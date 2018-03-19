package au.com.sentina.extentions

import android.databinding.BindingAdapter
import android.databinding.BindingConversion
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import au.com.sentina.App
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

fun ViewGroup.inflate(layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(this.context).inflate(layoutRes, this, attachToRoot)
}

@BindingAdapter("android:src")
fun loadImage(view: ImageView, url: String) {
    val picasso: Picasso? =App.appComponent?.picasso()
    picasso?.load(url)?.resize(480, 320)?.into(view)
}


@BindingAdapter("android:profile")
fun loadImage(view: CircleImageView, url: String) {
    val picasso: Picasso? =App.appComponent?.picasso()
    picasso?.load(url)?.resize(80, 80)?.into(view)
}


@BindingConversion
fun convertBooleanToVisibility(visible: Boolean): Int {
    return if (visible) View.VISIBLE else View.GONE
}

@BindingConversion
fun convertPriceToString(price: Double): String {
    return "$" + String.format("%.0f", price)
}





