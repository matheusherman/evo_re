package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final w f2480e = new w(true, 3, 1, null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f2481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f2482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Throwable f2483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f2484d;

    private w(boolean z10, int i10, int i11, String str, Throwable th) {
        this.f2481a = z10;
        this.f2484d = i10;
        this.f2482b = str;
        this.f2483c = th;
    }

    /* synthetic */ w(boolean z10, int i10, int i11, String str, Throwable th, j1.i iVar) {
        this(false, 1, 5, null, null);
    }

    @Deprecated
    static w b() {
        return f2480e;
    }

    static w c(@NonNull String str) {
        return new w(false, 1, 5, str, null);
    }

    static w d(@NonNull String str, @NonNull Throwable th) {
        return new w(false, 1, 5, str, th);
    }

    static w f(int i10) {
        return new w(true, i10, 1, null, null);
    }

    static w g(int i10, int i11, @NonNull String str, Throwable th) {
        return new w(false, i10, i11, str, th);
    }

    String a() {
        return this.f2482b;
    }

    final void e() {
        if (this.f2481a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f2483c != null) {
            Log.d("GoogleCertificatesRslt", a(), this.f2483c);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }
}
