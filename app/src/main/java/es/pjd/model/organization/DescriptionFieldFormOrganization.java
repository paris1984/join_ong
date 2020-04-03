package es.pjd.model.organization;

import es.pjd.R;

public class DescriptionFieldFormOrganization implements IStateFieldFormOrganization {

    @Override
    public OrgRegFormState getStatusIsNullOrEmpty() {
        return OrgRegFormState.builder()
                .withNameError(null)
                .withDescriptionError(R.string.empty_description).withEmailError(null).withPhoneError(null).build();
    }
}
