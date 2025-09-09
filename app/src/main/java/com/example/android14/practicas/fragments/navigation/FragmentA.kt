package com.example.android14.practicas.fragments.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android14.R
import com.example.android14.databinding.ActivityFragmentNavigationBinding
import com.example.android14.databinding.FragmentABinding


class FragmentA : Fragment() {


    private lateinit var binding: FragmentABinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentABinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setTitle("Login")

            binding.btnRegister.setOnClickListener {
                val name = binding.etName.text.toString()
                val email = binding.etEmail.text.toString()

                if (name.isNotEmpty() && email.isNotEmpty()) {
                    parentFragmentManager.beginTransaction().addToBackStack("Fragment B")
                        .replace(R.id.fragmentContainer, FragmentB.newInstance(name, email)).commit()
                } else{
                    Toast.makeText(requireContext(), "Ingresa la informacion", Toast.LENGTH_SHORT).show()
                }
            }

            binding.btnOpenRecover.setOnClickListener {
                val name = binding.etName.text.toString()
                parentFragmentManager.beginTransaction().addToBackStack("")
                    .replace(R.id.fragmentContainer, FragmentB.newInstance(name)).commit()
            }


        }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentA()
    }
}