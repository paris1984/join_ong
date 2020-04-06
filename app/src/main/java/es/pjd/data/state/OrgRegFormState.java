package es.pjd.data.state;

import androidx.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class OrgRegFormState extends BasicRegFormState {

    @Nullable
    private Integer descriptionError;

    private OrgRegFormState() {
    }

    @Nullable
    public Integer getDescriptionError() {
        return descriptionError;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof OrgRegFormState)){
            return false;
        }
        final OrgRegFormState castOther = (OrgRegFormState) other;
        return new EqualsBuilder()
                .appendSuper(super.equals(other))
                .append(descriptionError, castOther.descriptionError).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(descriptionError).toHashCode();
    }

    public static OrgRegFormStateBuilder builder(){
        return new OrgRegFormStateBuilder();
    }

    public OrgRegFormStateBuilder cloneBuilder(){
        return new OrgRegFormStateBuilder()
                .withNameError(this.nameError)
                .withDescriptionError(this.descriptionError)
                .withEmailError(this.emailError)
                .withIsDataValid(this.isDataValid);
    }


    public interface IOrgRegFormStateBuilder{
        OrgRegFormState build();
    }

    public static final class OrgRegFormStateBuilder extends BasicRegFormStateBuilder<OrgRegFormState,OrgRegFormStateBuilder> implements IOrgRegFormStateBuilder {

        @Override
        protected OrgRegFormState getObject() {
            return new OrgRegFormState();
        }

        @Override
        protected OrgRegFormStateBuilder thisObject() {
            return this;
        }

        public OrgRegFormStateBuilder(){
        }

        public OrgRegFormStateBuilder withDescriptionError(@Nullable Integer descriptionError) {
            object.descriptionError = descriptionError;
            return this;
        }
    }
}
