package es.pjd.data.model;

import es.pjd.common.AbstractModelBeanTest;

public class VolunteerFormRegisterTest extends AbstractModelBeanTest<VolunteerFormRegister> {

    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String NICK = "nick";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String PHONE = "phone";
    private static final String ID_ORGANIZATION = "id_organization";
    private static final String OTHER_EMAIL = "other_email";

    @Override
    public void initEntities() {
        entityA1 = VolunteerFormRegister.builder().withName(NAME).withSurname(SURNAME).withNick(NICK)
                .withEmail(EMAIL).withPassword(PASSWORD).withPhone(PHONE).withIdOrganization(ID_ORGANIZATION).build();
        entityA2 = VolunteerFormRegister.builder().withName(NAME).withSurname(SURNAME)
                .withNick(NICK).withEmail(EMAIL).withPassword(PASSWORD).withPhone(PHONE).withIdOrganization(ID_ORGANIZATION).build();
        entityB = VolunteerFormRegister.builder().withName(NAME).withSurname(SURNAME)
                .withNick(NICK).withEmail(OTHER_EMAIL).withPassword(PASSWORD).withPhone(PHONE).withIdOrganization(ID_ORGANIZATION).build();
    }
}
