package es.pjd.data.model;

import es.pjd.common.AbstractModelBeanTest;

public class OrganizationTest extends AbstractModelBeanTest<Organization> {

    private static final String NAME = "name1";
    private static final String DESCRIPTION = "description1";
    private static final String EMAIL = "email1";
    private static final String PHONE = "phone1";
    private static final String OTHER_EMAIL = "other_email";

    @Override
    public void initEntities() {
        entityA1 = Organization.builder().withName(NAME).withDescription(DESCRIPTION).withEmail(EMAIL).withPhone(PHONE).build();
        entityA2 = Organization.builder().withName(NAME).withDescription(DESCRIPTION).withEmail(EMAIL).withPhone(PHONE).build();
        entityB = Organization.builder().withName(NAME).withDescription(DESCRIPTION).withEmail(OTHER_EMAIL).withPhone(PHONE).build();
    }
}
