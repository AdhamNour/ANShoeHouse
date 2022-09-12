package com.answ.anshoehouse.shoelist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.marginBottom
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.answ.anshoehouse.R
import com.answ.anshoehouse.databinding.FragmentShoeListBinding
import com.bumptech.glide.Glide
import java.net.URL

class ShoeListFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeListFragment()
    }

    private  val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeListBinding.inflate(inflater, container, false);
//        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        viewModel.shoesList.forEach {


            binding.items.addView(
                getShoeLinearLayout(
                    getShoeDataLinearLayout(
                        getTextView(it.name),
                        getTextView(it.price.toString())
                    ), getImageView()
                )
            )
        }
        binding.add.setOnClickListener{
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }

        return binding.root
    }

    fun getTextView(str: String): TextView {
        val textView = TextView(context)
        textView.text = str
        textView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        return textView
    }

    fun getImageView(): ImageView {
        val imageView = ImageView(context)
        imageView.layoutParams = ViewGroup.LayoutParams(300, 300);
        val circularProgressDrawable = CircularProgressDrawable(requireContext())
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 100f
        circularProgressDrawable.start()
        Glide.with(this).load(URL("https://source.unsplash.com/random/300x300/?shoe"))
            .fitCenter()
            .placeholder(circularProgressDrawable)
            .into(imageView)
        return imageView;
    }

    fun getShoeDataLinearLayout(name: TextView, price: TextView): LinearLayout {
        val linearLayout = LinearLayout(context)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.layoutParams = LinearLayout.LayoutParams(
            0,
            LinearLayout.LayoutParams.WRAP_CONTENT, 1f
        )
        linearLayout.addView(name)
        linearLayout.addView(price)
        return linearLayout
    }

    fun getShoeLinearLayout(data: LinearLayout, img: ImageView): LinearLayout {
        val linearLayout = LinearLayout(context)
        linearLayout.orientation = LinearLayout.HORIZONTAL
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
        )
        params.setMargins(10)
        linearLayout.layoutParams=params
        linearLayout.gravity = Gravity.CENTER
        linearLayout.addView(data)
        linearLayout.addView(img)
        return linearLayout
    }


}