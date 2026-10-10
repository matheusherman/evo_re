package com.google.android.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class TrackSelectionView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LayoutInflater f1846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CheckedTextView f1847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CheckedTextView f1848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f1849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SparseArray<a1.a> f1850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1852h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private b1.n f1853i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CheckedTextView[][] f1854j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private r0.d f1855k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f1856l;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class b implements View.OnClickListener {
        private b() {
        }

        /* synthetic */ b(TrackSelectionView trackSelectionView, a aVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrackSelectionView.this.d(view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1859b;
    }

    public TrackSelectionView(Context context) {
        this(context, null);
    }

    private static int[] b(int[] iArr, int i10) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length + 1);
        iArrCopyOf[iArrCopyOf.length - 1] = i10;
        return iArrCopyOf;
    }

    private static int[] c(int[] iArr, int i10) {
        int[] iArr2 = new int[iArr.length - 1];
        int i11 = 0;
        for (int i12 : iArr) {
            if (i12 != i10) {
                iArr2[i11] = i12;
                i11++;
            }
        }
        return iArr2;
    }

    private void e() {
        this.f1856l = false;
        this.f1850f.clear();
    }

    private void f() {
        this.f1856l = true;
        this.f1850f.clear();
    }

    private void g(View view) {
        this.f1856l = false;
        c cVar = (c) d1.a.b(view.getTag());
        int i10 = cVar.f1858a;
        int i11 = cVar.f1859b;
        a1.a aVar = this.f1850f.get(i10);
        d1.a.b(null);
        if (aVar == null) {
            if (!this.f1852h && this.f1850f.size() > 0) {
                this.f1850f.clear();
            }
            this.f1850f.put(i10, new a1.a(i10, i11));
            return;
        }
        int i12 = aVar.f98c;
        int[] iArr = aVar.f97b;
        boolean zIsChecked = ((CheckedTextView) view).isChecked();
        boolean zH = h(i10);
        boolean z10 = zH || i();
        if (zIsChecked && z10) {
            if (i12 == 1) {
                this.f1850f.remove(i10);
                return;
            } else {
                this.f1850f.put(i10, new a1.a(i10, c(iArr, i11)));
                return;
            }
        }
        if (zIsChecked) {
            return;
        }
        if (zH) {
            this.f1850f.put(i10, new a1.a(i10, b(iArr, i11)));
        } else {
            this.f1850f.put(i10, new a1.a(i10, i11));
        }
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view) {
        if (view == this.f1847c) {
            f();
        } else if (view == this.f1848d) {
            e();
        } else {
            g(view);
        }
        j();
    }

    private boolean h(int i10) {
        if (!this.f1851g || this.f1855k.a(i10).f17783a <= 1) {
            return false;
        }
        throw null;
    }

    private boolean i() {
        return this.f1852h && this.f1855k.f17789a > 1;
    }

    private void j() {
        this.f1847c.setChecked(this.f1856l);
        this.f1848d.setChecked(!this.f1856l && this.f1850f.size() == 0);
        for (int i10 = 0; i10 < this.f1854j.length; i10++) {
            a1.a aVar = this.f1850f.get(i10);
            int i11 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f1854j[i10];
                if (i11 < checkedTextViewArr.length) {
                    if (aVar != null) {
                        this.f1854j[i10][i11].setChecked(aVar.a(((c) d1.a.b(checkedTextViewArr[i11].getTag())).f1859b));
                    } else {
                        checkedTextViewArr[i11].setChecked(false);
                    }
                    i11++;
                }
            }
        }
    }

    public boolean getIsDisabled() {
        return this.f1856l;
    }

    public List<a1.a> getOverrides() {
        ArrayList arrayList = new ArrayList(this.f1850f.size());
        for (int i10 = 0; i10 < this.f1850f.size(); i10++) {
            arrayList.add(this.f1850f.valueAt(i10));
        }
        return arrayList;
    }

    public void setAllowAdaptiveSelections(boolean z10) {
        if (this.f1851g != z10) {
            this.f1851g = z10;
            k();
        }
    }

    public void setAllowMultipleOverrides(boolean z10) {
        if (this.f1852h != z10) {
            this.f1852h = z10;
            if (!z10 && this.f1850f.size() > 1) {
                for (int size = this.f1850f.size() - 1; size > 0; size--) {
                    this.f1850f.remove(size);
                }
            }
            k();
        }
    }

    public void setShowDisableOption(boolean z10) {
        this.f1847c.setVisibility(z10 ? 0 : 8);
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10) {
        super(context, attributeSet, i10);
        setOrientation(1);
        this.f1850f = new SparseArray<>();
        setSaveFromParentEnabled(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.f1845a = resourceId;
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f1846b = layoutInflaterFrom;
        b bVar = new b(this, null);
        this.f1849e = bVar;
        this.f1853i = new b1.g(getResources());
        this.f1855k = r0.d.f17787d;
        CheckedTextView checkedTextView = (CheckedTextView) layoutInflaterFrom.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f1847c = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R$string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(bVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(layoutInflaterFrom.inflate(R$layout.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) layoutInflaterFrom.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f1848d = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R$string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(bVar);
        addView(checkedTextView2);
    }

    private void k() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount >= 3) {
                removeViewAt(childCount);
            } else {
                this.f1847c.setEnabled(false);
                this.f1848d.setEnabled(false);
                return;
            }
        }
    }

    public void setTrackNameProvider(b1.n nVar) {
        this.f1853i = (b1.n) d1.a.b(nVar);
        k();
    }
}
