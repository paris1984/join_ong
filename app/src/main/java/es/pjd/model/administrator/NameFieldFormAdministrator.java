package es.pjd.model.administrator;

import es.pjd.R;

public class NameFieldFormAdministrator implements IStateFieldFromAdministrator {

    @Override
    public AdministratorRegFormState getStatusIsNullOrEmpty() {
            return AdministratorRegFormState.builder()
                .withNameError(R.string.empty_name)
                .withSurnameError(null)
                .withNickError(null)
                .withEmailError(null)
                .withPasswordError(null)
                .withPasswordConfError(null)
                .withPhoneError(null).build();
    }

}
