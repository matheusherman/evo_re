package com.tvc.lib.mobile.ui.widget.flexbox;

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
import com.tvc.lib.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class FlexboxLayout extends ViewGroup implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private Drawable f9318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private Drawable f9319h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9320i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9321j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f9322k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f9323l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int[] f9324m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private SparseIntArray f9325n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private c f9326o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private List<b> f9327p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private c.a f9328q;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f9330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f9331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f9332d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f9333e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f9334f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f9335g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f9336h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f9337i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f9338j;

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
            this.f9329a = 1;
            this.f9330b = 0.0f;
            this.f9331c = 1.0f;
            this.f9332d = -1;
            this.f9333e = -1.0f;
            this.f9334f = -1;
            this.f9335g = -1;
            this.f9336h = ViewCompat.MEASURED_SIZE_MASK;
            this.f9337i = ViewCompat.MEASURED_SIZE_MASK;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlexboxLayout_Layout);
            this.f9329a = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_order, 1);
            this.f9330b = typedArrayObtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.f9331c = typedArrayObtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.f9332d = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.f9333e = typedArrayObtainStyledAttributes.getFraction(R$styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.f9334f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.f9335g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.f9336h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxWidth, ViewCompat.MEASURED_SIZE_MASK);
            this.f9337i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxHeight, ViewCompat.MEASURED_SIZE_MASK);
            this.f9338j = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int A() {
            return this.f9337i;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int C() {
            return this.f9336h;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int getOrder() {
            return this.f9329a;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int i() {
            return this.f9332d;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public float k() {
            return this.f9331c;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int m() {
            return this.f9334f;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public void n(int i10) {
            this.f9334f = i10;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int o() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int q() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int s() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public void t(int i10) {
            this.f9335g = i10;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public float u() {
            return this.f9330b;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public float v() {
            return this.f9333e;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f9329a);
            parcel.writeFloat(this.f9330b);
            parcel.writeFloat(this.f9331c);
            parcel.writeInt(this.f9332d);
            parcel.writeFloat(this.f9333e);
            parcel.writeInt(this.f9334f);
            parcel.writeInt(this.f9335g);
            parcel.writeInt(this.f9336h);
            parcel.writeInt(this.f9337i);
            parcel.writeByte(this.f9338j ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int x() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int y() {
            return this.f9335g;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public boolean z() {
            return this.f9338j;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f9329a = 1;
            this.f9330b = 0.0f;
            this.f9331c = 1.0f;
            this.f9332d = -1;
            this.f9333e = -1.0f;
            this.f9334f = -1;
            this.f9335g = -1;
            this.f9336h = ViewCompat.MEASURED_SIZE_MASK;
            this.f9337i = ViewCompat.MEASURED_SIZE_MASK;
            this.f9329a = layoutParams.f9329a;
            this.f9330b = layoutParams.f9330b;
            this.f9331c = layoutParams.f9331c;
            this.f9332d = layoutParams.f9332d;
            this.f9333e = layoutParams.f9333e;
            this.f9334f = layoutParams.f9334f;
            this.f9335g = layoutParams.f9335g;
            this.f9336h = layoutParams.f9336h;
            this.f9337i = layoutParams.f9337i;
            this.f9338j = layoutParams.f9338j;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f9329a = 1;
            this.f9330b = 0.0f;
            this.f9331c = 1.0f;
            this.f9332d = -1;
            this.f9333e = -1.0f;
            this.f9334f = -1;
            this.f9335g = -1;
            this.f9336h = ViewCompat.MEASURED_SIZE_MASK;
            this.f9337i = ViewCompat.MEASURED_SIZE_MASK;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f9329a = 1;
            this.f9330b = 0.0f;
            this.f9331c = 1.0f;
            this.f9332d = -1;
            this.f9333e = -1.0f;
            this.f9334f = -1;
            this.f9335g = -1;
            this.f9336h = ViewCompat.MEASURED_SIZE_MASK;
            this.f9337i = ViewCompat.MEASURED_SIZE_MASK;
        }

        protected LayoutParams(Parcel parcel) {
            super(0, 0);
            this.f9329a = 1;
            this.f9330b = 0.0f;
            this.f9331c = 1.0f;
            this.f9332d = -1;
            this.f9333e = -1.0f;
            this.f9334f = -1;
            this.f9335g = -1;
            this.f9336h = ViewCompat.MEASURED_SIZE_MASK;
            this.f9337i = ViewCompat.MEASURED_SIZE_MASK;
            this.f9329a = parcel.readInt();
            this.f9330b = parcel.readFloat();
            this.f9331c = parcel.readFloat();
            this.f9332d = parcel.readInt();
            this.f9333e = parcel.readFloat();
            this.f9334f = parcel.readInt();
            this.f9335g = parcel.readInt();
            this.f9336h = parcel.readInt();
            this.f9337i = parcel.readInt();
            this.f9338j = parcel.readByte() != 0;
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

    private boolean i(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f9327p.get(i11).c() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean k(int i10, int i11) {
        for (int i12 = 1; i12 <= i11; i12++) {
            View viewR = r(i10 - i12);
            if (viewR != null && viewR.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean t(int i10) {
        if (i10 >= 0 && i10 < this.f9327p.size()) {
            if (i(i10)) {
                if (g()) {
                    return (this.f9320i & 1) != 0;
                }
                return (this.f9321j & 1) != 0;
            }
            if (g()) {
                return (this.f9320i & 2) != 0;
            }
            if ((this.f9321j & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean u(int i10) {
        if (i10 >= 0 && i10 < this.f9327p.size()) {
            for (int i11 = i10 + 1; i11 < this.f9327p.size(); i11++) {
                if (i11 >= 0 && this.f9327p.get(i11).c() > 0) {
                    return false;
                }
            }
            if (g()) {
                return (this.f9320i & 4) != 0;
            }
            if ((this.f9321j & 4) != 0) {
                return true;
            }
        }
        return false;
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
        int size = this.f9327p.size();
        for (int i18 = 0; i18 < size; i18++) {
            b bVar2 = this.f9327p.get(i18);
            if (t(i18)) {
                int i19 = this.f9322k;
                paddingBottom -= i19;
                paddingTop += i19;
            }
            int i20 = paddingBottom;
            int i21 = this.f9314c;
            int i22 = 2;
            if (i21 == 0) {
                measuredWidth = paddingLeft;
                f10 = i17 - paddingRight;
            } else if (i21 != 1) {
                if (i21 == 2) {
                    int i23 = bVar2.f9453e;
                    measuredWidth = paddingLeft + ((i17 - i23) / 2.0f);
                    f10 = (i17 - paddingRight) - ((i17 - i23) / 2.0f);
                } else if (i21 == 3) {
                    measuredWidth = paddingLeft;
                    int iC = bVar2.c();
                    f11 = (i17 - bVar2.f9453e) / (iC != 1 ? iC - 1 : 1.0f);
                    f10 = i17 - paddingRight;
                } else if (i21 == 4) {
                    int iC2 = bVar2.c();
                    float f12 = iC2 != 0 ? (i17 - bVar2.f9453e) / iC2 : 0.0f;
                    float f13 = f12 / 2.0f;
                    measuredWidth = paddingLeft + f13;
                    float f14 = (i17 - paddingRight) - f13;
                    f11 = f12;
                    f10 = f14;
                } else {
                    if (i21 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.f9314c);
                    }
                    int iC3 = bVar2.c();
                    f11 = iC3 != 0 ? (i17 - bVar2.f9453e) / (iC3 + 1) : 0.0f;
                    measuredWidth = paddingLeft + f11;
                    f10 = (i17 - paddingRight) - f11;
                }
                float fMax = Math.max(f11, 0.0f);
                i14 = 0;
                while (i14 < bVar2.f9456h) {
                    int i24 = bVar2.f9463o + i14;
                    viewR = r(i24);
                    if (viewR != null || viewR.getVisibility() == 8) {
                        i14 = i14;
                        i15 = i20;
                    } else {
                        LayoutParams layoutParams = (LayoutParams) viewR.getLayoutParams();
                        float f15 = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        float f16 = f10 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        if (s(i24, i14)) {
                            int i25 = this.f9323l;
                            float f17 = i25;
                            f15 += f17;
                            f16 -= f17;
                            i16 = i25;
                        } else {
                            i16 = 0;
                        }
                        float f18 = f16;
                        int i26 = (i14 != bVar2.f9456h + (-1) || (this.f9321j & 4) <= 0) ? 0 : this.f9323l;
                        if (this.f9313b == i22) {
                            if (z10) {
                                view = viewR;
                                this.f9326o.Q(view, bVar2, Math.round(f18) - viewR.getMeasuredWidth(), i20 - viewR.getMeasuredHeight(), Math.round(f18), i20);
                            } else {
                                view = viewR;
                                this.f9326o.Q(view, bVar2, Math.round(f15), i20 - view.getMeasuredHeight(), Math.round(f15) + view.getMeasuredWidth(), i20);
                            }
                            i15 = i20;
                        } else {
                            i14 = i14;
                            view = viewR;
                            i15 = i20;
                            if (z10) {
                                this.f9326o.Q(view, bVar2, Math.round(f18) - view.getMeasuredWidth(), paddingTop, Math.round(f18), paddingTop + view.getMeasuredHeight());
                            } else {
                                int i27 = paddingTop;
                                this.f9326o.Q(view, bVar2, Math.round(f15), i27, view.getMeasuredWidth() + Math.round(f15), i27 + view.getMeasuredHeight());
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
                int i28 = bVar2.f9455g;
                paddingTop += i28;
                paddingBottom = i20 - i28;
            } else {
                int i29 = bVar2.f9453e;
                f10 = i29 - paddingLeft;
                measuredWidth = (i17 - i29) + paddingRight;
            }
            f11 = 0.0f;
            float fMax2 = Math.max(f11, 0.0f);
            i14 = 0;
            while (i14 < bVar2.f9456h) {
                int i210 = bVar2.f9463o + i14;
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
            int i211 = bVar2.f9455g;
            paddingTop += i211;
            paddingBottom = i20 - i211;
        }
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int h(View view) {
        return 0;
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A() {
        if (this.f9318g == null && this.f9319h == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private void o(Canvas canvas, int i10, int i11, int i12) {
        Drawable drawable = this.f9318g;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i10, i11, i12 + i10, this.f9322k + i11);
        this.f9318g.draw(canvas);
    }

    private void p(Canvas canvas, int i10, int i11, int i12) {
        Drawable drawable = this.f9319h;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i10, i11, this.f9323l + i10, i12 + i11);
        this.f9319h.draw(canvas);
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
        int size = this.f9327p.size();
        for (int i20 = 0; i20 < size; i20++) {
            b bVar2 = this.f9327p.get(i20);
            if (t(i20)) {
                int i21 = this.f9323l;
                paddingLeft += i21;
                i19 -= i21;
            }
            int i22 = i19;
            int i23 = this.f9314c;
            if (i23 == 0) {
                measuredHeight = paddingTop;
                f10 = i18 - paddingBottom;
            } else if (i23 != 1) {
                if (i23 == 2) {
                    int i24 = bVar2.f9453e;
                    measuredHeight = paddingTop + ((i18 - i24) / 2.0f);
                    f10 = (i18 - paddingBottom) - ((i18 - i24) / 2.0f);
                } else if (i23 == 3) {
                    measuredHeight = paddingTop;
                    int iC = bVar2.c();
                    f11 = (i18 - bVar2.f9453e) / (iC != 1 ? iC - 1 : 1.0f);
                    f10 = i18 - paddingBottom;
                } else if (i23 == 4) {
                    int iC2 = bVar2.c();
                    f11 = iC2 != 0 ? (i18 - bVar2.f9453e) / iC2 : 0.0f;
                    float f12 = f11 / 2.0f;
                    measuredHeight = paddingTop + f12;
                    f10 = (i18 - paddingBottom) - f12;
                } else {
                    if (i23 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.f9314c);
                    }
                    int iC3 = bVar2.c();
                    f11 = iC3 != 0 ? (i18 - bVar2.f9453e) / (iC3 + 1) : 0.0f;
                    measuredHeight = paddingTop + f11;
                    f10 = (i18 - paddingBottom) - f11;
                }
                float fMax = Math.max(f11, 0.0f);
                i14 = 0;
                while (i14 < bVar2.f9456h) {
                    int i25 = bVar2.f9463o + i14;
                    viewR = r(i25);
                    if (viewR != null || viewR.getVisibility() == 8) {
                        i16 = i14;
                        i15 = i22;
                    } else {
                        LayoutParams layoutParams = (LayoutParams) viewR.getLayoutParams();
                        float f13 = measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        float f14 = f10 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        if (s(i25, i14)) {
                            i17 = this.f9322k;
                            float f15 = i17;
                            f13 += f15;
                            f14 -= f15;
                        } else {
                            i17 = 0;
                        }
                        float f16 = f14;
                        int i26 = (i14 != bVar2.f9456h - 1 || (this.f9320i & 4) <= 0) ? 0 : this.f9322k;
                        if (z10) {
                            if (z11) {
                                i16 = i14;
                                this.f9326o.R(viewR, bVar2, true, i22 - viewR.getMeasuredWidth(), Math.round(f16) - viewR.getMeasuredHeight(), i22, Math.round(f16));
                            } else {
                                i16 = i14;
                                this.f9326o.R(viewR, bVar2, true, i22 - viewR.getMeasuredWidth(), Math.round(f13), i22, Math.round(f13) + viewR.getMeasuredHeight());
                            }
                            i15 = i22;
                        } else {
                            i16 = i14;
                            i15 = i22;
                            if (z11) {
                                this.f9326o.R(viewR, bVar2, false, paddingLeft, Math.round(f16) - viewR.getMeasuredHeight(), paddingLeft + viewR.getMeasuredWidth(), Math.round(f16));
                            } else {
                                int i27 = paddingLeft;
                                this.f9326o.R(viewR, bVar2, false, i27, Math.round(f13), i27 + viewR.getMeasuredWidth(), Math.round(f13) + viewR.getMeasuredHeight());
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
                int i28 = bVar2.f9455g;
                paddingLeft += i28;
                i19 = i22 - i28;
            } else {
                int i29 = bVar2.f9453e;
                f10 = i29 - paddingTop;
                measuredHeight = (i18 - i29) + paddingBottom;
            }
            f11 = 0.0f;
            float fMax2 = Math.max(f11, 0.0f);
            i14 = 0;
            while (i14 < bVar2.f9456h) {
                int i210 = bVar2.f9463o + i14;
                viewR = r(i210);
                if (viewR != null) {
                }
                i16 = i14;
                i15 = i22;
                i14 = i16 + 1;
                i22 = i15;
            }
            int i211 = bVar2.f9455g;
            paddingLeft += i211;
            i19 = i22 - i211;
        }
    }

    private void x(int i10, int i11) {
        this.f9327p.clear();
        this.f9328q.a();
        this.f9326o.c(this.f9328q, i10, i11);
        this.f9327p = this.f9328q.f9472a;
        this.f9326o.p(i10, i11);
        if (this.f9315d == 3) {
            for (b bVar : this.f9327p) {
                int iMax = Integer.MIN_VALUE;
                for (int i12 = 0; i12 < bVar.f9456h; i12++) {
                    View viewR = r(bVar.f9463o + i12);
                    if (viewR != null && viewR.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) viewR.getLayoutParams();
                        iMax = this.f9313b != 2 ? Math.max(iMax, viewR.getMeasuredHeight() + Math.max(bVar.f9460l - viewR.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : Math.max(iMax, viewR.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max((bVar.f9460l - viewR.getMeasuredHeight()) + viewR.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                    }
                }
                bVar.f9455g = iMax;
            }
        }
        this.f9326o.o(i10, i11, getPaddingTop() + getPaddingBottom());
        this.f9326o.X();
        z(this.f9312a, i10, i11, this.f9328q.f9473b);
    }

    private void y(int i10, int i11) {
        this.f9327p.clear();
        this.f9328q.a();
        this.f9326o.f(this.f9328q, i10, i11);
        this.f9327p = this.f9328q.f9472a;
        this.f9326o.p(i10, i11);
        this.f9326o.o(i10, i11, getPaddingLeft() + getPaddingRight());
        this.f9326o.X();
        z(this.f9312a, i10, i11, this.f9328q.f9473b);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (this.f9325n == null) {
            this.f9325n = new SparseIntArray(getChildCount());
        }
        this.f9324m = this.f9326o.n(view, i10, layoutParams, this.f9325n);
        super.addView(view, i10, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public boolean g() {
        int i10 = this.f9312a;
        return i10 == 0 || i10 == 1;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getAlignContent() {
        return this.f9316e;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getAlignItems() {
        return this.f9315d;
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.f9318g;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.f9319h;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getFlexDirection() {
        return this.f9312a;
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f9327p.size());
        for (b bVar : this.f9327p) {
            if (bVar.c() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.f9327p;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getFlexWrap() {
        return this.f9313b;
    }

    public int getJustifyContent() {
        return this.f9314c;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getLargestMainSize() {
        Iterator<b> it = this.f9327p.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().f9453e);
        }
        return iMax;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getMaxLine() {
        return this.f9317f;
    }

    public int getShowDividerHorizontal() {
        return this.f9320i;
    }

    public int getShowDividerVertical() {
        return this.f9321j;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.f9327p.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f9327p.get(i11);
            if (t(i11)) {
                i10 += g() ? this.f9322k : this.f9323l;
            }
            if (u(i11)) {
                i10 += g() ? this.f9322k : this.f9323l;
            }
            i10 += bVar.f9455g;
        }
        return i10;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f9319h == null && this.f9318g == null) {
            return;
        }
        if (this.f9320i == 0 && this.f9321j == 0) {
            return;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i10 = this.f9312a;
        if (i10 == 0) {
            m(canvas, layoutDirection == 1, this.f9313b == 2);
            return;
        }
        if (i10 == 1) {
            m(canvas, layoutDirection != 1, this.f9313b == 2);
            return;
        }
        if (i10 == 2) {
            boolean z10 = layoutDirection == 1;
            if (this.f9313b == 2) {
                z10 = !z10;
            }
            n(canvas, z10, false);
            return;
        }
        if (i10 != 3) {
            return;
        }
        boolean z11 = layoutDirection == 1;
        if (this.f9313b == 2) {
            z11 = !z11;
        }
        n(canvas, z11, true);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        if (this.f9325n == null) {
            this.f9325n = new SparseIntArray(getChildCount());
        }
        if (this.f9326o.O(this.f9325n)) {
            this.f9324m = this.f9326o.m(this.f9325n);
        }
        int i12 = this.f9312a;
        if (i12 == 0 || i12 == 1) {
            x(i10, i11);
            return;
        }
        if (i12 == 2 || i12 == 3) {
            y(i10, i11);
            return;
        }
        throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f9312a);
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
        int[] iArr = this.f9324m;
        if (i10 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i10]);
    }

    public void setAlignContent(int i10) {
        if (this.f9316e != i10) {
            this.f9316e = i10;
            requestLayout();
        }
    }

    public void setAlignItems(int i10) {
        if (this.f9315d != i10) {
            this.f9315d = i10;
            requestLayout();
        }
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable == this.f9318g) {
            return;
        }
        this.f9318g = drawable;
        if (drawable != null) {
            this.f9322k = drawable.getIntrinsicHeight();
        } else {
            this.f9322k = 0;
        }
        A();
        requestLayout();
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable == this.f9319h) {
            return;
        }
        this.f9319h = drawable;
        if (drawable != null) {
            this.f9323l = drawable.getIntrinsicWidth();
        } else {
            this.f9323l = 0;
        }
        A();
        requestLayout();
    }

    public void setFlexDirection(int i10) {
        if (this.f9312a != i10) {
            this.f9312a = i10;
            requestLayout();
        }
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public void setFlexLines(List<b> list) {
        this.f9327p = list;
    }

    public void setFlexWrap(int i10) {
        if (this.f9313b != i10) {
            this.f9313b = i10;
            requestLayout();
        }
    }

    public void setJustifyContent(int i10) {
        if (this.f9314c != i10) {
            this.f9314c = i10;
            requestLayout();
        }
    }

    public void setMaxLine(int i10) {
        if (this.f9317f != i10) {
            this.f9317f = i10;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i10) {
        if (i10 != this.f9320i) {
            this.f9320i = i10;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i10) {
        if (i10 != this.f9321j) {
            this.f9321j = i10;
            requestLayout();
        }
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9317f = -1;
        this.f9326o = new c(this);
        this.f9327p = new ArrayList();
        this.f9328q = new c.a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlexboxLayout, i10, 0);
        this.f9312a = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_flexDirection, 0);
        this.f9313b = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_flexWrap, 0);
        this.f9314c = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_justifyContent, 0);
        this.f9315d = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_alignItems, 0);
        this.f9316e = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_alignContent, 0);
        this.f9317f = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_maxLine, -1);
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
            this.f9321j = i11;
            this.f9320i = i11;
        }
        int i12 = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDividerVertical, 0);
        if (i12 != 0) {
            this.f9321j = i12;
        }
        int i13 = typedArrayObtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i13 != 0) {
            this.f9320i = i13;
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
        int size = this.f9327p.size();
        for (int i12 = 0; i12 < size; i12++) {
            b bVar = this.f9327p.get(i12);
            for (int i13 = 0; i13 < bVar.f9456h; i13++) {
                int i14 = bVar.f9463o + i13;
                View viewR = r(i14);
                if (viewR != null && viewR.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) viewR.getLayoutParams();
                    if (s(i14, i13)) {
                        if (z10) {
                            left = viewR.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        } else {
                            left = (viewR.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f9323l;
                        }
                        p(canvas, left, bVar.f9450b, bVar.f9455g);
                    }
                    if (i13 == bVar.f9456h - 1 && (this.f9321j & 4) > 0) {
                        if (z10) {
                            right = (viewR.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f9323l;
                        } else {
                            right = viewR.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        }
                        p(canvas, right, bVar.f9450b, bVar.f9455g);
                    }
                }
            }
            if (t(i12)) {
                if (z11) {
                    i11 = bVar.f9452d;
                } else {
                    i11 = bVar.f9450b - this.f9322k;
                }
                o(canvas, paddingLeft, i11, iMax);
            }
            if (u(i12) && (this.f9320i & 4) > 0) {
                if (z11) {
                    i10 = bVar.f9450b - this.f9322k;
                } else {
                    i10 = bVar.f9452d;
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
        int size = this.f9327p.size();
        for (int i12 = 0; i12 < size; i12++) {
            b bVar = this.f9327p.get(i12);
            for (int i13 = 0; i13 < bVar.f9456h; i13++) {
                int i14 = bVar.f9463o + i13;
                View viewR = r(i14);
                if (viewR != null && viewR.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) viewR.getLayoutParams();
                    if (s(i14, i13)) {
                        if (z11) {
                            top = viewR.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        } else {
                            top = (viewR.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f9322k;
                        }
                        o(canvas, bVar.f9449a, top, bVar.f9455g);
                    }
                    if (i13 == bVar.f9456h - 1 && (this.f9320i & 4) > 0) {
                        if (z11) {
                            bottom = (viewR.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f9322k;
                        } else {
                            bottom = viewR.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        }
                        o(canvas, bVar.f9449a, bottom, bVar.f9455g);
                    }
                }
            }
            if (t(i12)) {
                if (z10) {
                    i11 = bVar.f9451c;
                } else {
                    i11 = bVar.f9449a - this.f9323l;
                }
                p(canvas, i11, paddingTop, iMax);
            }
            if (u(i12) && (this.f9321j & 4) > 0) {
                if (z10) {
                    i10 = bVar.f9449a - this.f9323l;
                } else {
                    i10 = bVar.f9451c;
                }
                p(canvas, i10, paddingTop, iMax);
            }
        }
    }

    private boolean s(int i10, int i11) {
        if (k(i10, i11)) {
            if (g()) {
                if ((this.f9321j & 1) == 0) {
                    return false;
                }
                return true;
            }
            if ((this.f9320i & 1) == 0) {
                return false;
            }
            return true;
        }
        if (g()) {
            if ((this.f9321j & 2) == 0) {
                return false;
            }
            return true;
        }
        if ((this.f9320i & 2) == 0) {
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

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public View a(int i10) {
        return r(i10);
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int b(int i10, int i11, int i12) {
        return ViewGroup.getChildMeasureSpec(i10, i11, i12);
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public View d(int i10) {
        return getChildAt(i10);
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int e(View view, int i10, int i11) {
        int i12;
        int i13 = 0;
        if (g()) {
            if (s(i10, i11)) {
                i13 = this.f9323l;
            }
            if ((this.f9321j & 4) > 0) {
                i12 = this.f9323l;
            } else {
                return i13;
            }
        } else {
            if (s(i10, i11)) {
                i13 = this.f9322k;
            }
            if ((this.f9320i & 4) > 0) {
                i12 = this.f9322k;
            } else {
                return i13;
            }
        }
        return i13 + i12;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int f(int i10, int i11, int i12) {
        return ViewGroup.getChildMeasureSpec(i10, i11, i12);
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public void j(View view, int i10, int i11, b bVar) {
        if (s(i10, i11)) {
            if (g()) {
                int i12 = bVar.f9453e;
                int i13 = this.f9323l;
                bVar.f9453e = i12 + i13;
                bVar.f9454f += i13;
                return;
            }
            int i14 = bVar.f9453e;
            int i15 = this.f9322k;
            bVar.f9453e = i14 + i15;
            bVar.f9454f += i15;
        }
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public void l(b bVar) {
        if (g()) {
            if ((this.f9321j & 4) > 0) {
                int i10 = bVar.f9453e;
                int i11 = this.f9323l;
                bVar.f9453e = i10 + i11;
                bVar.f9454f += i11;
                return;
            }
            return;
        }
        if ((this.f9320i & 4) > 0) {
            int i12 = bVar.f9453e;
            int i13 = this.f9322k;
            bVar.f9453e = i12 + i13;
            bVar.f9454f += i13;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11;
        boolean z12;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i14 = this.f9312a;
        boolean z13 = false;
        if (i14 != 0) {
            if (i14 != 1) {
                if (i14 != 2) {
                    if (i14 == 3) {
                        if (layoutDirection == 1) {
                            z13 = true;
                        }
                        if (this.f9313b == 2) {
                            z13 = !z13;
                        }
                        w(z13, true, i10, i11, i12, i13);
                        return;
                    }
                    throw new IllegalStateException("Invalid flex direction is set: " + this.f9312a);
                }
                if (layoutDirection == 1) {
                    z13 = true;
                }
                if (this.f9313b == 2) {
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

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public void c(int i10, View view) {
    }
}
