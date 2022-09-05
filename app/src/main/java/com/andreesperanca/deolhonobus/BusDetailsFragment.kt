package com.andreesperanca.deolhonobus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreesperanca.deolhonobus.adapters.BusStopAdapter
import com.andreesperanca.deolhonobus.adapters.SearchAdapter
import com.andreesperanca.deolhonobus.databinding.FragmentBusDetailsBinding

class BusDetailsFragment : Fragment() {

    private val binding by lazy {
        FragmentBusDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val divisor = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        binding.rvBusStop.adapter = BusStopAdapter()
        binding.rvBusStop.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rvBusStop.addItemDecoration(divisor)

    }


}