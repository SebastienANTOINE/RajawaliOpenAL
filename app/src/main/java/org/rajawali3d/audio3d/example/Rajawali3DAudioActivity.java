package org.rajawali3d.audio3d.example;

import android.app.Activity;
import android.os.Bundle;

import org.rajawali3d.renderer.RajawaliRenderer;
import org.rajawali3d.surface.RajawaliSurfaceView;

public class Rajawali3DAudioActivity extends Activity {
    private RajawaliSurfaceView mSurfaceView;
    private RajawaliRenderer mRenderer;
    private Audio3DManager mAudioManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mAudioManager = Audio3DManager.getInstance(this);

        mRenderer = new Rajawali3DAudioRenderer(this);
        mSurfaceView = (RajawaliSurfaceView) findViewById(R.id.rajawaliSurface);
        mSurfaceView.setSurfaceRenderer(mRenderer);
    }

    @Override
    public void onResume() {
        super.onResume();
        mAudioManager.onResume();
    }

    @Override
    public void onPause() {
        mAudioManager.onPause();
        super.onPause();
    }

    @Override
    public void onStop() {
        mAudioManager.onDestroy();
        super.onStop();
    }
}
