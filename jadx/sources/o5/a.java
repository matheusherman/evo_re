package o5;

import ac.g;
import android.text.TextUtils;
import i5.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f16454c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<o> f16455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16456b = "^\\+\\d{5,20}$";

    /* JADX INFO: renamed from: o5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0320a implements Comparator<o> {
        C0320a(a aVar) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(o oVar, o oVar2) {
            return oVar2.e() - oVar.e();
        }
    }

    public static a c() {
        if (f16454c == null) {
            synchronized (a.class) {
                try {
                    if (f16454c == null) {
                        f16454c = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f16454c;
    }

    public List<o> b() {
        return this.f16455a;
    }

    public void e() {
        if (this.f16455a == null) {
            this.f16455a = new ArrayList();
        }
        if (this.f16455a.isEmpty()) {
            this.f16455a.add(new o("+55", "BR", "BR", 1, ""));
        }
        Collections.sort(this.f16455a, new C0320a(this));
        for (o oVar : this.f16455a) {
            if (TextUtils.isEmpty(oVar.d())) {
                oVar.f("^\\+\\d{5,20}$");
            }
        }
    }

    public boolean f(String str) {
        return str.contains("@") && str.contains(".") && !str.startsWith("@") && !str.endsWith("@");
    }

    public boolean g(String str) {
        return h(str, "");
    }

    public a() {
        e();
    }

    public int a(String str) {
        if (f(str)) {
            return 0;
        }
        if (g(str)) {
            return 1;
        }
        return -1;
    }

    public String d(String str) {
        return g.s(str).replace("-", "").replace(" ", "");
    }

    public boolean h(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strReplace = str.replace(" ", "");
        String strC = "^\\+\\d{5,20}$";
        if (!TextUtils.isEmpty(str2)) {
            for (o oVar : this.f16455a) {
                if (oVar.c().equalsIgnoreCase(str2)) {
                    strC = oVar.c();
                }
            }
        }
        return Pattern.matches(strC, strReplace);
    }
}
