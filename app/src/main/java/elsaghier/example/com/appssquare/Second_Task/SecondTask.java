package elsaghier.example.com.appssquare.Second_Task;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;

import elsaghier.example.com.appssquare.R;
import elsaghier.example.com.appssquare.Second_Task.Adapters.NavigationAdapter;
import elsaghier.example.com.appssquare.Second_Task.Fragments.AboutUsFragment;
import elsaghier.example.com.appssquare.Second_Task.Fragments.ContactUsFragment;
import elsaghier.example.com.appssquare.Second_Task.Fragments.HomeFragment;
import elsaghier.example.com.appssquare.Second_Task.Fragments.ProfileFragment;
import elsaghier.example.com.appssquare.Second_Task.Model.NavigationModel;

public class SecondTask extends AppCompatActivity {

    RecyclerView navRecycler;
    NavigationAdapter navigationAdapter;
    ArrayList<NavigationModel> models;
    RecyclerView.LayoutManager layoutManager;
    String[] tittles;
    TypedArray iconsRes;

    public static Fragment fragmentItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_task);
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        if (fragmentItem == null)
            trans.replace(R.id.container, new HomeFragment());
        else
            trans.replace(R.id.container, fragmentItem);
        trans.commit();
        init();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println();
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

    // Custom methods

    private void init() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        initRecycler();
    }

    // get resources from XML
    void loadData() {
        tittles = getResources().getStringArray(R.array.navigationItems);
        iconsRes = getResources().obtainTypedArray(R.array.navigationDrawerIcons);
    }

    // fill array of model
    @SuppressWarnings("ResourceType")
    void fillDataModel() {
        loadData();
        models = new ArrayList<>();
        NavigationModel model = new NavigationModel();
        model.setTittle(tittles[0]);
        model.setImageId(iconsRes.getResourceId(0, -1));
        model.setFragment(new HomeFragment());
        models.add(model);

        model = new NavigationModel();
        model.setTittle(tittles[1]);
        model.setImageId(iconsRes.getResourceId(1, -1));
        model.setFragment(new ProfileFragment());
        models.add(model);

        model = new NavigationModel();
        model.setTittle(tittles[2]);
        model.setImageId(iconsRes.getResourceId(2, -1));
        model.setFragment(new ContactUsFragment());
        models.add(model);

        model = new NavigationModel();
        model.setTittle(tittles[3]);
        model.setImageId(iconsRes.getResourceId(3, -1));
        model.setFragment(new AboutUsFragment());
        models.add(model);

    }

    // init Recycler Adapter
    void initRecycler() {
        fillDataModel();
        navRecycler = findViewById(R.id.navRecycler);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        navRecycler.setLayoutManager(layoutManager);

        navigationAdapter = new NavigationAdapter(models, this,navRecycler);
        navRecycler.setAdapter(navigationAdapter);
    }


}
