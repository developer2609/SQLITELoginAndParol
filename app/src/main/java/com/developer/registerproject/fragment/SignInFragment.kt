package com.developer.registerproject.fragment

import MyRvAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.developer.registerproject.R
import com.developer.registerproject.databinding.FragmentSignInBinding
import com.developer.registerproject.db.MyDbHelper
import com.developer.registerproject.db2.MyDbHelper2
import com.developer.registerproject.db2.MyDbInterface2
import com.developer.registerproject.db2.MyListobject
import com.developer.registerproject.db2.MyObject2
import com.developer.registerproject.model.Login
import com.developer.registerproject.model.Users

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding
    private lateinit var myDbHelper: MyDbHelper

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(layoutInflater)

        myDbHelper=MyDbHelper(requireContext())

        binding.btnNewaccaunt.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment2)
        }

         binding.btnSave.setOnClickListener {


             myDbHelper.getAllUsers().forEach {
                 if (binding.edtLogin.text.toString()==it.username  ) {
                     findNavController().navigate(R.id.blankFragment)
                 } else {
                     Toast.makeText(requireContext(), "Login or parol xato", Toast.LENGTH_SHORT)
                         .show()
                 }
             }

         }







        return binding.root


    }

}