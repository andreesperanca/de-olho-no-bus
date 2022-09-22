package com.andreesperanca.deolhonobus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.andreesperanca.deolhonobus.adapters.MarkerInfoAdapter
import com.andreesperanca.deolhonobus.databinding.ActivityMapsBinding
import com.andreesperanca.deolhonobus.models.MarkerInGmaps
import com.andreesperanca.deolhonobus.util.BitMapHelper
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private var args: MarkerInGmaps? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_DeOlhoNoBus)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent != null) {
            args = intent.getParcelableExtra<MarkerInGmaps>("markersForTheMap")
        }

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        addMarkers(googleMap)
        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style))
        googleMap.setInfoWindowAdapter(MarkerInfoAdapter(this))
        googleMap.setOnMapLoadedCallback {
            val bounds = LatLngBounds.Builder()
            args?.listMarker?.forEach {
                bounds.include(it.lng)
                googleMap.moveCamera(
                    CameraUpdateFactory.newLatLngBounds(
                        bounds.build(),
                        80
                    )
                )
            }
        }
    }

    private fun addMarkers(googleMap: GoogleMap) {
        args?.listMarker?.forEach {
            val marker1 = googleMap.addMarker(
                MarkerOptions()
                    .title(args?.title)
                    .position(it.lng)
                    .icon(
                        BitMapHelper.vectorToBitMap(
                            this,
                            R.drawable.ic_location_24,
                            ContextCompat.getColor(this, R.color.dark_blue)
                        )
                    )
            )
            marker1?.tag = it
        }
    }
}

