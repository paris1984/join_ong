package es.pjd.dagger;

import com.google.firebase.firestore.FirebaseFirestore;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Modulo que proporciona la instancia a FirebaseFirestore
 */
@Module
public class FirestoreDaggerModule {

    @Provides
    @Singleton
    public FirebaseFirestore provideFirebaseFirestore() {
        return FirebaseFirestore.getInstance();
    }
}
