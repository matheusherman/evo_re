package ub;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tb.c0;
import tb.d;
import tb.q;
import tb.u;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\f\" \u0010\u0013\u001a\u00020\r8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0014"}, d2 = {"Ltb/d;", "", "newline", "", "b", "(Ltb/d;J)Ljava/lang/String;", "Ltb/q;", "options", "", "selectTruncated", "", "c", "(Ltb/d;Ltb/q;Z)I", "", "a", "[B", "()[B", "getHEX_DIGIT_BYTES$annotations", "()V", "HEX_DIGIT_BYTES", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f19465a = c0.a("0123456789abcdef");

    public static final byte[] a() {
        return f19465a;
    }

    public static final String b(d dVar, long j10) throws EOFException {
        m.f(dVar, "<this>");
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (dVar.k(j11) == 13) {
                String strX = dVar.x(j11);
                dVar.skip(2L);
                return strX;
            }
        }
        String strX2 = dVar.x(j10);
        dVar.skip(1L);
        return strX2;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00a5 A[LOOP:0: B:8:0x0026->B:46:0x00a5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a4 A[SYNTHETIC] */
    public static final int c(d dVar, q options, boolean z10) {
        int i10;
        int i11;
        u uVar;
        int i12;
        int i13;
        m.f(dVar, "<this>");
        m.f(options, "options");
        u uVar2 = dVar.head;
        if (uVar2 == null) {
            return z10 ? -2 : -1;
        }
        byte[] bArr = uVar2.data;
        int i14 = uVar2.pos;
        int i15 = uVar2.limit;
        int[] iArrK = options.getTrie();
        u uVar3 = uVar2;
        int i16 = 0;
        int i17 = -1;
        loop0: while (true) {
            int i18 = i16 + 1;
            int i19 = iArrK[i16];
            int i20 = i16 + 2;
            int i21 = iArrK[i18];
            if (i21 != -1) {
                i17 = i21;
            }
            if (uVar3 == null) {
                break;
            }
            if (i19 >= 0) {
                i10 = i14 + 1;
                int i22 = bArr[i14] & 255;
                int i23 = i20 + i19;
                while (i20 != i23) {
                    if (i22 == iArrK[i20]) {
                        i11 = iArrK[i20 + i19];
                        if (i10 == i15) {
                            uVar3 = uVar3.next;
                            m.c(uVar3);
                            i10 = uVar3.pos;
                            bArr = uVar3.data;
                            i15 = uVar3.limit;
                            if (uVar3 == uVar2) {
                                uVar3 = null;
                            }
                        }
                        if (i11 >= 0) {
                            return i11;
                        }
                        i16 = -i11;
                        i14 = i10;
                    } else {
                        i20++;
                    }
                }
                return i17;
            }
            int i24 = i20 + (i19 * (-1));
            while (true) {
                int i25 = i14 + 1;
                int i26 = i20 + 1;
                if ((bArr[i14] & 255) == iArrK[i20]) {
                    boolean z11 = i26 == i24;
                    if (i25 == i15) {
                        m.c(uVar3);
                        u uVar4 = uVar3.next;
                        m.c(uVar4);
                        i13 = uVar4.pos;
                        byte[] bArr2 = uVar4.data;
                        i12 = uVar4.limit;
                        if (uVar4 != uVar2) {
                            uVar = uVar4;
                            bArr = bArr2;
                        } else {
                            if (!z11) {
                                break loop0;
                            }
                            bArr = bArr2;
                            uVar = null;
                        }
                    } else {
                        uVar = uVar3;
                        i12 = i15;
                        i13 = i25;
                    }
                    if (z11) {
                        i11 = iArrK[i26];
                        i10 = i13;
                        i15 = i12;
                        uVar3 = uVar;
                        break;
                    }
                    i14 = i13;
                    i15 = i12;
                    uVar3 = uVar;
                    i20 = i26;
                }
                return i17;
            }
            if (i11 >= 0) {
                return i11;
            }
            i16 = -i11;
            i14 = i10;
        }
        if (z10) {
            return -2;
        }
        return i17;
    }

    public static /* synthetic */ int d(d dVar, q qVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return c(dVar, qVar, z10);
    }
}
