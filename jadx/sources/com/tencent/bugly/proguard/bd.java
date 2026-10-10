package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class bd implements NativeExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final as f8932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final aa f8933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ac f8934d;

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i10, int i11, long j10, long j11, String str, String str2, String str3, String str4, int i12, String str5, int i13, int i14, int i15, String str6, String str7) {
        al.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i10, i11, j10, j11, str, str2, str3, str4, i12, str5, i13, i14, i15, str6, str7, null);
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException2(int i10, int i11, long j10, long j11, String str, String str2, String str3, String str4, int i12, String str5, int i13, int i14, int i15, String str6, String str7, String[] strArr) {
        String str8;
        String string;
        boolean z10;
        String str9;
        String str10;
        al.a("Native Crash Happen v2", new Object[0]);
        if (i12 > 0) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("(");
                str8 = str5;
                sb2.append(str8);
                sb2.append(")");
                string = sb2.toString();
            } catch (Throwable th) {
                if (al.a(th)) {
                    return;
                }
                th.printStackTrace();
                return;
            }
        } else {
            string = str;
            str8 = str5;
        }
        String strA = be.a(str3);
        Map<String, String> mapA = a(strArr);
        String str11 = mapA.get("HasPendingException");
        if (str11 == null || !str11.equals("true")) {
            z10 = false;
        } else {
            al.a("Native crash happened with a Java pending exception.", new Object[0]);
            z10 = true;
        }
        aa aaVar = this.f8933c;
        String str12 = mapA.get("ExceptionProcessName");
        if (str12 == null || str12.length() == 0) {
            str12 = aaVar.f8667d;
        } else {
            al.c("Name of crash process: %s", str12);
        }
        String str13 = mapA.get("ExceptionThreadName");
        al.c("crash thread name:%s tid:%s", str13, Integer.valueOf(i11));
        if (TextUtils.isEmpty(str13)) {
            str9 = Thread.currentThread().getName() + "(" + i11 + ")";
        } else {
            str9 = str13 + "(" + i11 + ")";
        }
        long j12 = (j10 * 1000) + (j11 / 1000);
        String str14 = mapA.get("SysLogPath");
        String str15 = mapA.get("JniLogPath");
        if (!this.f8934d.b()) {
            al.d("no remote but still store!", new Object[0]);
        }
        if (!this.f8934d.c().f8582f && this.f8934d.b()) {
            al.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
            as.a("NATIVE_CRASH", ap.a(), str12, str9, string + "\n" + str2 + "\n" + strA, null);
            ap.c(str4);
            return;
        }
        String str16 = str9;
        if (i12 > 0) {
            str8 = "KERNEL";
        }
        String str17 = "UNKNOWN";
        if (i12 <= 0) {
            str10 = str16;
            String strA2 = i13 > 0 ? z.a(i13) : "UNKNOWN";
            if (strA2.equals(String.valueOf(i13))) {
                str17 = strA2;
            } else {
                str17 = strA2 + "(" + i13 + ")";
            }
        } else {
            str10 = str16;
        }
        String str18 = str12;
        String str19 = str10;
        CrashDetailBean crashDetailBeanPackageCrashDatas = packageCrashDatas(str18, str19, j12, string, str2, strA, str8, str17, str4, str14, str15, str7, null, null, true, z10);
        if (crashDetailBeanPackageCrashDatas == null) {
            al.e("pkg crash datas fail!", new Object[0]);
            return;
        }
        as.a("NATIVE_CRASH", ap.a(), str18, str19, string + "\n" + str2 + "\n" + strA, crashDetailBeanPackageCrashDatas);
        as asVar = this.f8932b;
        if (asVar == null) {
            al.d("crashHandler is null. Won't upload native crash.", new Object[0]);
            return;
        }
        boolean zA = asVar.a(crashDetailBeanPackageCrashDatas, true);
        be.a(true, NativeCrashHandler.getInstance() != null ? NativeCrashHandler.getDumpFilePath() : null);
        if (!zA) {
            this.f8932b.b(crashDetailBeanPackageCrashDatas, true);
        }
        this.f8932b.a(crashDetailBeanPackageCrashDatas);
        at.a().f8845t.b();
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j10, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z10, boolean z11) {
        int i10;
        String str12;
        int iIndexOf;
        boolean zI = at.a().i();
        if (zI) {
            al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f8602b = 1;
        crashDetailBean.f8605e = this.f8933c.g();
        aa aaVar = this.f8933c;
        crashDetailBean.f8606f = aaVar.f8678o;
        crashDetailBean.f8607g = aaVar.q();
        crashDetailBean.f8613m = this.f8933c.f();
        crashDetailBean.f8614n = str3;
        crashDetailBean.f8615o = zI ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.f8616p = str4;
        String str13 = str5 != null ? str5 : "";
        crashDetailBean.f8617q = str13;
        crashDetailBean.f8618r = j10;
        crashDetailBean.f8621u = ap.c(str13.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.L = this.f8933c.s();
        crashDetailBean.f8608h = this.f8933c.p();
        crashDetailBean.f8609i = this.f8933c.A();
        crashDetailBean.f8622v = str8;
        String dumpFilePath = NativeCrashHandler.getInstance() != null ? NativeCrashHandler.getDumpFilePath() : null;
        String strA = be.a(dumpFilePath, str8);
        if (!ap.b(strA)) {
            crashDetailBean.Z = strA;
        }
        crashDetailBean.f8601aa = be.b(dumpFilePath);
        crashDetailBean.f8623w = be.a(str9, at.f8830f, at.f8835k, at.f8840p);
        crashDetailBean.f8624x = be.a(str10, at.f8830f, null, true);
        crashDetailBean.N = str7;
        crashDetailBean.O = str6;
        crashDetailBean.P = str11;
        crashDetailBean.F = this.f8933c.k();
        crashDetailBean.G = this.f8933c.j();
        crashDetailBean.H = this.f8933c.l();
        crashDetailBean.I = ab.b(this.f8931a);
        crashDetailBean.J = ab.g();
        crashDetailBean.K = ab.h();
        if (!z10) {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.f8623w == null) {
                crashDetailBean.f8623w = "This crash occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.Q = -1L;
            crashDetailBean.U = -1;
            crashDetailBean.V = -1;
            crashDetailBean.W = map;
            crashDetailBean.X = this.f8933c.y();
            crashDetailBean.f8626z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.f8625y = bArr;
            }
            return crashDetailBean;
        }
        crashDetailBean.C = ab.j();
        crashDetailBean.D = ab.f();
        crashDetailBean.E = ab.l();
        crashDetailBean.f8625y = ao.a();
        aa aaVar2 = this.f8933c;
        crashDetailBean.Q = aaVar2.f8657a;
        crashDetailBean.R = aaVar2.a();
        crashDetailBean.f8626z = ap.a(this.f8933c.Q, at.f8832h);
        int iIndexOf2 = crashDetailBean.f8617q.indexOf("java:\n");
        if (iIndexOf2 > 0 && (i10 = iIndexOf2 + 6) < crashDetailBean.f8617q.length()) {
            String str14 = crashDetailBean.f8617q;
            String strSubstring = str14.substring(i10, str14.length() - 1);
            if (strSubstring.length() > 0 && crashDetailBean.f8626z.containsKey(crashDetailBean.B) && (iIndexOf = (str12 = crashDetailBean.f8626z.get(crashDetailBean.B)).indexOf(strSubstring)) > 0) {
                String strSubstring2 = str12.substring(iIndexOf);
                crashDetailBean.f8626z.put(crashDetailBean.B, strSubstring2);
                crashDetailBean.f8617q = crashDetailBean.f8617q.substring(0, i10);
                crashDetailBean.f8617q += strSubstring2;
            }
        }
        if (str == null) {
            crashDetailBean.A = this.f8933c.f8667d;
        }
        crashDetailBean.U = this.f8933c.z();
        aa aaVar3 = this.f8933c;
        crashDetailBean.V = aaVar3.f8687x;
        crashDetailBean.W = aaVar3.t();
        crashDetailBean.X = this.f8933c.y();
        return crashDetailBean;
    }

    private static Map<String, String> a(String[] strArr) {
        HashMap map = new HashMap(strArr == null ? 1 : strArr.length);
        if (strArr == null) {
            al.c("not found extraMsg", new Object[0]);
            return map;
        }
        for (int i10 = 0; i10 < strArr.length; i10++) {
            String str = strArr[i10];
            if (str != null) {
                al.a("Extra message[%d]: %s", Integer.valueOf(i10), str);
                String[] strArrSplit = str.split("=");
                if (strArrSplit.length == 2) {
                    map.put(strArrSplit[0], strArrSplit[1]);
                } else {
                    al.d("bad extraMsg %s", str);
                }
            }
        }
        return map;
    }

    public bd(Context context, aa aaVar, as asVar, ac acVar) {
        this.f8931a = context;
        this.f8932b = asVar;
        this.f8933c = aaVar;
        this.f8934d = acVar;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final boolean getAndUpdateAnrState() {
        if (ay.a() == null) {
            return false;
        }
        ay ayVarA = ay.a();
        if (ayVarA.f8893a.get()) {
            al.c("anr is processing, return", new Object[0]);
            return false;
        }
        ActivityManager activityManager = ayVarA.f8894b;
        if (!z.a(activityManager) && az.a(activityManager, 0L) != null) {
            if (ayVarA.a(System.currentTimeMillis())) {
                return false;
            }
            return ayVarA.a(true);
        }
        al.c("proc is not in anr, wait next check", new Object[0]);
        return false;
    }
}
