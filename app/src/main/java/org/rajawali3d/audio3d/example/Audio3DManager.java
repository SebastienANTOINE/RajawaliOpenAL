package org.rajawali3d.audio3d.example;

import android.app.Activity;

import org.pielot.openal.Buffer;
import org.pielot.openal.SoundEnv;

import java.io.IOException;

public class Audio3DManager {
    private static Audio3DManager mInstance;
    private Activity mActivity;
    private SoundEnv mSoundEnv;

    private Audio3DManager(Activity activity) {
        mSoundEnv = SoundEnv.getInstance(activity);
    }

    public static Audio3DManager getInstance(Activity activity) {
        if(mInstance == null) {
            mInstance = new Audio3DManager(activity);
        }

        mInstance.setActivity(activity);

        return mInstance;
    }

    public static Audio3DManager getInstance() {
        if(mInstance == null) {
            throw new RuntimeException("SpatialAudioManager has not been intialised with an activity");
        }

        return mInstance;
    }

    public void setActivity(Activity activity) {
        mActivity = activity;
    }

    public Audio3D addSound(String assetPath) throws IOException {
        Buffer buffer = Buffer.createFrom(mActivity, assetPath);
        Audio3D source = new Audio3D(buffer);
        return source;
    }

    public void onPause() {
        mSoundEnv.stopAllSources();
    }

    public void onResume() {

    }

    public void onDestroy() {
        mSoundEnv.stopAllSources();
        mSoundEnv.release();
        mSoundEnv = null;
    }
}
