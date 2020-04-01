package es.pjd.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.pjd.data.model.User;

import static androidx.constraintlayout.widget.Constraints.TAG;

public abstract class BaseViewModel<Model> extends ViewModel {
    private FirebaseFirestore firebaseFirestore;

    protected abstract String getRootNode();
    protected abstract Model mapToModel(Map<String, Object> mapFromDB);
    protected abstract MutableLiveData<List<Model>> getModels();

    public BaseViewModel(){
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    protected FirebaseFirestore getDB(){
        return firebaseFirestore;
    }

    protected void setNewModelMap(Map<String, Object> modelMap, String id){
        firebaseFirestore.collection(getRootNode())
                .document(id)
                .set(modelMap)
                .addOnCompleteListener(getOnCompleteListenerForSave(id));
    }

    public void readCompleteCollection() {
        firebaseFirestore.collection(getRootNode())
                .get()
                .addOnCompleteListener(getOnCompleteListenerForRead());
    }

    public void readModelById(String id){

        DocumentReference docRef = firebaseFirestore.collection(getRootNode()).document(id);
        docRef.get().addOnCompleteListener(getOnCompleteListenerForReadById());
    }

    protected OnCompleteListener getOnCompleteListenerForSave(String id){
        return new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d("Info", "Document added in " + getRootNode() +" with ID: " + id);
                }
                else{
                    Log.w("Error", "Error adding document in "+ getRootNode() +" with ID: " + id);
                }
            }
        };
    }

    protected OnCompleteListener getOnCompleteListenerForReadById(){
        return new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());
                        getModels().setValue(Arrays.asList(mapToModel(document.getData())));
                    } else {
                        Log.d(TAG, "Error getting documents.", task.getException());
                    }
                } else {
                    Log.w(TAG, "Error getting documents.", task.getException());
                }
            }
        };
    }

    protected OnCompleteListener getOnCompleteListenerForRead(){
        return new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());
                        getModels().setValue(Arrays.asList(mapToModel(document.getData())));
                    }
                } else {
                    Log.w(TAG, "Error getting documents.", task.getException());
                }
            }
        };
    }
}
