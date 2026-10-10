package e3;

import com.google.gson.y;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f9872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b3.d.b<? extends Date> f9873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b3.d.b<? extends Date> f9874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f9875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y f9876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y f9877f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends b3.d.b<java.sql.Date> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // b3.d.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public java.sql.Date d(Date date) {
            return new java.sql.Date(date.getTime());
        }

        a(Class cls) {
            super(cls);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b extends b3.d.b<Timestamp> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // b3.d.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Timestamp d(Date date) {
            return new Timestamp(date.getTime());
        }

        b(Class cls) {
            super(cls);
        }
    }

    static {
        boolean z10;
        try {
            Class.forName("java.sql.Date");
            z10 = true;
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        f9872a = z10;
        if (z10) {
            f9873b = new a(java.sql.Date.class);
            f9874c = new b(Timestamp.class);
            f9875d = e3.a.f9866b;
            f9876e = e3.b.f9868b;
            f9877f = c.f9870b;
            return;
        }
        f9873b = null;
        f9874c = null;
        f9875d = null;
        f9876e = null;
        f9877f = null;
    }
}
