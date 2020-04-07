package es.pjd.data.state;


import es.pjd.common.AbstractModelBeanTest;
import es.pjd.validator.state.OrgRegFormState;

public class OrgRegFormStateTest extends AbstractModelBeanTest<OrgRegFormState> {

    public static final Integer NAME_ERROR = 1;
    public static final Integer DESCRIPTION_ERROR = 1;
    public static final Integer EMAIL_ERROR = 1;
    public static final Integer PHONE_ERROR = 1;
    public static final boolean IS_DATA_VALID_FALSE = false;
    public static final boolean IS_DATA_VALID_TRUE = true;

    @Override
    public void initEntities() {
        entityA1 = OrgRegFormState.builder().withNameError(NAME_ERROR)
                .withDescriptionError(DESCRIPTION_ERROR)
                .withEmailError(EMAIL_ERROR)
                .withPhoneError(PHONE_ERROR)
                .withIsDataValid(IS_DATA_VALID_FALSE)
                .build();
        entityA2 = OrgRegFormState.builder().withNameError(NAME_ERROR)
                .withDescriptionError(DESCRIPTION_ERROR)
                .withEmailError(EMAIL_ERROR)
                .withPhoneError(PHONE_ERROR)
                .withIsDataValid(IS_DATA_VALID_FALSE)
                .build();
        entityB = OrgRegFormState.builder().withNameError(NAME_ERROR)
                .withDescriptionError(DESCRIPTION_ERROR)
                .withEmailError(EMAIL_ERROR)
                .withPhoneError(PHONE_ERROR)
                .withIsDataValid(IS_DATA_VALID_TRUE)
                .build();
    }

}
