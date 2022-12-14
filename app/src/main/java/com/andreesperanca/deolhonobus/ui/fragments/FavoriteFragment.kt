package com.andreesperanca.deolhonobus.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreesperanca.deolhonobus.adapters.BusLineFavoriteAdapter
import com.andreesperanca.deolhonobus.adapters.BusStopFavoriteAdapter
import com.andreesperanca.deolhonobus.databinding.FragmentFavoriteBinding
import com.andreesperanca.deolhonobus.ui.viewmodels.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private val viewModel : FavoriteViewModel by viewModels()

    private val busLineAdapter by lazy {
        BusLineFavoriteAdapter()
    }

    private val busStopAdapter by lazy {
        BusStopFavoriteAdapter()
    }



    private val binding by lazy {
        FragmentFavoriteBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.favoritesBusLines.observe(viewLifecycleOwner) {
            busLineAdapter.updateList(it)
            uiBusLineFavoriteAdapter(busLineAdapter)
        }
        viewModel.favoritesBusStops.observe(viewLifecycleOwner) {
            busStopAdapter.updateList(it)
            uiBusStopFavoriteAdapter(busStopAdapter)
        }
    }
    override fun onStart() {
        super.onStart()
        configureBusLineAdapter()
        configureBusStopAdapter()
    }

    private fun configureBusLineAdapter() {
        binding.rvFavoritesBusLines.adapter = busLineAdapter
        binding.rvFavoritesBusLines.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }

    private fun configureBusStopAdapter() {
        binding.rvFavoritesBusStops.adapter = busStopAdapter
        binding.rvFavoritesBusStops.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }

    private fun uiBusLineFavoriteAdapter(adapter: BusLineFavoriteAdapter) {
        binding.rvFavoritesBusLines.adapter = adapter
        if (adapter.itemCount == 0) {
            binding.adapterBusLinesFavorites.root.visibility = View.VISIBLE
        } else {
            binding.adapterBusLinesFavorites.root.visibility = View.INVISIBLE
        }
    }
    private fun uiBusStopFavoriteAdapter(adapter: BusStopFavoriteAdapter) {
        binding.rvFavoritesBusStops.adapter = adapter
        if (adapter.itemCount == 0) {
            binding.adapterBusStopsFavorites.root.visibility = View.VISIBLE
        } else {
            binding.adapterBusStopsFavorites.root.visibility = View.INVISIBLE
        }
    }


}