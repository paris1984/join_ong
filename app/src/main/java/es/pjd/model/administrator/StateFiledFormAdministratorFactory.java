package es.pjd.model.administrator;

import es.pjd.data.model.FieldAdministrator;
import es.pjd.data.model.FieldOrganization;
import es.pjd.model.organization.DataValidFieldFormOrganization;
import es.pjd.model.organization.DescriptionFieldFormOrganization;
import es.pjd.model.organization.EmailFieldFormOrganization;
import es.pjd.model.organization.IDataValidStateFormOrganization;
import es.pjd.model.organization.IEmailStateFormOrganization;
import es.pjd.model.organization.IPhoneStateFormOrganization;
import es.pjd.model.organization.NameFieldFormOrganization;
import es.pjd.model.organization.PhoneFieldFormOrganization;

public class StateFiledFormAdministratorFactory {

    public static IStateFieldFromAdministrator getStatusIsNullOrEmpty(FieldAdministrator field){
        switch (field){
            case NAME:
                return new NameFieldFormAdministrator();
            case SURNAME:
                return new SurnameFieldFormAdministrator();
            case NICK:
                return new NickFieldFormAdministrator();
            case EMAIL:
                return new EmailFieldFormAdministrator();
            case PASSWORD:
                return new PasswordFieldFormAdministrator();
            case PASSWORD_CONF:
                return new PasswordConfFieldFormAdministrator();
            case PHONE:
                return new PhoneFieldFormAdmistrator();
            default:
                return new DataValidFieldFormAdministrator();
        }
    }

    public static IEmailStateFormAdministrator getStatusPatternNotValid(){
        return new EmailFieldFormAdministrator();
    }

    public static IPasswordStateFormAdministrator getStatusLengthMinNotValid(){
        return new PasswordFieldFormAdministrator();
    }

    public static IPasswordConfStateFormAdministrator getStatusConfLengthMinNotValid(){
        return new PasswordConfFieldFormAdministrator();
    }

    public static IPasswordConfStateFormAdministrator getStatusSameOtherField(){
        return new PasswordConfFieldFormAdministrator();
    }

    public static IPhoneStateFormAdministrator getStatusLengthNotValid(){
        return new PhoneFieldFormAdmistrator();
    }

    public static IDataValidStateFormAdministrator getStatusDataValid(){
        return new DataValidFieldFormAdministrator();
    }



}
