package es.pjd.validator.stage.factory.administratorvolunteer;

import es.pjd.R;
import es.pjd.validator.stage.AdministratorVolunteerRegFormState;

public class NickFieldFormAdministratorVolunteer implements IStateFieldFromAdministratorVolunteer {

    @Override
    public AdministratorVolunteerRegFormState getStatusIsNullOrEmpty() {
            return AdministratorVolunteerRegFormState.builder()
                .withNameError(null)
                .withSurnameError(null)
                .withNickError(R.string.empty_nick)
                .withEmailError(null)
                .withPasswordError(null)
                .withPasswordConfError(null)
                .withPhoneError(null).build();
    }

}
