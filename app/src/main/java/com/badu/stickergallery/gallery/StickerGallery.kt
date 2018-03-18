package com.badu.stickergallery.gallery

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
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
) : RelativeLayout(context, attrs) {

    var galleryModel: GalleryModel? = null
        set(value) {
            if(value != null) {
                val stickerUrlList = value.getStickerUrlList()
                val list = mutableListOf<RecyclerView>()
                stickerUrlList.forEach {
                    list.add(StickerPagerView(context!!, it))
                }
                val adapter = StickerPagerAdapter(list)
                stickerViewPager.adapter = adapter
            }

            field = value
        }

    init {
        inflateLayout()
    }

    private fun inflateLayout() {
        inflate(context!!, R.layout.layout_sticker_gallery, this)
    }

}