package com.tvc.lib.mobile.ui.widget.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class FlexboxLayoutManagerWrap extends RecyclerView.LayoutManager implements com.tvc.lib.mobile.ui.widget.flexbox.a, RecyclerView.SmoothScroller.ScrollVectorProvider {
    private static final Rect A = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9397d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9400g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private RecyclerView.Recycler f9403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private RecyclerView.State f9404k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private b f9405l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private OrientationHelper f9407n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private OrientationHelper f9408o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private SavedState f9409p;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f9414u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Context f9416w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private View f9417x;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9398e = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<com.tvc.lib.mobile.ui.widget.flexbox.b> f9401h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c f9402i = new c(this);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private a f9406m = new a(this, null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9410q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f9411r = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f9412s = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f9413t = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private SparseArray<View> f9415v = new SparseArray<>();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f9418y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private c.a f9419z = new c.a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f9420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f9421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f9422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f9423d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f9424e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f9425f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f9426g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f9427h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f9428i;

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
            this.f9420a = 0.0f;
            this.f9421b = 1.0f;
            this.f9422c = -1;
            this.f9423d = -1.0f;
            this.f9426g = ViewCompat.MEASURED_SIZE_MASK;
            this.f9427h = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int A() {
            return this.f9427h;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int C() {
            return this.f9426g;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int i() {
            return this.f9422c;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public float k() {
            return this.f9421b;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public int m() {
            return this.f9424e;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public void n(int i10) {
            this.f9424e = i10;
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
            this.f9425f = i10;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public float u() {
            return this.f9420a;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public float v() {
            return this.f9423d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeFloat(this.f9420a);
            parcel.writeFloat(this.f9421b);
            parcel.writeInt(this.f9422c);
            parcel.writeFloat(this.f9423d);
            parcel.writeInt(this.f9424e);
            parcel.writeInt(this.f9425f);
            parcel.writeInt(this.f9426g);
            parcel.writeInt(this.f9427h);
            parcel.writeByte(this.f9428i ? (byte) 1 : (byte) 0);
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
            return this.f9425f;
        }

        @Override // com.tvc.lib.mobile.ui.widget.flexbox.FlexItem
        public boolean z() {
            return this.f9428i;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f9420a = 0.0f;
            this.f9421b = 1.0f;
            this.f9422c = -1;
            this.f9423d = -1.0f;
            this.f9426g = ViewCompat.MEASURED_SIZE_MASK;
            this.f9427h = ViewCompat.MEASURED_SIZE_MASK;
        }

        protected LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.f9420a = 0.0f;
            this.f9421b = 1.0f;
            this.f9422c = -1;
            this.f9423d = -1.0f;
            this.f9426g = ViewCompat.MEASURED_SIZE_MASK;
            this.f9427h = ViewCompat.MEASURED_SIZE_MASK;
            this.f9420a = parcel.readFloat();
            this.f9421b = parcel.readFloat();
            this.f9422c = parcel.readInt();
            this.f9423d = parcel.readFloat();
            this.f9424e = parcel.readInt();
            this.f9425f = parcel.readInt();
            this.f9426g = parcel.readInt();
            this.f9427h = parcel.readInt();
            this.f9428i = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f9430b;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (f) null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }

            a() {
            }
        }

        /* synthetic */ SavedState(Parcel parcel, f fVar) {
            this(parcel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            this.f9429a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* synthetic */ SavedState(SavedState savedState, f fVar) {
            this(savedState);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g(int i10) {
            int i11 = this.f9429a;
            return i11 >= 0 && i11 < i10;
        }

        @NonNull
        public String toString() {
            return "SavedState{mAnchorPosition=" + this.f9429a + ", mAnchorOffset=" + this.f9430b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f9429a);
            parcel.writeInt(this.f9430b);
        }

        SavedState() {
        }

        private SavedState(Parcel parcel) {
            this.f9429a = parcel.readInt();
            this.f9430b = parcel.readInt();
        }

        private SavedState(SavedState savedState) {
            this.f9429a = savedState.f9429a;
            this.f9430b = savedState.f9430b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f9432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f9433c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f9434d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f9435e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f9436f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f9437g;

        /* synthetic */ a(FlexboxLayoutManagerWrap flexboxLayoutManagerWrap, f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s() {
            this.f9431a = -1;
            this.f9432b = -1;
            this.f9433c = Integer.MIN_VALUE;
            this.f9436f = false;
            this.f9437g = false;
            if (FlexboxLayoutManagerWrap.this.g()) {
                if (FlexboxLayoutManagerWrap.this.f9395b == 0) {
                    this.f9435e = FlexboxLayoutManagerWrap.this.f9394a == 1;
                    return;
                } else {
                    this.f9435e = FlexboxLayoutManagerWrap.this.f9395b == 2;
                    return;
                }
            }
            if (FlexboxLayoutManagerWrap.this.f9395b == 0) {
                this.f9435e = FlexboxLayoutManagerWrap.this.f9394a == 3;
            } else {
                this.f9435e = FlexboxLayoutManagerWrap.this.f9395b == 2;
            }
        }

        private a() {
            this.f9434d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q() {
            if (FlexboxLayoutManagerWrap.this.g() || !FlexboxLayoutManagerWrap.this.f9399f) {
                this.f9433c = this.f9435e ? FlexboxLayoutManagerWrap.this.f9407n.getEndAfterPadding() : FlexboxLayoutManagerWrap.this.f9407n.getStartAfterPadding();
            } else {
                this.f9433c = this.f9435e ? FlexboxLayoutManagerWrap.this.f9407n.getEndAfterPadding() : FlexboxLayoutManagerWrap.this.getWidth() - FlexboxLayoutManagerWrap.this.f9407n.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(View view) {
            OrientationHelper orientationHelper = FlexboxLayoutManagerWrap.this.f9395b == 0 ? FlexboxLayoutManagerWrap.this.f9408o : FlexboxLayoutManagerWrap.this.f9407n;
            if (FlexboxLayoutManagerWrap.this.g() || !FlexboxLayoutManagerWrap.this.f9399f) {
                if (this.f9435e) {
                    this.f9433c = orientationHelper.getDecoratedEnd(view) + orientationHelper.getTotalSpaceChange();
                } else {
                    this.f9433c = orientationHelper.getDecoratedStart(view);
                }
            } else if (this.f9435e) {
                this.f9433c = orientationHelper.getDecoratedStart(view) + orientationHelper.getTotalSpaceChange();
            } else {
                this.f9433c = orientationHelper.getDecoratedEnd(view);
            }
            this.f9431a = FlexboxLayoutManagerWrap.this.getPosition(view);
            this.f9437g = false;
            int[] iArr = FlexboxLayoutManagerWrap.this.f9402i.f9469c;
            int i10 = this.f9431a;
            if (i10 == -1) {
                i10 = 0;
            }
            int i11 = iArr[i10];
            this.f9432b = i11 != -1 ? i11 : 0;
            if (FlexboxLayoutManagerWrap.this.f9401h.size() > this.f9432b) {
                this.f9431a = ((com.tvc.lib.mobile.ui.widget.flexbox.b) FlexboxLayoutManagerWrap.this.f9401h.get(this.f9432b)).f9463o;
            }
        }

        @NonNull
        public String toString() {
            return "AnchorInfo{mPosition=" + this.f9431a + ", mFlexLinePosition=" + this.f9432b + ", mCoordinate=" + this.f9433c + ", mPerpendicularCoordinate=" + this.f9434d + ", mLayoutFromEnd=" + this.f9435e + ", mValid=" + this.f9436f + ", mAssignedFromSavedState=" + this.f9437g + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f9440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f9441c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f9442d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f9443e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f9444f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f9445g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f9446h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f9447i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f9448j;

        /* synthetic */ b(f fVar) {
            this();
        }

        private b() {
            this.f9446h = 1;
            this.f9447i = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean u(RecyclerView.State state, List<com.tvc.lib.mobile.ui.widget.flexbox.b> list) {
            int i10;
            int i11 = this.f9442d;
            return i11 >= 0 && i11 < state.getItemCount() && (i10 = this.f9441c) >= 0 && i10 < list.size();
        }

        @NonNull
        public String toString() {
            return "LayoutState{mAvailable=" + this.f9439a + ", mFlexLinePosition=" + this.f9441c + ", mPosition=" + this.f9442d + ", mOffset=" + this.f9443e + ", mScrollingOffset=" + this.f9444f + ", mLastScrollDelta=" + this.f9445g + ", mItemDirection=" + this.f9446h + ", mLayoutDirection=" + this.f9447i + '}';
        }
    }

    private View getChildClosestToStart() {
        return getChildAt(0);
    }

    private View y(int i10) {
        try {
            View viewD = D(0, getChildCount(), i10);
            if (viewD == null) {
                return null;
            }
            int i11 = this.f9402i.f9469c[getPosition(viewD)];
            if (i11 == -1) {
                return null;
            }
            return z(viewD, this.f9401h.get(i11));
        } catch (Exception unused) {
            return null;
        }
    }

    public void V(int i10) {
        if (i10 == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i11 = this.f9395b;
        if (i11 != i10) {
            if (i11 == 0 || i10 == 0) {
                removeAllViews();
                v();
            }
            this.f9395b = i10;
            this.f9407n = null;
            this.f9408o = null;
            requestLayout();
        }
    }

    public int findFirstVisibleItemPosition() {
        View viewC = C(0, getChildCount(), false);
        if (viewC == null) {
            return -1;
        }
        return getPosition(viewC);
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i10, int i11, Object obj) {
        super.onItemsUpdated(recyclerView, i10, i11, obj);
        Z(i10);
    }

    private View C(int i10, int i11, boolean z10) {
        int i12 = i11 > i10 ? 1 : -1;
        while (i10 != i11) {
            View childAt = getChildAt(i10);
            if (K(childAt, z10)) {
                return childAt;
            }
            i10 += i12;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:45:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:50:0x0110  */
    /* JADX WARN: Code duplicated, block: B:53:0x0131  */
    /* JADX WARN: Code duplicated, block: B:54:0x0149  */
    private int M(com.tvc.lib.mobile.ui.widget.flexbox.b bVar, b bVar2) {
        float f10;
        float f11;
        float f12;
        float measuredWidth;
        float measuredWidth2;
        float fMax;
        int iB;
        int i10;
        int i11;
        float f13;
        View viewD;
        float f14;
        int iY;
        int iX;
        LayoutParams layoutParams;
        float leftDecorationWidth;
        float rightDecorationWidth;
        int topDecorationHeight;
        com.tvc.lib.mobile.ui.widget.flexbox.b bVar3 = bVar;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int width = getWidth();
        int i12 = bVar2.f9443e;
        if (bVar2.f9447i == -1) {
            i12 -= bVar3.f9455g;
        }
        int i13 = i12;
        int i14 = bVar2.f9442d;
        int i15 = this.f9396c;
        int i16 = 1;
        if (i15 == 0) {
            f10 = paddingLeft;
            f11 = width - paddingRight;
        } else {
            if (i15 != 1) {
                if (i15 == 2) {
                    int i17 = bVar3.f9453e;
                    f10 = paddingLeft + ((width - i17) / 2.0f);
                    f11 = (width - paddingRight) - ((width - i17) / 2.0f);
                } else if (i15 == 3) {
                    f10 = paddingLeft;
                    int i18 = bVar3.f9456h;
                    f12 = (width - bVar3.f9453e) / (i18 != 1 ? i18 - 1 : 1.0f);
                    f11 = width - paddingRight;
                } else if (i15 == 4) {
                    int i19 = bVar3.f9456h;
                    f12 = i19 != 0 ? (width - bVar3.f9453e) / i19 : 0.0f;
                    float f15 = f12 / 2.0f;
                    f10 = paddingLeft + f15;
                    f11 = (width - paddingRight) - f15;
                } else {
                    if (i15 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.f9396c);
                    }
                    int i20 = bVar3.f9456h;
                    f12 = i20 != 0 ? (width - bVar3.f9453e) / (i20 + 1) : 0.0f;
                    f10 = paddingLeft + f12;
                    f11 = (width - paddingRight) - f12;
                }
                measuredWidth = f10 - this.f9406m.f9434d;
                measuredWidth2 = f11 - this.f9406m.f9434d;
                fMax = Math.max(f12, 0.0f);
                iB = bVar3.b();
                i10 = 0;
                i11 = i14;
                while (i11 < i14 + iB) {
                    f13 = measuredWidth2;
                    viewD = d(i11);
                    if (viewD == null) {
                        measuredWidth2 = f13;
                        f14 = fMax;
                    } else {
                        if (bVar2.f9447i == i16) {
                            calculateItemDecorationsForChild(viewD, A);
                            addView(viewD);
                        } else {
                            calculateItemDecorationsForChild(viewD, A);
                            addView(viewD, i10);
                            i10++;
                        }
                        int i21 = i10;
                        c cVar = this.f9402i;
                        f14 = fMax;
                        long j10 = cVar.f9470d[i11];
                        iY = cVar.y(j10);
                        iX = this.f9402i.x(j10);
                        layoutParams = (LayoutParams) viewD.getLayoutParams();
                        if (shouldMeasureChild(viewD, iY, iX, layoutParams)) {
                            viewD.measure(iY, iX);
                        }
                        leftDecorationWidth = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + getLeftDecorationWidth(viewD);
                        rightDecorationWidth = f13 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(viewD));
                        topDecorationHeight = i13 + getTopDecorationHeight(viewD);
                        if (this.f9399f) {
                            this.f9402i.Q(viewD, bVar3, Math.round(rightDecorationWidth) - viewD.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), viewD.getMeasuredHeight() + topDecorationHeight);
                        } else {
                            this.f9402i.Q(viewD, bVar, Math.round(leftDecorationWidth), topDecorationHeight, viewD.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + viewD.getMeasuredHeight());
                        }
                        measuredWidth = leftDecorationWidth + viewD.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(viewD) + f14;
                        i10 = i21;
                        measuredWidth2 = rightDecorationWidth - (((viewD.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + getLeftDecorationWidth(viewD)) + f14);
                    }
                    i11++;
                    bVar3 = bVar;
                    fMax = f14;
                    i16 = 1;
                }
                bVar2.f9441c += this.f9405l.f9447i;
                return bVar.a();
            }
            int i22 = bVar3.f9453e;
            float f16 = (width - i22) + paddingRight;
            f11 = i22 - paddingLeft;
            f10 = f16;
        }
        f12 = 0.0f;
        measuredWidth = f10 - this.f9406m.f9434d;
        measuredWidth2 = f11 - this.f9406m.f9434d;
        fMax = Math.max(f12, 0.0f);
        iB = bVar3.b();
        i10 = 0;
        i11 = i14;
        while (i11 < i14 + iB) {
            f13 = measuredWidth2;
            viewD = d(i11);
            if (viewD == null) {
                measuredWidth2 = f13;
                f14 = fMax;
            } else {
                if (bVar2.f9447i == i16) {
                    calculateItemDecorationsForChild(viewD, A);
                    addView(viewD);
                } else {
                    calculateItemDecorationsForChild(viewD, A);
                    addView(viewD, i10);
                    i10++;
                }
                int i23 = i10;
                c cVar2 = this.f9402i;
                f14 = fMax;
                long j11 = cVar2.f9470d[i11];
                iY = cVar2.y(j11);
                iX = this.f9402i.x(j11);
                layoutParams = (LayoutParams) viewD.getLayoutParams();
                if (shouldMeasureChild(viewD, iY, iX, layoutParams)) {
                    viewD.measure(iY, iX);
                }
                leftDecorationWidth = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + getLeftDecorationWidth(viewD);
                rightDecorationWidth = f13 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(viewD));
                topDecorationHeight = i13 + getTopDecorationHeight(viewD);
                if (this.f9399f) {
                    this.f9402i.Q(viewD, bVar3, Math.round(rightDecorationWidth) - viewD.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), viewD.getMeasuredHeight() + topDecorationHeight);
                } else {
                    this.f9402i.Q(viewD, bVar, Math.round(leftDecorationWidth), topDecorationHeight, viewD.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + viewD.getMeasuredHeight());
                }
                measuredWidth = leftDecorationWidth + viewD.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(viewD) + f14;
                i10 = i23;
                measuredWidth2 = rightDecorationWidth - (((viewD.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + getLeftDecorationWidth(viewD)) + f14);
            }
            i11++;
            bVar3 = bVar;
            fMax = f14;
            i16 = 1;
        }
        bVar2.f9441c += this.f9405l.f9447i;
        return bVar.a();
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:48:0x011d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0128  */
    /* JADX WARN: Code duplicated, block: B:53:0x0142  */
    /* JADX WARN: Code duplicated, block: B:55:0x0146  */
    /* JADX WARN: Code duplicated, block: B:56:0x0164  */
    /* JADX WARN: Code duplicated, block: B:57:0x0181  */
    /* JADX WARN: Code duplicated, block: B:59:0x0187  */
    /* JADX WARN: Code duplicated, block: B:60:0x01a4  */
    private int N(com.tvc.lib.mobile.ui.widget.flexbox.b bVar, b bVar2) {
        float f10;
        float f11;
        float f12;
        float measuredHeight;
        float measuredHeight2;
        float fMax;
        int iB;
        int i10;
        int i11;
        float f13;
        View viewD;
        float f14;
        int iY;
        int iX;
        LayoutParams layoutParams;
        float topDecorationHeight;
        float bottomDecorationHeight;
        int leftDecorationWidth;
        int rightDecorationWidth;
        boolean z10;
        com.tvc.lib.mobile.ui.widget.flexbox.b bVar3 = bVar;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i12 = bVar2.f9443e;
        int i13 = bVar2.f9443e;
        if (bVar2.f9447i == -1) {
            int i14 = bVar3.f9455g;
            i12 -= i14;
            i13 += i14;
        }
        int i15 = i12;
        int i16 = i13;
        int i17 = bVar2.f9442d;
        int i18 = this.f9396c;
        if (i18 == 0) {
            f10 = paddingTop;
            f11 = height - paddingBottom;
        } else {
            if (i18 != 1) {
                if (i18 == 2) {
                    int i19 = bVar3.f9453e;
                    f10 = paddingTop + ((height - i19) / 2.0f);
                    f11 = (height - paddingBottom) - ((height - i19) / 2.0f);
                } else if (i18 == 3) {
                    f10 = paddingTop;
                    int i20 = bVar3.f9456h;
                    f12 = (height - bVar3.f9453e) / (i20 != 1 ? i20 - 1 : 1.0f);
                    f11 = height - paddingBottom;
                } else if (i18 == 4) {
                    int i21 = bVar3.f9456h;
                    f12 = i21 != 0 ? (height - bVar3.f9453e) / i21 : 0.0f;
                    float f15 = f12 / 2.0f;
                    f10 = paddingTop + f15;
                    f11 = (height - paddingBottom) - f15;
                } else {
                    if (i18 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.f9396c);
                    }
                    int i22 = bVar3.f9456h;
                    f12 = i22 != 0 ? (height - bVar3.f9453e) / (i22 + 1) : 0.0f;
                    f10 = paddingTop + f12;
                    f11 = (height - paddingBottom) - f12;
                }
                measuredHeight = f10 - this.f9406m.f9434d;
                measuredHeight2 = f11 - this.f9406m.f9434d;
                fMax = Math.max(f12, 0.0f);
                iB = bVar3.b();
                i10 = 0;
                i11 = i17;
                while (i11 < i17 + iB) {
                    f13 = measuredHeight2;
                    viewD = d(i11);
                    if (viewD == null) {
                        measuredHeight2 = f13;
                        f14 = fMax;
                    } else {
                        c cVar = this.f9402i;
                        f14 = fMax;
                        long j10 = cVar.f9470d[i11];
                        iY = cVar.y(j10);
                        iX = this.f9402i.x(j10);
                        layoutParams = (LayoutParams) viewD.getLayoutParams();
                        if (shouldMeasureChild(viewD, iY, iX, layoutParams)) {
                            viewD.measure(iY, iX);
                        }
                        topDecorationHeight = measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getTopDecorationHeight(viewD);
                        bottomDecorationHeight = f13 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getBottomDecorationHeight(viewD));
                        if (bVar2.f9447i == 1) {
                            calculateItemDecorationsForChild(viewD, A);
                            addView(viewD);
                        } else {
                            calculateItemDecorationsForChild(viewD, A);
                            addView(viewD, i10);
                            i10++;
                        }
                        int i23 = i10;
                        leftDecorationWidth = getLeftDecorationWidth(viewD) + i15;
                        rightDecorationWidth = i16 - getRightDecorationWidth(viewD);
                        z10 = this.f9399f;
                        if (z10) {
                            if (this.f9400g) {
                                this.f9402i.R(viewD, bVar3, z10, rightDecorationWidth - viewD.getMeasuredWidth(), Math.round(bottomDecorationHeight) - viewD.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                            } else {
                                this.f9402i.R(viewD, bVar, z10, rightDecorationWidth - viewD.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, viewD.getMeasuredHeight() + Math.round(topDecorationHeight));
                            }
                        } else if (this.f9400g) {
                            this.f9402i.R(viewD, bVar, z10, leftDecorationWidth, Math.round(bottomDecorationHeight) - viewD.getMeasuredHeight(), leftDecorationWidth + viewD.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                        } else {
                            this.f9402i.R(viewD, bVar, z10, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + viewD.getMeasuredWidth(), viewD.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                        measuredHeight = topDecorationHeight + viewD.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getBottomDecorationHeight(viewD) + f14;
                        i10 = i23;
                        measuredHeight2 = bottomDecorationHeight - (((viewD.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + getTopDecorationHeight(viewD)) + f14);
                    }
                    i11++;
                    bVar3 = bVar;
                    fMax = f14;
                }
                bVar2.f9441c += this.f9405l.f9447i;
                return bVar.a();
            }
            int i24 = bVar3.f9453e;
            float f16 = (height - i24) + paddingBottom;
            f11 = i24 - paddingTop;
            f10 = f16;
        }
        f12 = 0.0f;
        measuredHeight = f10 - this.f9406m.f9434d;
        measuredHeight2 = f11 - this.f9406m.f9434d;
        fMax = Math.max(f12, 0.0f);
        iB = bVar3.b();
        i10 = 0;
        i11 = i17;
        while (i11 < i17 + iB) {
            f13 = measuredHeight2;
            viewD = d(i11);
            if (viewD == null) {
                measuredHeight2 = f13;
                f14 = fMax;
            } else {
                c cVar2 = this.f9402i;
                f14 = fMax;
                long j11 = cVar2.f9470d[i11];
                iY = cVar2.y(j11);
                iX = this.f9402i.x(j11);
                layoutParams = (LayoutParams) viewD.getLayoutParams();
                if (shouldMeasureChild(viewD, iY, iX, layoutParams)) {
                    viewD.measure(iY, iX);
                }
                topDecorationHeight = measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getTopDecorationHeight(viewD);
                bottomDecorationHeight = f13 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getBottomDecorationHeight(viewD));
                if (bVar2.f9447i == 1) {
                    calculateItemDecorationsForChild(viewD, A);
                    addView(viewD);
                } else {
                    calculateItemDecorationsForChild(viewD, A);
                    addView(viewD, i10);
                    i10++;
                }
                int i25 = i10;
                leftDecorationWidth = getLeftDecorationWidth(viewD) + i15;
                rightDecorationWidth = i16 - getRightDecorationWidth(viewD);
                z10 = this.f9399f;
                if (z10) {
                    if (this.f9400g) {
                        this.f9402i.R(viewD, bVar3, z10, rightDecorationWidth - viewD.getMeasuredWidth(), Math.round(bottomDecorationHeight) - viewD.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                    } else {
                        this.f9402i.R(viewD, bVar, z10, rightDecorationWidth - viewD.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, viewD.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                } else if (this.f9400g) {
                    this.f9402i.R(viewD, bVar, z10, leftDecorationWidth, Math.round(bottomDecorationHeight) - viewD.getMeasuredHeight(), leftDecorationWidth + viewD.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                } else {
                    this.f9402i.R(viewD, bVar, z10, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + viewD.getMeasuredWidth(), viewD.getMeasuredHeight() + Math.round(topDecorationHeight));
                }
                measuredHeight = topDecorationHeight + viewD.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getBottomDecorationHeight(viewD) + f14;
                i10 = i25;
                measuredHeight2 = bottomDecorationHeight - (((viewD.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + getTopDecorationHeight(viewD)) + f14);
            }
            i11++;
            bVar3 = bVar;
            fMax = f14;
        }
        bVar2.f9441c += this.f9405l.f9447i;
        return bVar.a();
    }

    private void Y(RecyclerView.State state, a aVar) {
        if (X(state, aVar, this.f9409p) || W(state, aVar)) {
            return;
        }
        aVar.q();
        aVar.f9431a = 0;
        aVar.f9432b = 0;
    }

    private void b0(int i10, int i11) {
        this.f9405l.f9447i = i10;
        boolean zG = g();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z10 = !zG && this.f9399f;
        if (i10 == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null) {
                return;
            }
            this.f9405l.f9443e = this.f9407n.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View viewB = B(childAt, this.f9401h.get(this.f9402i.f9469c[position]));
            this.f9405l.f9446h = 1;
            b bVar = this.f9405l;
            bVar.f9442d = position + bVar.f9446h;
            if (this.f9402i.f9469c.length <= this.f9405l.f9442d) {
                this.f9405l.f9441c = -1;
            } else {
                b bVar2 = this.f9405l;
                bVar2.f9441c = this.f9402i.f9469c[bVar2.f9442d];
            }
            if (z10) {
                this.f9405l.f9443e = this.f9407n.getDecoratedStart(viewB);
                this.f9405l.f9444f = (-this.f9407n.getDecoratedStart(viewB)) + this.f9407n.getStartAfterPadding();
                b bVar3 = this.f9405l;
                bVar3.f9444f = Math.max(bVar3.f9444f, 0);
            } else {
                this.f9405l.f9443e = this.f9407n.getDecoratedEnd(viewB);
                this.f9405l.f9444f = this.f9407n.getDecoratedEnd(viewB) - this.f9407n.getEndAfterPadding();
            }
            if ((this.f9405l.f9441c == -1 || this.f9405l.f9441c > this.f9401h.size() - 1) && this.f9405l.f9442d <= getFlexItemCount()) {
                int i12 = i11 - this.f9405l.f9444f;
                this.f9419z.a();
                if (i12 > 0) {
                    if (zG) {
                        this.f9402i.d(this.f9419z, iMakeMeasureSpec, iMakeMeasureSpec2, i12, this.f9405l.f9442d, this.f9401h);
                    } else {
                        this.f9402i.g(this.f9419z, iMakeMeasureSpec, iMakeMeasureSpec2, i12, this.f9405l.f9442d, this.f9401h);
                    }
                    this.f9402i.q(iMakeMeasureSpec, iMakeMeasureSpec2, this.f9405l.f9442d);
                    this.f9402i.Y(this.f9405l.f9442d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 == null) {
                return;
            }
            this.f9405l.f9443e = this.f9407n.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View viewZ = z(childAt2, this.f9401h.get(this.f9402i.f9469c[position2]));
            this.f9405l.f9446h = 1;
            int i13 = this.f9402i.f9469c[position2];
            if (i13 == -1) {
                i13 = 0;
            }
            if (i13 > 0) {
                this.f9405l.f9442d = position2 - this.f9401h.get(i13 - 1).b();
            } else {
                this.f9405l.f9442d = -1;
            }
            this.f9405l.f9441c = i13 > 0 ? i13 - 1 : 0;
            if (z10) {
                this.f9405l.f9443e = this.f9407n.getDecoratedEnd(viewZ);
                this.f9405l.f9444f = this.f9407n.getDecoratedEnd(viewZ) - this.f9407n.getEndAfterPadding();
                b bVar4 = this.f9405l;
                bVar4.f9444f = Math.max(bVar4.f9444f, 0);
            } else {
                this.f9405l.f9443e = this.f9407n.getDecoratedStart(viewZ);
                this.f9405l.f9444f = (-this.f9407n.getDecoratedStart(viewZ)) + this.f9407n.getStartAfterPadding();
            }
        }
        b bVar5 = this.f9405l;
        bVar5.f9439a = i11 - bVar5.f9444f;
    }

    private void c0(a aVar, boolean z10, boolean z11) {
        if (z11) {
            R();
        } else {
            this.f9405l.f9440b = false;
        }
        if (g() || !this.f9399f) {
            this.f9405l.f9439a = this.f9407n.getEndAfterPadding() - aVar.f9433c;
        } else {
            this.f9405l.f9439a = aVar.f9433c - getPaddingRight();
        }
        this.f9405l.f9442d = aVar.f9431a;
        this.f9405l.f9446h = 1;
        this.f9405l.f9447i = 1;
        this.f9405l.f9443e = aVar.f9433c;
        this.f9405l.f9444f = Integer.MIN_VALUE;
        this.f9405l.f9441c = aVar.f9432b;
        if (!z10 || this.f9401h.size() <= 1 || aVar.f9432b < 0 || aVar.f9432b >= this.f9401h.size() - 1) {
            return;
        }
        com.tvc.lib.mobile.ui.widget.flexbox.b bVar = this.f9401h.get(aVar.f9432b);
        this.f9405l.f9441c++;
        this.f9405l.f9442d += bVar.b();
    }

    private void d0(a aVar, boolean z10, boolean z11) {
        if (z11) {
            R();
        } else {
            this.f9405l.f9440b = false;
        }
        if (g() || !this.f9399f) {
            this.f9405l.f9439a = aVar.f9433c - this.f9407n.getStartAfterPadding();
        } else {
            this.f9405l.f9439a = (this.f9417x.getWidth() - aVar.f9433c) - this.f9407n.getStartAfterPadding();
        }
        this.f9405l.f9442d = aVar.f9431a;
        this.f9405l.f9446h = 1;
        this.f9405l.f9447i = -1;
        this.f9405l.f9443e = aVar.f9433c;
        this.f9405l.f9444f = Integer.MIN_VALUE;
        this.f9405l.f9441c = aVar.f9432b;
        if (!z10 || aVar.f9432b <= 0 || this.f9401h.size() <= aVar.f9432b) {
            return;
        }
        com.tvc.lib.mobile.ui.widget.flexbox.b bVar = this.f9401h.get(aVar.f9432b);
        this.f9405l.f9441c--;
        this.f9405l.f9442d -= bVar.b();
    }

    private void ensureLayoutState() {
        if (this.f9405l == null) {
            this.f9405l = new b(null);
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i10, int i11) {
        while (i11 >= i10) {
            removeAndRecycleViewAt(i11, recycler);
            i11--;
        }
    }

    private void v() {
        this.f9401h.clear();
        this.f9406m.s();
        this.f9406m.f9434d = 0;
    }

    private void w() {
        if (this.f9407n != null) {
            return;
        }
        if (g()) {
            if (this.f9395b == 0) {
                this.f9407n = OrientationHelper.createHorizontalHelper(this);
                this.f9408o = OrientationHelper.createVerticalHelper(this);
                return;
            } else {
                this.f9407n = OrientationHelper.createVerticalHelper(this);
                this.f9408o = OrientationHelper.createHorizontalHelper(this);
                return;
            }
        }
        if (this.f9395b == 0) {
            this.f9407n = OrientationHelper.createVerticalHelper(this);
            this.f9408o = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.f9407n = OrientationHelper.createHorizontalHelper(this);
            this.f9408o = OrientationHelper.createVerticalHelper(this);
        }
    }

    public void T(int i10) {
        int i11 = this.f9397d;
        if (i11 != i10) {
            if (i11 == 4 || i10 == 4) {
                removeAllViews();
                v();
            }
            this.f9397d = i10;
            requestLayout();
        }
    }

    public void U(int i10) {
        if (this.f9394a != i10) {
            removeAllViews();
            this.f9394a = i10;
            this.f9407n = null;
            this.f9408o = null;
            v();
            requestLayout();
        }
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public void c(int i10, View view) {
        this.f9415v.put(i10, view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.f9395b == 0) {
            return g();
        }
        if (!g()) {
            return true;
        }
        int width = getWidth();
        View view = this.f9417x;
        return width > (view != null ? view.getWidth() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.f9395b == 0) {
            return !g();
        }
        if (!g()) {
            int height = getHeight();
            View view = this.f9417x;
            if (height <= (view != null ? view.getHeight() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public View d(int i10) {
        View view = this.f9415v.get(i10);
        return view != null ? view : this.f9403j.getViewForPosition(i10);
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public boolean g() {
        int i10 = this.f9394a;
        return i10 == 0 || i10 == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getAlignItems() {
        return this.f9397d;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getFlexDirection() {
        return this.f9394a;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getFlexItemCount() {
        return this.f9404k.getItemCount();
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public List<com.tvc.lib.mobile.ui.widget.flexbox.b> getFlexLinesInternal() {
        return this.f9401h;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getFlexWrap() {
        return this.f9395b;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getLargestMainSize() {
        if (this.f9401h.size() == 0) {
            return 0;
        }
        int size = this.f9401h.size();
        int iMax = Integer.MIN_VALUE;
        for (int i10 = 0; i10 < size; i10++) {
            iMax = Math.max(iMax, this.f9401h.get(i10).f9453e);
        }
        return iMax;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getMaxLine() {
        return this.f9398e;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.f9401h.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += this.f9401h.get(i11).f9455g;
        }
        return i10;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public void j(View view, int i10, int i11, com.tvc.lib.mobile.ui.widget.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, A);
        if (g()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.f9453e += leftDecorationWidth;
            bVar.f9454f += leftDecorationWidth;
        } else {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            bVar.f9453e += topDecorationHeight;
            bVar.f9454f += topDecorationHeight;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i10;
        int i11;
        this.f9403j = recycler;
        this.f9404k = state;
        int itemCount = state.getItemCount();
        if (itemCount == 0 && state.isPreLayout()) {
            return;
        }
        S();
        w();
        ensureLayoutState();
        this.f9402i.t(itemCount);
        this.f9402i.u(itemCount);
        this.f9402i.s(itemCount);
        this.f9405l.f9448j = false;
        SavedState savedState = this.f9409p;
        if (savedState != null && savedState.g(itemCount)) {
            this.f9410q = this.f9409p.f9429a;
        }
        if (!this.f9406m.f9436f || this.f9410q != -1 || this.f9409p != null) {
            this.f9406m.s();
            Y(state, this.f9406m);
            this.f9406m.f9436f = true;
        }
        detachAndScrapAttachedViews(recycler);
        if (this.f9406m.f9435e) {
            d0(this.f9406m, false, true);
        } else {
            c0(this.f9406m, false, true);
        }
        a0(itemCount);
        x(recycler, state, this.f9405l);
        if (this.f9406m.f9435e) {
            i11 = this.f9405l.f9443e;
            c0(this.f9406m, true, false);
            x(recycler, state, this.f9405l);
            i10 = this.f9405l.f9443e;
        } else {
            i10 = this.f9405l.f9443e;
            d0(this.f9406m, true, false);
            x(recycler, state, this.f9405l);
            i11 = this.f9405l.f9443e;
        }
        if (getChildCount() > 0) {
            if (this.f9406m.f9435e) {
                fixLayoutStartGap(i11 + fixLayoutEndGap(i10, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i10 + fixLayoutStartGap(i11, recycler, state, true), recycler, state, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f9409p = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.f9409p != null) {
            return new SavedState(this.f9409p, (f) null);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() <= 0) {
            savedState.h();
            return savedState;
        }
        View childClosestToStart = getChildClosestToStart();
        savedState.f9429a = getPosition(childClosestToStart);
        savedState.f9430b = this.f9407n.getDecoratedStart(childClosestToStart) - this.f9407n.getStartAfterPadding();
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i10) {
        this.f9410q = i10;
        this.f9411r = Integer.MIN_VALUE;
        SavedState savedState = this.f9409p;
        if (savedState != null) {
            savedState.h();
        }
        requestLayout();
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public void setFlexLines(List<com.tvc.lib.mobile.ui.widget.flexbox.b> list) {
        this.f9401h = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i10);
        startSmoothScroll(linearSmoothScroller);
    }

    public FlexboxLayoutManagerWrap(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i10, i11);
        int i12 = properties.orientation;
        if (i12 != 0) {
            if (i12 == 1) {
                if (properties.reverseLayout) {
                    U(3);
                } else {
                    U(2);
                }
            }
        } else if (properties.reverseLayout) {
            U(1);
        } else {
            U(0);
        }
        V(1);
        T(4);
        this.f9416w = context;
    }

    private View A(int i10) {
        View viewD = D(getChildCount() - 1, -1, i10);
        if (viewD == null) {
            return null;
        }
        return B(viewD, this.f9401h.get(this.f9402i.f9469c[getPosition(viewD)]));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    private View B(View view, com.tvc.lib.mobile.ui.widget.flexbox.b bVar) {
        boolean zG = g();
        int childCount = (getChildCount() - bVar.f9456h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.f9399f && !zG) {
                    if (this.f9407n.getDecoratedStart(view) > this.f9407n.getDecoratedStart(childAt)) {
                        view = childAt;
                    }
                } else if (this.f9407n.getDecoratedEnd(view) < this.f9407n.getDecoratedEnd(childAt)) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private View D(int i10, int i11, int i12) {
        int i13;
        int position;
        w();
        ensureLayoutState();
        int startAfterPadding = this.f9407n.getStartAfterPadding();
        int endAfterPadding = this.f9407n.getEndAfterPadding();
        if (i11 > i10) {
            i13 = 1;
        } else {
            i13 = -1;
        }
        View view = null;
        View view2 = null;
        while (i10 != i11) {
            View childAt = getChildAt(i10);
            if (childAt != null && (position = getPosition(childAt)) >= 0 && position < i12) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.f9407n.getDecoratedStart(childAt) >= startAfterPadding && this.f9407n.getDecoratedEnd(childAt) <= endAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i10 += i13;
        }
        if (view != null) {
            return view;
        }
        return view2;
    }

    private int E(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    private int F(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    private int G(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    private int H(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    private int I(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z10;
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        w();
        int i11 = 1;
        this.f9405l.f9448j = true;
        if (!g() && this.f9399f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 ? i10 <= 0 : i10 >= 0) {
            i11 = -1;
        }
        int iAbs = Math.abs(i10);
        b0(i11, iAbs);
        int iX = this.f9405l.f9444f + x(recycler, state, this.f9405l);
        if (iX < 0) {
            return 0;
        }
        if (z10) {
            if (iAbs > iX) {
                i10 = (-i11) * iX;
            }
        } else if (iAbs > iX) {
            i10 = i11 * iX;
        }
        this.f9407n.offsetChildren(-i10);
        this.f9405l.f9445g = i10;
        return i10;
    }

    private int J(int i10) {
        int height;
        int height2;
        if (getChildCount() != 0 && i10 != 0) {
            w();
            boolean zG = g();
            View view = this.f9417x;
            if (zG) {
                height = view.getWidth();
            } else {
                height = view.getHeight();
            }
            if (zG) {
                height2 = getWidth();
            } else {
                height2 = getHeight();
            }
            if (getLayoutDirection() == 1) {
                int iAbs = Math.abs(i10);
                if (i10 < 0) {
                    return -Math.min((height2 + this.f9406m.f9434d) - height, iAbs);
                }
                if (this.f9406m.f9434d + i10 > 0) {
                    return -this.f9406m.f9434d;
                }
            } else {
                if (i10 > 0) {
                    return Math.min((height2 - this.f9406m.f9434d) - height, i10);
                }
                if (this.f9406m.f9434d + i10 < 0) {
                    return -this.f9406m.f9434d;
                }
            }
            return i10;
        }
        return 0;
    }

    private boolean K(View view, boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int iF = F(view);
        int iH = H(view);
        int iG = G(view);
        int iE = E(view);
        if (paddingLeft <= iF && width >= iG) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (iF < width && iG < paddingLeft) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (paddingTop <= iH && height >= iE) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (iH < height && iE < paddingTop) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z10) {
            if (z11 && z13) {
                return true;
            }
            return false;
        }
        if (z12 && z14) {
            return true;
        }
        return false;
    }

    private int L(com.tvc.lib.mobile.ui.widget.flexbox.b bVar, b bVar2) {
        if (g()) {
            return M(bVar, bVar2);
        }
        return N(bVar, bVar2);
    }

    private void O(RecyclerView.Recycler recycler, b bVar) {
        if (!bVar.f9448j) {
            return;
        }
        if (bVar.f9447i == -1) {
            P(recycler, bVar);
        } else {
            Q(recycler, bVar);
        }
    }

    private void P(RecyclerView.Recycler recycler, b bVar) {
        int childCount;
        int i10;
        View childAt;
        int i11;
        if (bVar.f9444f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt((i10 = childCount - 1))) == null || (i11 = this.f9402i.f9469c[getPosition(childAt)]) == -1) {
            return;
        }
        com.tvc.lib.mobile.ui.widget.flexbox.b bVar2 = this.f9401h.get(i11);
        for (int i12 = i10; i12 >= 0; i12--) {
            View childAt2 = getChildAt(i12);
            if (childAt2 != null) {
                if (!t(childAt2, bVar.f9444f)) {
                    break;
                }
                if (bVar2.f9463o != getPosition(childAt2)) {
                    continue;
                } else if (i11 <= 0) {
                    childCount = i12;
                    break;
                } else {
                    i11 += bVar.f9447i;
                    bVar2 = this.f9401h.get(i11);
                    childCount = i12;
                }
            }
        }
        recycleChildren(recycler, childCount, i10);
    }

    private void Q(RecyclerView.Recycler recycler, b bVar) {
        int childCount;
        View childAt;
        if (bVar.f9444f >= 0 && (childCount = getChildCount()) != 0 && (childAt = getChildAt(0)) != null) {
            int i10 = this.f9402i.f9469c[getPosition(childAt)];
            int i11 = -1;
            if (i10 == -1) {
                return;
            }
            com.tvc.lib.mobile.ui.widget.flexbox.b bVar2 = this.f9401h.get(i10);
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null) {
                    if (!u(childAt2, bVar.f9444f)) {
                        break;
                    }
                    if (bVar2.f9464p != getPosition(childAt2)) {
                        continue;
                    } else if (i10 >= this.f9401h.size() - 1) {
                        i11 = i12;
                        break;
                    } else {
                        i10 += bVar.f9447i;
                        bVar2 = this.f9401h.get(i10);
                        i11 = i12;
                    }
                }
            }
            recycleChildren(recycler, 0, i11);
        }
    }

    private void R() {
        int widthMode;
        boolean z10;
        if (g()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        b bVar = this.f9405l;
        if (widthMode != 0 && widthMode != Integer.MIN_VALUE) {
            z10 = false;
        } else {
            z10 = true;
        }
        bVar.f9440b = z10;
    }

    private void S() {
        boolean z10;
        boolean z11;
        boolean z12;
        int layoutDirection = getLayoutDirection();
        int i10 = this.f9394a;
        boolean z13 = false;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        this.f9399f = false;
                        this.f9400g = false;
                        return;
                    }
                    if (layoutDirection == 1) {
                        z13 = true;
                    }
                    this.f9399f = z13;
                    if (this.f9395b == 2) {
                        this.f9399f = !z13;
                    }
                    this.f9400g = true;
                    return;
                }
                if (layoutDirection == 1) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                this.f9399f = z12;
                if (this.f9395b == 2) {
                    this.f9399f = !z12;
                }
                this.f9400g = false;
                return;
            }
            if (layoutDirection != 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f9399f = z11;
            if (this.f9395b == 2) {
                z13 = true;
            }
            this.f9400g = z13;
            return;
        }
        if (layoutDirection == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f9399f = z10;
        if (this.f9395b == 2) {
            z13 = true;
        }
        this.f9400g = z13;
    }

    private boolean W(RecyclerView.State state, a aVar) {
        View viewY;
        int startAfterPadding;
        if (getChildCount() == 0) {
            return false;
        }
        if (aVar.f9435e) {
            viewY = A(state.getItemCount());
        } else {
            viewY = y(state.getItemCount());
        }
        if (viewY != null) {
            aVar.r(viewY);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.f9407n.getDecoratedStart(viewY) >= this.f9407n.getEndAfterPadding() || this.f9407n.getDecoratedEnd(viewY) < this.f9407n.getStartAfterPadding()) {
                    if (aVar.f9435e) {
                        startAfterPadding = this.f9407n.getEndAfterPadding();
                    } else {
                        startAfterPadding = this.f9407n.getStartAfterPadding();
                    }
                    aVar.f9433c = startAfterPadding;
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean X(RecyclerView.State state, a aVar, SavedState savedState) {
        int i10;
        View childAt;
        int decoratedStart;
        boolean z10 = false;
        if (!state.isPreLayout() && (i10 = this.f9410q) != -1) {
            if (i10 >= 0 && i10 < state.getItemCount()) {
                aVar.f9431a = this.f9410q;
                aVar.f9432b = this.f9402i.f9469c[aVar.f9431a];
                SavedState savedState2 = this.f9409p;
                if (savedState2 != null && savedState2.g(state.getItemCount())) {
                    aVar.f9433c = this.f9407n.getStartAfterPadding() + savedState.f9430b;
                    aVar.f9437g = true;
                    aVar.f9432b = -1;
                    return true;
                }
                if (this.f9411r == Integer.MIN_VALUE) {
                    View viewFindViewByPosition = findViewByPosition(this.f9410q);
                    if (viewFindViewByPosition != null) {
                        if (this.f9407n.getDecoratedMeasurement(viewFindViewByPosition) > this.f9407n.getTotalSpace()) {
                            aVar.q();
                            return true;
                        }
                        if (this.f9407n.getDecoratedStart(viewFindViewByPosition) - this.f9407n.getStartAfterPadding() < 0) {
                            aVar.f9433c = this.f9407n.getStartAfterPadding();
                            aVar.f9435e = false;
                            return true;
                        }
                        if (this.f9407n.getEndAfterPadding() - this.f9407n.getDecoratedEnd(viewFindViewByPosition) < 0) {
                            aVar.f9433c = this.f9407n.getEndAfterPadding();
                            aVar.f9435e = true;
                            return true;
                        }
                        if (aVar.f9435e) {
                            decoratedStart = this.f9407n.getDecoratedEnd(viewFindViewByPosition) + this.f9407n.getTotalSpaceChange();
                        } else {
                            decoratedStart = this.f9407n.getDecoratedStart(viewFindViewByPosition);
                        }
                        aVar.f9433c = decoratedStart;
                    } else {
                        if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
                            if (this.f9410q < getPosition(childAt)) {
                                z10 = true;
                            }
                            aVar.f9435e = z10;
                        }
                        aVar.q();
                    }
                    return true;
                }
                if (g() || !this.f9399f) {
                    aVar.f9433c = this.f9407n.getStartAfterPadding() + this.f9411r;
                } else {
                    aVar.f9433c = this.f9411r - this.f9407n.getEndPadding();
                }
                return true;
            }
            this.f9410q = -1;
            this.f9411r = Integer.MIN_VALUE;
        }
        return false;
    }

    private void Z(int i10) {
        if (i10 < findLastVisibleItemPosition()) {
            int childCount = getChildCount();
            this.f9402i.t(childCount);
            this.f9402i.u(childCount);
            this.f9402i.s(childCount);
            if (i10 < this.f9402i.f9469c.length) {
                this.f9418y = i10;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart == null) {
                    return;
                }
                this.f9410q = getPosition(childClosestToStart);
                if (!g() && this.f9399f) {
                    this.f9411r = this.f9407n.getDecoratedEnd(childClosestToStart) + this.f9407n.getEndPadding();
                } else {
                    this.f9411r = this.f9407n.getDecoratedStart(childClosestToStart) - this.f9407n.getStartAfterPadding();
                }
            }
        }
    }

    private void a0(int i10) {
        int i11;
        int iMin;
        int i12;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        boolean z10 = false;
        if (g()) {
            int i13 = this.f9412s;
            if (i13 != Integer.MIN_VALUE && i13 != width) {
                z10 = true;
            }
            i11 = this.f9405l.f9440b ? this.f9416w.getResources().getDisplayMetrics().heightPixels : this.f9405l.f9439a;
        } else {
            int i14 = this.f9413t;
            if (i14 != Integer.MIN_VALUE && i14 != height) {
                z10 = true;
            }
            if (!this.f9405l.f9440b) {
                i11 = this.f9405l.f9439a;
            } else {
                i11 = this.f9416w.getResources().getDisplayMetrics().widthPixels;
            }
        }
        int i15 = i11;
        this.f9412s = width;
        this.f9413t = height;
        int i16 = this.f9418y;
        if (i16 == -1 && (this.f9410q != -1 || z10)) {
            if (this.f9406m.f9435e) {
                return;
            }
            this.f9401h.clear();
            this.f9419z.a();
            if (g()) {
                this.f9402i.e(this.f9419z, iMakeMeasureSpec, iMakeMeasureSpec2, i15, this.f9406m.f9431a, this.f9401h);
            } else {
                this.f9402i.h(this.f9419z, iMakeMeasureSpec, iMakeMeasureSpec2, i15, this.f9406m.f9431a, this.f9401h);
            }
            this.f9401h = this.f9419z.f9472a;
            this.f9402i.p(iMakeMeasureSpec, iMakeMeasureSpec2);
            this.f9402i.X();
            a aVar = this.f9406m;
            aVar.f9432b = this.f9402i.f9469c[aVar.f9431a];
            this.f9405l.f9441c = this.f9406m.f9432b;
            return;
        }
        if (i16 == -1) {
            iMin = this.f9406m.f9431a;
        } else {
            iMin = Math.min(i16, this.f9406m.f9431a);
        }
        int i17 = iMin;
        this.f9419z.a();
        if (g()) {
            if (this.f9401h.size() > 0) {
                this.f9402i.j(this.f9401h, i17);
                this.f9402i.b(this.f9419z, iMakeMeasureSpec, iMakeMeasureSpec2, i15, i17, this.f9406m.f9431a, this.f9401h);
                i12 = i17;
            } else {
                i12 = i17;
                this.f9402i.s(i10);
                this.f9402i.d(this.f9419z, iMakeMeasureSpec, iMakeMeasureSpec2, i15, 0, this.f9401h);
            }
        } else {
            i12 = i17;
            if (this.f9401h.size() > 0) {
                this.f9402i.j(this.f9401h, i12);
                i17 = i12;
                this.f9402i.b(this.f9419z, iMakeMeasureSpec2, iMakeMeasureSpec, i15, i17, this.f9406m.f9431a, this.f9401h);
                iMakeMeasureSpec2 = iMakeMeasureSpec2;
                iMakeMeasureSpec = iMakeMeasureSpec;
                i12 = i17;
            } else {
                this.f9402i.s(i10);
                this.f9402i.g(this.f9419z, iMakeMeasureSpec, iMakeMeasureSpec2, i15, 0, this.f9401h);
            }
        }
        this.f9401h = this.f9419z.f9472a;
        this.f9402i.q(iMakeMeasureSpec, iMakeMeasureSpec2, i12);
        this.f9402i.Y(i12);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        w();
        View viewY = y(itemCount);
        View viewA = A(itemCount);
        if (state.getItemCount() == 0 || viewY == null || viewA == null) {
            return 0;
        }
        return Math.min(this.f9407n.getTotalSpace(), this.f9407n.getDecoratedEnd(viewA) - this.f9407n.getDecoratedStart(viewY));
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewY = y(itemCount);
        View viewA = A(itemCount);
        if (state.getItemCount() != 0 && viewY != null && viewA != null) {
            int position = getPosition(viewY);
            int position2 = getPosition(viewA);
            int iAbs = Math.abs(this.f9407n.getDecoratedEnd(viewA) - this.f9407n.getDecoratedStart(viewY));
            int[] iArr = this.f9402i.f9469c;
            int i10 = iArr[position];
            if (i10 != 0 && i10 != -1) {
                return Math.round((i10 * (iAbs / ((iArr[position2] - i10) + 1))) + (this.f9407n.getStartAfterPadding() - this.f9407n.getDecoratedStart(viewY)));
            }
        }
        return 0;
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewY = y(itemCount);
        View viewA = A(itemCount);
        if (state.getItemCount() == 0 || viewY == null || viewA == null) {
            return 0;
        }
        return (int) ((Math.abs(this.f9407n.getDecoratedEnd(viewA) - this.f9407n.getDecoratedStart(viewY)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition()) + 1)) * state.getItemCount());
    }

    private int fixLayoutEndGap(int i10, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z10) {
        int I;
        int endAfterPadding;
        if (!g() && this.f9399f) {
            int startAfterPadding = i10 - this.f9407n.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            I = I(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.f9407n.getEndAfterPadding() - i10;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            I = -I(-endAfterPadding2, recycler, state);
        }
        int i11 = i10 + I;
        if (z10 && (endAfterPadding = this.f9407n.getEndAfterPadding() - i11) > 0) {
            this.f9407n.offsetChildren(endAfterPadding);
            return endAfterPadding + I;
        }
        return I;
    }

    private int fixLayoutStartGap(int i10, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z10) {
        int I;
        int startAfterPadding;
        if (!g() && this.f9399f) {
            int endAfterPadding = this.f9407n.getEndAfterPadding() - i10;
            if (endAfterPadding <= 0) {
                return 0;
            }
            I = I(-endAfterPadding, recycler, state);
        } else {
            int startAfterPadding2 = i10 - this.f9407n.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            I = -I(startAfterPadding2, recycler, state);
        }
        int i11 = i10 + I;
        if (z10 && (startAfterPadding = i11 - this.f9407n.getStartAfterPadding()) > 0) {
            this.f9407n.offsetChildren(-startAfterPadding);
            return I - startAfterPadding;
        }
        return I;
    }

    private static boolean isMeasurementUpToDate(int i10, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (i12 > 0 && i10 != i12) {
            return false;
        }
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                return true;
            }
            if (mode != 1073741824 || size != i10) {
                return false;
            }
            return true;
        }
        if (size < i10) {
            return false;
        }
        return true;
    }

    private boolean shouldMeasureChild(View view, int i10, int i11, RecyclerView.LayoutParams layoutParams) {
        if (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i10, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i11, ((ViewGroup.MarginLayoutParams) layoutParams).height)) {
            return false;
        }
        return true;
    }

    private boolean t(View view, int i10) {
        if (!g() && this.f9399f) {
            if (this.f9407n.getDecoratedEnd(view) > i10) {
                return false;
            }
            return true;
        }
        if (this.f9407n.getDecoratedStart(view) < this.f9407n.getEnd() - i10) {
            return false;
        }
        return true;
    }

    private boolean u(View view, int i10) {
        if (!g() && this.f9399f) {
            if (this.f9407n.getEnd() - this.f9407n.getDecoratedStart(view) > i10) {
                return false;
            }
            return true;
        }
        if (this.f9407n.getDecoratedEnd(view) > i10) {
            return false;
        }
        return true;
    }

    private int x(RecyclerView.Recycler recycler, RecyclerView.State state, b bVar) {
        if (bVar.f9444f != Integer.MIN_VALUE) {
            if (bVar.f9439a < 0) {
                bVar.f9444f += bVar.f9439a;
            }
            O(recycler, bVar);
        }
        int i10 = bVar.f9439a;
        int iA = bVar.f9439a;
        boolean zG = g();
        int iL = 0;
        while (true) {
            if ((iA <= 0 && !this.f9405l.f9440b) || !bVar.u(state, this.f9401h)) {
                break;
            }
            com.tvc.lib.mobile.ui.widget.flexbox.b bVar2 = this.f9401h.get(bVar.f9441c);
            bVar.f9442d = bVar2.f9463o;
            iL += L(bVar2, bVar);
            if (zG || !this.f9399f) {
                bVar.f9443e += bVar2.a() * bVar.f9447i;
            } else {
                bVar.f9443e -= bVar2.a() * bVar.f9447i;
            }
            iA -= bVar2.a();
        }
        bVar.f9439a -= iL;
        if (bVar.f9444f != Integer.MIN_VALUE) {
            bVar.f9444f += iL;
            if (bVar.f9439a < 0) {
                bVar.f9444f += bVar.f9439a;
            }
            O(recycler, bVar);
        }
        return i10 - bVar.f9439a;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    private View z(View view, com.tvc.lib.mobile.ui.widget.flexbox.b bVar) {
        boolean zG = g();
        int i10 = bVar.f9456h;
        for (int i11 = 1; i11 < i10; i11++) {
            View childAt = getChildAt(i11);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.f9399f && !zG) {
                    if (this.f9407n.getDecoratedEnd(view) < this.f9407n.getDecoratedEnd(childAt)) {
                        view = childAt;
                    }
                } else if (this.f9407n.getDecoratedStart(view) > this.f9407n.getDecoratedStart(childAt)) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public View a(int i10) {
        return d(i10);
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int b(int i10, int i11, int i12) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i11, i12, canScrollHorizontally());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(@NonNull RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(@NonNull RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(@NonNull RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i10) {
        View childAt;
        int i11;
        if (getChildCount() == 0 || (childAt = getChildAt(0)) == null) {
            return null;
        }
        if (i10 < getPosition(childAt)) {
            i11 = -1;
        } else {
            i11 = 1;
        }
        if (g()) {
            return new PointF(0.0f, i11);
        }
        return new PointF(i11, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(@NonNull RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(@NonNull RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(@NonNull RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int e(View view, int i10, int i11) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (g()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int f(int i10, int i11, int i12) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i11, i12, canScrollVertically());
    }

    public int findLastVisibleItemPosition() {
        View viewC = C(getChildCount() - 1, -1, false);
        if (viewC == null) {
            return -1;
        }
        return getPosition(viewC);
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public int h(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (g()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f9417x = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.f9414u) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i10, int i11) {
        super.onItemsAdded(recyclerView, i10, i11);
        Z(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(@NonNull RecyclerView recyclerView, int i10, int i11, int i12) {
        super.onItemsMoved(recyclerView, i10, i11, i12);
        Z(Math.min(i10, i11));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i10, int i11) {
        super.onItemsRemoved(recyclerView, i10, i11);
        Z(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i10, int i11) {
        super.onItemsUpdated(recyclerView, i10, i11);
        Z(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f9409p = null;
        this.f9410q = -1;
        this.f9411r = Integer.MIN_VALUE;
        this.f9418y = -1;
        this.f9406m.s();
        this.f9415v.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (g() && this.f9395b != 0) {
            int iJ = J(i10);
            this.f9406m.f9434d += iJ;
            this.f9408o.offsetChildren(-iJ);
            return iJ;
        }
        int I = I(i10, recycler, state);
        this.f9415v.clear();
        return I;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!g() && (this.f9395b != 0 || g())) {
            int iJ = J(i10);
            this.f9406m.f9434d += iJ;
            this.f9408o.offsetChildren(-iJ);
            return iJ;
        }
        int I = I(i10, recycler, state);
        this.f9415v.clear();
        return I;
    }

    @Override // com.tvc.lib.mobile.ui.widget.flexbox.a
    public void l(com.tvc.lib.mobile.ui.widget.flexbox.b bVar) {
    }
}
