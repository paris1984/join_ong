package es.pjd.data.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrganizationTest {

    public static final String NAME = "name1";
    public static final String DESCRIPTION = "description1";
    public static final String EMAIL = "email1";
    public static final String PHONE = "phone1";
    public static final String OTHER_EMAIL = "other_email";
    private Organization entityA1;
    private Organization entityA2;
    private Organization entityB;

    @Before
    public void init(){
        entityA1 = Organization.builder().withName(NAME).withDescription(DESCRIPTION).withEmail(EMAIL).withPhone(PHONE).build();
        entityA2 = Organization.builder().withName(NAME).withDescription(DESCRIPTION).withEmail(EMAIL).withPhone(PHONE).build();
        entityB = entityA1.cloneBuilder().withEmail(OTHER_EMAIL).build();
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
