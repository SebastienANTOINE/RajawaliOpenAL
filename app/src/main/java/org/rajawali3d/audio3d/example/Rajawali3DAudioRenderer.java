package org.rajawali3d.audio3d.example;

import android.content.Context;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;

import org.rajawali3d.animation.Animation;
import org.rajawali3d.animation.RotateAroundAnimation3D;
import org.rajawali3d.animation.RotateOnAxisAnimation;
import org.rajawali3d.animation.TranslateAnimation3D;
import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Sphere;
import org.rajawali3d.renderer.RajawaliRenderer;

public class Rajawali3DAudioRenderer extends RajawaliRenderer {
    public Rajawali3DAudioRenderer(Context context) {
        super(context);
    }

    @Override
    protected void initScene() {
        getCurrentScene().setBackgroundColor(0xeeeeee);

        DirectionalLight light = new DirectionalLight();
        light.setLookAt(0, -1, -1);
        light.enableLookAt();
        getCurrentScene().addLight(light);

        //
        // -- Audio Object 1 | Bark | Orange sphere
        //

        AudioObject3D audioObj1 = new AudioObject3D("bark");
        getCurrentScene().addChild(audioObj1);

        Sphere sphere1 = new Sphere(.2f, 16, 16);
        Material sphereMaterial1 = new Material();
        sphereMaterial1.enableLighting(true);
        sphereMaterial1.setDiffuseMethod(new DiffuseMethod.Lambert());
        sphereMaterial1.setColor(0xCC8400);
        sphereMaterial1.setAmbientColor(0x990000);
        sphere1.setMaterial(sphereMaterial1);

        audioObj1.setPosition(-10, -10, -10);
        audioObj1.addChild(sphere1);

        TranslateAnimation3D a1 = new TranslateAnimation3D(new Vector3(10, 10, 10));
        a1.setInterpolator(new AccelerateDecelerateInterpolator());
        a1.setDurationMilliseconds(5000);
        a1.setTransformable3D(audioObj1);
        a1.setRepeatMode(Animation.RepeatMode.REVERSE_INFINITE);
        getCurrentScene().registerAnimation(a1);
        a1.play();

        //
        // -- Audio Object 2 | Beep | Yellow sphere
        //

        AudioObject3D audioObj2 = new AudioObject3D("beep");
        getCurrentScene().addChild(audioObj2);

        Sphere sphere2 = new Sphere(.2f, 16, 16);
        Material sphereMaterial2 = new Material();
        sphereMaterial2.enableLighting(true);
        sphereMaterial2.setDiffuseMethod(new DiffuseMethod.Lambert());
        sphereMaterial2.setColor(0xdddd00);
        sphereMaterial2.setAmbientColor(0xffffff);
        sphere2.setMaterial(sphereMaterial2);

        audioObj2.addChild(sphere2);

        RotateAroundAnimation3D a2 = new RotateAroundAnimation3D(getCurrentCamera().getPosition(), Vector3.Axis.X, 4);
        a2.setInterpolator(new AccelerateDecelerateInterpolator());
        a2.setDurationMilliseconds(7500);
        a2.setTransformable3D(audioObj2);
        a2.setRepeatMode(Animation.RepeatMode.REVERSE_INFINITE);
        getCurrentScene().registerAnimation(a2);
        a2.play();

    }

    @Override
    public void onOffsetsChanged(float v, float v2, float v3, float v4, int i, int i2) {

    }

    @Override
    public void onTouchEvent(MotionEvent motionEvent) {

    }
}
