package es.pjd.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

import es.pjd.R;
import es.pjd.model.UserViewModel;
import es.pjd.model.administrator.AdministratorRegFormState;
import es.pjd.model.administrator.AdministratorRegViewModel;

public class VolunteerRegActivity extends AppCompatActivity {

    public static final String COMES_FROM_ORGANIZATION = "comesFromOrgantization";
    public static final String NAME_ORG = "nameOrgantization";
    public static final String DESC_ORG = "descriptionOrgantization";
    public static final String EMAIL_ORG = "emailOrgantization";
    public static final String PHONE_ORG = "emailOrgantization";

    private FirebaseAuth mAuth;
    private UserViewModel userViewModel;
    private AdministratorRegViewModel administratorRegViewModel;
    private ProgressBar loadingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_reg);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();
        userViewModel = new UserViewModel();

        loadingProgressBar = findViewById(R.id.loading);
        final CardView volCardView = findViewById(R.id.volCardView);
        final CardView admCardView = findViewById(R.id.admCardView);

        if(hasParametersInActivity() && getIntent().getExtras().getBoolean(COMES_FROM_ORGANIZATION)){
            final EditText admName = findViewById(R.id.admName);
            final EditText admSurname = findViewById(R.id.admSurname);
            final EditText admNick = findViewById(R.id.admNick);
            final EditText admEmail = findViewById(R.id.admEmail);
            final EditText admPassword = findViewById(R.id.admPassword);
            final EditText admConfPassword = findViewById(R.id.admConfPassword);
            final EditText admPhone = findViewById(R.id.admTel);
            final Button admBtnAccept = findViewById(R.id.admBtnAccept);

            setTitle(getString(R.string.title_activity_administrator_reg));
            volCardView.setVisibility(View.GONE);
            admCardView.setVisibility(View.VISIBLE);

            administratorRegViewModel = ViewModelProviders.of(this).get(AdministratorRegViewModel.class);
            administratorRegViewModel.getAdministratorRegFormState().observe(this, new Observer<AdministratorRegFormState>() {
                @Override
                public void onChanged(@Nullable AdministratorRegFormState administratorRegFormState) {
                    if (administratorRegFormState == null) {
                        return;
                    }
                    admBtnAccept.setEnabled(administratorRegFormState.isDataValid());
                    if(administratorRegFormState.getNameError() != null){
                        admName.setError(getString(administratorRegFormState.getNameError()));
                    }
                    if(administratorRegFormState.getSurnameError() != null){
                        admSurname.setError(getString(administratorRegFormState.getSurnameError()));
                    }
                    if(administratorRegFormState.getNickError() != null){
                        admNick.setError(getString(administratorRegFormState.getNickError()));
                    }
                    if(administratorRegFormState.getEmailError() != null){
                        admEmail.setError(getString(administratorRegFormState.getEmailError()));
                    }
                    if(administratorRegFormState.getPasswordError() != null){
                        admPassword.setError(getString(administratorRegFormState.getPasswordError()));
                    }
                    if(administratorRegFormState.getPasswordConfError() != null){
                        admConfPassword.setError(getString(administratorRegFormState.getPasswordConfError()));
                    }
                    if(administratorRegFormState.getPhoneError() != null){
                        admPhone.setError(getString(administratorRegFormState.getPhoneError()));
                    }
                    loadingProgressBar.setVisibility(View.GONE);
                }
            });

            TextWatcher afterTextChangedListener = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    administratorRegViewModel.administratorDataChanged(admName.getText().toString(), admSurname.getText().toString(),
                            admNick.getText().toString(), admEmail.getText().toString(),
                            admPassword.getText().toString(), admConfPassword.getText().toString(),
                            admPhone.getText().toString());
                }
            };

            admName.addTextChangedListener(afterTextChangedListener);
            admSurname.addTextChangedListener(afterTextChangedListener);
            admNick.addTextChangedListener(afterTextChangedListener);
            admEmail.addTextChangedListener(afterTextChangedListener);
            admPassword.addTextChangedListener(afterTextChangedListener);
            admConfPassword.addTextChangedListener(afterTextChangedListener);
            admConfPassword.addTextChangedListener(afterTextChangedListener);
            admPhone.addTextChangedListener(afterTextChangedListener);

            admBtnAccept.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    Log.d("Guadado Org", "nombre: " + getIntent().getExtras().getString(NAME_ORG).trim() +
                            " descripcion: " +  getIntent().getExtras().getString(DESC_ORG).trim() +
                            " email: " +  getIntent().getExtras().getString(EMAIL_ORG).trim() +
                            " telefono: " +  getIntent().getExtras().getString(PHONE_ORG).trim());

                    Log.d("Guadado Admin", "nombre: " + admName.getText().toString().trim() +
                            " surname: " + admSurname.getText().toString().trim() +
                            " email: " + admEmail.getText().toString().trim() +
                            " password: " +  admPassword.getText().toString().trim() +
                            " phone: " + admPhone.getText().toString().trim() +
                            " nick: " + admNick.getText().toString().trim());

                    /*
                    registerAdmin(admName.getText().toString(),
                        admSurname.getText().toString(),
                        admEmail.getText().toString(),
                        admPassword.getText().toString(),
                        admPhone.getText().toString(),
                        admNick.getText().toString());

                     */
                }
            });

        }
        else {
            final EditText volName = findViewById(R.id.volName);
            final EditText volSurname = findViewById(R.id.volSurname);
            final EditText volNick = findViewById(R.id.volNick);
            final EditText volEmail = findViewById(R.id.volEmail);
            final EditText volPassword = findViewById(R.id.volPassword);
            final EditText volConfPassword = findViewById(R.id.volConfPassword);
            final EditText volPhone = findViewById(R.id.volTel);
            final EditText identOrg = findViewById(R.id.identOrg);
            final Button volBtnAccept = findViewById(R.id.volBtnAccept);

            volBtnAccept.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    registerVolunteer(volName.getText().toString(),
                            volSurname.getText().toString(),
                            volEmail.getText().toString(),
                            volPassword.getText().toString(),
                            volPhone.getText().toString(),
                            volNick.getText().toString(),
                            identOrg.getText().toString());
                }
            });

        }
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
