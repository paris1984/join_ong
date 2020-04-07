package es.pjd.validator.stage.factory.administratorvolunteer;


import es.pjd.validator.stage.AdministratorVolunteerRegFormState;

public interface IPasswordConfStateFormAdministratorVolunteer extends IPasswordStateFormAdministratorVolunteer{
    AdministratorVolunteerRegFormState getStatusSameOtherField();
}
