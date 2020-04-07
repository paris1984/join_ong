package es.pjd.validator.stage;

import androidx.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AdministratorVolunteerRegFormState extends BasicRegFormState {

    @Nullable
    private Integer surnameError;
    @Nullable
    private Integer nickError;
    @Nullable
    private Integer passwordError;
    @Nullable
    private Integer passwordConfError;
    @Nullable
    private Integer idOrganizationError;

    private AdministratorVolunteerRegFormState() {
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

    @Nullable
    public Integer getIdOrganizationError() {
        return idOrganizationError;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof AdministratorVolunteerRegFormState)){
            return false;
        }
        final AdministratorVolunteerRegFormState castOther = (AdministratorVolunteerRegFormState) other;
        return new EqualsBuilder()
                .appendSuper(super.equals(other))
                .append(surnameError, castOther.surnameError)
                .append(nickError, castOther.nickError)
                .append(passwordError, castOther.passwordError)
                .append(passwordConfError, castOther.passwordConfError)
                .append(idOrganizationError, castOther.idOrganizationError)
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
                .append(idOrganizationError)
                .toHashCode();
    }

    public static AdministratorVolunteerRegFormStateBuilder builder(){
        return new AdministratorVolunteerRegFormStateBuilder();
    }

    public AdministratorVolunteerRegFormStateBuilder cloneBuilder(){
        return new AdministratorVolunteerRegFormStateBuilder()
                .withNameError(this.nameError)
                .withSurnameError(this.surnameError)
                .withNickError(this.nickError)
                .withEmailError(this.emailError)
                .withPasswordError(this.passwordError)
                .withPasswordConfError(this.passwordConfError)
                .withPhoneError(this.phoneError)
                .withIdOrganizationError(this.idOrganizationError)
                .withIsDataValid(this.isDataValid);
    }

    public interface IAdministratorVolunteerRegFormStateBuilder{
        AdministratorVolunteerRegFormState build();
    }

    public static final class AdministratorVolunteerRegFormStateBuilder extends BasicRegFormStateBuilder<AdministratorVolunteerRegFormState,AdministratorVolunteerRegFormStateBuilder>
            implements IAdministratorVolunteerRegFormStateBuilder {

        @Override
        protected AdministratorVolunteerRegFormState getObject() {
            return new AdministratorVolunteerRegFormState();
        }

        @Override
        protected AdministratorVolunteerRegFormStateBuilder thisObject() {
            return this;
        }

        public AdministratorVolunteerRegFormStateBuilder(){
        }

        public AdministratorVolunteerRegFormStateBuilder withSurnameError(@Nullable Integer surnameError) {
            object.surnameError = surnameError;
            return thisObject();
        }

        public AdministratorVolunteerRegFormStateBuilder withNickError(@Nullable Integer nickError) {
            object.nickError = nickError;
            return thisObject();
        }

        public AdministratorVolunteerRegFormStateBuilder withPasswordError(@Nullable Integer passwordError) {
            object.passwordError = passwordError;
            return thisObject();
        }

        public AdministratorVolunteerRegFormStateBuilder withPasswordConfError(@Nullable Integer passwordConfError) {
            object.passwordConfError = passwordConfError;
            return thisObject();
        }

        public AdministratorVolunteerRegFormStateBuilder withIdOrganizationError(@Nullable Integer idOrganizationError) {
            object.idOrganizationError = idOrganizationError;
            return thisObject();
        }

    }



}
