package h3;

import java.util.Map;
import y3.b0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l implements u {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10808a;

        static {
            int[] iArr = new int[h3.a.values().length];
            f10808a = iArr;
            try {
                iArr[h3.a.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10808a[h3.a.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10808a[h3.a.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10808a[h3.a.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10808a[h3.a.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10808a[h3.a.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10808a[h3.a.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10808a[h3.a.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10808a[h3.a.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10808a[h3.a.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f10808a[h3.a.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f10808a[h3.a.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f10808a[h3.a.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // h3.u
    public p3.b a(String str, h3.a aVar, int i10, int i11, Map<g, ?> map) {
        u lVar;
        switch (a.f10808a[aVar.ordinal()]) {
            case 1:
                lVar = new y3.l();
                break;
            case 2:
                lVar = new b0();
                break;
            case 3:
                lVar = new y3.j();
                break;
            case 4:
                lVar = new y3.u();
                break;
            case 5:
                lVar = new h4.b();
                break;
            case 6:
                lVar = new y3.f();
                break;
            case 7:
                lVar = new y3.h();
                break;
            case 8:
                lVar = new y3.d();
                break;
            case 9:
                lVar = new y3.o();
                break;
            case 10:
                lVar = new c4.d();
                break;
            case 11:
                lVar = new y3.b();
                break;
            case 12:
                lVar = new s3.b();
                break;
            case 13:
                lVar = new i3.c();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + aVar);
        }
        return lVar.a(str, aVar, i10, i11, map);
    }
}
