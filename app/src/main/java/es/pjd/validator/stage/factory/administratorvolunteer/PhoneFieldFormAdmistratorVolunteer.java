package es.pjd.validator.stage.factory.administratorvolunteer;

import es.pjd.R;
import es.pjd.validator.stage.AdministratorVolunteerRegFormState;

public class PhoneFieldFormAdmistratorVolunteer implements IPhoneStateFormAdministratorVolunteer {

    @Override
    public AdministratorVolunteerRegFormState getStatusIsNullOrEmpty() {
        return AdministratorVolunteerRegFormState.builder()
            .withNameError(null)
            .withSurnameError(null)
            .withNickError(null)
            .withEmailError(null)
            .withPasswordError(null)
            .withPasswordConfError(null)
            .withPhoneError(R.string.empty_phone).build();
    }

    @Override
    public AdministratorVolunteerRegFormState getStatusLengthNotValid() {
       return AdministratorVolunteerRegFormState.builder()
           .withNameError(null)
           .withSurnameError(null)
           .withNickError(null)
           .withEmailError(null)
           .withPasswordError(null)
           .withPasswordConfError(null)
           .withPhoneError(R.string.invalid_phone).build();
    }
}
