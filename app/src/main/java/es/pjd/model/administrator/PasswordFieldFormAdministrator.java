package es.pjd.model.administrator;

import es.pjd.R;
import es.pjd.model.organization.IPhoneStateFormOrganization;
import es.pjd.model.organization.OrgRegFormState;

public class PasswordFieldFormAdministrator implements IPasswordStateFormAdministrator {

    @Override
    public AdministratorRegFormState getStatusIsNullOrEmpty() {
        return AdministratorRegFormState.builder()
            .withNameError(null)
            .withSurnameError(null)
            .withNickError(null)
            .withEmailError(null)
            .withPasswordError(R.string.empty_password)
            .withPasswordConfError(null)
            .withPhoneError(null).build();
    }

    @Override
    public AdministratorRegFormState getStatusLengthMinNotValid() {
       return AdministratorRegFormState.builder()
           .withNameError(null)
           .withSurnameError(null)
           .withNickError(null)
           .withEmailError(null)
           .withPasswordError(R.string.invalid_password)
           .withPasswordConfError(null)
           .withPhoneError(null).build();
    }
}
