package elsaghier.example.com.appssquare.Second_Task.Adapters;

import android.graphics.Color;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import elsaghier.example.com.appssquare.R;
import elsaghier.example.com.appssquare.Second_Task.Model.NavigationModel;
import elsaghier.example.com.appssquare.Second_Task.SecondTask;

/**
 * Created by ELSaghier on 1/13/2018.
 */

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.NavigationItemHolder> {

    private ArrayList<NavigationModel> data;
    private AppCompatActivity activity;
    private RecyclerView recyclerView;
    private int indexOfLastClickedItem = -1;

    public NavigationAdapter(ArrayList<NavigationModel> data, AppCompatActivity activity, RecyclerView recyclerView) {
        this.data = data;
        this.activity = activity;
        this.recyclerView = recyclerView;
    }


    @Override
    public NavigationItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.navigation_drawer_recycler_item
                , parent
                , false);

        return new NavigationItemHolder(v);
    }


    @Override
    public void onBindViewHolder(final NavigationItemHolder holder, int position) {

        final NavigationModel model = data.get(position);

        holder.setItemIcon(model.getImageId());
        holder.setItemTittle(model.getTittle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();

                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, model.getFragment())
                        .addToBackStack("Tag" + pos)
                        .commit();
                SecondTask.fragmentItem = model.getFragment();
                // close Drawer if opened [ almost opened :D ]
                DrawerLayout drawer = activity.findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                recyclerView.getChildAt(pos).setBackgroundColor(Color.GRAY);
                if (indexOfLastClickedItem != -1) {
                    recyclerView.getChildAt(indexOfLastClickedItem).setBackgroundColor(Color.TRANSPARENT);
                }
                indexOfLastClickedItem = pos;
            }
        });

    }

    @Override
    public int getItemCount() {
        if (data != null)
            return data.size();
        return 0;
    }

    class NavigationItemHolder extends RecyclerView.ViewHolder {

        ImageView iconTV;
        TextView tittleIV;

        NavigationItemHolder(View view) {
            super(view);
            iconTV = view.findViewById(R.id.itemImage);
            tittleIV = view.findViewById(R.id.itemName);
        }

        void setItemTittle(String tittle) {
            tittleIV.setText(tittle);
        }

        void setItemIcon(int imgRes) {
            iconTV.setImageResource(imgRes);
        }
    }
}
