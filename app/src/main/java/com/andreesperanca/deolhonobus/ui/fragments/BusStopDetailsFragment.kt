package com.andreesperanca.deolhonobus.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.andreesperanca.deolhonobus.MapsActivity
import com.andreesperanca.deolhonobus.R
import com.andreesperanca.deolhonobus.adapters.BusStopForecastAdapter
import com.andreesperanca.deolhonobus.databinding.FragmentBusStopDetailsBinding
import com.andreesperanca.deolhonobus.models.*
import com.andreesperanca.deolhonobus.ui.viewmodels.BusStopDetailsViewModel
import com.andreesperanca.deolhonobus.util.Resource
import com.google.android.gms.maps.model.LatLng
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.fragmentScope

class BusStopDetailsFragment : Fragment() {

    private val binding by lazy {
        FragmentBusStopDetailsBinding.inflate(layoutInflater)
    }
    private val adapter by lazy {
        BusStopForecastAdapter(childFragmentManager)
    }
    private val viewModel: BusStopDetailsViewModel by inject()

    private val args: BusStopDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getForecast.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    adapter.updateList(it.data)
                    binding.progressBar.visibility = View.INVISIBLE
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(),it.message,Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        }
        inputInfoBusStop()
    }

    private fun inputInfoBusStop() {
        binding.tvBusStopName.text = getString(R.string.busStopName, args.busStop.name)
        binding.tvAddress.text = getString(R.string.address, args.busStop.address)
        binding.tvIdCode.text = getString(R.string.idCode, args.busStop.id.toString())
    }

    override fun onResume() {
        super.onResume()
        configureRecyclerView()
        viewModel.getForecastWithBusStopCode(args.busStop.id.toString())


        binding.btnLocalizeBusStop.setOnClickListener {
            configureLozalizeButton()
        }
    }

    private fun configureLozalizeButton() {
        val listMarker = mutableListOf<Place>()
        val place = Place(title = args.busStop.name, LatLng(args.busStop.latitude,args.busStop.longitude))
        listMarker.add(place)
        val intent = Intent(requireContext(), MapsActivity::class.java)
        intent.putExtra("extrasinput", MarkerInGmaps(args.busStop.name,
            listMarker = listMarker
        ))
        startActivity(intent)
    }

    private fun configureRecyclerView() {
        binding.rvBusStop.adapter = adapter
        binding.rvBusStop.layoutManager = LinearLayoutManager(requireContext(), VERTICAL, false)
    }
}