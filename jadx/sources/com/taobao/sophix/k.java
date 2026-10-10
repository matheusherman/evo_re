package com.taobao.sophix;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f8468a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str, String str2) {
        try {
            return a(str.getBytes("utf-8"), str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(byte[] bArr, String str) {
        if (bArr != null && !TextUtils.isEmpty(str)) {
            try {
                Mac mac = Mac.getInstance("HmacSHA1");
                mac.init(new SecretKeySpec(str.getBytes("utf-8"), "HmacSHA1"));
                char[] cArrA = a(mac.doFinal(bArr));
                if (cArrA != null) {
                    return new String(cArrA);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String a(File file, String str) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        if (file == null || !file.exists() || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                Mac mac = Mac.getInstance("HmacSHA1");
                mac.init(new SecretKeySpec(str.getBytes("utf-8"), "HmacSHA1"));
                byte[] bArr = new byte[8192];
                while (true) {
                    int i10 = bufferedInputStream.read(bArr);
                    if (i10 <= -1) {
                        break;
                    }
                    mac.update(bArr, 0, i10);
                }
                char[] cArrA = a(mac.doFinal());
                if (cArrA != null && cArrA.length > 0) {
                    String str2 = new String(cArrA);
                    i.a(bufferedInputStream);
                    return str2;
                }
                i.a(bufferedInputStream);
            } catch (Exception e10) {
                e = e10;
                try {
                    e.printStackTrace();
                    i.a(bufferedInputStream);
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream2 = bufferedInputStream;
                    bufferedInputStream = bufferedInputStream2;
                    i.a(bufferedInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                i.a(bufferedInputStream);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            bufferedInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = bufferedInputStream2;
            i.a(bufferedInputStream);
            throw th;
        }
        return null;
    }

    private static char[] a(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = f8468a;
            cArr[i10] = cArr2[(b10 & 240) >>> 4];
            i10 += 2;
            cArr[i11] = cArr2[b10 & 15];
        }
        return cArr;
    }
}
