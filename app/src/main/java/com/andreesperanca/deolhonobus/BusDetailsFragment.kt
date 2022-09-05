package com.andreesperanca.deolhonobus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreesperanca.deolhonobus.adapters.BusStopAdapter
import com.andreesperanca.deolhonobus.adapters.SearchAdapter
import com.andreesperanca.deolhonobus.databinding.FragmentBusDetailsBinding

class BusDetailsFragment : Fragment() {

    private val args : BusDetailsFragmentArgs by navArgs()

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

    override fun onStart() {
        super.onStart()
        putBusInfo()
        configureFavoriteButton()
        configureLocalizeButton()
    }

    private fun configureLocalizeButton() {

    }

    private fun configureFavoriteButton() {
        binding.btnFavorite.setOnClickListener {
            if (binding.btnFavorite.drawable == resources.getDrawable(R.drawable.ic_is_favorite)) {
                binding.btnFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_not_favorite))
            } else {
                binding.btnFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_is_favorite))
            }
        }
    }

    private fun putBusInfo() {
        binding.tvNumberLine.text = getString(R.string.idBus,args.bus.id.toString())
        if (args.bus.CircularRoute) {
            binding.tvOperationType.text = getString(R.string.operationType, "Sim")
        } else {
            binding.tvOperationType.text = getString(R.string.operationType,"Não")
        }
        if (args.bus.secondLabel == "10") {
            binding.tvOperationMode.text = getString(R.string.operationMode, "BASE")
        } else {
            binding.tvOperationMode.text = getString(R.string.operationMode, "Atendimento.")
        }
        if (args.bus.direction == 1) {
            binding.tvOrigin.text = binding.root.context.getString(R.string.origin,args.bus.mainTerminal)
            binding.tvDestination.text = binding.root.context.getString(R.string.destination,args.bus.secondaryTerminal)
        } else {
            binding.tvOrigin.text = binding.root.context.getString(R.string.origin,args.bus.secondaryTerminal)
            binding.tvDestination.text = binding.root.context.getString(R.string.destination,args.bus.mainTerminal)
        }

    }


}