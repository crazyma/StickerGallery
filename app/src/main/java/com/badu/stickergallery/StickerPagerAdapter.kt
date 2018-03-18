package com.badu.stickergallery

import android.support.v4.view.PagerAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 * Created by badu on 2018/3/18.
 */
class StickerPagerAdapter(private var pageList: List<RecyclerView>) : PagerAdapter() {

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return o == view
    }

    override fun getCount(): Int {
        return pageList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(pageList[position])
        return pageList[position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, o: Any) {
        container.removeView(o as View)
    }
}