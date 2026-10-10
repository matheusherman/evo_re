package l7;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15218a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f15219b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15220c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f15221d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f15222e = 0;

    public static boolean a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                m7.f.h("", "result", str, "signature", str2);
                if (str2.equals(n7.a.c(m7.b.e(str).getBytes(), 2))) {
                    m7.f.e("", "signature is ok");
                    return true;
                }
                m7.f.e("", "signature is error");
            }
        } catch (Exception e10) {
            m7.f.e("", e10);
        }
        return false;
    }
}
