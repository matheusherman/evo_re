package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class KeyPosition extends Keys {
    private int mFrame;
    private String mTarget;
    private String mTransitionEasing = null;
    private float mPercentWidth = Float.NaN;
    private float mPercentHeight = Float.NaN;
    private float mPercentX = Float.NaN;
    private float mPercentY = Float.NaN;
    private Type mPositionType = Type.CARTESIAN;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum Type {
        CARTESIAN,
        SCREEN,
        PATH
    }

    public int getFrames() {
        return this.mFrame;
    }

    public float getPercentHeight() {
        return this.mPercentHeight;
    }

    public float getPercentWidth() {
        return this.mPercentWidth;
    }

    public float getPercentX() {
        return this.mPercentX;
    }

    public float getPercentY() {
        return this.mPercentY;
    }

    public Type getPositionType() {
        return this.mPositionType;
    }

    public String getTarget() {
        return this.mTarget;
    }

    public String getTransitionEasing() {
        return this.mTransitionEasing;
    }

    public void setFrames(int i10) {
        this.mFrame = i10;
    }

    public void setPercentHeight(float f10) {
        this.mPercentHeight = f10;
    }

    public void setPercentWidth(float f10) {
        this.mPercentWidth = f10;
    }

    public void setPercentX(float f10) {
        this.mPercentX = f10;
    }

    public void setPercentY(float f10) {
        this.mPercentY = f10;
    }

    public void setPositionType(Type type) {
        this.mPositionType = type;
    }

    public void setTarget(String str) {
        this.mTarget = str;
    }

    public void setTransitionEasing(String str) {
        this.mTransitionEasing = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("KeyPositions:{\n");
        append(sb2, TypedValues.AttributesType.S_TARGET, this.mTarget);
        sb2.append("frame:");
        sb2.append(this.mFrame);
        sb2.append(",\n");
        if (this.mPositionType != null) {
            sb2.append("type:'");
            sb2.append(this.mPositionType);
            sb2.append("',\n");
        }
        append(sb2, "easing", this.mTransitionEasing);
        append(sb2, "percentX", this.mPercentX);
        append(sb2, "percentY", this.mPercentY);
        append(sb2, "percentWidth", this.mPercentWidth);
        append(sb2, "percentHeight", this.mPercentHeight);
        sb2.append("},\n");
        return sb2.toString();
    }

    public KeyPosition(String str, int i10) {
        this.mTarget = null;
        this.mFrame = 0;
        this.mTarget = str;
        this.mFrame = i10;
    }
}
