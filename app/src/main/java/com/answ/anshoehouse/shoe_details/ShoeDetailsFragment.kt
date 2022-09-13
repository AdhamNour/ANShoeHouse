package com.answ.anshoehouse.shoe_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.answ.anshoehouse.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment : Fragment() {
    private lateinit var binding:FragmentShoeDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }
}