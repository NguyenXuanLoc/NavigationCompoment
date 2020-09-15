package com.example.appchat.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment


@Suppress("DEPRECATION")
abstract class BaseFragment() : Fragment() {
    open lateinit var mView: View
    open val self by lazy { activity }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(onCreateView(), container, false)
        getExtras()
        init()
        eventHandle()
        return mView
    }

    abstract fun onCreateView(): Int
    abstract fun init()
    abstract fun eventHandle()
    open fun getExtras() {}
    protected fun changeNavigationIcon(icon: Int) {
        val actionBar = (activity as AppCompatActivity?)?.supportActionBar
        actionBar?.run {
            setHomeAsUpIndicator(icon)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    // Using toolbar
    protected fun showTitle(title: Any? = null, toolbar: Toolbar) {
        // Set title
        when (title) {
            is CharSequence -> toolbar.title = title
            is String -> toolbar.title = title
            is Int -> toolbar.title = getString(title)
        }
    }

}