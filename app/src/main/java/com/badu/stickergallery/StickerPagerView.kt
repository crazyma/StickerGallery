package com.badu.stickergallery

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_sticker.view.*

/**
 * Created by badu on 2018/3/18.
 */

class StickerPagerView @JvmOverloads  constructor(context: Context, private val attrs: AttributeSet? = null): RecyclerView(context) {

    init {

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        layoutManager = GridLayoutManager(context, SPAN_COUNT)
        adapter = StickerAdapter(context)
    }

    class StickerAdapter(private val context: Context): RecyclerView.Adapter<StickerViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): StickerViewHolder {
            val layoutInflater = LayoutInflater.from(context)

            return StickerViewHolder(
                    layoutInflater.inflate(StickerViewHolder.LAYOUT_ID, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return 17
        }

        override fun onBindViewHolder(holder: StickerViewHolder?, position: Int) {
            holder!!.bindTo(context)
        }

    }

    class StickerViewHolder(view: View): RecyclerView.ViewHolder(view){

        fun bindTo(context: Context){
            GlideApp.with(context)
                    .load("https://png.icons8.com/color/120/mario.png")
                    .placeholder(R.mipmap.ic_launcher)
                    .into(itemView.stickerImageButton)

        }

        companion object {
            const val LAYOUT_ID = R.layout.item_sticker
        }

    }

    companion object {
        const val SPAN_COUNT = 4
    }

}