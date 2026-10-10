package com.pengrad.telegrambot.login;

import b6.a;
import java.math.BigInteger;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.TreeSet;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class CheckTelegramAuth {
    private final long authDate;
    private final String botToken;
    private final String dataCheck;
    private final String hash;

    public static CheckTelegramAuth fromUrl(String str, String str2) {
        return new CheckTelegramAuth(str, URI.create(str2).getQuery());
    }

    private static String hex(byte[] bArr) {
        return String.format("%040x", new BigInteger(1, bArr));
    }

    private static String hmacSha256(byte[] bArr, String str) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(bArr, "HmacSHA256"));
        return hex(mac.doFinal(str.getBytes()));
    }

    private static byte[] sha256(byte[] bArr) {
        return MessageDigest.getInstance("SHA-256").digest(bArr);
    }

    public Date authDate() {
        return new Date(this.authDate * 1000);
    }

    public boolean isFromTelegram() {
        return hmacSha256(sha256(this.botToken.getBytes()), this.dataCheck).equals(this.hash);
    }

    private CheckTelegramAuth(String str, String str2) {
        String[] strArrSplit = str2.split("&");
        TreeSet treeSet = new TreeSet();
        String strSubstring = null;
        long j10 = 0;
        for (String str3 : strArrSplit) {
            if (str3.startsWith("hash=")) {
                strSubstring = str3.substring(5);
            } else {
                treeSet.add(str3);
            }
            if (str3.startsWith("auth_date=")) {
                j10 = Long.parseLong(str3.substring(10));
            }
        }
        this.hash = strSubstring;
        this.authDate = j10;
        this.dataCheck = a.a("\n", treeSet);
        this.botToken = str;
    }
}
