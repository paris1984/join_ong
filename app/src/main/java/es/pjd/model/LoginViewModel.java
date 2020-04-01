package es.pjd.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Patterns;

import es.pjd.R;

public class LoginViewModel extends ViewModel {

    public static final int PASSWORD_SIZE_MAX = 6;
    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();

    public LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    public void loginDataChanged(String username, String password) {
        if(isUserNameFill(username))
            if(!"".equals(password)) {
                if (!isPasswordValid(password)) {
                    loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
                } else {
                    loginFormState.setValue(new LoginFormState(true));
                }
            }else{
                loginFormState.setValue(new LoginFormState(false));
            }
    }

    public Boolean isUserNameFill(String username) {
        Boolean valid = false;
        if(username==null || "".equals(username)){
            loginFormState.setValue(new LoginFormState(R.string.empty_username, null));
        }else if (!isUserNameValidPattern(username)){
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        }else{
            valid = true;
            //loginFormState.setValue(new LoginFormState(true));
        }
        return valid;
    }

    // A placeholder username validation check
    private boolean isUserNameValidPattern(String username) {
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return false;
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() >= PASSWORD_SIZE_MAX;
    }
}
