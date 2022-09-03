package com.andreesperanca.deolhonobus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andreesperanca.deolhonobus.databinding.FragmentGmapsBinding

class GmapsFragment : Fragment() {

    private val binding by lazy {
        FragmentGmapsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root


}