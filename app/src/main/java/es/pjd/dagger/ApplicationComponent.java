package es.pjd.dagger;

import javax.inject.Singleton;

import dagger.Component;
import es.pjd.activity.MenuActivity;

/**
 * Componente de la aplicacion. Injecta lo necesario, declarado en los modulos de @Component
 * en la actividad que se le indique.
 *
 * Si se quisieran injectar cosas diferentes en sitios diferentes, habría que ver como hacer para
 * que Dagger interpretase cada componente
 */
@Singleton
@Component(modules = {ViewModelModule.class, FirestoreDaggerModule.class})
public interface ApplicationComponent {
    void inject(MenuActivity menuActivity);
}