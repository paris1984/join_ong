package es.pjd.model.organization;

import androidx.annotation.Nullable;

import java.util.Objects;

public class OrganizationRegFormState {
    @Nullable
    private Integer nameError;
    @Nullable
    private Integer descriptionError;
    @Nullable
    private Integer emailError;
    @Nullable
    private Integer phoneError;
    private boolean isDataValid;

    private OrganizationRegFormState() {
    }

    @Nullable
    public Integer getNameError() {
        return nameError;
    }

    public void setNameError(@Nullable Integer nameError) {
        this.nameError = nameError;
    }

    @Nullable
    public Integer getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(@Nullable Integer descriptionError) {
        this.descriptionError = descriptionError;
    }

    @Nullable
    public Integer getEmailError() {
        return emailError;
    }

    public void setEmailError(@Nullable Integer emailError) {
        this.emailError = emailError;
    }

    @Nullable
    public Integer getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(@Nullable Integer phoneError) {
        this.phoneError = phoneError;
    }

    public boolean isDataValid() {
        return isDataValid;
    }

    public void setIsDataValid(boolean isDataValid) {
        this.isDataValid = isDataValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationRegFormState that = (OrganizationRegFormState) o;
        return isDataValid == that.isDataValid &&
                nameError.equals(that.nameError) &&
                descriptionError.equals(that.descriptionError) &&
                emailError.equals(that.emailError) &&
                phoneError.equals(that.phoneError);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameError, descriptionError, emailError, phoneError, isDataValid);
    }

    public static OrganizationFormStateBuilder builder(){
        return new OrganizationFormStateBuilder();
    }

    public OrganizationFormStateBuilder cloneBuilder(){
        return new OrganizationFormStateBuilder()
                .withNameError(this.nameError)
                .withDescriptionError(this.descriptionError)
                .withEmailError(this.emailError)
                .withIsDataValid(this.isDataValid);
    }


    public interface IOrganizationFormStateBuilder{
        OrganizationRegFormState build();
    }

    public static class OrganizationFormStateBuilder implements IOrganizationFormStateBuilder {

        @Nullable
        private Integer nameError;
        @Nullable
        private Integer descriptionError;
        @Nullable
        private Integer emailError;
        @Nullable
        private Integer phoneError;
        private boolean isDataValid;

        public OrganizationFormStateBuilder(){
        }

        public OrganizationFormStateBuilder withNameError(@Nullable Integer nameError) {
            this.nameError = nameError;
            return this;
        }

        public OrganizationFormStateBuilder withDescriptionError(@Nullable Integer descriptionError) {
            this.descriptionError = descriptionError;
            return this;
        }

        public OrganizationFormStateBuilder withEmailError(@Nullable Integer emailError) {
            this.emailError = emailError;
            return this;
        }

        public OrganizationFormStateBuilder withPhoneError(@Nullable Integer phoneError) {
            this.phoneError = phoneError;
            return this;
        }

        public OrganizationFormStateBuilder withIsDataValid(boolean isDataValid) {
            this.isDataValid = isDataValid;
            return this;
        }

        @Override
        public OrganizationRegFormState build() {
            OrganizationRegFormState organizationRegFormState = new OrganizationRegFormState();
            organizationRegFormState.setNameError(this.nameError);
            organizationRegFormState.setDescriptionError(this.descriptionError);
            organizationRegFormState.setEmailError(this.emailError);
            organizationRegFormState.setPhoneError(this.phoneError);
            organizationRegFormState.setIsDataValid(this.isDataValid);
            return organizationRegFormState;
        }
    }
}
