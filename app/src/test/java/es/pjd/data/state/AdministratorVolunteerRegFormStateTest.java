package es.pjd.data.state;

import es.pjd.common.AbstractModelBeanTest;
import es.pjd.validator.stage.AdministratorVolunteerRegFormState;


public class AdministratorVolunteerRegFormStateTest extends AbstractModelBeanTest<AdministratorVolunteerRegFormState> {

    private static final Integer NAME_ERROR = 1;
    private static final Integer SURNAME_ERROR = 1;
    private static final Integer NICK_ERROR = 1;
    private static final Integer EMAIL_ERROR = 1;
    private static final Integer PASSWORD_ERROR = 1;
    private static final Integer PASSWORD_CONF_ERROR = 1;
    private static final Integer PHONE_ERROR = 1;
    private static final Integer ID_ORGANIZATION_ERROR = 1;
    private static final boolean IS_DATA_VALID_TRUE = true;
    private static final boolean IS_DATA_VALID_FALSE = false;

    @Override
    public void initEntities() {
        entityA1 = AdministratorVolunteerRegFormState.builder()
                .withNameError(NAME_ERROR).withSurnameError(SURNAME_ERROR)
                .withNickError(NICK_ERROR).withEmailError(EMAIL_ERROR)
                .withPasswordError(PASSWORD_ERROR).withPasswordConfError(PASSWORD_CONF_ERROR)
                .withPhoneError(PHONE_ERROR).withIdOrganizationError(ID_ORGANIZATION_ERROR).withIsDataValid(IS_DATA_VALID_TRUE).build();
        entityA2 = AdministratorVolunteerRegFormState.builder()
                .withNameError(NAME_ERROR).withSurnameError(SURNAME_ERROR)
                .withNickError(NICK_ERROR).withEmailError(EMAIL_ERROR)
                .withPasswordError(PASSWORD_ERROR).withPasswordConfError(PASSWORD_CONF_ERROR)
                .withPhoneError(PHONE_ERROR).withIdOrganizationError(ID_ORGANIZATION_ERROR).withIsDataValid(IS_DATA_VALID_TRUE).build();
        entityB = AdministratorVolunteerRegFormState.builder()
                .withNameError(NAME_ERROR).withSurnameError(SURNAME_ERROR)
                .withNickError(NICK_ERROR).withEmailError(EMAIL_ERROR)
                .withPasswordError(PASSWORD_ERROR).withPasswordConfError(PASSWORD_CONF_ERROR)
                .withPhoneError(PHONE_ERROR).withIdOrganizationError(ID_ORGANIZATION_ERROR).withIsDataValid(IS_DATA_VALID_FALSE).build();
    }
}