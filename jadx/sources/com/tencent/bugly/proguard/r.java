package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.core.view.PointerIconCompat;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f9104e = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f9108d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class a implements ah {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f9109a;

        a(List list) {
            this.f9109a = list;
        }

        @Override // com.tencent.bugly.proguard.ah
        public final void a(boolean z10, String str) {
            if (z10) {
                al.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (UserInfoBean userInfoBean : this.f9109a) {
                    userInfoBean.f8560f = jCurrentTimeMillis;
                    r.this.a(userInfoBean, true);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f9111a = false;

        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                r.this.a(this.f9111a);
            } catch (Throwable th) {
                al.a(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private UserInfoBean f9114b;

        public c(UserInfoBean userInfoBean, boolean z10) {
            this.f9114b = userInfoBean;
            this.f9113a = z10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (r.this.f9108d) {
                try {
                    UserInfoBean userInfoBean = this.f9114b;
                    if (userInfoBean != null) {
                        r.a(userInfoBean);
                        al.c("[UserInfo] Record user info.", new Object[0]);
                        r.this.a(this.f9114b, false);
                    }
                    if (this.f9113a) {
                        r.this.b();
                    }
                } catch (Throwable th) {
                    if (al.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis < r.this.f9106b) {
                ak.a().a(r.this.new d(), (r.this.f9106b - jCurrentTimeMillis) + CoroutineLiveDataKt.DEFAULT_TIMEOUT);
            } else {
                r.this.a(3, false);
                r.this.a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f9117a;

        public e(long j10) {
            this.f9117a = j10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            r.this.b();
            r.this.a(this.f9117a);
        }
    }

    private static void b(List<UserInfoBean> list, List<UserInfoBean> list2) {
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            UserInfoBean next = it.next();
            if (next.f8560f != -1) {
                it.remove();
                if (next.f8559e < ap.b()) {
                    list2.add(next);
                }
            }
        }
    }

    public r(Context context, boolean z10) {
        this.f9105a = context;
        this.f9108d = z10;
    }

    public final void a(int i10, boolean z10) {
        ac acVarA = ac.a();
        if (acVarA != null && !acVarA.c().f8583g && i10 != 1 && i10 != 3) {
            al.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i10 == 1 || i10 == 3) {
            this.f9107c++;
        }
        aa aaVarA = aa.a(this.f9105a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f8556b = i10;
        userInfoBean.f8557c = aaVarA.f8667d;
        userInfoBean.f8558d = aaVarA.f();
        userInfoBean.f8559e = System.currentTimeMillis();
        userInfoBean.f8560f = -1L;
        userInfoBean.f8568n = aaVarA.f8678o;
        userInfoBean.f8569o = i10 == 1 ? 1 : 0;
        userInfoBean.f8566l = aaVarA.a();
        userInfoBean.f8567m = aaVarA.f8688y;
        userInfoBean.f8561g = aaVarA.f8689z;
        userInfoBean.f8562h = aaVarA.A;
        userInfoBean.f8563i = aaVarA.B;
        userInfoBean.f8565k = aaVarA.C;
        userInfoBean.f8572r = aaVarA.t();
        userInfoBean.f8573s = aaVarA.y();
        userInfoBean.f8570p = aaVarA.z();
        userInfoBean.f8571q = aaVarA.f8687x;
        ak.a().a(new c(userInfoBean, z10), 0L);
    }

    public final void b() {
        ak akVarA = ak.a();
        if (akVarA != null) {
            akVarA.a(new b());
        }
    }

    private static void b(List<UserInfoBean> list) {
        if (list.size() == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < list.size() && i10 < 50; i10++) {
            UserInfoBean userInfoBean = list.get(i10);
            sb2.append(" or _id = ");
            sb2.append(userInfoBean.f8555a);
        }
        String string = sb2.toString();
        if (string.length() > 0) {
            string = string.substring(4);
        }
        sb2.setLength(0);
        try {
            al.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(w.a().a("t_ui", string)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static ContentValues b(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = userInfoBean.f8555a;
            if (j10 > 0) {
                contentValues.put("_id", Long.valueOf(j10));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f8559e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f8560f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.f8556b));
            contentValues.put("_pc", userInfoBean.f8557c);
            contentValues.put("_dt", ap.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final void a(long j10) {
        ak.a().a(new e(j10), j10);
    }

    public final void a() {
        this.f9106b = ap.b() + 86400000;
        ak.a().a(new d(), (this.f9106b - System.currentTimeMillis()) + CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0074 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r1
      0x0074: PHI (r1v2 boolean) = (r1v0 boolean), (r1v3 boolean) binds: [B:25:0x006a, B:36:0x0087] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    private boolean b(boolean z10) {
        boolean z11 = true;
        if (!f9104e) {
            return true;
        }
        File file = new File(this.f9105a.getFilesDir(), "bugly_last_us_up_tm");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z10) {
            am.a(file, String.valueOf(jCurrentTimeMillis), 1024L, false);
            return true;
        }
        if (!file.exists()) {
            am.a(file, String.valueOf(jCurrentTimeMillis), 1024L, false);
        } else {
            BufferedReader bufferedReaderA = ap.a(file);
            if (bufferedReaderA != null) {
                try {
                    long jLongValue = Long.valueOf(bufferedReaderA.readLine().trim()).longValue();
                    if (jCurrentTimeMillis < jLongValue || jCurrentTimeMillis - jLongValue > 86400000 || jCurrentTimeMillis - jLongValue >= 300000) {
                        am.a(file, String.valueOf(jCurrentTimeMillis), 1024L, false);
                    } else {
                        z11 = false;
                    }
                    if (bufferedReaderA != null) {
                    }
                } catch (Throwable th) {
                    try {
                        al.b(th);
                        am.a(file, String.valueOf(jCurrentTimeMillis), 1024L, false);
                    } finally {
                        try {
                            bufferedReaderA.close();
                        } catch (Exception e10) {
                            al.a(e10);
                        }
                    }
                }
            } else if (bufferedReaderA != null) {
            }
        }
        return z11;
    }

    private static void a(List<UserInfoBean> list, List<UserInfoBean> list2) {
        int size = list.size() - 20;
        if (size > 0) {
            int i10 = 0;
            while (i10 < list.size() - 1) {
                int i11 = i10 + 1;
                for (int i12 = i11; i12 < list.size(); i12++) {
                    if (list.get(i10).f8559e > list.get(i12).f8559e) {
                        UserInfoBean userInfoBean = list.get(i10);
                        list.set(i10, list.get(i12));
                        list.set(i12, userInfoBean);
                    }
                }
                i10 = i11;
            }
            for (int i13 = 0; i13 < size; i13++) {
                list2.add(list.get(i13));
            }
        }
    }

    private static int a(List<UserInfoBean> list) {
        int i10;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i11 = 0;
        for (UserInfoBean userInfoBean : list) {
            if (userInfoBean.f8559e > jCurrentTimeMillis - 600000 && ((i10 = userInfoBean.f8556b) == 1 || i10 == 4 || i10 == 3)) {
                i11++;
            }
        }
        return i11;
    }

    private void a(List<UserInfoBean> list, boolean z10) {
        aa aaVarB;
        if (!b(z10)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : list) {
                userInfoBean.f8560f = jCurrentTimeMillis;
                a(userInfoBean, true);
            }
            al.d("uploadCheck failed", new Object[0]);
            return;
        }
        int i10 = this.f9107c == 1 ? 1 : 2;
        bv bvVar = null;
        if (list != null && list.size() != 0 && (aaVarB = aa.b()) != null) {
            aaVarB.o();
            bv bvVar2 = new bv();
            bvVar2.f9057b = aaVarB.f8667d;
            bvVar2.f9058c = aaVarB.g();
            ArrayList<bu> arrayList = new ArrayList<>();
            Iterator<UserInfoBean> it = list.iterator();
            while (it.hasNext()) {
                bu buVarA = ae.a(it.next());
                if (buVarA != null) {
                    arrayList.add(buVarA);
                }
            }
            bvVar2.f9059d = arrayList;
            HashMap map = new HashMap();
            bvVar2.f9060e = map;
            map.put("A7", new StringBuilder().toString());
            bvVar2.f9060e.put("A6", aa.n());
            bvVar2.f9060e.put("A5", aaVarB.m());
            Map<String, String> map2 = bvVar2.f9060e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(aaVarB.k());
            map2.put("A2", sb2.toString());
            Map<String, String> map3 = bvVar2.f9060e;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(aaVarB.k());
            map3.put("A1", sb3.toString());
            bvVar2.f9060e.put("A24", aaVarB.f8674k);
            Map<String, String> map4 = bvVar2.f9060e;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(aaVarB.l());
            map4.put("A17", sb4.toString());
            bvVar2.f9060e.put("A15", aaVarB.q());
            Map<String, String> map5 = bvVar2.f9060e;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(aaVarB.r());
            map5.put("A13", sb5.toString());
            bvVar2.f9060e.put("F08", aaVarB.E);
            bvVar2.f9060e.put("F09", aaVarB.F);
            Map<String, String> mapY = aaVarB.y();
            if (mapY != null && mapY.size() > 0) {
                for (Map.Entry<String, String> entry : mapY.entrySet()) {
                    bvVar2.f9060e.put("C04_" + entry.getKey(), entry.getValue());
                }
            }
            if (i10 == 1) {
                bvVar2.f9056a = (byte) 1;
            } else if (i10 != 2) {
                al.e("unknown up type %d ", Integer.valueOf(i10));
            } else {
                bvVar2.f9056a = (byte) 2;
            }
            bvVar = bvVar2;
        }
        if (bvVar == null) {
            al.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
            return;
        }
        byte[] bArrA = ae.a((m) bvVar);
        if (bArrA == null) {
            al.d("[UserInfo] Failed to encode data.", new Object[0]);
            return;
        }
        bq bqVarA = ae.a(this.f9105a, 840, bArrA);
        if (bqVarA == null) {
            al.d("[UserInfo] Request package is null.", new Object[0]);
            return;
        }
        ai.a().a(PointerIconCompat.TYPE_CONTEXT_MENU, bqVarA, ac.a().c().f8593q, StrategyBean.f8577a, new a(list), this.f9107c == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserInfoBean userInfoBean, boolean z10) {
        List<UserInfoBean> listA;
        if (userInfoBean == null) {
            return;
        }
        if (!z10 && userInfoBean.f8556b != 1 && (listA = a(aa.a(this.f9105a).f8667d)) != null && listA.size() >= 20) {
            al.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(listA.size()));
            return;
        }
        long jA = w.a().a("t_ui", b(userInfoBean), (v) null);
        if (jA >= 0) {
            al.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(jA));
            userInfoBean.f8555a = jA;
        }
    }

    public static List<UserInfoBean> a(String str) {
        Cursor cursorA;
        String str2;
        try {
            if (ap.b(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursorA = w.a().a("t_ui", (String[]) null, str2);
            if (cursorA == null) {
                if (cursorA != null) {
                    cursorA.close();
                }
                return null;
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursorA.moveToNext()) {
                    UserInfoBean userInfoBeanA = a(cursorA);
                    if (userInfoBeanA != null) {
                        arrayList.add(userInfoBeanA);
                    } else {
                        try {
                            long j10 = cursorA.getLong(cursorA.getColumnIndex("_id"));
                            sb2.append(" or _id = ");
                            sb2.append(j10);
                        } catch (Throwable unused) {
                            al.d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String string = sb2.toString();
                if (string.length() > 0) {
                    al.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(w.a().a("t_ui", string.substring(4))));
                }
                cursorA.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    return null;
                } finally {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorA = null;
        }
    }

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j10 = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) ap.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean == null) {
                return userInfoBean;
            }
            userInfoBean.f8555a = j10;
            return userInfoBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x0064 A[Catch: all -> 0x0024, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0006, B:9:0x000d, B:12:0x0014, B:14:0x001a, B:20:0x0026, B:22:0x003b, B:24:0x0049, B:27:0x005e, B:29:0x0064, B:31:0x0069, B:34:0x0070, B:37:0x0086, B:25:0x0058), top: B:42:0x0001 }] */
    public synchronized void a(boolean z10) {
        ai aiVarA;
        ac acVarA;
        boolean z11;
        if (this.f9108d && (aiVarA = ai.a()) != null && (acVarA = ac.a()) != null && (!acVarA.b() || aiVarA.b(PointerIconCompat.TYPE_CONTEXT_MENU))) {
            String str = aa.a(this.f9105a).f8667d;
            ArrayList arrayList = new ArrayList();
            List<UserInfoBean> listA = a(str);
            if (listA != null) {
                a(listA, arrayList);
                b(listA, arrayList);
                int iA = a(listA);
                if (iA > 15) {
                    al.d("[UserInfo] Upload user info too many times in 10 min: %d", Integer.valueOf(iA));
                    z11 = false;
                }
                if (arrayList.size() > 0) {
                    b(arrayList);
                }
                if (z11 && listA.size() != 0) {
                    al.c("[UserInfo] Upload user info(size: %d)", Integer.valueOf(listA.size()));
                    a(listA, z10);
                    return;
                }
                al.c("[UserInfo] There is no user info in local database.", new Object[0]);
            }
            listA = new ArrayList<>();
            z11 = true;
            if (arrayList.size() > 0) {
                b(arrayList);
            }
            if (z11) {
                al.c("[UserInfo] Upload user info(size: %d)", Integer.valueOf(listA.size()));
                a(listA, z10);
                return;
            }
            al.c("[UserInfo] There is no user info in local database.", new Object[0]);
        }
    }

    static /* synthetic */ void a(UserInfoBean userInfoBean) {
        aa aaVarB;
        if (userInfoBean == null || (aaVarB = aa.b()) == null) {
            return;
        }
        userInfoBean.f8564j = aaVarB.d();
    }
}
