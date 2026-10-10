package a5;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static b f116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static List<String> f117i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f118j = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f119a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f120b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f121c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f122d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f123e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f124f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f125g;

    public static b a() {
        if (f116h == null) {
            f116h = new b();
        }
        return f116h;
    }

    public boolean c() {
        return this.f125g;
    }

    private b() {
    }

    public boolean b() {
        if (!c() || TextUtils.isEmpty(this.f120b) || this.f122d != 1) {
            return false;
        }
        return true;
    }
}
