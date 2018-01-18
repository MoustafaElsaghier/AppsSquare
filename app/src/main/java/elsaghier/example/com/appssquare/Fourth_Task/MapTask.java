package elsaghier.example.com.appssquare.Fourth_Task;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import elsaghier.example.com.appssquare.R;

public class MapTask extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_task);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if (firstMarker == null) {
                    firstMarker = new MarkerOptions().position(latLng).title("First Marker");
                    mMap.addMarker(firstMarker);
                } else {
                    mMap.clear();
                    mMap.addMarker(firstMarker);
                    secondMarker = new MarkerOptions().position(latLng).title("Second Marker");
                    mMap.addMarker(secondMarker);
                }
            }
        });
    }

    MarkerOptions firstMarker, secondMarker;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("First Marker"));
    }

    public void resetMap(View view) {
        mMap.clear();
        firstMarker = null;
        secondMarker = null;
    }

    public void drawLines(View view) {
        PolylineOptions line =
                new PolylineOptions().add(firstMarker.getPosition(), secondMarker.getPosition())
                        .width(5).color(Color.RED);
        mMap.addPolyline(line);
    }
}
