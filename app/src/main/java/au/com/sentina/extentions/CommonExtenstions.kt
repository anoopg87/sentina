package au.com.sentina.extentions

import android.databinding.BindingAdapter
import android.databinding.BindingConversion
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.lang.Exception

fun ViewGroup.inflate(layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(this.context).inflate(layoutRes, this, attachToRoot)
}

@BindingAdapter("android:src")
fun loadImage(view: ImageView, url: String) {
    Picasso.get()
            .load(url)
            .resize(480, 320)
            .networkPolicy(NetworkPolicy.OFFLINE)
            .into(view, object : Callback {
                override fun onSuccess() = Unit
                override fun onError(e: Exception?) {
                    Picasso.get().load(url).into(
                            view,
                            object : Callback {
                                override fun onError(e: Exception?) = Unit
                                override fun onSuccess() = Unit
                            }
                    )
                }
            })
}


@BindingAdapter("android:profile")
fun loadImage(view: CircleImageView, url: String) {
    Picasso.get()
            .load(url)
            .resize(80, 80)
            .networkPolicy(NetworkPolicy.OFFLINE)
            .into(view, object : Callback {
                override fun onSuccess() = Unit
                override fun onError(e: Exception?) {
                    Picasso.get().load(url).into(view, object : Callback {
                        override fun onError(e: Exception?) = Unit
                        override fun onSuccess() = Unit
                    })
                }
            })
}


@BindingConversion
fun convertBooleanToVisibility(visible: Boolean): Int {
    return if (visible) View.VISIBLE else View.GONE
}

@BindingConversion
fun convertPriceToString(price: Double): String {
    return "$" + String.format("%.0f", price)
}





