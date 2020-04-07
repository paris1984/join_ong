package es.pjd.validator.state.factory.administratorvolunteer;


import es.pjd.validator.state.AdministratorVolunteerRegFormState;

public interface IPasswordConfStateFormAdministratorVolunteer extends IPasswordStateFormAdministratorVolunteer{
    AdministratorVolunteerRegFormState getStatusSameOtherField();
}
