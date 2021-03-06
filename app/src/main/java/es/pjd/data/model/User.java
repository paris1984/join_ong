package es.pjd.data.model;

import java.util.Map;

public class User {

    private String uid;
    private String name;
    private String surname;
    private String nick;
    private String phone;
    private String email;
    private Map<String, Permission> organizationPermissions;

    public User(){}

    public User(String uid, String name, String surname, String nick, String phone, String email, Map<String, Permission> organizationPermissions) {
        this.uid = uid;
        this.name = name;
        this.surname = surname;
        this.nick = nick;
        this.phone = phone;
        this.email = email;
        this.organizationPermissions = organizationPermissions;
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

    public Map<String, Permission> getOrganizacionPermissions(){
        return organizationPermissions;
    }
}
