package es.pjd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

        if(hasParametersActivity() && getIntent().getExtras().getBoolean("COMES_FROM_ORGANTIZATION")){
            Log.d("Info", "-------------------------------" + String.valueOf(getIntent().getExtras().getBoolean("COMES_FROM_ORGANTIZATION")));
        }

        final Button btnAccept = findViewById(R.id.volBtnAccept);

        btnAccept.setOnClickListener(new View.OnClickListener(){
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

    private boolean hasParametersActivity(){
        boolean result = false;
        Bundle getBundle = getIntent().getExtras();
        if(getBundle != null && !getBundle.isEmpty()){
            result= true;
        }
        return result;
    }
}
