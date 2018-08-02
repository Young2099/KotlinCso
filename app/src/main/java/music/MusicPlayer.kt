package music

import android.media.MediaPlayer
import java.util.*

/**
 * created by yf on 2018/8/2.
 */
class MusicPlayer {

    var isPlaying: Boolean = false //是否正在播放
    var currentIndex: Int = 0 //播放的位置
    var currentProgress = 0 //播放进度
    lateinit var mMediaPlayer: MediaPlayer //播放器
    lateinit var mPlayerListener: PlayerListener //控制器
    lateinit var timer: Timer //计时器
    var mTotalTime = 0 //播放时间

}