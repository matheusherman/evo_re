package com.live.evo.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.net.MailTo;
import androidx.core.view.ViewCompat;
import com.stub.StubApp;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e1.a f7195b;

    private Bitmap c(String str, h3.a aVar, int i10, int i11) {
        if (str == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(h3.g.class);
        enumMap.put(h3.g.CHARACTER_SET, Charset.forName("UTF-8").name());
        enumMap.put(h3.g.MARGIN, Integer.valueOf(this.f7195b.l()));
        try {
            p3.b bVarA = new h3.l().a(str, aVar, i11, i11, enumMap);
            int iN = bVarA.n();
            int iK = bVarA.k();
            int[] iArr = new int[iN * iK];
            for (int i12 = 0; i12 < iK; i12++) {
                int i13 = i12 * iN;
                for (int i14 = 0; i14 < iN; i14++) {
                    if (bVarA.h(i14, i12)) {
                        int[] iArrG = this.f7195b.g();
                        if (iArrG != null) {
                            int i15 = i11 / 2;
                            if (i14 < i15 && i12 < i15) {
                                iArr[(i12 * i11) + i14] = iArrG[0];
                            } else if (i14 < i15 && i12 > i15) {
                                iArr[(i12 * i11) + i14] = iArrG[1];
                            } else if (i14 <= i15 || i12 <= i15) {
                                iArr[(i12 * i11) + i14] = iArrG[3];
                            } else {
                                iArr[(i12 * i11) + i14] = iArrG[2];
                            }
                        } else {
                            iArr[i13 + i14] = i10;
                        }
                    } else {
                        int iO = this.f7195b.o();
                        int i16 = i13 + i14;
                        if (iO == 0) {
                            iO = -1;
                        }
                        iArr[i16] = iO;
                    }
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iN, iK, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, iN, 0, 0, iN, iK);
            return bitmapCreateBitmap;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private Bitmap d(String str, h3.a aVar, int i10, int i11, Bitmap bitmap, int i12) {
        Bitmap bitmapCreateBitmap = null;
        if (str == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(h3.g.class);
        enumMap.put(h3.g.CHARACTER_SET, Charset.forName("UTF-8").name());
        enumMap.put(h3.g.ERROR_CORRECTION, i4.f.H);
        enumMap.put(h3.g.MARGIN, Integer.valueOf(this.f7195b.l()));
        try {
            p3.b bVarA = new h3.l().a(str, aVar, i11, i11, enumMap);
            int iN = bVarA.n();
            int iK = bVarA.k();
            int i13 = iN / 2;
            int i14 = iK / 2;
            int[] iArr = new int[iN * iK];
            for (int i15 = 0; i15 < iK; i15++) {
                int i16 = i15 * iN;
                for (int i17 = 0; i17 < iN; i17++) {
                    if (i17 > i13 - i12 && i17 < i13 + i12 && i15 > i14 - i12 && i15 < i14 + i12) {
                        iArr[i16 + i17] = bitmap.getPixel((i17 - i13) + i12, (i15 - i14) + i12);
                    } else if (bVarA.h(i17, i15)) {
                        int[] iArrG = this.f7195b.g();
                        if (iArrG != null) {
                            int i18 = i11 / 2;
                            if (i17 < i18 && i15 < i18) {
                                iArr[(i15 * i11) + i17] = iArrG[0];
                            } else if (i17 < i18 && i15 > i18) {
                                iArr[(i15 * i11) + i17] = iArrG[1];
                            } else if (i17 <= i18 || i15 <= i18) {
                                iArr[(i15 * i11) + i17] = iArrG[3];
                            } else {
                                iArr[(i15 * i11) + i17] = iArrG[2];
                            }
                        } else {
                            iArr[i16 + i17] = i10;
                        }
                    } else {
                        int iO = this.f7195b.o();
                        int i19 = i16 + i17;
                        if (iO == 0) {
                            iO = -1;
                        }
                        iArr[i19] = iO;
                    }
                }
            }
            bitmapCreateBitmap = Bitmap.createBitmap(iN, iK, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, iN, 0, 0, iN, iK);
            if (this.f7195b.n() != null) {
                return a(bitmapCreateBitmap, this.f7195b.n());
            }
        } catch (IllegalArgumentException unused) {
        }
        return bitmapCreateBitmap;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7196a;

        static {
            int[] iArr = new int[o3.a.values().length];
            f7196a = iArr;
            try {
                iArr[o3.a.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7196a[o3.a.CALENDAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7196a[o3.a.ISBN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7196a[o3.a.PRODUCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7196a[o3.a.VIN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7196a[o3.a.URI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7196a[o3.a.TEXT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7196a[o3.a.EMAIL_ADDRESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7196a[o3.a.TEL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7196a[o3.a.SMS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7196a[o3.a.ADDRESSBOOK.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f7196a[o3.a.GEO.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private void f(e1.a aVar) {
        switch (a.f7196a[aVar.m().ordinal()]) {
            case 1:
                this.f7195b.u(aVar.h());
                break;
            case 2:
                this.f7195b.u(aVar.h());
                break;
            case 3:
                this.f7195b.u(aVar.h());
                break;
            case 4:
                this.f7195b.u(aVar.h());
                break;
            case 5:
                this.f7195b.u(aVar.h());
                break;
            case 6:
                this.f7195b.u(aVar.h());
                break;
            case 7:
                this.f7195b.u(aVar.h());
                break;
            case 8:
                this.f7195b.u(MailTo.MAILTO_SCHEME + aVar.h());
                break;
            case 9:
                this.f7195b.u("tel:" + aVar.h());
                break;
            case 10:
                this.f7195b.u("sms:" + aVar.h());
                break;
            case 11:
                Uri uriC = aVar.c();
                Bundle bundleB = uriC != null ? new v0().b(this.f7194a, uriC) : null;
                if ((bundleB != null && bundleB.isEmpty()) || bundleB == null) {
                    bundleB = aVar.e();
                }
                if (bundleB != null) {
                    String string = bundleB.getString("name");
                    String string2 = bundleB.getString("company");
                    String string3 = bundleB.getString("postal");
                    List<String> listG = g(bundleB, v0.f7369a);
                    List<String> listG2 = g(bundleB, v0.f7370b);
                    List<String> listG3 = g(bundleB, v0.f7371c);
                    String string4 = bundleB.getString("URL_KEY");
                    String[] strArrC = (aVar.q() ? new y1() : new p0()).c(Collections.singletonList(string), string2, Collections.singletonList(string3), listG, listG2, listG3, string4 != null ? Collections.singletonList(string4) : null, bundleB.getString("NOTE_KEY"));
                    if (!strArrC[1].isEmpty()) {
                        this.f7195b.u(strArrC[0]);
                    }
                }
                break;
            case 12:
                Bundle bundleE = aVar.e();
                if (bundleE != null) {
                    float f10 = bundleE.getFloat("LAT", Float.MAX_VALUE);
                    float f11 = bundleE.getFloat("LONG", Float.MAX_VALUE);
                    if (f10 != Float.MAX_VALUE && f11 != Float.MAX_VALUE) {
                        this.f7195b.u("geo:" + f10 + ',' + f11);
                        break;
                    }
                }
                break;
        }
    }

    private static List<String> g(Bundle bundle, String[] strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            Object obj = bundle.get(str);
            arrayList.add(obj == null ? null : obj.toString());
        }
        return arrayList;
    }

    private static int h(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i10 = point.x;
        int i11 = point.y;
        if (i10 >= i11) {
            i10 = i11;
        }
        return (i10 * 7) / 8;
    }

    Bitmap b() {
        String strI = this.f7195b.i();
        h3.a aVarD = this.f7195b.d();
        int iF = this.f7195b.f();
        int iP = this.f7195b.p();
        Bitmap bitmapJ = this.f7195b.j();
        return bitmapJ != null ? d(strI, aVarD, iF, iP, bitmapJ, this.f7195b.k()) : c(strI, aVarD, iF, iP);
    }

    d1(e1.a aVar, Context context) {
        this.f7194a = context;
        this.f7195b = aVar;
        if (aVar.f() == 0) {
            this.f7195b.s(ViewCompat.MEASURED_STATE_MASK);
        }
        if (this.f7195b.p() == 0) {
            this.f7195b.y(h(StubApp.getOrigApplicationContext(context.getApplicationContext())));
        }
        Bitmap bitmapJ = this.f7195b.j();
        if (bitmapJ != null) {
            int iMin = Math.min(bitmapJ.getWidth(), bitmapJ.getHeight()) / 2;
            if (this.f7195b.k() > 0 && this.f7195b.k() < iMin) {
                iMin = this.f7195b.k();
            }
            this.f7195b.v(bitmapJ, iMin);
        }
        e(aVar);
    }

    private static Bitmap a(Bitmap bitmap, Bitmap bitmap2) {
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap, (width - width2) / 2, (height - height2) / 2, (Paint) null);
        canvas.save();
        canvas.restore();
        return bitmapCreateBitmap;
    }

    private void e(e1.a aVar) {
        if (aVar.d() != null && aVar.d() != h3.a.QR_CODE) {
            return;
        }
        aVar.r(h3.a.QR_CODE);
        f(aVar);
    }
}
