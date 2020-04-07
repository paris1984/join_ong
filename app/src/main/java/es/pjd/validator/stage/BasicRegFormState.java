package es.pjd.validator.stage;

import androidx.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import es.pjd.common.AbstractModelBean;

public abstract class BasicRegFormState extends AbstractModelBean {

    @Nullable
    protected Integer nameError;
    @Nullable
    protected Integer emailError;
    @Nullable
    protected Integer phoneError;
    protected boolean isDataValid;

    protected BasicRegFormState(){
    }

    @Nullable
    public Integer getNameError() {
        return nameError;
    }

    @Nullable
    public Integer getEmailError() {
        return emailError;
    }

    @Nullable
    public Integer getPhoneError() {
        return phoneError;
    }

    public boolean isDataValid() {
        return isDataValid;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof BasicRegFormState)){
            return false;
        }
        final BasicRegFormState castOther = (BasicRegFormState) other;
        return new EqualsBuilder()
                .append(nameError, castOther.nameError)
                .append(emailError, castOther.emailError)
                .append(phoneError, castOther.phoneError)
                .append(isDataValid, castOther.isDataValid).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(nameError)
                .append(emailError)
                .append(phoneError)
                .append(isDataValid)
                .toHashCode();
    }



    public interface IBasicRegFormStateBuilder{
        BasicRegFormState build();
    }

    protected abstract static class BasicRegFormStateBuilder<T extends BasicRegFormState, B extends BasicRegFormStateBuilder<T,B>> implements IBasicRegFormStateBuilder{

        protected T object;
        protected B thisObject;

        protected abstract T getObject(); //Each concrete implementing subclass overrides this so that T becomes an object of the concrete subclass
        protected abstract B thisObject(); //Each concrete implementing subclass builder overrides this for the same reason, but for B for the builder

        protected BasicRegFormStateBuilder() {
            object = getObject();
            thisObject = thisObject();
        }

        public B withNameError(@Nullable Integer nameError) {
            object.nameError = nameError;
            return thisObject;
        }

        public B withEmailError(@Nullable Integer emailError) {
            object.emailError = emailError;
            return thisObject();
        }

        public B withPhoneError(@Nullable Integer phoneError) {
            object.phoneError = phoneError;
            return thisObject;
        }

        public B withIsDataValid(@Nullable boolean isDataValid) {
            object.isDataValid = isDataValid;
            return thisObject;
        }

        @Override
        public T build() {
            return object;
        }
    }

}
