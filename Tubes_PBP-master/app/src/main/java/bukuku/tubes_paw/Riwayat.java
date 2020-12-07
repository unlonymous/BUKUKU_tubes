package bukuku.tubes_paw;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Riwayat extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private FirebaseAuth auth;
    private FirebaseUser user;


    //NAVBAR=============================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);

        //HOOKS
        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        //tool bar
        setSupportActionBar(toolbar);

        //navigation drawer menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item
     */

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.nav_home:
                Intent intent = new Intent(Riwayat.this, MainActivity.class);
                startActivity(intent);

                break;

            case R.id.nav_daftar:
                intent = new Intent(Riwayat.this, BookActivity.class);
                startActivity(intent);

                break;

            case R.id.nav_pinjam:
                intent = new Intent(Riwayat.this, PinjamBuku.class);
                startActivity(intent);

                break;

            case R.id.nav_riwayat:
                intent = new Intent(Riwayat.this, Riwayat.class);
                startActivity(intent);

                break;

            //Comunicate

            case R.id.nav_map:
                intent = new Intent(Riwayat.this, Location.class);
                startActivity(intent);

                break;

            //Profile

            case R.id.nav_profil:
                intent = new Intent(Riwayat.this, Profil.class);
                startActivity(intent);

                break;

            case R.id.nav_logout:
                auth = FirebaseAuth.getInstance();
                user = auth.getCurrentUser();
                auth.signOut();
                intent = new Intent(Riwayat.this, Login.class);
                startActivity(intent);

                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    //NAVBAR==============================================================================


}