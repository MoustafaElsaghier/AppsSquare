package elsaghier.example.com.appssquare.Second_Task;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import elsaghier.example.com.appssquare.R;
import elsaghier.example.com.appssquare.Second_Task.Adapters.NavigationAdapter;
import elsaghier.example.com.appssquare.Second_Task.Fragments.AboutUsFragment;
import elsaghier.example.com.appssquare.Second_Task.Fragments.ContactUsFragment;
import elsaghier.example.com.appssquare.Second_Task.Fragments.HomeFragment;
import elsaghier.example.com.appssquare.Second_Task.Fragments.ProfileFragment;
import elsaghier.example.com.appssquare.Second_Task.Model.NavigationModel;

public class SecondTask extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView navRecycler;
    NavigationAdapter navigationAdapter;
    ArrayList<NavigationModel> models;
    RecyclerView.LayoutManager layoutManager;
    String[] tittles;
    int[] iconsRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_task);
        init();
    }

    private void init() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initRecycler();

    }

    // get resources from XML
    void loadData() {
        tittles = getResources().getStringArray(R.array.navigationItems);
        iconsRes = getResources().getIntArray(R.array.navigationDrawerIcons);
    }

    // fill array of model
    void fillDataModel() {
        loadData();
        models = new ArrayList<>();
        NavigationModel model = new NavigationModel();
        model.setTittle(tittles[0]);
        model.setImageId(iconsRes[0]);
        model.setFragment(new HomeFragment());

        model = new NavigationModel();
        model.setTittle(tittles[1]);
        model.setImageId(iconsRes[1]);
        model.setFragment(new ProfileFragment());

        model = new NavigationModel();
        model.setTittle(tittles[2]);
        model.setImageId(iconsRes[2]);
        model.setFragment(new ContactUsFragment());

        model = new NavigationModel();
        model.setTittle(tittles[3]);
        model.setImageId(iconsRes[3]);
        model.setFragment(new AboutUsFragment());

    }

    // init Recycler Adapter
    void initRecycler() {
        fillDataModel();
        navRecycler = findViewById(R.id.navRecycler);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        navigationAdapter = new NavigationAdapter(models, this);
        navRecycler.setAdapter(navigationAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
