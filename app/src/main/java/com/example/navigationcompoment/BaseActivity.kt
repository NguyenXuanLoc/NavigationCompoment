package com.example.appchat.ui.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.navigationcompoment.R
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseActivity : AppCompatActivity() {
    open val self by lazy { this }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentView()?.run {
            setContentView(R.layout.activity_base)
            layoutInflater.inflate(this, frlBase)
        }
        getExtra()
        init()
        eventHandle()
    }

    abstract fun contentView(): Int
    abstract fun init()
    abstract fun eventHandle()
    open fun getExtra() {}

    // Hide base toolbar
    protected fun hideToolbarBase() {
        toolbarBase.visibility = View.GONE
    }



    // Show base toolbar
    protected fun showToolbarBase() {
        toolbarBase.visibility = View.VISIBLE
    }

    // Using toolbar
    protected fun showTitle(title: Any? = null) {
        // Set title
        when (title) {
            is CharSequence -> toolbarBase.title = title
            is String -> toolbarBase.title = title
            is Int -> toolbarBase.title = getString(title)
        }
    }



    // Show Back icon
    protected fun enableHomeAsUp(
        toolbar: Toolbar = toolbarBase,
        backArrowColorResId: Int? = null,
        up: () -> Unit
    ) {
        toolbar.run {
            navigationIcon = backArrowColorResId?.run {
                DrawerArrowDrawable(self).apply {
                    progress = 1f
                    color = ContextCompat.getColor(self, backArrowColorResId)
                }
            } ?: DrawerArrowDrawable(self).apply { progress = 1f }
            setNavigationOnClickListener { up() }
        }
    }

}