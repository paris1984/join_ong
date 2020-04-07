package es.pjd.validator.state.factory.administratorvolunteer;


import es.pjd.validator.state.AdministratorVolunteerRegFormState;

public class DataValidFieldFormAdministratorVolunteer implements IDataValidStateFormAdministratorVolunteer {
    @Override
    public AdministratorVolunteerRegFormState getStatusIsNullOrEmpty() {
        return AdministratorVolunteerRegFormState.builder()
            .withNameError(null)
            .withSurnameError(null)
            .withNickError(null)
            .withEmailError(null)
            .withPasswordError(null)
            .withPasswordConfError(null)
            .withPhoneError(null)
            .withIsDataValid(false).build();
    }

    @Override
    public AdministratorVolunteerRegFormState getStatusIsValid() {
        return AdministratorVolunteerRegFormState.builder()
            .withNameError(null)
            .withSurnameError(null)
            .withNickError(null)
            .withEmailError(null)
            .withPasswordError(null)
            .withPasswordConfError(null)
            .withPhoneError(null)
            .withIsDataValid(true).build();
    }
}
