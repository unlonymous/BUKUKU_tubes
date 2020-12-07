package bukuku.tubes_paw;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import bukuku.tubes_paw.databinding.ActivityBookBinding;

public class BookActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ArrayList<Book> ListBuku;
    private RecyclerView recyclerView;
    private AdapterRecyclerView adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ActivityBookBinding binding;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private FirebaseAuth auth;
    private FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_book);
        ListBuku = new DaftarBooks().BOOK;

        //recycler view
        recyclerView = findViewById(R.id.recycler_view_book);
        adapter = new AdapterRecyclerView(BookActivity.this, ListBuku);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

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
                Intent intent = new Intent(BookActivity.this, MainActivity.class);
                startActivity(intent);

                break;

            case R.id.nav_daftar:
                intent = new Intent(BookActivity.this, Daftar_Buku.class);
                startActivity(intent);

                break;

            case R.id.nav_pinjam:
                intent = new Intent(BookActivity.this, PinjamBuku.class);
                startActivity(intent);

                break;

            case R.id.nav_riwayat:
                intent = new Intent(BookActivity.this, Riwayat.class);
                startActivity(intent);

                break;

            //Comunicate

            case R.id.nav_map:
                intent = new Intent(BookActivity.this, Location.class);
                startActivity(intent);

                break;

            //Profile

            case R.id.nav_profil:
                intent = new Intent(BookActivity.this, Profil.class);
                startActivity(intent);

                break;

            case R.id.nav_logout:
                auth = FirebaseAuth.getInstance();
                user = auth.getCurrentUser();
                auth.signOut();
                intent = new Intent(BookActivity.this, Login.class);
                startActivity(intent);

                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
