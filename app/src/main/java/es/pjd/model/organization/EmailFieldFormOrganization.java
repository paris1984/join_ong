package es.pjd.model.organization;

import es.pjd.R;

public class EmailFieldFormOrganization implements IEmailStateFormOrganization {

    @Override
    public OrgRegFormState getStatusIsNullOrEmpty() {
        return OrgRegFormState.builder()
                .withNameError(null)
                .withDescriptionError(null).withEmailError(R.string.empty_email).withPhoneError(null).build();
    }

    @Override
    public OrgRegFormState getStatusPatternNotValid() {
        return   OrgRegFormState.builder()
                .withNameError(null)
                .withDescriptionError(null).withEmailError(R.string.invalid_username).withPhoneError(null).build();
    }
}
