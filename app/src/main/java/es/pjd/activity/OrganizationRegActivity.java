package es.pjd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import es.pjd.R;

public class OrganizationRegActivity extends AppCompatActivity {

    public static final String COMES_FROM_ORGANIZATION = "comesFromOrgantization";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_reg);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        final EditText orgName = findViewById(R.id.orgName);
        final EditText orgDesc = findViewById(R.id.orgDesc);
        final EditText orgEmail = findViewById(R.id.orgEmail);
        final EditText orgTel = findViewById(R.id.orgTel);
        final Button btnNext = findViewById(R.id.orgBtnNext);

        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VolunteerRegActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean(COMES_FROM_ORGANIZATION, true);
                startActivity(intent.putExtras(bundle));
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
