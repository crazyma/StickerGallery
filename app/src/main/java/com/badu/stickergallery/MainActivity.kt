package com.badu.stickergallery

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showSticker()
    }

    private fun showSticker() {
        val list = listOf(StickerPagerView(this), StickerPagerView(this), StickerPagerView(this))
        val adapter = StickerPagerAdapter(list)
        stickerViewPager.adapter = adapter

        stickerViewPager.visibility = View.VISIBLE
    }
}
