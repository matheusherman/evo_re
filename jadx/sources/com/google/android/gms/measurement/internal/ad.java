package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s6 f3406a;

    private final boolean d() {
        return this.f3406a.H().f3391z.a() > 0;
    }

    @WorkerThread
    final void a() {
        this.f3406a.a().n();
        if (d()) {
            if (e()) {
                this.f3406a.H().f3390y.b(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                this.f3406a.J().h1("auto", "_cmpx", bundle);
            } else {
                String strA = this.f3406a.H().f3390y.a();
                if (TextUtils.isEmpty(strA)) {
                    this.f3406a.l().J().a("Cache still valid but referrer not found");
                } else {
                    long jA = ((this.f3406a.H().f3391z.a() / 3600000) - 1) * 3600000;
                    Uri uri = Uri.parse(strA);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(uri.getPath(), bundle2);
                    for (String str : uri.getQueryParameterNames()) {
                        bundle2.putString(str, uri.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", jA);
                    Object obj = pair.first;
                    this.f3406a.J().h1(obj == null ? "app" : (String) obj, "_cmp", (Bundle) pair.second);
                }
                this.f3406a.H().f3390y.b(null);
            }
            this.f3406a.H().f3391z.b(0L);
        }
    }

    @WorkerThread
    final void b(String str, Bundle bundle) {
        String string;
        this.f3406a.a().n();
        if (this.f3406a.s()) {
            return;
        }
        if (bundle == null || bundle.isEmpty()) {
            string = null;
        } else {
            if (str == null || str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.f3406a.H().f3390y.b(string);
        this.f3406a.H().f3391z.b(this.f3406a.c().a());
    }

    public ad(s6 s6Var) {
        this.f3406a = s6Var;
    }

    private final boolean e() {
        if (!d() || this.f3406a.c().a() - this.f3406a.H().f3391z.a() <= this.f3406a.B().D(null, g0.f3572i0)) {
            return false;
        }
        return true;
    }

    final void c() {
        if (d() && e()) {
            this.f3406a.H().f3390y.b(null);
        }
    }
}
