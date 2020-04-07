package es.pjd.validator.data.same;

public enum FieldOrganization{
    NAME("name"), DESCRIPTION("description"), EMAIL("email"), PHONE("phone"), NO_INFO("");

    private String fieldOrganization;

    FieldOrganization(String fieldOrganization){
        this.fieldOrganization = fieldOrganization;
    }

    public String getFieldOrganization(){
        return fieldOrganization;
    }
}
