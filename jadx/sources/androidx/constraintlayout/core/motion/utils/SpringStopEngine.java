package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;
    private float mV;
    double mDamping = 0.5d;
    private boolean mInitialized = false;
    private int mBoundaryMode = 0;

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f10) {
        return null;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }

    public void springConfig(float f10, float f11, float f12, float f13, float f14, float f15, float f16, int i10) {
        this.mTargetPos = f11;
        this.mDamping = f15;
        this.mInitialized = false;
        this.mPos = f10;
        this.mLastVelocity = f12;
        this.mStiffness = f14;
        this.mMass = f13;
        this.mStopThreshold = f16;
        this.mBoundaryMode = i10;
        this.mLastTime = 0.0f;
    }

    private void compute(double d10) {
        if (d10 <= 0.0d) {
            return;
        }
        double d11 = this.mStiffness;
        double d12 = this.mDamping;
        int iSqrt = (int) ((9.0d / ((Math.sqrt(d11 / ((double) this.mMass)) * d10) * 4.0d)) + 1.0d);
        double d13 = d10 / ((double) iSqrt);
        int i10 = 0;
        while (i10 < iSqrt) {
            float f10 = this.mPos;
            double d14 = this.mTargetPos;
            float f11 = this.mV;
            double d15 = d11;
            double d16 = ((-d11) * (((double) f10) - d14)) - (((double) f11) * d12);
            float f12 = this.mMass;
            double d17 = d12;
            double d18 = ((double) f11) + (((d16 / ((double) f12)) * d13) / 2.0d);
            double d19 = ((((-((((double) f10) + ((d13 * d18) / 2.0d)) - d14)) * d15) - (d18 * d17)) / ((double) f12)) * d13;
            double d20 = ((double) f11) + (d19 / 2.0d);
            float f13 = f11 + ((float) d19);
            this.mV = f13;
            float f14 = f10 + ((float) (d20 * d13));
            this.mPos = f14;
            int i11 = this.mBoundaryMode;
            if (i11 > 0) {
                if (f14 < 0.0f && (i11 & 1) == 1) {
                    this.mPos = -f14;
                    this.mV = -f13;
                }
                float f15 = this.mPos;
                if (f15 > 1.0f && (i11 & 2) == 2) {
                    this.mPos = 2.0f - f15;
                    this.mV = -this.mV;
                }
            }
            i10++;
            d11 = d15;
            d12 = d17;
        }
    }

    public float getAcceleration() {
        double d10 = this.mStiffness;
        return ((float) (((-d10) * (((double) this.mPos) - this.mTargetPos)) - (this.mDamping * ((double) this.mV)))) / this.mMass;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f10) {
        compute(f10 - this.mLastTime);
        this.mLastTime = f10;
        if (isStopped()) {
            this.mPos = (float) this.mTargetPos;
        }
        return this.mPos;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f10) {
        return this.mV;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double d10 = ((double) this.mPos) - this.mTargetPos;
        double d11 = this.mStiffness;
        double d12 = this.mV;
        return Math.sqrt((((d12 * d12) * ((double) this.mMass)) + ((d11 * d10) * d10)) / d11) <= ((double) this.mStopThreshold);
    }

    void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ";
        System.out.println(str2 + str);
    }
}
