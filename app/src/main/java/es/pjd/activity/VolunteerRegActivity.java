package es.pjd.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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
import es.pjd.viewmodel.UserViewModel;

public class VolunteerRegActivity extends AppCompatActivity {

    public static final String COMES_FROM_ORGANTIZATION = "comesFromOrgantization";
    private FirebaseAuth mAuth;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_reg);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();
        userViewModel = new UserViewModel();

        final CardView volCardView = findViewById(R.id.volCardView);
        final EditText volName = findViewById(R.id.volName);
        final EditText volSurname = findViewById(R.id.volSurname);
        final EditText volNick = findViewById(R.id.volNick);
        final EditText volEmail = findViewById(R.id.volEmail);
        final EditText volPassword = findViewById(R.id.volPassword);
        final EditText volConfPassword = findViewById(R.id.volConfPassword);
        final EditText volTel = findViewById(R.id.volTel);
        final EditText identOrg = findViewById(R.id.identOrg);
        final Button volBtnAccept = findViewById(R.id.volBtnAccept);

        final CardView admCardView = findViewById(R.id.admCardView);
        final EditText admName = findViewById(R.id.admName);
        final EditText admSurname = findViewById(R.id.admSurname);
        final EditText admNick = findViewById(R.id.admNick);
        final EditText admEmail = findViewById(R.id.admEmail);
        final EditText admPassword = findViewById(R.id.admPassword);
        final EditText admConfPassword = findViewById(R.id.admConfPassword);
        final EditText admTel = findViewById(R.id.admTel);
        final Button admBtnAccept = findViewById(R.id.admBtnAccept);


        if(hasParametersInActivity() && getIntent().getExtras().getBoolean(COMES_FROM_ORGANTIZATION)){
            setTitle(getString(R.string.title_activity_administrator_reg));
            volCardView.setVisibility(View.GONE);
            admCardView.setVisibility(View.VISIBLE);
        }

        volBtnAccept.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                registerVolunteer(volName.getText().toString(),
                        volSurname.getText().toString(),
                        volEmail.getText().toString(),
                        volPassword.getText().toString(),
                        volTel.getText().toString(),
                        volNick.getText().toString(),
                        identOrg.getText().toString());
            }
        });

        admBtnAccept.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                registerAdmin(volName.getText().toString(),
                        volSurname.getText().toString(),
                        volEmail.getText().toString(),
                        volPassword.getText().toString(),
                        volTel.getText().toString(),
                        volNick.getText().toString());
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    private boolean hasParametersInActivity(){
        boolean result = false;
        Bundle getBundle = getIntent().getExtras();
        if(getBundle != null && !getBundle.isEmpty()){
            result= true;
        }
        return result;
    }

    private void registerVolunteer(final String nameVol, final String surNameVol, final String emailVol, String passwordVol, final String nickVol, final String telVol, final String identOrg){
        mAuth.createUserWithEmailAndPassword(emailVol, passwordVol)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        FirebaseUser user = mAuth.getCurrentUser();
                        //userViewModel.addNewUser(nombre, apellidos, email, phone, nick );
                        userViewModel.setNewUserWithUid(nameVol, surNameVol, emailVol, telVol, nickVol );
                        //TODO abrir intent o esperar ver si no falla el registro?
                        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(intent);
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(VolunteerRegActivity.this, "Register fail:"+task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }

    private void registerAdmin(final String nameAdmin, final String surNameAdmin, final String emailAdmin, String passwordAdmin, final String nickAdmin, final String telAdmin){
        mAuth.createUserWithEmailAndPassword(emailAdmin, passwordAdmin)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        FirebaseUser user = mAuth.getCurrentUser();
                        //userViewModel.addNewUser(nombre, apellidos, email, phone, nick );
                        userViewModel.setNewUserWithUid(nameAdmin, surNameAdmin, emailAdmin, telAdmin, nickAdmin );
                        //TODO abrir intent o esperar ver si no falla el registro?
                        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(intent);
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(VolunteerRegActivity.this, "Register fail:"+task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }
}
