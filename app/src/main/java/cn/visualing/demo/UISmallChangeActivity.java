package cn.visualing.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.squareup.picasso.Picasso;

import cn.visualing.JZVideoPlayer;
import cn.visualing.JZVideoPlayerStandard;
import cn.visualing.demo.CustomView.JZVideoPlayerStandardAutoCompleteAfterFullscreen;
import cn.visualing.demo.CustomView.JZVideoPlayerStandardShowShareButtonAfterFullscreen;
import cn.visualing.demo.CustomView.JZVideoPlayerStandardShowTextureViewAfterAutoComplete;
import cn.visualing.demo.CustomView.JZVideoPlayerStandardShowTitleAfterFullscreen;

/**
 * Created by Nathen on 16/7/31.
 */
public class UISmallChangeActivity extends AppCompatActivity {
    JZVideoPlayerStandardShowShareButtonAfterFullscreen jzVideoPlayerStandardWithShareButton;
    JZVideoPlayerStandardShowTitleAfterFullscreen jzVideoPlayerStandardShowTitleAfterFullscreen;
    JZVideoPlayerStandardShowTextureViewAfterAutoComplete jzVideoPlayerStandardShowTextureViewAfterAutoComplete;
    JZVideoPlayerStandardAutoCompleteAfterFullscreen jzVideoPlayerStandardAutoCompleteAfterFullscreen;

    JZVideoPlayerStandard jzVideoPlayerStandard_1_1, jzVideoPlayerStandard_16_9;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("SmallChangeUI");
        setContentView(R.layout.activity_ui_small_change);

        jzVideoPlayerStandardWithShareButton = (JZVideoPlayerStandardShowShareButtonAfterFullscreen) findViewById(R.id.custom_videoplayer_standard_with_share_button);
        jzVideoPlayerStandardWithShareButton.setUp(VideoConstant.videoUrlList[3], JZVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "嫂子想呼吸");
        Picasso.with(this)
                .load(VideoConstant.videoThumbList[3])
                .into(jzVideoPlayerStandardWithShareButton.thumbImageView);


        jzVideoPlayerStandardShowTitleAfterFullscreen = (JZVideoPlayerStandardShowTitleAfterFullscreen) findViewById(R.id.custom_videoplayer_standard_show_title_after_fullscreen);
        jzVideoPlayerStandardShowTitleAfterFullscreen.setUp(VideoConstant.videoUrlList[4], JZVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "嫂子想摇头");
        Picasso.with(this)
                .load(VideoConstant.videoThumbList[4])
                .into(jzVideoPlayerStandardShowTitleAfterFullscreen.thumbImageView);

        jzVideoPlayerStandardShowTextureViewAfterAutoComplete = (JZVideoPlayerStandardShowTextureViewAfterAutoComplete) findViewById(R.id.custom_videoplayer_standard_show_textureview_aoto_complete);
        jzVideoPlayerStandardShowTextureViewAfterAutoComplete.setUp(VideoConstant.videoUrlList[5], JZVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "嫂子想旅行");
        Picasso.with(this)
                .load(VideoConstant.videoThumbList[5])
                .into(jzVideoPlayerStandardShowTextureViewAfterAutoComplete.thumbImageView);

        jzVideoPlayerStandardAutoCompleteAfterFullscreen = (JZVideoPlayerStandardAutoCompleteAfterFullscreen) findViewById(R.id.custom_videoplayer_standard_aoto_complete);
        jzVideoPlayerStandardAutoCompleteAfterFullscreen.setUp(VideoConstant.videoUrls[0][1], JZVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "嫂子没来");
        Picasso.with(this)
                .load(VideoConstant.videoThumbs[0][1])
                .into(jzVideoPlayerStandardAutoCompleteAfterFullscreen.thumbImageView);

        jzVideoPlayerStandard_1_1 = (JZVideoPlayerStandardAutoCompleteAfterFullscreen) findViewById(R.id.jz_videoplayer_1_1);
        jzVideoPlayerStandard_1_1.setUp(VideoConstant.videoUrls[0][1], JZVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "嫂子有事吗");
        Picasso.with(this)
                .load(VideoConstant.videoThumbs[0][1])
                .into(jzVideoPlayerStandard_1_1.thumbImageView);
        jzVideoPlayerStandard_1_1.widthRatio = 1;
        jzVideoPlayerStandard_1_1.heightRatio = 1;

        jzVideoPlayerStandard_16_9 = (JZVideoPlayerStandardAutoCompleteAfterFullscreen) findViewById(R.id.jz_videoplayer_16_9);
        jzVideoPlayerStandard_16_9.setUp(VideoConstant.videoUrls[0][1], JZVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "嫂子来不了");
        Picasso.with(this)
                .load(VideoConstant.videoThumbs[0][1])
                .into(jzVideoPlayerStandard_16_9.thumbImageView);
        jzVideoPlayerStandard_16_9.widthRatio = 16;
        jzVideoPlayerStandard_16_9.heightRatio = 9;
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
