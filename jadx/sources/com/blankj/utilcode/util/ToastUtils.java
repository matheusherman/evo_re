package com.blankj.utilcode.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.R$id;
import com.blankj.utilcode.R$layout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import org.apache.log4j.net.SyslogAppender;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ToastUtils {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ToastUtils f1207l = n();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static WeakReference<e> f1208m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1210b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1211c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1212d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1213e = -16777217;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1214f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1215g = -16777217;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1216h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1217i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Drawable[] f1218j = new Drawable[4];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1219k = false;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class UtilsMaxWidthRelativeLayout extends RelativeLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f1220a = x.b(80.0f);

        public UtilsMaxWidthRelativeLayout(Context context) {
            super(context);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
        }

        @Override // android.widget.RelativeLayout, android.view.View
        protected void onMeasure(int i10, int i11) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(x.f() - f1220a, Integer.MIN_VALUE), i11);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1222b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CharSequence f1223c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f1224d;

        b(View view, CharSequence charSequence, int i10) {
            this.f1222b = view;
            this.f1223c = charSequence;
            this.f1224d = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ToastUtils.l();
            e eVarO = ToastUtils.o(ToastUtils.this);
            WeakReference unused = ToastUtils.f1208m = new WeakReference(eVarO);
            View view = this.f1222b;
            if (view != null) {
                eVarO.b(view);
            } else {
                eVarO.a(this.f1223c);
            }
            eVarO.show(this.f1224d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static abstract class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected Toast f1225a = new Toast(u.a());

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected ToastUtils f1226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected View f1227c;

        private void e(TextView textView) {
            if (this.f1226b.f1214f != -1) {
                this.f1227c.setBackgroundResource(this.f1226b.f1214f);
                textView.setBackgroundColor(0);
                return;
            }
            if (this.f1226b.f1213e != -16777217) {
                Drawable background = this.f1227c.getBackground();
                Drawable background2 = textView.getBackground();
                if (background != null && background2 != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f1226b.f1213e, PorterDuff.Mode.SRC_IN));
                    textView.setBackgroundColor(0);
                } else if (background != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f1226b.f1213e, PorterDuff.Mode.SRC_IN));
                } else if (background2 != null) {
                    background2.mutate().setColorFilter(new PorterDuffColorFilter(this.f1226b.f1213e, PorterDuff.Mode.SRC_IN));
                } else {
                    this.f1227c.setBackgroundColor(this.f1226b.f1213e);
                }
            }
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void a(CharSequence charSequence) {
            View viewU = this.f1226b.u(charSequence);
            if (viewU != null) {
                b(viewU);
                d();
                return;
            }
            View view = this.f1225a.getView();
            this.f1227c = view;
            if (view == null || view.findViewById(R.id.message) == null) {
                b(x.s(R$layout.utils_toast_view));
            }
            TextView textView = (TextView) this.f1227c.findViewById(R.id.message);
            textView.setText(charSequence);
            if (this.f1226b.f1215g != -16777217) {
                textView.setTextColor(this.f1226b.f1215g);
            }
            if (this.f1226b.f1216h != -1) {
                textView.setTextSize(this.f1226b.f1216h);
            }
            e(textView);
            d();
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void b(View view) {
            this.f1227c = view;
            this.f1225a.setView(view);
        }

        View c(int i10) {
            Bitmap bitmapZ = x.z(this.f1227c);
            ImageView imageView = new ImageView(u.a());
            imageView.setTag("TAG_TOAST" + i10);
            imageView.setImageBitmap(bitmapZ);
            return imageView;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        @CallSuper
        public void cancel() {
            Toast toast = this.f1225a;
            if (toast != null) {
                toast.cancel();
            }
            this.f1225a = null;
            this.f1227c = null;
        }

        c(ToastUtils toastUtils) {
            this.f1226b = toastUtils;
            if (toastUtils.f1210b == -1 && this.f1226b.f1211c == -1 && this.f1226b.f1212d == -1) {
                return;
            }
            this.f1225a.setGravity(this.f1226b.f1210b, this.f1226b.f1211c, this.f1226b.f1212d);
        }

        private void d() {
            if (x.r()) {
                b(c(-1));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static int f1228f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private u.a f1229d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private e f1230e;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.cancel();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class b extends u.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f1232a;

            b(int i10) {
                this.f1232a = i10;
            }

            @Override // com.blankj.utilcode.util.u.a
            public void a(@NonNull Activity activity) {
                if (d.this.h()) {
                    d.this.k(activity, this.f1232a, false);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean h() {
            return this.f1229d != null;
        }

        private void i() {
            b bVar = new b(f1228f);
            this.f1229d = bVar;
            x.a(bVar);
        }

        private e j(int i10) {
            f fVar = new f(this.f1226b);
            fVar.f1225a = this.f1225a;
            fVar.show(i10);
            return fVar;
        }

        private e l(Activity activity, int i10) {
            g gVar = new g(this.f1226b, activity.getWindowManager(), 99);
            gVar.f1227c = c(-1);
            gVar.f1225a = this.f1225a;
            gVar.show(i10);
            return gVar;
        }

        private void m() {
            x.v(this.f1229d);
            this.f1229d = null;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void show(int i10) {
            if (this.f1225a == null) {
                return;
            }
            if (!x.p()) {
                this.f1230e = j(i10);
                return;
            }
            boolean z10 = false;
            for (Activity activity : x.e()) {
                if (x.o(activity)) {
                    if (z10) {
                        k(activity, f1228f, true);
                    } else {
                        this.f1230e = l(activity, i10);
                        z10 = true;
                    }
                }
            }
            if (!z10) {
                this.f1230e = j(i10);
                return;
            }
            i();
            x.x(new a(), i10 == 0 ? 2000L : 3500L);
            f1228f++;
        }

        d(ToastUtils toastUtils) {
            super(toastUtils);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(Activity activity, int i10, boolean z10) {
            Window window = activity.getWindow();
            if (window != null) {
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = this.f1225a.getGravity();
                layoutParams.bottomMargin = this.f1225a.getYOffset() + x.i();
                layoutParams.topMargin = this.f1225a.getYOffset() + x.l();
                layoutParams.leftMargin = this.f1225a.getXOffset();
                View viewC = c(i10);
                if (z10) {
                    viewC.setAlpha(0.0f);
                    viewC.animate().alpha(1.0f).setDuration(200L).start();
                }
                viewGroup.addView(viewC, layoutParams);
            }
        }

        @Override // com.blankj.utilcode.util.ToastUtils.c, com.blankj.utilcode.util.ToastUtils.e
        public void cancel() {
            Window window;
            if (h()) {
                m();
                for (Activity activity : x.e()) {
                    if (x.o(activity) && (window = activity.getWindow()) != null) {
                        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("TAG_TOAST");
                        sb2.append(f1228f - 1);
                        View viewFindViewWithTag = viewGroup.findViewWithTag(sb2.toString());
                        if (viewFindViewWithTag != null) {
                            try {
                                viewGroup.removeView(viewFindViewWithTag);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            e eVar = this.f1230e;
            if (eVar != null) {
                eVar.cancel();
                this.f1230e = null;
            }
            super.cancel();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    interface e {
        void a(CharSequence charSequence);

        void b(View view);

        void cancel();

        void show(int i10);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class f extends c {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class a extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Handler f1234a;

            @Override // android.os.Handler
            public void dispatchMessage(@NonNull Message message) {
                try {
                    this.f1234a.dispatchMessage(message);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                this.f1234a.handleMessage(message);
            }

            a(Handler handler) {
                this.f1234a = handler;
            }
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void show(int i10) {
            Toast toast = this.f1225a;
            if (toast == null) {
                return;
            }
            toast.setDuration(i10);
            this.f1225a.show();
        }

        f(ToastUtils toastUtils) {
            super(toastUtils);
            if (Build.VERSION.SDK_INT == 25) {
                try {
                    Field declaredField = Toast.class.getDeclaredField("mTN");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this.f1225a);
                    Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
                    declaredField2.setAccessible(true);
                    declaredField2.set(obj, new a((Handler) declaredField2.get(obj)));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class g extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private WindowManager f1235d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private WindowManager.LayoutParams f1236e;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.cancel();
            }
        }

        g(ToastUtils toastUtils, int i10) {
            super(toastUtils);
            this.f1236e = new WindowManager.LayoutParams();
            this.f1235d = (WindowManager) u.a().getSystemService("window");
            this.f1236e.type = i10;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.c, com.blankj.utilcode.util.ToastUtils.e
        public void cancel() {
            try {
                WindowManager windowManager = this.f1235d;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(this.f1227c);
                    this.f1235d = null;
                }
            } catch (Exception unused) {
            }
            super.cancel();
        }

        @Override // com.blankj.utilcode.util.ToastUtils.e
        public void show(int i10) {
            if (this.f1225a == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = this.f1236e;
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation.Toast;
            layoutParams.setTitle("ToastWithoutNotification");
            WindowManager.LayoutParams layoutParams2 = this.f1236e;
            layoutParams2.flags = SyslogAppender.LOG_LOCAL3;
            layoutParams2.packageName = u.a().getPackageName();
            this.f1236e.gravity = this.f1225a.getGravity();
            WindowManager.LayoutParams layoutParams3 = this.f1236e;
            int i11 = layoutParams3.gravity;
            if ((i11 & 7) == 7) {
                layoutParams3.horizontalWeight = 1.0f;
            }
            if ((i11 & 112) == 112) {
                layoutParams3.verticalWeight = 1.0f;
            }
            layoutParams3.x = this.f1225a.getXOffset();
            this.f1236e.y = this.f1225a.getYOffset();
            this.f1236e.horizontalMargin = this.f1225a.getHorizontalMargin();
            this.f1236e.verticalMargin = this.f1225a.getVerticalMargin();
            try {
                WindowManager windowManager = this.f1235d;
                if (windowManager != null) {
                    windowManager.addView(this.f1227c, this.f1236e);
                }
            } catch (Exception unused) {
            }
            x.x(new a(), i10 == 0 ? 2000L : 3500L);
        }

        g(ToastUtils toastUtils, WindowManager windowManager, int i10) {
            super(toastUtils);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f1236e = layoutParams;
            this.f1235d = windowManager;
            layoutParams.type = i10;
        }
    }

    private static void q(@Nullable CharSequence charSequence, int i10, ToastUtils toastUtils) {
        p(null, m(charSequence), i10, toastUtils);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ToastUtils.f1208m != null) {
                e eVar = (e) ToastUtils.f1208m.get();
                if (eVar != null) {
                    eVar.cancel();
                }
                WeakReference unused = ToastUtils.f1208m = null;
            }
        }
    }

    public static void l() {
        x.w(new a());
    }

    private static CharSequence m(CharSequence charSequence) {
        if (charSequence == null) {
            return "toast null";
        }
        return charSequence.length() == 0 ? "toast nothing" : charSequence;
    }

    @NonNull
    public static ToastUtils n() {
        return new ToastUtils();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static e o(ToastUtils toastUtils) {
        if (!toastUtils.f1219k && NotificationManagerCompat.from(u.a()).areNotificationsEnabled()) {
            if (Build.VERSION.SDK_INT < 23) {
                return new f(toastUtils);
            }
            if (!x.q()) {
                return new f(toastUtils);
            }
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 25) {
            return new g(toastUtils, 2005);
        }
        if (x.q()) {
            return i10 >= 26 ? new g(toastUtils, 2038) : new g(toastUtils, 2002);
        }
        return new d(toastUtils);
    }

    private static void p(@Nullable View view, @Nullable CharSequence charSequence, int i10, @NonNull ToastUtils toastUtils) {
        x.w(toastUtils.new b(view, charSequence, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View u(CharSequence charSequence) {
        if (!"dark".equals(this.f1209a) && !"light".equals(this.f1209a)) {
            Drawable[] drawableArr = this.f1218j;
            if (drawableArr[0] == null && drawableArr[1] == null && drawableArr[2] == null && drawableArr[3] == null) {
                return null;
            }
        }
        View viewS = x.s(R$layout.utils_toast_view);
        TextView textView = (TextView) viewS.findViewById(R.id.message);
        if ("dark".equals(this.f1209a)) {
            ((GradientDrawable) viewS.getBackground().mutate()).setColor(Color.parseColor("#BB000000"));
            textView.setTextColor(-1);
        }
        textView.setText(charSequence);
        if (this.f1218j[0] != null) {
            View viewFindViewById = viewS.findViewById(R$id.utvLeftIconView);
            ViewCompat.setBackground(viewFindViewById, this.f1218j[0]);
            viewFindViewById.setVisibility(0);
        }
        if (this.f1218j[1] != null) {
            View viewFindViewById2 = viewS.findViewById(R$id.utvTopIconView);
            ViewCompat.setBackground(viewFindViewById2, this.f1218j[1]);
            viewFindViewById2.setVisibility(0);
        }
        if (this.f1218j[2] != null) {
            View viewFindViewById3 = viewS.findViewById(R$id.utvRightIconView);
            ViewCompat.setBackground(viewFindViewById3, this.f1218j[2]);
            viewFindViewById3.setVisibility(0);
        }
        if (this.f1218j[3] != null) {
            View viewFindViewById4 = viewS.findViewById(R$id.utvBottomIconView);
            ViewCompat.setBackground(viewFindViewById4, this.f1218j[3]);
            viewFindViewById4.setVisibility(0);
        }
        return viewS;
    }

    public static void r(@Nullable String str, Object... objArr) {
        q(x.d(str, objArr), 1, f1207l);
    }

    public static void s(@StringRes int i10) {
        q(x.m(i10), 0, f1207l);
    }

    public static void t(@Nullable String str, Object... objArr) {
        q(x.d(str, objArr), 0, f1207l);
    }
}
