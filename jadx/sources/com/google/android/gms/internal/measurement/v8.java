package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class v8 implements Serializable, Iterable<Byte> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v8 f3170a = new h9(ga.f2718b);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d9 f3171b = new g9(null);
    private int zzc = 0;

    public static v8 m(byte[] bArr) {
        return n(bArr, 0, bArr.length);
    }

    public abstract byte e(int i10);

    public abstract boolean equals(Object obj);

    public abstract v8 i(int i10, int i11);

    abstract void o(x8 x8Var);

    abstract byte q(int i10);

    public abstract int r();

    protected abstract int s(int i10, int i11, int i12);

    static {
        new y8();
    }

    static /* synthetic */ int g(byte b10) {
        return b10 & 255;
    }

    static int h(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) >= 0) {
            return i13;
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i10 + " < 0");
        }
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i10 + ", " + i11);
        }
        throw new IndexOutOfBoundsException("End index: " + i11 + " >= " + i12);
    }

    public static v8 k(String str) {
        return new h9(str.getBytes(ga.f2717a));
    }

    public static v8 n(byte[] bArr, int i10, int i11) {
        h(i10, i10 + i11, bArr.length);
        return new h9(f3171b.a(bArr, i10, i11));
    }

    static f9 t(int i10) {
        return new f9(i10, null);
    }

    protected final int f() {
        return this.zzc;
    }

    public final int hashCode() {
        int iS = this.zzc;
        if (iS == 0) {
            int iR = r();
            iS = s(iR, 0, iR);
            if (iS == 0) {
                iS = 1;
            }
            this.zzc = iS;
        }
        return iS;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new z8(this);
    }

    public final String toString() {
        String strA;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        Integer numValueOf = Integer.valueOf(r());
        if (r() <= 50) {
            strA = rc.a(this);
        } else {
            strA = rc.a(i(0, 47)) + "...";
        }
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", hexString, numValueOf, strA);
    }

    v8() {
    }
}
