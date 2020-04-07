package es.pjd.validator.data.same;

public enum FieldAdministratorVolunteer {
    NAME("name"), SURNAME("surname"), NICK("nick"), EMAIL("email"), PASSWORD("password"), PASSWORD_CONF("password_conf"), PHONE("phone"), ID_ORGANIZATION("id_organization"), NO_INFO("");

    private String fieldAdministratorVolunteer;

    FieldAdministratorVolunteer(String fieldAdministratorVolunteer){
        this.fieldAdministratorVolunteer = fieldAdministratorVolunteer;
    }

    public String getFieldAdministratorVolunteer(){
        return fieldAdministratorVolunteer;
    }
}
