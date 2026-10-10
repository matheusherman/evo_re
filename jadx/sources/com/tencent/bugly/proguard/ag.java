package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SimpleDateFormat f8706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ad f8707b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ag f8708a = new ag(0);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f8709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f8710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8711c;

        public final String toString() {
            return "SLAData{uuid='" + this.f8709a + "', time=" + this.f8710b + ", data='" + this.f8711c + "'}";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f8719a;

        d(List list) {
            this.f8719a = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ag.c(this.f8719a);
        }
    }

    /* synthetic */ ag(byte b10) {
        this();
    }

    static void c(List<b> list) {
        if (list == null || list.isEmpty()) {
            al.c("sla batch report data is empty", new Object[0]);
            return;
        }
        al.c("sla batch report list size:%s", Integer.valueOf(list.size()));
        if (list.size() > 30) {
            list = list.subList(0, 29);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f8711c);
        }
        Pair<Integer, String> pairA = ad.a(arrayList);
        al.c("sla batch report result, rspCode:%s rspMsg:%s", pairA.first, pairA.second);
        if (((Integer) pairA.first).intValue() == 200) {
            d(list);
        }
    }

    public static void d(List<b> list) {
        if (list == null || list.isEmpty()) {
            al.c("sla batch delete list is null", new Object[0]);
            return;
        }
        al.c("sla batch delete list size:%s", Integer.valueOf(list.size()));
        try {
            String str = "_id in (" + a(",", list) + ")";
            al.c("sla batch delete where:%s", str);
            w.a().a("t_sla", str);
        } catch (Throwable th) {
            al.b(th);
        }
    }

    public final void a(List<c> list) {
        if (list == null || list.isEmpty()) {
            al.d("sla batch report event is null", new Object[0]);
            return;
        }
        al.c("sla batch report event size:%s", Integer.valueOf(list.size()));
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            b bVarB = b(it.next());
            if (bVarB != null) {
                arrayList.add(bVarB);
            }
        }
        e(arrayList);
        b(arrayList);
    }

    public final void b(List<b> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ak.a().a(new d(list));
        } else {
            c(list);
        }
    }

    private ag() {
        this.f8706a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
        this.f8707b = new ad();
    }

    private static void e(List<b> list) {
        for (b bVar : list) {
            al.c("sla save id:%s time:%s msg:%s", bVar.f8709a, Long.valueOf(bVar.f8710b), bVar.f8711c);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", bVar.f8709a);
                contentValues.put("_tm", Long.valueOf(bVar.f8710b));
                contentValues.put("_dt", bVar.f8711c);
                w.a().a("t_sla", contentValues, (v) null);
            } catch (Throwable th) {
                al.b(th);
            }
        }
    }

    private b b(c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.f8713b)) {
            aa aaVarB = aa.b();
            if (aaVarB == null) {
                al.d("sla convert failed because ComInfoManager is null", new Object[0]);
                return null;
            }
            StringBuilder sb2 = new StringBuilder("&app_version=");
            sb2.append(aaVarB.f8678o);
            sb2.append("&app_name=");
            sb2.append(aaVarB.f8680q);
            sb2.append("&app_bundle_id=");
            sb2.append(aaVarB.f8666c);
            sb2.append("&client_type=android&user_id=");
            sb2.append(aaVarB.f());
            sb2.append("&sdk_version=");
            sb2.append(aaVarB.f8671h);
            sb2.append("&event_code=");
            sb2.append(cVar.f8713b);
            sb2.append("&event_result=");
            sb2.append(cVar.f8715d ? 1 : 0);
            sb2.append("&event_time=");
            sb2.append(this.f8706a.format(new Date(cVar.f8714c)));
            sb2.append("&event_cost=");
            sb2.append(cVar.f8716e);
            sb2.append("&device_id=");
            sb2.append(aaVarB.g());
            sb2.append("&debug=");
            sb2.append(aaVarB.D ? 1 : 0);
            sb2.append("&param_0=");
            sb2.append(cVar.f8717f);
            sb2.append("&param_1=");
            sb2.append(cVar.f8712a);
            sb2.append("&param_2=");
            sb2.append(aaVarB.M ? "rqd" : "ext");
            sb2.append("&param_4=");
            sb2.append(aaVarB.e());
            String string = sb2.toString();
            if (!TextUtils.isEmpty(cVar.f8718g)) {
                string = string + "&param_3=" + cVar.f8718g;
            }
            al.c("sla convert eventId:%s eventType:%s, eventTime:%s success:%s cost:%s from:%s uploadMsg:", cVar.f8712a, cVar.f8713b, Long.valueOf(cVar.f8714c), Boolean.valueOf(cVar.f8715d), Long.valueOf(cVar.f8716e), cVar.f8717f, cVar.f8718g);
            String str = cVar.f8712a + "-" + cVar.f8713b;
            b bVar = new b();
            bVar.f8709a = str;
            bVar.f8710b = cVar.f8714c;
            bVar.f8711c = string;
            return bVar;
        }
        al.d("sla convert event is null", new Object[0]);
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f8712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f8713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f8714c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f8715d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f8716e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f8717f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        String f8718g;

        public c(String str, String str2, long j10, boolean z10, long j11, String str3, String str4) {
            this.f8712a = str;
            this.f8713b = str2;
            this.f8714c = j10;
            this.f8715d = z10;
            this.f8716e = j11;
            this.f8717f = str3;
            this.f8718g = str4;
        }

        public c() {
        }
    }

    private static String a(String str, Iterable<b> iterable) {
        Iterator<b> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("'");
        sb2.append(it.next().f8709a);
        sb2.append("'");
        while (it.hasNext()) {
            sb2.append(str);
            sb2.append("'");
            sb2.append(it.next().f8709a);
            sb2.append("'");
        }
        return sb2.toString();
    }

    public static List<b> a() {
        Cursor cursorA = w.a().a("t_sla", new String[]{"_id", "_tm", "_dt"}, (String) null, "_tm", "30");
        if (cursorA == null) {
            return null;
        }
        if (cursorA.getCount() <= 0) {
            cursorA.close();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursorA.moveToNext()) {
            try {
                b bVar = new b();
                bVar.f8709a = cursorA.getString(cursorA.getColumnIndex("_id"));
                bVar.f8710b = cursorA.getLong(cursorA.getColumnIndex("_tm"));
                bVar.f8711c = cursorA.getString(cursorA.getColumnIndex("_dt"));
                al.c(bVar.toString(), new Object[0]);
                arrayList.add(bVar);
            } catch (Throwable th) {
                try {
                    al.b(th);
                    return arrayList;
                } finally {
                    cursorA.close();
                }
            }
        }
        cursorA.close();
        return arrayList;
    }

    public final void a(c cVar) {
        if (TextUtils.isEmpty(cVar.f8713b)) {
            al.d("sla report event is null", new Object[0]);
        } else {
            al.c("sla report single event", new Object[0]);
            a(Collections.singletonList(cVar));
        }
    }
}
