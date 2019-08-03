package pe.joshluque.papayin

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import pe.joshluque.papayin.data.entity.Movie
import pe.joshluque.papayin.data.network.ApiStatus
import pe.joshluque.papayin.movielist.MovieGridAdapter
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import android.widget.TextView
import pe.joshluque.papayin.data.entity.Gender


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


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            ).into(imgView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Movie>?) {
    val adapter = recyclerView.adapter as MovieGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("gender")
fun setGender(view: TextView, genders: List<Int>) {
    val genderList = Gender.getGenders(genders).map {
        it.value
    }
    view.text = String.format("genders : %s", genderList.joinToString(", "))
}