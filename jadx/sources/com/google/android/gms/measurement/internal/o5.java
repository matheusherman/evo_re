package com.google.android.gms.measurement.internal;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class o5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f3850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Object f3852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ Object f3853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Object f3854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ p5 f3855f;

    o5(p5 p5Var, int i10, String str, Object obj, Object obj2, Object obj3) {
        this.f3850a = i10;
        this.f3851b = str;
        this.f3852c = obj;
        this.f3853d = obj2;
        this.f3854e = obj3;
        this.f3855f = p5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a6 a6VarH = this.f3855f.f3965a.H();
        if (!a6VarH.t()) {
            this.f3855f.z(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.f3855f.f3886c == 0) {
            if (this.f3855f.d().v()) {
                this.f3855f.f3886c = 'C';
            } else {
                this.f3855f.f3886c = 'c';
            }
        }
        if (this.f3855f.f3887d < 0) {
            this.f3855f.f3887d = 118003L;
        }
        String strSubstring = ExifInterface.GPS_MEASUREMENT_2D + "01VDIWEA?".charAt(this.f3850a) + this.f3855f.f3886c + this.f3855f.f3887d + ":" + p5.y(true, this.f3851b, this.f3852c, this.f3853d, this.f3854e);
        if (strSubstring.length() > 1024) {
            strSubstring = this.f3851b.substring(0, 1024);
        }
        e6 e6Var = a6VarH.f3371f;
        if (e6Var != null) {
            e6Var.b(strSubstring, 1L);
        }
    }
}
