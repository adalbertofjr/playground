package br.com.adalbertofjr.mapcameraone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap map;
    boolean mapReady = false;
    private LatLng seattlePosition = new LatLng(47.6204, -122.3491);
    private LatLng newYorkPosition = new LatLng(40.7127, -73.9857);
    private LatLng dublinPosition = new LatLng(53.3478, -6.2597);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSeattle = (Button) findViewById(R.id.main_btn_seattle);
        Button btnNewYork = (Button) findViewById(R.id.main_btn_new_york);
        Button btnDublin = (Button) findViewById(R.id.main_btn_dublin);

        btnSeattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    flyTo(seattlePosition);
                }
            }
        });

        btnNewYork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    flyTo(newYorkPosition);
                }
            }
        });

        btnDublin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    flyTo(dublinPosition);
                }
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.main_map);
        mapFragment.getMapAsync(this);
    }

    private void flyTo(LatLng destino) {
        CameraPosition target = CameraPosition.builder()
                .target(destino)
                .zoom(17)
                .bearing(0)
                .tilt(45)
                .build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        CameraPosition target = CameraPosition.builder().target(seattlePosition).zoom(14).build();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(target));

    }
}
