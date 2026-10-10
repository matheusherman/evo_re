package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.log4j.Priority;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class aj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f8738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected long f8739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f8740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f8743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f8744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f8745h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final aa f8746i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ac f8747j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final af f8748k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ai f8749l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f8750m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ah f8751n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ah f8752o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f8753p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String f8754q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Map<String, String> f8755r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f8756s;

    public aj(Context context, int i10, int i11, byte[] bArr, String str, String str2, ah ahVar, boolean z10) {
        this(context, i10, i11, bArr, str, str2, ahVar, 2, Priority.WARN_INT, z10);
    }

    private static void a(String str) {
        al.e("[Upload] Failed to upload(%d): %s", 1, str);
    }

    public final void b(long j10) {
        this.f8740c += j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        ac acVar;
        Pair pair;
        boolean zBooleanValue;
        try {
            this.f8738a = 0;
            this.f8739b = 0L;
            this.f8740c = 0L;
            if (ab.c(this.f8743f) == null) {
                str = "network is not available";
            } else {
                byte[] bArr = this.f8745h;
                if (bArr == null || bArr.length == 0) {
                    str = "request package is empty!";
                } else if (this.f8743f == null || this.f8746i == null || (acVar = this.f8747j) == null || this.f8748k == null) {
                    str = "illegal access error";
                } else {
                    str = acVar.c() == null ? "illegal local strategy" : null;
                }
            }
            if (str != null) {
                a(false, 0, str);
                return;
            }
            byte[] bArrA = ap.a(this.f8745h);
            if (bArrA == null) {
                a(false, 0, "failed to zip request body");
                return;
            }
            HashMap map = new HashMap(10);
            map.put("tls", "1");
            map.put("prodId", this.f8746i.e());
            map.put("bundleId", this.f8746i.f8666c);
            map.put("appVer", this.f8746i.f8678o);
            Map<String, String> map2 = this.f8755r;
            if (map2 != null) {
                map.putAll(map2);
            }
            map.put("cmd", Integer.toString(this.f8744g));
            map.put("platformId", Byte.toString((byte) 1));
            map.put("sdkVer", this.f8746i.f8671h);
            map.put("strategylastUpdateTime", Long.toString(this.f8747j.c().f8591o));
            this.f8749l.a(this.f8750m, System.currentTimeMillis());
            String strB = this.f8753p;
            this.f8747j.c();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int i12 = i10 + 1;
                if (i10 >= this.f8741d) {
                    a(false, i11, "failed after many attempts");
                    return;
                }
                if (i12 > 1) {
                    al.d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i12));
                    ap.b(this.f8742e);
                    if (i12 == this.f8741d) {
                        al.d("[Upload] Use the back-up url at the last time: %s", this.f8754q);
                        strB = this.f8754q;
                    }
                }
                al.c("[Upload] Send %d bytes", Integer.valueOf(bArrA.length));
                strB = b(strB);
                al.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", strB, Integer.valueOf(this.f8744g), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                byte[] bArrA2 = this.f8748k.a(strB, bArrA, this, map);
                Map<String, String> map3 = this.f8748k.f8705c;
                Pair<Boolean, Boolean> pairA = a(bArrA2, map3);
                if (((Boolean) pairA.first).booleanValue()) {
                    Pair<Boolean, Boolean> pairA2 = a(map3);
                    if (((Boolean) pairA2.first).booleanValue()) {
                        byte[] bArrB = ap.b(bArrA2);
                        if (bArrB != null) {
                            bArrA2 = bArrB;
                        }
                        br brVarA = ae.a(bArrA2);
                        if (brVarA == null) {
                            a(false, 1, "failed to decode response package");
                            Boolean bool = Boolean.FALSE;
                            pair = new Pair(bool, bool);
                        } else {
                            Integer numValueOf = Integer.valueOf(brVarA.f9021b);
                            byte[] bArr2 = brVarA.f9022c;
                            al.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", numValueOf, Integer.valueOf(bArr2 == null ? 0 : bArr2.length));
                            if (a(brVarA, this.f8746i, this.f8747j)) {
                                a(true, 2, "successfully uploaded");
                                Boolean bool2 = Boolean.TRUE;
                                pair = new Pair(bool2, bool2);
                            } else {
                                a(false, 2, "failed to process response package");
                                Boolean bool3 = Boolean.FALSE;
                                pair = new Pair(bool3, bool3);
                            }
                        }
                        zBooleanValue = !((Boolean) pair.first).booleanValue() ? ((Boolean) pair.second).booleanValue() : false;
                    } else {
                        zBooleanValue = ((Boolean) pairA2.second).booleanValue();
                    }
                } else {
                    zBooleanValue = ((Boolean) pairA.second).booleanValue();
                }
                if (!zBooleanValue) {
                    return;
                }
                i10 = i12;
                i11 = 1;
            }
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public aj(Context context, int i10, int i11, byte[] bArr, String str, String str2, ah ahVar, int i12, int i13, boolean z10) {
        this.f8741d = 2;
        this.f8742e = Priority.WARN_INT;
        this.f8753p = null;
        this.f8738a = 0;
        this.f8739b = 0L;
        this.f8740c = 0L;
        this.f8756s = false;
        this.f8743f = context;
        this.f8746i = aa.a(context);
        this.f8745h = bArr;
        this.f8747j = ac.a();
        if (af.f8703a == null) {
            af.f8703a = new af(context);
        }
        this.f8748k = af.f8703a;
        ai aiVarA = ai.a();
        this.f8749l = aiVarA;
        this.f8750m = i10;
        this.f8753p = str;
        this.f8754q = str2;
        this.f8751n = ahVar;
        this.f8752o = aiVarA.f8722a;
        this.f8744g = i11;
        if (i12 > 0) {
            this.f8741d = i12;
        }
        if (i13 > 0) {
            this.f8742e = i13;
        }
        this.f8756s = z10;
        this.f8755r = null;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0017  */
    /* JADX WARN: Code duplicated, block: B:12:0x001a  */
    private void a(boolean z10, int i10, String str) {
        String strValueOf;
        int i11 = this.f8744g;
        if (i11 == 630) {
            strValueOf = "crash";
        } else if (i11 == 640) {
            strValueOf = "userinfo";
        } else if (i11 == 830) {
            strValueOf = "crash";
        } else if (i11 != 840) {
            strValueOf = String.valueOf(i11);
        } else {
            strValueOf = "userinfo";
        }
        if (z10) {
            al.a("[Upload] Success: %s", strValueOf);
        } else {
            al.e("[Upload] Failed to upload(%d) %s: %s", Integer.valueOf(i10), strValueOf, str);
        }
        if (this.f8739b + this.f8740c > 0) {
            this.f8749l.a(this.f8749l.a(this.f8756s) + this.f8739b + this.f8740c, this.f8756s);
        }
        ah ahVar = this.f8751n;
        if (ahVar != null) {
            ahVar.a(z10, str);
        }
        ah ahVar2 = this.f8752o;
        if (ahVar2 != null) {
            ahVar2.a(z10, str);
        }
    }

    private static String b(String str) {
        if (ap.b(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            al.a(th);
            return str;
        }
    }

    private static boolean a(br brVar, aa aaVar, ac acVar) {
        if (brVar == null) {
            al.d("resp == null!", new Object[0]);
            return false;
        }
        byte b10 = brVar.f9020a;
        if (b10 != 0) {
            al.e("resp result error %d", Byte.valueOf(b10));
            return false;
        }
        try {
            if (!ap.b(brVar.f9026g) && !aa.b().i().equals(brVar.f9026g)) {
                w.a().a(ac.f8693a, "device", brVar.f9026g.getBytes("UTF-8"), true);
                aaVar.d(brVar.f9026g);
            }
        } catch (Throwable th) {
            al.a(th);
        }
        aaVar.f8676m = brVar.f9024e;
        int i10 = brVar.f9021b;
        if (i10 == 510) {
            byte[] bArr = brVar.f9022c;
            if (bArr == null) {
                al.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i10));
                return false;
            }
            bt btVar = (bt) ae.a(bArr, bt.class);
            if (btVar == null) {
                al.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(brVar.f9021b));
                return false;
            }
            acVar.a(btVar);
        }
        return true;
    }

    private Pair<Boolean, Boolean> a(byte[] bArr, Map<String, String> map) {
        if (bArr == null) {
            a("Failed to upload for no response!");
            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
        }
        al.c("[Upload] Received %d bytes", Integer.valueOf(bArr.length));
        if (bArr.length == 0) {
            a(false, 1, "response data from server is empty");
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    al.c("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
                }
            }
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        Boolean bool2 = Boolean.TRUE;
        return new Pair<>(bool2, bool2);
    }

    public final void a(long j10) {
        this.f8738a++;
        this.f8739b += j10;
    }

    private Pair<Boolean, Boolean> a(Map<String, String> map) {
        int i10;
        if (map != null && map.size() != 0) {
            if (!map.containsKey(NotificationCompat.CATEGORY_STATUS)) {
                al.d("[Upload] Headers does not contain %s", NotificationCompat.CATEGORY_STATUS);
            } else if (!map.containsKey("Bugly-Version")) {
                al.d("[Upload] Headers does not contain %s", "Bugly-Version");
            } else {
                String str = map.get("Bugly-Version");
                if (!str.contains("bugly")) {
                    al.d("[Upload] Bugly version is not valid: %s", str);
                } else {
                    al.c("[Upload] Bugly version from headers is: %s", str);
                    try {
                        i10 = Integer.parseInt(map.get(NotificationCompat.CATEGORY_STATUS));
                        try {
                            al.c("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i10), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                            if (i10 != 0) {
                                a(false, 1, "status of server is ".concat(String.valueOf(i10)));
                                Boolean bool = Boolean.FALSE;
                                return new Pair<>(bool, bool);
                            }
                            Boolean bool2 = Boolean.TRUE;
                            return new Pair<>(bool2, bool2);
                        } catch (Throwable unused) {
                            a("[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i10));
                            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
                        }
                    } catch (Throwable unused2) {
                        i10 = -1;
                    }
                }
            }
        } else {
            al.d("[Upload] Headers is empty.", new Object[0]);
        }
        al.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        a("[Upload] Failed to upload for no status header.");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                al.c(String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new Object[0]);
            }
        }
        al.c("[Upload] Failed to upload for no status header.", new Object[0]);
        return new Pair<>(Boolean.FALSE, Boolean.TRUE);
    }
}
