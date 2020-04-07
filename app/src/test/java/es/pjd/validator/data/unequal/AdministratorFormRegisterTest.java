package es.pjd.validator.data.unequal;

import es.pjd.common.AbstractModelBeanTest;
import es.pjd.validator.data.unequal.AdministratorFormRegister;

public class AdministratorFormRegisterTest extends AbstractModelBeanTest<AdministratorFormRegister> {

    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String NICK = "nick";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String PHONE = "phone";
    private static final String OTHER_EMAIL = "other_email";

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
