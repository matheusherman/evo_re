package b3;

import com.google.gson.s;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class d<T extends Date> extends x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b<T> f753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<DateFormat> f754b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class b<T extends Date> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b<Date> f755b = new a(Date.class);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<T> f756a;

        protected abstract T d(Date date);

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a extends b<Date> {
            a(Class cls) {
                super(cls);
            }

            @Override // b3.d.b
            protected Date d(Date date) {
                return date;
            }
        }

        private y c(d<T> dVar) {
            return o.b(this.f756a, dVar);
        }

        public final y a(int i10, int i11) {
            return c(new d<>(this, i10, i11, null));
        }

        public final y b(String str) {
            return c(new d<>(this, str, (a) null));
        }

        protected b(Class<T> cls) {
            this.f756a = cls;
        }
    }

    /* synthetic */ d(b bVar, int i10, int i11, a aVar) {
        this(bVar, i10, i11);
    }

    /* synthetic */ d(b bVar, String str, a aVar) {
        this(bVar, str);
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(g3.c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.q();
            return;
        }
        DateFormat dateFormat = this.f754b.get(0);
        synchronized (this.f754b) {
            str = dateFormat.format(date);
        }
        cVar.G(str);
    }

    public String toString() {
        DateFormat dateFormat = this.f754b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    private d(b<T> bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.f754b = arrayList;
        Objects.requireNonNull(bVar);
        this.f753a = bVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    private Date e(g3.a aVar) throws IOException {
        String strZ = aVar.z();
        synchronized (this.f754b) {
            try {
                Iterator<DateFormat> it = this.f754b.iterator();
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
    public T b(g3.a aVar) throws IOException {
        if (aVar.B() == g3.b.NULL) {
            aVar.x();
            return null;
        }
        return (T) this.f753a.d(e(aVar));
    }

    private d(b<T> bVar, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        this.f754b = arrayList;
        Objects.requireNonNull(bVar);
        this.f753a = bVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i10, i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i10, i11));
        }
        if (com.google.gson.internal.e.d()) {
            arrayList.add(com.google.gson.internal.j.c(i10, i11));
        }
    }
}
