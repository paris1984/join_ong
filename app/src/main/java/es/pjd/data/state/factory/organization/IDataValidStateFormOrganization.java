package es.pjd.data.state.factory.organization;

import es.pjd.data.state.OrgRegFormState;

public interface IDataValidStateFormOrganization extends IStateFieldFormOrganization{

    OrgRegFormState getStatusIsValid();
}
