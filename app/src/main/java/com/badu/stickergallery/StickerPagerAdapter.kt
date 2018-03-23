package com.badu.stickergallery

import android.support.v4.view.PagerAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView

/**
 * Created by badu on 2018/3/18.
 */
class StickerPagerAdapter(private val context: Context, private var pageList: List<RecyclerView>) : PagerAdapter() {

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

    override fun getPageTitle(position: Int): CharSequence? {
        return "Tab $position"
    }

    fun getTabView(position: Int): View {
        val v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null)
        val imageView = v.findViewById(R.id.tabIcon) as ImageView
        imageView.setImageResource(R.drawable.abc_ic_ab_back_material)
        return v
    }
}