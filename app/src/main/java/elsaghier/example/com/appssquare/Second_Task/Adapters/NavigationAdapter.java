package elsaghier.example.com.appssquare.Second_Task.Adapters;

import android.content.Context;
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

/**
 * Created by ELSaghier on 1/13/2018.
 */

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.NavigationItemHolder> {

    ArrayList<NavigationModel> data;
    Context context;

    public NavigationAdapter(ArrayList<NavigationModel> data, Context context) {
        this.data = data;
        this.context = context;

    }

    @Override
    public NavigationItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.navigation_drawer_recycler_item
                , parent
                , false);

        return new NavigationItemHolder(v);
    }

    @Override
    public void onBindViewHolder(NavigationItemHolder holder, final int position) {

        final NavigationModel model = data.get(position);

        holder.setItemIcon(model.getImageId());
        holder.setItemTittle(model.getTittle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AppCompatActivity) context).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, model.getFragment())
                        .commit();
                DrawerLayout drawer = ((AppCompatActivity) context).findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }

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
