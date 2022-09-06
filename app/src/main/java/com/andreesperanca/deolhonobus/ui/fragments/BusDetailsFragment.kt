package com.andreesperanca.deolhonobus.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreesperanca.deolhonobus.R
import com.andreesperanca.deolhonobus.SearchFragmentDirections
import com.andreesperanca.deolhonobus.adapters.BusStopAdapter
import com.andreesperanca.deolhonobus.data.local.FavoriteRoomDataBase
import com.andreesperanca.deolhonobus.databinding.FragmentBusDetailsBinding
import com.andreesperanca.deolhonobus.repositories.BusDetailsRepository
import com.andreesperanca.deolhonobus.ui.viewmodels.BusDetailsViewModel
import com.andreesperanca.deolhonobus.ui.viewmodels.BusDetailsViewModelFactory
import org.koin.android.ext.android.inject

class BusDetailsFragment : Fragment() {

    private val args: BusDetailsFragmentArgs by navArgs()
    private val db : FavoriteRoomDataBase by inject()
    private val viewModel: BusDetailsViewModel by activityViewModels {
        BusDetailsViewModelFactory(repository = BusDetailsRepository(favoriteDao = db.favoriteDao))
    }
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

        Log.i("teste", viewModel.isFavorite.value.toString())

        viewModel.isFavorite.observe(viewLifecycleOwner) { isFavorite ->
            if (isFavorite == true) {
                binding.btnFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_is_favorite))
            } else {
                binding.btnFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_not_favorite))
            }
        }
        configureRecyclerView()

    }
    override fun onStart() {
        super.onStart()
        putBusInfo()
        configureFavoriteButton()
        configureLocalizeButton()
    }

    private fun configureLocalizeButton() {
        binding.btnLocalize.setOnClickListener {
            if(findNavController().currentDestination?.id == R.id.busDetailsFragment) {
                findNavController().navigate(R.id.action_busDetailsFragment_to_gmapsFragment)
            }
        }
    }

    private fun configureFavoriteButton() {
        binding.btnFavorite.setOnClickListener {
            viewModel.favoriteBusLine(args.bus)
        }
    }
    private fun configureRecyclerView() {
        val divisor = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        binding.rvBusStop.adapter = BusStopAdapter()
        binding.rvBusStop.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rvBusStop.addItemDecoration(divisor)
    }
    private fun putBusInfo() {
        binding.tvNumberLine.text = getString(R.string.idBus, args.bus.busLineNumber.toString())
        if (args.bus.CircularRoute) {
            binding.tvOperationType.text = getString(R.string.operationType, "Sim")
        } else {
            binding.tvOperationType.text = getString(R.string.operationType, "Não")
        }
        if (args.bus.secondLabel == "10") {
            binding.tvOperationMode.text = getString(R.string.operationMode, "BASE")
        } else {
            binding.tvOperationMode.text = getString(R.string.operationMode, "Atendimento.")
        }
        if (args.bus.direction == 1) {
            binding.tvOrigin.text =
                binding.root.context.getString(R.string.origin, args.bus.mainTerminal)
            binding.tvDestination.text =
                binding.root.context.getString(R.string.destination, args.bus.secondaryTerminal)
        } else {
            binding.tvOrigin.text =
                binding.root.context.getString(R.string.origin, args.bus.secondaryTerminal)
            binding.tvDestination.text =
                binding.root.context.getString(R.string.destination, args.bus.mainTerminal)
        }
    }
}