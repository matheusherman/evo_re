package com.google.android.gms.common.util;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f2476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f2477c;

    @Nullable
    public static String a() throws Throwable {
        BufferedReader bufferedReader;
        if (f2475a == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                f2475a = Application.getProcessName();
            } else {
                int iMyPid = f2476b;
                if (iMyPid == 0) {
                    iMyPid = Process.myPid();
                    f2476b = iMyPid;
                }
                String strTrim = null;
                strTrim = null;
                strTrim = null;
                BufferedReader bufferedReader2 = null;
                if (iMyPid > 0) {
                    try {
                        String str = "/proc/" + iMyPid + "/cmdline";
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            bufferedReader = new BufferedReader(new FileReader(str));
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            try {
                                String line = bufferedReader.readLine();
                                m1.g.k(line);
                                strTrim = line.trim();
                            } catch (IOException unused) {
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2 = bufferedReader;
                                j.a(bufferedReader2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            throw th2;
                        }
                    } catch (IOException unused2) {
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    j.a(bufferedReader);
                }
                f2475a = strTrim;
            }
        }
        return f2475a;
    }

    public static boolean b() {
        Boolean boolValueOf = f2477c;
        if (boolValueOf == null) {
            if (m.e()) {
                boolValueOf = Boolean.valueOf(Process.isIsolated());
            } else {
                try {
                    Object objA = y1.h.a(Process.class, "isIsolated", new y1.g[0]);
                    Object[] objArr = new Object[0];
                    if (objA == null) {
                        throw new y1.c(y1.b.a("expected a non-null reference", objArr));
                    }
                    boolValueOf = (Boolean) objA;
                } catch (ReflectiveOperationException unused) {
                    boolValueOf = Boolean.FALSE;
                }
            }
            f2477c = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }
}
