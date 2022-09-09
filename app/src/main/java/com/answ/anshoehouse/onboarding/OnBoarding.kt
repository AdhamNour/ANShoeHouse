package com.answ.anshoehouse.onboarding

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.answ.anshoehouse.R
import com.answ.anshoehouse.databinding.FragmentOnBoardingBinding
import com.bumptech.glide.Glide
import java.net.URL

class OnBoarding : Fragment() {

    companion object {
        fun newInstance() = OnBoarding()
    }

    private lateinit var binding: FragmentOnBoardingBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val circularProgressDrawable = context?.let { CircularProgressDrawable(it) }
        circularProgressDrawable!!.strokeWidth = 5f
        circularProgressDrawable!!.centerRadius = 100f
        circularProgressDrawable!!.start()
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        Glide.with(this).load(URL("https://source.unsplash.com/random/300x300/?shoe")).fitCenter()
            .placeholder(circularProgressDrawable)
            .into(binding.imageView)
        Glide.with(this).load(URL("https://source.unsplash.com/random/300x300/?shoes")).fitCenter()
            .placeholder(circularProgressDrawable)
            .into(binding.imageView1)
        Glide.with(this).load(URL("https://source.unsplash.com/random/300x400/?shoe")).fitCenter()
            .placeholder(circularProgressDrawable)
            .into(binding.imageView2)
        return binding.root
    }



}