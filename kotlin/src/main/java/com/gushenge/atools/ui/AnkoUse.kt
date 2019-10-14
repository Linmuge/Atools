package com.gushenge.atools.ui

import android.view.ViewManager
import org.jetbrains.anko.custom.ankoView


inline fun ViewManager.arcButton(init: ArcButton.() -> Unit): ArcButton {
    return ankoView({ ArcButton(it) }, theme = 0, init = init)
}

inline fun ViewManager.arcButton(text:String?): ArcButton {
    return ankoView({ ArcButton(it) }, theme = 0){
        setText(text)
    }
}
inline fun ViewManager.arcButton(text:String? ,init: ArcButton.() -> Unit): ArcButton {
    return ankoView({ ArcButton(it) }, theme = 0){
        init()
        setText(text)
    }
}


inline fun ViewManager.autoHeightImage(init: AutoHeightImage.() -> Unit): AutoHeightImage {
    return ankoView({ AutoHeightImage(it) }, theme = 0, init = init)
}

inline fun ViewManager.rollingTextView(init: RollingTextView.() -> Unit): RollingTextView {
    return ankoView({ RollingTextView(it) }, theme = 0, init = init)
}

