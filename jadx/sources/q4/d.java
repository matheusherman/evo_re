package q4;

import com.koushikdutta.async.http.k;
import com.koushikdutta.async.http.l;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.koushikdutta.async.http.h f17648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    k f17649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f17650c;

    public d(com.koushikdutta.async.http.h hVar) {
        this.f17650c = -1L;
        this.f17648a = hVar;
        this.f17649b = k.q(hVar.c("Content-Disposition"));
    }

    public String a() {
        return this.f17649b.i("name");
    }

    public d(String str, long j10, List<l> list) {
        this.f17650c = j10;
        this.f17648a = new com.koushikdutta.async.http.h();
        StringBuilder sb2 = new StringBuilder(String.format(Locale.ENGLISH, "form-data; name=\"%s\"", str));
        if (list != null) {
            for (l lVar : list) {
                sb2.append(String.format(Locale.ENGLISH, "; %s=\"%s\"", lVar.getName(), lVar.getValue()));
            }
        }
        this.f17648a.g("Content-Disposition", sb2.toString());
        this.f17649b = k.q(this.f17648a.c("Content-Disposition"));
    }
}
