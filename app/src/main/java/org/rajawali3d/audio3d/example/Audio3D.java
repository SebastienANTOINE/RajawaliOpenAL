package org.rajawali3d.audio3d.example;

import org.pielot.openal.Buffer;
import org.pielot.openal.Source;
import org.rajawali3d.math.vector.Vector3;

public class Audio3D extends Source {
    private Vector3 mPosition;

    public Audio3D(Buffer buffer) {
        super(buffer);
        mPosition = new Vector3();
    }

    public void setPosition(Vector3 position) {
        mPosition.setAll(position);
        super.setPosition((float) position.x, (float) position.y, (float) position.z);
    }

    public Vector3 getPosition() {
        return mPosition;
    }
}
