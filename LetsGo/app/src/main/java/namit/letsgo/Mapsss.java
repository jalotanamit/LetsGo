package namit.letsgo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapsss extends FragmentActivity implements OnMapReadyCallback {
    Bundle bundle;
    String s,s2,s3;


    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapsss);

        bundle=getIntent().getExtras();
        s=bundle.getString("abc");
        s2=bundle.getString("aaa");
        s3=bundle.getString("aba");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker to the place
        LatLng sydney = new LatLng(Double.valueOf(s),Double.valueOf(s2));
        mMap.addMarker(new MarkerOptions().position(sydney).title(s3));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,16));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14),2000,null);
    }
}
