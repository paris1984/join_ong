package es.pjd.model.organization;

import es.pjd.R;

public class EmailFieldFormOrganization implements IEmailStateFormOrganization {

    @Override
    public OrganizationRegFormState getStatusIsNullOrEmpty() {
        return OrganizationRegFormState.builder()
                .withNameError(null)
                .withDescriptionError(null).withEmailError(R.string.empty_email).withPhoneError(null).build();
    }

    @Override
    public OrganizationRegFormState getStatusPatternNotValid() {
        return   OrganizationRegFormState.builder()
                .withNameError(null)
                .withDescriptionError(null).withEmailError(R.string.invalid_username).withPhoneError(null).build();
    }
}
