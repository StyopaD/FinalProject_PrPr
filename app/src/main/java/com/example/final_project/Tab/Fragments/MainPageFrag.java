package com.example.final_project.Tab.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.final_project.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainPageFrag#} factory method to
 * create an instance of this fragment.
 */
public class MainPageFrag extends Fragment implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    //private static final String ARG_PARAM1 = "param1";

    //private String mParam1;

    private TextView tapTextView;
    private GoogleMap googleMap;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Objects.requireNonNull(getActivity()).setContentView(R.layout.fragment_main_page);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //tapTextView = findViewById(R.id.tap_text);
    }

    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng home = new LatLng(41.394321,2.148217);
        LatLng TetuanSquare = new LatLng(41.394744, 2.175713);
        LatLng SagradaFamilia = new LatLng(41.403953, 2.173923);
        LatLng Gracia = new LatLng(41.409492, 2.153923);
        googleMap.addMarker(new MarkerOptions().position(home).title("Marker at home"));
        googleMap.addMarker(new MarkerOptions().position(TetuanSquare).title("randomMarker1"));
        googleMap.addMarker(new MarkerOptions().position(SagradaFamilia).title("randomMarker2"));
        googleMap.addMarker(new MarkerOptions().position(Gracia).title("randomMarker3"));

        final LatLng CriptaSantaEulalia = new LatLng(41.383835, 2.176295);
        Marker criptaMarker = googleMap.addMarker(
                new MarkerOptions().position(CriptaSantaEulalia)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
                        /*.icon(BitmapDescriptionFactory.fromResource(R.drawable.LOKSEA))
                         * .flat(true)      //This just means that it will rotate with Earth & will change perspective as we zoom in
                         * .zIndex(2.0f)    //In case we need to put them in order. Z INDEX is the one
                         * that drives the priorities on the OnMarkerClickListener()!!!
                         * We only need to put googleMap.setOnMarkerClickListener(OnMarkerClickListener)*/
                        .alpha(0.8f).draggable(true));

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(home));
        //If we add a float value of aprox 15 we will see aprox 2km radius from where the camera lands to begin with
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home,15));
        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                //Alex, put here the next activity to be shown when you pres on any of the markers.
                //After that, you just hav eto grab from the parsed intent the marker tag (marker.getTag())
                /**
                 * To do so, use:
                 * public boolean onMarkerClick(Marker marker) {
                 *                 if (marker.getTitle().equals("Chennai")){
                 *                     //Toast.makeText(MapsActivity.this, "Clicked"+marker.getTitle(), Toast.LENGTH_SHORT).show();
                 *                 }
                 *                 return false;
                 *             }
                 * */
                /*Intent intent = new Intent(MapsActivity.this, someActivity.class);
                startActivity(intent);*/
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_page, container, false);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        //get the data from the marker (so it has it inside)
        Integer clickCount = (Integer) marker.getTag();

        //If there is a click...
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            /*Toast.makeText(this,
                    marker.getTitle() +
                            " has been clicked " + clickCount + " times.",
                    Toast.LENGTH_SHORT).show();*/
        }

        /* We return false because reasons. That's it. But inside it is just to indicate that we have
        not consumed the event that we want to have as a "default behaviour". The "default behaviour"
        in this case is that the camera moves to the position of the pressed marker. We do not want
        that, right? We just want this toast for now. It might open the marker's info window, too,
        but with "false" we treat that, too.*/
        return false;
    }

/*
    @Override
    public void onMapClick(LatLng point) {
        tapTextView.setText("tapped, point=" + point);
    }

    @Override
    public void onMapLongClick(LatLng point) {
        tapTextView.setText("long pressed, point=" + point);
    }

    @Override
    public void onCameraIdle() {
        cameraTextView.setText(map.getCameraPosition().toString());
    }*/
}