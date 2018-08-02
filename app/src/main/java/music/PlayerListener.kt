package music

/**
 * created by yf on 2018/8/2.
 */
interface PlayerListener{
    fun onPlay()
    fun onPause()
    fun onPlayNext()
    fun onPlayPrev()
    fun onProgressUpdate(progress:Int)
}
