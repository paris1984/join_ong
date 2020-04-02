package es.pjd.model.organization;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class OrganizationRegFormStateTest {

    public static final Integer NAME_ERROR = 1;
    public static final Integer DESCRIPTION_ERROR = 1;
    public static final Integer EMAIL_ERROR = 1;
    public static final Integer PHONE_ERROR = 1;
    public static final boolean IS_DATA_VALID_FALSE = false;
    public static final boolean IS_DATA_VALID_TRUE = true;

    private OrganizationRegFormState entityA1;
    private OrganizationRegFormState entityA2;
    private OrganizationRegFormState entityB;

    @Before
    public void init(){
        entityA1 = OrganizationRegFormState.builder()
                .withNameError(NAME_ERROR)
                .withDescriptionError(DESCRIPTION_ERROR)
                .withEmailError(EMAIL_ERROR)
                .withPhoneError(PHONE_ERROR)
                .withIsDataValid(IS_DATA_VALID_FALSE).build();
        entityA2 =  OrganizationRegFormState.builder()
                .withNameError(NAME_ERROR)
                .withDescriptionError(DESCRIPTION_ERROR)
                .withEmailError(EMAIL_ERROR)
                .withPhoneError(PHONE_ERROR)
                .withIsDataValid(IS_DATA_VALID_FALSE).build();
        entityB = OrganizationRegFormState.builder()
                .withNameError(NAME_ERROR)
                .withDescriptionError(DESCRIPTION_ERROR)
                .withEmailError(EMAIL_ERROR)
                .withPhoneError(PHONE_ERROR)
                .withIsDataValid(IS_DATA_VALID_TRUE).build();
    }

    @Test
    public void comparingTheSameEntitiesShouldBeTrue(){
        assertEquals(entityA1, entityA2);
    }

    @Test
    public void comparingDifferentInstanceShouldBeFalse(){
        assertNotEquals(entityA1, entityB);
    }

    @Test
    public void comparingWithDifferentInstanceShouldBeFalse(){
        assertNotEquals(entityA1, this);
    }

    @Test
    public void givenTheSameEntitiesShouldHaveIdenticalHasCode(){
        assertEquals(entityA1.hashCode(), entityA2.hashCode());
    }

    @Test
    public void givenDifferentEntitiesShouldHaveDifferentHasCode(){
        assertNotEquals(entityA1.hashCode(), entityB.hashCode());
    }

    @Test
    public void shouldImplementToStringMethod(){
        assertNotNull(entityA1.toString());
        assertNotNull(entityA2.toString());
        assertNotNull(entityB.toString());
    }

}
