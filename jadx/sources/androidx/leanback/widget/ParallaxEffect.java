package androidx.leanback.widget;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public abstract class ParallaxEffect {
    final List<Parallax.PropertyMarkerValue> mMarkerValues = new ArrayList(2);
    final List<Float> mWeights = new ArrayList(2);
    final List<Float> mTotalWeights = new ArrayList(2);
    final List<ParallaxTarget> mTargets = new ArrayList(4);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class FloatEffect extends ParallaxEffect {
        @Override // androidx.leanback.widget.ParallaxEffect
        float calculateFraction(Parallax parallax) {
            float maxValue;
            int i10 = 0;
            int i11 = 0;
            float f10 = 0.0f;
            float f11 = 0.0f;
            while (i10 < this.mMarkerValues.size()) {
                Parallax.FloatPropertyMarkerValue floatPropertyMarkerValue = (Parallax.FloatPropertyMarkerValue) this.mMarkerValues.get(i10);
                int index = floatPropertyMarkerValue.getProperty().getIndex();
                float markerValue = floatPropertyMarkerValue.getMarkerValue(parallax);
                float floatPropertyValue = parallax.getFloatPropertyValue(index);
                if (i10 == 0) {
                    if (floatPropertyValue >= markerValue) {
                        return 0.0f;
                    }
                } else {
                    if (i11 == index && f10 < markerValue) {
                        throw new IllegalStateException("marker value of same variable must be descendant order");
                    }
                    if (floatPropertyValue == Float.MAX_VALUE) {
                        return getFractionWithWeightAdjusted((f10 - f11) / parallax.getMaxValue(), i10);
                    }
                    if (floatPropertyValue >= markerValue) {
                        if (i11 == index) {
                            maxValue = (f10 - floatPropertyValue) / (f10 - markerValue);
                        } else if (f11 != -3.4028235E38f) {
                            f10 += floatPropertyValue - f11;
                            maxValue = (f10 - floatPropertyValue) / (f10 - markerValue);
                        } else {
                            maxValue = 1.0f - ((floatPropertyValue - markerValue) / parallax.getMaxValue());
                        }
                        return getFractionWithWeightAdjusted(maxValue, i10);
                    }
                }
                i10++;
                f10 = markerValue;
                i11 = index;
                f11 = floatPropertyValue;
            }
            return 1.0f;
        }

        @Override // androidx.leanback.widget.ParallaxEffect
        Number calculateDirectValue(Parallax parallax) {
            if (this.mMarkerValues.size() != 2) {
                throw new RuntimeException("Must use two marker values for direct mapping");
            }
            if (this.mMarkerValues.get(0).getProperty() != this.mMarkerValues.get(1).getProperty()) {
                throw new RuntimeException("Marker value must use same Property for direct mapping");
            }
            float markerValue = ((Parallax.FloatPropertyMarkerValue) this.mMarkerValues.get(0)).getMarkerValue(parallax);
            float markerValue2 = ((Parallax.FloatPropertyMarkerValue) this.mMarkerValues.get(1)).getMarkerValue(parallax);
            if (markerValue > markerValue2) {
                markerValue2 = markerValue;
                markerValue = markerValue2;
            }
            Float f10 = ((Parallax.FloatProperty) this.mMarkerValues.get(0).getProperty()).get(parallax);
            if (f10.floatValue() < markerValue) {
                return Float.valueOf(markerValue);
            }
            return f10.floatValue() > markerValue2 ? Float.valueOf(markerValue2) : f10;
        }

        FloatEffect() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class IntEffect extends ParallaxEffect {
        @Override // androidx.leanback.widget.ParallaxEffect
        float calculateFraction(Parallax parallax) {
            float maxValue;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i10 < this.mMarkerValues.size()) {
                Parallax.IntPropertyMarkerValue intPropertyMarkerValue = (Parallax.IntPropertyMarkerValue) this.mMarkerValues.get(i10);
                int index = intPropertyMarkerValue.getProperty().getIndex();
                int markerValue = intPropertyMarkerValue.getMarkerValue(parallax);
                int intPropertyValue = parallax.getIntPropertyValue(index);
                if (i10 == 0) {
                    if (intPropertyValue >= markerValue) {
                        return 0.0f;
                    }
                } else {
                    if (i11 == index && i12 < markerValue) {
                        throw new IllegalStateException("marker value of same variable must be descendant order");
                    }
                    if (intPropertyValue == Integer.MAX_VALUE) {
                        return getFractionWithWeightAdjusted((i12 - i13) / parallax.getMaxValue(), i10);
                    }
                    if (intPropertyValue >= markerValue) {
                        if (i11 == index) {
                            maxValue = (i12 - intPropertyValue) / (i12 - markerValue);
                        } else if (i13 != Integer.MIN_VALUE) {
                            i12 += intPropertyValue - i13;
                            maxValue = (i12 - intPropertyValue) / (i12 - markerValue);
                        } else {
                            maxValue = 1.0f - ((intPropertyValue - markerValue) / parallax.getMaxValue());
                        }
                        return getFractionWithWeightAdjusted(maxValue, i10);
                    }
                }
                i10++;
                i12 = markerValue;
                i11 = index;
                i13 = intPropertyValue;
            }
            return 1.0f;
        }

        @Override // androidx.leanback.widget.ParallaxEffect
        Number calculateDirectValue(Parallax parallax) {
            if (this.mMarkerValues.size() != 2) {
                throw new RuntimeException("Must use two marker values for direct mapping");
            }
            if (this.mMarkerValues.get(0).getProperty() != this.mMarkerValues.get(1).getProperty()) {
                throw new RuntimeException("Marker value must use same Property for direct mapping");
            }
            int markerValue = ((Parallax.IntPropertyMarkerValue) this.mMarkerValues.get(0)).getMarkerValue(parallax);
            int markerValue2 = ((Parallax.IntPropertyMarkerValue) this.mMarkerValues.get(1)).getMarkerValue(parallax);
            if (markerValue > markerValue2) {
                markerValue2 = markerValue;
                markerValue = markerValue2;
            }
            Integer num = ((Parallax.IntProperty) this.mMarkerValues.get(0).getProperty()).get(parallax);
            if (num.intValue() < markerValue) {
                return Integer.valueOf(markerValue);
            }
            return num.intValue() > markerValue2 ? Integer.valueOf(markerValue2) : num;
        }

        IntEffect() {
        }
    }

    abstract Number calculateDirectValue(Parallax parallax);

    abstract float calculateFraction(Parallax parallax);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setWeights(float... fArr) {
        int length = fArr.length;
        int i10 = 0;
        while (true) {
            float f10 = 0.0f;
            if (i10 >= length) {
                this.mWeights.clear();
                this.mTotalWeights.clear();
                for (float f11 : fArr) {
                    this.mWeights.add(Float.valueOf(f11));
                    f10 += f11;
                    this.mTotalWeights.add(Float.valueOf(f10));
                }
                return;
            }
            if (fArr[i10] <= 0.0f) {
                throw new IllegalArgumentException();
            }
            i10++;
        }
    }

    public final ParallaxEffect target(ParallaxTarget parallaxTarget) {
        this.mTargets.add(parallaxTarget);
        return this;
    }

    public final void addTarget(ParallaxTarget parallaxTarget) {
        this.mTargets.add(parallaxTarget);
    }

    final float getFractionWithWeightAdjusted(float f10, int i10) {
        float size;
        float fFloatValue;
        if (this.mMarkerValues.size() >= 3) {
            if (this.mWeights.size() == this.mMarkerValues.size() - 1) {
                List<Float> list = this.mTotalWeights;
                size = list.get(list.size() - 1).floatValue();
                f10 = (f10 * this.mWeights.get(i10 - 1).floatValue()) / size;
                if (i10 < 2) {
                    return f10;
                }
                fFloatValue = this.mTotalWeights.get(i10 - 2).floatValue();
            } else {
                size = this.mMarkerValues.size() - 1;
                f10 /= size;
                if (i10 >= 2) {
                    fFloatValue = i10 - 1;
                }
            }
            return f10 + (fFloatValue / size);
        }
        return f10;
    }

    public final List<Parallax.PropertyMarkerValue> getPropertyRanges() {
        return this.mMarkerValues;
    }

    public final List<ParallaxTarget> getTargets() {
        return this.mTargets;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final List<Float> getWeights() {
        return this.mWeights;
    }

    public final void performMapping(Parallax parallax) {
        if (this.mMarkerValues.size() < 2) {
            return;
        }
        if (this instanceof IntEffect) {
            parallax.verifyIntProperties();
        } else {
            parallax.verifyFloatProperties();
        }
        Number numberCalculateDirectValue = null;
        boolean z10 = false;
        float fCalculateFraction = 0.0f;
        for (int i10 = 0; i10 < this.mTargets.size(); i10++) {
            ParallaxTarget parallaxTarget = this.mTargets.get(i10);
            if (parallaxTarget.isDirectMapping()) {
                if (numberCalculateDirectValue == null) {
                    numberCalculateDirectValue = calculateDirectValue(parallax);
                }
                parallaxTarget.directUpdate(numberCalculateDirectValue);
            } else {
                if (!z10) {
                    fCalculateFraction = calculateFraction(parallax);
                    z10 = true;
                }
                parallaxTarget.update(fCalculateFraction);
            }
        }
    }

    public final void removeTarget(ParallaxTarget parallaxTarget) {
        this.mTargets.remove(parallaxTarget);
    }

    public final void setPropertyRanges(Parallax.PropertyMarkerValue... propertyMarkerValueArr) {
        this.mMarkerValues.clear();
        for (Parallax.PropertyMarkerValue propertyMarkerValue : propertyMarkerValueArr) {
            this.mMarkerValues.add(propertyMarkerValue);
        }
    }

    public final ParallaxEffect target(Object obj, PropertyValuesHolder propertyValuesHolder) {
        this.mTargets.add(new ParallaxTarget.PropertyValuesHolderTarget(obj, propertyValuesHolder));
        return this;
    }

    ParallaxEffect() {
    }

    public final <T, V extends Number> ParallaxEffect target(T t10, Property<T, V> property) {
        this.mTargets.add(new ParallaxTarget.DirectPropertyTarget(t10, property));
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final ParallaxEffect weights(float... fArr) {
        setWeights(fArr);
        return this;
    }
}
