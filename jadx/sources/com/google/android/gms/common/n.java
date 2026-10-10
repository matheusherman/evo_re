package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import m1.o0;
import m1.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
abstract class n extends o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2400a;

    abstract byte[] W();

    public final boolean equals(@Nullable Object obj) {
        u1.a aVarE;
        if (obj != null && (obj instanceof y)) {
            try {
                y yVar = (y) obj;
                if (yVar.d() == this.f2400a && (aVarE = yVar.e()) != null) {
                    return Arrays.equals(W(), (byte[]) u1.b.g(aVarE));
                }
                return false;
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
            }
        }
        return false;
    }

    protected static byte[] g(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // m1.y
    public final int d() {
        return this.f2400a;
    }

    public final int hashCode() {
        return this.f2400a;
    }

    protected n(byte[] bArr) {
        boolean z10;
        if (bArr.length == 25) {
            z10 = true;
        } else {
            z10 = false;
        }
        m1.g.a(z10);
        this.f2400a = Arrays.hashCode(bArr);
    }

    @Override // m1.y
    public final u1.a e() {
        return u1.b.W(W());
    }
}
