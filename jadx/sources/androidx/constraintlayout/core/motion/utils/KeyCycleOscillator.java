package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    private int mWaveShape = 0;
    private String mWaveString = null;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class CoreSpline extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f10) {
            motionWidget.setValue(this.mTypeId, get(f10));
        }

        CoreSpline(String str) {
            this.mType = str;
            this.mTypeId = c.a(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        CurveFit mCurveFit;
        float[] mOffsetArr;
        private final int mOffst;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        private final int mPhase;
        float[] mPhaseArr;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        private final int mValue;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        public double getLastPhase() {
            return this.mSplineValueCache[1];
        }

        public double getSlope(float f10) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                double d10 = f10;
                curveFit.getSlope(d10, this.mSplineSlopeCache);
                this.mCurveFit.getPos(d10, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineSlopeCache;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d11 = f10;
            double value = this.mOscillator.getValue(d11, this.mSplineValueCache[1]);
            double slope = this.mOscillator.getSlope(d11, this.mSplineValueCache[1], this.mSplineSlopeCache[1]);
            double[] dArr2 = this.mSplineSlopeCache;
            return dArr2[0] + (value * dArr2[2]) + (slope * this.mSplineValueCache[2]);
        }

        public double getValues(float f10) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                curveFit.getPos(f10, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineValueCache;
                dArr[0] = this.mOffsetArr[0];
                dArr[1] = this.mPhaseArr[0];
                dArr[2] = this.mValues[0];
            }
            double[] dArr2 = this.mSplineValueCache;
            return dArr2[0] + (this.mOscillator.getValue(f10, dArr2[1]) * this.mSplineValueCache[2]);
        }

        public void setPoint(int i10, int i11, float f10, float f11, float f12, float f13) {
            this.mPosition[i10] = ((double) i11) / 100.0d;
            this.mPeriod[i10] = f10;
            this.mOffsetArr[i10] = f11;
            this.mPhaseArr[i10] = f12;
            this.mValues[i10] = f13;
        }

        public void setup(float f10) {
            this.mPathLength = f10;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.mPosition.length, 3);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[fArr.length + 2];
            this.mSplineSlopeCache = new double[fArr.length + 2];
            if (this.mPosition[0] > 0.0d) {
                this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
            }
            for (int i10 = 0; i10 < dArr.length; i10++) {
                double[] dArr3 = dArr[i10];
                dArr3[0] = this.mOffsetArr[i10];
                dArr3[1] = this.mPhaseArr[i10];
                dArr3[2] = this.mValues[i10];
                this.mOscillator.addPoint(this.mPosition[i10], this.mPeriod[i10]);
            }
            this.mOscillator.normalize();
            double[] dArr4 = this.mPosition;
            if (dArr4.length > 1) {
                this.mCurveFit = CurveFit.get(0, dArr4, dArr);
            } else {
                this.mCurveFit = null;
            }
        }

        CycleOscillator(int i10, String str, int i11, int i12) {
            Oscillator oscillator = new Oscillator();
            this.mOscillator = oscillator;
            this.mOffst = 0;
            this.mPhase = 1;
            this.mValue = 2;
            this.mWaveShape = i10;
            this.mVariesBy = i11;
            oscillator.setType(i10, str);
            this.mValues = new float[i12];
            this.mPosition = new double[i12];
            this.mPeriod = new float[i12];
            this.mOffsetArr = new float[i12];
            this.mPhaseArr = new float[i12];
            this.mScale = new float[i12];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class PathRotateSet extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f10) {
            motionWidget.setValue(this.mTypeId, get(f10));
        }

        public PathRotateSet(String str) {
            this.mType = str;
            this.mTypeId = c.a(str);
        }

        public void setPathRotate(MotionWidget motionWidget, float f10, double d10, double d11) {
            motionWidget.setRotationZ(get(f10) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
        }
    }

    public void setPoint(int i10, int i11, String str, int i12, float f10, float f11, float f12, float f13, Object obj) {
        this.mWavePoints.add(new WavePoint(i10, f10, f11, f12, f13));
        if (i12 != -1) {
            this.mVariesBy = i12;
        }
        this.mWaveShape = i11;
        setCustom(obj);
        this.mWaveString = str;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class WavePoint {
        float mOffset;
        float mPeriod;
        float mPhase;
        int mPosition;
        float mValue;

        WavePoint(int i10, float f10, float f11, float f12, float f13) {
            this.mPosition = i10;
            this.mValue = f13;
            this.mOffset = f11;
            this.mPeriod = f10;
            this.mPhase = f12;
        }
    }

    public static KeyCycleOscillator makeWidgetCycle(String str) {
        return str.equals("pathRotate") ? new PathRotateSet(str) : new CoreSpline(str);
    }

    public float get(float f10) {
        return (float) this.mCycleOscillator.getValues(f10);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f10) {
        return (float) this.mCycleOscillator.getSlope(f10);
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(float f10) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new Comparator<WavePoint>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
            }
        });
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, size);
        int i10 = 0;
        for (WavePoint wavePoint : this.mWavePoints) {
            float f11 = wavePoint.mPeriod;
            dArr[i10] = ((double) f11) * 0.01d;
            double[] dArr3 = dArr2[i10];
            float f12 = wavePoint.mValue;
            dArr3[0] = f12;
            float f13 = wavePoint.mOffset;
            dArr3[1] = f13;
            float f14 = wavePoint.mPhase;
            dArr3[2] = f14;
            this.mCycleOscillator.setPoint(i10, wavePoint.mPosition, f11, f13, f14, f12);
            i10++;
        }
        this.mCycleOscillator.setup(f10);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (WavePoint wavePoint : this.mWavePoints) {
            str = str + "[" + wavePoint.mPosition + " , " + decimalFormat.format(wavePoint.mValue) + "] ";
        }
        return str;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }

    public void setPoint(int i10, int i11, String str, int i12, float f10, float f11, float f12, float f13) {
        this.mWavePoints.add(new WavePoint(i10, f10, f11, f12, f13));
        if (i12 != -1) {
            this.mVariesBy = i12;
        }
        this.mWaveShape = i11;
        this.mWaveString = str;
    }

    protected void setCustom(Object obj) {
    }

    public void setProperty(MotionWidget motionWidget, float f10) {
    }
}
