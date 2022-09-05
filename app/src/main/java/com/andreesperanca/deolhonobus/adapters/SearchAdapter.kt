package com.andreesperanca.deolhonobus.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.andreesperanca.deolhonobus.R
import com.andreesperanca.deolhonobus.SearchFragmentDirections
import com.andreesperanca.deolhonobus.adapters.SearchAdapter.*
import com.andreesperanca.deolhonobus.databinding.RvBusItemBinding
import com.andreesperanca.deolhonobus.mockdata.MockData
import com.andreesperanca.deolhonobus.models.BusLine

class SearchAdapter : RecyclerView.Adapter<SearchViewHolder>() {

    val mockList = MockData().listLines

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvBusItemBinding.inflate(inflater, parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(mockList[position])
    }

    override fun getItemCount(): Int = mockList.size

    inner class SearchViewHolder(private val binding: RvBusItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(busLine: BusLine) {
            if (busLine.direction == 1) {
                binding.tvOrigin.text = binding.root.context.getString(R.string.origin,busLine.mainTerminal)
                binding.tvDestination.text = binding.root.context.getString(R.string.destination,busLine.secondaryTerminal)
            } else {
                binding.tvOrigin.text = binding.root.context.getString(R.string.origin,busLine.secondaryTerminal)
                binding.tvDestination.text = binding.root.context.getString(R.string.destination,busLine.mainTerminal)
            }
            binding.tvNumberLine.text = binding.root.context.getString(R.string.idBus,busLine.id.toString())

            binding.tvDetails.setOnClickListener {
                val action = SearchFragmentDirections.actionSearchFragmentToBusDetailsFragment(busLine)
                it.findNavController().navigate(action)

            }
        }

    }
}