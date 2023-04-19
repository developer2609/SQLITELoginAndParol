package com.developer.registerproject.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.developer.registerproject.R
import com.developer.registerproject.databinding.FragmentSignUpBinding
import com.developer.registerproject.db.MyDbHelper
import com.developer.registerproject.model.Users

class SignUpFragment : Fragment() {
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var binding:FragmentSignUpBinding


    @SuppressLint("SuspiciousIndentation", "ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSignUpBinding.inflate(layoutInflater)

        myDbHelper= MyDbHelper(requireContext())





           binding.cardSecond.setOnClickListener {
                val users=Users(
                     binding.edtName.text.toString(),
                     binding.edtPhone.text.toString(),
                      binding.edtUsername.text.toString(),
                      binding.edtPassword.text.toString()

                )

                 if (binding.edtName.text.toString().isNotEmpty() && binding.edtPhone.text.toString().isNotEmpty() && binding.edtUsername.text.toString().isNotEmpty() && binding.edtPassword.text.toString().isNotEmpty()){

                     myDbHelper.addUser(users)

                     binding.edtName.text.clear()
                     binding.edtPhone.text.clear()
                     binding.edtUsername.text.clear()
                     binding.edtPassword.text.clear()
                Toast.makeText(requireContext(), "Save", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.signInFragment2)

                 }else{
                     Toast.makeText(requireContext(), "Text is empty ", Toast.LENGTH_SHORT).show()
                 }

        }



        return binding.root
    }




}