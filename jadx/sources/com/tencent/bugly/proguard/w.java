package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static w f9153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static x f9154c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9155a = 4;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private v f9156b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f9157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ContentValues f9158d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f9159e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String[] f9160f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f9161g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String[] f9162h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f9163i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f9164j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f9165k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f9166l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f9167m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String[] f9168n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f9169o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private String f9170p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private byte[] f9171q;

        public a() {
        }

        public final void a(int i10, String str, byte[] bArr) {
            this.f9169o = i10;
            this.f9170p = str;
            this.f9171q = bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.f9155a) {
                case 1:
                    w.this.a(this.f9157c, this.f9158d, this.f9156b);
                    break;
                case 2:
                    w.this.a(this.f9157c, this.f9167m, this.f9168n, this.f9156b);
                    break;
                case 3:
                    Cursor cursorA = w.this.a(this.f9159e, this.f9157c, this.f9160f, this.f9161g, this.f9162h, this.f9163i, this.f9164j, this.f9165k, this.f9166l, this.f9156b);
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    break;
                case 4:
                    w.this.a(this.f9169o, this.f9170p, this.f9171q, this.f9156b);
                    break;
                case 5:
                    w.this.a(this.f9169o, this.f9156b);
                    break;
                case 6:
                    w.this.a(this.f9169o, this.f9170p, this.f9156b);
                    break;
            }
        }
    }

    private synchronized boolean b(y yVar) {
        ContentValues contentValuesD;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f9154c.getWritableDatabase();
            if (writableDatabase == null || (contentValuesD = d(yVar)) == null) {
                if (f9152a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            }
            long jReplace = writableDatabase.replace("t_pf", "_id", contentValuesD);
            if (jReplace < 0) {
                if (f9152a) {
                    writableDatabase.close();
                }
                return false;
            }
            al.c("[Database] insert %s success.", "t_pf");
            yVar.f9177a = jReplace;
            if (f9152a) {
                writableDatabase.close();
            }
            return true;
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
                if (f9152a && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    private static ContentValues c(y yVar) {
        if (yVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = yVar.f9177a;
            if (j10 > 0) {
                contentValues.put("_id", Long.valueOf(j10));
            }
            contentValues.put("_tp", Integer.valueOf(yVar.f9178b));
            contentValues.put("_pc", yVar.f9179c);
            contentValues.put("_th", yVar.f9180d);
            contentValues.put("_tm", Long.valueOf(yVar.f9181e));
            byte[] bArr = yVar.f9183g;
            if (bArr != null) {
                contentValues.put("_dt", bArr);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static ContentValues d(y yVar) {
        if (yVar != null && !ap.b(yVar.f9182f)) {
            try {
                ContentValues contentValues = new ContentValues();
                long j10 = yVar.f9177a;
                if (j10 > 0) {
                    contentValues.put("_id", Long.valueOf(j10));
                }
                contentValues.put("_tp", yVar.f9182f);
                contentValues.put("_tm", Long.valueOf(yVar.f9181e));
                byte[] bArr = yVar.f9183g;
                if (bArr != null) {
                    contentValues.put("_dt", bArr);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    private w(Context context, List<o> list) {
        f9154c = new x(context, list);
    }

    public static synchronized w a(Context context, List<o> list) {
        try {
            if (f9153b == null) {
                f9153b = new w(context, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9153b;
    }

    public static synchronized w a() {
        return f9153b;
    }

    public final Cursor a(String str, String[] strArr, String str2) {
        return a(str, strArr, str2, (String) null, (String) null);
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00cc A[Catch: all -> 0x0027, PHI: r2
      0x00cc: PHI (r2v2 android.database.sqlite.SQLiteDatabase) = (r2v1 android.database.sqlite.SQLiteDatabase), (r2v3 android.database.sqlite.SQLiteDatabase) binds: [B:55:0x00ca, B:41:0x00ad] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #3 {all -> 0x0027, blocks: (B:9:0x0023, B:12:0x002b, B:14:0x002f, B:32:0x0099, B:34:0x00a0, B:52:0x00c3, B:53:0x00c6, B:56:0x00cc, B:60:0x00d3, B:61:0x00d6, B:64:0x00dc, B:65:0x00df, B:39:0x00a9, B:45:0x00b4, B:47:0x00ba), top: B:74:0x0002, inners: #4 }] */
    private synchronized List<y> c(int i10) {
        Throwable th;
        SQLiteDatabase writableDatabase;
        Cursor cursorQuery;
        try {
            try {
                writableDatabase = f9154c.getWritableDatabase();
                if (writableDatabase != null) {
                    try {
                        String strConcat = "_id = ".concat(String.valueOf(i10));
                        cursorQuery = writableDatabase.query("t_pf", null, strConcat, null, null, null, null);
                        if (cursorQuery == null) {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (f9152a) {
                                writableDatabase.close();
                            }
                            return null;
                        }
                        try {
                            StringBuilder sb2 = new StringBuilder();
                            ArrayList arrayList = new ArrayList();
                            while (cursorQuery.moveToNext()) {
                                y yVarB = b(cursorQuery);
                                if (yVarB != null) {
                                    arrayList.add(yVarB);
                                } else {
                                    try {
                                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("_tp"));
                                        sb2.append(" or _tp = ");
                                        sb2.append(string);
                                    } catch (Throwable unused) {
                                        al.d("[Database] unknown id.", new Object[0]);
                                    }
                                }
                            }
                            if (sb2.length() > 0) {
                                sb2.append(" and _id = ");
                                sb2.append(i10);
                                al.d("[Database] deleted %s illegal data %d.", "t_pf", Integer.valueOf(writableDatabase.delete("t_pf", strConcat.substring(4), null)));
                            }
                            cursorQuery.close();
                            if (f9152a) {
                                writableDatabase.close();
                            }
                            return arrayList;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                if (!al.a(th)) {
                                    th.printStackTrace();
                                }
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (f9152a && writableDatabase != null) {
                                    writableDatabase.close();
                                }
                                return null;
                            } catch (Throwable th3) {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (f9152a && writableDatabase != null) {
                                    writableDatabase.close();
                                    throw th3;
                                }
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        cursorQuery = null;
                    }
                } else {
                    if (f9152a && writableDatabase != null) {
                        writableDatabase.close();
                    }
                    return null;
                }
            } catch (Throwable th5) {
                th = th5;
                writableDatabase = null;
                cursorQuery = null;
            }
        } catch (Throwable th6) {
            throw th6;
        }
    }

    public final Cursor a(String str, String[] strArr, String str2, String str3, String str4) {
        return a(false, str, strArr, str2, null, null, null, str3, str4, null);
    }

    public final int a(String str, String str2) {
        return a(str, str2, (String[]) null, (v) null);
    }

    public final synchronized long a(String str, ContentValues contentValues, v vVar) {
        long j10;
        j10 = -1;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f9154c.getWritableDatabase();
            if (writableDatabase != null && contentValues != null) {
                long jReplace = writableDatabase.replace(str, "_id", contentValues);
                if (jReplace >= 0) {
                    al.c("[Database] insert %s success.", str);
                } else {
                    al.d("[Database] replace %s error.", str);
                }
                j10 = jReplace;
            }
            if (f9152a && writableDatabase != null) {
                writableDatabase.close();
            }
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                if (f9152a && 0 != 0) {
                }
            } catch (Throwable th2) {
                if (f9152a && 0 != 0) {
                    writableDatabase.close();
                }
                throw th2;
            }
        }
        return j10;
    }

    public final synchronized void b(int i10) {
        String strConcat;
        SQLiteDatabase writableDatabase = f9154c.getWritableDatabase();
        if (writableDatabase != null) {
            if (i10 >= 0) {
                try {
                    strConcat = "_tp = ".concat(String.valueOf(i10));
                } catch (Throwable th) {
                    try {
                        if (!al.a(th)) {
                            th.printStackTrace();
                        }
                        if (f9152a) {
                            return;
                        }
                    } finally {
                        if (f9152a) {
                            writableDatabase.close();
                        }
                    }
                }
            } else {
                strConcat = null;
            }
            al.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", strConcat, null)));
            if (f9152a) {
                writableDatabase.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Cursor a(boolean z10, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, v vVar) {
        Cursor cursorQuery;
        cursorQuery = null;
        try {
            SQLiteDatabase writableDatabase = f9154c.getWritableDatabase();
            if (writableDatabase != null) {
                cursorQuery = writableDatabase.query(z10, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
        return cursorQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int a(String str, String str2, String[] strArr, v vVar) {
        int iDelete;
        iDelete = 0;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f9154c.getWritableDatabase();
            iDelete = writableDatabase != null ? writableDatabase.delete(str, str2, strArr) : 0;
            if (f9152a && writableDatabase != null) {
                writableDatabase.close();
            }
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                if (f9152a && writableDatabase != null) {
                }
            } catch (Throwable th2) {
                if (f9152a && writableDatabase != null) {
                    writableDatabase.close();
                }
                throw th2;
            }
        }
        return iDelete;
    }

    private static y b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.f9177a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.f9181e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.f9182f = cursor.getString(cursor.getColumnIndex("_tp"));
            yVar.f9183g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final boolean a(int i10, String str, byte[] bArr, boolean z10) {
        if (!z10) {
            a aVar = new a();
            aVar.a(i10, str, bArr);
            ak.a().a(aVar);
            return true;
        }
        return a(i10, str, bArr, (v) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i10, String str, byte[] bArr, v vVar) {
        try {
            y yVar = new y();
            yVar.f9177a = i10;
            yVar.f9182f = str;
            yVar.f9181e = System.currentTimeMillis();
            yVar.f9183g = bArr;
            return b(yVar);
        } catch (Throwable th) {
            if (al.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public final Map<String, byte[]> a(int i10, v vVar) {
        HashMap map = null;
        try {
            List<y> listC = c(i10);
            if (listC == null) {
                return null;
            }
            HashMap map2 = new HashMap();
            try {
                for (y yVar : listC) {
                    byte[] bArr = yVar.f9183g;
                    if (bArr != null) {
                        map2.put(yVar.f9182f, bArr);
                    }
                }
                return map2;
            } catch (Throwable th) {
                th = th;
                map = map2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (!al.a(th)) {
            th.printStackTrace();
        }
        return map;
    }

    public final synchronized boolean a(y yVar) {
        ContentValues contentValuesC;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f9154c.getWritableDatabase();
            if (writableDatabase != null && (contentValuesC = c(yVar)) != null) {
                long jReplace = writableDatabase.replace("t_lr", "_id", contentValuesC);
                if (jReplace >= 0) {
                    al.c("[Database] insert %s success.", "t_lr");
                    yVar.f9177a = jReplace;
                    if (f9152a) {
                        writableDatabase.close();
                    }
                    return true;
                }
                if (f9152a) {
                    writableDatabase.close();
                }
                return false;
            }
            if (f9152a && writableDatabase != null) {
                writableDatabase.close();
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
                if (f9152a && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00b2 A[Catch: all -> 0x00b6, TRY_LEAVE, TryCatch #2 {all -> 0x00b6, blocks: (B:42:0x00ac, B:44:0x00b2), top: B:66:0x00ac, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00bb A[Catch: all -> 0x0031, TRY_ENTER, TryCatch #1 {all -> 0x0031, blocks: (B:3:0x0001, B:14:0x002d, B:17:0x0035, B:19:0x0039, B:37:0x00a0, B:39:0x00a7, B:49:0x00bb, B:50:0x00be, B:52:0x00c2, B:54:0x00c8, B:55:0x00cb, B:57:0x00cf, B:58:0x00d2, B:42:0x00ac, B:44:0x00b2), top: B:65:0x0001, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00c2 A[Catch: all -> 0x0031, TryCatch #1 {all -> 0x0031, blocks: (B:3:0x0001, B:14:0x002d, B:17:0x0035, B:19:0x0039, B:37:0x00a0, B:39:0x00a7, B:49:0x00bb, B:50:0x00be, B:52:0x00c2, B:54:0x00c8, B:55:0x00cb, B:57:0x00cf, B:58:0x00d2, B:42:0x00ac, B:44:0x00b2), top: B:65:0x0001, inners: #2 }] */
    public final synchronized List<y> a(int i10) {
        String strConcat;
        Throwable th;
        Cursor cursor;
        try {
            SQLiteDatabase writableDatabase = f9154c.getWritableDatabase();
            if (writableDatabase != null) {
                if (i10 >= 0) {
                    try {
                        strConcat = "_tp = ".concat(String.valueOf(i10));
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = null;
                        try {
                            if (!al.a(th)) {
                                th.printStackTrace();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (f9152a) {
                                writableDatabase.close();
                            }
                            return null;
                        } catch (Throwable th3) {
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (f9152a) {
                                writableDatabase.close();
                                throw th3;
                            }
                            throw th3;
                        }
                    }
                } else {
                    strConcat = null;
                }
                Cursor cursorQuery = writableDatabase.query("t_lr", null, strConcat, null, null, null, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (f9152a) {
                        writableDatabase.close();
                    }
                    return null;
                }
                try {
                    StringBuilder sb2 = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    while (cursorQuery.moveToNext()) {
                        y yVarA = a(cursorQuery);
                        if (yVarA != null) {
                            arrayList.add(yVarA);
                        } else {
                            try {
                                long j10 = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
                                sb2.append(" or _id = ");
                                sb2.append(j10);
                            } catch (Throwable unused) {
                                al.d("[Database] unknown id.", new Object[0]);
                            }
                        }
                    }
                    String string = sb2.toString();
                    if (string.length() > 0) {
                        al.d("[Database] deleted %s illegal data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", string.substring(4), null)));
                    }
                    cursorQuery.close();
                    if (f9152a) {
                        writableDatabase.close();
                    }
                    return arrayList;
                } catch (Throwable th4) {
                    cursor = cursorQuery;
                    th = th4;
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (f9152a) {
                        writableDatabase.close();
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th5) {
            throw th5;
        }
    }

    public final synchronized void a(List<y> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    SQLiteDatabase writableDatabase = f9154c.getWritableDatabase();
                    if (writableDatabase != null) {
                        StringBuilder sb2 = new StringBuilder();
                        for (y yVar : list) {
                            sb2.append(" or _id = ");
                            sb2.append(yVar.f9177a);
                        }
                        String string = sb2.toString();
                        if (string.length() > 0) {
                            string = string.substring(4);
                        }
                        sb2.setLength(0);
                        try {
                            al.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", string, null)));
                            if (f9152a) {
                                writableDatabase.close();
                            }
                        } catch (Throwable th) {
                            try {
                                if (!al.a(th)) {
                                    th.printStackTrace();
                                }
                                if (f9152a) {
                                }
                            } finally {
                                if (f9152a) {
                                    writableDatabase.close();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static y a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.f9177a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.f9178b = cursor.getInt(cursor.getColumnIndex("_tp"));
            yVar.f9179c = cursor.getString(cursor.getColumnIndex("_pc"));
            yVar.f9180d = cursor.getString(cursor.getColumnIndex("_th"));
            yVar.f9181e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.f9183g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(int i10, String str, v vVar) {
        boolean z10;
        String strConcat;
        z10 = false;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = f9154c.getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    if (ap.b(str)) {
                        strConcat = "_id = ".concat(String.valueOf(i10));
                    } else {
                        strConcat = "_id = " + i10 + " and _tp = \"" + str + "\"";
                    }
                    int iDelete = writableDatabase.delete("t_pf", strConcat, null);
                    al.c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(iDelete));
                    if (iDelete > 0) {
                        z10 = true;
                    }
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase = writableDatabase;
                    try {
                        if (!al.a(th)) {
                            th.printStackTrace();
                        }
                        if (f9152a && sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                    } catch (Throwable th2) {
                        if (f9152a && sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th2;
                    }
                }
            }
            if (f9152a && writableDatabase != null) {
                writableDatabase.close();
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return z10;
    }
}
