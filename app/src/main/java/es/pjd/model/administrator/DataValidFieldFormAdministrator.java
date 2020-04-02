package es.pjd.model.administrator;

import es.pjd.R;
import es.pjd.model.organization.IDataValidStateFormOrganization;
import es.pjd.model.organization.OrgRegFormState;

public class DataValidFieldFormAdministrator implements IDataValidStateFormAdministrator {
    @Override
    public AdministratorRegFormState getStatusIsNullOrEmpty() {
        return AdministratorRegFormState.builder()
            .withNameError(null)
            .withSurnameError(null)
            .withNickError(null)
            .withEmailError(null)
            .withPasswordError(null)
            .withPasswordConfError(null)
            .withPhoneError(null)
            .withIsDataValid(false).build();
    }

    @Override
    public AdministratorRegFormState getStatusIsValid() {
        return AdministratorRegFormState.builder()
            .withNameError(null)
            .withSurnameError(null)
            .withNickError(null)
            .withEmailError(null)
            .withPasswordError(null)
            .withPasswordConfError(null)
            .withPhoneError(null)
            .withIsDataValid(true).build();
    }
}
