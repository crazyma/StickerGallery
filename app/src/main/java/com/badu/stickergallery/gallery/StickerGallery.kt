package com.badu.stickergallery.gallery

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.badu.stickergallery.R
import com.badu.stickergallery.StickerPagerAdapter
import com.badu.stickergallery.StickerPagerView
import kotlinx.android.synthetic.main.layout_sticker_gallery.view.*

/**
 * Created by badu on 2018/3/18.
 */
class StickerGallery @JvmOverloads constructor(
        context: Context,
        private val attrs: AttributeSet? = null
) : RelativeLayout(context, attrs), View.OnClickListener {

    var stickerClickListener: StickerGallery.OnStickerClickListener? = null
    var galleryModel: GalleryModel? = null

    init {
        inflateLayout()
    }

    fun notifyGalleryChanged() {
        if (galleryModel != null) {
            val stickerUrlList = galleryModel!!.getStickerUrlList()
            val list = mutableListOf<RecyclerView>()
            stickerUrlList.forEach {
                list.add(StickerPagerView(context!!, it, stickerClickListener))
            }
            val adapter = StickerPagerAdapter(context, list)
            stickerViewPager.adapter = adapter

            addStickerBarIcon(galleryModel!!)
        } else {
            stickerViewPager.adapter = null
            stickerBar.removeAllViews()
        }
    }

    override fun onClick(view: View?) {
        val index = view!!.tag as Int
        stickerViewPager.currentItem = index
    }

    private fun inflateLayout() {
        inflate(context!!, R.layout.layout_sticker_gallery, this)
    }

    private fun addStickerBarIcon(galleryModel: GalleryModel) {
        (0 until galleryModel.stickerModelList.size)
                .map {
                    ImageView(context).apply {
                        tag = it
                        setBackgroundResource(android.R.color.holo_green_light)

                        val size = resources.getDimensionPixelSize(R.dimen.bar_height)
                        layoutParams = LinearLayout.LayoutParams(size, size)

                        setImageResource(galleryModel.stickerModelList[it].iconId)
                        setOnClickListener(this@StickerGallery)
                    }
                }
                .forEach { stickerBar.addView(it) }
    }

    interface OnStickerClickListener {
        fun onStickerClicked(view: View)
    }
}