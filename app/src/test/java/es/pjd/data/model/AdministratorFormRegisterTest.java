package es.pjd.data.model;

import es.pjd.common.AbstractModelBeanTest;

public class AdministratorFormRegisterTest extends AbstractModelBeanTest<AdministratorFormRegister> {

    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String NICK = "nick";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String PHONE = "phone";
    public static final String OTHER_EMAIL = "other_email";

    @Override
    public void initEntities() {
        entityA1 = AdministratorFormRegister.builder().withName(NAME).withSurname(SURNAME).withNick(NICK)
                .withEmail(EMAIL).withPassword(PASSWORD).withPhone(PHONE).build();
        entityA2 = AdministratorFormRegister.builder().withName(NAME).withSurname(SURNAME)
                .withNick(NICK).withEmail(EMAIL).withPassword(PASSWORD).withPhone(PHONE).build();
        entityB = AdministratorFormRegister.builder().withName(NAME).withSurname(SURNAME)
                .withNick(NICK).withEmail(OTHER_EMAIL).withPassword(PASSWORD).withPhone(PHONE).build();
    }
}
