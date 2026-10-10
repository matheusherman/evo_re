package b3;

import com.google.gson.s;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class c extends x<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f751b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<DateFormat> f752a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements y {
        a() {
        }

        @Override // com.google.gson.y
        public <T> x<T> a(com.google.gson.e eVar, f3.a<T> aVar) {
            if (aVar.c() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(g3.c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.q();
            return;
        }
        DateFormat dateFormat = this.f752a.get(0);
        synchronized (this.f752a) {
            str = dateFormat.format(date);
        }
        cVar.G(str);
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f752a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.internal.e.d()) {
            arrayList.add(com.google.gson.internal.j.c(2, 2));
        }
    }

    private Date e(g3.a aVar) throws IOException {
        String strZ = aVar.z();
        synchronized (this.f752a) {
            try {
                Iterator<DateFormat> it = this.f752a.iterator();
                while (it.hasNext()) {
                    try {
                        return it.next().parse(strZ);
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return c3.a.c(strZ, new ParsePosition(0));
                } catch (ParseException e10) {
                    throw new s("Failed parsing '" + strZ + "' as Date; at path " + aVar.m(), e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date b(g3.a aVar) throws IOException {
        if (aVar.B() == g3.b.NULL) {
            aVar.x();
            return null;
        }
        return e(aVar);
    }
}
