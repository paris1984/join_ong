package es.pjd.model.administrator;

import es.pjd.model.organization.IStateFieldFormOrganization;
import es.pjd.model.organization.OrgRegFormState;

public interface IDataValidStateFormAdministrator extends IStateFieldFromAdministrator{
    AdministratorRegFormState getStatusIsValid();
}
