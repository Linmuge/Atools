package com.gushenge.atools.demo.activity.util

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.gushenge.atools.demo.ui.titlebar
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.webView

class PreferenceUtilsActivity : AppCompatActivity() {

    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            titlebar("PreferenceUtils").init(viewManager = this,activity = this@PreferenceUtilsActivity)
            webView= webView {
                loadUrl("https://www.gushenge.com/article/30")
                webViewClient = object: WebViewClient() {
                    override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                        loadUrl(url)
                        return true
                    }
                }

            }
        }



    }
}
