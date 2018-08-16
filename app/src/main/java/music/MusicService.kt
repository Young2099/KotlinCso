package music

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder

/**
 * created by yf on 2018/8/2.
 */
class MusicService:Service(),MediaPlayer.OnPreparedListener {
    override fun onPrepared(mp: MediaPlayer?) {

    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    private val binder: IBinder = MyBinder()

    inner class MyBinder : Binder() {
        fun startPlay() {

        }

    }
}