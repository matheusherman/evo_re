package e3;

import com.google.gson.e;
import com.google.gson.s;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class a extends x<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final y f9866b = new C0174a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateFormat f9867a;

    /* synthetic */ a(C0174a c0174a) {
        this();
    }

    /* JADX INFO: renamed from: e3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0174a implements y {
        C0174a() {
        }

        @Override // com.google.gson.y
        public <T> x<T> a(e eVar, f3.a<T> aVar) {
            C0174a c0174a = null;
            if (aVar.c() != Date.class) {
                return null;
            }
            return new a(c0174a);
        }
    }

    private a() {
        this.f9867a = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(g3.c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.q();
            return;
        }
        synchronized (this) {
            str = this.f9867a.format((java.util.Date) date);
        }
        cVar.G(str);
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Date b(g3.a aVar) throws IOException {
        java.util.Date date;
        if (aVar.B() == g3.b.NULL) {
            aVar.x();
            return null;
        }
        String strZ = aVar.z();
        try {
            synchronized (this) {
                date = this.f9867a.parse(strZ);
            }
            return new Date(date.getTime());
        } catch (ParseException e10) {
            throw new s("Failed parsing '" + strZ + "' as SQL Date; at path " + aVar.m(), e10);
        }
    }
}
