package com.answ.anshoehouse.shoedetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
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
        NavigationUI.setupActionBarWithNavController(this.activity as AppCompatActivity, findNavController())
        binding.vm= viewModel
        binding.save.setOnClickListener {
            if(viewModel.shoe.value!=null) {
                Log.d("ShoeDetails",viewModel.shoe.value.toString())
                sharedViewModel.addShoe(viewModel.shoe.value!!)
                findNavController().popBackStack()
            }
        }
        return binding.root
    }




}