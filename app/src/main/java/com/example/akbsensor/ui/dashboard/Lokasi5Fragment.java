package com.example.akbsensor.ui.dashboard;

/*
    NIM     : 10119234
    NAMA    : ARHAM JUSNI INDRAWAN
    KELAS   : IF-4
 */

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.akbsensor.R;
import com.example.akbsensor.databinding.FragmentTempat5Binding;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Lokasi5Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lokasi5Fragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FragmentTempat5Binding binding;

    public static Lokasi5Fragment newInstance() {
        return new Lokasi5Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTempat5Binding.inflate(inflater, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return binding.getRoot();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        List<Marker> markers = new ArrayList<>();
        markers.add(googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-6.908399676172855, 107.6112840927612))
                .title("Bandung Indah Plaza")));
        for(Marker m: markers)
        {
            builder.include(m.getPosition());
        }
        LatLngBounds bounds = builder.build();

        int padding = 0;
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds,512,200,padding);

        googleMap.moveCamera(cu);
    }
}