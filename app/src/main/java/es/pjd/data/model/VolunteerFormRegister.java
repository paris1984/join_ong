package es.pjd.data.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class VolunteerFormRegister extends AbstractBasicFormRegister {

    private String idOrganization;

    private VolunteerFormRegister(final VolunteerFormRegisterBuilder builder){
        super(builder);
        this.idOrganization = builder.idOrganization;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof VolunteerFormRegister)){
            return false;
        }
        final VolunteerFormRegister castOther = (VolunteerFormRegister) other;
        return new EqualsBuilder()
                .appendSuper(super.equals(other))
                .append(idOrganization, castOther.idOrganization)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(idOrganization)
                .toHashCode();
    }

    public static VolunteerFormRegisterBuilder builder(){
        return new VolunteerFormRegisterBuilder();
    }

    public VolunteerFormRegisterBuilder cloneBuilder(){
        return new VolunteerFormRegisterBuilder().withName(this.getName())
                .withSurname(this.getSurname()).withNick(this.getNick())
                .withEmail(this.getEmail()).withPassword(this.getPassword())
                .withPhone(this.getPhone()).withIdOrganization(this.idOrganization);
    }

    public static class VolunteerFormRegisterBuilder extends AbstractBasicFormRegisterBuilder<VolunteerFormRegisterBuilder>{

        private String idOrganization;

        public VolunteerFormRegisterBuilder withIdOrganization(final String idOrganization){
            this.idOrganization = idOrganization;
            return self();
        }

        @Override
        public VolunteerFormRegister build() {
            return new VolunteerFormRegister(this);
        }

        @Override
        protected VolunteerFormRegisterBuilder self() {
            return this;
        }
    }
}
