package es.pjd.validator.state.factory.organization;

import es.pjd.R;
import es.pjd.validator.state.OrgRegFormState;

public class PhoneFieldFormOrganization implements IPhoneStateFormOrganization {

    @Override
    public OrgRegFormState getStatusIsNullOrEmpty() {
        return OrgRegFormState.builder()
            .withNameError(null)
            .withDescriptionError(null).withEmailError(null).withPhoneError(R.string.empty_phone).build();
    }

    @Override
    public OrgRegFormState getStatusLengthNotValid() {
       return OrgRegFormState.builder()
            .withNameError(null)
            .withDescriptionError(null).withEmailError(null).withPhoneError(R.string.invalid_phone).build();
    }
}
