package es.pjd.data;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import es.pjd.data.model.LoggedInUser;

import java.io.IOException;
import java.util.concurrent.Executor;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    private FirebaseAuth mAuth;
    private LoggedInUser userLogged;
    private Activity activity;

    public Result<LoggedInUser> login(String username, String password, Activity parent) {
        activity = parent;
        mAuth = FirebaseAuth.getInstance();
        try {
            // TODO: handle loggedInUser authentication
           logar(username,password);
            return new Result.Success<>(userLogged);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }

    private void logar(String username, String password){



        mAuth.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information

                        FirebaseUser user = mAuth.getCurrentUser();
                        userLogged = new LoggedInUser(user.getUid(),user.getDisplayName());
                    } else {
                        // If sign in fails, display a message to the user.
                        new RuntimeException("Error al logarse");
                    }
                }
            });
    }
}
