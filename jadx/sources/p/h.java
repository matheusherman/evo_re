package p;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class h implements j.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f17173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final URL f17174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f17175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private String f17176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private URL f17177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private volatile byte[] f17178g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f17179h;

    public h(URL url) {
        this(url, i.f17181b);
    }

    public h(String str) {
        this(str, i.f17181b);
    }

    private byte[] d() {
        if (this.f17178g == null) {
            this.f17178g = c().getBytes(j.f.f11519a);
        }
        return this.f17178g;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f17176e)) {
            String string = this.f17175d;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) e0.k.d(this.f17174c)).toString();
            }
            this.f17176e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f17176e;
    }

    private URL g() {
        if (this.f17177f == null) {
            this.f17177f = new URL(f());
        }
        return this.f17177f;
    }

    public String c() {
        String str = this.f17175d;
        return str != null ? str : ((URL) e0.k.d(this.f17174c)).toString();
    }

    public Map<String, String> e() {
        return this.f17173b.b();
    }

    @Override // j.f
    public boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (c().equals(hVar.c()) && this.f17173b.equals(hVar.f17173b)) {
                return true;
            }
        }
        return false;
    }

    @Override // j.f
    public int hashCode() {
        if (this.f17179h == 0) {
            int iHashCode = c().hashCode();
            this.f17179h = iHashCode;
            this.f17179h = (iHashCode * 31) + this.f17173b.hashCode();
        }
        return this.f17179h;
    }

    public h(URL url, i iVar) {
        this.f17174c = (URL) e0.k.d(url);
        this.f17175d = null;
        this.f17173b = (i) e0.k.d(iVar);
    }

    @Override // j.f
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String h() {
        return f();
    }

    public URL i() {
        return g();
    }

    public String toString() {
        return c();
    }

    public h(String str, i iVar) {
        this.f17174c = null;
        this.f17175d = e0.k.b(str);
        this.f17173b = (i) e0.k.d(iVar);
    }
}
