package es.pjd.data.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class AdministratorVolunteer extends BasicRegForm{

    protected String surname;
    protected String nick;
    protected String password;
    protected String idOrganization;

    private AdministratorVolunteer(){
    }

    public String getSurname() {
        return surname;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public String getOrganization(){
        return idOrganization;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof AdministratorVolunteer)){
            return false;
        }
        final AdministratorVolunteer castOther = (AdministratorVolunteer) other;
        return new EqualsBuilder()
                .appendSuper(super.equals(other))
                .append(surname, castOther.surname)
                .append(nick, castOther.nick)
                .append(password, castOther.password)
                .append(idOrganization, castOther.idOrganization)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(surname)
                .append(nick)
                .append(password)
                .append(idOrganization)
                .toHashCode();
    }

    public static AdministratorVolunteerBuilder builder(){
        return new AdministratorVolunteerBuilder();
    }

    @Override
    public AdministratorVolunteerBuilder cloneBuilder(){
        return new AdministratorVolunteerBuilder()
            .withName(this.name)
            .withSurname(this.surname)
            .withNick(this.nick)
            .withEmail(this.email)
            .withPassword(this.password)
            .withPhone(this.phone)
            .withIdOrganization(this.idOrganization);
    }

    public interface IAdministratorVolunteerBuilder{
        AdministratorVolunteer build();
    }

    public static class AdministratorVolunteerBuilder extends BasicRegFormBuilder<AdministratorVolunteer,AdministratorVolunteerBuilder> implements IAdministratorVolunteerBuilder{

        @Override
        protected AdministratorVolunteer getObject() {
            return new AdministratorVolunteer();
        }

        @Override
        protected AdministratorVolunteerBuilder thisObject() {
            return this;
        }

        public AdministratorVolunteerBuilder() {}


        public AdministratorVolunteerBuilder withSurname(String surname){
            object.surname = surname;
            return this;
        }

        public AdministratorVolunteerBuilder withNick(String nick){
            object.nick = nick;
            return this;
        }

        public AdministratorVolunteerBuilder withPassword(String password){
            object.password = password;
            return this;
        }

        public AdministratorVolunteerBuilder withIdOrganization(String idOrganization){
            object.idOrganization = idOrganization;
            return this;
        }
    }

}
