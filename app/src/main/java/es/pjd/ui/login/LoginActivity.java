package es.pjd.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

import es.pjd.activity.DispatcherActivity;
import es.pjd.activity.MenuActivity;
import es.pjd.R;


public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private FirebaseAuth mAuth;
    private ProgressBar loadingProgressBar;
    private EditText usernameEditText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);
        //inicializacion de objetos
        usernameEditText = findViewById(R.id.username);
        loadingProgressBar = findViewById(R.id.loading);
        mAuth = FirebaseAuth.getInstance();
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final TextView registerText = findViewById(R.id.register);
        final TextView forgetPasswordText = findViewById(R.id.forgetpassword);


        //

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DispatcherActivity.class);
                startActivity(intent);
            }
        });

        forgetPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                if(loginViewModel.isUserNameFill(username)) {
                    forgetPassword(username);
                }
            }
        });

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    loadingProgressBar.setVisibility(View.GONE);
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                login(usernameEditText.getText().toString(),passwordEditText.getText().toString());
            }
        });
    }

    private void login(String user, String password){
        mAuth.signInWithEmailAndPassword(user, password)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();
                    Intent intent = new Intent(getBaseContext(), MenuActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);

                }else{

                    setError(null,task.getException());
                }
            }
        });
    }

    private void forgetPassword(String userName){
        loadingProgressBar.setVisibility(View.VISIBLE);
        mAuth.sendPasswordResetEmail(usernameEditText.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                String message;
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), getString(R.string.forgetpassword_ok), Toast.LENGTH_LONG).show();
                }else{
                    setError(null,task.getException());
                }

            }
        });
    }

    private void setError(String message,Exception... exceptions){
        String error=null;
        if(message!=null){
            error = message;
        }else{
            try{
                FirebaseAuthException exception = (FirebaseAuthException)exceptions[0];
                switch (exception.getErrorCode()){
                    case "ERROR_INVALID_EMAIL":error = getString(R.string.invalid_username);break;
                    default:error = getString(R.string.error_dontexist_user);
                }
            }catch(Exception e){
                error = getString(R.string.login_failed);
            }
        }
        loadingProgressBar.setVisibility(View.GONE);
        usernameEditText.setError(error);
    }
}
