package com.google.android.gms.dynamite;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.DynamiteApi;
import com.stub.StubApp;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class DynamiteModule {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Boolean f2505h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f2506i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f2507j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f2508k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Boolean f2509l;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static m f2514q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static n f2515r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2516a;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ThreadLocal f2510m = new ThreadLocal();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ThreadLocal f2511n = new com.google.android.gms.dynamite.b();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final b.a f2512o = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public static final b f2499b = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public static final b f2500c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public static final b f2501d = new f();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public static final b f2502e = new g();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public static final b f2503f = new h();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public static final b f2504g = new i();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public static final b f2513p = new j();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @DynamiteApi
    public static class DynamiteLoaderClassLoader {

        @NonNull
        public static ClassLoader sClassLoader;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a extends Exception {
        /* synthetic */ a(String str, v1.e eVar) {
            super(str);
        }

        /* synthetic */ a(String str, Throwable th, v1.e eVar) {
            super(str, th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public interface a {
            int a(@NonNull Context context, @NonNull String str, boolean z10);

            int b(@NonNull Context context, @NonNull String str);
        }

        /* JADX INFO: renamed from: com.google.android.gms.dynamite.DynamiteModule$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static class C0046b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2517a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f2518b = 0;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f2519c = 0;
        }

        @NonNull
        C0046b a(@NonNull Context context, @NonNull String str, @NonNull a aVar);
    }

    public static int b(@NonNull Context context, @NonNull String str) {
        return e(context, str, false);
    }

    /* JADX WARN: Code duplicated, block: B:106:0x017e  */
    /* JADX WARN: Code duplicated, block: B:127:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0144: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:325), block:B:93:0x0144 */
    private static int f(Context context, String str, boolean z10, boolean z11) throws Throwable {
        Throwable th;
        Exception exc;
        Cursor cursor;
        MatrixCursor matrixCursor;
        Cursor cursor2 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        try {
            try {
                boolean z12 = true;
                Uri uriBuild = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z10 ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartUptime", String.valueOf(((Long) f2511n.get()).longValue())).build();
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
                boolean z13 = false;
                if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                    matrixCursor = null;
                } else {
                    try {
                        Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uriBuild, null, null, null, null);
                        if (cursorQuery == null) {
                            contentProviderClientAcquireUnstableContentProviderClient.release();
                            matrixCursor = null;
                        } else {
                            try {
                                int count = cursorQuery.getCount();
                                int columnCount = cursorQuery.getColumnCount();
                                matrixCursor = new MatrixCursor(cursorQuery.getColumnNames(), count);
                                for (int i10 = 0; i10 < count; i10++) {
                                    if (!cursorQuery.moveToPosition(i10)) {
                                        throw new RemoteException("Cursor read incomplete (ContentProvider dead?)");
                                    }
                                    Object[] objArr4 = new Object[columnCount];
                                    for (int i11 = 0; i11 < columnCount; i11++) {
                                        int type = cursorQuery.getType(i11);
                                        if (type == 0) {
                                            objArr4[i11] = null;
                                        } else if (type == 1) {
                                            objArr4[i11] = Long.valueOf(cursorQuery.getLong(i11));
                                        } else if (type == 2) {
                                            objArr4[i11] = Double.valueOf(cursorQuery.getDouble(i11));
                                        } else if (type == 3) {
                                            objArr4[i11] = cursorQuery.getString(i11);
                                        } else {
                                            if (type != 4) {
                                                throw new RemoteException("Unknown column type");
                                            }
                                            objArr4[i11] = cursorQuery.getBlob(i11);
                                        }
                                    }
                                    matrixCursor.addRow(objArr4);
                                }
                                cursorQuery.close();
                                contentProviderClientAcquireUnstableContentProviderClient.release();
                            } catch (Throwable th2) {
                                try {
                                    cursorQuery.close();
                                    throw th2;
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                    throw th2;
                                }
                            }
                        }
                    } catch (RemoteException unused) {
                    } catch (Throwable th4) {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                        throw th4;
                    }
                }
                if (matrixCursor != null) {
                    try {
                        if (matrixCursor.moveToFirst()) {
                            int i12 = matrixCursor.getInt(0);
                            if (i12 > 0) {
                                synchronized (DynamiteModule.class) {
                                    try {
                                        f2506i = matrixCursor.getString(2);
                                        int columnIndex = matrixCursor.getColumnIndex("loaderVersion");
                                        if (columnIndex >= 0) {
                                            f2508k = matrixCursor.getInt(columnIndex);
                                        }
                                        int columnIndex2 = matrixCursor.getColumnIndex("disableStandaloneDynamiteLoader2");
                                        if (columnIndex2 >= 0) {
                                            if (matrixCursor.getInt(columnIndex2) == 0) {
                                                z12 = false;
                                            }
                                            f2507j = z12;
                                            z13 = z12;
                                        }
                                    } catch (Throwable th5) {
                                        throw th5;
                                    }
                                }
                                if (i(matrixCursor)) {
                                    matrixCursor = null;
                                }
                            }
                            if (z11 && z13) {
                                throw new a("forcing fallback to container DynamiteLoader impl", objArr2 == true ? 1 : 0);
                            }
                            if (matrixCursor != null) {
                                matrixCursor.close();
                            }
                            return i12;
                        }
                    } catch (Exception e10) {
                        exc = e10;
                        if (exc instanceof a) {
                            throw exc;
                        }
                        throw new a("V2 version check failed: " + exc.getMessage(), exc, objArr == true ? 1 : 0);
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new a("Failed to connect to dynamite module ContentResolver.", objArr3 == true ? 1 : 0);
            } catch (Throwable th6) {
                th = th6;
                cursor2 = cursor;
                if (cursor2 != null) {
                    throw th;
                }
                cursor2.close();
                throw th;
            }
        } catch (Exception e11) {
            exc = e11;
        } catch (Throwable th7) {
            th = th7;
            if (cursor2 != null) {
                throw th;
            }
            cursor2.close();
            throw th;
        }
    }

    private static void h(ClassLoader classLoader) throws a {
        n nVar;
        v1.e eVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder == null) {
                nVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                nVar = iInterfaceQueryLocalInterface instanceof n ? (n) iInterfaceQueryLocalInterface : new n(iBinder);
            }
            f2515r = nVar;
        } catch (ClassNotFoundException e10) {
            e = e10;
            throw new a("Failed to instantiate dynamite loader", e, eVar);
        } catch (IllegalAccessException e11) {
            e = e11;
            throw new a("Failed to instantiate dynamite loader", e, eVar);
        } catch (InstantiationException e12) {
            e = e12;
            throw new a("Failed to instantiate dynamite loader", e, eVar);
        } catch (NoSuchMethodException e13) {
            e = e13;
            throw new a("Failed to instantiate dynamite loader", e, eVar);
        } catch (InvocationTargetException e14) {
            e = e14;
            throw new a("Failed to instantiate dynamite loader", e, eVar);
        }
    }

    public static int a(@NonNull Context context, @NonNull String str) {
        try {
            Class<?> clsLoadClass = StubApp.getOrigApplicationContext(context.getApplicationContext()).getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (m1.f.a(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e10) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e10.getMessage())));
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:117:0x024c  */
    /* JADX WARN: Code duplicated, block: B:118:0x0252  */
    /* JADX WARN: Code duplicated, block: B:121:0x025b  */
    /* JADX WARN: Code duplicated, block: B:126:0x026d A[Catch: all -> 0x0081, TryCatch #1 {all -> 0x0081, blocks: (B:7:0x0044, B:11:0x007b, B:18:0x0087, B:21:0x008d, B:24:0x0095, B:103:0x01ff, B:104:0x020a, B:107:0x020d, B:108:0x020e, B:109:0x0216, B:126:0x026d, B:127:0x0284, B:110:0x0217, B:112:0x0235, B:114:0x0244, B:124:0x0264, B:125:0x026c, B:128:0x0285, B:129:0x02b5), top: B:144:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x008d A[Catch: all -> 0x0081, TRY_LEAVE, TryCatch #1 {all -> 0x0081, blocks: (B:7:0x0044, B:11:0x007b, B:18:0x0087, B:21:0x008d, B:24:0x0095, B:103:0x01ff, B:104:0x020a, B:107:0x020d, B:108:0x020e, B:109:0x0216, B:126:0x026d, B:127:0x0284, B:110:0x0217, B:112:0x0235, B:114:0x0244, B:124:0x0264, B:125:0x026c, B:128:0x0285, B:129:0x02b5), top: B:144:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0093 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x00a0 A[Catch: all -> 0x01f2, TryCatch #2 {, blocks: (B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc), top: B:145:0x009a, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a5 A[Catch: all -> 0x010e, a -> 0x0111, RemoteException -> 0x0114, TRY_ENTER, TryCatch #8 {RemoteException -> 0x0114, a -> 0x0111, all -> 0x010e, blocks: (B:26:0x0099, B:32:0x00a5, B:34:0x00ac, B:35:0x00cc, B:39:0x00d2, B:41:0x00da, B:43:0x00de, B:44:0x00ed, B:52:0x00fa, B:60:0x012a, B:62:0x0132, B:64:0x013a, B:65:0x0143, B:59:0x0117, B:68:0x0146, B:69:0x0147, B:70:0x014f, B:71:0x0150, B:72:0x0158, B:75:0x015b, B:76:0x015c, B:78:0x0180, B:80:0x0187, B:82:0x018f, B:88:0x01c8, B:90:0x01ce, B:91:0x01d7, B:92:0x01df, B:83:0x019e, B:84:0x01a6, B:86:0x01a9, B:87:0x01b9, B:93:0x01e0, B:94:0x01e8, B:95:0x01e9, B:96:0x01f1, B:102:0x01fe, B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc, B:46:0x00f0, B:50:0x00f7, B:36:0x00cd, B:37:0x00cf), top: B:152:0x0099, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ac A[Catch: all -> 0x010e, a -> 0x0111, RemoteException -> 0x0114, TryCatch #8 {RemoteException -> 0x0114, a -> 0x0111, all -> 0x010e, blocks: (B:26:0x0099, B:32:0x00a5, B:34:0x00ac, B:35:0x00cc, B:39:0x00d2, B:41:0x00da, B:43:0x00de, B:44:0x00ed, B:52:0x00fa, B:60:0x012a, B:62:0x0132, B:64:0x013a, B:65:0x0143, B:59:0x0117, B:68:0x0146, B:69:0x0147, B:70:0x014f, B:71:0x0150, B:72:0x0158, B:75:0x015b, B:76:0x015c, B:78:0x0180, B:80:0x0187, B:82:0x018f, B:88:0x01c8, B:90:0x01ce, B:91:0x01d7, B:92:0x01df, B:83:0x019e, B:84:0x01a6, B:86:0x01a9, B:87:0x01b9, B:93:0x01e0, B:94:0x01e8, B:95:0x01e9, B:96:0x01f1, B:102:0x01fe, B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc, B:46:0x00f0, B:50:0x00f7, B:36:0x00cd, B:37:0x00cf), top: B:152:0x0099, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d2 A[Catch: all -> 0x010e, a -> 0x0111, RemoteException -> 0x0114, TRY_ENTER, TryCatch #8 {RemoteException -> 0x0114, a -> 0x0111, all -> 0x010e, blocks: (B:26:0x0099, B:32:0x00a5, B:34:0x00ac, B:35:0x00cc, B:39:0x00d2, B:41:0x00da, B:43:0x00de, B:44:0x00ed, B:52:0x00fa, B:60:0x012a, B:62:0x0132, B:64:0x013a, B:65:0x0143, B:59:0x0117, B:68:0x0146, B:69:0x0147, B:70:0x014f, B:71:0x0150, B:72:0x0158, B:75:0x015b, B:76:0x015c, B:78:0x0180, B:80:0x0187, B:82:0x018f, B:88:0x01c8, B:90:0x01ce, B:91:0x01d7, B:92:0x01df, B:83:0x019e, B:84:0x01a6, B:86:0x01a9, B:87:0x01b9, B:93:0x01e0, B:94:0x01e8, B:95:0x01e9, B:96:0x01f1, B:102:0x01fe, B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc, B:46:0x00f0, B:50:0x00f7, B:36:0x00cd, B:37:0x00cf), top: B:152:0x0099, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0150 A[Catch: all -> 0x010e, a -> 0x0111, RemoteException -> 0x0114, TryCatch #8 {RemoteException -> 0x0114, a -> 0x0111, all -> 0x010e, blocks: (B:26:0x0099, B:32:0x00a5, B:34:0x00ac, B:35:0x00cc, B:39:0x00d2, B:41:0x00da, B:43:0x00de, B:44:0x00ed, B:52:0x00fa, B:60:0x012a, B:62:0x0132, B:64:0x013a, B:65:0x0143, B:59:0x0117, B:68:0x0146, B:69:0x0147, B:70:0x014f, B:71:0x0150, B:72:0x0158, B:75:0x015b, B:76:0x015c, B:78:0x0180, B:80:0x0187, B:82:0x018f, B:88:0x01c8, B:90:0x01ce, B:91:0x01d7, B:92:0x01df, B:83:0x019e, B:84:0x01a6, B:86:0x01a9, B:87:0x01b9, B:93:0x01e0, B:94:0x01e8, B:95:0x01e9, B:96:0x01f1, B:102:0x01fe, B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc, B:46:0x00f0, B:50:0x00f7, B:36:0x00cd, B:37:0x00cf), top: B:152:0x0099, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x015c A[Catch: all -> 0x010e, a -> 0x0111, RemoteException -> 0x0114, TryCatch #8 {RemoteException -> 0x0114, a -> 0x0111, all -> 0x010e, blocks: (B:26:0x0099, B:32:0x00a5, B:34:0x00ac, B:35:0x00cc, B:39:0x00d2, B:41:0x00da, B:43:0x00de, B:44:0x00ed, B:52:0x00fa, B:60:0x012a, B:62:0x0132, B:64:0x013a, B:65:0x0143, B:59:0x0117, B:68:0x0146, B:69:0x0147, B:70:0x014f, B:71:0x0150, B:72:0x0158, B:75:0x015b, B:76:0x015c, B:78:0x0180, B:80:0x0187, B:82:0x018f, B:88:0x01c8, B:90:0x01ce, B:91:0x01d7, B:92:0x01df, B:83:0x019e, B:84:0x01a6, B:86:0x01a9, B:87:0x01b9, B:93:0x01e0, B:94:0x01e8, B:95:0x01e9, B:96:0x01f1, B:102:0x01fe, B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc, B:46:0x00f0, B:50:0x00f7, B:36:0x00cd, B:37:0x00cf), top: B:152:0x0099, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0180 A[Catch: all -> 0x010e, a -> 0x0111, RemoteException -> 0x0114, TryCatch #8 {RemoteException -> 0x0114, a -> 0x0111, all -> 0x010e, blocks: (B:26:0x0099, B:32:0x00a5, B:34:0x00ac, B:35:0x00cc, B:39:0x00d2, B:41:0x00da, B:43:0x00de, B:44:0x00ed, B:52:0x00fa, B:60:0x012a, B:62:0x0132, B:64:0x013a, B:65:0x0143, B:59:0x0117, B:68:0x0146, B:69:0x0147, B:70:0x014f, B:71:0x0150, B:72:0x0158, B:75:0x015b, B:76:0x015c, B:78:0x0180, B:80:0x0187, B:82:0x018f, B:88:0x01c8, B:90:0x01ce, B:91:0x01d7, B:92:0x01df, B:83:0x019e, B:84:0x01a6, B:86:0x01a9, B:87:0x01b9, B:93:0x01e0, B:94:0x01e8, B:95:0x01e9, B:96:0x01f1, B:102:0x01fe, B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc, B:46:0x00f0, B:50:0x00f7, B:36:0x00cd, B:37:0x00cf), top: B:152:0x0099, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0187 A[Catch: all -> 0x010e, a -> 0x0111, RemoteException -> 0x0114, TryCatch #8 {RemoteException -> 0x0114, a -> 0x0111, all -> 0x010e, blocks: (B:26:0x0099, B:32:0x00a5, B:34:0x00ac, B:35:0x00cc, B:39:0x00d2, B:41:0x00da, B:43:0x00de, B:44:0x00ed, B:52:0x00fa, B:60:0x012a, B:62:0x0132, B:64:0x013a, B:65:0x0143, B:59:0x0117, B:68:0x0146, B:69:0x0147, B:70:0x014f, B:71:0x0150, B:72:0x0158, B:75:0x015b, B:76:0x015c, B:78:0x0180, B:80:0x0187, B:82:0x018f, B:88:0x01c8, B:90:0x01ce, B:91:0x01d7, B:92:0x01df, B:83:0x019e, B:84:0x01a6, B:86:0x01a9, B:87:0x01b9, B:93:0x01e0, B:94:0x01e8, B:95:0x01e9, B:96:0x01f1, B:102:0x01fe, B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc, B:46:0x00f0, B:50:0x00f7, B:36:0x00cd, B:37:0x00cf), top: B:152:0x0099, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x018f A[Catch: all -> 0x010e, a -> 0x0111, RemoteException -> 0x0114, TryCatch #8 {RemoteException -> 0x0114, a -> 0x0111, all -> 0x010e, blocks: (B:26:0x0099, B:32:0x00a5, B:34:0x00ac, B:35:0x00cc, B:39:0x00d2, B:41:0x00da, B:43:0x00de, B:44:0x00ed, B:52:0x00fa, B:60:0x012a, B:62:0x0132, B:64:0x013a, B:65:0x0143, B:59:0x0117, B:68:0x0146, B:69:0x0147, B:70:0x014f, B:71:0x0150, B:72:0x0158, B:75:0x015b, B:76:0x015c, B:78:0x0180, B:80:0x0187, B:82:0x018f, B:88:0x01c8, B:90:0x01ce, B:91:0x01d7, B:92:0x01df, B:83:0x019e, B:84:0x01a6, B:86:0x01a9, B:87:0x01b9, B:93:0x01e0, B:94:0x01e8, B:95:0x01e9, B:96:0x01f1, B:102:0x01fe, B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc, B:46:0x00f0, B:50:0x00f7, B:36:0x00cd, B:37:0x00cf), top: B:152:0x0099, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x019e A[Catch: all -> 0x010e, a -> 0x0111, RemoteException -> 0x0114, TryCatch #8 {RemoteException -> 0x0114, a -> 0x0111, all -> 0x010e, blocks: (B:26:0x0099, B:32:0x00a5, B:34:0x00ac, B:35:0x00cc, B:39:0x00d2, B:41:0x00da, B:43:0x00de, B:44:0x00ed, B:52:0x00fa, B:60:0x012a, B:62:0x0132, B:64:0x013a, B:65:0x0143, B:59:0x0117, B:68:0x0146, B:69:0x0147, B:70:0x014f, B:71:0x0150, B:72:0x0158, B:75:0x015b, B:76:0x015c, B:78:0x0180, B:80:0x0187, B:82:0x018f, B:88:0x01c8, B:90:0x01ce, B:91:0x01d7, B:92:0x01df, B:83:0x019e, B:84:0x01a6, B:86:0x01a9, B:87:0x01b9, B:93:0x01e0, B:94:0x01e8, B:95:0x01e9, B:96:0x01f1, B:102:0x01fe, B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc, B:46:0x00f0, B:50:0x00f7, B:36:0x00cd, B:37:0x00cf), top: B:152:0x0099, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x01a9 A[Catch: all -> 0x010e, a -> 0x0111, RemoteException -> 0x0114, TryCatch #8 {RemoteException -> 0x0114, a -> 0x0111, all -> 0x010e, blocks: (B:26:0x0099, B:32:0x00a5, B:34:0x00ac, B:35:0x00cc, B:39:0x00d2, B:41:0x00da, B:43:0x00de, B:44:0x00ed, B:52:0x00fa, B:60:0x012a, B:62:0x0132, B:64:0x013a, B:65:0x0143, B:59:0x0117, B:68:0x0146, B:69:0x0147, B:70:0x014f, B:71:0x0150, B:72:0x0158, B:75:0x015b, B:76:0x015c, B:78:0x0180, B:80:0x0187, B:82:0x018f, B:88:0x01c8, B:90:0x01ce, B:91:0x01d7, B:92:0x01df, B:83:0x019e, B:84:0x01a6, B:86:0x01a9, B:87:0x01b9, B:93:0x01e0, B:94:0x01e8, B:95:0x01e9, B:96:0x01f1, B:102:0x01fe, B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc, B:46:0x00f0, B:50:0x00f7, B:36:0x00cd, B:37:0x00cf), top: B:152:0x0099, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x01b9 A[Catch: all -> 0x010e, a -> 0x0111, RemoteException -> 0x0114, TryCatch #8 {RemoteException -> 0x0114, a -> 0x0111, all -> 0x010e, blocks: (B:26:0x0099, B:32:0x00a5, B:34:0x00ac, B:35:0x00cc, B:39:0x00d2, B:41:0x00da, B:43:0x00de, B:44:0x00ed, B:52:0x00fa, B:60:0x012a, B:62:0x0132, B:64:0x013a, B:65:0x0143, B:59:0x0117, B:68:0x0146, B:69:0x0147, B:70:0x014f, B:71:0x0150, B:72:0x0158, B:75:0x015b, B:76:0x015c, B:78:0x0180, B:80:0x0187, B:82:0x018f, B:88:0x01c8, B:90:0x01ce, B:91:0x01d7, B:92:0x01df, B:83:0x019e, B:84:0x01a6, B:86:0x01a9, B:87:0x01b9, B:93:0x01e0, B:94:0x01e8, B:95:0x01e9, B:96:0x01f1, B:102:0x01fe, B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc, B:46:0x00f0, B:50:0x00f7, B:36:0x00cd, B:37:0x00cf), top: B:152:0x0099, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01ce A[Catch: all -> 0x010e, a -> 0x0111, RemoteException -> 0x0114, TryCatch #8 {RemoteException -> 0x0114, a -> 0x0111, all -> 0x010e, blocks: (B:26:0x0099, B:32:0x00a5, B:34:0x00ac, B:35:0x00cc, B:39:0x00d2, B:41:0x00da, B:43:0x00de, B:44:0x00ed, B:52:0x00fa, B:60:0x012a, B:62:0x0132, B:64:0x013a, B:65:0x0143, B:59:0x0117, B:68:0x0146, B:69:0x0147, B:70:0x014f, B:71:0x0150, B:72:0x0158, B:75:0x015b, B:76:0x015c, B:78:0x0180, B:80:0x0187, B:82:0x018f, B:88:0x01c8, B:90:0x01ce, B:91:0x01d7, B:92:0x01df, B:83:0x019e, B:84:0x01a6, B:86:0x01a9, B:87:0x01b9, B:93:0x01e0, B:94:0x01e8, B:95:0x01e9, B:96:0x01f1, B:102:0x01fe, B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc, B:46:0x00f0, B:50:0x00f7, B:36:0x00cd, B:37:0x00cf), top: B:152:0x0099, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x01d7 A[Catch: all -> 0x010e, a -> 0x0111, RemoteException -> 0x0114, TryCatch #8 {RemoteException -> 0x0114, a -> 0x0111, all -> 0x010e, blocks: (B:26:0x0099, B:32:0x00a5, B:34:0x00ac, B:35:0x00cc, B:39:0x00d2, B:41:0x00da, B:43:0x00de, B:44:0x00ed, B:52:0x00fa, B:60:0x012a, B:62:0x0132, B:64:0x013a, B:65:0x0143, B:59:0x0117, B:68:0x0146, B:69:0x0147, B:70:0x014f, B:71:0x0150, B:72:0x0158, B:75:0x015b, B:76:0x015c, B:78:0x0180, B:80:0x0187, B:82:0x018f, B:88:0x01c8, B:90:0x01ce, B:91:0x01d7, B:92:0x01df, B:83:0x019e, B:84:0x01a6, B:86:0x01a9, B:87:0x01b9, B:93:0x01e0, B:94:0x01e8, B:95:0x01e9, B:96:0x01f1, B:102:0x01fe, B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc, B:46:0x00f0, B:50:0x00f7, B:36:0x00cd, B:37:0x00cf), top: B:152:0x0099, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x01e0 A[Catch: all -> 0x010e, a -> 0x0111, RemoteException -> 0x0114, TryCatch #8 {RemoteException -> 0x0114, a -> 0x0111, all -> 0x010e, blocks: (B:26:0x0099, B:32:0x00a5, B:34:0x00ac, B:35:0x00cc, B:39:0x00d2, B:41:0x00da, B:43:0x00de, B:44:0x00ed, B:52:0x00fa, B:60:0x012a, B:62:0x0132, B:64:0x013a, B:65:0x0143, B:59:0x0117, B:68:0x0146, B:69:0x0147, B:70:0x014f, B:71:0x0150, B:72:0x0158, B:75:0x015b, B:76:0x015c, B:78:0x0180, B:80:0x0187, B:82:0x018f, B:88:0x01c8, B:90:0x01ce, B:91:0x01d7, B:92:0x01df, B:83:0x019e, B:84:0x01a6, B:86:0x01a9, B:87:0x01b9, B:93:0x01e0, B:94:0x01e8, B:95:0x01e9, B:96:0x01f1, B:102:0x01fe, B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc, B:46:0x00f0, B:50:0x00f7, B:36:0x00cd, B:37:0x00cf), top: B:152:0x0099, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x01e9 A[Catch: all -> 0x010e, a -> 0x0111, RemoteException -> 0x0114, TryCatch #8 {RemoteException -> 0x0114, a -> 0x0111, all -> 0x010e, blocks: (B:26:0x0099, B:32:0x00a5, B:34:0x00ac, B:35:0x00cc, B:39:0x00d2, B:41:0x00da, B:43:0x00de, B:44:0x00ed, B:52:0x00fa, B:60:0x012a, B:62:0x0132, B:64:0x013a, B:65:0x0143, B:59:0x0117, B:68:0x0146, B:69:0x0147, B:70:0x014f, B:71:0x0150, B:72:0x0158, B:75:0x015b, B:76:0x015c, B:78:0x0180, B:80:0x0187, B:82:0x018f, B:88:0x01c8, B:90:0x01ce, B:91:0x01d7, B:92:0x01df, B:83:0x019e, B:84:0x01a6, B:86:0x01a9, B:87:0x01b9, B:93:0x01e0, B:94:0x01e8, B:95:0x01e9, B:96:0x01f1, B:102:0x01fe, B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc, B:46:0x00f0, B:50:0x00f7, B:36:0x00cd, B:37:0x00cf), top: B:152:0x0099, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x01f4 A[Catch: all -> 0x01f2, TRY_ENTER, TryCatch #2 {, blocks: (B:27:0x009a, B:29:0x00a0, B:30:0x00a2, B:99:0x01f4, B:100:0x01fc), top: B:145:0x009a, outer: #8 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:126:0x026d, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:34:0x00ac, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:76:0x015c, please report this as an issue */
    @NonNull
    public static DynamiteModule d(@NonNull Context context, @NonNull b bVar, @NonNull String str) throws Throwable {
        long j10;
        DynamiteModule dynamiteModuleG;
        int i10;
        Boolean bool;
        m mVarK;
        int iG;
        u1.a aVarY;
        Object objG;
        DynamiteModule dynamiteModule;
        k kVar;
        n nVar;
        k kVar2;
        boolean z10;
        u1.a aVarG;
        Cursor cursor;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        v1.e eVar = null;
        if (origApplicationContext == null) {
            throw new a("null application Context", null);
        }
        ThreadLocal threadLocal = f2510m;
        k kVar3 = (k) threadLocal.get();
        k kVar4 = new k(null);
        threadLocal.set(kVar4);
        ThreadLocal threadLocal2 = f2511n;
        Long l10 = (Long) threadLocal2.get();
        long jLongValue = l10.longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.uptimeMillis()));
            b.C0046b c0046bA = bVar.a(context, str, f2512o);
            int i11 = c0046bA.f2517a;
            j10 = 0;
            try {
                Log.i("DynamiteModule", "Considering local module " + str + ":" + i11 + " and remote module " + str + ":" + c0046bA.f2518b);
                int i12 = c0046bA.f2519c;
                if (i12 != 0) {
                    if (i12 != -1) {
                        if (i12 == 1 || c0046bA.f2518b != 0) {
                            if (i12 == -1) {
                                dynamiteModuleG = g(origApplicationContext, str);
                            } else {
                                if (i12 == 1) {
                                    throw new a("VersionPolicy returned invalid code:" + i12, null);
                                }
                                try {
                                    i10 = c0046bA.f2518b;
                                    try {
                                        synchronized (DynamiteModule.class) {
                                            if (j(context)) {
                                                throw new a("Remote loading disabled", null);
                                            }
                                            bool = f2505h;
                                        }
                                        if (bool != null) {
                                            throw new a("Failed to determine which loading route to use.", null);
                                        }
                                        if (bool.booleanValue()) {
                                            Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i10);
                                            synchronized (DynamiteModule.class) {
                                                nVar = f2515r;
                                            }
                                            if (nVar != null) {
                                                throw new a("DynamiteLoaderV2 was not cached.", null);
                                            }
                                            kVar2 = (k) threadLocal.get();
                                            if (kVar2 != null || kVar2.f2520a == null) {
                                                throw new a("No result cursor", null);
                                            }
                                            Context origApplicationContext2 = StubApp.getOrigApplicationContext(context.getApplicationContext());
                                            Cursor cursor2 = kVar2.f2520a;
                                            u1.b.W(null);
                                            synchronized (DynamiteModule.class) {
                                                z10 = f2508k >= 2;
                                            }
                                            if (z10) {
                                                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                aVarG = nVar.W(u1.b.W(origApplicationContext2), str, i10, u1.b.W(cursor2));
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                aVarG = nVar.g(u1.b.W(origApplicationContext2), str, i10, u1.b.W(cursor2));
                                            }
                                            Context context2 = (Context) u1.b.g(aVarG);
                                            if (context2 == null) {
                                                throw new a("Failed to get module context", eVar);
                                            }
                                            dynamiteModule = new DynamiteModule(context2);
                                        } else {
                                            Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i10);
                                            mVarK = k(context);
                                            if (mVarK != null) {
                                                throw new a("Failed to create IDynamiteLoader.", null);
                                            }
                                            iG = mVarK.g();
                                            if (iG >= 3) {
                                                kVar = (k) threadLocal.get();
                                                if (kVar != null) {
                                                    throw new a("No cached result cursor holder", null);
                                                }
                                                aVarY = mVarK.Z(u1.b.W(context), str, i10, u1.b.W(kVar.f2520a));
                                            } else if (iG == 2) {
                                                Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                aVarY = mVarK.a0(u1.b.W(context), str, i10);
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                aVarY = mVarK.Y(u1.b.W(context), str, i10);
                                            }
                                            objG = u1.b.g(aVarY);
                                            if (objG != null) {
                                                throw new a("Failed to load remote module.", null);
                                            }
                                            dynamiteModule = new DynamiteModule((Context) objG);
                                        }
                                        dynamiteModuleG = dynamiteModule;
                                    } catch (RemoteException e10) {
                                        throw new a("Failed to load remote module.", e10, null);
                                    } catch (a e11) {
                                        throw e11;
                                    } catch (Throwable th) {
                                        com.google.android.gms.common.util.f.a(context, th);
                                        throw new a("Failed to load remote module.", th, null);
                                    }
                                } catch (a e12) {
                                    Log.w("DynamiteModule", "Failed to load remote module: " + e12.getMessage());
                                    int i13 = c0046bA.f2517a;
                                    if (i13 == 0 || bVar.a(context, str, new l(i13, 0)).f2519c != -1) {
                                        throw new a("Remote load failed. No local fallback found.", e12, null);
                                    }
                                    dynamiteModuleG = g(origApplicationContext, str);
                                }
                            }
                            if (jLongValue == 0) {
                                f2511n.remove();
                            } else {
                                f2511n.set(l10);
                            }
                            cursor = kVar4.f2520a;
                            if (cursor != null) {
                                cursor.close();
                            }
                            f2510m.set(kVar3);
                            return dynamiteModuleG;
                        }
                    } else if (c0046bA.f2517a != 0) {
                        i12 = -1;
                        if (i12 == 1) {
                        }
                        if (i12 == -1) {
                            dynamiteModuleG = g(origApplicationContext, str);
                        } else {
                            if (i12 == 1) {
                                throw new a("VersionPolicy returned invalid code:" + i12, null);
                            }
                            i10 = c0046bA.f2518b;
                            synchronized (DynamiteModule.class) {
                                if (j(context)) {
                                    throw new a("Remote loading disabled", null);
                                }
                                bool = f2505h;
                                if (bool != null) {
                                    throw new a("Failed to determine which loading route to use.", null);
                                }
                                if (bool.booleanValue()) {
                                    Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i10);
                                    synchronized (DynamiteModule.class) {
                                        nVar = f2515r;
                                        if (nVar != null) {
                                            throw new a("DynamiteLoaderV2 was not cached.", null);
                                        }
                                        kVar2 = (k) threadLocal.get();
                                        if (kVar2 != null) {
                                        }
                                        throw new a("No result cursor", null);
                                    }
                                }
                                Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i10);
                                mVarK = k(context);
                                if (mVarK != null) {
                                    throw new a("Failed to create IDynamiteLoader.", null);
                                }
                                iG = mVarK.g();
                                if (iG >= 3) {
                                    kVar = (k) threadLocal.get();
                                    if (kVar != null) {
                                        throw new a("No cached result cursor holder", null);
                                    }
                                    aVarY = mVarK.Z(u1.b.W(context), str, i10, u1.b.W(kVar.f2520a));
                                } else if (iG == 2) {
                                    Log.w("DynamiteModule", "IDynamite loader version = 2");
                                    aVarY = mVarK.a0(u1.b.W(context), str, i10);
                                } else {
                                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                    aVarY = mVarK.Y(u1.b.W(context), str, i10);
                                }
                                objG = u1.b.g(aVarY);
                                if (objG != null) {
                                    throw new a("Failed to load remote module.", null);
                                }
                                dynamiteModule = new DynamiteModule((Context) objG);
                                dynamiteModuleG = dynamiteModule;
                            }
                        }
                        if (jLongValue == 0) {
                            f2511n.remove();
                        } else {
                            f2511n.set(l10);
                        }
                        cursor = kVar4.f2520a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        f2510m.set(kVar3);
                        return dynamiteModuleG;
                    }
                }
                throw new a("No acceptable module " + str + " found. Local version is " + c0046bA.f2517a + " and remote version is " + c0046bA.f2518b + ".", null);
            } catch (Throwable th2) {
                th = th2;
                if (jLongValue == j10) {
                    f2511n.remove();
                } else {
                    f2511n.set(l10);
                }
                Cursor cursor3 = kVar4.f2520a;
                if (cursor3 != null) {
                    cursor3.close();
                }
                f2510m.set(kVar3);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            j10 = 0;
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:143:0x01d0 */
    /* JADX WARN: Code duplicated, block: B:106:0x0181 A[Catch: all -> 0x00f0, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x00f0, blocks: (B:3:0x0002, B:64:0x00e5, B:66:0x00eb, B:74:0x0111, B:102:0x0173, B:106:0x0181, B:124:0x01d6, B:125:0x01d9, B:119:0x01cd, B:72:0x00f6, B:127:0x01db, B:4:0x0003, B:7:0x0009, B:8:0x0029, B:62:0x00e2, B:21:0x004d, B:45:0x00a5, B:48:0x00a8, B:55:0x00c0, B:63:0x00e4, B:61:0x00c6), top: B:136:0x0002, inners: #6, #10 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00b4 A[Catch: all -> 0x003a, TryCatch #11 {all -> 0x003a, blocks: (B:9:0x002a, B:11:0x0036, B:52:0x00bd, B:16:0x003f, B:18:0x0046, B:20:0x004c, B:25:0x0053, B:27:0x0057, B:31:0x0061, B:33:0x0069, B:36:0x0070, B:43:0x009c, B:44:0x00a4, B:39:0x0077, B:41:0x007d, B:42:0x008e, B:47:0x00a7, B:50:0x00aa, B:51:0x00b4, B:17:0x0042), top: B:142:0x002a, inners: #1 }] */
    public static int e(@NonNull Context context, @NonNull String str, boolean z10) {
        Throwable th;
        RemoteException remoteException;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = f2505h;
                Cursor cursor2 = null;
                int iW = 0;
                if (bool == null) {
                    try {
                        Field declaredField = StubApp.getOrigApplicationContext(context.getApplicationContext()).getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            try {
                                ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                                if (classLoader == ClassLoader.getSystemClassLoader()) {
                                    bool = Boolean.FALSE;
                                } else if (classLoader != null) {
                                    try {
                                        h(classLoader);
                                    } catch (a unused) {
                                    }
                                    bool = Boolean.TRUE;
                                } else {
                                    if (!j(context)) {
                                        return 0;
                                    }
                                    if (f2507j) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    } else {
                                        Boolean bool2 = Boolean.TRUE;
                                        if (bool2.equals(null)) {
                                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                                            bool = Boolean.FALSE;
                                        } else {
                                            try {
                                                int iF = f(context, str, z10, true);
                                                String str2 = f2506i;
                                                if (str2 != null && !str2.isEmpty()) {
                                                    ClassLoader classLoaderA = v1.d.a();
                                                    if (classLoaderA == null) {
                                                        if (Build.VERSION.SDK_INT >= 29) {
                                                            v1.b.a();
                                                            String str3 = f2506i;
                                                            m1.g.k(str3);
                                                            classLoaderA = v1.a.a(str3, ClassLoader.getSystemClassLoader());
                                                        } else {
                                                            String str4 = f2506i;
                                                            m1.g.k(str4);
                                                            classLoaderA = new com.google.android.gms.dynamite.a(str4, ClassLoader.getSystemClassLoader());
                                                        }
                                                    }
                                                    h(classLoaderA);
                                                    declaredField.set(null, classLoaderA);
                                                    f2505h = bool2;
                                                    return iF;
                                                }
                                                return iF;
                                            } catch (a unused2) {
                                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                                bool = Boolean.FALSE;
                                            }
                                        }
                                    }
                                }
                                f2505h = bool;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e10) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e10.toString());
                        bool = Boolean.FALSE;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return f(context, str, z10, false);
                    } catch (a e11) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e11.getMessage());
                        return 0;
                    }
                }
                m mVarK = k(context);
                try {
                    if (mVarK != null) {
                        try {
                            int iG = mVarK.g();
                            if (iG >= 3) {
                                k kVar = (k) f2510m.get();
                                if (kVar == null || (cursor = kVar.f2520a) == null) {
                                    Cursor cursor3 = (Cursor) u1.b.g(mVarK.b0(u1.b.W(context), str, z10, ((Long) f2511n.get()).longValue()));
                                    if (cursor3 != null) {
                                        try {
                                            if (cursor3.moveToFirst()) {
                                                int i10 = cursor3.getInt(0);
                                                cursor2 = (i10 <= 0 || !i(cursor3)) ? cursor3 : null;
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                iW = i10;
                                            } else {
                                                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                                if (cursor3 != null) {
                                                    cursor3.close();
                                                }
                                            }
                                        } catch (RemoteException e12) {
                                            remoteException = e12;
                                            cursor2 = cursor3;
                                            Log.w("DynamiteModule", "Failed to retrieve remote module version: " + remoteException.getMessage());
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            cursor2 = cursor3;
                                            if (cursor2 == null) {
                                                throw th;
                                            }
                                            cursor2.close();
                                            throw th;
                                        }
                                    } else {
                                        Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                    }
                                } else {
                                    iW = cursor.getInt(0);
                                }
                            } else if (iG == 2) {
                                Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                iW = mVarK.X(u1.b.W(context), str, z10);
                            } else {
                                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                iW = mVarK.W(u1.b.W(context), str, z10);
                            }
                        } catch (RemoteException e13) {
                            remoteException = e13;
                        }
                    }
                    return iW;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } catch (Throwable th5) {
            com.google.android.gms.common.util.f.a(context, th5);
            throw th5;
        }
    }

    private static boolean i(Cursor cursor) {
        k kVar = (k) f2510m.get();
        if (kVar == null || kVar.f2520a != null) {
            return false;
        }
        kVar.f2520a = cursor;
        return true;
    }

    private static boolean j(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f2509l)) {
            return true;
        }
        boolean z10 = false;
        if (f2509l == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", true != com.google.android.gms.common.util.m.f() ? 0 : 268435456);
            if (com.google.android.gms.common.b.f().h(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z10 = true;
            }
            f2509l = Boolean.valueOf(z10);
            if (z10 && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f2507j = true;
            }
        }
        if (!z10) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z10;
    }

    private static m k(Context context) {
        m mVar;
        synchronized (DynamiteModule.class) {
            m mVar2 = f2514q;
            if (mVar2 != null) {
                return mVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    mVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    mVar = iInterfaceQueryLocalInterface instanceof m ? (m) iInterfaceQueryLocalInterface : new m(iBinder);
                }
                if (mVar != null) {
                    f2514q = mVar;
                    return mVar;
                }
            } catch (Exception e10) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e10.getMessage());
            }
            return null;
        }
    }

    @NonNull
    public IBinder c(@NonNull String str) throws a {
        try {
            return (IBinder) this.f2516a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e10) {
            throw new a("Failed to instantiate module class: ".concat(String.valueOf(str)), e10, null);
        }
    }

    private DynamiteModule(Context context) {
        m1.g.k(context);
        this.f2516a = context;
    }

    private static DynamiteModule g(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }
}
