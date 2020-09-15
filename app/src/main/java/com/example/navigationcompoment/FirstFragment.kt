package com.example.navigationcompoment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.appchat.ui.base.BaseFragment
import kotlinx.android.synthetic.main.first_fragment.view.*

class FirstFragment : BaseFragment() {
    var navController: NavController? = null
    var btnClick: Button? = null

    override fun onCreateView(): Int {
        return R.layout.first_fragment
    }

    override fun init() {

    }

    override fun eventHandle() {
        mView.btnThird.setOnClickListener {
            bundleOf("KEY1" to "Hello").also {
                findNavController().navigate(
                    R.id.ac_third, it
                )

            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

}