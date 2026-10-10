package w6;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q6.b f20089a = q6.c.d(a.class);

    public static String d(String str) {
        try {
            return b.a(e(str), true);
        } catch (Exception e10) {
            f20089a.error("generateKey failed.", e10);
            return "";
        }
    }

    static {
        Security.addProvider(new dd.a());
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/ZeroBytePadding");
            cipher.init(1, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String b(String str, String str2) {
        return b.a(a(str.getBytes("UTF-8"), c(str2)), true);
    }

    public static byte[] e(String str) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(str.getBytes("UTF-8"));
        keyGenerator.init(128, secureRandom);
        return keyGenerator.generateKey().getEncoded();
    }

    public static byte[] c(String str) {
        try {
            return b.b(str);
        } catch (Exception e10) {
            f20089a.error("generateKey failed.", e10);
            return new byte[0];
        }
    }
}
