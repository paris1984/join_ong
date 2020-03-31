package es.pjd.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseViewModel<Model> extends ViewModel {
    private FirebaseFirestore firebaseFirestore;

    protected abstract String getRootNode();
    protected abstract Model mapToModel(Map<String, Object> mapFromDB);

    public BaseViewModel(){
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    protected FirebaseFirestore getDB(){
        return firebaseFirestore;
    }

    protected void addNewModelMap(Map<String, Object> modelMap){

        firebaseFirestore.collection(getRootNode())
                .add(modelMap)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Info", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Error", "Error adding document", e);
                    }
                });
    }
}
