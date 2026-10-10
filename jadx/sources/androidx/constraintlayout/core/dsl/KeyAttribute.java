package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class KeyAttribute extends Keys {
    private int mFrame;
    private String mTarget;
    private String mTransitionEasing;
    protected String TYPE = "KeyAttributes";
    private Fit mCurveFit = null;
    private Visibility mVisibility = null;
    private float mAlpha = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum Fit {
        SPLINE,
        LINEAR
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum Visibility {
        VISIBLE,
        INVISIBLE,
        GONE
    }

    protected void attributesToString(StringBuilder sb2) {
        append(sb2, TypedValues.AttributesType.S_TARGET, this.mTarget);
        sb2.append("frame:");
        sb2.append(this.mFrame);
        sb2.append(",\n");
        append(sb2, "easing", this.mTransitionEasing);
        if (this.mCurveFit != null) {
            sb2.append("fit:'");
            sb2.append(this.mCurveFit);
            sb2.append("',\n");
        }
        if (this.mVisibility != null) {
            sb2.append("visibility:'");
            sb2.append(this.mVisibility);
            sb2.append("',\n");
        }
        append(sb2, "alpha", this.mAlpha);
        append(sb2, "rotationX", this.mRotationX);
        append(sb2, "rotationY", this.mRotationY);
        append(sb2, "rotationZ", this.mRotation);
        append(sb2, "pivotX", this.mPivotX);
        append(sb2, "pivotY", this.mPivotY);
        append(sb2, "pathRotate", this.mTransitionPathRotate);
        append(sb2, "scaleX", this.mScaleX);
        append(sb2, "scaleY", this.mScaleY);
        append(sb2, "translationX", this.mTranslationX);
        append(sb2, "translationY", this.mTranslationY);
        append(sb2, "translationZ", this.mTranslationZ);
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public Fit getCurveFit() {
        return this.mCurveFit;
    }

    public float getPivotX() {
        return this.mPivotX;
    }

    public float getPivotY() {
        return this.mPivotY;
    }

    public float getRotation() {
        return this.mRotation;
    }

    public float getRotationX() {
        return this.mRotationX;
    }

    public float getRotationY() {
        return this.mRotationY;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public String getTarget() {
        return this.mTarget;
    }

    public String getTransitionEasing() {
        return this.mTransitionEasing;
    }

    public float getTransitionPathRotate() {
        return this.mTransitionPathRotate;
    }

    public float getTranslationX() {
        return this.mTranslationX;
    }

    public float getTranslationY() {
        return this.mTranslationY;
    }

    public float getTranslationZ() {
        return this.mTranslationZ;
    }

    public Visibility getVisibility() {
        return this.mVisibility;
    }

    public void setAlpha(float f10) {
        this.mAlpha = f10;
    }

    public void setCurveFit(Fit fit) {
        this.mCurveFit = fit;
    }

    public void setPivotX(float f10) {
        this.mPivotX = f10;
    }

    public void setPivotY(float f10) {
        this.mPivotY = f10;
    }

    public void setRotation(float f10) {
        this.mRotation = f10;
    }

    public void setRotationX(float f10) {
        this.mRotationX = f10;
    }

    public void setRotationY(float f10) {
        this.mRotationY = f10;
    }

    public void setScaleX(float f10) {
        this.mScaleX = f10;
    }

    public void setScaleY(float f10) {
        this.mScaleY = f10;
    }

    public void setTarget(String str) {
        this.mTarget = str;
    }

    public void setTransitionEasing(String str) {
        this.mTransitionEasing = str;
    }

    public void setTransitionPathRotate(float f10) {
        this.mTransitionPathRotate = f10;
    }

    public void setTranslationX(float f10) {
        this.mTranslationX = f10;
    }

    public void setTranslationY(float f10) {
        this.mTranslationY = f10;
    }

    public void setTranslationZ(float f10) {
        this.mTranslationZ = f10;
    }

    public void setVisibility(Visibility visibility) {
        this.mVisibility = visibility;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.TYPE);
        sb2.append(":{\n");
        attributesToString(sb2);
        sb2.append("},\n");
        return sb2.toString();
    }

    public KeyAttribute(int i10, String str) {
        this.mTarget = str;
        this.mFrame = i10;
    }
}
