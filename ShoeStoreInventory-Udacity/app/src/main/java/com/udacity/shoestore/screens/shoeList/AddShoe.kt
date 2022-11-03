package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.models.Shoe

/**
 * A simple [Fragment] subclass.
 * Use the [AddShoe.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddShoe : Fragment() {

    private lateinit var binding: FragmentAddShoeBinding
    private val shoeListViewModel: ShoeListViewModel by activityViewModels()
    private var newShoe = Shoe()

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

        binding.newShoeItem = newShoe

        binding.addShoeScreenAddShoeBtn.setOnClickListener {
            if (newShoe.name.isNotEmpty() && newShoe.company.isNotEmpty() && newShoe.size != 0.0 && newShoe.description.isNotEmpty()) {
                shoeListViewModel.addShoe(newShoe)
                findNavController().navigate(AddShoeDirections.actionAddShoeToShoeList())
            } else {
                Toast.makeText(context, "Enter all the details and try again!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.addShoeScreenCancelBtn.setOnClickListener {
            findNavController().navigate(AddShoeDirections.actionAddShoeToShoeList())
        }


        return binding.root
    }

}