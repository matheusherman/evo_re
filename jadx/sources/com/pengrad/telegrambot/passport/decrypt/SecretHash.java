package com.pengrad.telegrambot.passport.decrypt;

import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class SecretHash {
    private final byte[] secretHash;

    private byte[] concat(byte[]... bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int i10 = 0;
        for (byte[] bArr4 : bArr) {
            for (byte b10 : bArr4) {
                bArr3[i10] = b10;
                i10++;
            }
        }
        return bArr3;
    }

    private byte[] sha512(byte[] bArr) {
        return MessageDigest.getInstance("SHA-512").digest(bArr);
    }

    public byte[] iv() {
        return Arrays.copyOfRange(this.secretHash, 32, 48);
    }

    public byte[] key() {
        return Arrays.copyOfRange(this.secretHash, 0, 32);
    }

    public SecretHash(byte[] bArr, byte[] bArr2) {
        this.secretHash = sha512(concat(bArr, bArr2));
    }
}
