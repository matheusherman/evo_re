package com.live.evo.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$styleable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class MenuTabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f7478p = "MenuTabLayout";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<c> f7480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f7481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LinearLayout f7485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f7488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ArrayList<a> f7489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ViewPager f7490l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ViewPager.OnPageChangeListener f7491m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private a f7492n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f7493o;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
        void a(c cVar, int i10);

        void b(c cVar, int i10);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<MenuTabLayout> f7494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f7496c;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) {
            this.f7495b = this.f7496c;
            this.f7496c = i10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i10) {
            MenuTabLayout menuTabLayout = this.f7494a.get();
            if (menuTabLayout == null || menuTabLayout.getSelectedTabPosition() == i10 || i10 >= menuTabLayout.getTabCount()) {
                return;
            }
            menuTabLayout.setSelectTabView(i10);
        }

        public b(MenuTabLayout menuTabLayout) {
            this.f7494a = new WeakReference<>(menuTabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class c extends FrameLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private View f7497a;

        public c(Context context) {
            super(context);
            if (MenuTabLayout.this.f7479a != 0) {
                ViewCompat.setBackground(this, AppCompatResources.getDrawable(context, MenuTabLayout.this.f7479a));
            }
        }

        @NonNull
        public c a(@Nullable View view) {
            this.f7497a = view;
            ViewCompat.setBackground(this, AppCompatResources.getDrawable(getContext(), R$drawable.menu_fragment_tab_bg_normal));
            b();
            return this;
        }

        void b() {
            if (this.f7497a != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
                setPadding(4, 4, 4, 4);
                addView(this.f7497a, layoutParams);
            }
        }

        @Nullable
        public View getCustomView() {
            return this.f7497a;
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            isSelected();
            super.setSelected(z10);
            if (z10) {
                MenuTabLayout menuTabLayout = MenuTabLayout.this;
                ViewCompat.setBackground(menuTabLayout.k(menuTabLayout.f7482d), AppCompatResources.getDrawable(getContext(), R$drawable.menub_fragment_tab_bg_selected));
                findViewById(R$id.tab_title).setSelected(z10);
                findViewById(R$id.tab_bottom_line).setVisibility(8);
            } else {
                ViewCompat.setBackground(this, AppCompatResources.getDrawable(getContext(), R$drawable.menub_fragment_tab_bg_normal));
                findViewById(R$id.tab_title).setEnabled(z10);
                findViewById(R$id.tab_title).setSelected(z10);
                findViewById(R$id.tab_bottom_line).setVisibility(8);
            }
            View view = this.f7497a;
            if (view != null) {
                view.setSelected(z10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager f7499a;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f7500a;

            a(int i10) {
                this.f7500a = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f7499a.setCurrentItem(this.f7500a);
            }
        }

        @Override // com.live.evo.widget.MenuTabLayout.a
        public void b(c cVar, int i10) {
            ViewPager viewPager = this.f7499a;
            if (viewPager == null || viewPager.getCurrentItem() == i10) {
                return;
            }
            try {
                this.f7499a.post(new a(i10));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        public d(ViewPager viewPager) {
            this.f7499a = viewPager;
        }

        @Override // com.live.evo.widget.MenuTabLayout.a
        public void a(c cVar, int i10) {
        }
    }

    public MenuTabLayout(Context context) {
        this(context, null);
    }

    public void e(@NonNull c cVar, int i10) {
        cVar.setFocusable(false);
        cVar.setFocusableInTouchMode(false);
        cVar.findViewById(R$id.tab_title).setEnabled(false);
        cVar.findViewById(R$id.tab_title).setSelected(false);
        this.f7480b.add(cVar);
        this.f7485g.addView(cVar, h());
        if (this.f7482d == this.f7480b.indexOf(cVar)) {
            setSelectTabView(this.f7482d);
        }
    }

    public MenuTabLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void f() {
        int i10 = this.f7486h;
        if (i10 == 1) {
            this.f7485g.setGravity(17);
        } else if (i10 == 2 || i10 == 3) {
            this.f7485g.setGravity(16);
        }
    }

    private LinearLayout.LayoutParams h() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.leftMargin = this.f7483e;
        p(layoutParams);
        return layoutParams;
    }

    private void i(@NonNull c cVar, int i10) {
        for (int size = this.f7489k.size() - 1; size >= 0; size--) {
            this.f7489k.get(size).b(cVar, i10);
        }
    }

    private void j(@NonNull c cVar, int i10) {
        for (int size = this.f7489k.size() - 1; size >= 0; size--) {
            this.f7489k.get(size).a(cVar, i10);
        }
    }

    private void n() {
        c cVar = this.f7481c;
        int i10 = this.f7482d;
        int i11 = this.f7486h;
        if (i11 == 3 || i11 == 2) {
            int measuredWidth = getMeasuredWidth();
            int scrollX = getScrollX();
            int x10 = (int) cVar.getX();
            int measuredWidth2 = cVar.getMeasuredWidth();
            int measuredWidth3 = this.f7485g.getMeasuredWidth();
            Log.d(f7478p, "index = " + i10 + " --- scrollViewWidth = " + measuredWidth + " --- scrolled = " + scrollX + " --- tabViewX = " + x10 + " --- tabViewWidth" + measuredWidth2);
            int i12 = this.f7486h;
            if (i12 == 2) {
                int i13 = x10 + (measuredWidth2 / 2);
                int i14 = measuredWidth / 2;
                if (i13 < i14 || i13 > measuredWidth3 - i14 || i13 == scrollX + i14) {
                    return;
                }
                smoothScrollTo(i13 - i14, 0);
                return;
            }
            if (i12 != 3) {
                return;
            }
            int i15 = measuredWidth2 + x10;
            if (i15 > measuredWidth + scrollX) {
                smoothScrollTo(i15 - measuredWidth, 0);
            } else if (scrollX > x10) {
                smoothScrollTo(x10, 0);
            }
        }
    }

    private void p(LinearLayout.LayoutParams layoutParams) {
        if (this.f7486h == 1) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    public void c(@NonNull a aVar) {
        if (this.f7489k.contains(aVar)) {
            return;
        }
        this.f7489k.add(aVar);
    }

    public void d(@NonNull c cVar) {
        e(cVar, this.f7483e);
    }

    public void g() {
        ArrayList<c> arrayList = this.f7480b;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f7480b.clear();
        this.f7485g.removeAllViews();
    }

    public int getMode() {
        return this.f7486h;
    }

    public int getSelectedTabPosition() {
        return this.f7482d;
    }

    public int getTabCount() {
        return this.f7480b.size();
    }

    public c k(int i10) {
        if (i10 < 0 || i10 >= getTabCount()) {
            return null;
        }
        return this.f7480b.get(i10);
    }

    @NonNull
    public c l() {
        c cVar = new c(getContext());
        cVar.setFocusable(false);
        return cVar;
    }

    public void m(@NonNull a aVar) {
        ArrayList<a> arrayList = this.f7489k;
        if (arrayList != null) {
            arrayList.remove(aVar);
        }
    }

    void o(c cVar, int i10) {
        c cVar2 = this.f7481c;
        int i11 = this.f7482d;
        if (cVar2 == cVar) {
            if (cVar2 != null) {
                i(cVar2, i11);
                if (hasFocus()) {
                    setFocusedTabView(i11);
                    return;
                }
                return;
            }
            return;
        }
        if (cVar2 != null) {
            j(cVar2, i11);
            setUnFocusedTabView(i11);
        }
        this.f7481c = cVar;
        this.f7482d = i10;
        if (cVar != null) {
            i(cVar, i10);
            if (hasFocus()) {
                setFocusedTabView(i10);
            }
        }
        n();
    }

    public void setDispatchKeyMode(int i10) {
        if (i10 != this.f7487i) {
            this.f7487i = i10;
        }
    }

    public void setMode(int i10) {
        if (i10 != this.f7486h) {
            this.f7486h = i10;
            f();
        }
    }

    public void setTabCheckShowText(boolean z10) {
        this.f7493o = z10;
    }

    public void setTabIsSelected(boolean z10) {
        this.f7488j = z10;
    }

    public void setTabSelectedListener(a aVar) {
        if (aVar != null) {
            c(aVar);
        }
    }

    public void setTabsMargin(int i10) {
        this.f7483e = i10;
    }

    public void setupWithViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f7490l;
        if (viewPager2 != null) {
            ViewPager.OnPageChangeListener onPageChangeListener = this.f7491m;
            if (onPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(onPageChangeListener);
            }
            a aVar = this.f7492n;
            if (aVar != null) {
                m(aVar);
            }
        }
        if (viewPager == null) {
            this.f7490l = null;
            this.f7491m = null;
            this.f7492n = null;
            return;
        }
        this.f7490l = viewPager;
        b bVar = new b(this);
        this.f7491m = bVar;
        viewPager.addOnPageChangeListener(bVar);
        d dVar = new d(viewPager);
        this.f7492n = dVar;
        c(dVar);
    }

    public MenuTabLayout(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7480b = new ArrayList<>();
        this.f7481c = null;
        this.f7482d = -1;
        this.f7483e = 0;
        this.f7484f = false;
        this.f7486h = 1;
        this.f7487i = 1;
        this.f7488j = true;
        this.f7489k = new ArrayList<>();
        this.f7479a = context.obtainStyledAttributes(attributeSet, R$styleable.MenuTabLayout, 0, 0).getResourceId(0, 0);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f7485g = linearLayout;
        linearLayout.setOrientation(0);
        this.f7485g.setFocusable(false);
        this.f7485g.setFocusableInTouchMode(false);
        f();
        addView(this.f7485g, new FrameLayout.LayoutParams(-2, -1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int tabCount;
        if (keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        int i10 = 0;
        if (keyCode != 21) {
            if (keyCode != 22) {
                return super.dispatchKeyEvent(keyEvent);
            }
            int i11 = this.f7482d;
            if (this.f7484f) {
                if (i11 < getTabCount() - 1) {
                    i10 = i11 + 1;
                }
                setSelectTabView(i10);
            } else if (i11 < getTabCount() - 1) {
                setSelectTabView(i11 + 1);
            } else {
                Log.d(f7478p, "index == count, 不循环");
                int i12 = this.f7487i;
                if (i12 == 3 || i12 == 4) {
                    c cVar = this.f7481c;
                    if (cVar != null) {
                        cVar.setSelected(false);
                    }
                    return super.dispatchKeyEvent(keyEvent);
                }
            }
            return true;
        }
        int i13 = this.f7482d;
        if (this.f7484f) {
            if (i13 > 0) {
                tabCount = i13 - 1;
            } else {
                tabCount = getTabCount() - 1;
            }
            setSelectTabView(tabCount);
        } else if (i13 > 0) {
            setSelectTabView(i13 - 1);
        } else {
            Log.d(f7478p, "index == 0, 不循环");
            int i14 = this.f7487i;
            if (i14 == 2 || i14 == 4) {
                c cVar2 = this.f7481c;
                if (cVar2 != null) {
                    cVar2.setSelected(false);
                }
                return super.dispatchKeyEvent(keyEvent);
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z10, int i10, @Nullable Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (z10) {
            int i11 = this.f7482d;
            if (i11 >= 0) {
                setSelectTabView(i11);
                return;
            } else {
                setSelectTabView(0);
                return;
            }
        }
        ViewCompat.setBackground(k(this.f7482d), AppCompatResources.getDrawable(getContext(), R$drawable.menub_fragment_tab_bg_unfocus));
        k(this.f7482d).findViewById(R$id.tab_title).setEnabled(true);
        k(this.f7482d).findViewById(R$id.tab_title).setSelected(z10);
        k(this.f7482d).findViewById(R$id.tab_bottom_line).setVisibility(0);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (getChildCount() == 1) {
            int measuredWidth = getChildAt(0).getMeasuredWidth();
            if (this.f7486h == 1 && measuredWidth >= getMeasuredWidth()) {
                int childCount = this.f7485g.getChildCount();
                for (int i12 = 0; i12 < childCount; i12++) {
                    this.f7485g.getChildAt(i12).getLayoutParams().width = getMeasuredWidth() / childCount;
                }
            }
        }
    }

    protected void setFocusedTabView(int i10) {
        if (i10 < getTabCount() && k(i10) != null) {
            k(i10).setSelected(true);
        }
    }

    @Override // android.view.View
    public void setOnKeyListener(View.OnKeyListener onKeyListener) {
        super.setOnKeyListener(onKeyListener);
    }

    public void setSelectTabView(int i10) {
        if (i10 < getTabCount()) {
            o(k(i10), i10);
        }
    }

    protected void setUnFocusedTabView(int i10) {
        if (i10 < getTabCount() && k(i10) != null) {
            k(i10).setSelected(false);
        }
    }
}
