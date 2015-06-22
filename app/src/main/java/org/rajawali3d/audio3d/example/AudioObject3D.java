package org.rajawali3d.audio3d.example;

import android.util.Log;

import org.rajawali3d.Object3D;
import org.rajawali3d.cameras.Camera;
import org.rajawali3d.materials.Material;
import org.rajawali3d.math.Matrix4;
import org.rajawali3d.math.vector.Vector3;

import java.io.IOException;

public class AudioObject3D extends Object3D {
    private Audio3D mAudio;
    private Vector3 mTransformedPosition;
    private Vector3 mDistance = new Vector3();
    private String mSoundAsset;

    public AudioObject3D(String soundAsset) {
        super();
        mTransformedPosition = new Vector3();
        mSoundAsset = soundAsset;
        init();
    }

    public void init() {
        Audio3DManager manager = Audio3DManager.getInstance();

        try {
            mAudio = manager.addSound(mSoundAsset);
        } catch (IOException e) {
            Log.e("Audio3D", "Error loading 3D audio: " + mSoundAsset + " ... " + e);
            return;
        }

        if (mAudio != null) {
            mAudio.play(true);
        } else {
            Log.e("Audio3D", "Error loading 3D audio: " + mSoundAsset);
        }
    }

    @Override
    public void render(Camera camera, final Matrix4 vpMatrix, final Matrix4 projMatrix, final Matrix4 vMatrix,
                       final Matrix4 parentMatrix, Material sceneMaterial) {
        if (mAudio != null) {
            mTransformedPosition.setAll(mPosition);
            mTransformedPosition.multiply(mMVMatrix);
            mAudio.setPosition(mTransformedPosition);
        }

        super.render(camera, vpMatrix, projMatrix, vMatrix, parentMatrix, sceneMaterial);

    }
}