package com.andreesperanca.deolhonobus.ui.fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.andreesperanca.deolhonobus.adapters.SearchAdapter
import com.andreesperanca.deolhonobus.databinding.FragmentSearchBinding
import com.andreesperanca.deolhonobus.util.hideKeyBoard
import com.andreesperanca.deolhonobus.util.hideKeyboard

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
        configureAdapter()

        binding.btnSearch.setOnClickListener {
            if (binding.lines.isChecked) {
                //FAZER BUSCA POR LINHA E NÚMERO
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
    private fun configureAdapter() {
        val divisor = DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL)
        binding.rvSearchFragment.adapter = SearchAdapter()
        binding.rvSearchFragment.layoutManager = LinearLayoutManager(requireContext(), VERTICAL, false)
        binding.rvSearchFragment.addItemDecoration(divisor)
    }
}