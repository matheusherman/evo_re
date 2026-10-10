package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f8809a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Map<Integer, Pair<String, String>> f8810h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ArrayList<g> f8811i = new b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<Integer, Integer> f8812j = new c();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Map<Integer, String> f8813k = new d();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Map<Integer, String> f8814l = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f8815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final ai f8816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final w f8817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final ac f8818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected aw f8819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected BuglyStrategy.a f8820g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class f implements ah {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f8821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f8822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f8823c;

        f(long j10, List list, boolean z10) {
            this.f8821a = j10;
            this.f8822b = list;
            this.f8823c = z10;
        }

        @Override // com.tencent.bugly.proguard.ah
        public final void a(boolean z10, String str) {
            String str2;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f8821a;
            List list = this.f8822b;
            if (this.f8823c) {
                str2 = "realtime";
            } else {
                str2 = "cache";
            }
            as.a(list, z10, jCurrentTimeMillis, str2, str);
            as.a(z10, (List<CrashDetailBean>) this.f8822b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static abstract class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f8825a;

        /* synthetic */ g(int i10, byte b10) {
            this(i10);
        }

        abstract boolean a();

        private g(int i10) {
            this.f8825a = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class h extends g {
        /* synthetic */ h(byte b10) {
            this();
        }

        private h() {
            super(3, (byte) 0);
        }

        @Override // com.tencent.bugly.proguard.as.g
        final boolean a() {
            return at.a().k();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class i extends g {
        /* synthetic */ i(byte b10) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.g
        final boolean a() {
            return true;
        }

        private i() {
            super(7, (byte) 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class j extends g {
        /* synthetic */ j(byte b10) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.g
        final boolean a() {
            return true;
        }

        private j() {
            super(2, (byte) 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class k extends g {
        /* synthetic */ k(byte b10) {
            this();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private k() {
            byte b10 = 0;
            super(b10, b10);
        }

        @Override // com.tencent.bugly.proguard.as.g
        final boolean a() {
            return at.a().j();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class l extends g {
        /* synthetic */ l(byte b10) {
            this();
        }

        private l() {
            super(5, (byte) 0);
        }

        @Override // com.tencent.bugly.proguard.as.g
        final boolean a() {
            if ((at.a().B & 2) > 0) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class m extends g {
        /* synthetic */ m(byte b10) {
            this();
        }

        private m() {
            super(6, (byte) 0);
        }

        @Override // com.tencent.bugly.proguard.as.g
        final boolean a() {
            if ((at.a().B & 1) > 0) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class n extends g {
        /* synthetic */ n(byte b10) {
            this();
        }

        private n() {
            super(1, (byte) 0);
        }

        @Override // com.tencent.bugly.proguard.as.g
        final boolean a() {
            return at.a().j();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class o extends g {
        /* synthetic */ o(byte b10) {
            this();
        }

        private o() {
            super(4, (byte) 0);
        }

        @Override // com.tencent.bugly.proguard.as.g
        final boolean a() {
            if ((at.a().B & 4) > 0) {
                return true;
            }
            return false;
        }
    }

    private static List<ar> a(List<ar> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (ar arVar : list) {
            if (arVar.f8806d && arVar.f8804b <= jCurrentTimeMillis - 86400000) {
                arrayList.add(arVar);
            }
        }
        return arrayList;
    }

    private static void b(CrashDetailBean crashDetailBean, List<ar> list) {
        StringBuilder sb2 = new StringBuilder(64);
        for (ar arVar : list) {
            if (!arVar.f8807e && !arVar.f8806d) {
                String str = crashDetailBean.f8619s;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(arVar.f8804b);
                if (!str.contains(sb3.toString())) {
                    crashDetailBean.f8620t++;
                    sb2.append(arVar.f8804b);
                    sb2.append("\n");
                }
            }
        }
        crashDetailBean.f8619s += sb2.toString();
    }

    private static ContentValues c(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = crashDetailBean.f8600a;
            if (j10 > 0) {
                contentValues.put("_id", Long.valueOf(j10));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f8618r));
            contentValues.put("_s1", crashDetailBean.f8621u);
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f8604d ? 1 : 0));
            contentValues.put("_me", Integer.valueOf(crashDetailBean.f8610j ? 1 : 0));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f8612l));
            contentValues.put("_dt", ap.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static void d(List<ar> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id in (");
        Iterator<ar> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().f8803a);
            sb2.append(",");
        }
        StringBuilder sb3 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
        sb3.append(")");
        String string = sb3.toString();
        sb3.setLength(0);
        try {
            al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", string)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void e(List<CrashDetailBean> list) {
        try {
            if (list.size() == 0) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            for (CrashDetailBean crashDetailBean : list) {
                sb2.append(" or _id = ");
                sb2.append(crashDetailBean.f8600a);
            }
            String string = sb2.toString();
            if (string.length() > 0) {
                string = string.substring(4);
            }
            sb2.setLength(0);
            al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", string)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends HashMap<Integer, Pair<String, String>> {
        a() {
            put(3, new Pair("203", "103"));
            put(7, new Pair("208", "108"));
            put(0, new Pair("200", "100"));
            put(1, new Pair("201", "101"));
            put(2, new Pair("202", "102"));
            put(4, new Pair("204", "104"));
            put(6, new Pair("206", "106"));
            put(5, new Pair("207", "107"));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b extends ArrayList<g> {
        b() {
            byte b10 = 0;
            add(new h(b10));
            add(new i(b10));
            add(new j(b10));
            add(new k(b10));
            add(new n(b10));
            add(new o(b10));
            add(new l(b10));
            add(new m(b10));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class c extends HashMap<Integer, Integer> {
        c() {
            put(3, 4);
            put(7, 7);
            put(2, 1);
            put(0, 0);
            put(1, 2);
            put(4, 3);
            put(5, 5);
            put(6, 6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class d extends HashMap<Integer, String> {
        d() {
            put(3, "BuglyAnrCrash");
            put(0, "BuglyJavaCrash");
            put(1, "BuglyNativeCrash");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class e extends HashMap<Integer, String> {
        e() {
            put(3, "BuglyAnrCrashReport");
            put(0, "BuglyJavaCrashReport");
            put(1, "BuglyNativeCrashReport");
        }
    }

    public as(Context context, ai aiVar, w wVar, ac acVar, BuglyStrategy.a aVar) {
        f8809a = 1004;
        this.f8815b = context;
        this.f8816c = aiVar;
        this.f8817d = wVar;
        this.f8818e = acVar;
        this.f8820g = aVar;
        this.f8819f = null;
    }

    private static void b(List<ar> list) {
        List<CrashDetailBean> listC = c(list);
        if (listC == null || listC.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CrashDetailBean crashDetailBean : listC) {
            String str = f8814l.get(Integer.valueOf(crashDetailBean.f8602b));
            if (!TextUtils.isEmpty(str)) {
                al.c("find expired data,crashId:%s eventType:%s", crashDetailBean.f8603c, str);
                arrayList.add(new ag.c(crashDetailBean.f8603c, str, crashDetailBean.f8618r, false, 0L, "expired", null));
            }
        }
        ag.a.f8708a.a(arrayList);
    }

    private static CrashDetailBean a(List<ar> list, CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2;
        List<CrashDetailBean> listC;
        if (list.isEmpty()) {
            return crashDetailBean;
        }
        ArrayList arrayList = new ArrayList(10);
        for (ar arVar : list) {
            if (arVar.f8807e) {
                arrayList.add(arVar);
            }
        }
        if (arrayList.isEmpty() || (listC = c(arrayList)) == null || listC.isEmpty()) {
            crashDetailBean2 = null;
        } else {
            Collections.sort(listC);
            crashDetailBean2 = listC.get(0);
            a(crashDetailBean2, listC);
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f8610j = true;
            crashDetailBean.f8620t = 0;
            crashDetailBean.f8619s = "";
            crashDetailBean2 = crashDetailBean;
        }
        b(crashDetailBean2, list);
        if (crashDetailBean2.f8618r != crashDetailBean.f8618r) {
            String str = crashDetailBean2.f8619s;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.f8618r);
            if (!str.contains(sb2.toString())) {
                crashDetailBean2.f8620t++;
                crashDetailBean2.f8619s += crashDetailBean.f8618r + "\n";
            }
        }
        return crashDetailBean2;
    }

    private static List<CrashDetailBean> c(List<ar> list) {
        Cursor cursorA;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id in (");
        Iterator<ar> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().f8803a);
            sb2.append(",");
        }
        if (sb2.toString().contains(",")) {
            sb2 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
        }
        sb2.append(")");
        String string = sb2.toString();
        sb2.setLength(0);
        try {
            cursorA = w.a().a("t_cr", (String[]) null, string);
            if (cursorA == null) {
                if (cursorA != null) {
                    cursorA.close();
                }
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb2.append("_id in (");
                int i10 = 0;
                while (cursorA.moveToNext()) {
                    CrashDetailBean crashDetailBeanA = a(cursorA);
                    if (crashDetailBeanA != null) {
                        arrayList.add(crashDetailBeanA);
                    } else {
                        try {
                            sb2.append(cursorA.getLong(cursorA.getColumnIndex("_id")));
                            sb2.append(",");
                            i10++;
                        } catch (Throwable unused) {
                            al.d("unknown id!", new Object[0]);
                        }
                    }
                }
                if (sb2.toString().contains(",")) {
                    sb2 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
                }
                sb2.append(")");
                String string2 = sb2.toString();
                if (i10 > 0) {
                    al.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", string2)));
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

    private static String e(CrashDetailBean crashDetailBean) {
        try {
            Pair<String, String> pair = f8810h.get(Integer.valueOf(crashDetailBean.f8602b));
            if (pair == null) {
                al.e("crash type error! %d", Integer.valueOf(crashDetailBean.f8602b));
                return "";
            }
            if (crashDetailBean.f8610j) {
                return (String) pair.first;
            }
            return (String) pair.second;
        } catch (Exception e10) {
            al.a(e10);
            return "";
        }
    }

    private boolean d(CrashDetailBean crashDetailBean) {
        String absolutePath;
        try {
            al.c("save eup logs", new Object[0]);
            aa aaVarB = aa.b();
            String str = "#--------\npackage:" + aaVarB.e() + "\nversion:" + aaVarB.f8678o + "\nsdk:" + aaVarB.f8671h + "\nprocess:" + crashDetailBean.A + "\ndate:" + ap.a(new Date(crashDetailBean.f8618r)) + "\ntype:" + crashDetailBean.f8614n + "\nmessage:" + crashDetailBean.f8615o + "\nstack:\n" + crashDetailBean.f8617q + "\neupID:" + crashDetailBean.f8603c + "\n";
            if (at.f8837m == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/" + this.f8815b.getPackageName();
                } else {
                    absolutePath = null;
                }
            } else {
                File file = new File(at.f8837m);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                absolutePath = file.getAbsolutePath();
            }
            am.a(absolutePath + "/euplog.txt", str, at.f8838n);
            return true;
        } catch (Throwable th) {
            al.d("rqdp{  save error} %s", th.toString());
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final void b(CrashDetailBean crashDetailBean, boolean z10) {
        if (at.f8839o) {
            al.a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, 3000L, z10, crashDetailBean.f8602b == 7, z10);
            return;
        }
        al.a("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
    }

    public final void b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues contentValuesC = c(crashDetailBean);
        if (contentValuesC != null) {
            long jA = w.a().a("t_cr", contentValuesC, (v) null);
            if (jA >= 0) {
                al.c("insert %s success!", "t_cr");
                crashDetailBean.f8600a = jA;
            }
        }
        if (at.f8836l) {
            d(crashDetailBean);
        }
    }

    private static void a(CrashDetailBean crashDetailBean, List<CrashDetailBean> list) {
        String[] strArrSplit;
        StringBuilder sb2 = new StringBuilder(128);
        for (int i10 = 1; i10 < list.size(); i10++) {
            String str = list.get(i10).f8619s;
            if (str != null && (strArrSplit = str.split("\n")) != null) {
                for (String str2 : strArrSplit) {
                    if (!crashDetailBean.f8619s.contains(str2)) {
                        crashDetailBean.f8620t++;
                        sb2.append(str2);
                        sb2.append("\n");
                    }
                }
            }
        }
        crashDetailBean.f8619s += sb2.toString();
    }

    private static ar b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ar arVar = new ar();
            arVar.f8803a = cursor.getLong(cursor.getColumnIndex("_id"));
            arVar.f8804b = cursor.getLong(cursor.getColumnIndex("_tm"));
            arVar.f8805c = cursor.getString(cursor.getColumnIndex("_s1"));
            arVar.f8806d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            arVar.f8807e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            arVar.f8808f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return arVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:67:0x019b  */
    public final boolean a(CrashDetailBean crashDetailBean, boolean z10) {
        boolean z11;
        boolean zA;
        Map<String, String> mapOnCrashHandleStart;
        if (crashDetailBean == null) {
            al.d("CrashBean is null, won't handle.", new Object[0]);
            return true;
        }
        b(crashDetailBean);
        if (z10 && (this.f8820g != null || this.f8819f != null)) {
            Iterator<g> it = f8811i.iterator();
            while (true) {
                if (!it.hasNext()) {
                    zA = false;
                    break;
                }
                g next = it.next();
                if (next.f8825a == crashDetailBean.f8602b) {
                    zA = next.a();
                    break;
                }
            }
            if (!zA) {
                al.c("Should not call back.", new Object[0]);
            } else {
                try {
                    Map<Integer, Integer> map = f8812j;
                    if (!map.containsKey(Integer.valueOf(crashDetailBean.f8602b))) {
                        al.d("Cannot get crash type for crashBean type:" + crashDetailBean.f8602b, new Object[0]);
                    } else {
                        int iIntValue = map.get(Integer.valueOf(crashDetailBean.f8602b)).intValue();
                        byte[] bArrOnCrashHandleStart2GetExtraDatas = null;
                        if (this.f8819f != null) {
                            al.c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
                            al.c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
                            String strB = this.f8819f.b();
                            if (strB != null) {
                                mapOnCrashHandleStart = new HashMap<>(1);
                                mapOnCrashHandleStart.put("userData", strB);
                            } else {
                                mapOnCrashHandleStart = null;
                            }
                        } else if (this.f8820g != null) {
                            al.c("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
                            mapOnCrashHandleStart = this.f8820g.onCrashHandleStart(iIntValue, crashDetailBean.f8614n, crashDetailBean.f8615o, crashDetailBean.f8617q);
                        } else {
                            mapOnCrashHandleStart = null;
                        }
                        a(crashDetailBean, mapOnCrashHandleStart);
                        al.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                        if (this.f8819f != null) {
                            al.c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
                            bArrOnCrashHandleStart2GetExtraDatas = this.f8819f.a();
                        } else if (this.f8820g != null) {
                            al.c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
                            bArrOnCrashHandleStart2GetExtraDatas = this.f8820g.onCrashHandleStart2GetExtraDatas(iIntValue, crashDetailBean.f8614n, crashDetailBean.f8615o, crashDetailBean.f8617q);
                        }
                        if (bArrOnCrashHandleStart2GetExtraDatas == null) {
                            al.d("extra user byte is null. CrashBean won't have userExtraByteDatas.", new Object[0]);
                        } else {
                            if (bArrOnCrashHandleStart2GetExtraDatas.length <= 100000) {
                                crashDetailBean.Y = bArrOnCrashHandleStart2GetExtraDatas;
                            } else {
                                al.d("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(bArrOnCrashHandleStart2GetExtraDatas.length), Integer.valueOf(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH));
                                crashDetailBean.Y = Arrays.copyOf(bArrOnCrashHandleStart2GetExtraDatas, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                            }
                            al.a("add extra bytes %d ", Integer.valueOf(bArrOnCrashHandleStart2GetExtraDatas.length));
                        }
                        if (this.f8819f != null) {
                            al.c("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
                            if (!this.f8819f.c()) {
                                al.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
                            }
                        }
                    }
                } catch (Throwable th) {
                    al.d("crash handle callback something wrong! %s", th.getClass().getName());
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (!ab.r()) {
            crashDetailBean.f8623w = ap.a(at.f8830f, at.f8835k);
        }
        String str = crashDetailBean.f8617q;
        String str2 = at.f8841q;
        if (str2 == null || str2.isEmpty()) {
            z11 = false;
        } else {
            al.c("Crash filter for crash stack is: %s", at.f8841q);
            if (str.contains(at.f8841q)) {
                al.d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                z11 = true;
            } else {
                z11 = false;
            }
        }
        if (z11 || a(crashDetailBean.f8617q)) {
            return true;
        }
        if (crashDetailBean.f8602b != 2) {
            y yVar = new y();
            yVar.f9178b = 1;
            yVar.f9179c = crashDetailBean.A;
            yVar.f9180d = crashDetailBean.B;
            yVar.f9181e = crashDetailBean.f8618r;
            w.a().b(1);
            w.a().a(yVar);
            al.b("[crash] a crash occur, handling...", new Object[0]);
        } else {
            al.b("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<ar> listB = b();
        List<ar> arrayList = new ArrayList<>(10);
        if (listB != null && listB.size() > 0) {
            arrayList.addAll(a(listB));
            listB.removeAll(arrayList);
            if (listB.size() > 20) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("_id in (");
                sb2.append("SELECT _id FROM t_cr order by _id limit 5");
                sb2.append(")");
                String string = sb2.toString();
                sb2.setLength(0);
                try {
                    al.c("deleted first record %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", string)));
                } catch (Throwable th2) {
                    if (!al.a(th2)) {
                        th2.printStackTrace();
                    }
                }
            }
            if (b(crashDetailBean, listB, arrayList)) {
                return true;
            }
        }
        b(crashDetailBean);
        String str3 = f8813k.get(Integer.valueOf(crashDetailBean.f8602b));
        if (!TextUtils.isEmpty(str3)) {
            ag.a.f8708a.a(new ag.c(crashDetailBean.f8603c, str3, crashDetailBean.f8618r, true, 0L, "realtime", null));
        }
        d(arrayList);
        al.b("[crash] save crash success", new Object[0]);
        return false;
    }

    private static List<ar> b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor cursorA = w.a().a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, (String) null);
            if (cursorA == null) {
                if (cursorA != null) {
                    cursorA.close();
                }
                return null;
            }
            try {
                if (cursorA.getCount() <= 0) {
                    cursorA.close();
                    return arrayList;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("_id in (");
                int i10 = 0;
                while (cursorA.moveToNext()) {
                    ar arVarB = b(cursorA);
                    if (arVarB != null) {
                        arrayList.add(arVarB);
                    } else {
                        try {
                            sb2.append(cursorA.getLong(cursorA.getColumnIndex("_id")));
                            sb2.append(",");
                            i10++;
                        } catch (Throwable unused) {
                            al.d("unknown id!", new Object[0]);
                        }
                    }
                }
                if (sb2.toString().contains(",")) {
                    sb2 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
                }
                sb2.append(")");
                String string = sb2.toString();
                sb2.setLength(0);
                if (i10 > 0) {
                    al.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", string)));
                }
                cursorA.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = cursorA;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    return arrayList;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void c(ArrayList<bn> arrayList, String str) {
        if (ap.b(str)) {
            return;
        }
        try {
            bn bnVar = new bn((byte) 1, "crashInfos.txt", str.getBytes("utf-8"));
            al.c("attach crash infos", new Object[0]);
            arrayList.add(bnVar);
        } catch (Exception e10) {
            e10.printStackTrace();
            al.a(e10);
        }
    }

    private static void b(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "jniLog.txt", str.getBytes("utf-8")));
            } catch (Exception e10) {
                e10.printStackTrace();
                al.a(e10);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        String str;
        if (crashDetailBean.f8602b == 1 && (str = crashDetailBean.f8622v) != null) {
            try {
                bn bnVarA = a("tomb.zip", context, str);
                if (bnVarA != null) {
                    al.c("attach tombs", new Object[0]);
                    arrayList.add(bnVarA);
                }
            } catch (Exception e10) {
                al.a(e10);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            arrayList.add(new bn((byte) 1, "userExtraByteData", bArr));
            al.c("attach extraData", new Object[0]);
        } catch (Exception e10) {
            al.a(e10);
        }
    }

    private boolean b(CrashDetailBean crashDetailBean, List<ar> list, List<ar> list2) {
        boolean z10;
        int i10 = crashDetailBean.f8602b;
        boolean z11 = i10 == 0 || i10 == 1;
        boolean z12 = i10 == 3;
        if (p.f9101c) {
            z10 = false;
        } else {
            z10 = (z12 || z11) ? at.f8829e : true;
        }
        if (!z10) {
            return false;
        }
        ArrayList<ar> arrayList = new ArrayList(10);
        if (!a(crashDetailBean, list, arrayList)) {
            try {
                if (arrayList.size() >= at.f8828d) {
                }
            } catch (Exception e10) {
                al.a(e10);
                al.d("Failed to merge crash.", new Object[0]);
            }
            return false;
        }
        al.a("same crash occur too much do merged!", new Object[0]);
        CrashDetailBean crashDetailBeanA = a((List<ar>) arrayList, crashDetailBean);
        for (ar arVar : arrayList) {
            if (arVar.f8803a != crashDetailBeanA.f8600a) {
                list2.add(arVar);
            }
        }
        b(crashDetailBeanA);
        d(list2);
        al.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
        return true;
    }

    private static boolean a(String str) {
        String str2 = at.f8842r;
        if (str2 != null && !str2.isEmpty()) {
            try {
                al.c("Crash regular filter for crash stack is: %s", at.f8842r);
                if (Pattern.compile(at.f8842r).matcher(str).find()) {
                    al.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                    return true;
                }
            } catch (Exception e10) {
                al.a(e10);
                al.d("Failed to compile " + at.f8842r, new Object[0]);
            }
        }
        return false;
    }

    private static boolean a(CrashDetailBean crashDetailBean, List<ar> list, List<ar> list2) {
        boolean z10 = false;
        for (ar arVar : list) {
            if (crashDetailBean.f8621u.equals(arVar.f8805c)) {
                if (arVar.f8807e) {
                    z10 = true;
                }
                list2.add(arVar);
            }
        }
        return z10;
    }

    public static List<CrashDetailBean> a() {
        StrategyBean strategyBeanC = ac.a().c();
        if (strategyBeanC == null) {
            al.d("have not synced remote!", new Object[0]);
            return null;
        }
        if (!strategyBeanC.f8582f) {
            al.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            al.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jB = ap.b();
        List<ar> listB = b();
        al.c("Size of crash list loaded from DB: %s", Integer.valueOf(listB.size()));
        if (listB.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.addAll(a(listB));
        listB.removeAll(arrayList);
        Iterator<ar> it = listB.iterator();
        while (it.hasNext()) {
            ar next = it.next();
            long j10 = next.f8804b;
            if (j10 < jB - at.f8834j) {
                arrayList2.add(next);
                it.remove();
                arrayList.add(next);
            } else if (next.f8806d) {
                if (j10 >= jCurrentTimeMillis - 86400000) {
                    it.remove();
                } else if (!next.f8807e) {
                    it.remove();
                    arrayList.add(next);
                }
            } else if (next.f8808f >= 3 && j10 < jCurrentTimeMillis - 86400000) {
                it.remove();
                arrayList.add(next);
            }
        }
        b(arrayList2);
        if (arrayList.size() > 0) {
            d(arrayList);
        }
        ArrayList arrayList3 = new ArrayList();
        List<CrashDetailBean> listC = c(listB);
        if (listC != null && listC.size() > 0) {
            String str = aa.b().f8678o;
            Iterator<CrashDetailBean> it2 = listC.iterator();
            while (it2.hasNext()) {
                CrashDetailBean next2 = it2.next();
                if (!str.equals(next2.f8606f)) {
                    it2.remove();
                    arrayList3.add(next2);
                }
            }
        }
        if (arrayList3.size() > 0) {
            e(arrayList3);
        }
        return listC;
    }

    public final void a(CrashDetailBean crashDetailBean) {
        int i10 = crashDetailBean.f8602b;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 3 && !at.a().k()) {
                    return;
                }
            } else if (!at.a().j()) {
                return;
            }
        } else if (!at.a().j()) {
            return;
        }
        if (this.f8819f != null) {
            al.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
        }
    }

    public final void a(List<CrashDetailBean> list, long j10, boolean z10, boolean z11, boolean z12) {
        if (!aa.a(this.f8815b).f8669f) {
            al.d("warn: not upload process", new Object[0]);
            return;
        }
        ai aiVar = this.f8816c;
        if (aiVar == null) {
            al.d("warn: upload manager is null", new Object[0]);
            return;
        }
        if (!z12 && !aiVar.b(at.f8826a)) {
            al.d("warn: not crashHappen or not should upload", new Object[0]);
            return;
        }
        StrategyBean strategyBeanC = this.f8818e.c();
        if (!strategyBeanC.f8582f) {
            al.d("remote report is disable!", new Object[0]);
            al.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            return;
        }
        if (list != null && list.size() != 0) {
            try {
                String str = strategyBeanC.f8594r;
                String str2 = StrategyBean.f8578b;
                bp bpVarA = a(this.f8815b, list, aa.b());
                if (bpVarA == null) {
                    al.d("create eupPkg fail!", new Object[0]);
                    return;
                }
                byte[] bArrA = ae.a((com.tencent.bugly.proguard.m) bpVarA);
                if (bArrA == null) {
                    al.d("send encode fail!", new Object[0]);
                    return;
                }
                bq bqVarA = ae.a(this.f8815b, 830, bArrA);
                if (bqVarA == null) {
                    al.d("request package is null.", new Object[0]);
                    return;
                }
                f fVar = new f(System.currentTimeMillis(), list, z10);
                if (z10) {
                    this.f8816c.a(f8809a, bqVarA, str, str2, fVar, j10, z11);
                    return;
                } else {
                    this.f8816c.a(f8809a, bqVarA, str, str2, fVar, false);
                    return;
                }
            } catch (Throwable th) {
                al.e("req cr error %s", th.toString());
                if (al.b(th)) {
                    return;
                }
                th.printStackTrace();
                return;
            }
        }
        al.d("warn: crashList is null or crashList num is 0", new Object[0]);
    }

    public static void a(boolean z10, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            al.c("up finish update state %b", Boolean.valueOf(z10));
            for (CrashDetailBean crashDetailBean : list) {
                al.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f8603c, Integer.valueOf(crashDetailBean.f8612l), Boolean.valueOf(crashDetailBean.f8604d), Boolean.valueOf(crashDetailBean.f8610j));
                int i10 = crashDetailBean.f8612l + 1;
                crashDetailBean.f8612l = i10;
                crashDetailBean.f8604d = z10;
                al.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f8603c, Integer.valueOf(i10), Boolean.valueOf(crashDetailBean.f8604d), Boolean.valueOf(crashDetailBean.f8610j));
            }
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                at.a().a(it.next());
            }
            al.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z10) {
            return;
        }
        al.b("[crash] upload fail.", new Object[0]);
    }

    private static CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j10 = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) ap.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean == null) {
                return crashDetailBean;
            }
            crashDetailBean.f8600a = j10;
            return crashDetailBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static bo a(Context context, CrashDetailBean crashDetailBean, aa aaVar) {
        ArrayList<bl> arrayList = null;
        if (context != null && crashDetailBean != null && aaVar != null) {
            bo boVar = new bo();
            boVar.f8969a = e(crashDetailBean);
            boVar.f8970b = crashDetailBean.f8618r;
            boVar.f8971c = crashDetailBean.f8614n;
            boVar.f8972d = crashDetailBean.f8615o;
            boVar.f8973e = crashDetailBean.f8616p;
            boVar.f8975g = crashDetailBean.f8617q;
            boVar.f8976h = crashDetailBean.f8626z;
            boVar.f8977i = crashDetailBean.f8603c;
            boVar.f8978j = null;
            boVar.f8980l = crashDetailBean.f8613m;
            boVar.f8981m = crashDetailBean.f8605e;
            boVar.f8974f = crashDetailBean.B;
            boVar.f8982n = null;
            Map<String, PlugInBean> map = crashDetailBean.f8608h;
            if (map != null && !map.isEmpty()) {
                arrayList = new ArrayList<>(crashDetailBean.f8608h.size());
                for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f8608h.entrySet()) {
                    bl blVar = new bl();
                    blVar.f8952a = entry.getValue().f8574a;
                    blVar.f8954c = entry.getValue().f8576c;
                    blVar.f8956e = entry.getValue().f8575b;
                    arrayList.add(blVar);
                }
            }
            boVar.f8984p = arrayList;
            al.c("libInfo %s", boVar.f8983o);
            ArrayList<bn> arrayList2 = new ArrayList<>(20);
            a(arrayList2, crashDetailBean);
            a(arrayList2, crashDetailBean.f8623w);
            b(arrayList2, crashDetailBean.f8624x);
            c(arrayList2, crashDetailBean.Z);
            a(arrayList2, crashDetailBean.f8601aa, context);
            a(arrayList2, crashDetailBean.f8625y);
            a(arrayList2, crashDetailBean, context);
            b(arrayList2, crashDetailBean, context);
            a(arrayList2, aaVar.L);
            b(arrayList2, crashDetailBean.Y);
            boVar.f8985q = arrayList2;
            if (crashDetailBean.f8610j) {
                boVar.f8979k = crashDetailBean.f8620t;
            }
            boVar.f8986r = a(crashDetailBean, aaVar);
            boVar.f8987s = new HashMap();
            Map<String, String> map2 = crashDetailBean.S;
            if (map2 != null && map2.size() > 0) {
                boVar.f8987s.putAll(crashDetailBean.S);
                al.a("setted message size %d", Integer.valueOf(boVar.f8987s.size()));
            }
            Map<String, String> map3 = boVar.f8987s;
            al.c("pss:" + crashDetailBean.I + " vss:" + crashDetailBean.J + " javaHeap:" + crashDetailBean.K, new Object[0]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.I);
            map3.put("SDK_UPLOAD_U1", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.J);
            map3.put("SDK_UPLOAD_U2", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(crashDetailBean.K);
            map3.put("SDK_UPLOAD_U3", sb4.toString());
            al.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", crashDetailBean.f8614n, crashDetailBean.f8603c, aaVar.d(), Long.valueOf((crashDetailBean.f8618r - crashDetailBean.Q) / 1000), Boolean.valueOf(crashDetailBean.f8611k), Boolean.valueOf(crashDetailBean.R), Boolean.valueOf(crashDetailBean.f8610j), Boolean.valueOf(crashDetailBean.f8602b == 1), Integer.valueOf(crashDetailBean.f8620t), crashDetailBean.f8619s, Boolean.valueOf(crashDetailBean.f8604d), Integer.valueOf(boVar.f8986r.size()));
            return boVar;
        }
        al.d("enExp args == null", new Object[0]);
        return null;
    }

    private static bp a(Context context, List<CrashDetailBean> list, aa aaVar) {
        if (context != null && list != null && list.size() != 0 && aaVar != null) {
            bp bpVar = new bp();
            bpVar.f8991a = new ArrayList<>();
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                bpVar.f8991a.add(a(context, it.next(), aaVar));
            }
            return bpVar;
        }
        al.d("enEXPPkg args == null!", new Object[0]);
        return null;
    }

    private static bn a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 != null && context != null) {
            al.c("zip %s", str2);
            File file = new File(str2);
            File file2 = new File(context.getCacheDir(), str);
            if (!ap.a(file, file2)) {
                al.d("zip fail!", new Object[0]);
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i10 = fileInputStream.read(bArr);
                        if (i10 <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i10);
                        byteArrayOutputStream.flush();
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    al.c("read bytes :%d", Integer.valueOf(byteArray.length));
                    bn bnVar = new bn((byte) 2, file2.getName(), byteArray);
                    try {
                        fileInputStream.close();
                    } catch (IOException e10) {
                        if (!al.a(e10)) {
                            e10.printStackTrace();
                        }
                    }
                    if (file2.exists()) {
                        al.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return bnVar;
                } catch (Throwable th) {
                    th = th;
                    try {
                        if (!al.a(th)) {
                            th.printStackTrace();
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e11) {
                                if (!al.a(e11)) {
                                    e11.printStackTrace();
                                }
                            }
                        }
                        if (file2.exists()) {
                            al.c("del tmp", new Object[0]);
                        }
                        return null;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e12) {
                                if (!al.a(e12)) {
                                    e12.printStackTrace();
                                }
                            }
                        }
                        if (file2.exists()) {
                            al.c("del tmp", new Object[0]);
                            file2.delete();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        } else {
            al.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
            return null;
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        aa aaVarB = aa.b();
        if (aaVarB == null) {
            return;
        }
        al.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        al.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        al.e("# PKG NAME: %s", aaVarB.f8666c);
        al.e("# APP VER: %s", aaVarB.f8678o);
        al.e("# SDK VER: %s", aaVarB.f8671h);
        al.e("# LAUNCH TIME: %s", ap.a(new Date(aa.b().f8657a)));
        al.e("# CRASH TYPE: %s", str);
        al.e("# CRASH TIME: %s", str2);
        al.e("# CRASH PROCESS: %s", str3);
        al.e("# CRASH FOREGROUND: %s", Boolean.valueOf(aaVarB.a()));
        al.e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            al.e("# REPORT ID: %s", crashDetailBean.f8603c);
            al.e("# CRASH DEVICE: %s %s", aaVarB.h(), aaVarB.r().booleanValue() ? "ROOTED" : "UNROOT");
            al.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
            al.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
            if (!ap.b(crashDetailBean.O)) {
                al.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.O, crashDetailBean.N);
            } else if (crashDetailBean.f8602b == 3) {
                if (crashDetailBean.T == null) {
                    str6 = Configurator.NULL;
                } else {
                    str6 = crashDetailBean.T.get("BUGLY_CR_01");
                }
                al.e("# EXCEPTION ANR MESSAGE:\n %s", str6);
            }
        }
        if (!ap.b(str5)) {
            al.e("# CRASH STACK: ", new Object[0]);
            al.e(str5, new Object[0]);
        }
        al.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }

    private static void a(CrashDetailBean crashDetailBean, Map<String, String> map) {
        String value;
        if (map != null && !map.isEmpty()) {
            crashDetailBean.S = new LinkedHashMap(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!ap.b(entry.getKey())) {
                    String key = entry.getKey();
                    if (key.length() > 100) {
                        key = key.substring(0, 100);
                        al.d("setted key length is over limit %d substring to %s", 100, key);
                    }
                    if (!ap.b(entry.getValue()) && entry.getValue().length() > 100000) {
                        value = entry.getValue().substring(entry.getValue().length() - BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                        al.d("setted %s value length is over limit %d substring", key, Integer.valueOf(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH));
                    } else {
                        value = entry.getValue();
                    }
                    crashDetailBean.S.put(key, value);
                    al.a("add setted key %s value size:%d", key, Integer.valueOf(value.length()));
                }
            }
            return;
        }
        al.d("extra map is empty. CrashBean won't have userDatas.", new Object[0]);
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean) {
        String str;
        if (crashDetailBean.f8610j && (str = crashDetailBean.f8619s) != null && str.length() > 0) {
            try {
                arrayList.add(new bn((byte) 1, "alltimes.txt", crashDetailBean.f8619s.getBytes("utf-8")));
            } catch (Exception e10) {
                e10.printStackTrace();
                al.a(e10);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "log.txt", str.getBytes("utf-8")));
            } catch (Exception e10) {
                e10.printStackTrace();
                al.a(e10);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, String str, Context context) {
        if (str != null) {
            try {
                bn bnVarA = a("backupRecord.zip", context, str);
                if (bnVarA != null) {
                    al.c("attach backup record", new Object[0]);
                    arrayList.add(bnVarA);
                }
            } catch (Exception e10) {
                al.a(e10);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            bn bnVar = new bn((byte) 2, "buglylog.zip", bArr);
            al.c("attach user log", new Object[0]);
            arrayList.add(bnVar);
        } catch (Exception e10) {
            al.a(e10);
        }
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        bn bnVarA;
        if (crashDetailBean.f8602b != 3) {
            return;
        }
        al.c("crashBean.anrMessages:%s", crashDetailBean.T);
        try {
            Map<String, String> map = crashDetailBean.T;
            if (map != null && map.containsKey("BUGLY_CR_01")) {
                if (!TextUtils.isEmpty(crashDetailBean.T.get("BUGLY_CR_01"))) {
                    arrayList.add(new bn((byte) 1, "anrMessage.txt", crashDetailBean.T.get("BUGLY_CR_01").getBytes("utf-8")));
                    al.c("attach anr message", new Object[0]);
                }
                crashDetailBean.T.remove("BUGLY_CR_01");
            }
            String str = crashDetailBean.f8622v;
            if (str == null || (bnVarA = a("trace.zip", context, str)) == null) {
                return;
            }
            al.c("attach traces", new Object[0]);
            arrayList.add(bnVarA);
        } catch (Exception e10) {
            e10.printStackTrace();
            al.a(e10);
        }
    }

    private static void a(ArrayList<bn> arrayList, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
        }
        try {
            arrayList.add(new bn((byte) 1, "martianlog.txt", sb2.toString().getBytes("utf-8")));
            al.c("attach pageTracingList", new Object[0]);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private static Map<String, String> a(CrashDetailBean crashDetailBean, aa aaVar) {
        HashMap map = new HashMap(30);
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.C);
            map.put("A9", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.D);
            map.put("A11", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(crashDetailBean.E);
            map.put("A10", sb4.toString());
            map.put("A23", crashDetailBean.f8606f);
            StringBuilder sb5 = new StringBuilder();
            aaVar.getClass();
            map.put("A7", sb5.toString());
            map.put("A6", aa.n());
            map.put("A5", aaVar.m());
            map.put("A22", aaVar.g());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(crashDetailBean.G);
            map.put("A2", sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append(crashDetailBean.F);
            map.put("A1", sb7.toString());
            map.put("A24", aaVar.f8674k);
            StringBuilder sb8 = new StringBuilder();
            sb8.append(crashDetailBean.H);
            map.put("A17", sb8.toString());
            map.put("A25", aaVar.g());
            map.put("A15", aaVar.q());
            StringBuilder sb9 = new StringBuilder();
            sb9.append(aaVar.r());
            map.put("A13", sb9.toString());
            map.put("A34", crashDetailBean.A);
            if (aaVar.G != null) {
                map.put("productIdentify", aaVar.G);
            }
            map.put("A26", URLEncoder.encode(crashDetailBean.L, "utf-8"));
            if (crashDetailBean.f8602b == 1) {
                map.put("A27", crashDetailBean.O);
                map.put("A28", crashDetailBean.N);
                StringBuilder sb10 = new StringBuilder();
                sb10.append(crashDetailBean.f8611k);
                map.put("A29", sb10.toString());
            }
            map.put("A30", crashDetailBean.P);
            StringBuilder sb11 = new StringBuilder();
            sb11.append(crashDetailBean.Q);
            map.put("A18", sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(true ^ crashDetailBean.R);
            map.put("A36", sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(aaVar.f8689z);
            map.put("F02", sb13.toString());
            StringBuilder sb14 = new StringBuilder();
            sb14.append(aaVar.A);
            map.put("F03", sb14.toString());
            map.put("F04", aaVar.d());
            StringBuilder sb15 = new StringBuilder();
            sb15.append(aaVar.B);
            map.put("F05", sb15.toString());
            map.put("F06", aaVar.f8688y);
            map.put("F08", aaVar.E);
            map.put("F09", aaVar.F);
            StringBuilder sb16 = new StringBuilder();
            sb16.append(aaVar.C);
            map.put("F10", sb16.toString());
            a(map, crashDetailBean);
            return map;
        } catch (Exception e10) {
            e10.printStackTrace();
            al.a(e10);
            return map;
        }
    }

    private static void a(Map<String, String> map, CrashDetailBean crashDetailBean) {
        if (crashDetailBean.U >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.U);
            map.put("C01", sb2.toString());
        }
        if (crashDetailBean.V >= 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.V);
            map.put("C02", sb3.toString());
        }
        Map<String, String> map2 = crashDetailBean.W;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : crashDetailBean.W.entrySet()) {
                map.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map3 = crashDetailBean.X;
        if (map3 == null || map3.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry2 : crashDetailBean.X.entrySet()) {
            map.put("C04_" + entry2.getKey(), entry2.getValue());
        }
    }

    static /* synthetic */ void a(List list, boolean z10, long j10, String str, String str2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CrashDetailBean crashDetailBean = (CrashDetailBean) it.next();
            String str3 = f8814l.get(Integer.valueOf(crashDetailBean.f8602b));
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new ag.c(crashDetailBean.f8603c, str3, crashDetailBean.f8618r, z10, j10, str, str2));
            }
        }
        ag.a.f8708a.a(arrayList);
    }
}
