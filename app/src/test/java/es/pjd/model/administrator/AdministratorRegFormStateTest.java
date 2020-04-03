package es.pjd.model.administrator;

import es.pjd.common.AbstractModelBeanTest;

public class AdministratorRegFormStateTest extends AbstractModelBeanTest<AdministratorRegFormState> {

    public static final Integer NAME_ERROR = 1;
    public static final Integer SURNAME_ERROR = 1;
    public static final Integer NICK_ERROR = 1;
    public static final Integer EMAIL_ERROR = 1;
    public static final Integer PASSWORD_ERROR = 1;
    public static final Integer PASSWORD_CONF_ERROR = 1;
    public static final Integer PHONE_ERROR = 1;
    public static final boolean IS_DATA_VALID_FALSE = false;

    @Override
    public void initEntities() {
        entityA1 = AdministratorRegFormState.builder()
                .withNameError(NAME_ERROR)
                .withSurnameError(SURNAME_ERROR)
                .withNickError(NICK_ERROR)
                .withEmailError(EMAIL_ERROR)
                .withPasswordError(PASSWORD_ERROR)
                .withPasswordConfError(PASSWORD_CONF_ERROR)
                .withPhoneError(PHONE_ERROR)
                .withIsDataValid(IS_DATA_VALID_FALSE).build();
        entityA2 =  AdministratorRegFormState.builder()
                .withNameError(NAME_ERROR)
                .withSurnameError(SURNAME_ERROR)
                .withNickError(NICK_ERROR)
                .withEmailError(EMAIL_ERROR)
                .withPasswordError(PASSWORD_ERROR)
                .withPasswordConfError(PASSWORD_CONF_ERROR)
                .withPhoneError(PHONE_ERROR)
                .withIsDataValid(IS_DATA_VALID_FALSE).build();
        entityB = entityA2.cloneBuilder().withIsDataValid(true).build();
    }

}
