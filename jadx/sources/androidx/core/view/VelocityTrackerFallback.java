package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private final float[] mMovements = new float[20];
    private final long[] mEventTimes = new long[20];
    private float mLastComputedVelocity = 0.0f;
    private int mDataPointsBufferSize = 0;
    private int mDataPointsBufferLastUsedIndex = 0;

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private static float kineticEnergyToVelocity(float f10) {
        return (f10 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f10) * 2.0f));
    }

    void computeCurrentVelocity(int i10) {
        computeCurrentVelocity(i10, Float.MAX_VALUE);
    }

    private float getCurrentVelocity() {
        long[] jArr;
        long j10;
        int i10 = this.mDataPointsBufferSize;
        if (i10 < 2) {
            return 0.0f;
        }
        int i11 = this.mDataPointsBufferLastUsedIndex;
        int i12 = ((i11 + 20) - (i10 - 1)) % 20;
        long j11 = this.mEventTimes[i11];
        while (true) {
            jArr = this.mEventTimes;
            j10 = jArr[i12];
            if (j11 - j10 <= RANGE_MS) {
                break;
            }
            this.mDataPointsBufferSize--;
            i12 = (i12 + 1) % 20;
        }
        int i13 = this.mDataPointsBufferSize;
        if (i13 < 2) {
            return 0.0f;
        }
        if (i13 == 2) {
            int i14 = (i12 + 1) % 20;
            long j12 = jArr[i14];
            if (j10 == j12) {
                return 0.0f;
            }
            return this.mMovements[i14] / (j12 - j10);
        }
        int i15 = 0;
        float fAbs = 0.0f;
        for (int i16 = 0; i16 < this.mDataPointsBufferSize - 1; i16++) {
            int i17 = i16 + i12;
            long[] jArr2 = this.mEventTimes;
            long j13 = jArr2[i17 % 20];
            int i18 = (i17 + 1) % 20;
            if (jArr2[i18] != j13) {
                i15++;
                float fKineticEnergyToVelocity = kineticEnergyToVelocity(fAbs);
                float f10 = this.mMovements[i18] / (this.mEventTimes[i18] - j13);
                fAbs += (f10 - fKineticEnergyToVelocity) * Math.abs(f10);
                if (i15 == 1) {
                    fAbs *= 0.5f;
                }
            }
        }
        return kineticEnergyToVelocity(fAbs);
    }

    void computeCurrentVelocity(int i10, float f10) {
        float currentVelocity = getCurrentVelocity() * i10;
        this.mLastComputedVelocity = currentVelocity;
        if (currentVelocity < (-Math.abs(f10))) {
            this.mLastComputedVelocity = -Math.abs(f10);
        } else if (this.mLastComputedVelocity > Math.abs(f10)) {
            this.mLastComputedVelocity = Math.abs(f10);
        }
    }

    float getAxisVelocity(int i10) {
        if (i10 != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }

    VelocityTrackerFallback() {
    }

    void addMovement(@NonNull MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.mDataPointsBufferSize != 0 && eventTime - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > ASSUME_POINTER_STOPPED_MS) {
            clear();
        }
        int i10 = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = i10;
        int i11 = this.mDataPointsBufferSize;
        if (i11 != 20) {
            this.mDataPointsBufferSize = i11 + 1;
        }
        this.mMovements[i10] = motionEvent.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }
}
