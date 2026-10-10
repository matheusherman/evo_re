package com.pengrad.telegrambot.passport.decrypt;

import com.google.gson.e;
import com.pengrad.telegrambot.passport.Credentials;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Decrypt {
    private static byte[] base64(String str) {
        return Base64.decode(str, 0);
    }

    private static byte[] decryptAes256Cbc(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IOException {
        byte[] bArrDecrypt = new Aes256Cbc(bArr, bArr2).decrypt(bArr3);
        return Arrays.copyOfRange(bArrDecrypt, bArrDecrypt[0] & 255, bArrDecrypt.length);
    }

    public static byte[] decryptFile(byte[] bArr, String str, String str2) {
        SecretHash secretHash = new SecretHash(base64(str2), base64(str));
        return decryptAes256Cbc(secretHash.key(), secretHash.iv(), bArr);
    }

    public static Credentials decryptCredentials(String str, String str2, String str3, String str4) {
        SecretHash secretHash = new SecretHash(RsaOaep.decrypt(str, base64(str4)), base64(str3));
        return (Credentials) new e().n(new String(decryptAes256Cbc(secretHash.key(), secretHash.iv(), base64(str2))), Credentials.class);
    }

    public static String decryptData(String str, String str2, String str3) {
        return new String(decryptFile(base64(str), str2, str3));
    }
}
