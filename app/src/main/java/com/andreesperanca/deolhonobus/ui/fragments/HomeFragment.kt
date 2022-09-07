package com.andreesperanca.deolhonobus.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreesperanca.deolhonobus.adapters.BusLineFavoriteAdapter
import com.andreesperanca.deolhonobus.adapters.BusStopAdapter
import com.andreesperanca.deolhonobus.adapters.BusStopFavoriteAdapter
import com.andreesperanca.deolhonobus.databinding.FragmentHomeBinding
import com.andreesperanca.deolhonobus.ui.viewmodels.HomeViewModel
import org.koin.android.ext.android.inject


class HomeFragment : Fragment() {

    private val viewModel : HomeViewModel by inject()

    private val busLineAdapter by lazy {
        BusLineFavoriteAdapter()
    }

    private val busStopAdapter by lazy {
        BusStopFavoriteAdapter()
    }



    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.favoritesBusLines.observe(viewLifecycleOwner) { busLineAdapter.updateList(it) }
        viewModel.favoritesBusStops.observe(viewLifecycleOwner) { busStopAdapter.updateList(it) }

    }

    override fun onStart() {
        super.onStart()
        configureBusLineAdapter()
        configureBusStopAdapter()
    }

    private fun configureBusLineAdapter() {
        val divisor = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        binding.rvFavoritesBusLines.adapter = busLineAdapter
        binding.rvFavoritesBusLines.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.rvFavoritesBusLines.addItemDecoration(divisor)
    }

    private fun configureBusStopAdapter() {
        val divisor = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        binding.rvFavoritesBusStops.adapter = busStopAdapter
        binding.rvFavoritesBusStops.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.rvFavoritesBusStops.addItemDecoration(divisor)
    }
}