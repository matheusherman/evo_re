package com.live.evo.util;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ziyi.kit.keyboard.KeyUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<Integer, d> f7169a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HashMap<Integer, ViewTreeObserver.OnGlobalLayoutListener> f7170b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f7171c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f7172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f7173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f7174f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Window f7175a;

        a(Window window) {
            this.f7175a = window;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            this.f7175a.getDecorView().getWindowVisibleDisplayFrame(rect);
            a0.f7173e = this.f7175a.getDecorView().getHeight();
            int i10 = a0.f7173e - (rect.bottom - rect.top);
            boolean z10 = i10 > a0.f7173e / 4;
            if ((!a0.f7171c || z10) && (a0.f7171c || !z10)) {
                return;
            }
            a0.f7171c = z10;
            Iterator it = a0.f7169a.entrySet().iterator();
            while (it.hasNext()) {
                ((d) ((Map.Entry) it.next()).getValue()).a(a0.f7171c, i10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f7176a;

        b(View view) {
            this.f7176a = view;
        }

        @Override // com.live.evo.util.a0.d
        public void a(boolean z10, int i10) {
            if (a0.l(this.f7176a) != null) {
                if (z10) {
                    a0.t(this.f7176a, i10);
                } else {
                    a0.r(this.f7176a);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f7177a;

        c(View view) {
            this.f7177a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f7177a.clearAnimation();
            int left = this.f7177a.getLeft();
            a0.f7172d = this.f7177a.getTop();
            a0.s(this.f7177a, left, this.f7177a.getTop() + a0.f7174f, this.f7177a.getWidth(), this.f7177a.getHeight() * 2);
            this.f7177a.requestLayout();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface d {
        void a(boolean z10, int i10);
    }

    public static void i(View view, List<EditText> list) {
        if (view == null || (view instanceof ziyi.kit.keyboard.b)) {
            return;
        }
        if (view instanceof EditText) {
            list.add((EditText) view);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                i(viewGroup.getChildAt(i10), list);
            }
        }
    }

    public static void j(Window window, int i10) {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListenerN;
        HashMap<Integer, ViewTreeObserver.OnGlobalLayoutListener> map = f7170b;
        if (map == null || map.containsKey(Integer.valueOf(i10)) || (onGlobalLayoutListenerN = n(window)) == null || window == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListenerN);
        f7170b.put(Integer.valueOf(i10), onGlobalLayoutListenerN);
    }

    public static EditText l(View view) {
        ArrayList arrayList = new ArrayList();
        i(view, arrayList);
        return m(arrayList);
    }

    public static ViewTreeObserver.OnGlobalLayoutListener n(Window window) {
        return new a(window);
    }

    public static void p(Window window, int i10) {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        if (window == null || (onGlobalLayoutListener = f7170b.get(Integer.valueOf(i10))) == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void q(Fragment fragment, View view) {
        if (f7169a == null || fragment == null) {
            return;
        }
        Window window = fragment.getActivity().getWindow();
        if (view != null) {
            f7169a.remove(Integer.valueOf(view.getId()));
        }
        p(window, view.getId());
    }

    public static void r(View view) {
        if (f7174f < 0) {
            int left = view.getLeft();
            int i10 = f7172d;
            int width = view.getWidth();
            int height = view.getHeight() * 2;
            view.layout(left, i10, left + width, i10 + height);
            f7174f = 0;
            s(view, left, i10, width, height);
        }
    }

    public static void k(Fragment fragment, View view) {
        Window window = fragment.getActivity().getWindow();
        if (KeyUtils.k() == null && fragment.getParentFragment() != null && view != null && window != null) {
            j(window, view.getId());
            f7169a.put(Integer.valueOf(view.getId()), new b(view));
        }
    }

    public static EditText m(List<EditText> list) {
        for (EditText editText : list) {
            if (editText.hasFocus()) {
                return editText;
            }
        }
        return null;
    }

    public static void o() {
        KeyUtils.G(R$drawable.key_bg);
        KeyUtils.J(R$drawable.key_normal_focus);
        KeyUtils.L(R$drawable.key_normal_unfocus);
        KeyUtils.K(R$color.keyboard_key_textcolor);
        KeyUtils.H("C");
        KeyUtils.I("B");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(View view, int i10, int i11, int i12, int i13) {
        if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.setMargins(i10, i11, 0, 0);
            layoutParams.width = i12;
            layoutParams.height = i13;
            view.setLayoutParams(layoutParams);
            return;
        }
        if (view.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.setMargins(i10, i11, 0, 0);
            layoutParams2.width = i12;
            layoutParams2.height = i13;
            view.setLayoutParams(layoutParams2);
            return;
        }
        if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams3.setMargins(i10, i11, 0, 0);
            layoutParams3.width = i12;
            layoutParams3.height = i13;
            view.setLayoutParams(layoutParams3);
        }
    }

    public static void t(View view, int i10) {
        EditText editTextL = l(view);
        if (editTextL != null) {
            int i11 = f7173e - i10;
            int[] iArr = {0, 0};
            editTextL.getLocationInWindow(iArr);
            if (iArr[1] + editTextL.getHeight() > i11) {
                f7174f = (i11 - iArr[1]) - editTextL.getHeight();
            }
            if (f7174f < 0) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, f7174f);
                translateAnimation.setInterpolator(new OvershootInterpolator());
                translateAnimation.setAnimationListener(new c(view));
                view.startAnimation(translateAnimation);
            }
        }
    }
}
