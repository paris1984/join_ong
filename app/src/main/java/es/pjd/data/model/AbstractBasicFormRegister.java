package es.pjd.data.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public abstract class AbstractBasicFormRegister extends BasicFormRegister {

    private String surname;
    private String nick;
    private String password;

    protected AbstractBasicFormRegister(final AbstractBasicFormRegisterBuilder<?> builder ) {
        super(builder);
        this.surname = builder.surname;
        this.nick = builder.nick;
        this.password = builder.password;
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

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof AbstractBasicFormRegister)){
            return false;
        }
        final AbstractBasicFormRegister castOther = (AbstractBasicFormRegister) other;
        return new EqualsBuilder()
                .appendSuper(super.equals(other))
                .append(surname, castOther.surname)
                .append(nick, castOther.nick)
                .append(password, castOther.password)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(surname)
                .append(nick)
                .append(password)
                .toHashCode();
    }

    public static abstract class AbstractBasicFormRegisterBuilder<T extends AbstractBasicFormRegisterBuilder<T>> extends BasicFormRegisterBuilder<T>{

        private String surname;
        private String nick;
        private String password;

        public T withSurname(final String surname){
            this.surname = surname;
            return self();
        }

        public T withNick(final String nick){
            this.nick = nick;
            return self();
        }

        public T withPassword(final String password){
            this.password = password;
            return self();
        }
    }

}
