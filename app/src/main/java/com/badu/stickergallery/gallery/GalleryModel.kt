package com.badu.stickergallery.gallery

/**
 * Created by david on 2018/3/18.
 */
data class GalleryModel(private val stickerModelList: List<StickerModel>) {

    fun getStickerUrlList(): List<List<String>> {
        val list = mutableListOf<List<String>>()
        stickerModelList.forEach {
            list.add(it.stickerUrlList)
        }

        return list
    }
}