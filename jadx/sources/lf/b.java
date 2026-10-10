package lf;

import android.os.Build;
import android.util.Base64;
import c9.l;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import ua.d;
import ua.n;
import x1.f1.lb.util.d1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001*B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u0004¢\u0006\u0004\b \u0010!JE\u0010'\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0004¢\u0006\u0004\b'\u0010(R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010)R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010)¨\u0006+"}, d2 = {"Llf/b;", "", "<init>", "()V", "", "plainText", "", "key", "iv", "c", "(Ljava/lang/String;[B[B)Ljava/lang/String;", "cipherText", "b", "keyBytes", "i", "([B)Ljava/lang/String;", "Ljava/security/PublicKey;", "h", "()Ljava/security/PublicKey;", "payload", "j", "(Ljava/lang/String;)Ljava/lang/String;", "clientSecret", "serverPublicKeyPem", "Lr8/z;", "f", "(Ljava/lang/String;Ljava/lang/String;)V", "", "g", "()Z", "json", "Llf/b$a;", "d", "(Ljava/lang/String;)Llf/b$a;", "timestamp", "nonce", "sign", "aesKey", "serverSecret", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B[BLjava/lang/String;)Ljava/lang/String;", "Ljava/lang/String;", "a", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f15415a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String clientSecret = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String serverPublicKeyPem = "";

    /* JADX INFO: renamed from: lf.b$a, reason: from toString */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001a\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u001b\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u000fR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u000fR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0017\u0010!R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001c\u0010 \u001a\u0004\b\u001d\u0010!¨\u0006\""}, d2 = {"Llf/b$a;", "", "", "cipherText", "aesKeyEncrypted", "iv", "timestamp", "nonce", "sign", "", "aesKey", "ivRaw", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B[B)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "c", "b", "d", "h", "e", "f", "g", "[B", "()[B", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class EncryptedPayload {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String cipherText;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String aesKeyEncrypted;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String iv;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String timestamp;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final String nonce;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final String sign;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final byte[] aesKey;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final byte[] ivRaw;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EncryptedPayload)) {
                return false;
            }
            EncryptedPayload encryptedPayload = (EncryptedPayload) other;
            return m.a(this.cipherText, encryptedPayload.cipherText) && m.a(this.aesKeyEncrypted, encryptedPayload.aesKeyEncrypted) && m.a(this.iv, encryptedPayload.iv) && m.a(this.timestamp, encryptedPayload.timestamp) && m.a(this.nonce, encryptedPayload.nonce) && m.a(this.sign, encryptedPayload.sign) && m.a(this.aesKey, encryptedPayload.aesKey) && m.a(this.ivRaw, encryptedPayload.ivRaw);
        }

        public EncryptedPayload(String cipherText, String aesKeyEncrypted, String iv, String timestamp, String nonce, String sign, byte[] aesKey, byte[] ivRaw) {
            m.f(cipherText, "cipherText");
            m.f(aesKeyEncrypted, "aesKeyEncrypted");
            m.f(iv, "iv");
            m.f(timestamp, "timestamp");
            m.f(nonce, "nonce");
            m.f(sign, "sign");
            m.f(aesKey, "aesKey");
            m.f(ivRaw, "ivRaw");
            this.cipherText = cipherText;
            this.aesKeyEncrypted = aesKeyEncrypted;
            this.iv = iv;
            this.timestamp = timestamp;
            this.nonce = nonce;
            this.sign = sign;
            this.aesKey = aesKey;
            this.ivRaw = ivRaw;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final byte[] getAesKey() {
            return this.aesKey;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getAesKeyEncrypted() {
            return this.aesKeyEncrypted;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getCipherText() {
            return this.cipherText;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final String getIv() {
            return this.iv;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final byte[] getIvRaw() {
            return this.ivRaw;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final String getNonce() {
            return this.nonce;
        }

        /* JADX INFO: renamed from: g, reason: from getter */
        public final String getSign() {
            return this.sign;
        }

        /* JADX INFO: renamed from: h, reason: from getter */
        public final String getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return (((((((((((((this.cipherText.hashCode() * 31) + this.aesKeyEncrypted.hashCode()) * 31) + this.iv.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + this.nonce.hashCode()) * 31) + this.sign.hashCode()) * 31) + Arrays.hashCode(this.aesKey)) * 31) + Arrays.hashCode(this.ivRaw);
        }

        public String toString() {
            return "EncryptedPayload(cipherText=" + this.cipherText + ", aesKeyEncrypted=" + this.aesKeyEncrypted + ", iv=" + this.iv + ", timestamp=" + this.timestamp + ", nonce=" + this.nonce + ", sign=" + this.sign + ", aesKey=" + Arrays.toString(this.aesKey) + ", ivRaw=" + Arrays.toString(this.ivRaw) + ")";
        }
    }

    static {
        if (Security.getProvider("BC") == null) {
            Security.addProvider(new dd.a());
        }
    }

    private final String b(String cipherText, byte[] key, byte[] iv) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
        cipher.init(2, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
        byte[] bArrDoFinal = cipher.doFinal(Base64.decode(cipherText, 2));
        m.e(bArrDoFinal, "doFinal(...)");
        Charset UTF_8 = StandardCharsets.UTF_8;
        m.e(UTF_8, "UTF_8");
        return new String(bArrDoFinal, UTF_8);
    }

    private final String c(String plainText, byte[] key, byte[] iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
        cipher.init(1, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
        Charset UTF_8 = StandardCharsets.UTF_8;
        m.e(UTF_8, "UTF_8");
        byte[] bytes = plainText.getBytes(UTF_8);
        m.e(bytes, "getBytes(...)");
        String strEncodeToString = Base64.encodeToString(cipher.doFinal(bytes), 2);
        m.e(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    private final PublicKey h() throws InvalidKeySpecException {
        PublicKey publicKeyGeneratePublic = (Build.VERSION.SDK_INT >= 28 ? KeyFactory.getInstance("RSA") : KeyFactory.getInstance("RSA", "BC")).generatePublic(new X509EncodedKeySpec(Base64.decode(serverPublicKeyPem, 2)));
        m.e(publicKeyGeneratePublic, "generatePublic(...)");
        return publicKeyGeneratePublic;
    }

    private final String i(byte[] keyBytes) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
        cipher.init(1, h());
        String strEncodeToString = Base64.encodeToString(cipher.doFinal(keyBytes), 2);
        m.e(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    private final String j(String payload) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = payload.getBytes(d.UTF_8);
        m.e(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        m.e(bArrDigest, "digest(...)");
        return j.c0(bArrDigest, "", null, null, 0, null, new l() { // from class: lf.a
            @Override // c9.l
            public final Object invoke(Object obj) {
                return b.k(((Byte) obj).byteValue());
            }
        }, 30, null);
    }

    public final EncryptedPayload d(String json) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
        m.f(json, "json");
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        byte[] bArr2 = new byte[16];
        new SecureRandom().nextBytes(bArr2);
        String strC = c(json, bArr, bArr2);
        String strI = i(bArr);
        String strValueOf = String.valueOf(d1.d());
        String string = UUID.randomUUID().toString();
        m.e(string, "toString(...)");
        String strJ = j(strC + strValueOf + string + clientSecret);
        String strEncodeToString = Base64.encodeToString(bArr2, 2);
        m.e(strEncodeToString, "encodeToString(...)");
        return new EncryptedPayload(strC, strI, strEncodeToString, strValueOf, string, strJ, bArr, bArr2);
    }

    public final String e(String cipherText, String timestamp, String nonce, String sign, byte[] aesKey, byte[] iv, String serverSecret) {
        m.f(cipherText, "cipherText");
        m.f(timestamp, "timestamp");
        m.f(nonce, "nonce");
        m.f(sign, "sign");
        m.f(aesKey, "aesKey");
        m.f(iv, "iv");
        m.f(serverSecret, "serverSecret");
        if (m.a(j(cipherText + timestamp + nonce + serverSecret), sign)) {
            return b(cipherText, aesKey, iv);
        }
        throw new IllegalArgumentException("response signature mismatch");
    }

    public final void f(String clientSecret2, String serverPublicKeyPem2) {
        m.f(clientSecret2, "clientSecret");
        m.f(serverPublicKeyPem2, "serverPublicKeyPem");
        clientSecret = clientSecret2;
        serverPublicKeyPem = new ua.l("\\s").f(n.E(n.E(serverPublicKeyPem2, "-----BEGIN PUBLIC KEY-----", "", false, 4, null), "-----END PUBLIC KEY-----", "", false, 4, null), "");
    }

    public final boolean g() {
        return clientSecret.length() > 0 && serverPublicKeyPem.length() > 0;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence k(byte b10) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
        m.e(str, "format(...)");
        return str;
    }
}
