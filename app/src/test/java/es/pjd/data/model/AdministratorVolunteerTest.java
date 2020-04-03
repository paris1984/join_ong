package es.pjd.data.model;

import es.pjd.common.AbstractModelBeanTest;

public class AdministratorVolunteerTest extends AbstractModelBeanTest<AdministratorVolunteer> {

    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String NICK = "nick";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String PHONE = "phone";
    public static final String ID_ORGANIZATION = "id_organization";
    public static final String OTHER_EMAIL = "other_email";

    @Override
    public void initEntities() {
        entityA1 = AdministratorVolunteer.builder().withName(NAME).withSurname(SURNAME).withNick(NICK)
                .withEmail(EMAIL).withPassword(PASSWORD).withPhone(PHONE).withIdOrganization(ID_ORGANIZATION).build();
        entityA2 = AdministratorVolunteer.builder().withName(NAME).withSurname(SURNAME)
                .withNick(NICK).withEmail(EMAIL).withPassword(PASSWORD).withPhone(PHONE).withIdOrganization(ID_ORGANIZATION).build();
        entityB = AdministratorVolunteer.builder().withName(NAME).withSurname(SURNAME)
                .withNick(NICK).withEmail(OTHER_EMAIL).withPassword(PASSWORD).withPhone(PHONE).withIdOrganization(ID_ORGANIZATION).build();
    }
}
