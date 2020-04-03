package es.pjd.model.organization;

import es.pjd.data.model.FieldOrganization;

public class StateFiledFormOrganizationFactory {

    public static IStateFieldFormOrganization getStatusIsNullOrEmpty(FieldOrganization field){
        switch (field){
            case NAME:
                return new NameFieldFormOrganization();
            case DESCRIPTION:
                return new DescriptionFieldFormOrganization();
            case EMAIL:
                return new EmailFieldFormOrganization();
            case PHONE:
                return new PhoneFieldFormOrganization();
            default:
                return new DataValidFieldFormOrganization();
        }
    }

    public static IEmailStateFormOrganization getStatusPatternNotValid(){
        return new EmailFieldFormOrganization();
    }

    public static IPhoneStateFormOrganization getStatusLengthNotValid(){
        return new PhoneFieldFormOrganization();
    }

    public static IDataValidStateFormOrganization getStatusDataValid(){
        return new DataValidFieldFormOrganization();
    }



}
