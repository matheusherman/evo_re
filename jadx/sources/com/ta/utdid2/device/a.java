package com.ta.utdid2.device;

import android.content.Context;
import android.text.TextUtils;
import l7.h;
import m7.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f8378a = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f8379c = 3000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8380d = "";

    synchronized String getUtdid(Context context) {
        if (!TextUtils.isEmpty(this.f8380d)) {
            return this.f8380d;
        }
        try {
            m7.c.a();
            String strL = l();
            if (TextUtils.isEmpty(strL)) {
                strL = d.a(context).getValue();
            }
            if (TextUtils.isEmpty(strL)) {
                m7.c.b();
                return "ffffffffffffffffffffffff";
            }
            this.f8380d = strL;
            f();
            String str = this.f8380d;
            m7.c.b();
            return str;
        } catch (Throwable th) {
            try {
                f.d("AppUtdid", th, new Object[0]);
                return "ffffffffffffffffffffffff";
            } finally {
                m7.c.b();
            }
        }
        throw th;
    }

    public synchronized String m() {
        return this.f8380d;
    }

    public static a a() {
        return f8378a;
    }

    private void f() {
        f.i();
        if (TextUtils.isEmpty(this.f8380d)) {
            return;
        }
        try {
            final Context contextF = j7.a.b().f();
            boolean zM94c = c.m94c(contextF);
            f.e("", "isMainProcess", Boolean.valueOf(zM94c));
            if (zM94c) {
                new Thread(new Runnable() { // from class: com.ta.utdid2.device.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Thread.sleep(a.f8379c);
                        } catch (Exception unused) {
                        }
                        if (!l7.e.c(contextF)) {
                            f.e("", "unable upload!");
                        } else {
                            new h(contextF).run();
                        }
                    }
                }).start();
            }
        } catch (Throwable th) {
            f.e("", th);
        }
    }

    private a() {
    }

    private String l() {
        if (j7.a.b().f() == null) {
            return "";
        }
        String strF = l7.e.f();
        if (d.m95c(strF)) {
            f.e("AppUtdid", "read utdid from V5AppFile");
            d.setType(7);
            return strF;
        }
        return null;
    }
}
