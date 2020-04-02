package es.pjd.model;

import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.common.base.Strings;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.Map;

import es.pjd.R;
import es.pjd.data.model.Organization;

public class OrganizationRegViewModel extends BaseViewModel<Organization>{

    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final int PHONE_SIZE = 9;
    public static final String FORMAT_EMAIL = "@";
    private MutableLiveData<OrganizationRegFormState> organizationFormState = new MutableLiveData<>();

    private MutableLiveData<List<Organization>> organizations;
    private FirebaseFirestore db;

    public OrganizationRegViewModel() {
        db = FirebaseFirestore.getInstance();
        organizations = new MutableLiveData<>();
    }

    public LiveData<OrganizationRegFormState> getOrganizationFormState() {
        return organizationFormState;
    }

    public void organizationDataChanged(String name, String description, String email, String phone) {
        if(!isValidField(name, NAME) || !isValidField(description, DESCRIPTION) || !isValidField(email, EMAIL) || !isValidField(phone, PHONE)) {
            organizationFormState.setValue(
                    OrganizationRegFormState.builder()
                            .withNameError(null)
                            .withDescriptionError(null).withEmailError(null).withPhoneError(null).withIsDataValid(false).build());
        }
        else{
            organizationFormState.setValue(
                    OrganizationRegFormState.builder()
                            .withNameError(null)
                            .withDescriptionError(null).withEmailError(null).withPhoneError(null).withIsDataValid(true).build());
        }
    }

    private boolean isValidField(String req, String nameField){
        Boolean valid = false;
        if(Strings.isNullOrEmpty(req.trim())){
            switch (nameField){
                case NAME:
                    organizationFormState.setValue(
                            OrganizationRegFormState.builder()
                                    .withNameError(R.string.empty_field)
                                    .withDescriptionError(null).withEmailError(null).withPhoneError(null).build());
                    break;
                case DESCRIPTION:
                    organizationFormState.setValue(
                            OrganizationRegFormState.builder()
                                    .withNameError(null)
                                    .withDescriptionError(R.string.empty_field).withEmailError(null).withPhoneError(null).build());
                    break;
                case EMAIL:
                    organizationFormState.setValue(
                            OrganizationRegFormState.builder()
                                    .withNameError(null)
                                    .withDescriptionError(null).withEmailError(R.string.empty_field).withPhoneError(null).build());
                    break;
                case PHONE:
                    organizationFormState.setValue(
                            OrganizationRegFormState.builder()
                                    .withNameError(null)
                                    .withDescriptionError(null).withEmailError(null).withPhoneError(R.string.empty_field).build());
                    break;
            }
        }
        else if(EMAIL.equals(nameField) && !isEmailValidPattern(req)){
            organizationFormState.setValue(
                    OrganizationRegFormState.builder()
                            .withNameError(null)
                            .withDescriptionError(null).withEmailError(R.string.invalid_username).withPhoneError(null).build());
        }
        else if(PHONE.equals(nameField) && !isPhoneSizeValid(req)){
            organizationFormState.setValue(
                    OrganizationRegFormState.builder()
                            .withNameError(null)
                            .withDescriptionError(null).withEmailError(null).withPhoneError(R.string.invalid_phone).build());
        }else{
            valid = true;
        }
        return valid;
    }

    private boolean isEmailValidPattern(String req) {
        if (req.contains(FORMAT_EMAIL)) {
            return Patterns.EMAIL_ADDRESS.matcher(req).matches();
        } else {
            return false;
        }
    }

    private boolean isPhoneSizeValid(String req) {
        return req != null && req.trim().length() == PHONE_SIZE;
    }

    @Override
    protected String getRootNode() {
        return null;
    }

    @Override
    protected MutableLiveData<List<Organization>> getModels() {
        return null;
    }

    @Override
    protected Organization mapToModel(Map mapFromDB) {
        return null;
    }
}
