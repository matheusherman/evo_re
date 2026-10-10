package com.ta.utdid2.device;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import m7.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f8385a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private o7.a f1a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8390d = null;
    private Context mContext;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Pattern f8386b = Pattern.compile("[^0-9a-zA-Z=/+]+");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Object f0a = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8388f = ".UTSystemConfig" + File.separator + "Global";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f8387e = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f8389g = "";

    public static d a(Context context) {
        if (context != null && f8385a == null) {
            synchronized (f0a) {
                try {
                    if (f8385a == null) {
                        f8385a = new d(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8385a;
    }

    private void c(String str) {
        if (m95c(str)) {
            f8387e = 6;
            f.e("UTUtdid", "utdid type:", 6);
            this.f1a.b(str, f8387e);
        }
    }

    public synchronized String getValue() {
        String str = this.f8390d;
        if (str != null) {
            return str;
        }
        return p();
    }

    private static String b(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(m7.e.c(new byte[]{69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93}), mac.getAlgorithm()));
        return n7.a.c(mac.doFinal(bArr), 2);
    }

    private String q() {
        String strC = this.f1a.c();
        if (!m95c(strC)) {
            f.e("UTUtdid", "read utdid is null");
            Log.d("UTUtdid", "read utdid is null");
            return null;
        }
        int iA = this.f1a.a();
        if (iA == 0) {
            f8387e = 1;
        } else {
            f8387e = iA;
        }
        f.e("UTUtdid", "get utdid from sp. type", Integer.valueOf(f8387e));
        return strC;
    }

    public static void setExtendFactor(String str) {
        f8389g = str;
    }

    static void setType(int i10) {
        f8387e = i10;
    }

    private d(Context context) {
        this.f1a = null;
        this.mContext = context;
        j7.a.b().e(context);
        this.f1a = new o7.a(context, f8388f, "Alvin2");
    }

    private String p() {
        String strQ = q();
        if (m95c(strQ)) {
            if (!TextUtils.isEmpty(strQ) && strQ.endsWith("\n")) {
                this.f8390d = strQ.substring(0, strQ.length() - 1);
            } else {
                this.f8390d = strQ;
            }
            return this.f8390d;
        }
        try {
            byte[] bArrA = a();
            if (bArrA != null) {
                String strC = n7.a.c(bArrA, 2);
                this.f8390d = strC;
                f8387e = 6;
                c(strC);
                return this.f8390d;
            }
            return null;
        } catch (Exception e10) {
            f.d("", e10, new Object[0]);
            return null;
        }
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    static boolean m95c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        if (24 == str.length()) {
            return !f8386b.matcher(str).find();
        }
        return false;
    }

    private byte[] a() throws IOException {
        String str;
        f.e("UTUtdid", "generateUtdid");
        Log.d("UTUtdid", "generateUtdid");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNextInt = new Random().nextInt();
        byte[] bArrA = n7.b.a(iCurrentTimeMillis);
        byte[] bArrA2 = n7.b.a(iNextInt);
        byteArrayOutputStream.write(bArrA, 0, 4);
        byteArrayOutputStream.write(bArrA2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = f8389g + n7.c.a(this.mContext);
        } catch (Exception unused) {
            str = f8389g + new Random().nextInt();
        }
        byteArrayOutputStream.write(n7.b.a(n7.d.a(str)), 0, 4);
        byteArrayOutputStream.write(n7.b.a(n7.d.a(b(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }
}
