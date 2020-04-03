package es.pjd.data.model;

import es.pjd.common.AbstractModelBeanTest;

public class OrganizationFormRegisterTest extends AbstractModelBeanTest<OrganizationFormRegister> {

    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String OTHER_EMAIL = "other_email";

    @Override
    public void initEntities() {
        entityA1 = OrganizationFormRegister.builder().withName(NAME).withDescription(DESCRIPTION)
                .withEmail(EMAIL).withPhone(PHONE).build();
        entityA2 = OrganizationFormRegister.builder().withName(NAME).withDescription(DESCRIPTION)
                .withEmail(EMAIL).withPhone(PHONE).build();
        entityB =OrganizationFormRegister.builder().withName(NAME).withDescription(DESCRIPTION)
                .withEmail(OTHER_EMAIL).withPhone(PHONE).build();
    }
}
