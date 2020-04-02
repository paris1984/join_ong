package es.pjd.model.administrator;

import es.pjd.R;

public class SurnameFieldFormAdministrator implements IStateFieldFromAdministrator {

    @Override
    public AdministratorRegFormState getStatusIsNullOrEmpty() {
            return AdministratorRegFormState.builder()
                .withNameError(null)
                .withSurnameError(R.string.empty_surname)
                .withNickError(null)
                .withEmailError(null)
                .withPasswordError(null)
                .withPasswordConfError(null)
                .withPhoneError(null).build();
    }

}
