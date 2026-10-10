package fb;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Charset f10107a = Charset.forName("UTF-8");

    public static void a(int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        throw new ab.a("Expect chunk type:" + Integer.toHexString(i10) + ", but got:" + Integer.toHexString(i11));
    }

    public static String e(ByteBuffer byteBuffer, boolean z10) {
        if (!z10) {
            String strD = a.d(byteBuffer, c(byteBuffer));
            a.g(byteBuffer);
            return strD;
        }
        b(byteBuffer);
        String str = new String(a.c(byteBuffer, b(byteBuffer)), f10107a);
        a.e(byteBuffer);
        return str;
    }

    private static int b(ByteBuffer byteBuffer) {
        short sE = a.e(byteBuffer);
        if ((sE & 128) != 0) {
            return ((sE & 127) << 8) + a.e(byteBuffer);
        }
        return sE;
    }

    private static int c(ByteBuffer byteBuffer) {
        int iG = a.g(byteBuffer);
        if ((32768 & iG) != 0) {
            return ((iG & 32767) << 16) + a.g(byteBuffer);
        }
        return iG;
    }

    public static cb.b d(ByteBuffer byteBuffer, cb.c cVar) {
        a.g(byteBuffer);
        a.e(byteBuffer);
        short sE = a.e(byteBuffer);
        if (sE != 0) {
            if (sE != 1) {
                if (sE != 3) {
                    if (sE != 5) {
                        if (sE != 6) {
                            switch (sE) {
                                case 16:
                                    return cb.b.b(byteBuffer.getInt());
                                case 17:
                                    return cb.b.e(byteBuffer.getInt());
                                case 18:
                                    return cb.b.a(byteBuffer.getInt());
                                default:
                                    switch (sE) {
                                        case 28:
                                        case 30:
                                            return cb.b.i(byteBuffer.getInt(), 8);
                                        case 29:
                                        case 31:
                                            return cb.b.i(byteBuffer.getInt(), 6);
                                        default:
                                            return cb.b.g(byteBuffer.getInt(), sE);
                                    }
                            }
                        }
                        return cb.b.d(byteBuffer.getInt());
                    }
                    return cb.b.c(byteBuffer.getInt());
                }
                int i10 = byteBuffer.getInt();
                if (i10 >= 0) {
                    return cb.b.j(i10, cVar);
                }
                return null;
            }
            return cb.b.h(byteBuffer.getInt());
        }
        return cb.b.f();
    }

    public static cb.c f(ByteBuffer byteBuffer, cb.d dVar) {
        boolean z10;
        long jPosition = byteBuffer.position();
        int iE = dVar.e();
        int[] iArr = new int[iE];
        if (dVar.e() > 0) {
            for (int i10 = 0; i10 < dVar.e(); i10++) {
                iArr[i10] = h.e(a.f(byteBuffer));
            }
        }
        dVar.d();
        if ((dVar.d() & 256) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        long jF = (dVar.f() + jPosition) - ((long) dVar.c());
        a.b(byteBuffer, jF);
        bb.f[] fVarArr = new bb.f[iE];
        for (int i11 = 0; i11 < iE; i11++) {
            fVarArr[i11] = new bb.f(i11, h.b(iArr[i11]) + jF);
        }
        cb.c cVar = new cb.c(dVar.e());
        String strE = null;
        long jB = -1;
        for (int i12 = 0; i12 < iE; i12++) {
            bb.f fVar = fVarArr[i12];
            if (fVar.b() == jB) {
                cVar.b(fVar.a(), strE);
            } else {
                a.b(byteBuffer, fVar.b());
                jB = fVar.b();
                strE = e(byteBuffer, z10);
                cVar.b(fVar.a(), strE);
            }
        }
        dVar.g();
        a.b(byteBuffer, jPosition + ((long) dVar.a()));
        return cVar;
    }

    public static String g(ByteBuffer byteBuffer, int i10) {
        String strD = a.d(byteBuffer, i10);
        for (int i11 = 0; i11 < strD.length(); i11++) {
            if (strD.charAt(i11) == 0) {
                return strD.substring(0, i11);
            }
        }
        return strD;
    }
}
