package com.andreesperanca.deolhonobus.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.andreesperanca.deolhonobus.adapters.BusStopAdapter
import com.andreesperanca.deolhonobus.adapters.BusLineAdapter
import com.andreesperanca.deolhonobus.databinding.FragmentSearchBinding
import com.andreesperanca.deolhonobus.ui.viewmodels.SearchViewModel
import com.andreesperanca.deolhonobus.util.Resource
import com.andreesperanca.deolhonobus.util.hideKeyboard
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private val binding by lazy {
        FragmentSearchBinding.inflate(layoutInflater)
    }
    private val adapter by lazy {
        BusLineAdapter()
    }

    private val adapterBusStop by lazy {
        BusStopAdapter()
    }

    private val viewModel: SearchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchBusStopWithBusLineCode.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    configureBusStopAdapter(adapterBusStop)
                    adapterBusStop.updateList(it.data)
                    binding.progressBar.visibility = View.INVISIBLE
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        }

        viewModel.fetchBusStopWithHallCode.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    configureBusStopAdapter(adapterBusStop)
                    adapterBusStop.updateList(it.data)
                    binding.progressBar.visibility = View.INVISIBLE
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        }

        viewModel.fetchBusStopWithNameOrAddress.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    configureBusStopAdapter(adapterBusStop)
                    adapterBusStop.updateList(it.data)
                    binding.progressBar.visibility = View.INVISIBLE
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        }

        viewModel.seachResult.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    configureBusLineAdapter(adapter)
                    adapter.updateList(it.data)
                    binding.progressBar.visibility = View.INVISIBLE
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        }

        viewModel.authResult.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    Toast.makeText(requireContext(), it.data, Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility = View.INVISIBLE
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }

        }

        binding.rgSearchType.setOnCheckedChangeListener { group, checkedId ->
            if (binding.busStop.id == checkedId) {
                binding.rgSearchBusStopSelected.visibility = View.VISIBLE
                binding.rgSearchLineSelected.visibility = View.INVISIBLE
            } else {
                binding.rgSearchBusStopSelected.visibility = View.INVISIBLE
                binding.rgSearchLineSelected.visibility = View.VISIBLE
            }
        }

        binding.btnSearch.setOnClickListener {
            if (binding.lines.isChecked) {
                viewModel.getAuthInApi()
                viewModel.getBusLines(binding.searchBar.text.toString())
            } else {
                when (true) {
                    binding.rbLineName.isChecked -> run { viewModel.getBusStopWithBusLineCode(binding.searchBar.text.toString()) }
                    binding.rbBusStop.isChecked -> run { viewModel.getBusStopWithAddressOrName(binding.searchBar.text.toString()) }
                    else -> run { viewModel.getBusStopWithHallCode(binding.searchBar.text.toString()) }
                }
            }
            hideKeyboard(binding.root)
        }
    }

    private fun configureBusLineAdapter(adapter: BusLineAdapter) {
        val divisor = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        binding.rvSearchFragment.adapter = adapter
        binding.rvSearchFragment.layoutManager =
            LinearLayoutManager(requireContext(), VERTICAL, false)
        binding.rvSearchFragment.addItemDecoration(divisor)
    }

    private fun configureBusStopAdapter(adapter: BusStopAdapter) {
        val divisor = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        binding.rvSearchFragment.adapter = adapter
        binding.rvSearchFragment.layoutManager =
            LinearLayoutManager(requireContext(), VERTICAL, false)
        binding.rvSearchFragment.addItemDecoration(divisor)
    }

}
