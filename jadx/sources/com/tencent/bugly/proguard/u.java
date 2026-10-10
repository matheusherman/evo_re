package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f9141a = System.currentTimeMillis();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static u f9142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f9143c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SharedPreferences f9146f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<Integer, Map<String, t>> f9145e = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9144d = aa.b().f8667d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9147a = 1004;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f9148b;

        @Override // java.lang.Runnable
        public final void run() {
            t tVar;
            try {
                if (TextUtils.isEmpty(u.this.f9144d)) {
                    return;
                }
                List<t> listD = u.this.d(this.f9147a);
                if (listD == null) {
                    listD = new ArrayList();
                }
                if (u.this.f9145e.get(Integer.valueOf(this.f9147a)) == null) {
                    u.this.f9145e.put(Integer.valueOf(this.f9147a), new HashMap());
                }
                if (((Map) u.this.f9145e.get(Integer.valueOf(this.f9147a))).get(u.this.f9144d) == null) {
                    tVar = new t();
                    tVar.f9134a = this.f9147a;
                    tVar.f9140g = u.f9141a;
                    tVar.f9135b = u.this.f9144d;
                    tVar.f9139f = aa.b().f8678o;
                    tVar.f9138e = aa.b().f8671h;
                    tVar.f9136c = System.currentTimeMillis();
                    tVar.f9137d = this.f9148b;
                    ((Map) u.this.f9145e.get(Integer.valueOf(this.f9147a))).put(u.this.f9144d, tVar);
                } else {
                    tVar = (t) ((Map) u.this.f9145e.get(Integer.valueOf(this.f9147a))).get(u.this.f9144d);
                    tVar.f9137d = this.f9148b;
                }
                ArrayList arrayList = new ArrayList();
                boolean z10 = false;
                for (t tVar2 : listD) {
                    if (u.a(tVar2, tVar)) {
                        tVar2.f9137d = tVar.f9137d;
                        z10 = true;
                    }
                    if (u.b(tVar2, tVar)) {
                        arrayList.add(tVar2);
                    }
                }
                listD.removeAll(arrayList);
                if (!z10) {
                    listD.add(tVar);
                }
                u.this.a(this.f9147a, listD);
            } catch (Exception unused) {
                al.e("saveCrashRecord failed", new Object[0]);
            }
        }

        a(int i10) {
            this.f9148b = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9150a;

        b(int i10) {
            this.f9150a = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean zC = u.this.c(this.f9150a);
            u.this.f9146f.edit().putBoolean(this.f9150a + "_" + u.this.f9144d, !zC).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0042 A[Catch: all -> 0x0031, Exception -> 0x0057, PHI: r6
      0x0042: PHI (r6v10 java.io.ObjectInputStream) = (r6v9 java.io.ObjectInputStream), (r6v11 java.io.ObjectInputStream) binds: [B:21:0x0040, B:26:0x004e] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x0057, blocks: (B:4:0x0003, B:10:0x002c, B:29:0x0053, B:30:0x0056, B:22:0x0042), top: B:38:0x0003, outer: #0 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    public synchronized <T extends List<?>> T d(int i10) {
        ObjectInputStream objectInputStream;
        try {
            File file = new File(this.f9143c.getDir("crashrecord", 0), String.valueOf(i10));
            ?? Exists = file.exists();
            try {
                if (Exists == 0) {
                    return null;
                }
                try {
                    objectInputStream = new ObjectInputStream(new FileInputStream(file));
                    try {
                        T t10 = (T) objectInputStream.readObject();
                        objectInputStream.close();
                        return t10;
                    } catch (IOException unused) {
                        al.a("open record file error", new Object[0]);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    } catch (ClassNotFoundException unused2) {
                        al.a("get object error", new Object[0]);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    }
                } catch (IOException unused3) {
                    objectInputStream = null;
                } catch (ClassNotFoundException unused4) {
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    Exists = 0;
                    if (Exists != 0) {
                        Exists.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused5) {
            al.e("readCrashRecord error", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean c(int i10) {
        try {
            try {
                List<t> listD = d(i10);
                if (listD == null) {
                    return false;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (t tVar : listD) {
                    String str = tVar.f9135b;
                    if (str != null && str.equalsIgnoreCase(this.f9144d) && tVar.f9137d > 0) {
                        arrayList.add(tVar);
                    }
                    if (tVar.f9136c + 86400000 < jCurrentTimeMillis) {
                        arrayList2.add(tVar);
                    }
                }
                Collections.sort(arrayList);
                if (arrayList.size() < 2) {
                    listD.removeAll(arrayList2);
                    a(i10, listD);
                    return false;
                }
                if (arrayList.size() <= 0 || ((t) arrayList.get(arrayList.size() - 1)).f9136c + 86400000 >= jCurrentTimeMillis) {
                    return true;
                }
                listD.clear();
                a(i10, listD);
                return false;
            } catch (Exception unused) {
                al.e("isFrequentCrash failed", new Object[0]);
                return false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private u(Context context) {
        this.f9143c = context;
        this.f9146f = context.getSharedPreferences("crashrecord", 0);
    }

    public final synchronized boolean b(int i10) {
        boolean z10;
        z10 = true;
        try {
            z10 = this.f9146f.getBoolean(i10 + "_" + this.f9144d, true);
            ak.a().a(new b(i10));
        } catch (Exception unused) {
            al.e("canInit error", new Object[0]);
            return z10;
        }
        return z10;
    }

    public static synchronized u a(Context context) {
        try {
            if (f9142b == null) {
                f9142b = new u(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9142b;
    }

    public static synchronized u a() {
        return f9142b;
    }

    static /* synthetic */ boolean b(t tVar, t tVar2) {
        String str = tVar.f9138e;
        if (str != null && !str.equalsIgnoreCase(tVar2.f9138e)) {
            return true;
        }
        String str2 = tVar.f9139f;
        return !(str2 == null || str2.equalsIgnoreCase(tVar2.f9139f)) || tVar.f9137d <= 0;
    }

    public final void a(int i10) {
        ak.a().a(new a(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x004c A[Catch: all -> 0x002a, Exception -> 0x0050, TRY_ENTER, TryCatch #1 {Exception -> 0x0050, blocks: (B:7:0x0006, B:11:0x0025, B:32:0x004c, B:33:0x004f, B:26:0x0043), top: B:39:0x0006, outer: #3 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public synchronized <T extends List<?>> void a(int i10, T t10) {
        Throwable th;
        ObjectOutputStream objectOutputStream;
        IOException e10;
        if (t10 == null) {
            return;
        }
        try {
            ObjectOutputStream dir = this.f9143c.getDir("crashrecord", 0);
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File((File) dir, String.valueOf(i10))));
                    try {
                        objectOutputStream.writeObject(t10);
                        objectOutputStream.close();
                    } catch (IOException e11) {
                        e10 = e11;
                        e10.printStackTrace();
                        al.a("open record file error", new Object[0]);
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (dir != 0) {
                        dir.close();
                    }
                    throw th;
                }
            } catch (IOException e12) {
                objectOutputStream = null;
                e10 = e12;
            } catch (Throwable th3) {
                dir = 0;
                th = th3;
                if (dir != 0) {
                    dir.close();
                }
                throw th;
            }
        } catch (Exception unused) {
            al.e("writeCrashRecord error", new Object[0]);
        }
    }

    static /* synthetic */ boolean a(t tVar, t tVar2) {
        String str;
        return tVar.f9140g == tVar2.f9140g && (str = tVar.f9135b) != null && str.equalsIgnoreCase(tVar2.f9135b);
    }
}
