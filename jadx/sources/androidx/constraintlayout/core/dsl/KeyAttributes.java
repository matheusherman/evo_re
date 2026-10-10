package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class KeyAttributes extends Keys {
    private int[] mFrames;
    private String[] mTarget;
    private String mTransitionEasing;
    protected String TYPE = "KeyAttributes";
    private Fit mCurveFit = null;
    private Visibility[] mVisibility = null;
    private float[] mAlpha = null;
    private float[] mRotation = null;
    private float[] mRotationX = null;
    private float[] mRotationY = null;
    private float[] mPivotX = null;
    private float[] mPivotY = null;
    private float[] mTransitionPathRotate = null;
    private float[] mScaleX = null;
    private float[] mScaleY = null;
    private float[] mTranslationX = null;
    private float[] mTranslationY = null;
    private float[] mTranslationZ = null;

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
        sb2.append(Arrays.toString(this.mFrames));
        sb2.append(",\n");
        append(sb2, "easing", this.mTransitionEasing);
        if (this.mCurveFit != null) {
            sb2.append("fit:'");
            sb2.append(this.mCurveFit);
            sb2.append("',\n");
        }
        if (this.mVisibility != null) {
            sb2.append("visibility:'");
            sb2.append(Arrays.toString(this.mVisibility));
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

    public float[] getAlpha() {
        return this.mAlpha;
    }

    public Fit getCurveFit() {
        return this.mCurveFit;
    }

    public float[] getPivotX() {
        return this.mPivotX;
    }

    public float[] getPivotY() {
        return this.mPivotY;
    }

    public float[] getRotation() {
        return this.mRotation;
    }

    public float[] getRotationX() {
        return this.mRotationX;
    }

    public float[] getRotationY() {
        return this.mRotationY;
    }

    public float[] getScaleX() {
        return this.mScaleX;
    }

    public float[] getScaleY() {
        return this.mScaleY;
    }

    public String[] getTarget() {
        return this.mTarget;
    }

    public String getTransitionEasing() {
        return this.mTransitionEasing;
    }

    public float[] getTransitionPathRotate() {
        return this.mTransitionPathRotate;
    }

    public float[] getTranslationX() {
        return this.mTranslationX;
    }

    public float[] getTranslationY() {
        return this.mTranslationY;
    }

    public float[] getTranslationZ() {
        return this.mTranslationZ;
    }

    public Visibility[] getVisibility() {
        return this.mVisibility;
    }

    public void setAlpha(float... fArr) {
        this.mAlpha = fArr;
    }

    public void setCurveFit(Fit fit) {
        this.mCurveFit = fit;
    }

    public void setPivotX(float... fArr) {
        this.mPivotX = fArr;
    }

    public void setPivotY(float... fArr) {
        this.mPivotY = fArr;
    }

    public void setRotation(float... fArr) {
        this.mRotation = fArr;
    }

    public void setRotationX(float... fArr) {
        this.mRotationX = fArr;
    }

    public void setRotationY(float... fArr) {
        this.mRotationY = fArr;
    }

    public void setScaleX(float[] fArr) {
        this.mScaleX = fArr;
    }

    public void setScaleY(float[] fArr) {
        this.mScaleY = fArr;
    }

    public void setTarget(String[] strArr) {
        this.mTarget = strArr;
    }

    public void setTransitionEasing(String str) {
        this.mTransitionEasing = str;
    }

    public void setTransitionPathRotate(float... fArr) {
        this.mTransitionPathRotate = fArr;
    }

    public void setTranslationX(float[] fArr) {
        this.mTranslationX = fArr;
    }

    public void setTranslationY(float[] fArr) {
        this.mTranslationY = fArr;
    }

    public void setTranslationZ(float[] fArr) {
        this.mTranslationZ = fArr;
    }

    public void setVisibility(Visibility... visibilityArr) {
        this.mVisibility = visibilityArr;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.TYPE);
        sb2.append(":{\n");
        attributesToString(sb2);
        sb2.append("},\n");
        return sb2.toString();
    }

    KeyAttributes(int i10, String... strArr) {
        this.mFrames = null;
        this.mTarget = strArr;
        int[] iArr = new int[i10];
        this.mFrames = iArr;
        float length = 100.0f / (iArr.length + 1);
        int i11 = 0;
        while (true) {
            int[] iArr2 = this.mFrames;
            if (i11 < iArr2.length) {
                iArr2[i11] = (int) ((i11 * length) + length);
                i11++;
            } else {
                return;
            }
        }
    }
}
