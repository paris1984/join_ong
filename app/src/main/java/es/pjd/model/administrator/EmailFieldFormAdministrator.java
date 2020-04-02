package es.pjd.model.administrator;

import es.pjd.R;
import es.pjd.model.organization.IEmailStateFormOrganization;
import es.pjd.model.organization.OrgRegFormState;

public class EmailFieldFormAdministrator implements IEmailStateFormAdministrator {

    @Override
    public AdministratorRegFormState getStatusIsNullOrEmpty() {
        return AdministratorRegFormState.builder()
                .withNameError(null)
                .withSurnameError(null)
                .withNickError(null)
                .withEmailError(R.string.empty_email)
                .withPasswordError(null)
                .withPasswordConfError(null)
                .withPhoneError(null).build();
    }

    @Override
    public AdministratorRegFormState getStatusPatternNotValid() {
        return   AdministratorRegFormState.builder()
                .withNameError(null)
                .withSurnameError(null)
                .withNickError(null)
                .withEmailError(R.string.invalid_username)
                .withPasswordError(null)
                .withPasswordConfError(null)
                .withPhoneError(null).build();
    }
}
