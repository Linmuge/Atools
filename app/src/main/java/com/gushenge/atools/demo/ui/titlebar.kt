package com.gushenge.atools.demo.ui

import android.app.Activity
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewManager
import android.widget.RelativeLayout
import android.widget.TextView
import com.gushenge.atools.demo.R
import com.gushenge.atools.demo.dao.GlobalKeys
import com.gushenge.atools.util.APreference
import com.gushenge.atools.util.AView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class titlebar{

    lateinit var titleT:TextView
    public lateinit var root :RelativeLayout
    lateinit var title :String
    lateinit var close:RelativeLayout
    var vis :Int = 0
    var statusBarColor by APreference(GlobalKeys.StatusBarColor,1)
    constructor(title:String, visibility: Int){
        this.vis = visibility
        this.title = title
    }
    constructor(title:String){
        this.vis = View.VISIBLE
        this.title = title
    }
    fun init(viewManager: ViewManager,activity: Activity):RelativeLayout{
        root = with(viewManager){
            relativeLayout {
                backgroundColor = statusBarColor
                fitsSystemWindows = true
                relativeLayout {
                    close = relativeLayout{
                        visibility = vis
                        onClick { activity.finish() }
                        minimumWidth = dip(45)
                        imageView(){
                            imageResource = if (AView.isLightColor(statusBarColor)) R.drawable.back_black else R.drawable.back_white

                        }.lparams(width = dip(20),height = dip(20)){
                            centerInParent()
                        }
                    }.lparams(width = dip(45),height = dip(45))
                    titleT = textView(title){
                        textColor = if (AView.isLightColor(statusBarColor)) Color.BLACK else Color.WHITE
                        textSize = 20f
                        gravity = Gravity.CENTER

                    }.lparams(height = dip(45)){
                        centerInParent()
                    }
                }.lparams(width= matchParent,height = dip(45)){
                    AView.setMargins(this@relativeLayout,0,AView.getStatusBarHeight(activity),0,0)
                }
            }
        }
        return root
    }
}