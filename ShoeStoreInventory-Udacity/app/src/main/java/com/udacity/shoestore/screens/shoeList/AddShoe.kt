package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.databinding.FragmentAddShoeBindingImpl
import com.udacity.shoestore.models.Shoe

/**
 * A simple [Fragment] subclass.
 * Use the [AddShoe.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddShoe : Fragment() {

    private lateinit var binding: FragmentAddShoeBinding
    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_shoe,
            container,
            false)
        binding.lifecycleOwner = this
        binding.shoeListingsViewModel = shoeListViewModel

        binding.addShoeScreenAddShoeBtn.setOnClickListener {
            val shoeName = binding.addShoeScreenShoeNameEt.text.toString()
            val shoeCompany = binding.addShoeScreenShoeCompanyEt.text.toString()
            val shoeSize = binding.addShoeScreenShoeSizeEt.text.toString()
            val description = binding.addShoeScreenShoeDescriptionEt.text.toString()
            if (shoeName.isNotEmpty() && shoeCompany.isNotEmpty() && shoeSize.isNotEmpty() && description.isNotEmpty()) {
                val shoeItem = Shoe(shoeName, shoeSize.toDouble(), shoeCompany, description)
                shoeListViewModel.addShoe(shoeItem)
                findNavController().navigate(AddShoeDirections.actionAddShoeToShoeList())
            }
        }

        binding.addShoeScreenCancelBtn.setOnClickListener {
            findNavController().navigate(AddShoeDirections.actionAddShoeToShoeList())
        }


        return binding.root
    }

}