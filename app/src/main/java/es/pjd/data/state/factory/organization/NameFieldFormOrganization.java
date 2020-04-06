package es.pjd.data.state.factory.organization;

import es.pjd.R;
import es.pjd.data.state.OrgRegFormState;

public class NameFieldFormOrganization implements IStateFieldFormOrganization {

    @Override
    public OrgRegFormState getStatusIsNullOrEmpty() {
            return OrgRegFormState.builder()
                .withNameError(R.string.empty_name)
                .withDescriptionError(null).withEmailError(null).withPhoneError(null).build();
    }

}
