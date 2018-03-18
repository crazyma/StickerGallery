package com.badu.stickergallery.gallery

import android.content.Context
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

    init {
        inflateLayout()
    }

    private fun inflateLayout() {
        inflate(context!!, R.layout.layout_sticker_gallery, this)

        val list = listOf(StickerPagerView(context!!), StickerPagerView(context!!), StickerPagerView(context!!))
        val adapter = StickerPagerAdapter(list)
        stickerViewPager.adapter = adapter
    }


}