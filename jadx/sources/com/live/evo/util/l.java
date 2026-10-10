package com.live.evo.util;

import android.R;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static l f7252c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<f> f7253a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7254b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements x1.f1.lb.util.w0.a<String> {
        a() {
        }

        @Override // x1.f1.lb.util.w0.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            l.this.f7254b = Boolean.getBoolean(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean[] f7256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f7257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f7258c;

        c(l lVar, boolean[] zArr, Runnable runnable, Activity activity) {
            this.f7256a = zArr;
            this.f7257b = runnable;
            this.f7258c = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (!this.f7256a[0]) {
                this.f7257b.run();
                this.f7256a[0] = true;
            }
            this.f7258c.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f7259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f7260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean[] f7261c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f7262d;

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            try {
                try {
                    ((AlarmManager) this.f7259a.getSystemService(NotificationCompat.CATEGORY_ALARM)).setTimeZone(this.f7260b.f7269d);
                    if (!this.f7261c[0]) {
                        this.f7262d.run();
                        this.f7261c[0] = true;
                    }
                } catch (Throwable unused) {
                    l.this.f7254b = false;
                    x1.f1.lb.util.w0.f21452a.t("has_stz_p", "false");
                    if (!this.f7261c[0]) {
                        this.f7262d.run();
                        this.f7261c[0] = true;
                    }
                }
                this.f7259a.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            } catch (Throwable th) {
                if (!this.f7261c[0]) {
                    this.f7262d.run();
                    this.f7261c[0] = true;
                }
                throw th;
            }
        }

        d(Activity activity, f fVar, boolean[] zArr, Runnable runnable) {
            this.f7259a = activity;
            this.f7260b = fVar;
            this.f7261c = zArr;
            this.f7262d = runnable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean[] f7264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f7265b;

        e(l lVar, boolean[] zArr, Runnable runnable) {
            this.f7264a = zArr;
            this.f7265b = runnable;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (this.f7264a[0]) {
                return;
            }
            this.f7265b.run();
            this.f7264a[0] = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a3.c("o_id")
        String f7266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a3.c("t_id")
        String f7267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a3.c("set_sys")
        boolean f7268c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a3.c("t_sys_id")
        String f7269d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @a3.c("set_sys_prompt")
        boolean f7270e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @a3.c("message")
        String f7271f;

        public String a() {
            return this.f7271f;
        }

        public String b() {
            return this.f7269d;
        }

        public boolean c() {
            return this.f7268c;
        }

        public boolean d() {
            return this.f7270e;
        }
    }

    public void h(Activity activity, Runnable runnable) {
        Runnable runnable2;
        boolean[] zArr = {false};
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            f fVarB = b(TimeZone.getDefault().getID());
            builder.setMessage(fVarB.a());
            builder.setPositiveButton(2131951835, new c(this, zArr, runnable, activity));
            runnable2 = runnable;
            try {
                builder.setNegativeButton(2131952616, new d(activity, fVarB, zArr, runnable2));
                builder.setOnDismissListener(new e(this, zArr, runnable2));
                builder.show();
            } catch (Throwable unused) {
                if (zArr[0]) {
                    return;
                }
                runnable2.run();
                zArr[0] = true;
            }
        } catch (Throwable unused2) {
            runnable2 = runnable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b extends f3.a<List<f>> {
        b(l lVar) {
        }
    }

    private f b(String str) {
        List<f> list = this.f7253a;
        if (list != null && !list.isEmpty()) {
            try {
                for (f fVar : this.f7253a) {
                    if (TextUtils.equals(fVar.f7266a, str)) {
                        return fVar;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static l d() {
        if (f7252c == null) {
            synchronized (l.class) {
                try {
                    if (f7252c == null) {
                        f7252c = new l("");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f7252c;
    }

    private boolean f(f fVar) {
        if (TextUtils.isEmpty(fVar.f7266a) || TextUtils.isEmpty(fVar.f7267b)) {
            return false;
        }
        return (fVar.c() && TextUtils.isEmpty(fVar.b())) ? false : true;
    }

    public Pair<Boolean, Boolean> g() {
        try {
            if (!this.f7254b) {
                Boolean bool = Boolean.FALSE;
                return Pair.create(bool, bool);
            }
            f fVarB = b(TimeZone.getDefault().getID());
            if (fVarB == null) {
                Boolean bool2 = Boolean.FALSE;
                return Pair.create(bool2, bool2);
            }
            boolean z10 = false;
            boolean z11 = fVarB.c() && !fVarB.f7269d.startsWith("GMT");
            Boolean boolValueOf = Boolean.valueOf(z11);
            if (z11 && fVarB.d()) {
                z10 = true;
            }
            return Pair.create(boolValueOf, Boolean.valueOf(z10));
        } catch (Throwable unused) {
            Boolean bool3 = Boolean.FALSE;
            return Pair.create(bool3, bool3);
        }
    }

    public l(String str) {
        x1.f1.lb.util.w0.f21452a.n("has_stz_p", new a(), "true");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e(str);
    }

    private void e(String str) {
        try {
            for (f fVar : (List) w.a().o(str, new b(this).d())) {
                if (f(fVar)) {
                    this.f7253a.add(fVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public TimeZone c() {
        TimeZone timeZone = TimeZone.getDefault();
        try {
            f fVarB = b(timeZone.getID());
            if (fVarB == null) {
                return timeZone;
            }
            return TimeZone.getTimeZone(fVarB.f7267b);
        } catch (Throwable unused) {
            return timeZone;
        }
    }

    public void i(Context context) {
        try {
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).setTimeZone(b(TimeZone.getDefault().getID()).f7269d);
        } catch (Throwable unused) {
        }
    }
}
