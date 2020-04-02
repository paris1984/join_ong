package es.pjd.model.organization;

import es.pjd.R;

public class DescriptionFieldFormOrganization implements IStateFieldFormOrganization {

    @Override
    public OrganizationRegFormState getStatusIsNullOrEmpty() {
        return OrganizationRegFormState.builder()
                .withNameError(null)
                .withDescriptionError(R.string.empty_description).withEmailError(null).withPhoneError(null).build();
    }
}
