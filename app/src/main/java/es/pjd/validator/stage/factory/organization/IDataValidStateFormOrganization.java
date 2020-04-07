package es.pjd.validator.stage.factory.organization;

import es.pjd.validator.stage.OrgRegFormState;

public interface IDataValidStateFormOrganization extends IStateFieldFormOrganization{

    OrgRegFormState getStatusIsValid();
}
