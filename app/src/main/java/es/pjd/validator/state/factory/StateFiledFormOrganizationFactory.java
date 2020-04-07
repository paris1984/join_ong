package es.pjd.validator.stage.factory;

import es.pjd.validator.data.same.FieldOrganization;
import es.pjd.validator.stage.factory.organization.DataValidFieldFormOrganization;
import es.pjd.validator.stage.factory.organization.DescriptionFieldFormOrganization;
import es.pjd.validator.stage.factory.organization.EmailFieldFormOrganization;
import es.pjd.validator.stage.factory.organization.IDataValidStateFormOrganization;
import es.pjd.validator.stage.factory.organization.IEmailStateFormOrganization;
import es.pjd.validator.stage.factory.organization.IPhoneStateFormOrganization;
import es.pjd.validator.stage.factory.organization.IStateFieldFormOrganization;
import es.pjd.validator.stage.factory.organization.NameFieldFormOrganization;
import es.pjd.validator.stage.factory.organization.PhoneFieldFormOrganization;

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
