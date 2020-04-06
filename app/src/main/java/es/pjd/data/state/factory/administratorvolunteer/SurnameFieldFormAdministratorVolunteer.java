package es.pjd.data.state.factory.administratorvolunteer;

import es.pjd.R;
import es.pjd.data.state.AdministratorVolunteerRegFormState;

public class SurnameFieldFormAdministratorVolunteer implements IStateFieldFromAdministratorVolunteer {

    @Override
    public AdministratorVolunteerRegFormState getStatusIsNullOrEmpty() {
            return AdministratorVolunteerRegFormState.builder()
                .withNameError(null)
                .withSurnameError(R.string.empty_surname)
                .withNickError(null)
                .withEmailError(null)
                .withPasswordError(null)
                .withPasswordConfError(null)
                .withPhoneError(null).build();
    }

}
