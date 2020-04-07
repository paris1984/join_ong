package es.pjd.validator.state.factory.administratorvolunteer;

import es.pjd.R;
import es.pjd.validator.state.AdministratorVolunteerRegFormState;

public class NameFieldFormAdministratorVolunteer implements IStateFieldFromAdministratorVolunteer {

    @Override
    public AdministratorVolunteerRegFormState getStatusIsNullOrEmpty() {
            return AdministratorVolunteerRegFormState.builder()
                .withNameError(R.string.empty_name)
                .withSurnameError(null)
                .withNickError(null)
                .withEmailError(null)
                .withPasswordError(null)
                .withPasswordConfError(null)
                .withPhoneError(null).build();
    }

}
