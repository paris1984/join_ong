package es.pjd.model.organization;

public class DataValidFieldFormOrganization implements IDataValidStateFormOrganization {
    @Override
    public OrganizationRegFormState getStatusIsNullOrEmpty() {
        return OrganizationRegFormState.builder()
                .withNameError(null)
                .withDescriptionError(null).withEmailError(null).withPhoneError(null).withIsDataValid(false).build();
    }

    @Override
    public OrganizationRegFormState getStatusIsValid() {
        return OrganizationRegFormState.builder()
                .withNameError(null)
                .withDescriptionError(null).withEmailError(null).withPhoneError(null).withIsDataValid(true).build();
    }
}
