package es.pjd.model.administrator;

import es.pjd.R;

public class PasswordConfFieldFormAdministrator implements IPasswordConfStateFormAdministrator {

    @Override
    public AdministratorRegFormState getStatusIsNullOrEmpty() {
        return AdministratorRegFormState.builder()
            .withNameError(null)
            .withSurnameError(null)
            .withNickError(null)
            .withEmailError(null)
            .withPasswordError(null)
            .withPasswordConfError(R.string.empty_password_conf)
            .withPhoneError(null).build();
    }

    @Override
    public AdministratorRegFormState getStatusLengthMinNotValid() {
       return AdministratorRegFormState.builder()
           .withNameError(null)
           .withSurnameError(null)
           .withNickError(null)
           .withEmailError(null)
           .withPasswordError(null)
           .withPasswordConfError(R.string.invalid_password)
           .withPhoneError(null).build();
    }

    @Override
    public AdministratorRegFormState getStatusSameOtherField() {
        return AdministratorRegFormState.builder()
            .withNameError(null)
            .withSurnameError(null)
            .withNickError(null)
            .withEmailError(null)
            .withPasswordError(null)
            .withPasswordConfError(R.string.invalid_password_password_conf)
            .withPhoneError(null).build();
    }
}
