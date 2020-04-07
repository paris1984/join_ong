package es.pjd.validator.stage.factory.administratorvolunteer;

import es.pjd.R;
import es.pjd.validator.stage.AdministratorVolunteerRegFormState;

public class EmailFieldFormAdministratorVolunteer implements IEmailStateFormAdministratorVolunteer {

    @Override
    public AdministratorVolunteerRegFormState getStatusIsNullOrEmpty() {
        return AdministratorVolunteerRegFormState.builder()
                .withNameError(null)
                .withSurnameError(null)
                .withNickError(null)
                .withEmailError(R.string.empty_email)
                .withPasswordError(null)
                .withPasswordConfError(null)
                .withPhoneError(null).build();
    }

    @Override
    public AdministratorVolunteerRegFormState getStatusPatternNotValid() {
        return   AdministratorVolunteerRegFormState.builder()
                .withNameError(null)
                .withSurnameError(null)
                .withNickError(null)
                .withEmailError(R.string.invalid_username)
                .withPasswordError(null)
                .withPasswordConfError(null)
                .withPhoneError(null).build();
    }
}
