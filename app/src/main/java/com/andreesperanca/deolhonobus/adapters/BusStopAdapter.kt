package com.andreesperanca.deolhonobus.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.andreesperanca.deolhonobus.R
import com.andreesperanca.deolhonobus.adapters.BusStopAdapter.BusStopViewHolder
import com.andreesperanca.deolhonobus.adapters.SearchAdapter.SearchViewHolder
import com.andreesperanca.deolhonobus.databinding.RvBusStopItemBinding
import com.andreesperanca.deolhonobus.mockdata.MockData
import com.andreesperanca.deolhonobus.models.BusStop
import com.andreesperanca.deolhonobus.ui.fragments.BusDetailsFragmentDirections

class BusStopAdapter : RecyclerView.Adapter<BusStopViewHolder>() {

    val mockList = MockData().listBusStop

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusStopViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvBusStopItemBinding.inflate(inflater, parent, false)
        return BusStopViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BusStopViewHolder, position: Int) {
        holder.bind(mockList[position])
    }

    override fun getItemCount(): Int = mockList.size

    inner class BusStopViewHolder(private val binding: RvBusStopItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(busStop: BusStop) {

            binding.tvBusStopName.text = binding.root.context.getString(R.string.busStopName,busStop.name)
            binding.tvAddress.text = binding.root.context.getString(R.string.address,busStop.address)
            binding.tvDetails.setOnClickListener {
                val action = BusDetailsFragmentDirections.actionBusDetailsFragmentToBusStopDetailsFragment(busStop)
                it.findNavController().navigate(action)
            }
        }
    }
}