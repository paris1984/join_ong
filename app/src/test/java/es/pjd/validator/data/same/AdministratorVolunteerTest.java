package es.pjd.validator.data.same;

import es.pjd.common.AbstractModelBeanTest;
import es.pjd.validator.data.same.AdministratorVolunteer;

public class AdministratorVolunteerTest extends AbstractModelBeanTest<AdministratorVolunteer> {

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
        entityA1 = AdministratorVolunteer.builder().withName(NAME).withSurname(SURNAME).withNick(NICK)
                .withEmail(EMAIL).withPassword(PASSWORD).withPhone(PHONE).withIdOrganization(ID_ORGANIZATION).build();
        entityA2 = AdministratorVolunteer.builder().withName(NAME).withSurname(SURNAME)
                .withNick(NICK).withEmail(EMAIL).withPassword(PASSWORD).withPhone(PHONE).withIdOrganization(ID_ORGANIZATION).build();
        entityB = AdministratorVolunteer.builder().withName(NAME).withSurname(SURNAME)
                .withNick(NICK).withEmail(OTHER_EMAIL).withPassword(PASSWORD).withPhone(PHONE).withIdOrganization(ID_ORGANIZATION).build();
    }
}
