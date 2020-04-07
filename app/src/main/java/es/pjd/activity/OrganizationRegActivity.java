package es.pjd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.Objects;

import es.pjd.R;
import es.pjd.validator.stage.OrgRegFormState;
import es.pjd.validator.OrganizationRegValidator;

public class OrganizationRegActivity extends AppCompatActivity {

    public static final String COMES_FROM_ORGANIZATION = "comesFromOrgantization";
    public static final String NAME_ORG = "nameOrgantization";
    public static final String DESC_ORG = "descriptionOrgantization";
    public static final String EMAIL_ORG = "emailOrgantization";
    public static final String PHONE_ORG = "phoneOrgantization";
    private OrganizationRegValidator organizationRegValidator;
    private ProgressBar loadingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_reg);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        organizationRegValidator = ViewModelProviders.of(this).get(OrganizationRegValidator.class);

        loadingProgressBar = findViewById(R.id.loading);
        final EditText orgName = findViewById(R.id.orgName);
        final EditText orgDesc = findViewById(R.id.orgDesc);
        final EditText orgEmail = findViewById(R.id.orgEmail);
        final EditText orgPhone = findViewById(R.id.orgTel);
        final Button btnNext = findViewById(R.id.orgBtnNext);

        organizationRegValidator.getOrganizationFormState().observe(this, new Observer<OrgRegFormState>() {
            @Override
            public void onChanged(@Nullable OrgRegFormState organizationRegFormState) {
                if (organizationRegFormState == null) {
                    return;
                }
                btnNext.setEnabled(organizationRegFormState.isDataValid());
                if(organizationRegFormState.getNameError() != null){
                    orgName.setError(getString(organizationRegFormState.getNameError()));
                }
                if(organizationRegFormState.getDescriptionError() != null){
                    orgDesc.setError(getString(organizationRegFormState.getDescriptionError()));
                }
                if(organizationRegFormState.getEmailError() != null){
                    orgEmail.setError(getString(organizationRegFormState.getEmailError()));
                }
                if(organizationRegFormState.getPhoneError() != null){
                    orgPhone.setError(getString(organizationRegFormState.getPhoneError()));
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
                organizationRegValidator.organizationDataChanged(orgName.getText().toString(), orgDesc.getText().toString(), orgEmail.getText().toString(), orgPhone.getText().toString());
            }
        };

        orgName.addTextChangedListener(afterTextChangedListener);
        orgDesc.addTextChangedListener(afterTextChangedListener);
        orgEmail.addTextChangedListener(afterTextChangedListener);
        orgPhone.addTextChangedListener(afterTextChangedListener);

        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(getApplicationContext(), VolunteerRegActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean(COMES_FROM_ORGANIZATION, true);
                bundle.putString(NAME_ORG, orgName.getText().toString().trim());
                bundle.putString(DESC_ORG, orgDesc.getText().toString().trim());
                bundle.putString(EMAIL_ORG, orgEmail.getText().toString().trim());
                bundle.putString(PHONE_ORG, orgPhone.getText().toString().trim());
                startActivity(intent.putExtras(bundle));
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        loadingProgressBar.setVisibility(View.GONE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

}
