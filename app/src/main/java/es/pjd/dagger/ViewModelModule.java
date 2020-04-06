package es.pjd.dagger;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import dagger.multibindings.IntoMap;
import es.pjd.model.UserViewModel;
import es.pjd.viewmodel.ViewModelFactory;

/**
 * Modulo para obtener cada ViewModel.
 * Se trata de una clase abstracta cuyos métodos son anotados con @Binds para manejar las interfaces
 * Si se quisiera usar implementaciones, la clase dejaria de ser abstracta y se usarian @Provides
 */
@Module
public abstract class ViewModelModule {

    /**
     * Define la anotacion @ViewModelKey que recibirá la key por parametro
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @MapKey
    @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }

    /**
     * Devuelve el factory de ViewModels
     *
     * @param viewModelFactory
     * @return
     */
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);
    /*ViewModelFactory viewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap)
    {
        return new ViewModelFactory(providerMap);
    }*/

    /**
     * Devuelve el ViewModel de usuarios.
     * @param userViewModel
     * @return
     */
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel bindsUserViewModel(UserViewModel userViewModel);
    /*ViewModel bindsUserViewModel(FirebaseFirestore firebaseFirestore)
    {
        return new UserViewModel(firebaseFirestore);
    }*/

    /**
     * Replicar estructura anterior para cada ViewModel
     */
/*    @Provides
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindsLoginViewModel(LoginViewModel userViewModel);
    /*ViewModel bindsUserViewModel(FirebaseFirestore firebaseFirestore)
    {
        return new UserViewModel(firebaseFirestore);
    }*/

}
