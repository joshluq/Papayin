package pe.joshluque.papayin

import android.view.View
import androidx.databinding.BindingAdapter
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import pe.joshluque.papayin.data.network.ApiStatus

@BindingAdapter("startAnimationWhenLoading")
fun startAnimationWhenLoading(view: LottieAnimationView, status: ApiStatus?) {
    when (status) {
        ApiStatus.LOADING -> {
            view.apply {
                repeatMode = LottieDrawable.RESTART
                playAnimation()
                visibility = View.VISIBLE
            }
        }
        else -> {
            view.apply {
                cancelAnimation()
                visibility = View.GONE
            }
        }
    }
}

@BindingAdapter("hideWhenLoading")
fun hideWhenLoading(view: View, status: ApiStatus?) {
    when (status) {
        ApiStatus.LOADING -> view.visibility = View.GONE
        else -> view.visibility = View.VISIBLE
    }
}