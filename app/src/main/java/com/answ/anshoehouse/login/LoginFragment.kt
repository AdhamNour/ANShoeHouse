package com.answ.anshoehouse.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.answ.anshoehouse.R
import com.answ.anshoehouse.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel
        binding.emailTextEdit.doOnTextChanged { text, start, before, count ->
            viewModel.setEmail(text.toString())
        }
        binding.passwordEditText.doOnTextChanged { text, start, before, count ->
            viewModel.setPassword(
                text.toString()
            )
        }
        binding.loginButton.setOnClickListener {
            if (viewModel.login())
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToOnBoarding())
            else
                Toast.makeText(
                    requireContext(), "Login Failed", Toast.LENGTH_SHORT
                ).show()
        }
        return binding.root
    }
}