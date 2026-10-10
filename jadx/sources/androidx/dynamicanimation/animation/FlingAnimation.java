package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction = DEFAULT_FRICTION;
        private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
        private float mVelocityThreshold;

        @Override // androidx.dynamicanimation.animation.Force
        public float getAcceleration(float f10, float f11) {
            return f11 * this.mFriction;
        }

        float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        void setValueThreshold(float f10) {
            this.mVelocityThreshold = f10 * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        DynamicAnimation.MassState updateValueAndVelocity(float f10, float f11, long j10) {
            this.mMassState.mVelocity = (float) (((double) f11) * Math.exp((j10 / 1000.0f) * this.mFriction));
            DynamicAnimation.MassState massState = this.mMassState;
            float f12 = massState.mVelocity;
            float f13 = f10 + ((f12 - f11) / this.mFriction);
            massState.mValue = f13;
            if (isAtEquilibrium(f13, f12)) {
                this.mMassState.mVelocity = 0.0f;
            }
            return this.mMassState;
        }

        DragForce() {
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float f10, float f11) {
            if (Math.abs(f11) < this.mVelocityThreshold) {
                return true;
            }
            return false;
        }

        void setFrictionScalar(float f10) {
            this.mFriction = f10 * DEFAULT_FRICTION;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }

    public FlingAnimation setFriction(@FloatRange(from = 0.0d, fromInclusive = false) float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Friction must be positive");
        }
        this.mFlingForce.setFrictionScalar(f10);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    float getAcceleration(float f10, float f11) {
        return this.mFlingForce.getAcceleration(f10, f11);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean isAtEquilibrium(float f10, float f11) {
        return f10 >= this.mMaxValue || f10 <= this.mMinValue || this.mFlingForce.isAtEquilibrium(f10, f11);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMaxValue(float f10) {
        super.setMaxValue(f10);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMinValue(float f10) {
        super.setMinValue(f10);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setStartVelocity(float f10) {
        super.setStartVelocity(f10);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    void setValueThreshold(float f10) {
        this.mFlingForce.setValueThreshold(f10);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean updateValueAndVelocity(long j10) {
        DynamicAnimation.MassState massStateUpdateValueAndVelocity = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, j10);
        float f10 = massStateUpdateValueAndVelocity.mValue;
        this.mValue = f10;
        float f11 = massStateUpdateValueAndVelocity.mVelocity;
        this.mVelocity = f11;
        float f12 = this.mMinValue;
        if (f10 < f12) {
            this.mValue = f12;
            return true;
        }
        float f13 = this.mMaxValue;
        if (f10 <= f13) {
            return isAtEquilibrium(f10, f11);
        }
        this.mValue = f13;
        return true;
    }

    public <K> FlingAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k10, floatPropertyCompat);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }
}
