package es.pjd.model.organization;

public class DataValidFieldFormOrganization implements IDataValidStateFormOrganization {
    @Override
    public OrgRegFormState getStatusIsNullOrEmpty() {
        return OrgRegFormState.builder()
                .withNameError(null)
                .withDescriptionError(null).withEmailError(null).withPhoneError(null).withIsDataValid(false).build();
    }

    @Override
    public OrgRegFormState getStatusIsValid() {
        return OrgRegFormState.builder()
                .withNameError(null)
                .withDescriptionError(null).withEmailError(null).withPhoneError(null).withIsDataValid(true).build();
    }
}
