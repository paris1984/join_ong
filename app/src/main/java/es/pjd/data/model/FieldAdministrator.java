package es.pjd.data.model;

public enum FieldAdministrator {
    NAME("name"), SURNAME("surname"), NICK("nick"), EMAIL("email"), PASSWORD("password"), PASSWORD_CONF("password_conf"), PHONE("phone"), NO_INFO("");

    private String fieldAdministrator;

    FieldAdministrator(String fieldAdministrator){
        this.fieldAdministrator = fieldAdministrator;
    }

    public String getFieldAdministrator(){
        return fieldAdministrator;
    }
}
