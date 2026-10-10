package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f3957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ m f3958c;

    public r(m mVar, String str) {
        this.f3958c = mVar;
        m1.g.e(str);
        this.f3956a = str;
        this.f3957b = -1L;
    }

    public final List<p> a() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = this.f3958c.C().query("raw_events", new String[]{"rowid", "name", "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{this.f3956a, String.valueOf(this.f3957b)}, null, null, "rowid", "1000");
                if (!cursorQuery.moveToFirst()) {
                    List<p> list = Collections.EMPTY_LIST;
                    cursorQuery.close();
                    return list;
                }
                do {
                    long j10 = cursorQuery.getLong(0);
                    long j11 = cursorQuery.getLong(3);
                    boolean z10 = cursorQuery.getLong(5) == 1;
                    byte[] blob = cursorQuery.getBlob(4);
                    if (j10 > this.f3957b) {
                        this.f3957b = j10;
                    }
                    try {
                        com.google.android.gms.internal.measurement.o5.a aVar = (com.google.android.gms.internal.measurement.o5.a) sc.H(com.google.android.gms.internal.measurement.o5.Y(), blob);
                        String string = cursorQuery.getString(1);
                        if (string == null) {
                            string = "";
                        }
                        aVar.F(string).H(cursorQuery.getLong(2));
                        arrayList.add(new p(j10, j11, z10, (com.google.android.gms.internal.measurement.o5) ((com.google.android.gms.internal.measurement.ea) aVar.w())));
                    } catch (IOException e10) {
                        this.f3958c.l().H().c("Data loss. Failed to merge raw event. appId", p5.w(this.f3956a), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e11) {
                this.f3958c.l().H().c("Data loss. Error querying raw events batch. appId", p5.w(this.f3956a), e11);
                if (0 != 0) {
                    cursor.close();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public r(m mVar, String str, long j10) {
        this.f3958c = mVar;
        m1.g.e(str);
        this.f3956a = str;
        this.f3957b = mVar.J("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j10)}, -1L);
    }
}
