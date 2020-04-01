package es.pjd.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

import es.pjd.R;
import es.pjd.model.UserViewModel;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText nombre;
        final EditText apellidos;
        final EditText telefono;
        final EditText email;
        final EditText password;
        final EditText repassword;
        final Button registrar;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //inicializacion de objetos
        registrar = findViewById(R.id.registrar);
        nombre = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellidos);
        telefono = findViewById(R.id.telefono);
        email = findViewById(R.id.email);
        password = findViewById(R.id.passwordR);
        repassword = findViewById(R.id.repasswordR); //TODO hacer comprobación de password.
        //

        //añadido de acciones a los objetos
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar(nombre.getText().toString(),
                        apellidos.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString(),
                        telefono.getText().toString(),
                        ""); //TODO añadir la vista para el nick y recuperarla.
            }
        });
        //
        mAuth = FirebaseAuth.getInstance();

        userViewModel = new UserViewModel();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    private void registrar(final String nombre, final String apellidos, final String email, String password, final String phone, final String nick){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = mAuth.getCurrentUser();
                            //userViewModel.addNewUser(nombre, apellidos, email, phone, nick );
                            userViewModel.setNewUserWithUid(nombre, apellidos, email, phone, nick );
                            //TODO abrir intent o esperar ver si no falla el registro?
                            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterActivity.this, "Register fail:"+task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
