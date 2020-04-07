package es.pjd.validator.stage.factory.organization;

import es.pjd.R;
import es.pjd.validator.stage.OrgRegFormState;

public class DescriptionFieldFormOrganization implements IStateFieldFormOrganization {

    @Override
    public OrgRegFormState getStatusIsNullOrEmpty() {
        return OrgRegFormState.builder()
                .withNameError(null)
                .withDescriptionError(R.string.empty_description).withEmailError(null).withPhoneError(null).build();
    }
}
