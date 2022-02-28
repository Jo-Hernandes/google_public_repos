package com.jonathas.googlepublicrepositories.commons

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun <T> Single<T>.observeOnMainThread(): Single<T> = subscribeOn(Schedulers.io()).observeOn(
    AndroidSchedulers.mainThread()
)

fun <T> Fragment.observe(liveData: LiveData<T>, action: (T) -> Unit) {
    liveData.observe(viewLifecycleOwner) { action(it) }
}


@BindingAdapter(
    value = ["imageUrl", "placeholder", "error"],
    requireAll = false
)
fun ImageView.loadImage(
    url: String?,
    placeholder: Drawable?,
    error: Drawable?,
) = Glide
    .with(context)
    .load(url)
    .apply(
        RequestOptions()
            .fitCenter()
            .placeholder(placeholder)
            .error(error)
    )
    .into(this)
