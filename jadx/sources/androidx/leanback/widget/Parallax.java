package androidx.leanback.widget;

import android.util.Property;
import androidx.annotation.CallSuper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public abstract class Parallax<PropertyT extends Property> {
    private final List<ParallaxEffect> mEffects;
    private float[] mFloatValues;
    final List<PropertyT> mProperties;
    final List<PropertyT> mPropertiesReadOnly;
    private int[] mValues;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class FloatProperty extends Property<Parallax, Float> {
        public static final float UNKNOWN_AFTER = Float.MAX_VALUE;
        public static final float UNKNOWN_BEFORE = -3.4028235E38f;
        private final int mIndex;

        public FloatProperty(String str, int i10) {
            super(Float.class, str);
            this.mIndex = i10;
        }

        public final PropertyMarkerValue at(float f10, float f11) {
            return new FloatPropertyMarkerValue(this, f10, f11);
        }

        public final PropertyMarkerValue atAbsolute(float f10) {
            return new FloatPropertyMarkerValue(this, f10, 0.0f);
        }

        public final PropertyMarkerValue atFraction(float f10) {
            return new FloatPropertyMarkerValue(this, 0.0f, f10);
        }

        public final PropertyMarkerValue atMax() {
            return new FloatPropertyMarkerValue(this, 0.0f, 1.0f);
        }

        public final PropertyMarkerValue atMin() {
            return new FloatPropertyMarkerValue(this, 0.0f);
        }

        @Override // android.util.Property
        public final Float get(Parallax parallax) {
            return Float.valueOf(parallax.getFloatPropertyValue(this.mIndex));
        }

        public final int getIndex() {
            return this.mIndex;
        }

        public final float getValue(Parallax parallax) {
            return parallax.getFloatPropertyValue(this.mIndex);
        }

        @Override // android.util.Property
        public final void set(Parallax parallax, Float f10) {
            parallax.setFloatPropertyValue(this.mIndex, f10.floatValue());
        }

        public final void setValue(Parallax parallax, float f10) {
            parallax.setFloatPropertyValue(this.mIndex, f10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class FloatPropertyMarkerValue extends PropertyMarkerValue<FloatProperty> {
        private final float mFactionOfMax;
        private final float mValue;

        FloatPropertyMarkerValue(FloatProperty floatProperty, float f10) {
            this(floatProperty, f10, 0.0f);
        }

        FloatPropertyMarkerValue(FloatProperty floatProperty, float f10, float f11) {
            super(floatProperty);
            this.mValue = f10;
            this.mFactionOfMax = f11;
        }

        final float getMarkerValue(Parallax parallax) {
            return this.mFactionOfMax == 0.0f ? this.mValue : this.mValue + (parallax.getMaxValue() * this.mFactionOfMax);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class IntProperty extends Property<Parallax, Integer> {
        public static final int UNKNOWN_AFTER = Integer.MAX_VALUE;
        public static final int UNKNOWN_BEFORE = Integer.MIN_VALUE;
        private final int mIndex;

        public IntProperty(String str, int i10) {
            super(Integer.class, str);
            this.mIndex = i10;
        }

        public final PropertyMarkerValue at(int i10, float f10) {
            return new IntPropertyMarkerValue(this, i10, f10);
        }

        public final PropertyMarkerValue atAbsolute(int i10) {
            return new IntPropertyMarkerValue(this, i10, 0.0f);
        }

        public final PropertyMarkerValue atFraction(float f10) {
            return new IntPropertyMarkerValue(this, 0, f10);
        }

        public final PropertyMarkerValue atMax() {
            return new IntPropertyMarkerValue(this, 0, 1.0f);
        }

        public final PropertyMarkerValue atMin() {
            return new IntPropertyMarkerValue(this, 0);
        }

        @Override // android.util.Property
        public final Integer get(Parallax parallax) {
            return Integer.valueOf(parallax.getIntPropertyValue(this.mIndex));
        }

        public final int getIndex() {
            return this.mIndex;
        }

        public final int getValue(Parallax parallax) {
            return parallax.getIntPropertyValue(this.mIndex);
        }

        @Override // android.util.Property
        public final void set(Parallax parallax, Integer num) {
            parallax.setIntPropertyValue(this.mIndex, num.intValue());
        }

        public final void setValue(Parallax parallax, int i10) {
            parallax.setIntPropertyValue(this.mIndex, i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class IntPropertyMarkerValue extends PropertyMarkerValue<IntProperty> {
        private final float mFactionOfMax;
        private final int mValue;

        IntPropertyMarkerValue(IntProperty intProperty, int i10) {
            this(intProperty, i10, 0.0f);
        }

        IntPropertyMarkerValue(IntProperty intProperty, int i10, float f10) {
            super(intProperty);
            this.mValue = i10;
            this.mFactionOfMax = f10;
        }

        final int getMarkerValue(Parallax parallax) {
            return this.mFactionOfMax == 0.0f ? this.mValue : this.mValue + Math.round(parallax.getMaxValue() * this.mFactionOfMax);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class PropertyMarkerValue<PropertyT> {
        private final PropertyT mProperty;

        public PropertyT getProperty() {
            return this.mProperty;
        }

        public PropertyMarkerValue(PropertyT propertyt) {
            this.mProperty = propertyt;
        }
    }

    public ParallaxEffect addEffect(PropertyMarkerValue... propertyMarkerValueArr) {
        ParallaxEffect intEffect = propertyMarkerValueArr[0].getProperty() instanceof IntProperty ? new ParallaxEffect.IntEffect() : new ParallaxEffect.FloatEffect();
        intEffect.setPropertyRanges(propertyMarkerValueArr);
        this.mEffects.add(intEffect);
        return intEffect;
    }

    public abstract PropertyT createProperty(String str, int i10);

    public abstract float getMaxValue();

    @CallSuper
    public void updateValues() {
        for (int i10 = 0; i10 < this.mEffects.size(); i10++) {
            this.mEffects.get(i10).performMapping(this);
        }
    }

    public final PropertyT addProperty(String str) {
        int size = this.mProperties.size();
        PropertyT propertyt = (PropertyT) createProperty(str, size);
        int i10 = 0;
        if (propertyt instanceof IntProperty) {
            int length = this.mValues.length;
            if (length == size) {
                int[] iArr = new int[length * 2];
                while (i10 < length) {
                    iArr[i10] = this.mValues[i10];
                    i10++;
                }
                this.mValues = iArr;
            }
            this.mValues[size] = Integer.MAX_VALUE;
        } else {
            if (!(propertyt instanceof FloatProperty)) {
                throw new IllegalArgumentException("Invalid Property type");
            }
            int length2 = this.mFloatValues.length;
            if (length2 == size) {
                float[] fArr = new float[length2 * 2];
                while (i10 < length2) {
                    fArr[i10] = this.mFloatValues[i10];
                    i10++;
                }
                this.mFloatValues = fArr;
            }
            this.mFloatValues[size] = Float.MAX_VALUE;
        }
        this.mProperties.add(propertyt);
        return propertyt;
    }

    public List<ParallaxEffect> getEffects() {
        return this.mEffects;
    }

    final float getFloatPropertyValue(int i10) {
        return this.mFloatValues[i10];
    }

    final int getIntPropertyValue(int i10) {
        return this.mValues[i10];
    }

    public final List<PropertyT> getProperties() {
        return this.mPropertiesReadOnly;
    }

    public void removeAllEffects() {
        this.mEffects.clear();
    }

    public void removeEffect(ParallaxEffect parallaxEffect) {
        this.mEffects.remove(parallaxEffect);
    }

    final void setFloatPropertyValue(int i10, float f10) {
        if (i10 >= this.mProperties.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.mFloatValues[i10] = f10;
    }

    final void setIntPropertyValue(int i10, int i11) {
        if (i10 >= this.mProperties.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.mValues[i10] = i11;
    }

    final void verifyFloatProperties() {
        if (this.mProperties.size() < 2) {
            return;
        }
        float floatPropertyValue = getFloatPropertyValue(0);
        int i10 = 1;
        while (i10 < this.mProperties.size()) {
            float floatPropertyValue2 = getFloatPropertyValue(i10);
            if (floatPropertyValue2 < floatPropertyValue) {
                Integer numValueOf = Integer.valueOf(i10);
                String name = this.mProperties.get(i10).getName();
                int i11 = i10 - 1;
                throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is smaller than Property[%d]\"%s\"", numValueOf, name, Integer.valueOf(i11), this.mProperties.get(i11).getName()));
            }
            if (floatPropertyValue == -3.4028235E38f && floatPropertyValue2 == Float.MAX_VALUE) {
                int i12 = i10 - 1;
                throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is UNKNOWN_BEFORE and Property[%d]\"%s\" is UNKNOWN_AFTER", Integer.valueOf(i12), this.mProperties.get(i12).getName(), Integer.valueOf(i10), this.mProperties.get(i10).getName()));
            }
            i10++;
            floatPropertyValue = floatPropertyValue2;
        }
    }

    void verifyIntProperties() {
        if (this.mProperties.size() < 2) {
            return;
        }
        int intPropertyValue = getIntPropertyValue(0);
        int i10 = 1;
        while (i10 < this.mProperties.size()) {
            int intPropertyValue2 = getIntPropertyValue(i10);
            if (intPropertyValue2 < intPropertyValue) {
                Integer numValueOf = Integer.valueOf(i10);
                String name = this.mProperties.get(i10).getName();
                int i11 = i10 - 1;
                throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is smaller than Property[%d]\"%s\"", numValueOf, name, Integer.valueOf(i11), this.mProperties.get(i11).getName()));
            }
            if (intPropertyValue == Integer.MIN_VALUE && intPropertyValue2 == Integer.MAX_VALUE) {
                int i12 = i10 - 1;
                throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is UNKNOWN_BEFORE and Property[%d]\"%s\" is UNKNOWN_AFTER", Integer.valueOf(i12), this.mProperties.get(i12).getName(), Integer.valueOf(i10), this.mProperties.get(i10).getName()));
            }
            i10++;
            intPropertyValue = intPropertyValue2;
        }
    }

    public Parallax() {
        ArrayList arrayList = new ArrayList();
        this.mProperties = arrayList;
        this.mPropertiesReadOnly = Collections.unmodifiableList(arrayList);
        this.mValues = new int[4];
        this.mFloatValues = new float[4];
        this.mEffects = new ArrayList(4);
    }
}
