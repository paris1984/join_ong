package es.pjd.dagger;

import com.google.firebase.firestore.FirebaseFirestore;

import javax.inject.Singleton;

import dagger.Component;
import es.pjd.model.UserViewModel;

/**
 * Componente que injecta FirebaseFirestore declarado en FirestoreDaggerModule en cada método que le indiquemos
 * De momento solo en userViewModel. Hay que hacer lo mismo para cada ViewModel que creemos.
 */
@Singleton
@Component(modules = {FirestoreDaggerModule.class})
public interface FirestoreDaggerComponent {
    void inject(UserViewModel userViewModel);
    //add an inject method for every xViewModel that requires FirebaseFirestore instance
}
