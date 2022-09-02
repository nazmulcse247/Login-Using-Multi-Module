package com.nazmul.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.nazmul.common.utils.NetworkResult
import com.nazmul.model.UserRequest
import com.nazmul.signup.databinding.FragmentSignupBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignupFragment2 : Fragment() {

    private var _binding : FragmentSignupBinding? = null
    private val binding get() = _binding!!
    private val authViewModel by viewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignupBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignUp.setOnClickListener {

            authViewModel.registerUser(UserRequest("hoque321","hoque132@gmail.com","001144"))
            authViewModel.authLiveData.observe(viewLifecycleOwner, Observer {
                binding.progressBar.visibility = View.GONE
                when(it){
                    is NetworkResult.Success -> {
                        Toast.makeText(requireContext(),"success",Toast.LENGTH_LONG).show()
                    }
                    is NetworkResult.Error -> {

                    }
                    is NetworkResult.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            })
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}