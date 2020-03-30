package es.pjd.data.model;

public class User {

    private String uid;
    private String name;
    private String surname;
    private String nick;
    private String phone;
    private String email;

    public User(){}

    public User(String uid, String name, String surname, String nick, String phone, String email) {
        this.uid = uid;
        this.name = name;
        this.surname = surname;
        this.nick = nick;
        this.phone = phone;
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNick() {
        return nick;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
