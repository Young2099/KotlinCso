package music

/**
 * Created by yf on 2018/8/3.
 *    // 音乐id
private int mMusicId;
// 路径
private String mFileName;
// 名字
private String mMusicName;
// 时间
private int mMusicDuration;
// Artist
private String mMusicArtist;
// Album
private String mMusicAlbum;
// year
private String mMusicYear;
// file type
private String mFileType;
// fize size
private String mFileSize;
// path
private String mFilePath;
 */

data class Music constructor(val mMusicId:Int,
                              val mFileName:String,
                              val mMusicName:String,
                              val mMusicDuration:Int,
                              val mMusicArtist:String,
                              val mMusicAlbum:String,
                              val mMusicYear:String,
                              val mFileType:String,
                              val mFileSize:String,
                              val mFilePath:String)

