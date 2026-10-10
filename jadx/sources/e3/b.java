package e3;

import com.google.gson.e;
import com.google.gson.s;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class b extends x<Time> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final y f9868b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateFormat f9869a;

    /* synthetic */ b(a aVar) {
        this();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements y {
        a() {
        }

        @Override // com.google.gson.y
        public <T> x<T> a(e eVar, f3.a<T> aVar) {
            a aVar2 = null;
            if (aVar.c() != Time.class) {
                return null;
            }
            return new b(aVar2);
        }
    }

    private b() {
        this.f9869a = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(g3.c cVar, Time time) throws IOException {
        String str;
        if (time == null) {
            cVar.q();
            return;
        }
        synchronized (this) {
            str = this.f9869a.format((Date) time);
        }
        cVar.G(str);
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Time b(g3.a aVar) throws IOException {
        Time time;
        if (aVar.B() == g3.b.NULL) {
            aVar.x();
            return null;
        }
        String strZ = aVar.z();
        try {
            synchronized (this) {
                time = new Time(this.f9869a.parse(strZ).getTime());
            }
            return time;
        } catch (ParseException e10) {
            throw new s("Failed parsing '" + strZ + "' as SQL Time; at path " + aVar.m(), e10);
        }
    }
}
