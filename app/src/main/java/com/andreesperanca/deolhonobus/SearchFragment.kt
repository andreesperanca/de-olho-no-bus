package com.andreesperanca.deolhonobus

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.andreesperanca.deolhonobus.adapters.SearchAdapter
import com.andreesperanca.deolhonobus.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private val binding by lazy {
        FragmentSearchBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rgSearchType.setOnCheckedChangeListener { group, checkedId ->
            if (binding.busStop.id == checkedId) {
                binding.rgSearchBusStopSelected.visibility = View.VISIBLE
                binding.rgSearchLineSelected.visibility = View.INVISIBLE
            } else {
                binding.rgSearchBusStopSelected.visibility = View.INVISIBLE
                binding.rgSearchLineSelected.visibility = View.VISIBLE
            }
        }

        val divisor = DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL)
        binding.rvSearchFragment.adapter = SearchAdapter()
        binding.rvSearchFragment.layoutManager = LinearLayoutManager(requireContext(), VERTICAL, false)
        binding.rvSearchFragment.addItemDecoration(divisor)

    }
}