package com.live.evo.widget.nicespinner;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.google.android.material.navigation.NavigationBarView;
import com.live.evo.R$dimen;
import com.live.evo.R$drawable;
import com.live.evo.R$styleable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class NiceSpinner extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Drawable f7627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ListPopupWindow f7628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.live.evo.widget.nicespinner.c f7629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AdapterView.OnItemClickListener f7630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f7631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private r5.b f7632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ColorStateList f7634i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f7635j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7636k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f7637l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7638m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7639n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f7640o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @DrawableRes
    private int f7641p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private r5.d f7642q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private r5.d f7643r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private d f7644s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private ObjectAnimator f7645t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private View.OnClickListener f7646u;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NiceSpinner.this.f7628c.isShowing() || NiceSpinner.this.f7629d.getCount() <= 0) {
                NiceSpinner.this.m();
            } else {
                NiceSpinner.this.r();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            View view2;
            int i11;
            long j11;
            AdapterView<?> adapterView2;
            NiceSpinner.this.f7626a = i10;
            if (NiceSpinner.this.f7632g != null) {
                NiceSpinner.this.f7632g.a(NiceSpinner.this, view, i10, j10);
                j11 = j10;
                view2 = view;
                i11 = i10;
            } else {
                view2 = view;
                i11 = i10;
                j11 = j10;
            }
            if (NiceSpinner.this.f7630e != null) {
                adapterView2 = adapterView;
                NiceSpinner.this.f7630e.onItemClick(adapterView2, view2, i11, j11);
            } else {
                adapterView2 = adapterView;
            }
            if (NiceSpinner.this.f7631f != null) {
                NiceSpinner.this.f7631f.onItemSelected(adapterView2, view2, i11, j11);
            }
            NiceSpinner.this.f7629d.b(i11);
            NiceSpinner niceSpinner = NiceSpinner.this;
            niceSpinner.setTextInternal(niceSpinner.f7629d.a(i11));
            NiceSpinner.this.m();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements PopupWindow.OnDismissListener {
        c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (NiceSpinner.this.f7633h) {
                return;
            }
            NiceSpinner.this.k(false);
        }
    }

    public NiceSpinner(Context context) {
        super(context);
        this.f7642q = new r5.c();
        this.f7643r = new r5.c();
        this.f7645t = null;
        this.f7646u = new a();
        n(context, null);
    }

    public void setArrowDrawable(@DrawableRes @ColorRes int i10) {
        this.f7641p = i10;
        Drawable drawableO = o(R$drawable.arrow_for_spinner);
        this.f7627b = drawableO;
        setArrowDrawableOrHide(drawableO);
    }

    private int getParentVerticalOffset() {
        int i10 = this.f7639n;
        if (i10 > 0) {
            return i10;
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i11 = iArr[1];
        this.f7639n = i11;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z10) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.f7627b, "level", z10 ? 0 : 10000, z10 ? 10000 : 0);
        this.f7645t = objectAnimatorOfInt;
        objectAnimatorOfInt.setInterpolator(new LinearOutSlowInInterpolator());
        this.f7645t.start();
    }

    private Drawable o(int i10) {
        if (this.f7641p == 0) {
            return null;
        }
        Drawable drawable = ContextCompat.getDrawable(getContext(), this.f7641p);
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (i10 != Integer.MAX_VALUE && i10 != 0) {
                DrawableCompat.setTint(drawable, i10);
            }
        }
        return drawable;
    }

    private void setArrowDrawableOrHide(Drawable drawable) {
        if (this.f7633h || drawable == null) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextInternal(Object obj) {
        r5.d dVar = this.f7643r;
        if (dVar != null) {
            setText(dVar.a(obj));
        } else {
            setText(obj.toString());
        }
    }

    private int t() {
        return (this.f7638m - getParentVerticalOffset()) - getMeasuredHeight();
    }

    public int getDropDownListPaddingBottom() {
        return this.f7640o;
    }

    public r5.b getOnSpinnerItemSelectedListener() {
        return this.f7632g;
    }

    public d getPopUpTextAlignment() {
        return this.f7644s;
    }

    public int getSelectedIndex() {
        return this.f7626a;
    }

    public Object getSelectedItem() {
        return this.f7629d.a(this.f7626a);
    }

    public <T> void l(@NonNull List<T> list) {
        com.live.evo.widget.nicespinner.a aVar = new com.live.evo.widget.nicespinner.a(getContext(), list, this.f7635j, this.f7636k, this.f7642q, this.f7644s);
        this.f7629d = aVar;
        setAdapterInternal(aVar);
    }

    public void m() {
        if (!this.f7633h) {
            k(false);
        }
        this.f7628c.dismiss();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    protected void onDetachedFromWindow() {
        ObjectAnimator objectAnimator = this.f7645t;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            int i10 = bundle.getInt("selected_index");
            this.f7626a = i10;
            com.live.evo.widget.nicespinner.c cVar = this.f7629d;
            if (cVar != null) {
                setTextInternal(cVar.a(i10));
                this.f7629d.b(this.f7626a);
            }
            if (bundle.getBoolean("is_popup_showing") && this.f7628c != null) {
                post(new Runnable() { // from class: r5.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17842a.r();
                    }
                });
            }
            this.f7633h = bundle.getBoolean("is_arrow_hidden", false);
            this.f7641p = bundle.getInt("arrow_drawable_res_id");
            parcelable = bundle.getParcelable("instance_state");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instance_state", super.onSaveInstanceState());
        bundle.putInt("selected_index", this.f7626a);
        bundle.putBoolean("is_arrow_hidden", this.f7633h);
        bundle.putInt("arrow_drawable_res_id", this.f7641p);
        ListPopupWindow listPopupWindow = this.f7628c;
        if (listPopupWindow != null) {
            bundle.putBoolean("is_popup_showing", listPopupWindow.isShowing());
        }
        return bundle;
    }

    public void r() {
        if (!this.f7633h) {
            k(true);
        }
        this.f7628c.setAnchorView(this);
        this.f7628c.show();
        ListView listView = this.f7628c.getListView();
        if (listView != null) {
            listView.requestFocus();
            listView.setVerticalScrollBarEnabled(false);
            listView.setHorizontalScrollBarEnabled(false);
            listView.setVerticalFadingEdgeEnabled(false);
            listView.setHorizontalFadingEdgeEnabled(false);
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        com.live.evo.widget.nicespinner.b bVar = new com.live.evo.widget.nicespinner.b(getContext(), listAdapter, this.f7635j, this.f7636k, this.f7642q, this.f7644s);
        this.f7629d = bVar;
        setAdapterInternal(bVar);
    }

    public void setArrowTintColor(int i10) {
        Drawable drawable = this.f7627b;
        if (drawable == null || this.f7633h) {
            return;
        }
        DrawableCompat.setTint(drawable, i10);
    }

    public void setDropDownListPaddingBottom(int i10) {
        this.f7640o = i10;
    }

    @Override // android.widget.TextView
    public void setHeight(int i10) {
        this.f7628c.setHeight(i10);
    }

    @Deprecated
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f7631f = onItemSelectedListener;
    }

    public void setOnSpinnerItemSelectedListener(r5.b bVar) {
        this.f7632g = bVar;
    }

    public void setSelectedIndex(int i10) {
        com.live.evo.widget.nicespinner.c cVar = this.f7629d;
        if (cVar != null) {
            if (i10 < 0 || i10 > cVar.getCount()) {
                throw new IllegalArgumentException("Position must be lower than adapter count!");
            }
            this.f7629d.b(i10);
            this.f7626a = i10;
            setTextInternal(this.f7629d.a(i10));
        }
    }

    public void setSelectedTextFormatter(r5.d dVar) {
        this.f7643r = dVar;
    }

    public void setSpinnerTextFormatter(r5.d dVar) {
        this.f7642q = dVar;
    }

    public void setTintColor(@ColorRes int i10) {
        Drawable drawable = this.f7627b;
        if (drawable == null || this.f7633h) {
            return;
        }
        DrawableCompat.setTint(drawable, ContextCompat.getColor(getContext(), i10));
    }

    private int getPopUpHeight() {
        return Math.max(t(), s());
    }

    private void n(Context context, AttributeSet attributeSet) {
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NiceSpinner);
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.one_and_a_half_grid_unit);
        setGravity(NavigationBarView.ITEM_GRAVITY_START_CENTER);
        setPadding(resources.getDimensionPixelSize(R$dimen.three_grid_unit), dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setClickable(true);
        setFocusable(true);
        setOnClickListener(this.f7646u);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, R$drawable.selector);
        this.f7636k = resourceId;
        setBackgroundResource(resourceId);
        this.f7634i = resources.getColorStateList(typedArrayObtainStyledAttributes.getResourceId(10, R.color.white));
        this.f7635j = resources.getColorStateList(typedArrayObtainStyledAttributes.getResourceId(8, R.color.white));
        setTextColor(this.f7634i);
        this.f7628c = new ListPopupWindow(context);
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            this.f7628c.setListSelector(typedArrayObtainStyledAttributes.getDrawable(5));
        } else if (typedArrayObtainStyledAttributes.hasValue(2)) {
            this.f7628c.setListSelector(typedArrayObtainStyledAttributes.getDrawable(2));
        }
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f7628c.setBackgroundDrawable(typedArrayObtainStyledAttributes.getDrawable(3));
        }
        this.f7628c.setOnItemClickListener(new b());
        this.f7628c.setModal(true);
        this.f7628c.setOnDismissListener(new c());
        this.f7633h = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.f7637l = typedArrayObtainStyledAttributes.getColor(1, getResources().getColor(R.color.black));
        this.f7641p = typedArrayObtainStyledAttributes.getResourceId(0, R$drawable.arrow_for_spinner);
        this.f7640o = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.f7644s = d.f(typedArrayObtainStyledAttributes.getInt(9, d.START.ordinal()));
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(6);
        if (textArray != null) {
            l(Arrays.asList(textArray));
        }
        typedArrayObtainStyledAttributes.recycle();
        p();
    }

    private void p() {
        this.f7638m = getContext().getResources().getDisplayMetrics().heightPixels;
    }

    private int s() {
        return getParentVerticalOffset();
    }

    private <T> void setAdapterInternal(com.live.evo.widget.nicespinner.c<T> cVar) {
        if (cVar.getCount() >= 0) {
            this.f7626a = 0;
            this.f7628c.setAdapter(cVar);
            setTextInternal(cVar.a(this.f7626a));
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        Drawable drawableO = o(this.f7637l);
        this.f7627b = drawableO;
        setArrowDrawableOrHide(drawableO);
    }

    public void q(int i10, boolean z10) {
        setSelectedIndex(i10);
    }

    public void setArrowDrawable(Drawable drawable) {
        this.f7627b = drawable;
        setArrowDrawableOrHide(drawable);
    }

    public NiceSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7642q = new r5.c();
        this.f7643r = new r5.c();
        this.f7645t = null;
        this.f7646u = new a();
        n(context, attributeSet);
    }

    public NiceSpinner(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7642q = new r5.c();
        this.f7643r = new r5.c();
        this.f7645t = null;
        this.f7646u = new a();
        n(context, attributeSet);
    }
}
