package br.com.adalbertofjr.maptwo;

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

public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    GoogleMap map;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMap = (Button) findViewById(R.id.main_btn_map);
        Button btnSat = (Button) findViewById(R.id.main_btn_satelite);
        Button btnHib = (Button) findViewById(R.id.main_btn_hibrido);

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        });

        btnSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                }
            }
        });

        btnHib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                }
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.main_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        map = googleMap;

        LatLng saoPaulo = new LatLng(-23.533773, -46.625290);
        CameraPosition target = CameraPosition.builder().target(saoPaulo).zoom(14).build();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}