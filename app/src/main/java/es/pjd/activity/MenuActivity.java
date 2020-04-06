package es.pjd.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import javax.inject.Inject;

import es.pjd.R;
import es.pjd.dagger.DaggerApplicationComponent;
import es.pjd.data.model.User;
import es.pjd.model.UserViewModel;
import es.pjd.viewmodel.ViewModelFactory;

public class MenuActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    /** Variable a injectar */
    @Inject ViewModelFactory mViewModelFactory;

    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        /** Decirle a dagger que es el momento de injectar lo declarado para esta actividad (this)*/
        DaggerApplicationComponent.create().inject(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        /**Usar el factory creado para manejar instancias personalizadas.
         * En este caso UserViewModel que necesita la inyeccion de firebase
         */
        //userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel = ViewModelProviders.of(this, mViewModelFactory).get(UserViewModel.class);


        userViewModel.getUserById(FirebaseAuth.getInstance().getUid()).observe(this, new Observer<List<User>>() {
        //userViewModel.getUserOrganizationPermissionsById(FirebaseAuth.getInstance().getUid()).observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                if(users != null && !users.isEmpty()){
                    String customGreetText = String.format(getResources().getString(R.string.custom_greet), users.get(0).getName());
                    ((TextView)findViewById(R.id.customGreet)).setText(customGreetText);
                    ((TextView)findViewById(R.id.customMail)).setText(users.get(0).getEmail());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
