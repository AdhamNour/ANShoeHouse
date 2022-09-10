package com.answ.anshoehouse.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.answ.anshoehouse.R
import com.answ.anshoehouse.databinding.FragmentInstructionOnBoardingBinding
import com.answ.anshoehouse.databinding.FragmentOnBoardingBinding
import com.bumptech.glide.Glide
import java.net.URL

class InstructionOnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentInstructionOnBoardingBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val circularProgressDrawable = context?.let { CircularProgressDrawable(it) }
        circularProgressDrawable!!.strokeWidth = 5f
        circularProgressDrawable!!.centerRadius = 100f
        circularProgressDrawable!!.start()
        // Inflate the layout for this fragment
        binding = FragmentInstructionOnBoardingBinding.inflate(inflater, container, false);
        Glide.with(this).load(URL("https://source.unsplash.com/random/300x300/?instruction"))
            .fitCenter()
            .placeholder(circularProgressDrawable)
            .into(binding.imageView)
        Glide.with(this).load(URL("https://source.unsplash.com/random/300x300/?instruction"))
            .fitCenter()
            .placeholder(circularProgressDrawable)
            .into(binding.imageView1)
        Glide.with(this).load(URL("https://source.unsplash.com/random/300x400/?instruction"))
            .fitCenter()
            .placeholder(circularProgressDrawable)
            .into(binding.imageView2)
        binding.next.setOnClickListener {
            findNavController().navigate(InstructionOnBoardingFragmentDirections.actionInstructionOnBoardingFragment2ToShoeListFragment())
            activity?.getPreferences(Context.MODE_PRIVATE)?.edit()?.putBoolean(getString(R.string.first_time),true)?.apply();
        }
        return binding.root
    }


}