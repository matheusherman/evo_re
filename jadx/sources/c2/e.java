package c2;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a.g f1109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a.g f1110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a.AbstractC0042a f1111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final com.google.android.gms.common.api.a.AbstractC0042a f1112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Scope f1113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Scope f1114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f1115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f1116h;

    static {
        com.google.android.gms.common.api.a.g gVar = new com.google.android.gms.common.api.a.g();
        f1109a = gVar;
        com.google.android.gms.common.api.a.g gVar2 = new com.google.android.gms.common.api.a.g();
        f1110b = gVar2;
        b bVar = new b();
        f1111c = bVar;
        c cVar = new c();
        f1112d = cVar;
        f1113e = new Scope("profile");
        f1114f = new Scope(NotificationCompat.CATEGORY_EMAIL);
        f1115g = new com.google.android.gms.common.api.a("SignIn.API", bVar, gVar);
        f1116h = new com.google.android.gms.common.api.a("SignIn.INTERNAL_API", cVar, gVar2);
    }
}
