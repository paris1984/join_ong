package es.pjd.model.organization;

import es.pjd.R;

public class PhoneFieldFormOrganization implements IPhoneStateFormOrganization {

    @Override
    public OrganizationRegFormState getStatusIsNullOrEmpty() {
        return OrganizationRegFormState.builder()
            .withNameError(null)
            .withDescriptionError(null).withEmailError(null).withPhoneError(R.string.empty_phone).build();
    }

    @Override
    public OrganizationRegFormState getStatusLengthNotValid() {
       return OrganizationRegFormState.builder()
            .withNameError(null)
            .withDescriptionError(null).withEmailError(null).withPhoneError(R.string.invalid_phone).build();
    }
}
