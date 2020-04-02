package es.pjd.model.administrator;

import androidx.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import es.pjd.model.BasicRegFormState;

public class AdministratorRegFormState extends BasicRegFormState {

    @Nullable
    private Integer surnameError;
    @Nullable
    private Integer nickError;
    @Nullable
    private Integer passwordError;
    @Nullable
    private Integer passwordConfError;

    private AdministratorRegFormState() {
    }

    @Nullable
    public Integer getSurnameError() {
        return surnameError;
    }

    @Nullable
    public Integer getNickError() {
        return nickError;
    }

    @Nullable
    public Integer getPasswordError() {
        return passwordError;
    }

    @Nullable
    public Integer getPasswordConfError() {
        return passwordConfError;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof AdministratorRegFormState)){
            return false;
        }
        final AdministratorRegFormState castOther = (AdministratorRegFormState) other;
        return new EqualsBuilder()
                .appendSuper(super.equals(other))
                .append(surnameError, castOther.surnameError)
                .append(nickError, castOther.nickError)
                .append(passwordError, castOther.passwordError)
                .append(passwordConfError, castOther.passwordConfError)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(surnameError)
                .append(nickError)
                .append(passwordError)
                .append(passwordConfError)
                .toHashCode();
    }

    public static AdministratorRegFormStateBuilder builder(){
        return new AdministratorRegFormStateBuilder();
    }

    public AdministratorRegFormStateBuilder cloneBuilder(){
        return new AdministratorRegFormStateBuilder()
                .withNameError(this.nameError)
                .withSurnameError(this.surnameError)
                .withNickError(this.nickError)
                .withEmailError(this.emailError)
                .withPasswordError(this.passwordError)
                .withPasswordConfError(this.passwordConfError)
                .withPhoneError(this.phoneError)
                .withIsDataValid(this.isDataValid);
    }

    public interface IAdministratorRegFormStateBuilder{
        AdministratorRegFormState build();
    }

    public static final class AdministratorRegFormStateBuilder extends BasicRegFormStateBuilder<AdministratorRegFormState,AdministratorRegFormStateBuilder>
            implements IAdministratorRegFormStateBuilder {

        @Override
        protected AdministratorRegFormState getObject() {
            return new AdministratorRegFormState();
        }

        @Override
        protected AdministratorRegFormStateBuilder thisObject() {
            return this;
        }

        public AdministratorRegFormStateBuilder(){
        }

        public AdministratorRegFormStateBuilder withSurnameError(@Nullable Integer surnameError) {
            object.surnameError = surnameError;
            return this;
        }

        public AdministratorRegFormStateBuilder withNickError(@Nullable Integer nickError) {
            object.nickError = nickError;
            return this;
        }

        public AdministratorRegFormStateBuilder withPasswordError(@Nullable Integer passwordError) {
            object.passwordError = passwordError;
            return this;
        }

        public AdministratorRegFormStateBuilder withPasswordConfError(@Nullable Integer passwordConfError) {
            object.passwordConfError = passwordConfError;
            return this;
        }

    }



}
