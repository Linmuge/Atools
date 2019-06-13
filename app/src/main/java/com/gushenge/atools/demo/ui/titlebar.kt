package com.gushenge.atools.demo.ui

import android.app.Activity
import android.graphics.Color
import android.view.Gravity
import android.view.ViewManager
import android.widget.RelativeLayout
import android.widget.TextView
import com.gushenge.atools.demo.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class titlebar(var title:String,visibility1: Int){
    lateinit var close:RelativeLayout
    lateinit var titleT:TextView
    lateinit var root :RelativeLayout
    val vis = visibility1
    fun init(viewManager: ViewManager,activity: Activity):RelativeLayout{
        root = with(viewManager){
            relativeLayout {
                setBackgroundColor(resources.getColor(R.color.colorPrimary))
                close = relativeLayout(){
                    visibility = vis
                    onClick { activity.finish() }
                    minimumWidth = dip(45)
                    imageView(){
                        setImageResource(R.drawable.back)

                    }.lparams(width = dip(20),height = dip(20)){
                        centerInParent()
                    }
                }.lparams(width = dip(45),height = dip(45))
                titleT = textView(title){
                    textColor = Color.WHITE
                    textSize = sp(7).toFloat()
                    gravity = Gravity.CENTER

                }.lparams(height = dip(45)){
                    centerInParent()
                }
            }
        }
        return root
    }
}