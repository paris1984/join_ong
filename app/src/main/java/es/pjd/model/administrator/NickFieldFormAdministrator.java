package es.pjd.model.administrator;

import es.pjd.R;

public class NickFieldFormAdministrator implements IStateFieldFromAdministrator {

    @Override
    public AdministratorRegFormState getStatusIsNullOrEmpty() {
            return AdministratorRegFormState.builder()
                .withNameError(null)
                .withSurnameError(null)
                .withNickError(R.string.empty_nick)
                .withEmailError(null)
                .withPasswordError(null)
                .withPasswordConfError(null)
                .withPhoneError(null).build();
    }

}
