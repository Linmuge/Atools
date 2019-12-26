package com.gushenge.atools.util.keyboard

/**
 * Created by Gushenge on 2019/12/26.
 */
interface OnKeyboardStateChangeListener {
    /**
     * 监听键盘状态变化监听
     * @param isShow 是否显示
     * @param heightDifference 界面变化的高度差
     */
    fun onKeyboardStateChange(isShow: Boolean, heightDifference: Int)
}