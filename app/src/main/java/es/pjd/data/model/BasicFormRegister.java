package es.pjd.data.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import es.pjd.common.AbstractModelBean;

public abstract class BasicFormRegister extends AbstractModelBean {

    private String name;
    private String email;
    private String phone;

    protected BasicFormRegister(final BasicFormRegisterBuilder<?> builder ){
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
    }

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
        if(!(other instanceof BasicFormRegister)){
            return false;
        }
        final BasicFormRegister castOther = (BasicFormRegister) other;
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

    public abstract <T extends BasicFormRegisterBuilder> T cloneBuilder();

    public abstract static class BasicFormRegisterBuilder<T extends BasicFormRegisterBuilder<T>>{

        private String name;
        private String email;
        private String phone;

        public T withName(final String name){
            this.name = name;
            return  self();
        }

        public T withEmail(final String email){
            this.email = email;
            return self();
        }

        public T withPhone(final String phone){
            this.phone = phone;
            return  self();
        }

        public abstract BasicFormRegister build();

        protected abstract T self();
    }
}
