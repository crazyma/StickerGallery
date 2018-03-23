package com.badu.stickergallery

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.badu.stickergallery.gallery.GalleryModel
import com.badu.stickergallery.gallery.StickerGallery
import com.badu.stickergallery.gallery.StickerModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), StickerGallery.OnStickerClickListener {
    override fun onStickerClicked(view: View) {
        Log.d("crazyma", "view tag : " + view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showSticker()
        setupStickerGallery()
    }

    private fun showSticker() {
        val list = listOf(StickerPagerView(this), StickerPagerView(this), StickerPagerView(this), StickerPagerView(this), StickerPagerView(this), StickerPagerView(this), StickerPagerView(this), StickerPagerView(this), StickerPagerView(this))
        val adapter = StickerPagerAdapter(this,list)
        stickerViewPager.adapter = adapter

        stickerViewPager.visibility = View.VISIBLE
        tabLayout.setupWithViewPager(stickerViewPager)
        for(i in 0 until tabLayout.tabCount){
            val tab = tabLayout.getTabAt(i)
            tab!!.customView = adapter.getTabView(i)
        }
    }

    private fun setupStickerGallery() {
        stickerGallery.stickerClickListener = this
        stickerGallery.galleryModel = createGalleryModelSample()
        stickerGallery.notifyGalleryChanged()
    }

    private fun createStickerModelSample(): StickerModel {
        val list = listOf("https://png.icons8.com/color/120/mario.png", "https://png.icons8.com/color/120/mario.png")
        val model = StickerModel(R.drawable.abc_ic_arrow_drop_right_black_24dp, stickerUrlList = list)
        return model
    }

    private fun createGalleryModelSample(): GalleryModel {
        val list = listOf(createStickerModelSample(), createStickerModelSample(), createStickerModelSample())
        val model = GalleryModel(list)
        return model
    }
}
