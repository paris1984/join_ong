package es.pjd.validator.state.factory;

import es.pjd.validator.data.same.FieldAdministratorVolunteer;
import es.pjd.validator.state.factory.administratorvolunteer.DataValidFieldFormAdministratorVolunteer;
import es.pjd.validator.state.factory.administratorvolunteer.EmailFieldFormAdministratorVolunteer;
import es.pjd.validator.state.factory.administratorvolunteer.IDataValidStateFormAdministratorVolunteer;
import es.pjd.validator.state.factory.administratorvolunteer.IEmailStateFormAdministratorVolunteer;
import es.pjd.validator.state.factory.administratorvolunteer.IPasswordConfStateFormAdministratorVolunteer;
import es.pjd.validator.state.factory.administratorvolunteer.IPasswordStateFormAdministratorVolunteer;
import es.pjd.validator.state.factory.administratorvolunteer.IPhoneStateFormAdministratorVolunteer;
import es.pjd.validator.state.factory.administratorvolunteer.IStateFieldFromAdministratorVolunteer;
import es.pjd.validator.state.factory.administratorvolunteer.NameFieldFormAdministratorVolunteer;
import es.pjd.validator.state.factory.administratorvolunteer.NickFieldFormAdministratorVolunteer;
import es.pjd.validator.state.factory.administratorvolunteer.PasswordConfFieldFormAdministratorVolunteer;
import es.pjd.validator.state.factory.administratorvolunteer.PasswordFieldFormAdministratorVolunteer;
import es.pjd.validator.state.factory.administratorvolunteer.PhoneFieldFormAdmistratorVolunteer;
import es.pjd.validator.state.factory.administratorvolunteer.SurnameFieldFormAdministratorVolunteer;

public class StateFiledFormAdministratorVolunteerFactory {

    public static IStateFieldFromAdministratorVolunteer getStatusIsNullOrEmpty(FieldAdministratorVolunteer field){
        switch (field){
            case NAME:
                return new NameFieldFormAdministratorVolunteer();
            case SURNAME:
                return new SurnameFieldFormAdministratorVolunteer();
            case NICK:
                return new NickFieldFormAdministratorVolunteer();
            case EMAIL:
                return new EmailFieldFormAdministratorVolunteer();
            case PASSWORD:
                return new PasswordFieldFormAdministratorVolunteer();
            case PASSWORD_CONF:
                return new PasswordConfFieldFormAdministratorVolunteer();
            case PHONE:
                return new PhoneFieldFormAdmistratorVolunteer();
            default:
                return new DataValidFieldFormAdministratorVolunteer();
        }
    }

    public static IEmailStateFormAdministratorVolunteer getStatusPatternNotValid(){
        return new EmailFieldFormAdministratorVolunteer();
    }

    public static IPasswordStateFormAdministratorVolunteer getStatusLengthMinNotValid(){
        return new PasswordFieldFormAdministratorVolunteer();
    }

    public static IPasswordConfStateFormAdministratorVolunteer getStatusConfLengthMinNotValid(){
        return new PasswordConfFieldFormAdministratorVolunteer();
    }

    public static IPasswordConfStateFormAdministratorVolunteer getStatusSameOtherField(){
        return new PasswordConfFieldFormAdministratorVolunteer();
    }

    public static IPhoneStateFormAdministratorVolunteer getStatusLengthNotValid(){
        return new PhoneFieldFormAdmistratorVolunteer();
    }

    public static IDataValidStateFormAdministratorVolunteer getStatusDataValid(){
        return new DataValidFieldFormAdministratorVolunteer();
    }



}
