package es.pjd.data.model;

import es.pjd.common.AbstractModelBeanTest;

public class OrganizationTest extends AbstractModelBeanTest<Organization> {

    public static final String NAME = "name1";
    public static final String DESCRIPTION = "description1";
    public static final String EMAIL = "email1";
    public static final String PHONE = "phone1";
    public static final String OTHER_EMAIL = "other_email";

    @Override
    public void initEntities() {
        entityA1 = Organization.builder().withName(NAME).withDescription(DESCRIPTION).withEmail(EMAIL).withPhone(PHONE).build();
        entityA2 = Organization.builder().withName(NAME).withDescription(DESCRIPTION).withEmail(EMAIL).withPhone(PHONE).build();
        entityB = entityA1.cloneBuilder().withEmail(OTHER_EMAIL).build();
    }
}
