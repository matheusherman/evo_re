package l7;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f15231b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15232a;

    private boolean b(String str) {
        a aVarA = b.a("https://mpush-api.aliyun.com/v2.0/a/audid/req/", str, true);
        if (aVarA == null) {
            return false;
        }
        return com.ta.utdid2.device.e.a(aVarA);
    }

    public h(Context context) {
        this.f15232a = context;
    }

    private void a() {
        m7.f.i();
        if (m7.d.a(this.f15232a) && !f15231b) {
            f15231b = true;
            try {
                c();
                f15231b = false;
            } catch (Throwable unused) {
                f15231b = false;
            }
        }
    }

    private void c() {
        m7.f.i();
        String strD = d();
        if (TextUtils.isEmpty(strD)) {
            m7.f.e("postData is empty", new Object[0]);
        } else if (b(strD)) {
            m7.f.e("", "upload success");
        } else {
            m7.f.e("", "upload fail");
        }
    }

    private String d() {
        String strM = com.ta.utdid2.device.a.a().m();
        if (TextUtils.isEmpty(strM)) {
            return null;
        }
        String strA = k7.a.a(strM);
        if (m7.f.f()) {
            m7.f.h("", strA);
        }
        return k7.b.a(strA);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Throwable th) {
            m7.f.d("", th, new Object[0]);
        }
    }
}
