package es.pjd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import es.pjd.R;

public class OrganizationRegActivity extends AppCompatActivity {

    public static final String COMES_FROM_ORGANTIZATION = "comesFromOrgantization";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_reg);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        final Button btnNext = findViewById(R.id.orgBtnNext);

        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VolunteerRegActivity.class);
                Bundle bundleOrganizationReg = new Bundle();
                bundleOrganizationReg.putBoolean(COMES_FROM_ORGANTIZATION, true);
                intent.putExtras(bundleOrganizationReg);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
