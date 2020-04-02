package es.pjd.model.administrator;

import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.common.base.Strings;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.Map;

import es.pjd.data.model.FieldAdministrator;
import es.pjd.data.model.FieldOrganization;
import es.pjd.data.model.Organization;
import es.pjd.model.BaseViewModel;
import es.pjd.model.organization.OrgRegFormState;
import es.pjd.model.organization.OrganizationRegFormState;
import es.pjd.model.organization.StateFiledFormOrganizationFactory;

public class AdministratorRegViewModel extends BaseViewModel<Organization> {

    public static final int PHONE_SIZE = 9;
    public static final int PASSWORD_LENGTH = 6;
    public static final String FORMAT_EMAIL = "@";

    private MutableLiveData<AdministratorRegFormState> administratorFormState = new MutableLiveData<>();
    private String valueFieldPassword;

    private MutableLiveData<List<Organization>> organizations;
    private FirebaseFirestore db;

    public AdministratorRegViewModel() {
        db = FirebaseFirestore.getInstance();
        organizations = new MutableLiveData<>();
    }

    public LiveData<AdministratorRegFormState> getAdministratorRegFormState() {
        return administratorFormState;
    }

    public void administratorDataChanged(String name, String surname, String nick, String email, String password, String passwordConf ,String phone) {
        valueFieldPassword = password;
        if(!isValidField(name, FieldAdministrator.NAME) || !isValidField(surname, FieldAdministrator.SURNAME)  || !isValidField(nick, FieldAdministrator.NICK)
                || !isValidField(email, FieldAdministrator.EMAIL) || !isValidField(password, FieldAdministrator.PASSWORD)
                || !isValidField(passwordConf, FieldAdministrator.PASSWORD_CONF) || !isValidField(phone, FieldAdministrator.PHONE)) {
            administratorFormState.setValue(StateFiledFormAdministratorFactory.getStatusIsNullOrEmpty(FieldAdministrator.NO_INFO).getStatusIsNullOrEmpty());
        }
        else{
            administratorFormState.setValue(StateFiledFormAdministratorFactory.getStatusDataValid().getStatusIsValid());
        }
    }

    private boolean isValidField(String req, FieldAdministrator field){
        Boolean valid = false;
        if(Strings.isNullOrEmpty(req.trim())){
            administratorFormState.setValue(StateFiledFormAdministratorFactory.getStatusIsNullOrEmpty(field).getStatusIsNullOrEmpty());
        }
        else if(FieldAdministrator.EMAIL.equals(field) && !isEmailValidPattern(req)){
            administratorFormState.setValue(StateFiledFormAdministratorFactory.getStatusPatternNotValid().getStatusPatternNotValid());
        }
        else if(FieldAdministrator.PASSWORD.equals(field) && !isPasswordValidLength(req)){
            administratorFormState.setValue(StateFiledFormAdministratorFactory.getStatusLengthMinNotValid().getStatusLengthMinNotValid());
        }
        else if(FieldAdministrator.PASSWORD_CONF.equals(field) && !isPasswordValidLength(req)){
            administratorFormState.setValue(StateFiledFormAdministratorFactory.getStatusConfLengthMinNotValid().getStatusLengthMinNotValid());
        }
        else if(FieldAdministrator.PASSWORD_CONF.equals(field) && !isPasswordSamePasswordConf(req)){
            administratorFormState.setValue(StateFiledFormAdministratorFactory.getStatusSameOtherField().getStatusSameOtherField());
        }
        else if(FieldAdministrator.PHONE.equals(field) && !isPhoneSizeValid(req)){
            administratorFormState.setValue(StateFiledFormAdministratorFactory.getStatusLengthNotValid().getStatusLengthNotValid());
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

    private boolean isPasswordValidLength(String req) {
        return req != null && req.trim().length() >= PASSWORD_LENGTH;
    }

    private boolean isPasswordSamePasswordConf(String req) {
        return req != null && req.trim().equals(valueFieldPassword);
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
