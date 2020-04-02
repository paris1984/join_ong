package es.pjd.model.administrator;

import es.pjd.R;
import es.pjd.model.organization.IPhoneStateFormOrganization;
import es.pjd.model.organization.OrgRegFormState;

public class PhoneFieldFormAdmistrator implements IPhoneStateFormAdministrator {

    @Override
    public AdministratorRegFormState getStatusIsNullOrEmpty() {
        return AdministratorRegFormState.builder()
            .withNameError(null)
            .withSurnameError(null)
            .withNickError(null)
            .withEmailError(null)
            .withPasswordError(null)
            .withPasswordConfError(null)
            .withPhoneError(R.string.empty_phone).build();
    }

    @Override
    public AdministratorRegFormState getStatusLengthNotValid() {
       return AdministratorRegFormState.builder()
           .withNameError(null)
           .withSurnameError(null)
           .withNickError(null)
           .withEmailError(null)
           .withPasswordError(null)
           .withPasswordConfError(null)
           .withPhoneError(R.string.invalid_phone).build();
    }
}
