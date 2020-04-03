package es.pjd.data.model;

public enum FieldVolunteer {
    NAME("name"), SURNAME("surname"), NICK("nick"), EMAIL("email"), PASSWORD("password"), PASSWORD_CONF("password_conf"), PHONE("phone"), ID_ORGANIZATION("id_organization"), NO_INFO("");

    private String fieldVolunteer;

    FieldVolunteer(String fieldVolunteer){
        this.fieldVolunteer = fieldVolunteer;
    }

    public String getFieldVolunteer(){
        return fieldVolunteer;
    }
}
