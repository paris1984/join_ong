package es.pjd.model.organization;

import es.pjd.R;

public class NameFieldFormOrganization implements IStateFieldFormOrganization {

    @Override
    public OrganizationRegFormState getStatusIsNullOrEmpty() {
            return OrganizationRegFormState.builder()
                .withNameError(R.string.empty_name)
                .withDescriptionError(null).withEmailError(null).withPhoneError(null).build();
    }

}
