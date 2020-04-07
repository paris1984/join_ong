package es.pjd.validator.data.unequal;

import es.pjd.common.AbstractModelBeanTest;
import es.pjd.validator.data.unequal.OrganizationFormRegister;

public class OrganizationFormRegisterTest extends AbstractModelBeanTest<OrganizationFormRegister> {

    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String OTHER_EMAIL = "other_email";

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
