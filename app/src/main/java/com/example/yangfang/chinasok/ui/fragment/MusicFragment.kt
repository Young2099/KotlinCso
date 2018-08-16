package com.example.yangfang.chinasok.ui.fragment

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.database.Cursor
import android.os.IBinder
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import com.example.yangfang.chinasok.R
import com.example.yangfang.chinasok.util.LogUtil
import music.Music
import music.MusicService


/**
 * created by yf on 2018/8/2.
 */

class MusicFragment : BaseFragment(),View.OnClickListener {
    override fun onClick(v: View) {
        when(v.id){
            R.id.play ->{ musicService.startPlay()}
        }

    }

    private var mPlayList = mutableListOf<Music>()
    private var cursor: Cursor? = null
    override fun initView(mRootView: View?) {
    }

    override fun setLayoutId(): Int {
        return R.layout.fragment_music
    }

    private lateinit var musicService: MusicService.MyBinder

    override fun initData() {
        super.initData()
        getPlayList()
        bindServiceConnection()
        musicService = MusicService().MyBinder()

    }

    companion object {
        private const val BIND_AUTO_CREATE: Int = 11
    }

    @SuppressLint("WrongConstant")
    private fun bindServiceConnection() {
        val intent = Intent(mActivity, MusicService::class.java)
        mActivity.startService(intent)
        mActivity.bindService(intent, sc, BIND_AUTO_CREATE)
    }

    private val sc = object : ServiceConnection {
        override fun onServiceConnected(componentName: ComponentName, iBinder: IBinder) {
            musicService = (iBinder as MusicService.MyBinder)
        }

        override fun onServiceDisconnected(componentName: ComponentName) {

        }
    }

    private fun getPlayList(): List<Music>? {
        if (cursor != null) {
            cursor!!.close()
            cursor = null
        }
        cursor = mActivity.contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, arrayOf(MediaStore.Audio.Media._ID, MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DURATION, MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.ALBUM, MediaStore.Audio.Media.YEAR,
                MediaStore.Audio.Media.MIME_TYPE, MediaStore.Audio.Media.SIZE, MediaStore.Audio.Media.DATA), null, null, null)
        if (cursor == null || !cursor!!.moveToFirst()) {
            Toast.makeText(mActivity, "没有音乐", Toast.LENGTH_LONG).show()
            return mPlayList
        }
        var dex = 0
        cursor!!.moveToFirst()
        while (cursor!!.moveToNext()) {
            var fileType: String? = null
            if ("audio/mpeg" == cursor!!.getString(7).trim()) {
                fileType = "mp3"
            } else if ("audio/x-ms-wma" == cursor!!.getString(7).trim()) {
                fileType = "wma"
            }
            var filePath: String? = null
            if (cursor!!.getString(9) != null) {
                filePath = cursor!!.getString(9)

            }
            val year: String = if (cursor!!.getString(6) != null) {
                cursor!!.getString(6)

            } else {
                ""
            }

            val music = Music(dex, cursor!!.getString(1)
                    , cursor!!.getString(2), cursor!!.getInt(3), cursor!!.getString(4),
                    cursor!!.getString(5), year, fileType!!, cursor!!.getString(8), filePath!!)
            dex++
            mPlayList.add(music)
            LogUtil.e("f$music")
        }
        cursor!!.close()
        cursor = null
        return mPlayList
    }


}