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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.pjd.data.model.User;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class UserViewModel extends ViewModel {
    private MutableLiveData<List<User>> users;
    private FirebaseFirestore db;

    public UserViewModel(){
        db = FirebaseFirestore.getInstance();
        users = new MutableLiveData<>();
    }

    public LiveData<List<User>> getUserByUid(String uid){

        db.collection("users").whereEqualTo("uid", uid)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                    users.setValue(Arrays.asList(mapToUser(document.getData())));

                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

        return users;
    }


    public void writeNewUser(String name, String surname, String email, String phone, String nick){
        FirebaseAuth auth = FirebaseAuth.getInstance();

        Map<String, Object> user = new HashMap<>();
        user.put("name",name);
        user.put("surname",surname);
        user.put("email", email);
        user.put("phone", phone);
        user.put("nick", nick);
        user.put("uid", auth.getUid());
        db.collection("users")
                .add(user)
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

    public LiveData<List<User>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {

    }

    private User mapToUser(Map<String, Object> mapFromDB){
        return new User(
                mapFromDB.get("uid").toString(),
                mapFromDB.get("name").toString(),
                mapFromDB.get("surname").toString(),
                mapFromDB.get("nick").toString(),
                mapFromDB.get("phone").toString(),
                mapFromDB.get("email").toString());
    }
}
