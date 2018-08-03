package com.example.yangfang.chinasok.ui.fragment

import android.database.Cursor
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import com.example.yangfang.chinasok.R
import music.Music

/**
 * created by yf on 2018/8/2.
 */

class MusicFragment : BaseFragment() {
    private  var mPlayList:List<Music>? = null
    private  var cursor: Cursor? = null
    override fun initView(mRootView: View?) {
    }

    override fun setLayoutId(): Int {
        return R.layout.fragment_music
    }

    override fun initData() {
        super.initData()
        getPlayList();
    }

    private fun getPlayList(): List<Music>? {
        if(mPlayList != null){
            return mPlayList as List<Music>
        }
        if(cursor != null){
            cursor!!.close()
            cursor = null
        }
        cursor = mActivity.contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, arrayOf( MediaStore.Audio.Media._ID, MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DURATION, MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.ALBUM, MediaStore.Audio.Media.YEAR,
                MediaStore.Audio.Media.MIME_TYPE, MediaStore.Audio.Media.SIZE, MediaStore.Audio.Media.DATA),null, null,null)
        if (cursor == null || cursor!!.moveToFirst() == false) {
            Toast.makeText(mActivity, "没有音乐", Toast.LENGTH_LONG).show();
            return mPlayList;
        }

    }


}