package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.lifecycleOwner = this

        shoeListViewModel.shoeList.observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {
                loadShoes(it)
            }
        })
        binding.showListScreenFloatingActionBtn.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListToAddShoe())
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun loadShoes(shoeList: List<Shoe>?) {
        context?.let {
            val shoeContainer = binding.shoeListLayout
            shoeList?.forEach { shoe ->
                val shoeLayout = ShoeLayout(it)
                shoeLayout.createShoe(shoe)
                shoeContainer.addView(shoeLayout)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}