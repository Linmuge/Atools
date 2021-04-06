import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import com.gushenge.atools.ui.ArcButton
import com.gushenge.atools.util.ARandom
import com.gushenge.atools.util.AView

fun Context.browse(url: String, newTask: Boolean = false): Boolean {
    try {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        if (newTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
        return true
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
        return false
    }
}


fun ArcButton.initColor(): ArcButton {
    val color = ARandom.color()
    setTextColor(if (AView.isLightColor(color)) Color.BLACK else Color.WHITE)
    setBackgroundColor(color)
    return this
}

