package x1.f1.lb.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0013¨\u0006\u0015"}, d2 = {"Lx1/f1/lb/util/y0;", "", "<init>", "()V", "Landroid/content/Context;", "paramContext", "", "paramString", "", "Landroid/content/pm/Signature;", "b", "(Landroid/content/Context;Ljava/lang/String;)[Landroid/content/pm/Signature;", "packageName", "c", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "", "paramArrayOfByte", "a", "([B)Ljava/lang/String;", "Ljava/lang/String;", "mySignature", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f21468a = new y0();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String mySignature = "";

    private final Signature[] b(Context paramContext, String paramString) {
        if (paramString != null && paramString.length() != 0) {
            try {
                PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 64);
                if (packageInfo == null) {
                    return null;
                }
                return packageInfo.signatures;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public final String a(byte[] paramArrayOfByte) {
        kotlin.jvm.internal.m.f(paramArrayOfByte, "paramArrayOfByte");
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(paramArrayOfByte);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr2 = new char[bArrDigest.length * 2];
            int i10 = 0;
            for (byte b10 : bArrDigest) {
                int i11 = i10 + 1;
                cArr2[i10] = cArr[(b10 >>> 4) & 15];
                i10 += 2;
                cArr2[i11] = cArr[b10 & 15];
            }
            return new String(cArr2);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public final String c(Context paramContext, String packageName) {
        kotlin.jvm.internal.m.f(paramContext, "paramContext");
        kotlin.jvm.internal.m.f(packageName, "packageName");
        Signature[] signatureArrB = b(paramContext, packageName);
        if (signatureArrB == null || signatureArrB.length == 0) {
            return "";
        }
        byte[] byteArray = signatureArrB[0].toByteArray();
        kotlin.jvm.internal.m.e(byteArray, "toByteArray(...)");
        return a(byteArray);
    }

    private y0() {
    }
}
