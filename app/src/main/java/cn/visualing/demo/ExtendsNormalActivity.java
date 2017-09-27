package cn.visualing.demo;

import android.app.Activity;
import android.os.Bundle;

import com.squareup.picasso.Picasso;

import cn.visualing.JZVideoPlayer;
import cn.visualing.JZVideoPlayerStandard;

/**
 * Created by Nathen on 2017/9/19.
 */

public class ExtendsNormalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extends_normal);
        JZVideoPlayerStandard jzVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
        jzVideoPlayerStandard.setUp(VideoConstant.videoUrlList[0]
                , JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "嫂子不信");
        Picasso.with(this)
                .load(VideoConstant.videoThumbList[0])
                .into(jzVideoPlayerStandard.thumbImageView);
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
