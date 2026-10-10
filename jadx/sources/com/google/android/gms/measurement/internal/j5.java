package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class j5 extends m5 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f3726e = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i5 f3727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3728d;

    private static long D(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{ExifInterface.GPS_MEASUREMENT_3D}, null, null, "rowid desc", "1");
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return -1L;
            }
            long j10 = cursorQuery.getLong(0);
            cursorQuery.close();
            return j10;
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            cursorQuery.close();
            throw th;
        }
    }

    @WorkerThread
    public final boolean L() {
        return F(3, new byte[0]);
    }

    @Override // com.google.android.gms.measurement.internal.m5
    protected final boolean y() {
        return false;
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 3861. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:99)
        */
    @androidx.annotation.WorkerThread
    private final boolean F(int r18, byte[] r19) {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.j5.F(int, byte[]):boolean");
    }

    @VisibleForTesting
    @WorkerThread
    private final SQLiteDatabase O() {
        if (this.f3728d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f3727c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f3728d = true;
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:143:0x0261  */
    /* JADX WARN: Code duplicated, block: B:145:0x0266  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41, types: [com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable] */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v50, types: [com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable] */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r0v59, types: [com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable] */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r0v68 */
    /* JADX WARN: Type inference failed for: r0v69 */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARN: Type inference failed for: r10v5, types: [android.database.sqlite.SQLiteClosable, android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r10v6, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARN: Type inference failed for: r10v7, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARN: Type inference failed for: r10v8, types: [android.database.sqlite.SQLiteClosable, android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r11v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r11v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r11v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r22v1, types: [java.util.List<b2.n>] */
    /* JADX WARN: Type inference failed for: r22v10 */
    /* JADX WARN: Type inference failed for: r22v11 */
    /* JADX WARN: Type inference failed for: r22v12 */
    /* JADX WARN: Type inference failed for: r22v13 */
    /* JADX WARN: Type inference failed for: r22v14 */
    /* JADX WARN: Type inference failed for: r22v15 */
    /* JADX WARN: Type inference failed for: r22v16 */
    /* JADX WARN: Type inference failed for: r22v17 */
    /* JADX WARN: Type inference failed for: r22v18 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r22v7 */
    /* JADX WARN: Type inference failed for: r22v8 */
    /* JADX WARN: Type inference failed for: r22v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List<b2.n>] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final List<b2.n> E(int i10) throws Throwable {
        ?? O;
        ?? r22;
        ?? Query;
        ?? r14;
        ?? r13;
        ?? r10;
        ?? r11;
        ?? r12;
        n();
        ?? r15 = 0;
        if (this.f3728d) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!P()) {
            return arrayList;
        }
        int i11 = 0;
        int i12 = 5;
        while (i11 < 5) {
            try {
                O = O();
                try {
                    if (O == 0) {
                        this.f3728d = true;
                        if (O != 0) {
                            O.close();
                        }
                        return r15;
                    }
                    try {
                        try {
                            O.beginTransaction();
                            long jD = D(O);
                            long j10 = -1;
                            if (jD != -1) {
                                r14 = new String[]{String.valueOf(jD)};
                                r13 = "rowid<?";
                            } else {
                                ?? r16 = r15;
                                r14 = r16;
                                r13 = r16;
                            }
                            Query = O.query("messages", new String[]{"rowid", IjkMediaMeta.IJKM_KEY_TYPE, "entry"}, r13, r14, null, null, "rowid asc", Integer.toString(100));
                            ?? r17 = r15;
                            while (Query.moveToNext()) {
                                try {
                                    j10 = Query.getLong(0);
                                    int i13 = Query.getInt(1);
                                    byte[] blob = Query.getBlob(2);
                                    r22 = r17;
                                    if (i13 == 0) {
                                        try {
                                            Parcel parcelObtain = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain.unmarshall(blob, 0, blob.length);
                                                    parcelObtain.setDataPosition(0);
                                                    zzbj zzbjVarCreateFromParcel = zzbj.CREATOR.createFromParcel(parcelObtain);
                                                    parcelObtain.recycle();
                                                    if (zzbjVarCreateFromParcel != null) {
                                                        arrayList.add(new b2.n(zzbjVarCreateFromParcel, "", 0L));
                                                    }
                                                } catch (Throwable th) {
                                                    parcelObtain.recycle();
                                                    throw th;
                                                }
                                            } catch (n1.a.C0307a unused) {
                                                l().H().a("Failed to load event from local database");
                                                parcelObtain.recycle();
                                            }
                                        } catch (SQLiteDatabaseLockedException unused2) {
                                            SystemClock.sleep(i12);
                                            i12 += 20;
                                            if (Query != 0) {
                                                Query.close();
                                            }
                                            if (O != 0) {
                                                O.close();
                                            }
                                            i11++;
                                            r15 = r22;
                                        } catch (SQLiteFullException e10) {
                                            e = e10;
                                            l().H().b("Error reading entries from local database", e);
                                            this.f3728d = true;
                                            if (Query != 0) {
                                                Query.close();
                                            }
                                            if (O != 0) {
                                                O.close();
                                            }
                                            i11++;
                                            r15 = r22;
                                        } catch (SQLiteException e11) {
                                            e = e11;
                                            if (O != 0) {
                                                try {
                                                    if (O.inTransaction()) {
                                                        O.endTransaction();
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    r15 = Query;
                                                    if (r15 != 0) {
                                                        r15.close();
                                                    }
                                                    if (O != 0) {
                                                        O.close();
                                                    }
                                                    throw th;
                                                }
                                            }
                                            l().H().b("Error reading entries from local database", e);
                                            this.f3728d = true;
                                            if (Query != 0) {
                                                Query.close();
                                            }
                                            if (O != 0) {
                                                O.close();
                                            }
                                            i11++;
                                            r15 = r22;
                                        }
                                    } else if (i13 == 1) {
                                        Parcel parcelObtain2 = Parcel.obtain();
                                        try {
                                            try {
                                                parcelObtain2.unmarshall(blob, 0, blob.length);
                                                parcelObtain2.setDataPosition(0);
                                                zzpy zzpyVarCreateFromParcel = zzpy.CREATOR.createFromParcel(parcelObtain2);
                                                parcelObtain2.recycle();
                                                r12 = zzpyVarCreateFromParcel;
                                            } catch (Throwable th3) {
                                                parcelObtain2.recycle();
                                                throw th3;
                                            }
                                        } catch (n1.a.C0307a unused3) {
                                            l().H().a("Failed to load user property from local database");
                                            parcelObtain2.recycle();
                                            r12 = r22;
                                        }
                                        if (r12 != 0) {
                                            arrayList.add(new b2.n(r12, "", 0L));
                                        }
                                    } else if (i13 == 2) {
                                        Parcel parcelObtain3 = Parcel.obtain();
                                        try {
                                            try {
                                                parcelObtain3.unmarshall(blob, 0, blob.length);
                                                parcelObtain3.setDataPosition(0);
                                                zzai zzaiVarCreateFromParcel = zzai.CREATOR.createFromParcel(parcelObtain3);
                                                parcelObtain3.recycle();
                                                r11 = zzaiVarCreateFromParcel;
                                            } catch (Throwable th4) {
                                                parcelObtain3.recycle();
                                                throw th4;
                                            }
                                        } catch (n1.a.C0307a unused4) {
                                            l().H().a("Failed to load conditional user property from local database");
                                            parcelObtain3.recycle();
                                            r11 = r22;
                                        }
                                        if (r11 != 0) {
                                            arrayList.add(new b2.n(r11, "", 0L));
                                        }
                                    } else if (i13 == 4) {
                                        Parcel parcelObtain4 = Parcel.obtain();
                                        try {
                                            try {
                                                parcelObtain4.unmarshall(blob, 0, blob.length);
                                                parcelObtain4.setDataPosition(0);
                                                zzbi zzbiVarCreateFromParcel = zzbi.CREATOR.createFromParcel(parcelObtain4);
                                                parcelObtain4.recycle();
                                                r10 = zzbiVarCreateFromParcel;
                                            } catch (n1.a.C0307a unused5) {
                                                l().H().a("Failed to load default event parameters from local database");
                                                parcelObtain4.recycle();
                                                r10 = r22;
                                            }
                                            if (r10 != 0) {
                                                arrayList.add(new b2.n(r10, "", 0L));
                                            }
                                        } catch (Throwable th5) {
                                            parcelObtain4.recycle();
                                            throw th5;
                                        }
                                    } else if (i13 == 3) {
                                        l().M().a("Skipping app launch break");
                                    } else {
                                        l().H().a("Unknown record type in local database");
                                    }
                                    r17 = r22;
                                } catch (SQLiteDatabaseLockedException unused6) {
                                    r22 = r17;
                                } catch (SQLiteFullException e12) {
                                    e = e12;
                                    r22 = r17;
                                } catch (SQLiteException e13) {
                                    e = e13;
                                    r22 = r17;
                                }
                            }
                            if (O.delete("messages", "rowid <= ?", new String[]{Long.toString(j10)}) < arrayList.size()) {
                                l().H().a("Fewer entries removed from local database than expected");
                            }
                            O.setTransactionSuccessful();
                            O.endTransaction();
                            Query.close();
                            O.close();
                            return arrayList;
                        } catch (Throwable th6) {
                            th = th6;
                            if (r15 != 0) {
                                r15.close();
                            }
                            if (O != 0) {
                                O.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteDatabaseLockedException unused7) {
                        r22 = r15;
                        Query = r22;
                    } catch (SQLiteFullException e14) {
                        e = e14;
                        r22 = r15;
                        Query = r22;
                    } catch (SQLiteException e15) {
                        e = e15;
                        r22 = r15;
                        Query = r22;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (SQLiteDatabaseLockedException unused8) {
                r22 = r15;
                O = r22;
                Query = O;
            } catch (SQLiteFullException e16) {
                e = e16;
                r22 = r15;
                O = r22;
                Query = O;
            } catch (SQLiteException e17) {
                e = e17;
                r22 = r15;
                O = r22;
                Query = O;
            } catch (Throwable th8) {
                th = th8;
                O = r15;
            }
        }
        ?? r23 = r15;
        l().M().a("Failed to read events from database in reasonable time");
        return r23;
    }

    @WorkerThread
    public final boolean M() {
        n();
        if (this.f3728d || !P()) {
            return false;
        }
        int i10 = 5;
        for (int i11 = 0; i11 < 5; i11++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    SQLiteDatabase sQLiteDatabaseO = O();
                    if (sQLiteDatabaseO == null) {
                        this.f3728d = true;
                        if (sQLiteDatabaseO != null) {
                            sQLiteDatabaseO.close();
                        }
                        return false;
                    }
                    sQLiteDatabaseO.beginTransaction();
                    sQLiteDatabaseO.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    sQLiteDatabaseO.setTransactionSuccessful();
                    sQLiteDatabaseO.endTransaction();
                    sQLiteDatabaseO.close();
                    return true;
                } catch (SQLiteFullException e10) {
                    l().H().b("Error deleting app launch break from local database", e10);
                    this.f3728d = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep(i10);
                i10 += 20;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e11) {
                if (0 != 0) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                }
                l().H().b("Error deleting app launch break from local database", e11);
                this.f3728d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        l().M().a("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    j5(s6 s6Var) {
        super(s6Var);
        this.f3727c = new i5(this, b(), "google_app_measurement_local.db");
    }

    @VisibleForTesting
    private final boolean P() {
        return b().getDatabasePath("google_app_measurement_local.db").exists();
    }

    public final boolean G(zzai zzaiVar) {
        j();
        byte[] bArrR0 = wc.r0(zzaiVar);
        if (bArrR0.length > 131072) {
            l().J().a("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return F(2, bArrR0);
    }

    public final boolean H(zzbi zzbiVar) {
        j();
        byte[] bArrR0 = wc.r0(zzbiVar);
        if (bArrR0 == null) {
            l().J().a("Null default event parameters; not writing to database");
            return false;
        }
        if (bArrR0.length > 131072) {
            l().J().a("Default event parameters too long for local database. Sending directly to service");
            return false;
        }
        return F(4, bArrR0);
    }

    public final boolean I(zzbj zzbjVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzbjVar.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length > 131072) {
            l().J().a("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return F(0, bArrMarshall);
    }

    public final boolean J(zzpy zzpyVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzpyVar.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length > 131072) {
            l().J().a("User property too long for local database. Sending directly to service");
            return false;
        }
        return F(1, bArrMarshall);
    }

    @WorkerThread
    public final void K() {
        int iDelete;
        n();
        try {
            SQLiteDatabase sQLiteDatabaseO = O();
            if (sQLiteDatabaseO != null && (iDelete = sQLiteDatabaseO.delete("messages", null, null)) > 0) {
                l().L().b("Reset local analytics data. records", Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e10) {
            l().H().b("Error resetting local analytics data. error", e10);
        }
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p6 a() {
        return super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ Context b() {
        return super.b();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.d c() {
        return super.c();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ i d() {
        return super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ e e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a0 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ k5 g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a6 h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ l9 i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ wc j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p5 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void m() {
        super.m();
    }

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void n() {
        super.n();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ w o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ h5 q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ j5 r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ z7 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ o9 t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ s9 u() {
        return super.u();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ x9 v() {
        return super.v();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ ib w() {
        return super.w();
    }
}
