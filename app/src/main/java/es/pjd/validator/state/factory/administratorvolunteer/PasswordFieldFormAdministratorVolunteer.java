package es.pjd.validator.state.factory.administratorvolunteer;

import es.pjd.R;
import es.pjd.validator.state.AdministratorVolunteerRegFormState;

public class PasswordFieldFormAdministratorVolunteer implements IPasswordStateFormAdministratorVolunteer {

    @Override
    public AdministratorVolunteerRegFormState getStatusIsNullOrEmpty() {
        return AdministratorVolunteerRegFormState.builder()
            .withNameError(null)
            .withSurnameError(null)
            .withNickError(null)
            .withEmailError(null)
            .withPasswordError(R.string.empty_password)
            .withPasswordConfError(null)
            .withPhoneError(null).build();
    }

    @Override
    public AdministratorVolunteerRegFormState getStatusLengthMinNotValid() {
       return AdministratorVolunteerRegFormState.builder()
           .withNameError(null)
           .withSurnameError(null)
           .withNickError(null)
           .withEmailError(null)
           .withPasswordError(R.string.invalid_password)
           .withPasswordConfError(null)
           .withPhoneError(null).build();
    }
}
