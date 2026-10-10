package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {

    @NonNull
    public static final Parcelable.Creator<DataHolder> CREATOR = new c();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final a f2215k = new b(new String[0], null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f2217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Bundle f2218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CursorWindow[] f2219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f2220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final Bundle f2221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int[] f2222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f2223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f2224i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2225j = true;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            try {
                if (!this.f2224i) {
                    this.f2224i = true;
                    int i10 = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.f2219d;
                        if (i10 >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i10].close();
                        i10++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isClosed() {
        boolean z10;
        synchronized (this) {
            z10 = this.f2224i;
        }
        return z10;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String[] f2226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList f2227b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final HashMap f2228c = new HashMap();
    }

    @Nullable
    public Bundle J() {
        return this.f2221f;
    }

    public int M() {
        return this.f2220e;
    }

    public final void P() {
        this.f2218c = new Bundle();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr = this.f2217b;
            if (i11 >= strArr.length) {
                break;
            }
            this.f2218c.putInt(strArr[i11], i11);
            i11++;
        }
        this.f2222g = new int[this.f2219d.length];
        int numRows = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.f2219d;
            if (i10 >= cursorWindowArr.length) {
                this.f2223h = numRows;
                return;
            }
            this.f2222g[i10] = numRows;
            numRows += this.f2219d[i10].getNumRows() - (numRows - cursorWindowArr[i10].getStartPosition());
            i10++;
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.f2225j && this.f2219d.length > 0 && !isClosed()) {
                close();
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + toString() + ")");
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        String[] strArr = this.f2217b;
        int iA = n1.b.a(parcel);
        n1.b.s(parcel, 1, strArr, false);
        n1.b.u(parcel, 2, this.f2219d, i10, false);
        n1.b.k(parcel, 3, M());
        n1.b.e(parcel, 4, J(), false);
        n1.b.k(parcel, 1000, this.f2216a);
        n1.b.b(parcel, iA);
        if ((i10 & 1) != 0) {
            close();
        }
    }

    DataHolder(int i10, String[] strArr, CursorWindow[] cursorWindowArr, int i11, @Nullable Bundle bundle) {
        this.f2216a = i10;
        this.f2217b = strArr;
        this.f2219d = cursorWindowArr;
        this.f2220e = i11;
        this.f2221f = bundle;
    }
}
