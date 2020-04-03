package es.pjd.data.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class AdministratorFormRegister extends AbstractBasicFormRegister {

    private AdministratorFormRegister(final AbstractBasicFormRegisterBuilder builder){
        super(builder);
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof AdministratorFormRegister)){
            return false;
        }
        final AdministratorFormRegister castOther = (AdministratorFormRegister) other;
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

    public static AdministratorFormRegisterBuilder builder(){
        return new AdministratorFormRegisterBuilder();
    }

    @Override
    public AdministratorFormRegisterBuilder cloneBuilder(){
        return new AdministratorFormRegisterBuilder().withName(this.getName())
                .withSurname(this.getSurname()).withNick(this.getNick())
                .withEmail(this.getEmail()).withPassword(this.getPassword())
                .withPhone(this.getPhone());
    }

    public static class AdministratorFormRegisterBuilder extends AbstractBasicFormRegisterBuilder<AdministratorFormRegisterBuilder>{

        @Override
        public AdministratorFormRegister build() {
            return new AdministratorFormRegister(this);
        }

        @Override
        protected AdministratorFormRegisterBuilder self() {
            return this;
        }
    }

}
