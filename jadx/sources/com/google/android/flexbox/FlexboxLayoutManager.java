package com.google.android.flexbox;

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
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements com.google.android.flexbox.a, RecyclerView.SmoothScroller.ScrollVectorProvider {
    private static final Rect A = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1996d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1999g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private RecyclerView.Recycler f2002j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private RecyclerView.State f2003k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private c f2004l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private OrientationHelper f2006n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private OrientationHelper f2007o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private SavedState f2008p;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f2013u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Context f2015w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private View f2016x;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1997e = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<com.google.android.flexbox.b> f2000h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.google.android.flexbox.c f2001i = new com.google.android.flexbox.c(this);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private b f2005m = new b(this, null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f2009q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f2010r = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f2011s = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f2012t = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private SparseArray<View> f2014v = new SparseArray<>();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f2017y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private com.google.android.flexbox.c.b f2018z = new com.google.android.flexbox.c.b();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f2019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f2020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f2022d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f2023e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f2024f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f2025g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f2026h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f2027i;

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
            this.f2019a = 0.0f;
            this.f2020b = 1.0f;
            this.f2021c = -1;
            this.f2022d = -1.0f;
            this.f2025g = ViewCompat.MEASURED_SIZE_MASK;
            this.f2026h = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int A() {
            return this.f2026h;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int C() {
            return this.f2025g;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int i() {
            return this.f2021c;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float k() {
            return this.f2020b;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int m() {
            return this.f2023e;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void n(int i10) {
            this.f2023e = i10;
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
            this.f2024f = i10;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float u() {
            return this.f2019a;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float v() {
            return this.f2022d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeFloat(this.f2019a);
            parcel.writeFloat(this.f2020b);
            parcel.writeInt(this.f2021c);
            parcel.writeFloat(this.f2022d);
            parcel.writeInt(this.f2023e);
            parcel.writeInt(this.f2024f);
            parcel.writeInt(this.f2025g);
            parcel.writeInt(this.f2026h);
            parcel.writeByte(this.f2027i ? (byte) 1 : (byte) 0);
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
            return this.f2024f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean z() {
            return this.f2027i;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f2019a = 0.0f;
            this.f2020b = 1.0f;
            this.f2021c = -1;
            this.f2022d = -1.0f;
            this.f2025g = ViewCompat.MEASURED_SIZE_MASK;
            this.f2026h = ViewCompat.MEASURED_SIZE_MASK;
        }

        protected LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.f2019a = 0.0f;
            this.f2020b = 1.0f;
            this.f2021c = -1;
            this.f2022d = -1.0f;
            this.f2025g = ViewCompat.MEASURED_SIZE_MASK;
            this.f2026h = ViewCompat.MEASURED_SIZE_MASK;
            this.f2019a = parcel.readFloat();
            this.f2020b = parcel.readFloat();
            this.f2021c = parcel.readInt();
            this.f2022d = parcel.readFloat();
            this.f2023e = parcel.readInt();
            this.f2024f = parcel.readInt();
            this.f2025g = parcel.readInt();
            this.f2026h = parcel.readInt();
            this.f2027i = parcel.readByte() != 0;
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
        private int f2028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2029b;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (a) null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }

            a() {
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            this.f2028a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* synthetic */ SavedState(SavedState savedState, a aVar) {
            this(savedState);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g(int i10) {
            int i11 = this.f2028a;
            return i11 >= 0 && i11 < i10;
        }

        @NonNull
        public String toString() {
            return "SavedState{mAnchorPosition=" + this.f2028a + ", mAnchorOffset=" + this.f2029b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f2028a);
            parcel.writeInt(this.f2029b);
        }

        SavedState() {
        }

        private SavedState(Parcel parcel) {
            this.f2028a = parcel.readInt();
            this.f2029b = parcel.readInt();
        }

        private SavedState(SavedState savedState) {
            this.f2028a = savedState.f2028a;
            this.f2029b = savedState.f2029b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2031b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2032c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2033d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2034e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f2035f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f2036g;

        private b() {
            this.f2033d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t() {
            this.f2030a = -1;
            this.f2031b = -1;
            this.f2032c = Integer.MIN_VALUE;
            this.f2035f = false;
            this.f2036g = false;
            if (FlexboxLayoutManager.this.g()) {
                if (FlexboxLayoutManager.this.f1994b == 0) {
                    this.f2034e = FlexboxLayoutManager.this.f1993a == 1;
                    return;
                } else {
                    this.f2034e = FlexboxLayoutManager.this.f1994b == 2;
                    return;
                }
            }
            if (FlexboxLayoutManager.this.f1994b == 0) {
                this.f2034e = FlexboxLayoutManager.this.f1993a == 3;
            } else {
                this.f2034e = FlexboxLayoutManager.this.f1994b == 2;
            }
        }

        static /* synthetic */ int l(b bVar, int i10) {
            int i11 = bVar.f2033d + i10;
            bVar.f2033d = i11;
            return i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r() {
            if (FlexboxLayoutManager.this.g() || !FlexboxLayoutManager.this.f1998f) {
                this.f2032c = this.f2034e ? FlexboxLayoutManager.this.f2006n.getEndAfterPadding() : FlexboxLayoutManager.this.f2006n.getStartAfterPadding();
            } else {
                this.f2032c = this.f2034e ? FlexboxLayoutManager.this.f2006n.getEndAfterPadding() : FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.f2006n.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(View view) {
            OrientationHelper orientationHelper = FlexboxLayoutManager.this.f1994b == 0 ? FlexboxLayoutManager.this.f2007o : FlexboxLayoutManager.this.f2006n;
            if (FlexboxLayoutManager.this.g() || !FlexboxLayoutManager.this.f1998f) {
                if (this.f2034e) {
                    this.f2032c = orientationHelper.getDecoratedEnd(view) + orientationHelper.getTotalSpaceChange();
                } else {
                    this.f2032c = orientationHelper.getDecoratedStart(view);
                }
            } else if (this.f2034e) {
                this.f2032c = orientationHelper.getDecoratedStart(view) + orientationHelper.getTotalSpaceChange();
            } else {
                this.f2032c = orientationHelper.getDecoratedEnd(view);
            }
            this.f2030a = FlexboxLayoutManager.this.getPosition(view);
            this.f2036g = false;
            int[] iArr = FlexboxLayoutManager.this.f2001i.f2068c;
            int i10 = this.f2030a;
            if (i10 == -1) {
                i10 = 0;
            }
            int i11 = iArr[i10];
            this.f2031b = i11 != -1 ? i11 : 0;
            if (FlexboxLayoutManager.this.f2000h.size() > this.f2031b) {
                this.f2030a = ((com.google.android.flexbox.b) FlexboxLayoutManager.this.f2000h.get(this.f2031b)).f2062o;
            }
        }

        @NonNull
        public String toString() {
            return "AnchorInfo{mPosition=" + this.f2030a + ", mFlexLinePosition=" + this.f2031b + ", mCoordinate=" + this.f2032c + ", mPerpendicularCoordinate=" + this.f2033d + ", mLayoutFromEnd=" + this.f2034e + ", mValid=" + this.f2035f + ", mAssignedFromSavedState=" + this.f2036g + '}';
        }

        /* synthetic */ b(FlexboxLayoutManager flexboxLayoutManager, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2041d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f2042e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f2043f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f2044g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f2045h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f2046i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f2047j;

        private c() {
            this.f2045h = 1;
            this.f2046i = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean D(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            int i10;
            int i11 = this.f2041d;
            return i11 >= 0 && i11 < state.getItemCount() && (i10 = this.f2040c) >= 0 && i10 < list.size();
        }

        static /* synthetic */ int c(c cVar, int i10) {
            int i11 = cVar.f2042e + i10;
            cVar.f2042e = i11;
            return i11;
        }

        static /* synthetic */ int d(c cVar, int i10) {
            int i11 = cVar.f2042e - i10;
            cVar.f2042e = i11;
            return i11;
        }

        static /* synthetic */ int i(c cVar, int i10) {
            int i11 = cVar.f2038a - i10;
            cVar.f2038a = i11;
            return i11;
        }

        static /* synthetic */ int l(c cVar) {
            int i10 = cVar.f2040c;
            cVar.f2040c = i10 + 1;
            return i10;
        }

        static /* synthetic */ int m(c cVar) {
            int i10 = cVar.f2040c;
            cVar.f2040c = i10 - 1;
            return i10;
        }

        static /* synthetic */ int n(c cVar, int i10) {
            int i11 = cVar.f2040c + i10;
            cVar.f2040c = i11;
            return i11;
        }

        static /* synthetic */ int q(c cVar, int i10) {
            int i11 = cVar.f2043f + i10;
            cVar.f2043f = i11;
            return i11;
        }

        static /* synthetic */ int u(c cVar, int i10) {
            int i11 = cVar.f2041d + i10;
            cVar.f2041d = i11;
            return i11;
        }

        static /* synthetic */ int v(c cVar, int i10) {
            int i11 = cVar.f2041d - i10;
            cVar.f2041d = i11;
            return i11;
        }

        @NonNull
        public String toString() {
            return "LayoutState{mAvailable=" + this.f2038a + ", mFlexLinePosition=" + this.f2040c + ", mPosition=" + this.f2041d + ", mOffset=" + this.f2042e + ", mScrollingOffset=" + this.f2043f + ", mLastScrollDelta=" + this.f2044g + ", mItemDirection=" + this.f2045h + ", mLayoutDirection=" + this.f2046i + '}';
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    private View getChildClosestToStart() {
        return getChildAt(0);
    }

    private View y(int i10) {
        View viewD = D(0, getChildCount(), i10);
        if (viewD == null) {
            return null;
        }
        int i11 = this.f2001i.f2068c[getPosition(viewD)];
        if (i11 == -1) {
            return null;
        }
        return z(viewD, this.f2000h.get(i11));
    }

    public void V(int i10) {
        if (i10 == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i11 = this.f1994b;
        if (i11 != i10) {
            if (i11 == 0 || i10 == 0) {
                removeAllViews();
                v();
            }
            this.f1994b = i10;
            this.f2006n = null;
            this.f2007o = null;
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

    @Override // com.google.android.flexbox.a
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
    private int M(com.google.android.flexbox.b bVar, c cVar) {
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
        com.google.android.flexbox.b bVar2 = bVar;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int width = getWidth();
        int i12 = cVar.f2042e;
        if (cVar.f2046i == -1) {
            i12 -= bVar2.f2054g;
        }
        int i13 = i12;
        int i14 = cVar.f2041d;
        int i15 = this.f1995c;
        int i16 = 1;
        if (i15 == 0) {
            f10 = paddingLeft;
            f11 = width - paddingRight;
        } else {
            if (i15 != 1) {
                if (i15 == 2) {
                    int i17 = bVar2.f2052e;
                    f10 = paddingLeft + ((width - i17) / 2.0f);
                    f11 = (width - paddingRight) - ((width - i17) / 2.0f);
                } else if (i15 == 3) {
                    f10 = paddingLeft;
                    int i18 = bVar2.f2055h;
                    f12 = (width - bVar2.f2052e) / (i18 != 1 ? i18 - 1 : 1.0f);
                    f11 = width - paddingRight;
                } else if (i15 == 4) {
                    int i19 = bVar2.f2055h;
                    f12 = i19 != 0 ? (width - bVar2.f2052e) / i19 : 0.0f;
                    float f15 = f12 / 2.0f;
                    f10 = paddingLeft + f15;
                    f11 = (width - paddingRight) - f15;
                } else {
                    if (i15 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.f1995c);
                    }
                    int i20 = bVar2.f2055h;
                    f12 = i20 != 0 ? (width - bVar2.f2052e) / (i20 + 1) : 0.0f;
                    f10 = paddingLeft + f12;
                    f11 = (width - paddingRight) - f12;
                }
                measuredWidth = f10 - this.f2005m.f2033d;
                measuredWidth2 = f11 - this.f2005m.f2033d;
                fMax = Math.max(f12, 0.0f);
                iB = bVar2.b();
                i10 = 0;
                i11 = i14;
                while (i11 < i14 + iB) {
                    f13 = measuredWidth2;
                    viewD = d(i11);
                    if (viewD == null) {
                        measuredWidth2 = f13;
                        f14 = fMax;
                    } else {
                        if (cVar.f2046i == i16) {
                            calculateItemDecorationsForChild(viewD, A);
                            addView(viewD);
                        } else {
                            calculateItemDecorationsForChild(viewD, A);
                            addView(viewD, i10);
                            i10++;
                        }
                        int i21 = i10;
                        com.google.android.flexbox.c cVar2 = this.f2001i;
                        f14 = fMax;
                        long j10 = cVar2.f2069d[i11];
                        iY = cVar2.y(j10);
                        iX = this.f2001i.x(j10);
                        layoutParams = (LayoutParams) viewD.getLayoutParams();
                        if (shouldMeasureChild(viewD, iY, iX, layoutParams)) {
                            viewD.measure(iY, iX);
                        }
                        leftDecorationWidth = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + getLeftDecorationWidth(viewD);
                        rightDecorationWidth = f13 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(viewD));
                        topDecorationHeight = i13 + getTopDecorationHeight(viewD);
                        if (this.f1998f) {
                            this.f2001i.Q(viewD, bVar2, Math.round(rightDecorationWidth) - viewD.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), viewD.getMeasuredHeight() + topDecorationHeight);
                        } else {
                            this.f2001i.Q(viewD, bVar, Math.round(leftDecorationWidth), topDecorationHeight, viewD.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + viewD.getMeasuredHeight());
                        }
                        measuredWidth = leftDecorationWidth + viewD.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(viewD) + f14;
                        i10 = i21;
                        measuredWidth2 = rightDecorationWidth - (((viewD.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + getLeftDecorationWidth(viewD)) + f14);
                    }
                    i11++;
                    bVar2 = bVar;
                    fMax = f14;
                    i16 = 1;
                }
                c.n(cVar, this.f2004l.f2046i);
                return bVar.a();
            }
            int i22 = bVar2.f2052e;
            float f16 = (width - i22) + paddingRight;
            f11 = i22 - paddingLeft;
            f10 = f16;
        }
        f12 = 0.0f;
        measuredWidth = f10 - this.f2005m.f2033d;
        measuredWidth2 = f11 - this.f2005m.f2033d;
        fMax = Math.max(f12, 0.0f);
        iB = bVar2.b();
        i10 = 0;
        i11 = i14;
        while (i11 < i14 + iB) {
            f13 = measuredWidth2;
            viewD = d(i11);
            if (viewD == null) {
                measuredWidth2 = f13;
                f14 = fMax;
            } else {
                if (cVar.f2046i == i16) {
                    calculateItemDecorationsForChild(viewD, A);
                    addView(viewD);
                } else {
                    calculateItemDecorationsForChild(viewD, A);
                    addView(viewD, i10);
                    i10++;
                }
                int i23 = i10;
                com.google.android.flexbox.c cVar3 = this.f2001i;
                f14 = fMax;
                long j11 = cVar3.f2069d[i11];
                iY = cVar3.y(j11);
                iX = this.f2001i.x(j11);
                layoutParams = (LayoutParams) viewD.getLayoutParams();
                if (shouldMeasureChild(viewD, iY, iX, layoutParams)) {
                    viewD.measure(iY, iX);
                }
                leftDecorationWidth = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + getLeftDecorationWidth(viewD);
                rightDecorationWidth = f13 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(viewD));
                topDecorationHeight = i13 + getTopDecorationHeight(viewD);
                if (this.f1998f) {
                    this.f2001i.Q(viewD, bVar2, Math.round(rightDecorationWidth) - viewD.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), viewD.getMeasuredHeight() + topDecorationHeight);
                } else {
                    this.f2001i.Q(viewD, bVar, Math.round(leftDecorationWidth), topDecorationHeight, viewD.getMeasuredWidth() + Math.round(leftDecorationWidth), topDecorationHeight + viewD.getMeasuredHeight());
                }
                measuredWidth = leftDecorationWidth + viewD.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(viewD) + f14;
                i10 = i23;
                measuredWidth2 = rightDecorationWidth - (((viewD.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + getLeftDecorationWidth(viewD)) + f14);
            }
            i11++;
            bVar2 = bVar;
            fMax = f14;
            i16 = 1;
        }
        c.n(cVar, this.f2004l.f2046i);
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
    private int N(com.google.android.flexbox.b bVar, c cVar) {
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
        com.google.android.flexbox.b bVar2 = bVar;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i12 = cVar.f2042e;
        int i13 = cVar.f2042e;
        if (cVar.f2046i == -1) {
            int i14 = bVar2.f2054g;
            i12 -= i14;
            i13 += i14;
        }
        int i15 = i12;
        int i16 = i13;
        int i17 = cVar.f2041d;
        int i18 = this.f1995c;
        if (i18 == 0) {
            f10 = paddingTop;
            f11 = height - paddingBottom;
        } else {
            if (i18 != 1) {
                if (i18 == 2) {
                    int i19 = bVar2.f2052e;
                    f10 = paddingTop + ((height - i19) / 2.0f);
                    f11 = (height - paddingBottom) - ((height - i19) / 2.0f);
                } else if (i18 == 3) {
                    f10 = paddingTop;
                    int i20 = bVar2.f2055h;
                    f12 = (height - bVar2.f2052e) / (i20 != 1 ? i20 - 1 : 1.0f);
                    f11 = height - paddingBottom;
                } else if (i18 == 4) {
                    int i21 = bVar2.f2055h;
                    f12 = i21 != 0 ? (height - bVar2.f2052e) / i21 : 0.0f;
                    float f15 = f12 / 2.0f;
                    f10 = paddingTop + f15;
                    f11 = (height - paddingBottom) - f15;
                } else {
                    if (i18 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.f1995c);
                    }
                    int i22 = bVar2.f2055h;
                    f12 = i22 != 0 ? (height - bVar2.f2052e) / (i22 + 1) : 0.0f;
                    f10 = paddingTop + f12;
                    f11 = (height - paddingBottom) - f12;
                }
                measuredHeight = f10 - this.f2005m.f2033d;
                measuredHeight2 = f11 - this.f2005m.f2033d;
                fMax = Math.max(f12, 0.0f);
                iB = bVar2.b();
                i10 = 0;
                i11 = i17;
                while (i11 < i17 + iB) {
                    f13 = measuredHeight2;
                    viewD = d(i11);
                    if (viewD == null) {
                        measuredHeight2 = f13;
                        f14 = fMax;
                    } else {
                        com.google.android.flexbox.c cVar2 = this.f2001i;
                        f14 = fMax;
                        long j10 = cVar2.f2069d[i11];
                        iY = cVar2.y(j10);
                        iX = this.f2001i.x(j10);
                        layoutParams = (LayoutParams) viewD.getLayoutParams();
                        if (shouldMeasureChild(viewD, iY, iX, layoutParams)) {
                            viewD.measure(iY, iX);
                        }
                        topDecorationHeight = measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getTopDecorationHeight(viewD);
                        bottomDecorationHeight = f13 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getBottomDecorationHeight(viewD));
                        if (cVar.f2046i == 1) {
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
                        z10 = this.f1998f;
                        if (z10) {
                            if (this.f1999g) {
                                this.f2001i.R(viewD, bVar2, z10, rightDecorationWidth - viewD.getMeasuredWidth(), Math.round(bottomDecorationHeight) - viewD.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                            } else {
                                this.f2001i.R(viewD, bVar, z10, rightDecorationWidth - viewD.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, viewD.getMeasuredHeight() + Math.round(topDecorationHeight));
                            }
                        } else if (this.f1999g) {
                            this.f2001i.R(viewD, bVar, z10, leftDecorationWidth, Math.round(bottomDecorationHeight) - viewD.getMeasuredHeight(), leftDecorationWidth + viewD.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                        } else {
                            this.f2001i.R(viewD, bVar, z10, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + viewD.getMeasuredWidth(), viewD.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                        measuredHeight = topDecorationHeight + viewD.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getBottomDecorationHeight(viewD) + f14;
                        i10 = i23;
                        measuredHeight2 = bottomDecorationHeight - (((viewD.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + getTopDecorationHeight(viewD)) + f14);
                    }
                    i11++;
                    bVar2 = bVar;
                    fMax = f14;
                }
                c.n(cVar, this.f2004l.f2046i);
                return bVar.a();
            }
            int i24 = bVar2.f2052e;
            float f16 = (height - i24) + paddingBottom;
            f11 = i24 - paddingTop;
            f10 = f16;
        }
        f12 = 0.0f;
        measuredHeight = f10 - this.f2005m.f2033d;
        measuredHeight2 = f11 - this.f2005m.f2033d;
        fMax = Math.max(f12, 0.0f);
        iB = bVar2.b();
        i10 = 0;
        i11 = i17;
        while (i11 < i17 + iB) {
            f13 = measuredHeight2;
            viewD = d(i11);
            if (viewD == null) {
                measuredHeight2 = f13;
                f14 = fMax;
            } else {
                com.google.android.flexbox.c cVar3 = this.f2001i;
                f14 = fMax;
                long j11 = cVar3.f2069d[i11];
                iY = cVar3.y(j11);
                iX = this.f2001i.x(j11);
                layoutParams = (LayoutParams) viewD.getLayoutParams();
                if (shouldMeasureChild(viewD, iY, iX, layoutParams)) {
                    viewD.measure(iY, iX);
                }
                topDecorationHeight = measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getTopDecorationHeight(viewD);
                bottomDecorationHeight = f13 - (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getBottomDecorationHeight(viewD));
                if (cVar.f2046i == 1) {
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
                z10 = this.f1998f;
                if (z10) {
                    if (this.f1999g) {
                        this.f2001i.R(viewD, bVar2, z10, rightDecorationWidth - viewD.getMeasuredWidth(), Math.round(bottomDecorationHeight) - viewD.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                    } else {
                        this.f2001i.R(viewD, bVar, z10, rightDecorationWidth - viewD.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, viewD.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                } else if (this.f1999g) {
                    this.f2001i.R(viewD, bVar, z10, leftDecorationWidth, Math.round(bottomDecorationHeight) - viewD.getMeasuredHeight(), leftDecorationWidth + viewD.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                } else {
                    this.f2001i.R(viewD, bVar, z10, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + viewD.getMeasuredWidth(), viewD.getMeasuredHeight() + Math.round(topDecorationHeight));
                }
                measuredHeight = topDecorationHeight + viewD.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getBottomDecorationHeight(viewD) + f14;
                i10 = i25;
                measuredHeight2 = bottomDecorationHeight - (((viewD.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + getTopDecorationHeight(viewD)) + f14);
            }
            i11++;
            bVar2 = bVar;
            fMax = f14;
        }
        c.n(cVar, this.f2004l.f2046i);
        return bVar.a();
    }

    private void Y(RecyclerView.State state, b bVar) {
        if (X(state, bVar, this.f2008p) || W(state, bVar)) {
            return;
        }
        bVar.r();
        bVar.f2030a = 0;
        bVar.f2031b = 0;
    }

    private void b0(int i10, int i11) {
        this.f2004l.f2046i = i10;
        boolean zG = g();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z10 = !zG && this.f1998f;
        if (i10 == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null) {
                return;
            }
            this.f2004l.f2042e = this.f2006n.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View viewB = B(childAt, this.f2000h.get(this.f2001i.f2068c[position]));
            this.f2004l.f2045h = 1;
            c cVar = this.f2004l;
            cVar.f2041d = position + cVar.f2045h;
            if (this.f2001i.f2068c.length <= this.f2004l.f2041d) {
                this.f2004l.f2040c = -1;
            } else {
                c cVar2 = this.f2004l;
                cVar2.f2040c = this.f2001i.f2068c[cVar2.f2041d];
            }
            if (z10) {
                this.f2004l.f2042e = this.f2006n.getDecoratedStart(viewB);
                this.f2004l.f2043f = (-this.f2006n.getDecoratedStart(viewB)) + this.f2006n.getStartAfterPadding();
                c cVar3 = this.f2004l;
                cVar3.f2043f = Math.max(cVar3.f2043f, 0);
            } else {
                this.f2004l.f2042e = this.f2006n.getDecoratedEnd(viewB);
                this.f2004l.f2043f = this.f2006n.getDecoratedEnd(viewB) - this.f2006n.getEndAfterPadding();
            }
            if ((this.f2004l.f2040c == -1 || this.f2004l.f2040c > this.f2000h.size() - 1) && this.f2004l.f2041d <= getFlexItemCount()) {
                int i12 = i11 - this.f2004l.f2043f;
                this.f2018z.a();
                if (i12 > 0) {
                    if (zG) {
                        this.f2001i.d(this.f2018z, iMakeMeasureSpec, iMakeMeasureSpec2, i12, this.f2004l.f2041d, this.f2000h);
                    } else {
                        this.f2001i.g(this.f2018z, iMakeMeasureSpec, iMakeMeasureSpec2, i12, this.f2004l.f2041d, this.f2000h);
                    }
                    this.f2001i.q(iMakeMeasureSpec, iMakeMeasureSpec2, this.f2004l.f2041d);
                    this.f2001i.Y(this.f2004l.f2041d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 == null) {
                return;
            }
            this.f2004l.f2042e = this.f2006n.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View viewZ = z(childAt2, this.f2000h.get(this.f2001i.f2068c[position2]));
            this.f2004l.f2045h = 1;
            int i13 = this.f2001i.f2068c[position2];
            if (i13 == -1) {
                i13 = 0;
            }
            if (i13 > 0) {
                this.f2004l.f2041d = position2 - this.f2000h.get(i13 - 1).b();
            } else {
                this.f2004l.f2041d = -1;
            }
            this.f2004l.f2040c = i13 > 0 ? i13 - 1 : 0;
            if (z10) {
                this.f2004l.f2042e = this.f2006n.getDecoratedEnd(viewZ);
                this.f2004l.f2043f = this.f2006n.getDecoratedEnd(viewZ) - this.f2006n.getEndAfterPadding();
                c cVar4 = this.f2004l;
                cVar4.f2043f = Math.max(cVar4.f2043f, 0);
            } else {
                this.f2004l.f2042e = this.f2006n.getDecoratedStart(viewZ);
                this.f2004l.f2043f = (-this.f2006n.getDecoratedStart(viewZ)) + this.f2006n.getStartAfterPadding();
            }
        }
        c cVar5 = this.f2004l;
        cVar5.f2038a = i11 - cVar5.f2043f;
    }

    private void c0(b bVar, boolean z10, boolean z11) {
        if (z11) {
            R();
        } else {
            this.f2004l.f2039b = false;
        }
        if (g() || !this.f1998f) {
            this.f2004l.f2038a = this.f2006n.getEndAfterPadding() - bVar.f2032c;
        } else {
            this.f2004l.f2038a = bVar.f2032c - getPaddingRight();
        }
        this.f2004l.f2041d = bVar.f2030a;
        this.f2004l.f2045h = 1;
        this.f2004l.f2046i = 1;
        this.f2004l.f2042e = bVar.f2032c;
        this.f2004l.f2043f = Integer.MIN_VALUE;
        this.f2004l.f2040c = bVar.f2031b;
        if (!z10 || this.f2000h.size() <= 1 || bVar.f2031b < 0 || bVar.f2031b >= this.f2000h.size() - 1) {
            return;
        }
        com.google.android.flexbox.b bVar2 = this.f2000h.get(bVar.f2031b);
        c.l(this.f2004l);
        c.u(this.f2004l, bVar2.b());
    }

    private void d0(b bVar, boolean z10, boolean z11) {
        if (z11) {
            R();
        } else {
            this.f2004l.f2039b = false;
        }
        if (g() || !this.f1998f) {
            this.f2004l.f2038a = bVar.f2032c - this.f2006n.getStartAfterPadding();
        } else {
            this.f2004l.f2038a = (this.f2016x.getWidth() - bVar.f2032c) - this.f2006n.getStartAfterPadding();
        }
        this.f2004l.f2041d = bVar.f2030a;
        this.f2004l.f2045h = 1;
        this.f2004l.f2046i = -1;
        this.f2004l.f2042e = bVar.f2032c;
        this.f2004l.f2043f = Integer.MIN_VALUE;
        this.f2004l.f2040c = bVar.f2031b;
        if (!z10 || bVar.f2031b <= 0 || this.f2000h.size() <= bVar.f2031b) {
            return;
        }
        com.google.android.flexbox.b bVar2 = this.f2000h.get(bVar.f2031b);
        c.m(this.f2004l);
        c.v(this.f2004l, bVar2.b());
    }

    private void ensureLayoutState() {
        if (this.f2004l == null) {
            this.f2004l = new c(null);
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i10, int i11) {
        while (i11 >= i10) {
            removeAndRecycleViewAt(i11, recycler);
            i11--;
        }
    }

    private void v() {
        this.f2000h.clear();
        this.f2005m.t();
        this.f2005m.f2033d = 0;
    }

    private void w() {
        if (this.f2006n != null) {
            return;
        }
        if (g()) {
            if (this.f1994b == 0) {
                this.f2006n = OrientationHelper.createHorizontalHelper(this);
                this.f2007o = OrientationHelper.createVerticalHelper(this);
                return;
            } else {
                this.f2006n = OrientationHelper.createVerticalHelper(this);
                this.f2007o = OrientationHelper.createHorizontalHelper(this);
                return;
            }
        }
        if (this.f1994b == 0) {
            this.f2006n = OrientationHelper.createVerticalHelper(this);
            this.f2007o = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.f2006n = OrientationHelper.createHorizontalHelper(this);
            this.f2007o = OrientationHelper.createVerticalHelper(this);
        }
    }

    public void T(int i10) {
        int i11 = this.f1996d;
        if (i11 != i10) {
            if (i11 == 4 || i10 == 4) {
                removeAllViews();
                v();
            }
            this.f1996d = i10;
            requestLayout();
        }
    }

    public void U(int i10) {
        if (this.f1993a != i10) {
            removeAllViews();
            this.f1993a = i10;
            this.f2006n = null;
            this.f2007o = null;
            v();
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public void c(int i10, View view) {
        this.f2014v.put(i10, view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.f1994b == 0) {
            return g();
        }
        if (!g()) {
            return true;
        }
        int width = getWidth();
        View view = this.f2016x;
        return width > (view != null ? view.getWidth() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.f1994b == 0) {
            return !g();
        }
        if (!g()) {
            int height = getHeight();
            View view = this.f2016x;
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

    @Override // com.google.android.flexbox.a
    public View d(int i10) {
        View view = this.f2014v.get(i10);
        return view != null ? view : this.f2002j.getViewForPosition(i10);
    }

    @Override // com.google.android.flexbox.a
    public boolean g() {
        int i10 = this.f1993a;
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

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.f1996d;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.f1993a;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.f2003k.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.f2000h;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.f1994b;
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        if (this.f2000h.size() == 0) {
            return 0;
        }
        int size = this.f2000h.size();
        int iMax = Integer.MIN_VALUE;
        for (int i10 = 0; i10 < size; i10++) {
            iMax = Math.max(iMax, this.f2000h.get(i10).f2052e);
        }
        return iMax;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.f1997e;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.f2000h.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += this.f2000h.get(i11).f2054g;
        }
        return i10;
    }

    @Override // com.google.android.flexbox.a
    public void i(View view, int i10, int i11, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, A);
        if (g()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.f2052e += leftDecorationWidth;
            bVar.f2053f += leftDecorationWidth;
        } else {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            bVar.f2052e += topDecorationHeight;
            bVar.f2053f += topDecorationHeight;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i10;
        int i11;
        this.f2002j = recycler;
        this.f2003k = state;
        int itemCount = state.getItemCount();
        if (itemCount == 0 && state.isPreLayout()) {
            return;
        }
        S();
        w();
        ensureLayoutState();
        this.f2001i.t(itemCount);
        this.f2001i.u(itemCount);
        this.f2001i.s(itemCount);
        this.f2004l.f2047j = false;
        SavedState savedState = this.f2008p;
        if (savedState != null && savedState.g(itemCount)) {
            this.f2009q = this.f2008p.f2028a;
        }
        if (!this.f2005m.f2035f || this.f2009q != -1 || this.f2008p != null) {
            this.f2005m.t();
            Y(state, this.f2005m);
            this.f2005m.f2035f = true;
        }
        detachAndScrapAttachedViews(recycler);
        if (this.f2005m.f2034e) {
            d0(this.f2005m, false, true);
        } else {
            c0(this.f2005m, false, true);
        }
        a0(itemCount);
        x(recycler, state, this.f2004l);
        if (this.f2005m.f2034e) {
            i11 = this.f2004l.f2042e;
            c0(this.f2005m, true, false);
            x(recycler, state, this.f2004l);
            i10 = this.f2004l.f2042e;
        } else {
            i10 = this.f2004l.f2042e;
            d0(this.f2005m, true, false);
            x(recycler, state, this.f2004l);
            i11 = this.f2004l.f2042e;
        }
        if (getChildCount() > 0) {
            if (this.f2005m.f2034e) {
                fixLayoutStartGap(i11 + fixLayoutEndGap(i10, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i10 + fixLayoutStartGap(i11, recycler, state, true), recycler, state, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f2008p = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.f2008p != null) {
            return new SavedState(this.f2008p, (a) null);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() <= 0) {
            savedState.h();
            return savedState;
        }
        View childClosestToStart = getChildClosestToStart();
        savedState.f2028a = getPosition(childClosestToStart);
        savedState.f2029b = this.f2006n.getDecoratedStart(childClosestToStart) - this.f2006n.getStartAfterPadding();
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i10) {
        this.f2009q = i10;
        this.f2010r = Integer.MIN_VALUE;
        SavedState savedState = this.f2008p;
        if (savedState != null) {
            savedState.h();
        }
        requestLayout();
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.f2000h = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i10);
        startSmoothScroll(linearSmoothScroller);
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
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
        this.f2015w = context;
    }

    private View A(int i10) {
        View viewD = D(getChildCount() - 1, -1, i10);
        if (viewD == null) {
            return null;
        }
        return B(viewD, this.f2000h.get(this.f2001i.f2068c[getPosition(viewD)]));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    private View B(View view, com.google.android.flexbox.b bVar) {
        boolean zG = g();
        int childCount = (getChildCount() - bVar.f2055h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.f1998f && !zG) {
                    if (this.f2006n.getDecoratedStart(view) > this.f2006n.getDecoratedStart(childAt)) {
                        view = childAt;
                    }
                } else if (this.f2006n.getDecoratedEnd(view) < this.f2006n.getDecoratedEnd(childAt)) {
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
        int startAfterPadding = this.f2006n.getStartAfterPadding();
        int endAfterPadding = this.f2006n.getEndAfterPadding();
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
                    if (this.f2006n.getDecoratedStart(childAt) >= startAfterPadding && this.f2006n.getDecoratedEnd(childAt) <= endAfterPadding) {
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
        this.f2004l.f2047j = true;
        if (!g() && this.f1998f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 ? i10 <= 0 : i10 >= 0) {
            i11 = -1;
        }
        int iAbs = Math.abs(i10);
        b0(i11, iAbs);
        int iX = this.f2004l.f2043f + x(recycler, state, this.f2004l);
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
        this.f2006n.offsetChildren(-i10);
        this.f2004l.f2044g = i10;
        return i10;
    }

    private int J(int i10) {
        int height;
        int height2;
        if (getChildCount() != 0 && i10 != 0) {
            w();
            boolean zG = g();
            View view = this.f2016x;
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
                    return -Math.min((height2 + this.f2005m.f2033d) - height, iAbs);
                }
                if (this.f2005m.f2033d + i10 > 0) {
                    return -this.f2005m.f2033d;
                }
            } else {
                if (i10 > 0) {
                    return Math.min((height2 - this.f2005m.f2033d) - height, i10);
                }
                if (this.f2005m.f2033d + i10 < 0) {
                    return -this.f2005m.f2033d;
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

    private int L(com.google.android.flexbox.b bVar, c cVar) {
        if (g()) {
            return M(bVar, cVar);
        }
        return N(bVar, cVar);
    }

    private void O(RecyclerView.Recycler recycler, c cVar) {
        if (!cVar.f2047j) {
            return;
        }
        if (cVar.f2046i == -1) {
            P(recycler, cVar);
        } else {
            Q(recycler, cVar);
        }
    }

    private void P(RecyclerView.Recycler recycler, c cVar) {
        int childCount;
        int i10;
        View childAt;
        int i11;
        if (cVar.f2043f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt((i10 = childCount - 1))) == null || (i11 = this.f2001i.f2068c[getPosition(childAt)]) == -1) {
            return;
        }
        com.google.android.flexbox.b bVar = this.f2000h.get(i11);
        for (int i12 = i10; i12 >= 0; i12--) {
            View childAt2 = getChildAt(i12);
            if (childAt2 != null) {
                if (!t(childAt2, cVar.f2043f)) {
                    break;
                }
                if (bVar.f2062o != getPosition(childAt2)) {
                    continue;
                } else if (i11 <= 0) {
                    childCount = i12;
                    break;
                } else {
                    i11 += cVar.f2046i;
                    bVar = this.f2000h.get(i11);
                    childCount = i12;
                }
            }
        }
        recycleChildren(recycler, childCount, i10);
    }

    private void Q(RecyclerView.Recycler recycler, c cVar) {
        int childCount;
        View childAt;
        if (cVar.f2043f >= 0 && (childCount = getChildCount()) != 0 && (childAt = getChildAt(0)) != null) {
            int i10 = this.f2001i.f2068c[getPosition(childAt)];
            int i11 = -1;
            if (i10 == -1) {
                return;
            }
            com.google.android.flexbox.b bVar = this.f2000h.get(i10);
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null) {
                    if (!u(childAt2, cVar.f2043f)) {
                        break;
                    }
                    if (bVar.f2063p != getPosition(childAt2)) {
                        continue;
                    } else if (i10 >= this.f2000h.size() - 1) {
                        i11 = i12;
                        break;
                    } else {
                        i10 += cVar.f2046i;
                        bVar = this.f2000h.get(i10);
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
        c cVar = this.f2004l;
        if (widthMode != 0 && widthMode != Integer.MIN_VALUE) {
            z10 = false;
        } else {
            z10 = true;
        }
        cVar.f2039b = z10;
    }

    private void S() {
        boolean z10;
        boolean z11;
        boolean z12;
        int layoutDirection = getLayoutDirection();
        int i10 = this.f1993a;
        boolean z13 = false;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        this.f1998f = false;
                        this.f1999g = false;
                        return;
                    }
                    if (layoutDirection == 1) {
                        z13 = true;
                    }
                    this.f1998f = z13;
                    if (this.f1994b == 2) {
                        this.f1998f = !z13;
                    }
                    this.f1999g = true;
                    return;
                }
                if (layoutDirection == 1) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                this.f1998f = z12;
                if (this.f1994b == 2) {
                    this.f1998f = !z12;
                }
                this.f1999g = false;
                return;
            }
            if (layoutDirection != 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f1998f = z11;
            if (this.f1994b == 2) {
                z13 = true;
            }
            this.f1999g = z13;
            return;
        }
        if (layoutDirection == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f1998f = z10;
        if (this.f1994b == 2) {
            z13 = true;
        }
        this.f1999g = z13;
    }

    private boolean W(RecyclerView.State state, b bVar) {
        View viewY;
        int startAfterPadding;
        if (getChildCount() == 0) {
            return false;
        }
        if (bVar.f2034e) {
            viewY = A(state.getItemCount());
        } else {
            viewY = y(state.getItemCount());
        }
        if (viewY != null) {
            bVar.s(viewY);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.f2006n.getDecoratedStart(viewY) >= this.f2006n.getEndAfterPadding() || this.f2006n.getDecoratedEnd(viewY) < this.f2006n.getStartAfterPadding()) {
                    if (bVar.f2034e) {
                        startAfterPadding = this.f2006n.getEndAfterPadding();
                    } else {
                        startAfterPadding = this.f2006n.getStartAfterPadding();
                    }
                    bVar.f2032c = startAfterPadding;
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean X(RecyclerView.State state, b bVar, SavedState savedState) {
        int i10;
        View childAt;
        int decoratedStart;
        boolean z10 = false;
        if (!state.isPreLayout() && (i10 = this.f2009q) != -1) {
            if (i10 >= 0 && i10 < state.getItemCount()) {
                bVar.f2030a = this.f2009q;
                bVar.f2031b = this.f2001i.f2068c[bVar.f2030a];
                SavedState savedState2 = this.f2008p;
                if (savedState2 != null && savedState2.g(state.getItemCount())) {
                    bVar.f2032c = this.f2006n.getStartAfterPadding() + savedState.f2029b;
                    bVar.f2036g = true;
                    bVar.f2031b = -1;
                    return true;
                }
                if (this.f2010r == Integer.MIN_VALUE) {
                    View viewFindViewByPosition = findViewByPosition(this.f2009q);
                    if (viewFindViewByPosition != null) {
                        if (this.f2006n.getDecoratedMeasurement(viewFindViewByPosition) > this.f2006n.getTotalSpace()) {
                            bVar.r();
                            return true;
                        }
                        if (this.f2006n.getDecoratedStart(viewFindViewByPosition) - this.f2006n.getStartAfterPadding() < 0) {
                            bVar.f2032c = this.f2006n.getStartAfterPadding();
                            bVar.f2034e = false;
                            return true;
                        }
                        if (this.f2006n.getEndAfterPadding() - this.f2006n.getDecoratedEnd(viewFindViewByPosition) < 0) {
                            bVar.f2032c = this.f2006n.getEndAfterPadding();
                            bVar.f2034e = true;
                            return true;
                        }
                        if (bVar.f2034e) {
                            decoratedStart = this.f2006n.getDecoratedEnd(viewFindViewByPosition) + this.f2006n.getTotalSpaceChange();
                        } else {
                            decoratedStart = this.f2006n.getDecoratedStart(viewFindViewByPosition);
                        }
                        bVar.f2032c = decoratedStart;
                    } else {
                        if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
                            if (this.f2009q < getPosition(childAt)) {
                                z10 = true;
                            }
                            bVar.f2034e = z10;
                        }
                        bVar.r();
                    }
                    return true;
                }
                if (g() || !this.f1998f) {
                    bVar.f2032c = this.f2006n.getStartAfterPadding() + this.f2010r;
                } else {
                    bVar.f2032c = this.f2010r - this.f2006n.getEndPadding();
                }
                return true;
            }
            this.f2009q = -1;
            this.f2010r = Integer.MIN_VALUE;
        }
        return false;
    }

    private void Z(int i10) {
        if (i10 < findLastVisibleItemPosition()) {
            int childCount = getChildCount();
            this.f2001i.t(childCount);
            this.f2001i.u(childCount);
            this.f2001i.s(childCount);
            if (i10 < this.f2001i.f2068c.length) {
                this.f2017y = i10;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart == null) {
                    return;
                }
                this.f2009q = getPosition(childClosestToStart);
                if (!g() && this.f1998f) {
                    this.f2010r = this.f2006n.getDecoratedEnd(childClosestToStart) + this.f2006n.getEndPadding();
                } else {
                    this.f2010r = this.f2006n.getDecoratedStart(childClosestToStart) - this.f2006n.getStartAfterPadding();
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
            int i13 = this.f2011s;
            if (i13 != Integer.MIN_VALUE && i13 != width) {
                z10 = true;
            }
            i11 = this.f2004l.f2039b ? this.f2015w.getResources().getDisplayMetrics().heightPixels : this.f2004l.f2038a;
        } else {
            int i14 = this.f2012t;
            if (i14 != Integer.MIN_VALUE && i14 != height) {
                z10 = true;
            }
            if (!this.f2004l.f2039b) {
                i11 = this.f2004l.f2038a;
            } else {
                i11 = this.f2015w.getResources().getDisplayMetrics().widthPixels;
            }
        }
        int i15 = i11;
        this.f2011s = width;
        this.f2012t = height;
        int i16 = this.f2017y;
        if (i16 == -1 && (this.f2009q != -1 || z10)) {
            if (this.f2005m.f2034e) {
                return;
            }
            this.f2000h.clear();
            this.f2018z.a();
            if (g()) {
                this.f2001i.e(this.f2018z, iMakeMeasureSpec, iMakeMeasureSpec2, i15, this.f2005m.f2030a, this.f2000h);
            } else {
                this.f2001i.h(this.f2018z, iMakeMeasureSpec, iMakeMeasureSpec2, i15, this.f2005m.f2030a, this.f2000h);
            }
            this.f2000h = this.f2018z.f2071a;
            this.f2001i.p(iMakeMeasureSpec, iMakeMeasureSpec2);
            this.f2001i.X();
            b bVar = this.f2005m;
            bVar.f2031b = this.f2001i.f2068c[bVar.f2030a];
            this.f2004l.f2040c = this.f2005m.f2031b;
            return;
        }
        if (i16 == -1) {
            iMin = this.f2005m.f2030a;
        } else {
            iMin = Math.min(i16, this.f2005m.f2030a);
        }
        int i17 = iMin;
        this.f2018z.a();
        if (g()) {
            if (this.f2000h.size() > 0) {
                this.f2001i.j(this.f2000h, i17);
                this.f2001i.b(this.f2018z, iMakeMeasureSpec, iMakeMeasureSpec2, i15, i17, this.f2005m.f2030a, this.f2000h);
                i12 = i17;
            } else {
                i12 = i17;
                this.f2001i.s(i10);
                this.f2001i.d(this.f2018z, iMakeMeasureSpec, iMakeMeasureSpec2, i15, 0, this.f2000h);
            }
        } else {
            i12 = i17;
            if (this.f2000h.size() > 0) {
                this.f2001i.j(this.f2000h, i12);
                i17 = i12;
                this.f2001i.b(this.f2018z, iMakeMeasureSpec2, iMakeMeasureSpec, i15, i17, this.f2005m.f2030a, this.f2000h);
                iMakeMeasureSpec2 = iMakeMeasureSpec2;
                iMakeMeasureSpec = iMakeMeasureSpec;
                i12 = i17;
            } else {
                this.f2001i.s(i10);
                this.f2001i.g(this.f2018z, iMakeMeasureSpec, iMakeMeasureSpec2, i15, 0, this.f2000h);
            }
        }
        this.f2000h = this.f2018z.f2071a;
        this.f2001i.q(iMakeMeasureSpec, iMakeMeasureSpec2, i12);
        this.f2001i.Y(i12);
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
        return Math.min(this.f2006n.getTotalSpace(), this.f2006n.getDecoratedEnd(viewA) - this.f2006n.getDecoratedStart(viewY));
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
            int iAbs = Math.abs(this.f2006n.getDecoratedEnd(viewA) - this.f2006n.getDecoratedStart(viewY));
            int[] iArr = this.f2001i.f2068c;
            int i10 = iArr[position];
            if (i10 != 0 && i10 != -1) {
                return Math.round((i10 * (iAbs / ((iArr[position2] - i10) + 1))) + (this.f2006n.getStartAfterPadding() - this.f2006n.getDecoratedStart(viewY)));
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
        return (int) ((Math.abs(this.f2006n.getDecoratedEnd(viewA) - this.f2006n.getDecoratedStart(viewY)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition()) + 1)) * state.getItemCount());
    }

    private int fixLayoutEndGap(int i10, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z10) {
        int I;
        int endAfterPadding;
        if (!g() && this.f1998f) {
            int startAfterPadding = i10 - this.f2006n.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            I = I(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.f2006n.getEndAfterPadding() - i10;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            I = -I(-endAfterPadding2, recycler, state);
        }
        int i11 = i10 + I;
        if (z10 && (endAfterPadding = this.f2006n.getEndAfterPadding() - i11) > 0) {
            this.f2006n.offsetChildren(endAfterPadding);
            return endAfterPadding + I;
        }
        return I;
    }

    private int fixLayoutStartGap(int i10, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z10) {
        int I;
        int startAfterPadding;
        if (!g() && this.f1998f) {
            int endAfterPadding = this.f2006n.getEndAfterPadding() - i10;
            if (endAfterPadding <= 0) {
                return 0;
            }
            I = I(-endAfterPadding, recycler, state);
        } else {
            int startAfterPadding2 = i10 - this.f2006n.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            I = -I(startAfterPadding2, recycler, state);
        }
        int i11 = i10 + I;
        if (z10 && (startAfterPadding = i11 - this.f2006n.getStartAfterPadding()) > 0) {
            this.f2006n.offsetChildren(-startAfterPadding);
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
        if (!g() && this.f1998f) {
            if (this.f2006n.getDecoratedEnd(view) > i10) {
                return false;
            }
            return true;
        }
        if (this.f2006n.getDecoratedStart(view) < this.f2006n.getEnd() - i10) {
            return false;
        }
        return true;
    }

    private boolean u(View view, int i10) {
        if (!g() && this.f1998f) {
            if (this.f2006n.getEnd() - this.f2006n.getDecoratedStart(view) > i10) {
                return false;
            }
            return true;
        }
        if (this.f2006n.getDecoratedEnd(view) > i10) {
            return false;
        }
        return true;
    }

    private int x(RecyclerView.Recycler recycler, RecyclerView.State state, c cVar) {
        if (cVar.f2043f != Integer.MIN_VALUE) {
            if (cVar.f2038a < 0) {
                c.q(cVar, cVar.f2038a);
            }
            O(recycler, cVar);
        }
        int i10 = cVar.f2038a;
        int iA = cVar.f2038a;
        boolean zG = g();
        int iL = 0;
        while (true) {
            if ((iA <= 0 && !this.f2004l.f2039b) || !cVar.D(state, this.f2000h)) {
                break;
            }
            com.google.android.flexbox.b bVar = this.f2000h.get(cVar.f2040c);
            cVar.f2041d = bVar.f2062o;
            iL += L(bVar, cVar);
            if (!zG && this.f1998f) {
                c.d(cVar, bVar.a() * cVar.f2046i);
            } else {
                c.c(cVar, bVar.a() * cVar.f2046i);
            }
            iA -= bVar.a();
        }
        c.i(cVar, iL);
        if (cVar.f2043f != Integer.MIN_VALUE) {
            c.q(cVar, iL);
            if (cVar.f2038a < 0) {
                c.q(cVar, cVar.f2038a);
            }
            O(recycler, cVar);
        }
        return i10 - cVar.f2038a;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    private View z(View view, com.google.android.flexbox.b bVar) {
        boolean zG = g();
        int i10 = bVar.f2055h;
        for (int i11 = 1; i11 < i10; i11++) {
            View childAt = getChildAt(i11);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.f1998f && !zG) {
                    if (this.f2006n.getDecoratedEnd(view) < this.f2006n.getDecoratedEnd(childAt)) {
                        view = childAt;
                    }
                } else if (this.f2006n.getDecoratedStart(view) > this.f2006n.getDecoratedStart(childAt)) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    @Override // com.google.android.flexbox.a
    public View a(int i10) {
        return d(i10);
    }

    @Override // com.google.android.flexbox.a
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

    @Override // com.google.android.flexbox.a
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

    @Override // com.google.android.flexbox.a
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

    @Override // com.google.android.flexbox.a
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
        this.f2016x = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.f2013u) {
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
        this.f2008p = null;
        this.f2009q = -1;
        this.f2010r = Integer.MIN_VALUE;
        this.f2017y = -1;
        this.f2005m.t();
        this.f2014v.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (g() && this.f1994b != 0) {
            int iJ = J(i10);
            b.l(this.f2005m, iJ);
            this.f2007o.offsetChildren(-iJ);
            return iJ;
        }
        int I = I(i10, recycler, state);
        this.f2014v.clear();
        return I;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!g() && (this.f1994b != 0 || g())) {
            int iJ = J(i10);
            b.l(this.f2005m, iJ);
            this.f2007o.offsetChildren(-iJ);
            return iJ;
        }
        int I = I(i10, recycler, state);
        this.f2014v.clear();
        return I;
    }

    @Override // com.google.android.flexbox.a
    public void k(com.google.android.flexbox.b bVar) {
    }
}
