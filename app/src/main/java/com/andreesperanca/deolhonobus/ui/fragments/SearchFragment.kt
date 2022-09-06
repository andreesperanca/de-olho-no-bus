package com.andreesperanca.deolhonobus.ui.fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.andreesperanca.deolhonobus.adapters.SearchAdapter
import com.andreesperanca.deolhonobus.databinding.FragmentSearchBinding
import com.andreesperanca.deolhonobus.ui.viewmodels.SearchViewModel
import com.andreesperanca.deolhonobus.util.Resource
import com.andreesperanca.deolhonobus.util.hideKeyBoard
import com.andreesperanca.deolhonobus.util.hideKeyboard
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private val binding by lazy {
        FragmentSearchBinding.inflate(layoutInflater)
    }

    private val viewModel: SearchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.seachResult.observe(viewLifecycleOwner) {
            when(it) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    val divisor = DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL)
                    binding.rvSearchFragment.adapter = SearchAdapter(it.data!!)
                    binding.rvSearchFragment.layoutManager = LinearLayoutManager(requireContext(), VERTICAL, false)
                    binding.rvSearchFragment.addItemDecoration(divisor)
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        }

        viewModel.authResult.observe(viewLifecycleOwner) {
            when(it) {
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
                //FAZER BUSCA POR LINHA E NÚMERO
                viewModel.getAuthInApi()
                viewModel.getBusLines(binding.searchBar.text.toString())
                Log.i("teste", "FAZER REQUISIÇÃO DE LINHA POR NÚMERO E LINHA")
            } else {
                when (true) {
                    binding.rbLineName.isChecked -> kotlin.run {
                        //FAZER REQUISIÇÃO DE PARADA POR NÚMERO DE LINHA
                        Log.i("teste", "FAZER REQUISIÇÃO DE PARADA POR NÚMERO DE LINHA")
                    }
                    binding.rbBusStop.isChecked -> kotlin.run {
                        //FAZER REQUISIÇÃO POR NOME DE PARADA
                        Log.i("teste", "FAZER REQUISIÇÃO POR NOME DE PARADA")
                    }
                    binding.rbHall.isChecked -> kotlin.run {
                        Log.i(
                            "teste",
                            "FAZER REQUISIÇÃO POR CÓDIGO DE CORREDOR"
                        )
                    }
                    else -> kotlin.run {
                        //FAZER REQUISIÇÃO POR CÓDIGO DE CORREDOR
                        Log.i("teste", "Nenhuma opção selecionada")
                    }
                }
            }
            hideKeyboard(binding.root)
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getAuthInApi()
    }

    override fun onResume() {
        super.onResume()

    }

//    private fun configureAdapter() {
//        val divisor = DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL)
//        binding.rvSearchFragment.adapter = SearchAdapter()
//        binding.rvSearchFragment.layoutManager = LinearLayoutManager(requireContext(), VERTICAL, false)
//        binding.rvSearchFragment.addItemDecoration(divisor)
//    }
}