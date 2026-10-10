package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.collection.SimpleArrayMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class p7 {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile com.google.common.base.l<q7> f2945a;

        public static com.google.common.base.l<q7> a(Context context) {
            com.google.common.base.l<q7> lVar;
            com.google.common.base.l<q7> lVarB;
            com.google.common.base.l<q7> lVar2 = f2945a;
            if (lVar2 != null) {
                return lVar2;
            }
            synchronized (a.class) {
                try {
                    lVar = f2945a;
                    if (lVar == null) {
                        new p7();
                        if (t7.c(Build.TYPE, Build.TAGS)) {
                            if (a7.a() && !context.isDeviceProtectedStorage()) {
                                context = context.createDeviceProtectedStorageContext();
                            }
                            lVarB = p7.b(context);
                        } else {
                            lVarB = com.google.common.base.l.a();
                        }
                        lVar = lVarB;
                        f2945a = lVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return lVar;
        }

        private a() {
        }
    }

    private static q7 a(Context context, File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                HashMap map = new HashMap();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        Log.w("HermeticFileOverrides", "Parsed " + String.valueOf(file) + " for Android package " + context.getPackageName());
                        g7 g7Var = new g7(simpleArrayMap);
                        bufferedReader.close();
                        return g7Var;
                    }
                    String[] strArrSplit = line.split(" ", 3);
                    if (strArrSplit.length != 3) {
                        Log.e("HermeticFileOverrides", "Invalid: " + line);
                    } else {
                        String strC = c(strArrSplit[0]);
                        String strDecode = Uri.decode(c(strArrSplit[1]));
                        String strDecode2 = (String) map.get(strArrSplit[2]);
                        if (strDecode2 == null) {
                            String strC2 = c(strArrSplit[2]);
                            strDecode2 = Uri.decode(strC2);
                            if (strDecode2.length() < 1024 || strDecode2 == strC2) {
                                map.put(strC2, strDecode2);
                            }
                        }
                        SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(strC);
                        if (simpleArrayMap2 == null) {
                            simpleArrayMap2 = new SimpleArrayMap();
                            simpleArrayMap.put(strC, simpleArrayMap2);
                        }
                        simpleArrayMap2.put(strDecode, strDecode2);
                    }
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static final String c(String str) {
        return new String(str);
    }

    private static com.google.common.base.l<File> d(Context context) {
        try {
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? com.google.common.base.l.d(file) : com.google.common.base.l.a();
        } catch (RuntimeException e10) {
            Log.e("HermeticFileOverrides", "no data dir", e10);
            return com.google.common.base.l.a();
        }
    }

    @VisibleForTesting
    static com.google.common.base.l<q7> b(Context context) {
        com.google.common.base.l<q7> lVarA;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            com.google.common.base.l<File> lVarD = d(context);
            if (lVarD.c()) {
                lVarA = com.google.common.base.l.d(a(context, lVarD.b()));
            } else {
                lVarA = com.google.common.base.l.a();
            }
            return lVarA;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }
}
