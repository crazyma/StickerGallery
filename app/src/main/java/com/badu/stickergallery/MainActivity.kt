package com.badu.stickergallery

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.badu.stickergallery.gallery.GalleryModel
import com.badu.stickergallery.gallery.StickerModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showSticker()
        setupStickerGallery()
    }

    private fun showSticker() {
        val list = listOf(StickerPagerView(this), StickerPagerView(this), StickerPagerView(this))
        val adapter = StickerPagerAdapter(list)
        stickerViewPager.adapter = adapter

        stickerViewPager.visibility = View.VISIBLE
    }

    private fun setupStickerGallery(){
        stickerGallery.galleryModel = createGalleryModelSample()
    }

    private fun createStickerModelSample(): StickerModel {
        val list = listOf("https://png.icons8.com/color/120/mario.png", "https://png.icons8.com/color/120/mario.png")
        val model = StickerModel(stickerUrlList = list)
        return model
    }

    private fun createGalleryModelSample(): GalleryModel {
        val list = listOf(createStickerModelSample(), createStickerModelSample(), createStickerModelSample())
        val model = GalleryModel(list)
        return model
    }
}
