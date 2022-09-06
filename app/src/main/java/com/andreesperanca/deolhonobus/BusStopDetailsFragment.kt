package com.andreesperanca.deolhonobus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.andreesperanca.deolhonobus.adapters.SearchAdapter
import com.andreesperanca.deolhonobus.databinding.FragmentBusStopDetailsBinding
import com.andreesperanca.deolhonobus.databinding.FragmentHomeBinding
import com.andreesperanca.deolhonobus.ui.fragments.BusDetailsFragmentArgs

class BusStopDetailsFragment : Fragment() {

    private val binding by lazy {
        FragmentBusStopDetailsBinding.inflate(layoutInflater)
    }
    private val args: BusStopDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRecyclerView()
        inputInfoBusStop()

    }

    private fun inputInfoBusStop() {
        binding.tvBusStopName.text = getString(R.string.busStopName, args.busStop.name)
        binding.tvAddress.text = getString(R.string.address, args.busStop.address)
        binding.tvIdCode.text = getString(R.string.idCode, args.busStop.id.toString())
    }

    private fun configureRecyclerView() {
        binding.rvBusStop.adapter = SearchAdapter()
        binding.rvBusStop.layoutManager = LinearLayoutManager(requireContext(), VERTICAL, false)
    }
}