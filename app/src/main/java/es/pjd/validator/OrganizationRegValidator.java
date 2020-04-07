package es.pjd.validator;

import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.common.base.Strings;

import java.util.List;
import java.util.Map;

import es.pjd.model.BaseViewModel;
import es.pjd.validator.data.same.FieldOrganization;
import es.pjd.validator.data.same.Organization;
import es.pjd.validator.state.factory.StateFiledFormOrganizationFactory;
import es.pjd.validator.state.OrgRegFormState;

public class OrganizationRegValidator extends BaseViewModel<Organization> {

    public static final int PHONE_SIZE = 9;
    public static final String FORMAT_EMAIL = "@";

    private MutableLiveData<OrgRegFormState> organizationFormState = new MutableLiveData<>();

    private MutableLiveData<List<Organization>> organizations;

    public OrganizationRegValidator() {
        organizations = new MutableLiveData<>();
    }

    public LiveData<OrgRegFormState> getOrganizationFormState() {
        return organizationFormState;
    }

    public void organizationDataChanged(String name, String description, String email, String phone) {
        if(!isValidField(name, FieldOrganization.NAME) || !isValidField(description, FieldOrganization.DESCRIPTION) || !isValidField(email, FieldOrganization.EMAIL) || !isValidField(phone, FieldOrganization.PHONE)) {
            organizationFormState.setValue(StateFiledFormOrganizationFactory.getStatusIsNullOrEmpty(FieldOrganization.NO_INFO).getStatusIsNullOrEmpty());
        }
        else{
            organizationFormState.setValue(StateFiledFormOrganizationFactory.getStatusDataValid().getStatusIsValid());
        }
    }

    private boolean isValidField(String req, FieldOrganization field){
        Boolean valid = false;
        if(Strings.isNullOrEmpty(req.trim())){
            organizationFormState.setValue(StateFiledFormOrganizationFactory.getStatusIsNullOrEmpty(field).getStatusIsNullOrEmpty());
        }
        else if(FieldOrganization.EMAIL.equals(field) && !isEmailValidPattern(req)){
            organizationFormState.setValue(StateFiledFormOrganizationFactory.getStatusPatternNotValid().getStatusPatternNotValid());
        }
        else if(FieldOrganization.PHONE.equals(field) && !isPhoneSizeValid(req)){
            organizationFormState.setValue(StateFiledFormOrganizationFactory.getStatusLengthNotValid().getStatusLengthNotValid());
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
