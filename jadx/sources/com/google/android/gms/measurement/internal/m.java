package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.util.CursorUtil;
import com.google.android.gms.internal.measurement.ef;
import com.google.android.gms.internal.measurement.fe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class m extends bc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f3791f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final String[] f3792g = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f3793h = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String[] f3794i = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f3795j = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f3796k = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f3797l = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String[] f3798m = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String[] f3799n = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String[] f3800o = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String[] f3801p = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final t f3802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final sb f3803e;

    @WorkerThread
    private final com.google.android.gms.internal.measurement.t5 K0(String str, long j10) throws Throwable {
        SQLiteException sQLiteException;
        com.google.android.gms.internal.measurement.t5 t5Var;
        Throwable th;
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = C().query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str, Long.toString(j10)}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
                try {
                    try {
                        if (!cursorQuery.moveToFirst()) {
                            l().H().b("Raw event metadata record is missing. appId", p5.w(str));
                            cursorQuery.close();
                            return null;
                        }
                        try {
                            com.google.android.gms.internal.measurement.t5 t5Var2 = (com.google.android.gms.internal.measurement.t5) ((com.google.android.gms.internal.measurement.ea) ((com.google.android.gms.internal.measurement.t5.a) sc.H(com.google.android.gms.internal.measurement.t5.J2(), cursorQuery.getBlob(0))).w());
                            try {
                                if (cursorQuery.moveToNext()) {
                                    l().M().b("Get multiple raw event metadata records, expected one. appId", p5.w(str));
                                }
                                cursorQuery.close();
                                cursorQuery.close();
                                return t5Var2;
                            } catch (SQLiteException e10) {
                                cursor = cursorQuery;
                                t5Var = t5Var2;
                                sQLiteException = e10;
                                l().H().c("Data loss. Error selecting raw event. appId", p5.w(str), sQLiteException);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return t5Var;
                            }
                        } catch (IOException e11) {
                            l().H().c("Data loss. Failed to merge raw event metadata. appId", p5.w(str), e11);
                            cursorQuery.close();
                            return null;
                        }
                    } catch (SQLiteException e12) {
                        sQLiteException = e12;
                        cursor = cursorQuery;
                        t5Var = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor == null) {
                        throw th;
                    }
                    cursor.close();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (SQLiteException e13) {
            sQLiteException = e13;
            t5Var = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    @WorkerThread
    private final <T> T S(String str, String[] strArr, u<T> uVar) throws Throwable {
        Cursor cursorRawQuery;
        ?? r10 = 0;
        try {
            try {
                cursorRawQuery = C().rawQuery(str, strArr);
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        T tA = uVar.a(cursorRawQuery);
                        cursorRawQuery.close();
                        return tA;
                    }
                    l().L().a("No data found");
                    cursorRawQuery.close();
                    return null;
                } catch (SQLiteException e10) {
                    e = e10;
                    l().H().b("Error querying database.", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r10 = str;
                if (r10 != 0) {
                    r10.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r10 != 0) {
                r10.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final long A() {
        return J("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    @WorkerThread
    public final long B() {
        return J("select max(timestamp) from raw_events", null, 0L);
    }

    @VisibleForTesting
    @WorkerThread
    protected final long I0(String str, String str2) {
        m1.g.e(str);
        m1.g.e(str2);
        n();
        v();
        SQLiteDatabase sQLiteDatabaseC = C();
        sQLiteDatabaseC.beginTransaction();
        long j10 = 0;
        try {
            try {
                long J = J("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1L);
                if (J == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseC.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        l().H().c("Failed to insert column (got -1). appId", p5.w(str), str2);
                        return -1L;
                    }
                    J = 0;
                    l().H().d("Error inserting column. appId", p5.w(str), str2, e);
                    return j10;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put(str2, Long.valueOf(1 + J));
                    if (sQLiteDatabaseC.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                        l().H().c("Failed to update column (got 0). appId", p5.w(str), str2);
                        return -1L;
                    }
                    sQLiteDatabaseC.setTransactionSuccessful();
                    return J;
                } catch (SQLiteException e10) {
                    e = e10;
                    j10 = J;
                }
            } finally {
                sQLiteDatabaseC.endTransaction();
            }
        } catch (SQLiteException e11) {
            e = e11;
        }
    }

    @WorkerThread
    public final q M(long j10, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        return L(j10, str, 1L, false, false, z12, false, z14, z15, z16);
    }

    @Override // com.google.android.gms.measurement.internal.bc
    protected final boolean y() {
        return false;
    }

    private final pc Q(String str, long j10, byte[] bArr, String str2, String str3, int i10, int i11, long j11, long j12, long j13) {
        b2.c1 c1Var;
        if (TextUtils.isEmpty(str2)) {
            l().G().a("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            com.google.android.gms.internal.measurement.s5.a aVar = (com.google.android.gms.internal.measurement.s5.a) sc.H(com.google.android.gms.internal.measurement.s5.R(), bArr);
            b2.c1[] c1VarArrValues = b2.c1.values();
            int length = c1VarArrValues.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    c1Var = b2.c1.UNKNOWN;
                    break;
                }
                c1Var = c1VarArrValues[i12];
                if (c1Var.b() == i10) {
                    break;
                }
                i12++;
            }
            if (c1Var != b2.c1.GOOGLE_SIGNAL && c1Var != b2.c1.GOOGLE_SIGNAL_PENDING && i11 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.google.android.gms.internal.measurement.t5> it = aVar.G().iterator();
                while (it.hasNext()) {
                    com.google.android.gms.internal.measurement.t5.a aVarC = it.next().C();
                    aVarC.I0(i11);
                    arrayList.add((com.google.android.gms.internal.measurement.t5) ((com.google.android.gms.internal.measurement.ea) aVarC.w()));
                }
                aVar.D();
                aVar.z(arrayList);
            }
            HashMap map = new HashMap();
            if (str3 != null) {
                for (String str4 : str3.split("\r\n")) {
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] strArrSplit = str4.split("=", 2);
                    if (strArrSplit.length != 2) {
                        l().H().b("Invalid upload header: ", str4);
                        break;
                    }
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
            return new rc().j(j10).e((com.google.android.gms.internal.measurement.s5) ((com.google.android.gms.internal.measurement.ea) aVar.w())).f(str2).g(map).d(c1Var).h(j11).c(j12).i(j13).b(i11).a();
        } catch (IOException e10) {
            l().H().c("Failed to queued MeasurementBatch from upload_queue. appId", str, e10);
            return null;
        }
    }

    @WorkerThread
    public final long I(String str, com.google.android.gms.internal.measurement.s5 s5Var, String str2, Map<String, String> map, b2.c1 c1Var, Long l10) {
        int iDelete;
        n();
        v();
        m1.g.k(s5Var);
        m1.g.e(str);
        if (!d().u(g0.M0)) {
            return -1L;
        }
        n();
        v();
        if (v0()) {
            long jA = t().f3521f.a();
            long jB = c().b();
            if (Math.abs(jB - jA) > i.T()) {
                t().f3521f.b(jB);
                n();
                v();
                if (v0() && (iDelete = C().delete("upload_queue", G0(), new String[0])) > 0) {
                    l().L().b("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(iDelete));
                }
                if (d().u(g0.P0)) {
                    q1(str);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + "=" + entry.getValue());
        }
        byte[] bArrM = s5Var.m();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", bArrM);
        contentValues.put("upload_uri", str2);
        StringBuilder sb2 = new StringBuilder();
        int size = arrayList.size();
        if (size > 0) {
            sb2.append((CharSequence) arrayList.get(0));
            int i10 = 1;
            while (i10 < size) {
                sb2.append((CharSequence) "\r\n");
                Object obj = arrayList.get(i10);
                i10++;
                sb2.append((CharSequence) obj);
            }
        }
        contentValues.put("upload_headers", sb2.toString());
        contentValues.put("upload_type", Integer.valueOf(c1Var.b()));
        contentValues.put("creation_timestamp", Long.valueOf(c().a()));
        contentValues.put("retry_count", (Integer) 0);
        if (l10 != null) {
            contentValues.put("associated_row_id", l10);
        }
        try {
            long jInsert = C().insert("upload_queue", null, contentValues);
            if (jInsert != -1) {
                return jInsert;
            }
            l().H().b("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
            return jInsert;
        } catch (SQLiteException e10) {
            l().H().c("Error storing MeasurementBatch to upload_queue. appId", str, e10);
            return -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x010e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0114  */
    @WorkerThread
    public final List<tc> N0(String str, String str2, String str3) throws Throwable {
        m mVar;
        String string;
        m1.g.e(str);
        n();
        v();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                ArrayList arrayList2 = new ArrayList(3);
                String str4 = str;
                arrayList2.add(str4);
                StringBuilder sb2 = new StringBuilder("app_id=?");
                if (TextUtils.isEmpty(str2)) {
                    string = str2;
                } else {
                    string = str2;
                    try {
                        arrayList2.add(string);
                        sb2.append(" and origin=?");
                    } catch (SQLiteException e10) {
                        e = e10;
                        mVar = this;
                        mVar.l().H().d("(2)Error querying user properties", p5.w(str), string, e);
                        List<tc> list = Collections.EMPTY_LIST;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return list;
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    arrayList2.add(str3 + "*");
                    sb2.append(" and name glob ?");
                }
                cursorQuery = C().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, sb2.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", "1001");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                while (arrayList.size() < 1000) {
                    String string2 = cursorQuery.getString(0);
                    long j10 = cursorQuery.getLong(1);
                    mVar = this;
                    try {
                        try {
                            Object objR = mVar.R(cursorQuery, 2);
                            string = cursorQuery.getString(3);
                            if (objR == null) {
                                mVar.l().H().d("(2)Read invalid user property value, ignoring it", p5.w(str4), string, str3);
                            } else {
                                arrayList.add(new tc(str4, string, string2, j10, objR));
                            }
                            if (!cursorQuery.moveToNext()) {
                                cursorQuery.close();
                                return arrayList;
                            }
                            str4 = str;
                        } catch (Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e11) {
                        e = e11;
                        mVar.l().H().d("(2)Error querying user properties", p5.w(str), string, e);
                        List<tc> list2 = Collections.EMPTY_LIST;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return list2;
                    }
                }
                l().H().b("Read more than the max allowed user properties, ignoring excess", 1000);
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e12) {
                e = e12;
                mVar = this;
                string = str2;
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final List<Pair<com.google.android.gms.internal.measurement.t5, Long>> U(String str, int i10, int i11) {
        long jU;
        long jU2;
        n();
        v();
        int i12 = 1;
        m1.g.a(i10 > 0);
        m1.g.a(i11 > 0);
        m1.g.e(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = C().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i10));
                if (!cursorQuery.moveToFirst()) {
                    List<Pair<com.google.android.gms.internal.measurement.t5, Long>> list = Collections.EMPTY_LIST;
                    cursorQuery.close();
                    return list;
                }
                ArrayList arrayList = new ArrayList();
                int length = 0;
                while (true) {
                    long j10 = cursorQuery.getLong(0);
                    try {
                        byte[] bArrK0 = o().k0(cursorQuery.getBlob(i12));
                        if (!arrayList.isEmpty() && bArrK0.length + length > i11) {
                            break;
                        }
                        try {
                            com.google.android.gms.internal.measurement.t5.a aVar = (com.google.android.gms.internal.measurement.t5.a) sc.H(com.google.android.gms.internal.measurement.t5.J2(), bArrK0);
                            if (!arrayList.isEmpty()) {
                                com.google.android.gms.internal.measurement.t5 t5Var = (com.google.android.gms.internal.measurement.t5) ((Pair) arrayList.get(0)).first;
                                com.google.android.gms.internal.measurement.t5 t5Var2 = (com.google.android.gms.internal.measurement.t5) ((com.google.android.gms.internal.measurement.ea) aVar.w());
                                if (!t5Var.h0().equals(t5Var2.h0()) || !t5Var.g0().equals(t5Var2.g0()) || t5Var.x0() != t5Var2.x0() || !t5Var.i0().equals(t5Var2.i0())) {
                                    break;
                                }
                                Iterator<com.google.android.gms.internal.measurement.y5> it = t5Var.v0().iterator();
                                while (true) {
                                    jU = -1;
                                    if (!it.hasNext()) {
                                        jU2 = -1;
                                        break;
                                    }
                                    com.google.android.gms.internal.measurement.y5 next = it.next();
                                    if ("_npa".equals(next.a0())) {
                                        jU2 = next.U();
                                        break;
                                    }
                                }
                                for (com.google.android.gms.internal.measurement.y5 y5Var : t5Var2.v0()) {
                                    if ("_npa".equals(y5Var.a0())) {
                                        jU = y5Var.U();
                                        break;
                                    }
                                }
                                if (jU2 != jU) {
                                    break;
                                }
                            }
                            if (!cursorQuery.isNull(2)) {
                                aVar.I0(cursorQuery.getInt(2));
                            }
                            length += bArrK0.length;
                            arrayList.add(Pair.create((com.google.android.gms.internal.measurement.t5) ((com.google.android.gms.internal.measurement.ea) aVar.w()), Long.valueOf(j10)));
                        } catch (IOException e10) {
                            l().H().c("Failed to merge queued bundle. appId", p5.w(str), e10);
                        }
                        if (!cursorQuery.moveToNext() || length > i11) {
                            break;
                        }
                        i12 = 1;
                    } catch (IOException e11) {
                        l().H().c("Failed to unzip queued bundle. appId", p5.w(str), e11);
                    }
                }
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e12) {
                l().H().c("Error querying bundles. appId", p5.w(str), e12);
                List<Pair<com.google.android.gms.internal.measurement.t5, Long>> list2 = Collections.EMPTY_LIST;
                if (0 != 0) {
                    cursor.close();
                }
                return list2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final c0 U0(String str, String str2) {
        return T0("events", str, str2);
    }

    @WorkerThread
    public final x4 V0(String str) {
        Cursor cursorQuery;
        Boolean boolValueOf;
        m1.g.e(str);
        n();
        v();
        Cursor cursor = null;
        try {
            cursorQuery = C().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id", "session_stitching_token", "sgtm_upload_enabled", "target_os_version", "session_stitching_token_hash", "ad_services_version", "unmatched_first_open_without_ad_id", "npa_metadata_value", "attribution_eligibility_status", "sgtm_preview_key", "dma_consent_state", "daily_realtime_dcu_count", "bundle_delivery_index", "serialized_npa_metadata", "unmatched_pfo", "unmatched_uwa", "ad_campaign_info", "client_upload_eligibility"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    x4 x4Var = new x4(this.f4241b.I0(), str);
                    v7 v7VarF0 = this.f4241b.f0(str);
                    v7.a aVar = v7.a.ANALYTICS_STORAGE;
                    if (v7VarF0.m(aVar)) {
                        x4Var.J(cursorQuery.getString(0));
                    }
                    x4Var.a0(cursorQuery.getString(1));
                    if (this.f4241b.f0(str).m(v7.a.AD_STORAGE)) {
                        x4Var.g0(cursorQuery.getString(2));
                    }
                    x4Var.B0(cursorQuery.getLong(3));
                    x4Var.D0(cursorQuery.getLong(4));
                    x4Var.z0(cursorQuery.getLong(5));
                    x4Var.T(cursorQuery.getString(6));
                    x4Var.O(cursorQuery.getString(7));
                    x4Var.v0(cursorQuery.getLong(8));
                    x4Var.o0(cursorQuery.getLong(9));
                    x4Var.K(cursorQuery.isNull(10) || cursorQuery.getInt(10) != 0);
                    x4Var.l0(cursorQuery.getLong(11));
                    x4Var.f0(cursorQuery.getLong(12));
                    x4Var.c0(cursorQuery.getLong(13));
                    x4Var.W(cursorQuery.getLong(14));
                    x4Var.S(cursorQuery.getLong(15));
                    x4Var.t0(cursorQuery.getLong(16));
                    x4Var.H(cursorQuery.isNull(17) ? -2147483648L : cursorQuery.getInt(17));
                    x4Var.X(cursorQuery.getString(18));
                    x4Var.Z(cursorQuery.getLong(19));
                    x4Var.i0(cursorQuery.getLong(20));
                    x4Var.d0(cursorQuery.getString(21));
                    x4Var.h(cursorQuery.isNull(23) || cursorQuery.getInt(23) != 0);
                    x4Var.f(cursorQuery.getString(24));
                    x4Var.r0(cursorQuery.isNull(25) ? 0L : cursorQuery.getLong(25));
                    if (!cursorQuery.isNull(26)) {
                        x4Var.g(Arrays.asList(cursorQuery.getString(26).split(",", -1)));
                    }
                    if (this.f4241b.f0(str).m(aVar)) {
                        x4Var.m0(cursorQuery.getString(28));
                    }
                    x4Var.P((cursorQuery.isNull(29) || cursorQuery.getInt(29) == 0) ? false : true);
                    x4Var.x0(cursorQuery.getLong(39));
                    x4Var.p0(cursorQuery.getString(36));
                    x4Var.H0(cursorQuery.getLong(30));
                    x4Var.F0(cursorQuery.getLong(31));
                    if (ef.a() && d().I(str, g0.V0)) {
                        x4Var.b(cursorQuery.getInt(32));
                        x4Var.N(cursorQuery.getLong(35));
                    }
                    x4Var.U((cursorQuery.isNull(33) || cursorQuery.getInt(33) == 0) ? false : true);
                    if (cursorQuery.isNull(34)) {
                        boolValueOf = null;
                    } else {
                        boolValueOf = Boolean.valueOf(cursorQuery.getInt(34) != 0);
                    }
                    x4Var.d(boolValueOf);
                    x4Var.R(cursorQuery.getInt(37));
                    x4Var.M(cursorQuery.getInt(38));
                    x4Var.j0(cursorQuery.isNull(40) ? "" : (String) m1.g.k(cursorQuery.getString(40)));
                    if (!cursorQuery.isNull(41)) {
                        x4Var.e(Long.valueOf(cursorQuery.getLong(41)));
                    }
                    if (!cursorQuery.isNull(42)) {
                        x4Var.I(Long.valueOf(cursorQuery.getLong(42)));
                    }
                    x4Var.i(cursorQuery.getBlob(43));
                    if (d().I(str, g0.P0) && !cursorQuery.isNull(44)) {
                        x4Var.G(cursorQuery.getInt(44));
                    }
                    x4Var.x();
                    if (cursorQuery.moveToNext()) {
                        l().H().b("Got multiple records for app, expected one. appId", p5.w(str));
                    }
                    cursorQuery.close();
                    return x4Var;
                } catch (SQLiteException e10) {
                    e = e10;
                    l().H().c("Error querying app. appId", p5.w(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        th = th;
        cursor = cursorQuery;
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    @WorkerThread
    public final void Z(c0 c0Var) {
        d0("events", c0Var);
    }

    @WorkerThread
    public final void a0(x4 x4Var, boolean z10, boolean z11) {
        m1.g.k(x4Var);
        n();
        v();
        String strL = x4Var.l();
        m1.g.k(strL);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strL);
        if (z10) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.f4241b.f0(strL).m(v7.a.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", x4Var.m());
        }
        contentValues.put("gmp_app_id", x4Var.q());
        if (this.f4241b.f0(strL).m(v7.a.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", x4Var.s());
        }
        contentValues.put("last_bundle_index", Long.valueOf(x4Var.G0()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(x4Var.I0()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(x4Var.E0()));
        contentValues.put("app_version", x4Var.o());
        contentValues.put("app_store", x4Var.n());
        contentValues.put("gmp_version", Long.valueOf(x4Var.A0()));
        contentValues.put("dev_cert_hash", Long.valueOf(x4Var.u0()));
        contentValues.put("measurement_enabled", Boolean.valueOf(x4Var.A()));
        contentValues.put("day", Long.valueOf(x4Var.s0()));
        contentValues.put("daily_public_events_count", Long.valueOf(x4Var.n0()));
        contentValues.put("daily_events_count", Long.valueOf(x4Var.k0()));
        contentValues.put("daily_conversions_count", Long.valueOf(x4Var.e0()));
        contentValues.put("config_fetched_time", Long.valueOf(x4Var.b0()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(x4Var.y0()));
        contentValues.put("app_version_int", Long.valueOf(x4Var.V()));
        contentValues.put("firebase_instance_id", x4Var.p());
        contentValues.put("daily_error_events_count", Long.valueOf(x4Var.h0()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(x4Var.q0()));
        contentValues.put("health_monitor_sample", x4Var.r());
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(x4Var.z()));
        contentValues.put("admob_app_id", x4Var.j());
        contentValues.put("dynamite_version", Long.valueOf(x4Var.w0()));
        if (this.f4241b.f0(strL).m(v7.a.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", x4Var.u());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(x4Var.C()));
        contentValues.put("target_os_version", Long.valueOf(x4Var.K0()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(x4Var.J0()));
        if (ef.a() && d().I(strL, g0.V0)) {
            contentValues.put("ad_services_version", Integer.valueOf(x4Var.a()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(x4Var.Y()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(x4Var.D()));
        contentValues.put("npa_metadata_value", x4Var.L0());
        contentValues.put("bundle_delivery_index", Long.valueOf(x4Var.C0()));
        contentValues.put("sgtm_preview_key", x4Var.v());
        contentValues.put("dma_consent_state", Integer.valueOf(x4Var.Q()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(x4Var.L()));
        contentValues.put("serialized_npa_metadata", x4Var.t());
        if (d().I(strL, g0.P0)) {
            contentValues.put("client_upload_eligibility", Integer.valueOf(x4Var.F()));
        }
        List<String> listW = x4Var.w();
        if (listW != null) {
            if (listW.isEmpty()) {
                l().M().b("Safelisted events should not be an empty list. appId", strL);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", listW));
            }
        }
        if (fe.a() && d().u(g0.J0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", x4Var.M0());
        contentValues.put("unmatched_uwa", x4Var.N0());
        contentValues.put("ad_campaign_info", x4Var.E());
        try {
            SQLiteDatabase sQLiteDatabaseC = C();
            if (sQLiteDatabaseC.update("apps", contentValues, "app_id = ?", new String[]{strL}) == 0 && sQLiteDatabaseC.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                l().H().b("Failed to insert/update app (got -1). appId", p5.w(strL));
            }
        } catch (SQLiteException e10) {
            l().H().c("Error storing app. appId", p5.w(strL), e10);
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00fa  */
    @WorkerThread
    public final pc e1(String str) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        m1.g.e(str);
        n();
        v();
        Cursor cursor2 = null;
        if (!d().u(g0.M0)) {
            return null;
        }
        if (d().u(g0.P0)) {
            List<pc> listV = V(str, zzpb.J(b2.c1.GOOGLE_SIGNAL), 1);
            if (listV.isEmpty()) {
                return null;
            }
            return listV.get(0);
        }
        try {
            cursorQuery = C().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", "creation_timestamp", "associated_row_id", "last_upload_timestamp"}, "app_id=? AND NOT " + G0(), new String[]{str}, null, null, "creation_timestamp ASC", "1");
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return null;
                }
                cursor = cursorQuery;
                try {
                    pc pcVarQ = Q(str, cursorQuery.getLong(0), cursorQuery.getBlob(2), cursorQuery.getString(3), cursorQuery.getString(4), cursorQuery.getInt(5), cursorQuery.getInt(6), cursorQuery.getLong(7), cursorQuery.getLong(8), cursorQuery.getLong(9));
                    cursor.close();
                    return pcVarQ;
                } catch (SQLiteException e10) {
                    e = e10;
                    cursorQuery = cursor;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e11) {
                e = e11;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
            }
        } catch (SQLiteException e12) {
            e = e12;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            l().H().c("Error to querying MeasurementBatch from upload_queue. appId", str, e);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            cursor2 = cursorQuery;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final void f0(String str, Long l10, String str2, Bundle bundle) {
        com.google.android.gms.internal.measurement.t5 t5VarK0;
        m mVar = this;
        String str3 = str;
        m1.g.k(bundle);
        mVar.n();
        mVar.v();
        r rVar = (!mVar.d().u(g0.f3564f1) || l10 == null) ? new r(mVar, str3) : new r(mVar, str3, l10.longValue());
        List<p> listA = rVar.a();
        while (!listA.isEmpty()) {
            for (p pVar : listA) {
                if (!TextUtils.isEmpty(str2) && (t5VarK0 = mVar.K0(str3, pVar.f3883b)) != null) {
                    Iterator<com.google.android.gms.internal.measurement.y5> it = t5VarK0.v0().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().a0().equals(str2)) {
                            }
                        }
                    }
                }
                sc scVarO = mVar.o();
                com.google.android.gms.internal.measurement.o5 o5Var = pVar.f3885d;
                Bundle bundle2 = new Bundle();
                for (com.google.android.gms.internal.measurement.q5 q5Var : o5Var.b0()) {
                    if (q5Var.f0()) {
                        bundle2.putDouble(q5Var.c0(), q5Var.K());
                    } else if (q5Var.g0()) {
                        bundle2.putFloat(q5Var.c0(), q5Var.S());
                    } else if (q5Var.h0()) {
                        bundle2.putLong(q5Var.c0(), q5Var.Y());
                    } else if (q5Var.j0()) {
                        bundle2.putString(q5Var.c0(), q5Var.d0());
                    } else if (q5Var.e0().isEmpty()) {
                        scVarO.l().H().b("Unexpected parameter type for parameter", q5Var);
                    } else {
                        bundle2.putParcelableArray(q5Var.c0(), sc.j0(q5Var.e0()));
                    }
                }
                String string = bundle2.getString("_o");
                bundle2.remove("_o");
                String strA0 = o5Var.a0();
                if (string == null) {
                    string = "";
                }
                t5 t5Var = new t5(strA0, string, bundle2, o5Var.X());
                mVar.j().O(t5Var.f4056d, bundle);
                mVar.j0(pVar.f3882a, new d0(mVar.f3965a, t5Var.f4054b, str3, pVar.f3885d.a0(), pVar.f3885d.X(), pVar.f3885d.W(), t5Var.f4056d), pVar.f3883b, pVar.f3884c);
                mVar = this;
                str3 = str;
            }
            listA = rVar.a();
            mVar = this;
            str3 = str;
        }
    }

    public final boolean f1(String str, String str2) {
        return J0("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    @WorkerThread
    final void h0(String str, List<com.google.android.gms.internal.measurement.l4> list) {
        boolean z10;
        boolean z11;
        m1.g.k(list);
        for (int i10 = 0; i10 < list.size(); i10++) {
            com.google.android.gms.internal.measurement.l4.a aVarC = list.get(i10).C();
            if (aVarC.v() != 0) {
                for (int i11 = 0; i11 < aVarC.v(); i11++) {
                    com.google.android.gms.internal.measurement.m4.a aVarC2 = aVarC.z(i11).C();
                    com.google.android.gms.internal.measurement.m4.a aVar = (com.google.android.gms.internal.measurement.m4.a) ((com.google.android.gms.internal.measurement.ea.b) aVarC2.clone());
                    String strB = b2.j0.b(aVarC2.A());
                    if (strB != null) {
                        aVar.y(strB);
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    for (int i12 = 0; i12 < aVarC2.v(); i12++) {
                        com.google.android.gms.internal.measurement.n4 n4VarZ = aVarC2.z(i12);
                        String strA = b2.i0.a(n4VarZ.Q());
                        if (strA != null) {
                            aVar.x(i12, (com.google.android.gms.internal.measurement.n4) ((com.google.android.gms.internal.measurement.ea) n4VarZ.C().v(strA).w()));
                            z11 = true;
                        }
                    }
                    if (z11) {
                        com.google.android.gms.internal.measurement.l4.a aVarX = aVarC.x(i11, aVar);
                        list.set(i10, (com.google.android.gms.internal.measurement.l4) ((com.google.android.gms.internal.measurement.ea) aVarX.w()));
                        aVarC = aVarX;
                    }
                }
            }
            if (aVarC.A() != 0) {
                for (int i13 = 0; i13 < aVarC.A(); i13++) {
                    com.google.android.gms.internal.measurement.p4 p4VarC = aVarC.C(i13);
                    String strA2 = b2.l0.a(p4VarC.O());
                    if (strA2 != null) {
                        aVarC = aVarC.y(i13, p4VarC.C().v(strA2));
                        list.set(i10, (com.google.android.gms.internal.measurement.l4) ((com.google.android.gms.internal.measurement.ea) aVarC.w()));
                    }
                }
            }
        }
        v();
        n();
        m1.g.e(str);
        m1.g.k(list);
        SQLiteDatabase sQLiteDatabaseC = C();
        sQLiteDatabaseC.beginTransaction();
        try {
            v();
            n();
            m1.g.e(str);
            SQLiteDatabase sQLiteDatabaseC2 = C();
            sQLiteDatabaseC2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseC2.delete("event_filters", "app_id=?", new String[]{str});
            for (com.google.android.gms.internal.measurement.l4 l4Var : list) {
                v();
                n();
                m1.g.e(str);
                m1.g.k(l4Var);
                if (l4Var.U()) {
                    int iN = l4Var.n();
                    Iterator<com.google.android.gms.internal.measurement.m4> it = l4Var.S().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().Z()) {
                                l().M().c("Event filter with no ID. Audience definition ignored. appId, audienceId", p5.w(str), Integer.valueOf(iN));
                                break;
                            }
                        } else {
                            Iterator<com.google.android.gms.internal.measurement.p4> it2 = l4Var.T().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    Iterator<com.google.android.gms.internal.measurement.m4> it3 = l4Var.S().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!o0(str, iN, it3.next())) {
                                                z10 = false;
                                                break;
                                            }
                                        } else {
                                            z10 = true;
                                            break;
                                        }
                                    }
                                    if (z10) {
                                        Iterator<com.google.android.gms.internal.measurement.p4> it4 = l4Var.T().iterator();
                                        while (it4.hasNext()) {
                                            if (!p0(str, iN, it4.next())) {
                                                z10 = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (!z10) {
                                        v();
                                        n();
                                        m1.g.e(str);
                                        SQLiteDatabase sQLiteDatabaseC3 = C();
                                        sQLiteDatabaseC3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iN)});
                                        sQLiteDatabaseC3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iN)});
                                        break;
                                    }
                                    break;
                                }
                                if (!it2.next().T()) {
                                    l().M().c("Property filter with no ID. Audience definition ignored. appId, audienceId", p5.w(str), Integer.valueOf(iN));
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    l().M().b("Audience with no ID. appId", p5.w(str));
                }
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.internal.measurement.l4 l4Var2 : list) {
                arrayList.add(l4Var2.U() ? Integer.valueOf(l4Var2.n()) : null);
            }
            Q0(str, arrayList);
            sQLiteDatabaseC.setTransactionSuccessful();
        } finally {
            sQLiteDatabaseC.endTransaction();
        }
    }

    public final void m1(String str) {
        c0 c0VarU0;
        h1("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = C().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return;
                }
                do {
                    String string = cursorQuery.getString(0);
                    if (string != null && (c0VarU0 = U0(str, string)) != null) {
                        d0("events_snapshot", c0VarU0);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
            } catch (SQLiteException e10) {
                l().H().c("Error creating snapshot. appId", p5.w(str), e10);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            cursorQuery.close();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ec A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00ee A[ADDED_TO_REGION] */
    public final void n1(String str) throws Throwable {
        boolean z10;
        c0 c0VarT0;
        ArrayList arrayList = new ArrayList(Arrays.asList("name", "lifetime_count"));
        c0 c0VarU0 = U0(str, "_f");
        c0 c0VarU1 = U0(str, "_v");
        h1("events", str);
        boolean z11 = false;
        Cursor cursorQuery = null;
        try {
            cursorQuery = C().query("events_snapshot", (String[]) arrayList.toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                if (c0VarU0 != null) {
                    d0("events", c0VarU0);
                } else if (c0VarU1 != null) {
                    d0("events", c0VarU1);
                }
                h1("events_snapshot", str);
                return;
            }
            boolean z12 = false;
            z10 = false;
            do {
                try {
                    String string = cursorQuery.getString(0);
                    if (cursorQuery.getLong(1) >= 1) {
                        if ("_f".equals(string)) {
                            z12 = true;
                        } else if ("_v".equals(string)) {
                            z10 = true;
                        }
                    }
                    if (string != null && (c0VarT0 = T0("events_snapshot", str, string)) != null) {
                        d0("events", c0VarT0);
                    }
                } catch (SQLiteException e10) {
                    e = e10;
                    z11 = z12;
                    try {
                        l().H().c("Error querying snapshot. appId", p5.w(str), e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (!z11 && c0VarU0 != null) {
                            d0("events", c0VarU0);
                        } else if (!z10 && c0VarU1 != null) {
                            d0("events", c0VarU1);
                        }
                        h1("events_snapshot", str);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (z11 && c0VarU0 != null) {
                            d0("events", c0VarU0);
                        } else if (!z10 && c0VarU1 != null) {
                            d0("events", c0VarU1);
                        }
                        h1("events_snapshot", str);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z11 = z12;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (z11) {
                        if (!z10) {
                            d0("events", c0VarU1);
                        }
                    } else if (!z10) {
                        d0("events", c0VarU1);
                    }
                    h1("events_snapshot", str);
                    throw th;
                }
            } while (cursorQuery.moveToNext());
            cursorQuery.close();
            if (!z12 && c0VarU0 != null) {
                d0("events", c0VarU0);
            } else if (!z10 && c0VarU1 != null) {
                d0("events", c0VarU1);
            }
            h1("events_snapshot", str);
        } catch (SQLiteException e11) {
            e = e11;
            z10 = false;
        } catch (Throwable th3) {
            th = th3;
            z10 = false;
        }
    }

    public final boolean u0() {
        return J0("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final boolean u1() {
        return J0("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean v1() {
        return J0("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final long z() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = C().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return -1L;
                }
                long j10 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j10;
            } catch (SQLiteException e10) {
                l().H().b("Error querying raw events", e10);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    m(gc gcVar) {
        super(gcVar);
        this.f3803e = new sb(c());
        this.f3802d = new t(this, b(), "google_app_measurement.db");
    }

    private final String G0() {
        long jA = c().a();
        Locale locale = Locale.US;
        b2.c1 c1Var = b2.c1.GOOGLE_SIGNAL;
        Integer numValueOf = Integer.valueOf(c1Var.b());
        Long lValueOf = Long.valueOf(jA);
        Long lA = g0.S.a(null);
        lA.longValue();
        return "(" + String.format(locale, "(upload_type = %d AND ABS(creation_timestamp - %d) > %d)", numValueOf, lValueOf, lA) + " OR " + String.format(locale, "(upload_type != %d AND ABS(creation_timestamp - %d) > %d)", Integer.valueOf(c1Var.b()), Long.valueOf(jA), Long.valueOf(i.S())) + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0030  */
    @WorkerThread
    public final long J(String str, String[] strArr, long j10) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = C().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    long j11 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j11;
                }
                cursorRawQuery.close();
                return j10;
            } catch (SQLiteException e10) {
                l().H().c("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        throw th;
    }

    @WorkerThread
    private final long J0(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = C().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e10) {
                l().H().c("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private static String M0(List<Integer> list) {
        if (list.isEmpty()) {
            return "";
        }
        return String.format(" AND (upload_type IN (%s))", TextUtils.join(", ", list));
    }

    private final boolean Q0(String str, List<Integer> list) {
        m1.g.e(str);
        v();
        n();
        SQLiteDatabase sQLiteDatabaseC = C();
        try {
            long jJ0 = J0("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, d().z(str, g0.U)));
            if (jJ0 <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                Integer num = list.get(i10);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            if (sQLiteDatabaseC.delete("audience_filter_values", "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in " + ("(" + TextUtils.join(",", arrayList) + ")") + " order by rowid desc limit -1 offset ?)", new String[]{str, Integer.toString(iMax)}) <= 0) {
                return false;
            }
            return true;
        } catch (SQLiteException e10) {
            l().H().c("Database error querying filters. appId", p5.w(str), e10);
            return false;
        }
    }

    @VisibleForTesting
    @WorkerThread
    private final Object R(Cursor cursor, int i10) {
        int type = cursor.getType(i10);
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type != 4) {
                            l().H().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                            return null;
                        }
                        l().H().a("Loaded invalid blob type value, ignoring it");
                        return null;
                    }
                    return cursor.getString(i10);
                }
                return Double.valueOf(cursor.getDouble(i10));
            }
            return Long.valueOf(cursor.getLong(i10));
        }
        l().H().a("Loaded invalid null value from database");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0030  */
    @WorkerThread
    private final String T(String str, String[] strArr, String str2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = C().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    String string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                    return string;
                }
                cursorRawQuery.close();
                return str2;
            } catch (SQLiteException e10) {
                l().H().c("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        throw th;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x012a  */
    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    private final c0 T0(String str, String str2, String str3) throws Throwable {
        Cursor cursorQuery;
        long j10;
        Long lValueOf;
        Long lValueOf2;
        Long lValueOf3;
        Boolean boolValueOf;
        m1.g.e(str2);
        m1.g.e(str3);
        n();
        v();
        CursorUtil.AnonymousClass2 anonymousClass2 = 0;
        try {
            try {
                boolean z10 = false;
                cursorQuery = C().query(str, (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str2, str3}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    long j11 = cursorQuery.getLong(0);
                    long j12 = cursorQuery.getLong(1);
                    long j13 = cursorQuery.getLong(2);
                    long j14 = 0;
                    if (cursorQuery.isNull(3)) {
                        j10 = 0;
                    } else {
                        j10 = cursorQuery.getLong(3);
                    }
                    if (cursorQuery.isNull(4)) {
                        lValueOf = null;
                    } else {
                        lValueOf = Long.valueOf(cursorQuery.getLong(4));
                    }
                    if (cursorQuery.isNull(5)) {
                        lValueOf2 = null;
                    } else {
                        lValueOf2 = Long.valueOf(cursorQuery.getLong(5));
                    }
                    if (cursorQuery.isNull(6)) {
                        lValueOf3 = null;
                    } else {
                        lValueOf3 = Long.valueOf(cursorQuery.getLong(6));
                    }
                    if (!cursorQuery.isNull(7)) {
                        if (cursorQuery.getLong(7) == 1) {
                            z10 = true;
                        }
                        boolValueOf = Boolean.valueOf(z10);
                    } else {
                        boolValueOf = null;
                    }
                    if (!cursorQuery.isNull(8)) {
                        j14 = cursorQuery.getLong(8);
                    }
                    c0 c0Var = new c0(str2, str3, j11, j12, j14, j13, j10, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                    if (cursorQuery.moveToNext()) {
                        l().H().b("Got multiple records for event aggregates, expected one. appId", p5.w(str2));
                    }
                    cursorQuery.close();
                    return c0Var;
                } catch (SQLiteException e10) {
                    e = e10;
                    l().H().d("Error querying events. appId", p5.w(str2), g().c(str3), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                anonymousClass2 = "current_bundle_count";
                if (anonymousClass2 != 0) {
                    anonymousClass2.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (anonymousClass2 != 0) {
                anonymousClass2.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private static void Y(ContentValues contentValues, String str, Object obj) {
        m1.g.e(str);
        m1.g.k(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    private final void d0(String str, c0 c0Var) {
        Long l10;
        m1.g.k(c0Var);
        n();
        v();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c0Var.f3440a);
        contentValues.put("name", c0Var.f3441b);
        contentValues.put("lifetime_count", Long.valueOf(c0Var.f3442c));
        contentValues.put("current_bundle_count", Long.valueOf(c0Var.f3443d));
        contentValues.put("last_fire_timestamp", Long.valueOf(c0Var.f3445f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(c0Var.f3446g));
        contentValues.put("last_bundled_day", c0Var.f3447h);
        contentValues.put("last_sampled_complex_event_id", c0Var.f3448i);
        contentValues.put("last_sampling_rate", c0Var.f3449j);
        contentValues.put("current_session_count", Long.valueOf(c0Var.f3444e));
        Boolean bool = c0Var.f3450k;
        if (bool != null && bool.booleanValue()) {
            l10 = 1L;
        } else {
            l10 = null;
        }
        contentValues.put("last_exempt_from_sampling", l10);
        try {
            if (C().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                l().H().b("Failed to insert/update event aggregates (got -1). appId", p5.w(c0Var.f3440a));
            }
        } catch (SQLiteException e10) {
            l().H().c("Error storing event aggregates. appId", p5.w(c0Var.f3440a), e10);
        }
    }

    @WorkerThread
    private final void g0(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabaseC = C();
            String asString = contentValues.getAsString(str2);
            if (asString == null) {
                l().I().b("Value of the primary key is not set.", p5.w(str2));
                return;
            }
            if (sQLiteDatabaseC.update(str, contentValues, str2 + " = ?", new String[]{asString}) == 0 && sQLiteDatabaseC.insertWithOnConflict(str, null, contentValues, 5) == -1) {
                l().H().c("Failed to insert/update table (got -1). key", p5.w(str), p5.w(str2));
            }
        } catch (SQLiteException e10) {
            l().H().d("Error storing into table. key", p5.w(str), p5.w(str2), e10);
        }
    }

    private final void h1(String str, String str2) {
        m1.g.e(str2);
        n();
        v();
        try {
            C().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e10) {
            l().H().c("Error deleting snapshot. appId", p5.w(str2), e10);
        }
    }

    private final boolean j0(long j10, d0 d0Var, long j11, boolean z10) {
        n();
        v();
        m1.g.k(d0Var);
        m1.g.e(d0Var.f3472a);
        byte[] bArrM = o().F(d0Var).m();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", d0Var.f3472a);
        contentValues.put("name", d0Var.f3473b);
        contentValues.put("timestamp", Long.valueOf(d0Var.f3475d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j11));
        contentValues.put("data", bArrM);
        contentValues.put("realtime", Integer.valueOf(z10 ? 1 : 0));
        try {
            long jUpdate = C().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j10)});
            if (jUpdate != 1) {
                l().H().c("Failed to update raw event. appId, updatedRows", p5.w(d0Var.f3472a), Long.valueOf(jUpdate));
                return false;
            }
            return true;
        } catch (SQLiteException e10) {
            l().H().c("Error updating raw event. appId", p5.w(d0Var.f3472a), e10);
            return false;
        }
    }

    @WorkerThread
    private final boolean o0(String str, int i10, com.google.android.gms.internal.measurement.m4 m4Var) {
        Integer numValueOf;
        Boolean boolValueOf;
        v();
        n();
        m1.g.e(str);
        m1.g.k(m4Var);
        Integer numValueOf2 = null;
        if (m4Var.S().isEmpty()) {
            r5 r5VarM = l().M();
            Object objW = p5.w(str);
            Integer numValueOf3 = Integer.valueOf(i10);
            if (m4Var.Z()) {
                numValueOf2 = Integer.valueOf(m4Var.N());
            }
            r5VarM.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", objW, numValueOf3, String.valueOf(numValueOf2));
            return false;
        }
        byte[] bArrM = m4Var.m();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i10));
        if (m4Var.Z()) {
            numValueOf = Integer.valueOf(m4Var.N());
        } else {
            numValueOf = null;
        }
        contentValues.put("filter_id", numValueOf);
        contentValues.put("event_name", m4Var.S());
        if (m4Var.a0()) {
            boolValueOf = Boolean.valueOf(m4Var.X());
        } else {
            boolValueOf = null;
        }
        contentValues.put("session_scoped", boolValueOf);
        contentValues.put("data", bArrM);
        try {
            if (C().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                l().H().b("Failed to insert event filter (got -1). appId", p5.w(str));
                return true;
            }
            return true;
        } catch (SQLiteException e10) {
            l().H().c("Error storing event filter. appId", p5.w(str), e10);
            return false;
        }
    }

    @WorkerThread
    private final boolean p0(String str, int i10, com.google.android.gms.internal.measurement.p4 p4Var) {
        Integer numValueOf;
        Boolean boolValueOf;
        v();
        n();
        m1.g.e(str);
        m1.g.k(p4Var);
        Integer numValueOf2 = null;
        if (p4Var.O().isEmpty()) {
            r5 r5VarM = l().M();
            Object objW = p5.w(str);
            Integer numValueOf3 = Integer.valueOf(i10);
            if (p4Var.T()) {
                numValueOf2 = Integer.valueOf(p4Var.n());
            }
            r5VarM.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", objW, numValueOf3, String.valueOf(numValueOf2));
            return false;
        }
        byte[] bArrM = p4Var.m();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i10));
        if (p4Var.T()) {
            numValueOf = Integer.valueOf(p4Var.n());
        } else {
            numValueOf = null;
        }
        contentValues.put("filter_id", numValueOf);
        contentValues.put("property_name", p4Var.O());
        if (p4Var.U()) {
            boolValueOf = Boolean.valueOf(p4Var.S());
        } else {
            boolValueOf = null;
        }
        contentValues.put("session_scoped", boolValueOf);
        contentValues.put("data", bArrM);
        try {
            if (C().insertWithOnConflict("property_filters", null, contentValues, 5) == -1) {
                l().H().b("Failed to insert property filter (got -1). appId", p5.w(str));
                return false;
            }
            return true;
        } catch (SQLiteException e10) {
            l().H().c("Error storing property filter. appId", p5.w(str), e10);
            return false;
        }
    }

    private final int q1(String str) {
        m1.g.e(str);
        n();
        v();
        try {
            int iZ = d().z(str, g0.A);
            if (iZ <= 0) {
                return 0;
            }
            return C().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(iZ)});
        } catch (SQLiteException e10) {
            l().H().c("Error deleting over the limit queued batches. appId", p5.w(str), e10);
            return 0;
        }
    }

    @VisibleForTesting
    @WorkerThread
    final SQLiteDatabase C() {
        n();
        try {
            return this.f3802d.getWritableDatabase();
        } catch (SQLiteException e10) {
            l().M().b("Error opening database", e10);
            throw e10;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x003e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    @WorkerThread
    public final String D() throws Throwable {
        Throwable th;
        Cursor cursorRawQuery;
        ?? C = C();
        try {
            try {
                cursorRawQuery = C.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        String string = cursorRawQuery.getString(0);
                        cursorRawQuery.close();
                        return string;
                    }
                    cursorRawQuery.close();
                    return null;
                } catch (SQLiteException e10) {
                    e = e10;
                    l().H().b("Database error getting next bundle app id", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (C != 0) {
                    C.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorRawQuery = null;
        } catch (Throwable th3) {
            th = th3;
            C = 0;
            if (C != 0) {
                C.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final int E(String str, String str2) {
        m1.g.e(str);
        m1.g.e(str2);
        n();
        v();
        try {
            return C().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            l().H().d("Error deleting conditional property", p5.w(str), g().g(str2), e10);
            return 0;
        }
    }

    public final long F(com.google.android.gms.internal.measurement.t5 t5Var) {
        n();
        v();
        m1.g.k(t5Var);
        m1.g.e(t5Var.c0());
        byte[] bArrM = t5Var.m();
        long jB = o().B(bArrM);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", t5Var.c0());
        contentValues.put("metadata_fingerprint", Long.valueOf(jB));
        contentValues.put("metadata", bArrM);
        try {
            C().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jB;
        } catch (SQLiteException e10) {
            l().H().c("Error storing raw event metadata. appId", p5.w(t5Var.c0()), e10);
            throw e10;
        }
    }

    public final long H(String str) {
        m1.g.e(str);
        n();
        v();
        try {
            return C().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, d().z(str, g0.f3595q))))});
        } catch (SQLiteException e10) {
            l().H().c("Error deleting over the limit events. appId", p5.w(str), e10);
            return 0L;
        }
    }

    public final long H0(String str) {
        m1.g.e(str);
        return J("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x008c  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0031: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:50), block:B:10:0x0031 */
    public final Pair<com.google.android.gms.internal.measurement.o5, Long> K(String str, Long l10) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        n();
        v();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = C().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l10)});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        l().L().a("Main event not found");
                        cursorRawQuery.close();
                        return null;
                    }
                    try {
                        Pair<com.google.android.gms.internal.measurement.o5, Long> pairCreate = Pair.create((com.google.android.gms.internal.measurement.o5) ((com.google.android.gms.internal.measurement.ea) ((com.google.android.gms.internal.measurement.o5.a) sc.H(com.google.android.gms.internal.measurement.o5.Y(), cursorRawQuery.getBlob(0))).w()), Long.valueOf(cursorRawQuery.getLong(1)));
                        cursorRawQuery.close();
                        return pairCreate;
                    } catch (IOException e10) {
                        l().H().d("Failed to merge main event. appId, eventId", p5.w(str), l10, e10);
                        cursorRawQuery.close();
                        return null;
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    l().H().b("Error selecting main event", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e12) {
            e = e12;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final q L(long j10, String str, long j11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        m1.g.e(str);
        n();
        v();
        String[] strArr = {str};
        q qVar = new q();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseC = C();
                Cursor cursorQuery = sQLiteDatabaseC.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    l().M().b("Not updating daily counts, app is not known. appId", p5.w(str));
                    cursorQuery.close();
                    return qVar;
                }
                if (cursorQuery.getLong(0) == j10) {
                    qVar.f3926b = cursorQuery.getLong(1);
                    qVar.f3925a = cursorQuery.getLong(2);
                    qVar.f3927c = cursorQuery.getLong(3);
                    qVar.f3928d = cursorQuery.getLong(4);
                    qVar.f3929e = cursorQuery.getLong(5);
                    qVar.f3930f = cursorQuery.getLong(6);
                    qVar.f3931g = cursorQuery.getLong(7);
                }
                if (z10) {
                    qVar.f3926b += j11;
                }
                if (z11) {
                    qVar.f3925a += j11;
                }
                if (z12) {
                    qVar.f3927c += j11;
                }
                if (z13) {
                    qVar.f3928d += j11;
                }
                if (z14) {
                    qVar.f3929e += j11;
                }
                if (z15) {
                    qVar.f3930f += j11;
                }
                if (z16) {
                    qVar.f3931g += j11;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j10));
                contentValues.put("daily_public_events_count", Long.valueOf(qVar.f3925a));
                contentValues.put("daily_events_count", Long.valueOf(qVar.f3926b));
                contentValues.put("daily_conversions_count", Long.valueOf(qVar.f3927c));
                contentValues.put("daily_error_events_count", Long.valueOf(qVar.f3928d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(qVar.f3929e));
                contentValues.put("daily_realtime_dcu_count", Long.valueOf(qVar.f3930f));
                contentValues.put("daily_registered_triggers_count", Long.valueOf(qVar.f3931g));
                sQLiteDatabaseC.update("apps", contentValues, "app_id=?", strArr);
                cursorQuery.close();
                return qVar;
            } catch (SQLiteException e10) {
                l().H().c("Error updating daily counts. appId", p5.w(str), e10);
                if (0 != 0) {
                    cursor.close();
                }
                return qVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
                throw th;
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0057  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r4v0, types: [long] */
    public final String L0(long j10) throws Throwable {
        Cursor cursorRawQuery;
        n();
        v();
        ?? r10 = 0;
        try {
            try {
                cursorRawQuery = C().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf((long) j10)});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        l().L().a("No expired configs for apps with pending events");
                        cursorRawQuery.close();
                        return null;
                    }
                    String string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                    return string;
                } catch (SQLiteException e10) {
                    e = e10;
                    l().H().b("Error selecting expired configs", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r10 = j10;
                if (r10 != 0) {
                    r10.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r10 != 0) {
                r10.close();
            }
            throw th;
        }
    }

    @WorkerThread
    final void O0(Long l10) {
        String str;
        n();
        v();
        m1.g.k(l10);
        if (!d().u(g0.M0) || !v0()) {
            return;
        }
        if (J0("SELECT COUNT(1) FROM upload_queue WHERE rowid = " + l10 + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
            l().M().a("The number of upload retries exceeds the limit. Will remain unchanged.");
        }
        try {
            SQLiteDatabase sQLiteDatabaseC = C();
            if (d().u(g0.P0)) {
                str = " SET retry_count = retry_count + 1, last_upload_timestamp = " + c().a();
            } else {
                str = " SET retry_count = retry_count + 1 ";
            }
            sQLiteDatabaseC.execSQL("UPDATE upload_queue" + str + " WHERE rowid = " + l10 + " AND retry_count < 2147483647");
        } catch (SQLiteException e10) {
            l().H().b("Error incrementing retry count. error", e10);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00b3  */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0092: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:147), block:B:16:0x0092 */
    @WorkerThread
    public final pc P(long j10) {
        Cursor cursorQuery;
        Cursor cursor;
        Cursor cursor2 = null;
        if (!d().u(g0.P0)) {
            return null;
        }
        n();
        v();
        try {
            try {
                cursorQuery = C().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", "creation_timestamp", "associated_row_id", "last_upload_timestamp"}, "rowId=?", new String[]{String.valueOf(j10)}, null, null, null, "1");
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    pc pcVarQ = Q((String) m1.g.k(cursorQuery.getString(1)), j10, cursorQuery.getBlob(2), cursorQuery.getString(3), cursorQuery.getString(4), cursorQuery.getInt(5), cursorQuery.getInt(6), cursorQuery.getLong(7), cursorQuery.getLong(8), cursorQuery.getLong(9));
                    cursorQuery.close();
                    return pcVarQ;
                } catch (SQLiteException e10) {
                    e = e10;
                    l().H().c("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j10), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final void P0(String str, v7 v7Var) {
        m1.g.k(str);
        m1.g.k(v7Var);
        n();
        v();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", v7Var.v());
        contentValues.put("consent_source", Integer.valueOf(v7Var.b()));
        g0("consent_settings", "app_id", contentValues);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0086  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x002d: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:46), block:B:10:0x002d */
    public final Bundle R0(String str) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        n();
        v();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = C().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        l().L().a("Default event parameters not found");
                        cursorRawQuery.close();
                        return null;
                    }
                    try {
                        com.google.android.gms.internal.measurement.o5 o5Var = (com.google.android.gms.internal.measurement.o5) ((com.google.android.gms.internal.measurement.ea) ((com.google.android.gms.internal.measurement.o5.a) sc.H(com.google.android.gms.internal.measurement.o5.Y(), cursorRawQuery.getBlob(0))).w());
                        o();
                        Bundle bundleC = sc.C(o5Var.b0());
                        cursorRawQuery.close();
                        return bundleC;
                    } catch (IOException e10) {
                        l().H().c("Failed to retrieve default event parameters. appId", p5.w(str), e10);
                        cursorRawQuery.close();
                        return null;
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    l().H().b("Error selecting default event parameters", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e12) {
            e = e12;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0119  */
    @WorkerThread
    public final zzai S0(String str, String str2) throws Throwable {
        String str3;
        Cursor cursorQuery;
        boolean z10;
        m1.g.e(str);
        m1.g.e(str2);
        n();
        v();
        Cursor cursor = null;
        try {
            cursorQuery = C().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    String string = cursorQuery.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    String str4 = string;
                    Object objR = R(cursorQuery, 1);
                    if (cursorQuery.getInt(2) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    String string2 = cursorQuery.getString(3);
                    long j10 = cursorQuery.getLong(4);
                    sc scVarO = o();
                    byte[] blob = cursorQuery.getBlob(5);
                    Parcelable.Creator<zzbj> creator = zzbj.CREATOR;
                    zzbj zzbjVar = (zzbj) scVarO.E(blob, creator);
                    str3 = str2;
                    try {
                        zzai zzaiVar = new zzai(str, str4, new zzpy(str3, cursorQuery.getLong(8), objR, str4), cursorQuery.getLong(6), z10, string2, zzbjVar, j10, (zzbj) o().E(cursorQuery.getBlob(7), creator), cursorQuery.getLong(9), (zzbj) o().E(cursorQuery.getBlob(10), creator));
                        if (cursorQuery.moveToNext()) {
                            l().H().c("Got multiple records for conditional property, expected one", p5.w(str), g().g(str3));
                        }
                        cursorQuery.close();
                        return zzaiVar;
                    } catch (SQLiteException e10) {
                        e = e10;
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    str3 = str2;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e12) {
            e = e12;
            str3 = str2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        l().H().d("Error querying conditional property", p5.w(str), g().g(str3), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    @WorkerThread
    public final List<pc> V(String str, zzpb zzpbVar, int i10) {
        String strValueOf;
        if (!d().u(g0.P0)) {
            return Collections.EMPTY_LIST;
        }
        m1.g.e(str);
        n();
        v();
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseC = C();
                String[] strArr = {"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", "creation_timestamp", "associated_row_id", "last_upload_timestamp"};
                String str2 = "app_id=?" + M0(zzpbVar.f4313a) + " AND NOT " + G0();
                String[] strArr2 = {str};
                if (i10 > 0) {
                    strValueOf = String.valueOf(i10);
                } else {
                    strValueOf = null;
                }
                cursorQuery = sQLiteDatabaseC.query("upload_queue", strArr, str2, strArr2, null, null, "creation_timestamp ASC", strValueOf);
                ArrayList arrayList = new ArrayList();
                while (cursorQuery.moveToNext()) {
                    pc pcVarQ = Q(str, cursorQuery.getLong(0), cursorQuery.getBlob(2), cursorQuery.getString(3), cursorQuery.getString(4), cursorQuery.getInt(5), cursorQuery.getInt(6), cursorQuery.getLong(7), cursorQuery.getLong(8), cursorQuery.getLong(9));
                    if (pcVarQ != null) {
                        arrayList.add(pcVarQ);
                    }
                }
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e10) {
                l().H().c("Error to querying MeasurementBatch from upload_queue. appId", str, e10);
                List<pc> list = Collections.EMPTY_LIST;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return list;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final List<zzai> W(String str, String str2, String str3) {
        m1.g.e(str);
        n();
        v();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb2 = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb2.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + "*");
            sb2.append(" and name glob ?");
        }
        return X(sb2.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code duplicated, block: B:32:0x008b  */
    /* JADX WARN: Code duplicated, block: B:38:? A[SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x005a: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:91), block:B:14:0x0059 */
    @WorkerThread
    public final n W0(String str) {
        Throwable th;
        Cursor cursorQuery;
        Cursor cursor;
        m1.g.e(str);
        n();
        v();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = C().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    byte[] blob = cursorQuery.getBlob(0);
                    String string = cursorQuery.getString(1);
                    String string2 = cursorQuery.getString(2);
                    if (cursorQuery.moveToNext()) {
                        l().H().b("Got multiple records for app config, expected one. appId", p5.w(str));
                    }
                    if (blob == null) {
                        cursorQuery.close();
                        return null;
                    }
                    n nVar = new n(blob, string, string2);
                    cursorQuery.close();
                    return nVar;
                } catch (SQLiteException e10) {
                    e = e10;
                    l().H().c("Error querying remote config. appId", p5.w(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                    throw th;
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
                throw th;
            }
            throw th;
        }
    }

    public final List<zzai> X(String str, String[] strArr) {
        n();
        v();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = C().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                while (arrayList.size() < 1000) {
                    boolean z10 = false;
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    String string3 = cursorQuery.getString(2);
                    Object objR = R(cursorQuery, 3);
                    if (cursorQuery.getInt(4) != 0) {
                        z10 = true;
                    }
                    String string4 = cursorQuery.getString(5);
                    long j10 = cursorQuery.getLong(6);
                    sc scVarO = o();
                    byte[] blob = cursorQuery.getBlob(7);
                    Parcelable.Creator<zzbj> creator = zzbj.CREATOR;
                    zzbj zzbjVar = (zzbj) scVarO.E(blob, creator);
                    long j11 = cursorQuery.getLong(8);
                    zzbj zzbjVar2 = (zzbj) o().E(cursorQuery.getBlob(9), creator);
                    long j12 = cursorQuery.getLong(10);
                    arrayList.add(new zzai(string, string2, new zzpy(string3, j12, objR, string2), j11, z10, string4, zzbjVar, j10, zzbjVar2, cursorQuery.getLong(11), (zzbj) o().E(cursorQuery.getBlob(12), creator)));
                    if (!cursorQuery.moveToNext()) {
                        cursorQuery.close();
                        return arrayList;
                    }
                }
                l().H().b("Read more than the max allowed conditional properties, ignoring extra", 1000);
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e10) {
                l().H().b("Error querying conditional user property value", e10);
                List<zzai> list = Collections.EMPTY_LIST;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return list;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final tc X0(String str, String str2) {
        Throwable th;
        String str3;
        String str4;
        SQLiteException sQLiteException;
        Cursor cursorQuery;
        m1.g.e(str);
        m1.g.e(str2);
        n();
        v();
        Cursor cursor = null;
        try {
            cursorQuery = C().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    long j10 = cursorQuery.getLong(0);
                    Object objR = R(cursorQuery, 1);
                    if (objR == null) {
                        cursorQuery.close();
                        return null;
                    }
                    str3 = str;
                    str4 = str2;
                    try {
                        tc tcVar = new tc(str3, cursorQuery.getString(2), str4, j10, objR);
                        if (cursorQuery.moveToNext()) {
                            l().H().b("Got multiple records for user property, expected one. appId", p5.w(str3));
                        }
                        cursorQuery.close();
                        return tcVar;
                    } catch (SQLiteException e10) {
                        e = e10;
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    str3 = str;
                    str4 = str2;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                    throw th;
                }
                throw th;
            }
            sQLiteException = e;
        } catch (SQLiteException e12) {
            str3 = str;
            str4 = str2;
            sQLiteException = e12;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
        }
        l().H().d("Error querying user property. appId", p5.w(str3), g().g(str4), sQLiteException);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final y Y0(String str) {
        m1.g.k(str);
        n();
        v();
        return y.d(T("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    final Map<Integer, List<com.google.android.gms.internal.measurement.m4>> Z0(String str, String str2) {
        v();
        n();
        m1.g.e(str);
        m1.g.e(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = C().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<com.google.android.gms.internal.measurement.m4>> map = Collections.EMPTY_MAP;
                    cursorQuery.close();
                    return map;
                }
                do {
                    try {
                        com.google.android.gms.internal.measurement.m4 m4Var = (com.google.android.gms.internal.measurement.m4) ((com.google.android.gms.internal.measurement.ea) ((com.google.android.gms.internal.measurement.m4.a) sc.H(com.google.android.gms.internal.measurement.m4.O(), cursorQuery.getBlob(1))).w());
                        int i10 = cursorQuery.getInt(0);
                        List arrayList = (List) arrayMap.get(Integer.valueOf(i10));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap.put(Integer.valueOf(i10), arrayList);
                        }
                        arrayList.add(m4Var);
                    } catch (IOException e10) {
                        l().H().c("Failed to merge filter. appId", p5.w(str), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayMap;
            } catch (SQLiteException e11) {
                l().H().c("Database error querying filters. appId", p5.w(str), e11);
                Map<Integer, List<com.google.android.gms.internal.measurement.m4>> map2 = Collections.EMPTY_MAP;
                if (0 != 0) {
                    cursor.close();
                }
                return map2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
                throw th;
            }
            throw th;
        }
    }

    public final v7 a1(String str) {
        m1.g.k(str);
        n();
        v();
        return v7.p(T("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    @WorkerThread
    public final void b0(Long l10) {
        n();
        v();
        m1.g.k(l10);
        if (d().u(g0.M0)) {
            try {
                if (C().delete("upload_queue", "rowid=?", new String[]{String.valueOf(l10)}) != 1) {
                    l().M().a("Deleted fewer rows from upload_queue than expected");
                }
            } catch (SQLiteException e10) {
                l().H().b("Failed to delete a MeasurementBatch in a upload_queue table", e10);
                throw e10;
            }
        }
    }

    final Map<Integer, List<com.google.android.gms.internal.measurement.p4>> b1(String str, String str2) {
        v();
        n();
        m1.g.e(str);
        m1.g.e(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = C().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<com.google.android.gms.internal.measurement.p4>> map = Collections.EMPTY_MAP;
                    cursorQuery.close();
                    return map;
                }
                do {
                    try {
                        com.google.android.gms.internal.measurement.p4 p4Var = (com.google.android.gms.internal.measurement.p4) ((com.google.android.gms.internal.measurement.ea) ((com.google.android.gms.internal.measurement.p4.a) sc.H(com.google.android.gms.internal.measurement.p4.M(), cursorQuery.getBlob(1))).w());
                        int i10 = cursorQuery.getInt(0);
                        List arrayList = (List) arrayMap.get(Integer.valueOf(i10));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap.put(Integer.valueOf(i10), arrayList);
                        }
                        arrayList.add(p4Var);
                    } catch (IOException e10) {
                        l().H().c("Failed to merge filter", p5.w(str), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayMap;
            } catch (SQLiteException e11) {
                l().H().c("Database error querying filters. appId", p5.w(str), e11);
                Map<Integer, List<com.google.android.gms.internal.measurement.p4>> map2 = Collections.EMPTY_MAP;
                if (0 != 0) {
                    cursor.close();
                }
                return map2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
                throw th;
            }
            throw th;
        }
    }

    public final void c0(String str, y yVar) {
        m1.g.k(str);
        m1.g.k(yVar);
        n();
        v();
        v7 v7VarC1 = c1(str);
        v7 v7Var = v7.f4111c;
        if (v7VarC1 == v7Var) {
            P0(str, v7Var);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", yVar.j());
        g0("consent_settings", "app_id", contentValues);
    }

    public final v7 c1(String str) {
        m1.g.k(str);
        n();
        v();
        v7 v7Var = (v7) S("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new u() { // from class: com.google.android.gms.measurement.internal.o
            @Override // com.google.android.gms.measurement.internal.u
            public final Object a(Cursor cursor) {
                return v7.i(cursor.getString(0), cursor.getInt(1));
            }
        });
        if (v7Var == null) {
            return v7.f4111c;
        }
        return v7Var;
    }

    @WorkerThread
    public final void d1(String str, String str2) {
        m1.g.e(str);
        m1.g.e(str2);
        n();
        v();
        try {
            C().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            l().H().d("Error deleting user property. appId", p5.w(str), g().g(str2), e10);
        }
    }

    public final void e0(String str, v7 v7Var) {
        m1.g.k(str);
        m1.g.k(v7Var);
        n();
        v();
        P0(str, c1(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", v7Var.v());
        g0("consent_settings", "app_id", contentValues);
    }

    public final List<zzow> g1(String str) {
        m1.g.e(str);
        n();
        v();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = C().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, null, null, "rowid", null);
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    arrayList.add(new zzow(string, cursorQuery.getLong(1), cursorQuery.getInt(2)));
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e10) {
                l().H().c("Error querying trigger uris. appId", p5.w(str), e10);
                List<zzow> list = Collections.EMPTY_LIST;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return list;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
                throw th;
            }
            throw th;
        }
    }

    @VisibleForTesting
    @WorkerThread
    final void i0(List<Long> list) {
        n();
        v();
        m1.g.k(list);
        m1.g.m(list.size());
        if (!v0()) {
            return;
        }
        String str = "(" + TextUtils.join(",", list) + ")";
        if (J0("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
            l().M().a("The number of upload retries exceeds the limit. Will remain unchanged.");
        }
        try {
            C().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
        } catch (SQLiteException e10) {
            l().H().b("Error incrementing retry count. error", e10);
        }
    }

    @WorkerThread
    public final List<tc> i1(String str) {
        String str2;
        m1.g.e(str);
        n();
        v();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = C().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                while (true) {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str3 = string2;
                    long j10 = cursorQuery.getLong(2);
                    Object objR = R(cursorQuery, 3);
                    if (objR == null) {
                        l().H().b("Read invalid user property value, ignoring it. appId", p5.w(str));
                        str2 = str;
                    } else {
                        str2 = str;
                        arrayList.add(new tc(str2, str3, string, j10, objR));
                    }
                    try {
                        if (!cursorQuery.moveToNext()) {
                            cursorQuery.close();
                            return arrayList;
                        }
                        str = str2;
                    } catch (SQLiteException e10) {
                        e = e10;
                    }
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                    throw th;
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            str2 = str;
        }
        l().H().c("Error querying user properties. appId", p5.w(str2), e);
        List<tc> list = Collections.EMPTY_LIST;
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return list;
    }

    final Map<Integer, com.google.android.gms.internal.measurement.v5> j1(String str) {
        v();
        n();
        m1.g.e(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = C().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, com.google.android.gms.internal.measurement.v5> map = Collections.EMPTY_MAP;
                    cursorQuery.close();
                    return map;
                }
                ArrayMap arrayMap = new ArrayMap();
                do {
                    int i10 = cursorQuery.getInt(0);
                    try {
                        arrayMap.put(Integer.valueOf(i10), (com.google.android.gms.internal.measurement.v5) ((com.google.android.gms.internal.measurement.ea) ((com.google.android.gms.internal.measurement.v5.a) sc.H(com.google.android.gms.internal.measurement.v5.X(), cursorQuery.getBlob(1))).w()));
                    } catch (IOException e10) {
                        l().H().d("Failed to merge filter results. appId, audienceId, error", p5.w(str), Integer.valueOf(i10), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayMap;
            } catch (SQLiteException e11) {
                l().H().c("Database error querying filter results. appId", p5.w(str), e11);
                Map<Integer, com.google.android.gms.internal.measurement.v5> map2 = Collections.EMPTY_MAP;
                if (0 != 0) {
                    cursor.close();
                }
                return map2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
                throw th;
            }
            throw th;
        }
    }

    @WorkerThread
    public final boolean k0(com.google.android.gms.internal.measurement.t5 t5Var, boolean z10) {
        n();
        v();
        m1.g.k(t5Var);
        m1.g.e(t5Var.c0());
        m1.g.o(t5Var.V0());
        s1();
        long jA = c().a();
        if (t5Var.r2() < jA - i.S() || t5Var.r2() > i.S() + jA) {
            l().M().d("Storing bundle outside of the max uploading time span. appId, now, timestamp", p5.w(t5Var.c0()), Long.valueOf(jA), Long.valueOf(t5Var.r2()));
        }
        try {
            byte[] bArrI0 = o().i0(t5Var.m());
            l().L().b("Saving bundle, size", Integer.valueOf(bArrI0.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", t5Var.c0());
            contentValues.put("bundle_end_timestamp", Long.valueOf(t5Var.r2()));
            contentValues.put("data", bArrI0);
            contentValues.put("has_realtime", Integer.valueOf(z10 ? 1 : 0));
            if (t5Var.c1()) {
                contentValues.put("retry_count", Integer.valueOf(t5Var.M1()));
            }
            try {
                if (C().insert("queue", null, contentValues) == -1) {
                    l().H().b("Failed to insert bundle (got -1). appId", p5.w(t5Var.c0()));
                    return false;
                }
                return true;
            } catch (SQLiteException e10) {
                l().H().c("Error storing bundle. appId", p5.w(t5Var.c0()), e10);
                return false;
            }
        } catch (IOException e11) {
            l().H().c("Data loss. Failed to serialize bundle. appId", p5.w(t5Var.c0()), e11);
            return false;
        }
    }

    final Map<Integer, List<com.google.android.gms.internal.measurement.m4>> k1(String str) {
        m1.g.e(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = C().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<com.google.android.gms.internal.measurement.m4>> map = Collections.EMPTY_MAP;
                    cursorQuery.close();
                    return map;
                }
                do {
                    try {
                        com.google.android.gms.internal.measurement.m4 m4Var = (com.google.android.gms.internal.measurement.m4) ((com.google.android.gms.internal.measurement.ea) ((com.google.android.gms.internal.measurement.m4.a) sc.H(com.google.android.gms.internal.measurement.m4.O(), cursorQuery.getBlob(1))).w());
                        if (m4Var.Y()) {
                            int i10 = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i10));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i10), arrayList);
                            }
                            arrayList.add(m4Var);
                        }
                    } catch (IOException e10) {
                        l().H().c("Failed to merge filter. appId", p5.w(str), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayMap;
            } catch (SQLiteException e11) {
                l().H().c("Database error querying filters. appId", p5.w(str), e11);
                Map<Integer, List<com.google.android.gms.internal.measurement.m4>> map2 = Collections.EMPTY_MAP;
                if (0 != 0) {
                    cursor.close();
                }
                return map2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
                throw th;
            }
            throw th;
        }
    }

    @WorkerThread
    public final boolean l0(zzai zzaiVar) {
        m1.g.k(zzaiVar);
        n();
        v();
        String str = zzaiVar.f4286a;
        m1.g.k(str);
        if (X0(str, zzaiVar.f4288c.f4316b) == null && J0("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzaiVar.f4287b);
        contentValues.put("name", zzaiVar.f4288c.f4316b);
        Y(contentValues, "value", m1.g.k(zzaiVar.f4288c.J()));
        contentValues.put("active", Boolean.valueOf(zzaiVar.f4290e));
        contentValues.put("trigger_event_name", zzaiVar.f4291f);
        contentValues.put("trigger_timeout", Long.valueOf(zzaiVar.f4293h));
        j();
        contentValues.put("timed_out_event", wc.r0(zzaiVar.f4292g));
        contentValues.put("creation_timestamp", Long.valueOf(zzaiVar.f4289d));
        j();
        contentValues.put("triggered_event", wc.r0(zzaiVar.f4294i));
        contentValues.put("triggered_timestamp", Long.valueOf(zzaiVar.f4288c.f4317c));
        contentValues.put("time_to_live", Long.valueOf(zzaiVar.f4295j));
        j();
        contentValues.put("expired_event", wc.r0(zzaiVar.f4296k));
        try {
            if (C().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                l().H().b("Failed to insert/update conditional user property (got -1)", p5.w(str));
                return true;
            }
            return true;
        } catch (SQLiteException e10) {
            l().H().c("Error storing conditional user property", p5.w(str), e10);
            return true;
        }
    }

    final Map<Integer, List<Integer>> l1(String str) {
        v();
        n();
        m1.g.e(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = C().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
                if (!cursorRawQuery.moveToFirst()) {
                    Map<Integer, List<Integer>> map = Collections.EMPTY_MAP;
                    cursorRawQuery.close();
                    return map;
                }
                do {
                    int i10 = cursorRawQuery.getInt(0);
                    List arrayList = (List) arrayMap.get(Integer.valueOf(i10));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        arrayMap.put(Integer.valueOf(i10), arrayList);
                    }
                    arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                } while (cursorRawQuery.moveToNext());
                cursorRawQuery.close();
                return arrayMap;
            } catch (SQLiteException e10) {
                l().H().c("Database error querying scoped filters. appId", p5.w(str), e10);
                Map<Integer, List<Integer>> map2 = Collections.EMPTY_MAP;
                if (0 != 0) {
                    cursor.close();
                }
                return map2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean m0(d0 d0Var, long j10, boolean z10) {
        n();
        v();
        m1.g.k(d0Var);
        m1.g.e(d0Var.f3472a);
        byte[] bArrM = o().F(d0Var).m();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", d0Var.f3472a);
        contentValues.put("name", d0Var.f3473b);
        contentValues.put("timestamp", Long.valueOf(d0Var.f3475d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j10));
        contentValues.put("data", bArrM);
        contentValues.put("realtime", Integer.valueOf(z10 ? 1 : 0));
        try {
            if (C().insert("raw_events", null, contentValues) == -1) {
                l().H().b("Failed to insert raw event (got -1). appId", p5.w(d0Var.f3472a));
                return false;
            }
            return true;
        } catch (SQLiteException e10) {
            l().H().c("Error storing raw event. appId", p5.w(d0Var.f3472a), e10);
            return false;
        }
    }

    @WorkerThread
    public final boolean n0(tc tcVar) {
        m1.g.k(tcVar);
        n();
        v();
        if (X0(tcVar.f4075a, tcVar.f4077c) == null) {
            if (wc.K0(tcVar.f4077c)) {
                if (J0("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{tcVar.f4075a}) >= d().r(tcVar.f4075a, g0.V, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(tcVar.f4077c) && J0("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{tcVar.f4075a, tcVar.f4076b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", tcVar.f4075a);
        contentValues.put("origin", tcVar.f4076b);
        contentValues.put("name", tcVar.f4077c);
        contentValues.put("set_timestamp", Long.valueOf(tcVar.f4078d));
        Y(contentValues, "value", tcVar.f4079e);
        try {
            if (C().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                l().H().b("Failed to insert/update user property (got -1). appId", p5.w(tcVar.f4075a));
                return true;
            }
            return true;
        } catch (SQLiteException e10) {
            l().H().c("Error storing user property. appId", p5.w(tcVar.f4075a), e10);
            return true;
        }
    }

    @WorkerThread
    public final void o1() {
        v();
        C().beginTransaction();
    }

    @WorkerThread
    public final boolean p1(String str) {
        if (!d().u(g0.M0)) {
            return false;
        }
        if (d().u(g0.P0)) {
            b2.c1[] c1VarArr = {b2.c1.GOOGLE_SIGNAL};
            ArrayList arrayList = new ArrayList(1);
            for (int i10 = 0; i10 <= 0; i10++) {
                arrayList.add(Integer.valueOf(c1VarArr[0].b()));
            }
            if (J0("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?" + M0(arrayList) + " AND NOT " + G0(), new String[]{str}) == 0) {
                return false;
            }
            return true;
        }
        if (J0("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=? AND NOT " + G0(), new String[]{str}) == 0) {
            return false;
        }
        return true;
    }

    final boolean q0(String str, long j10) {
        if (!d().u(g0.f3564f1) && c().a() > 15000 + j10) {
            return false;
        }
        try {
            if (J("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j10)}, 0L) > 0 || J("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j10)}, 0L) <= 0) {
                return false;
            }
            return true;
        } catch (SQLiteException e10) {
            l().H().b("Error checking backfill conditions", e10);
            return false;
        }
    }

    final boolean r0(String str, Bundle bundle) {
        n();
        v();
        byte[] bArrM = o().F(new d0(this.f3965a, "", str, "dep", 0L, 0L, bundle)).m();
        l().L().c("Saving default event parameters, appId, data size", g().c(str), Integer.valueOf(bArrM.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrM);
        try {
            if (C().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                l().H().b("Failed to insert default event parameters (got -1). appId", p5.w(str));
                return false;
            }
            return true;
        } catch (SQLiteException e10) {
            l().H().c("Error storing default event parameters. appId", p5.w(str), e10);
            return false;
        }
    }

    @WorkerThread
    public final void r1() {
        v();
        C().endTransaction();
    }

    @WorkerThread
    public final boolean s0(String str, zzow zzowVar) {
        n();
        v();
        m1.g.k(zzowVar);
        m1.g.e(str);
        long jA = c().a();
        long j10 = zzowVar.f4304b;
        f5<Long> f5Var = g0.f3604u0;
        if (j10 < jA - f5Var.a(null).longValue() || zzowVar.f4304b > f5Var.a(null).longValue() + jA) {
            l().M().d("Storing trigger URI outside of the max retention time span. appId, now, timestamp", p5.w(str), Long.valueOf(jA), Long.valueOf(zzowVar.f4304b));
        }
        l().L().a("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzowVar.f4303a);
        contentValues.put("source", Integer.valueOf(zzowVar.f4305c));
        contentValues.put("timestamp_millis", Long.valueOf(zzowVar.f4304b));
        try {
            if (C().insert("trigger_uris", null, contentValues) == -1) {
                l().H().b("Failed to insert trigger URI (got -1). appId", p5.w(str));
                return false;
            }
            return true;
        } catch (SQLiteException e10) {
            l().H().c("Error storing trigger URI. appId", p5.w(str), e10);
            return false;
        }
    }

    @WorkerThread
    final void s1() {
        int iDelete;
        n();
        v();
        if (v0()) {
            long jA = t().f3520e.a();
            long jB = c().b();
            if (Math.abs(jB - jA) > i.T()) {
                t().f3520e.b(jB);
                n();
                v();
                if (v0() && (iDelete = C().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(c().a()), String.valueOf(i.S())})) > 0) {
                    l().L().b("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
                }
            }
        }
    }

    public final boolean t0(String str, Long l10, long j10, com.google.android.gms.internal.measurement.o5 o5Var) {
        n();
        v();
        m1.g.k(o5Var);
        m1.g.e(str);
        m1.g.k(l10);
        byte[] bArrM = o5Var.m();
        l().L().c("Saving complex main event, appId, data size", g().c(str), Integer.valueOf(bArrM.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l10);
        contentValues.put("children_to_process", Long.valueOf(j10));
        contentValues.put("main_event", bArrM);
        try {
            if (C().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                l().H().b("Failed to insert complex main event (got -1). appId", p5.w(str));
                return false;
            }
            return true;
        } catch (SQLiteException e10) {
            l().H().c("Error storing complex main event. appId", p5.w(str), e10);
            return false;
        }
    }

    @WorkerThread
    public final void t1() {
        v();
        C().setTransactionSuccessful();
    }

    @VisibleForTesting
    protected final boolean v0() {
        return b().getDatabasePath("google_app_measurement.db").exists();
    }
}
