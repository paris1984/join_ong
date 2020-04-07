package es.pjd.validator.stage.factory.administratorvolunteer;

import es.pjd.R;
import es.pjd.validator.stage.AdministratorVolunteerRegFormState;

public class PasswordConfFieldFormAdministratorVolunteer implements IPasswordConfStateFormAdministratorVolunteer {

    @Override
    public AdministratorVolunteerRegFormState getStatusIsNullOrEmpty() {
        return AdministratorVolunteerRegFormState.builder()
            .withNameError(null)
            .withSurnameError(null)
            .withNickError(null)
            .withEmailError(null)
            .withPasswordError(null)
            .withPasswordConfError(R.string.empty_password_conf)
            .withPhoneError(null).build();
    }

    @Override
    public AdministratorVolunteerRegFormState getStatusLengthMinNotValid() {
       return AdministratorVolunteerRegFormState.builder()
           .withNameError(null)
           .withSurnameError(null)
           .withNickError(null)
           .withEmailError(null)
           .withPasswordError(null)
           .withPasswordConfError(R.string.invalid_password)
           .withPhoneError(null).build();
    }

    @Override
    public AdministratorVolunteerRegFormState getStatusSameOtherField() {
        return AdministratorVolunteerRegFormState.builder()
            .withNameError(null)
            .withSurnameError(null)
            .withNickError(null)
            .withEmailError(null)
            .withPasswordError(null)
            .withPasswordConfError(R.string.invalid_password_password_conf)
            .withPhoneError(null).build();
    }
}
