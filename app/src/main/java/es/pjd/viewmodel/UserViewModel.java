package es.pjd.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.pjd.data.model.User;

public class UserViewModel extends ViewModel {


    private MutableLiveData<List<User>> users;

    private FirebaseFirestore db;

    public UserViewModel(){
        db = FirebaseFirestore.getInstance();
    }

    public LiveData<List<User>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<>();
            loadUsers();
        }
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
                        Log.d("INfo", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Error", "Error adding document", e);
                    }
                });
    }

    private void loadUsers() {

    }
}
