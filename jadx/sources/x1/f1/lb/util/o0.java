package x1.f1.lb.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ%\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0018\u0010\u0017R\u001c\u0010\u001c\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001d¨\u0006\u001e"}, d2 = {"Lx1/f1/lb/util/o0;", "", "<init>", "()V", "", "data", "key", "", "b", "([B[B)Ljava/lang/String;", "d", "([B[B)[B", "Lx1/f1/lb/util/o0$a;", "base64", "Lr8/z;", "f", "(Lx1/f1/lb/util/o0$a;)V", "keyString", "g", "(Ljava/lang/String;)[B", "e", "(Ljava/lang/String;)Ljava/lang/String;", "a", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "c", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Lx1/f1/lb/util/o0$a;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f21433a = new o0();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(x1.f1.lb.util.a.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static a base64 = new b();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lx1/f1/lb/util/o0$a;", "", "", "byteArray", "", "a", "([B)Ljava/lang/String;", TypedValues.Custom.S_STRING, "b", "(Ljava/lang/String;)[B", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        String a(byte[] byteArray);

        byte[] b(String string);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"x1/f1/lb/util/o0$b", "Lx1/f1/lb/util/o0$a;", "", "byteArray", "", "a", "([B)Ljava/lang/String;", TypedValues.Custom.S_STRING, "b", "(Ljava/lang/String;)[B", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements a {
        b() {
        }

        @Override // x1.f1.lb.util.o0.a
        public String a(byte[] byteArray) {
            String strU = wb.a.u(byteArray);
            kotlin.jvm.internal.m.e(strU, "encodeBase64URLSafeString(...)");
            return strU;
        }

        @Override // x1.f1.lb.util.o0.a
        public byte[] b(String string) {
            return wb.a.r(string);
        }
    }

    static {
        Security.addProvider(new dd.a());
    }

    private final String b(byte[] data, byte[] key) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/ZeroBytePadding");
            cipher.init(2, secretKeySpec);
            byte[] bArrDoFinal = cipher.doFinal(data);
            kotlin.jvm.internal.m.e(bArrDoFinal, "doFinal(...)");
            Charset UTF_8 = StandardCharsets.UTF_8;
            kotlin.jvm.internal.m.e(UTF_8, "UTF_8");
            return new String(bArrDoFinal, UTF_8);
        } catch (Exception e10) {
            logger.error("decrypt failure", e10);
            return null;
        }
    }

    private final byte[] d(byte[] data, byte[] key) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/ZeroBytePadding");
            cipher.init(1, secretKeySpec);
            return cipher.doFinal(data);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final String a(String data, String key) {
        return b(base64.b(data), base64.b(key));
    }

    public final String c(String data, String key) {
        kotlin.jvm.internal.m.f(data, "data");
        try {
            Charset charsetForName = Charset.forName("UTF-8");
            kotlin.jvm.internal.m.e(charsetForName, "forName(...)");
            byte[] bytes = data.getBytes(charsetForName);
            kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
            return base64.a(d(bytes, base64.b(key)));
        } catch (Exception e10) {
            logger.error("encrypt failure", e10);
            return null;
        }
    }

    public final String e(String keyString) {
        kotlin.jvm.internal.m.f(keyString, "keyString");
        try {
            return base64.a(g(keyString));
        } catch (Exception e10) {
            logger.error("generateKey failed.", e10);
            return "";
        }
    }

    public final void f(a base65) {
        kotlin.jvm.internal.m.f(base65, "base64");
        base64 = base65;
    }

    public final byte[] g(String keyString) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.m.f(keyString, "keyString");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        Charset charsetForName = Charset.forName("UTF-8");
        kotlin.jvm.internal.m.e(charsetForName, "forName(...)");
        byte[] bytes = keyString.getBytes(charsetForName);
        kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
        secureRandom.setSeed(bytes);
        keyGenerator.init(128, secureRandom);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        kotlin.jvm.internal.m.e(encoded, "getEncoded(...)");
        return encoded;
    }

    private o0() {
    }
}
