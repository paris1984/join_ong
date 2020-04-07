package es.pjd.validator.state.factory.administratorvolunteer;


import es.pjd.validator.state.AdministratorVolunteerRegFormState;

public interface IDataValidStateFormAdministratorVolunteer extends IStateFieldFromAdministratorVolunteer{
    AdministratorVolunteerRegFormState getStatusIsValid();
}
