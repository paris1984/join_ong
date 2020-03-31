package es.pjd.activity;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Objects;

import es.pjd.R;
import es.pjd.ui.login.LoginActivity;

public class VolunteerRegActivity extends AppCompatActivity {

    public static final String COMES_FROM_ORGANTIZATION = "comesFromOrgantization";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_reg);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        final CardView volCardView = findViewById(R.id.volCardView);
        final EditText volName = findViewById(R.id.volName);
        final EditText volSurname = findViewById(R.id.volSurname);
        final EditText volPassword = findViewById(R.id.volPassword);
        final EditText volConfPassword = findViewById(R.id.volConfPassword);
        final EditText volTel = findViewById(R.id.volTel);
        final EditText identOrg = findViewById(R.id.identOrg);
        final Button volBtnAccept = findViewById(R.id.volBtnAccept);

        final CardView adminCardView = findViewById(R.id.adminCardView);
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
            adminCardView.setVisibility(View.VISIBLE);
        }

        volBtnAccept.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
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
}
