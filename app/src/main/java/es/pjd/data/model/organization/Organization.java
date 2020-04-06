package es.pjd.data.model.organization;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import es.pjd.data.model.BasicRegForm;


public class Organization extends BasicRegForm {

    protected String description;

    private Organization(){
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Organization)){
            return false;
        }
        final Organization castOther = (Organization) other;
        return new EqualsBuilder()
                .appendSuper(super.equals(other))
                .append(description, castOther.description).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(description).toHashCode();
    }

    public static OrganizationBuilder builder(){
        return new OrganizationBuilder();
    }

    @Override
    public OrganizationBuilder cloneBuilder(){
        return new OrganizationBuilder()
                .withName(this.name)
                .withDescription(this.description)
                .withEmail(this.email)
                .withPhone(this.phone);
    }

    public interface IOrganizationBuilder{
        Organization build();
    }

    public static class OrganizationBuilder extends BasicRegFormBuilder<Organization,OrganizationBuilder> implements IOrganizationBuilder{

        @Override
        protected Organization getObject() {
            return new Organization();
        }

        @Override
        protected OrganizationBuilder thisObject() {
            return this;
        }

        public OrganizationBuilder() {}


        public OrganizationBuilder withDescription(String description){
            object.description = description;
            return this;
        }
    }

}
