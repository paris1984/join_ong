package es.pjd.data.state.factory.organization;

import es.pjd.R;
import es.pjd.data.state.OrgRegFormState;

public class DescriptionFieldFormOrganization implements IStateFieldFormOrganization {

    @Override
    public OrgRegFormState getStatusIsNullOrEmpty() {
        return OrgRegFormState.builder()
                .withNameError(null)
                .withDescriptionError(R.string.empty_description).withEmailError(null).withPhoneError(null).build();
    }
}
