package es.pjd.data.model;

public enum Permission {
    ADMIN("Admin"),
    VOLUNTEER("Voluntario");

    private String permission;

    Permission(String permission){
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }

}
