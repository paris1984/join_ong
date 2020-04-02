package es.pjd.common;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertFalse;

public abstract class AbstractModelBeanTest<T extends AbstractModelBean> {

    protected T entityA1;
    protected T entityA2;
    protected T entityB;

    @Before
    public abstract void initEntities();

    @Test
    public void comparingTheSameEntitiesShouldBeTrue(){
        assertThat(entityA1, is(entityA2));
    }

    @Test
    public void comparingDifferentInstanceShouldBeFalse(){
        assertThat(entityA1, is(not(entityB)));
    }

    @Test
    public void comparingWithDifferentInstanceShouldBeFalse(){
        assertFalse(entityA1.equals(this));
    }

    @Test
    public void givenTheSameEntitiesShouldHaveIdenticalHasCode(){
        assertThat(entityA1.hashCode(), is(entityA2.hashCode()));
    }

    @Test
    public void givenDifferentEntitiesShouldHaveDifferentHasCode(){
        assertThat(entityA1.hashCode(), is(not(entityB.hashCode())));
    }

    @Test
    public void shouldImplementToStringMethod(){
        assertThat(entityA1.toString(), not(nullValue()));
        assertThat(entityA2.toString(),not(nullValue()));
        assertThat(entityB.toString(), not(nullValue()));
    }

}
