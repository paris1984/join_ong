package es.pjd.data.state.factory.administratorvolunteer;


import es.pjd.data.state.AdministratorVolunteerRegFormState;

public interface IDataValidStateFormAdministratorVolunteer extends IStateFieldFromAdministratorVolunteer{
    AdministratorVolunteerRegFormState getStatusIsValid();
}
