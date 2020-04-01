package es.pjd.data.model;


import java.util.Objects;

public class Organization {

    private String name;
    private String description;
    private String email;
    private String phone;

    private Organization(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Organization that = (Organization) other;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, email, phone);
    }

    public static OrganizationBuilder builder(){
        return new OrganizationBuilder();
    }

    public OrganizationBuilder cloneBuilder(){
        return new OrganizationBuilder().withName(this.name).withDescription(this.description).withEmail(this.email).withPhone(this.phone);
    }

    public interface IOrganizationBuilder{
        Organization build();
    }

    public static class OrganizationBuilder implements IOrganizationBuilder{

        private String name;
        private String description;
        private String email;
        private String phone;

        public OrganizationBuilder() {}

        public OrganizationBuilder withName(String name){
            this.name = name;
            return this;
        }

        public OrganizationBuilder withDescription(String description){
            this.description = description;
            return this;
        }

        public OrganizationBuilder withEmail(String email){
            this.email = email;
            return this;
        }

        public OrganizationBuilder withPhone(String phone){
            this.phone = phone;
            return this;
        }

        @Override
        public Organization build(){
            Organization organization = new Organization();
            organization.setName(this.name);
            organization.setDescription(this.description);
            organization.setEmail(this.email);
            organization.setPhone(this.phone);
            return organization;
        }

    }

}
