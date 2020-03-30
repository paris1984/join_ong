package es.pjd.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import es.pjd.data.model.User;

public class UserViewModel extends ViewModel {


    private MutableLiveData<List<User>> users;
    private DatabaseReference mDatabase;

    public UserViewModel(){
        mDatabase = FirebaseDatabase.getInstance().getReference("users");
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
        User user = new User(auth.getUid(), name, surname, nick, phone, email);
        mDatabase.setValue(user);
    }

    private void loadUsers() {

    }
}
