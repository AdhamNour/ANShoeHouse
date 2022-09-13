package com.answ.anshoehouse.shoedetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.answ.anshoehouse.R
import com.answ.anshoehouse.databinding.FragmentShoeDetailsBinding
import com.answ.anshoehouse.shoelist.ShoeListViewModel

class ShoeDetailsFragment : Fragment() {

    private  val viewModel: ShoeDetailsViewModel by viewModels()
    private val sharedViewModel:ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailsBinding;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeDetailsBinding.inflate(inflater, container, false)
        binding.vm= viewModel
        binding.save.setOnClickListener {
            viewModel.shoe.value?.let { it1 -> sharedViewModel.addShoe(it1) }
        }
        return binding.root
    }



}