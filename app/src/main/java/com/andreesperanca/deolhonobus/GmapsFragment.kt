package com.andreesperanca.deolhonobus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.andreesperanca.deolhonobus.databinding.FragmentGmapsBinding
import com.andreesperanca.deolhonobus.mockdata.MockData
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

class GmapsFragment : Fragment() {

    private val binding by lazy {
        FragmentGmapsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val mapFragment =
//            childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
//
//        mapFragment.getMapAsync { googleMap ->
//            addMarkers(googleMap)
//
//            googleMap.setMapStyle(
//                MapStyleOptions.loadRawResourceStyle(requireContext(), R.raw.map_style)
//            )
//
////            googleMap.setInfoWindowAdapter(MarkerInfoAdapter(requireContext()))
//            googleMap.setOnMapLoadedCallback {
//                val bounds = LatLngBounds.Builder()
//                MockData().listPosition.forEach {
//                    it.listPoints.forEach {
//                        bounds.include(it.latLng)
//                        googleMap.moveCamera(
//                            CameraUpdateFactory.newLatLngBounds(
//                                bounds.build(),
//                                500
//                            )
//                        )
//                    }
//                }
//            }
//        }
//    }
//
//    private fun addMarkers(googleMap: GoogleMap) {
//
//        MockData().listPosition.forEach { relation ->
//            relation.listPoints.forEach {
//                val marker = googleMap.addMarker(
//                    MarkerOptions()
//                        .title(it.timeLocalized)
//                        .position(it.latLng)
//                        .icon(
//                            BitMapHelper.vectorToBitMap(
//                                requireContext(),
//                                R.drawable.bus_stop,
//                                ContextCompat.getColor(requireContext(), R.color.black)
//                            )
//                        )
//                )
//                marker?.tag = relation
//            }
//        }
//    }
    }
}