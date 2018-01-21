package elsaghier.example.com.appssquare.Fourth_Task;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import elsaghier.example.com.appssquare.R;

public class MapTask extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    MarkerOptions firstMarker, secondMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_task);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if (firstMarker == null) {
                    firstMarker = new MarkerOptions().position(latLng).title("First Marker");
                    Marker m1 = mMap.addMarker(firstMarker);
                    m1.showInfoWindow();
                    m1.setDraggable(true);
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(firstMarker.getPosition()));
                } else {
                    mMap.clear();
                    mMap.addMarker(firstMarker);
                    Marker m2 = mMap.addMarker(firstMarker);
                    m2.showInfoWindow();
                    m2.setDraggable(true);

                    secondMarker = new MarkerOptions().position(latLng).title("Second Marker");
                    Marker m3 = mMap.addMarker(secondMarker);
                    m3.showInfoWindow();
                    m3.setDraggable(true);

//                    mMap.moveCamera(CameraUpdateFactory.newLatLng(secondMarker.getPosition()));
                }
            }
        });
    }

    public void resetMap(View view) {
        mMap.clear();
        firstMarker = null;
        secondMarker = null;
    }

    public void drawLines(View view) {
        if (firstMarker == null || secondMarker == null) {
            Toast.makeText(this, "Build two point", Toast.LENGTH_SHORT).show();
            return;
        }
        PolylineOptions line =
                new PolylineOptions()
                        .add(firstMarker.getPosition(),
                                secondMarker.getPosition())
                        .width(5)
                        .color(Color.RED);
        mMap.addPolyline(line);
    }
}
