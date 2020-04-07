package es.pjd.validator;

import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.common.base.Strings;

import java.util.List;
import java.util.Map;

import es.pjd.model.BaseViewModel;
import es.pjd.validator.data.same.AdministratorVolunteer;
import es.pjd.validator.data.same.FieldAdministratorVolunteer;
import es.pjd.validator.state.AdministratorVolunteerRegFormState;
import es.pjd.validator.state.factory.StateFiledFormAdministratorVolunteerFactory;

public class AdministratorVolunteerRegValidator extends BaseViewModel<AdministratorVolunteer> {

    public static final int PHONE_SIZE = 9;
    public static final int PASSWORD_LENGTH = 6;
    public static final String FORMAT_EMAIL = "@";

    private MutableLiveData<AdministratorVolunteerRegFormState> administratorVolunteerRegFormState = new MutableLiveData<>();
    private String valueFieldPassword;

    private MutableLiveData<List<AdministratorVolunteer>> administratorVolunteers;

    public AdministratorVolunteerRegValidator() {
        administratorVolunteers = new MutableLiveData<>();
    }

    public LiveData<AdministratorVolunteerRegFormState> getAdministratorVolunteerRegFormState() {
        return administratorVolunteerRegFormState;
    }

    public void administratorDataChanged(String name, String surname, String nick, String email, String password, String passwordConf ,String phone) {
        valueFieldPassword = password;
        if(!isValidField(name, FieldAdministratorVolunteer.NAME) || !isValidField(surname, FieldAdministratorVolunteer.SURNAME)
                || !isValidField(nick, FieldAdministratorVolunteer.NICK) || !isValidField(email, FieldAdministratorVolunteer.EMAIL)
                || !isValidField(password, FieldAdministratorVolunteer.PASSWORD)  || !isValidField(passwordConf, FieldAdministratorVolunteer.PASSWORD_CONF)
                || !isValidField(phone, FieldAdministratorVolunteer.PHONE)) {
            administratorVolunteerRegFormState.setValue(StateFiledFormAdministratorVolunteerFactory.getStatusIsNullOrEmpty(FieldAdministratorVolunteer.NO_INFO).getStatusIsNullOrEmpty());
        }
        else{
            administratorVolunteerRegFormState.setValue(StateFiledFormAdministratorVolunteerFactory.getStatusDataValid().getStatusIsValid());
        }
    }

    public void volunteerDataChanged(String name, String surname, String nick, String email, String password, String passwordConf ,String phone, String idOrganization) {
        valueFieldPassword = password;
        if(!isValidField(name, FieldAdministratorVolunteer.NAME) || !isValidField(surname, FieldAdministratorVolunteer.SURNAME)
                || !isValidField(nick, FieldAdministratorVolunteer.NICK) || !isValidField(email, FieldAdministratorVolunteer.EMAIL)
                || !isValidField(password, FieldAdministratorVolunteer.PASSWORD) || !isValidField(passwordConf, FieldAdministratorVolunteer.PASSWORD_CONF)
                || !isValidField(phone, FieldAdministratorVolunteer.PHONE) || !isValidField(idOrganization, FieldAdministratorVolunteer.ID_ORGANIZATION)) {
            administratorVolunteerRegFormState.setValue(StateFiledFormAdministratorVolunteerFactory.getStatusIsNullOrEmpty(FieldAdministratorVolunteer.NO_INFO).getStatusIsNullOrEmpty());
        }
        else{
            administratorVolunteerRegFormState.setValue(StateFiledFormAdministratorVolunteerFactory.getStatusDataValid().getStatusIsValid());
        }
    }

    private boolean isValidField(String req, FieldAdministratorVolunteer field){
        Boolean valid = false;
        if(Strings.isNullOrEmpty(req.trim())){
            administratorVolunteerRegFormState.setValue(StateFiledFormAdministratorVolunteerFactory.getStatusIsNullOrEmpty(field).getStatusIsNullOrEmpty());
        }
        else if(FieldAdministratorVolunteer.EMAIL.equals(field) && !isEmailValidPattern(req)){
            administratorVolunteerRegFormState.setValue(StateFiledFormAdministratorVolunteerFactory.getStatusPatternNotValid().getStatusPatternNotValid());
        }
        else if(FieldAdministratorVolunteer.PASSWORD.equals(field) && !isPasswordValidLength(req)){
            administratorVolunteerRegFormState.setValue(StateFiledFormAdministratorVolunteerFactory.getStatusLengthMinNotValid().getStatusLengthMinNotValid());
        }
        else if(FieldAdministratorVolunteer.PASSWORD_CONF.equals(field) && !isPasswordValidLength(req)){
            administratorVolunteerRegFormState.setValue(StateFiledFormAdministratorVolunteerFactory.getStatusConfLengthMinNotValid().getStatusLengthMinNotValid());
        }
        else if(FieldAdministratorVolunteer.PASSWORD_CONF.equals(field) && !isPasswordSamePasswordConf(req)){
            administratorVolunteerRegFormState.setValue(StateFiledFormAdministratorVolunteerFactory.getStatusSameOtherField().getStatusSameOtherField());
        }
        else if(FieldAdministratorVolunteer.PHONE.equals(field) && !isPhoneSizeValid(req)) {
            administratorVolunteerRegFormState.setValue(StateFiledFormAdministratorVolunteerFactory.getStatusLengthNotValid().getStatusLengthNotValid());
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
    protected MutableLiveData<List<AdministratorVolunteer>> getModels() {
        return null;
    }

    @Override
    protected AdministratorVolunteer mapToModel(Map mapFromDB) {
        return null;
    }
}
