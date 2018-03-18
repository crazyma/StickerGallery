package com.badu.stickergallery

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.badu.stickergallery.gallery.StickerGallery
import kotlinx.android.synthetic.main.item_sticker.view.*

/**
 * Created by badu on 2018/3/18.
 */

class StickerPagerView @JvmOverloads constructor(context: Context, private val attrs: AttributeSet? = null) : RecyclerView(context) {

    private var stickerUrlList: List<String>? = null
    private var stickerClickListener: StickerGallery.OnStickerClickListener? = null

    init {

    }

    constructor(context: Context, list: List<String>, listener: StickerGallery.OnStickerClickListener?) : this(context) {
        stickerUrlList = list
        stickerClickListener = listener
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        layoutManager = GridLayoutManager(context, SPAN_COUNT)
        adapter = StickerAdapter(context, stickerUrlList, stickerClickListener)
    }

    class StickerAdapter(
            private val context: Context,
            private var stickerUrlList: List<String>?,
            private val listener: StickerGallery.OnStickerClickListener?
    ) : RecyclerView.Adapter<StickerViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): StickerViewHolder {
            val layoutInflater = LayoutInflater.from(context)

            return StickerViewHolder(
                    layoutInflater.inflate(StickerViewHolder.LAYOUT_ID, parent, false)
            )
        }

        override fun getItemCount() = when (stickerUrlList) {
            null -> 0
            else -> stickerUrlList!!.size
        }

        override fun onBindViewHolder(holder: StickerViewHolder?, position: Int) {
            holder!!.bindTo(context, stickerUrlList!![position], listener)
        }

    }

    class StickerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTo(context: Context, urlString: String, listener: StickerGallery.OnStickerClickListener?) {
            GlideApp.with(context)
                    .load(urlString)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(itemView.stickerImageButton)

            itemView.stickerImageButton.setOnClickListener { view ->
                listener?.onStickerClicked(view)
            }
        }

        companion object {
            const val LAYOUT_ID = R.layout.item_sticker
        }

    }

    companion object {
        const val SPAN_COUNT = 4
    }

}