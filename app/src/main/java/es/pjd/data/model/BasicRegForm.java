package es.pjd.data.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import es.pjd.common.AbstractModelBean;

public abstract class BasicRegForm extends AbstractModelBean {

    protected String name;
    protected String email;
    protected String phone;

    protected BasicRegForm(){}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof BasicRegForm)){
            return false;
        }
        final BasicRegForm castOther = (BasicRegForm) other;
        return new EqualsBuilder()
                .append(name, castOther.name)
                .append(email, castOther.email)
                .append(phone, castOther.phone).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(name)
                .append(email)
                .append(phone)
                .toHashCode();
    }

    public interface IBasicRegFormBuilder{
        BasicRegForm build();
    }

    protected abstract static class BasicRegFormBuilder<T extends BasicRegForm, B extends BasicRegFormBuilder<T, B>> implements IBasicRegFormBuilder{

        protected T object;
        protected B thisObject;

        protected abstract T getObject(); //Each concrete implementing subclass overrides this so that T becomes an object of the concrete subclass
        protected abstract B thisObject(); //Each concrete implementing subclass builder overrides this for the same reason, but for B for the builder

        protected BasicRegFormBuilder(){
            object = getObject();
            thisObject = thisObject();
        }

        public B withName(String name) {
            object.name = name;
            return thisObject;
        }

        public B withEmail(String email) {
            object.email = email;
            return thisObject;
        }

        public B withPhone(String phone) {
            object.phone = phone;
            return thisObject;
        }

        @Override
        public T build() {
            return object;
        }

    }


}
