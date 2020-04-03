package es.pjd.data.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class OrganizationFormRegister extends BasicFormRegister {

    private final String description;

    protected OrganizationFormRegister(OrganizationFormRegisterBuilder builder) {
        super(builder);
        this.description = builder.description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof OrganizationFormRegister)){
            return false;
        }
        final OrganizationFormRegister castOther = (OrganizationFormRegister) other;
        return new EqualsBuilder()
                .appendSuper(super.equals(other))
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .toHashCode();
    }

    public static OrganizationFormRegisterBuilder builder(){
        return new OrganizationFormRegisterBuilder();
    }

    public OrganizationFormRegisterBuilder cloneBuilder(){
        return new OrganizationFormRegisterBuilder()
                .withName(this.getName())
                .withDescription(this.getDescription())
                .withEmail(this.getEmail())
                .withPhone(this.getPhone());
    }

    public static class OrganizationFormRegisterBuilder extends BasicFormRegisterBuilder<OrganizationFormRegisterBuilder>{

        private String description;

        public OrganizationFormRegisterBuilder withDescription(final String description){
            this.description = description;
            return self();
        }

        @Override
        public OrganizationFormRegister build() {
            return new OrganizationFormRegister(this);
        }

        @Override
        protected OrganizationFormRegisterBuilder self() {
            return this;
        }
    }

}
