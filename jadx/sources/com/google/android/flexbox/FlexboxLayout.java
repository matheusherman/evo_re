package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class FlexboxLayout extends ViewGroup implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private Drawable f1972g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private Drawable f1973h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1974i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1975j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1976k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1977l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int[] f1978m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private SparseIntArray f1979n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private c f1980o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private List<b> f1981p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private c.b f1982q;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f1984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f1985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1986d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f1987e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1988f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f1989g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f1990h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f1991i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f1992j;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LayoutParams[] newArray(int i10) {
                return new LayoutParams[i10];
            }

            a() {
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1983a = 1;
            this.f1984b = 0.0f;
            this.f1985c = 1.0f;
            this.f1986d = -1;
            this.f1987e = -1.0f;
            this.f1988f = -1;
            this.f1989g = -1;
            this.f1990h = ViewCompat.MEASURED_SIZE_MASK;
            this.f1991i = ViewCompat.MEASURED_SIZE_MASK;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlexboxLayout_Layout);
            this.f1983a = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_order, 1);
            this.f1984b = typedArrayObtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.f1985c = typedArrayObtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.f1986d = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.f1987e = typedArrayObtainStyledAttributes.getFraction(R$styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.f1988f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.f1989g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.f1990h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxWidth, ViewCompat.MEASURED_SIZE_MASK);
            this.f1991i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxHeight, ViewCompat.MEASURED_SIZE_MASK);
            this.f1992j = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int A() {
            return this.f1991i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int C() {
            return this.f1990h;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.f1983a;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int i() {
            return this.f1986d;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float k() {
            return this.f1985c;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int m() {
            return this.f1988f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void n(int i10) {
            this.f1988f = i10;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int o() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int q() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int s() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void t(int i10) {
            this.f1989g = i10;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float u() {
            return this.f1984b;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float v() {
            return this.f1987e;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f1983a);
            parcel.writeFloat(this.f1984b);
            parcel.writeFloat(this.f1985c);
            parcel.writeInt(this.f1986d);
            parcel.writeFloat(this.f1987e);
            parcel.writeInt(this.f1988f);
            parcel.writeInt(this.f1989g);
            parcel.writeInt(this.f1990h);
            parcel.writeInt(this.f1991i);
            parcel.writeByte(this.f1992j ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.FlexItem
        public int x() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int y() {
            return this.f1989g;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean z() {
            return this.f1992j;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f1983a = 1;
            this.f1984b = 0.0f;
            this.f1985c = 1.0f;
            this.f1986d = -1;
            this.f1987e = -1.0f;
            this.f1988f = -1;
            this.f1989g = -1;
            this.f1990h = ViewCompat.MEASURED_SIZE_MASK;
            this.f1991i = ViewCompat.MEASURED_SIZE_MASK;
            this.f1983a = layoutParams.f1983a;
            this.f1984b = layoutParams.f1984b;
            this.f1985c = layoutParams.f1985c;
            this.f1986d = layoutParams.f1986d;
            this.f1987e = layoutParams.f1987e;
            this.f1988f = layoutParams.f1988f;
            this.f1989g = layoutParams.f1989g;
            this.f1990h = layoutParams.f1990h;
            this.f1991i = layoutParams.f1991i;
            this.f1992j = layoutParams.f1992j;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1983a = 1;
            this.f1984b = 0.0f;
            this.f1985c = 1.0f;
            this.f1986d = -1;
            this.f1987e = -1.0f;
            this.f1988f = -1;
            this.f1989g = -1;
            this.f1990h = ViewCompat.MEASURED_SIZE_MASK;
            this.f1991i = ViewCompat.MEASURED_SIZE_MASK;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1983a = 1;
            this.f1984b = 0.0f;
            this.f1985c = 1.0f;
            this.f1986d = -1;
            this.f1987e = -1.0f;
            this.f1988f = -1;
            this.f1989g = -1;
            this.f1990h = ViewCompat.MEASURED_SIZE_MASK;
            this.f1991i = ViewCompat.MEASURED_SIZE_MASK;
        }

        protected LayoutParams(Parcel parcel) {
            super(0, 0);
            this.f1983a = 1;
            this.f1984b = 0.0f;
            this.f1985c = 1.0f;
            this.f1986d = -1;
            this.f1987e = -1.0f;
            this.f1988f = -1;
            this.f1989g = -1;
            this.f1990h = ViewCompat.MEASURED_SIZE_MASK;
            this.f1991i = ViewCompat.MEASURED_SIZE_MASK;
            this.f1983a = parcel.readInt();
            this.f1984b = parcel.readFloat();
            this.f1985c = parcel.readFloat();
            this.f1986d = parcel.readInt();
            this.f1987e = parcel.readFloat();
            this.f1988f = parcel.readInt();
            this.f1989g = parcel.readInt();
            this.f1990h = parcel.readInt();
            this.f1991i = parcel.readInt();
            this.f1992j = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    private boolean j(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f1981p.get(i11).c() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean l(int i10, int i11) {
        for (int i12 = 1; i12 <= i11; i12++) {
            View viewR = r(i10 - i12);
            if (viewR != null && viewR.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean t(int i10) {
        if (i10 >= 0 && i10 < this.f1981p.size()) {
            if (j(i10)) {
                if (g()) {
                    return (this.f1974i & 1) != 0;
                }
                return (this.f1975j & 1) != 0;
            }
            if (g()) {
                return (this.f1974i & 2) != 0;
            }
            if ((this.f1975j & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean u(int i10) {
        if (i10 >= 0 && i10 < this.f1981p.size()) {
            for (int i11 = i10 + 1; i11 < this.f1981p.size(); i11++) {
                if (this.f1981p.get(i11).c() > 0) {
                    return false;
                }
            }
            if (g()) {
                return (this.f1974i & 4) != 0;
            }
            if ((this.f1975j & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.flexbox.a
    public int h(View view) {
        return 0;
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A() {
        if (this.f1972g == null && this.f1973h == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private void o(Canvas canvas, int i10, int i11, int i12) {
        Drawable drawable = this.f1972g;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i10, i11, i12 + i10, this.f1976k + i11);
        this.f1972g.draw(canvas);
    }

    private void p(Canvas canvas, int i10, int i11, int i12) {
        Drawable drawable = this.f1973h;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i10, i11, this.f1977l + i10, i12 + i11);
        this.f1973h.draw(canvas);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ed  */
    private void v(boolean z10, int i10, int i11, int i12, int i13) {
        float measuredWidth;
        float f10;
        float f11;
        int i14;
        View viewR;
        int i15;
        int i16;
        View view;
        b bVar;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i17 = i12 - i10;
        int paddingBottom = (i13 - i11) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.f1981p.size();
        for (int i18 = 0; i18 < size; i18++) {
            b bVar2 = this.f1981p.get(i18);
            if (t(i18)) {
                int i19 = this.f1976k;
                paddingBottom -= i19;
                paddingTop += i19;
            }
            int i20 = paddingBottom;
            int i21 = this.f1968c;
            int i22 = 2;
            if (i21 == 0) {
                measuredWidth = paddingLeft;
                f10 = i17 - paddingRight;
            } else if (i21 != 1) {
                if (i21 == 2) {
                    int i23 = bVar2.f2052e;
                    measuredWidth = paddingLeft + ((i17 - i23) / 2.0f);
                    f10 = (i17 - paddingRight) - ((i17 - i23) / 2.0f);
                } else if (i21 == 3) {
                    measuredWidth = paddingLeft;
                    int iC = bVar2.c();
                    f11 = (i17 - bVar2.f2052e) / (iC != 1 ? iC - 1 : 1.0f);
                    f10 = i17 - paddingRight;
                } else if (i21 == 4) {
                    int iC2 = bVar2.c();
                    float f12 = iC2 != 0 ? (i17 - bVar2.f2052e) / iC2 : 0.0f;
                    float f13 = f12 / 2.0f;
                    measuredWidth = paddingLeft + f13;
                    float f14 = (i17 - paddingRight) - f13;
                    f11 = f12;
                    f10 = f14;
                } else {
                    if (i21 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.f1968c);
                    }
                    int iC3 = bVar2.c();
                    f11 = iC3 != 0 ? (i17 - bVar2.f2052e) / (iC3 + 1) : 0.0f;
                    measuredWidth = paddingLeft + f11;
                    f10 = (i17 - paddingRight) - f11;
                }
                float fMax = Math.max(f11, 0.0f);
                i14 = 0;
                while (i14 < bVar2.f2055h) {
                    int i24 = bVar2.f2062o + i14;
                    viewR = r(i24);
                    if (viewR != null || viewR.getVisibility() == 8) {
                        i14 = i14;
                        i15 = i20;
                    } else {
                        LayoutParams layoutParams = (LayoutParams) viewR.getLayoutParams();
                        float f15 = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        float f16 = f10 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        if (s(i24, i14)) {
                            int i25 = this.f1977l;
                            float f17 = i25;
                            f15 += f17;
                            f16 -= f17;
                            i16 = i25;
                        } else {
                            i16 = 0;
                        }
                        float f18 = f16;
                        int i26 = (i14 != bVar2.f2055h + (-1) || (this.f1975j & 4) <= 0) ? 0 : this.f1977l;
                        if (this.f1967b == i22) {
                            if (z10) {
                                view = viewR;
                                this.f1980o.Q(view, bVar2, Math.round(f18) - viewR.getMeasuredWidth(), i20 - viewR.getMeasuredHeight(), Math.round(f18), i20);
                            } else {
                                view = viewR;
                                this.f1980o.Q(view, bVar2, Math.round(f15), i20 - view.getMeasuredHeight(), Math.round(f15) + view.getMeasuredWidth(), i20);
                            }
                            i15 = i20;
                        } else {
                            i14 = i14;
                            view = viewR;
                            i15 = i20;
                            if (z10) {
                                this.f1980o.Q(view, bVar2, Math.round(f18) - view.getMeasuredWidth(), paddingTop, Math.round(f18), paddingTop + view.getMeasuredHeight());
                            } else {
                                int i27 = paddingTop;
                                this.f1980o.Q(view, bVar2, Math.round(f15), i27, view.getMeasuredWidth() + Math.round(f15), i27 + view.getMeasuredHeight());
                                paddingTop = i27;
                            }
                        }
                        measuredWidth = f15 + view.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        float measuredWidth2 = f18 - ((view.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
                        if (z10) {
                            bVar = bVar2;
                            bVar.d(view, i26, 0, i16, 0);
                        } else {
                            bVar = bVar2;
                            bVar.d(view, i16, 0, i26, 0);
                        }
                        bVar2 = bVar;
                        f10 = measuredWidth2;
                    }
                    i14++;
                    i20 = i15;
                    i22 = 2;
                }
                int i28 = bVar2.f2054g;
                paddingTop += i28;
                paddingBottom = i20 - i28;
            } else {
                int i29 = bVar2.f2052e;
                f10 = i29 - paddingLeft;
                measuredWidth = (i17 - i29) + paddingRight;
            }
            f11 = 0.0f;
            float fMax2 = Math.max(f11, 0.0f);
            i14 = 0;
            while (i14 < bVar2.f2055h) {
                int i210 = bVar2.f2062o + i14;
                viewR = r(i210);
                if (viewR != null) {
                    i14 = i14;
                    i15 = i20;
                } else {
                    i14 = i14;
                    i15 = i20;
                }
                i14++;
                i20 = i15;
                i22 = 2;
            }
            int i211 = bVar2.f2054g;
            paddingTop += i211;
            paddingBottom = i20 - i211;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d9  */
    private void w(boolean z10, boolean z11, int i10, int i11, int i12, int i13) {
        float measuredHeight;
        float f10;
        float f11;
        int i14;
        View viewR;
        int i15;
        int i16;
        int i17;
        b bVar;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i18 = i13 - i11;
        int i19 = (i12 - i10) - paddingRight;
        int size = this.f1981p.size();
        for (int i20 = 0; i20 < size; i20++) {
            b bVar2 = this.f1981p.get(i20);
            if (t(i20)) {
                int i21 = this.f1977l;
                paddingLeft += i21;
                i19 -= i21;
            }
            int i22 = i19;
            int i23 = this.f1968c;
            if (i23 == 0) {
                measuredHeight = paddingTop;
                f10 = i18 - paddingBottom;
            } else if (i23 != 1) {
                if (i23 == 2) {
                    int i24 = bVar2.f2052e;
                    measuredHeight = paddingTop + ((i18 - i24) / 2.0f);
                    f10 = (i18 - paddingBottom) - ((i18 - i24) / 2.0f);
                } else if (i23 == 3) {
                    measuredHeight = paddingTop;
                    int iC = bVar2.c();
                    f11 = (i18 - bVar2.f2052e) / (iC != 1 ? iC - 1 : 1.0f);
                    f10 = i18 - paddingBottom;
                } else if (i23 == 4) {
                    int iC2 = bVar2.c();
                    f11 = iC2 != 0 ? (i18 - bVar2.f2052e) / iC2 : 0.0f;
                    float f12 = f11 / 2.0f;
                    measuredHeight = paddingTop + f12;
                    f10 = (i18 - paddingBottom) - f12;
                } else {
                    if (i23 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.f1968c);
                    }
                    int iC3 = bVar2.c();
                    f11 = iC3 != 0 ? (i18 - bVar2.f2052e) / (iC3 + 1) : 0.0f;
                    measuredHeight = paddingTop + f11;
                    f10 = (i18 - paddingBottom) - f11;
                }
                float fMax = Math.max(f11, 0.0f);
                i14 = 0;
                while (i14 < bVar2.f2055h) {
                    int i25 = bVar2.f2062o + i14;
                    viewR = r(i25);
                    if (viewR != null || viewR.getVisibility() == 8) {
                        i16 = i14;
                        i15 = i22;
                    } else {
                        LayoutParams layoutParams = (LayoutParams) viewR.getLayoutParams();
                        float f13 = measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        float f14 = f10 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        if (s(i25, i14)) {
                            i17 = this.f1976k;
                            float f15 = i17;
                            f13 += f15;
                            f14 -= f15;
                        } else {
                            i17 = 0;
                        }
                        float f16 = f14;
                        int i26 = (i14 != bVar2.f2055h - 1 || (this.f1974i & 4) <= 0) ? 0 : this.f1976k;
                        if (z10) {
                            if (z11) {
                                i16 = i14;
                                this.f1980o.R(viewR, bVar2, true, i22 - viewR.getMeasuredWidth(), Math.round(f16) - viewR.getMeasuredHeight(), i22, Math.round(f16));
                            } else {
                                i16 = i14;
                                this.f1980o.R(viewR, bVar2, true, i22 - viewR.getMeasuredWidth(), Math.round(f13), i22, Math.round(f13) + viewR.getMeasuredHeight());
                            }
                            i15 = i22;
                        } else {
                            i16 = i14;
                            i15 = i22;
                            if (z11) {
                                this.f1980o.R(viewR, bVar2, false, paddingLeft, Math.round(f16) - viewR.getMeasuredHeight(), paddingLeft + viewR.getMeasuredWidth(), Math.round(f16));
                            } else {
                                int i27 = paddingLeft;
                                this.f1980o.R(viewR, bVar2, false, i27, Math.round(f13), i27 + viewR.getMeasuredWidth(), Math.round(f13) + viewR.getMeasuredHeight());
                                paddingLeft = i27;
                            }
                        }
                        measuredHeight = f13 + viewR.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        float measuredHeight2 = f16 - ((viewR.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin);
                        if (z11) {
                            bVar = bVar2;
                            bVar.d(viewR, 0, i26, 0, i17);
                        } else {
                            bVar = bVar2;
                            bVar.d(viewR, 0, i17, 0, i26);
                        }
                        bVar2 = bVar;
                        f10 = measuredHeight2;
                    }
                    i14 = i16 + 1;
                    i22 = i15;
                }
                int i28 = bVar2.f2054g;
                paddingLeft += i28;
                i19 = i22 - i28;
            } else {
                int i29 = bVar2.f2052e;
                f10 = i29 - paddingTop;
                measuredHeight = (i18 - i29) + paddingBottom;
            }
            f11 = 0.0f;
            float fMax2 = Math.max(f11, 0.0f);
            i14 = 0;
            while (i14 < bVar2.f2055h) {
                int i210 = bVar2.f2062o + i14;
                viewR = r(i210);
                if (viewR != null) {
                }
                i16 = i14;
                i15 = i22;
                i14 = i16 + 1;
                i22 = i15;
            }
            int i211 = bVar2.f2054g;
            paddingLeft += i211;
            i19 = i22 - i211;
        }
    }

    private void x(int i10, int i11) {
        this.f1981p.clear();
        this.f1982q.a();
        this.f1980o.c(this.f1982q, i10, i11);
        this.f1981p = this.f1982q.f2071a;
        this.f1980o.p(i10, i11);
        if (this.f1969d == 3) {
            for (b bVar : this.f1981p) {
                int iMax = Integer.MIN_VALUE;
                for (int i12 = 0; i12 < bVar.f2055h; i12++) {
                    View viewR = r(bVar.f2062o + i12);
                    if (viewR != null && viewR.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) viewR.getLayoutParams();
                        iMax = this.f1967b != 2 ? Math.max(iMax, viewR.getMeasuredHeight() + Math.max(bVar.f2059l - viewR.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : Math.max(iMax, viewR.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max((bVar.f2059l - viewR.getMeasuredHeight()) + viewR.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                    }
                }
                bVar.f2054g = iMax;
            }
        }
        this.f1980o.o(i10, i11, getPaddingTop() + getPaddingBottom());
        this.f1980o.X();
        z(this.f1966a, i10, i11, this.f1982q.f2072b);
    }

    private void y(int i10, int i11) {
        this.f1981p.clear();
        this.f1982q.a();
        this.f1980o.f(this.f1982q, i10, i11);
        this.f1981p = this.f1982q.f2071a;
        this.f1980o.p(i10, i11);
        this.f1980o.o(i10, i11, getPaddingLeft() + getPaddingRight());
        this.f1980o.X();
        z(this.f1966a, i10, i11, this.f1982q.f2072b);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (this.f1979n == null) {
            this.f1979n = new SparseIntArray(getChildCount());
        }
        this.f1978m = this.f1980o.n(view, i10, layoutParams, this.f1979n);
        super.addView(view, i10, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // com.google.android.flexbox.a
    public boolean g() {
        int i10 = this.f1966a;
        return i10 == 0 || i10 == 1;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.f1970e;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.f1969d;
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.f1972g;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.f1973h;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.f1966a;
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f1981p.size());
        for (b bVar : this.f1981p) {
            if (bVar.c() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.f1981p;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.f1967b;
    }

    public int getJustifyContent() {
        return this.f1968c;
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        Iterator<b> it = this.f1981p.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().f2052e);
        }
        return iMax;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.f1971f;
    }

    public int getShowDividerHorizontal() {
        return this.f1974i;
    }

    public int getShowDividerVertical() {
        return this.f1975j;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.f1981p.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f1981p.get(i11);
            if (t(i11)) {
                i10 += g() ? this.f1976k : this.f1977l;
            }
            if (u(i11)) {
                i10 += g() ? this.f1976k : this.f1977l;
            }
            i10 += bVar.f2054g;
        }
        return i10;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f1973h == null && this.f1972g == null) {
            return;
        }
        if (this.f1974i == 0 && this.f1975j == 0) {
            return;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i10 = this.f1966a;
        if (i10 == 0) {
            m(canvas, layoutDirection == 1, this.f1967b == 2);
            return;
        }
        if (i10 == 1) {
            m(canvas, layoutDirection != 1, this.f1967b == 2);
            return;
        }
        if (i10 == 2) {
            boolean z10 = layoutDirection == 1;
            if (this.f1967b == 2) {
                z10 = !z10;
            }
            n(canvas, z10, false);
            return;
        }
        if (i10 != 3) {
            return;
        }
        boolean z11 = layoutDirection == 1;
        if (this.f1967b == 2) {
            z11 = !z11;
        }
        n(canvas, z11, true);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        if (this.f1979n == null) {
            this.f1979n = new SparseIntArray(getChildCount());
        }
        if (this.f1980o.O(this.f1979n)) {
            this.f1978m = this.f1980o.m(this.f1979n);
        }
        int i12 = this.f1966a;
        if (i12 == 0 || i12 == 1) {
            x(i10, i11);
            return;
        }
        if (i12 == 2 || i12 == 3) {
            y(i10, i11);
            return;
        }
        throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f1966a);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public View r(int i10) {
        if (i10 < 0) {
            return null;
        }
        int[] iArr = this.f1978m;
        if (i10 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i10]);
    }

    public void setAlignContent(int i10) {
        if (this.f1970e != i10) {
            this.f1970e = i10;
            requestLayout();
        }
    }

    public void setAlignItems(int i10) {
        if (this.f1969d != i10) {
            this.f1969d = i10;
            requestLayout();
        }
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable == this.f1972g) {
            return;
        }
        this.f1972g = drawable;
        if (drawable != null) {
            this.f1976k = drawable.getIntrinsicHeight();
        } else {
            this.f1976k = 0;
        }
        A();
        requestLayout();
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable == this.f1973h) {
            return;
        }
        this.f1973h = drawable;
        if (drawable != null) {
            this.f1977l = drawable.getIntrinsicWidth();
        } else {
            this.f1977l = 0;
        }
        A();
        requestLayout();
    }

    public void setFlexDirection(int i10) {
        if (this.f1966a != i10) {
            this.f1966a = i10;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.f1981p = list;
    }

    public void setFlexWrap(int i10) {
        if (this.f1967b != i10) {
            this.f1967b = i10;
            requestLayout();
        }
    }

    public void setJustifyContent(int i10) {
        if (this.f1968c != i10) {
            this.f1968c = i10;
            requestLayout();
        }
    }

    public void setMaxLine(int i10) {
        if (this.f1971f != i10) {
            this.f1971f = i10;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i10) {
        if (i10 != this.f1974i) {
            this.f1974i = i10;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i10) {
        if (i10 != this.f1975j) {
            this.f1975j = i10;
            requestLayout();
        }
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1971f = -1;
        this.f1980o = new c(this);
        this.f1981p = new ArrayList();
        this.f1982q = new c.b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlexboxLayout, i10, 0);
        this.f1966a = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_flexDirection, 0);
        this.f1967b = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_flexWrap, 0);
        this.f1968c = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_justifyContent, 0);
        this.f1969d = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_alignItems, 0);
        this.f1970e = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_alignContent, 0);
        this.f1971f = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i11 = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDivider, 0);
        if (i11 != 0) {
            this.f1975j = i11;
            this.f1974i = i11;
        }
        int i12 = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDividerVertical, 0);
        if (i12 != 0) {
            this.f1975j = i12;
        }
        int i13 = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i13 != 0) {
            this.f1974i = i13;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void m(Canvas canvas, boolean z10, boolean z11) {
        int i10;
        int i11;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.f1981p.size();
        for (int i12 = 0; i12 < size; i12++) {
            b bVar = this.f1981p.get(i12);
            for (int i13 = 0; i13 < bVar.f2055h; i13++) {
                int i14 = bVar.f2062o + i13;
                View viewR = r(i14);
                if (viewR != null && viewR.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) viewR.getLayoutParams();
                    if (s(i14, i13)) {
                        if (z10) {
                            left = viewR.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        } else {
                            left = (viewR.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f1977l;
                        }
                        p(canvas, left, bVar.f2049b, bVar.f2054g);
                    }
                    if (i13 == bVar.f2055h - 1 && (this.f1975j & 4) > 0) {
                        if (z10) {
                            right = (viewR.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f1977l;
                        } else {
                            right = viewR.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        }
                        p(canvas, right, bVar.f2049b, bVar.f2054g);
                    }
                }
            }
            if (t(i12)) {
                if (z11) {
                    i11 = bVar.f2051d;
                } else {
                    i11 = bVar.f2049b - this.f1976k;
                }
                o(canvas, paddingLeft, i11, iMax);
            }
            if (u(i12) && (this.f1974i & 4) > 0) {
                if (z11) {
                    i10 = bVar.f2049b - this.f1976k;
                } else {
                    i10 = bVar.f2051d;
                }
                o(canvas, paddingLeft, i10, iMax);
            }
        }
    }

    private void n(Canvas canvas, boolean z10, boolean z11) {
        int i10;
        int i11;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.f1981p.size();
        for (int i12 = 0; i12 < size; i12++) {
            b bVar = this.f1981p.get(i12);
            for (int i13 = 0; i13 < bVar.f2055h; i13++) {
                int i14 = bVar.f2062o + i13;
                View viewR = r(i14);
                if (viewR != null && viewR.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) viewR.getLayoutParams();
                    if (s(i14, i13)) {
                        if (z11) {
                            top = viewR.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        } else {
                            top = (viewR.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f1976k;
                        }
                        o(canvas, bVar.f2048a, top, bVar.f2054g);
                    }
                    if (i13 == bVar.f2055h - 1 && (this.f1974i & 4) > 0) {
                        if (z11) {
                            bottom = (viewR.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f1976k;
                        } else {
                            bottom = viewR.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        }
                        o(canvas, bVar.f2048a, bottom, bVar.f2054g);
                    }
                }
            }
            if (t(i12)) {
                if (z10) {
                    i11 = bVar.f2050c;
                } else {
                    i11 = bVar.f2048a - this.f1977l;
                }
                p(canvas, i11, paddingTop, iMax);
            }
            if (u(i12) && (this.f1975j & 4) > 0) {
                if (z10) {
                    i10 = bVar.f2048a - this.f1977l;
                } else {
                    i10 = bVar.f2050c;
                }
                p(canvas, i10, paddingTop, iMax);
            }
        }
    }

    private boolean s(int i10, int i11) {
        if (l(i10, i11)) {
            if (g()) {
                if ((this.f1975j & 1) == 0) {
                    return false;
                }
                return true;
            }
            if ((this.f1974i & 1) == 0) {
                return false;
            }
            return true;
        }
        if (g()) {
            if ((this.f1975j & 2) == 0) {
                return false;
            }
            return true;
        }
        if ((this.f1974i & 2) == 0) {
            return false;
        }
        return true;
    }

    private void z(int i10, int i11, int i12, int i13) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        if (i10 != 0 && i10 != 1) {
            if (i10 != 2 && i10 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + i10);
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        }
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    if (size < largestMainSize) {
                        i13 = View.combineMeasuredStates(i13, 16777216);
                    }
                    iResolveSizeAndState = View.resolveSizeAndState(size, i11, i13);
                } else {
                    throw new IllegalStateException("Unknown width mode is set: " + mode);
                }
            } else {
                iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i11, i13);
            }
        } else {
            if (size < largestMainSize) {
                i13 = View.combineMeasuredStates(i13, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i11, i13);
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 0) {
                if (mode2 == 1073741824) {
                    if (size2 < sumOfCrossSize) {
                        i13 = View.combineMeasuredStates(i13, 256);
                    }
                    iResolveSizeAndState2 = View.resolveSizeAndState(size2, i12, i13);
                } else {
                    throw new IllegalStateException("Unknown height mode is set: " + mode2);
                }
            } else {
                iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i12, i13);
            }
        } else {
            if (size2 < sumOfCrossSize) {
                i13 = View.combineMeasuredStates(i13, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i12, i13);
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    @Override // com.google.android.flexbox.a
    public View a(int i10) {
        return r(i10);
    }

    @Override // com.google.android.flexbox.a
    public int b(int i10, int i11, int i12) {
        return ViewGroup.getChildMeasureSpec(i10, i11, i12);
    }

    @Override // com.google.android.flexbox.a
    public View d(int i10) {
        return getChildAt(i10);
    }

    @Override // com.google.android.flexbox.a
    public int e(View view, int i10, int i11) {
        int i12;
        int i13 = 0;
        if (g()) {
            if (s(i10, i11)) {
                i13 = this.f1977l;
            }
            if ((this.f1975j & 4) > 0) {
                i12 = this.f1977l;
            } else {
                return i13;
            }
        } else {
            if (s(i10, i11)) {
                i13 = this.f1976k;
            }
            if ((this.f1974i & 4) > 0) {
                i12 = this.f1976k;
            } else {
                return i13;
            }
        }
        return i13 + i12;
    }

    @Override // com.google.android.flexbox.a
    public int f(int i10, int i11, int i12) {
        return ViewGroup.getChildMeasureSpec(i10, i11, i12);
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public void i(View view, int i10, int i11, b bVar) {
        if (s(i10, i11)) {
            if (g()) {
                int i12 = bVar.f2052e;
                int i13 = this.f1977l;
                bVar.f2052e = i12 + i13;
                bVar.f2053f += i13;
                return;
            }
            int i14 = bVar.f2052e;
            int i15 = this.f1976k;
            bVar.f2052e = i14 + i15;
            bVar.f2053f += i15;
        }
    }

    @Override // com.google.android.flexbox.a
    public void k(b bVar) {
        if (g()) {
            if ((this.f1975j & 4) > 0) {
                int i10 = bVar.f2052e;
                int i11 = this.f1977l;
                bVar.f2052e = i10 + i11;
                bVar.f2053f += i11;
                return;
            }
            return;
        }
        if ((this.f1974i & 4) > 0) {
            int i12 = bVar.f2052e;
            int i13 = this.f1976k;
            bVar.f2052e = i12 + i13;
            bVar.f2053f += i13;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11;
        boolean z12;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i14 = this.f1966a;
        boolean z13 = false;
        if (i14 != 0) {
            if (i14 != 1) {
                if (i14 != 2) {
                    if (i14 == 3) {
                        if (layoutDirection == 1) {
                            z13 = true;
                        }
                        if (this.f1967b == 2) {
                            z13 = !z13;
                        }
                        w(z13, true, i10, i11, i12, i13);
                        return;
                    }
                    throw new IllegalStateException("Invalid flex direction is set: " + this.f1966a);
                }
                if (layoutDirection == 1) {
                    z13 = true;
                }
                if (this.f1967b == 2) {
                    z13 = !z13;
                }
                w(z13, false, i10, i11, i12, i13);
                return;
            }
            if (layoutDirection != 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            v(z12, i10, i11, i12, i13);
            return;
        }
        if (layoutDirection == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        v(z11, i10, i11, i12, i13);
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setShowDivider(int i10) {
        setShowDividerVertical(i10);
        setShowDividerHorizontal(i10);
    }

    @Override // com.google.android.flexbox.a
    public void c(int i10, View view) {
    }
}
