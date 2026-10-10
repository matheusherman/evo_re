package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class a {
    @Nullable
    public static MessageDigest b(@NonNull String str) {
        for (int i10 = 0; i10 < 2; i10++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                if (messageDigest != null) {
                    return messageDigest;
                }
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    @Nullable
    @Deprecated
    public static byte[] a(@NonNull Context context, @NonNull String str) {
        MessageDigest messageDigestB;
        PackageInfo packageInfoD = t1.e.a(context).d(str, 64);
        Signature[] signatureArr = packageInfoD.signatures;
        if (signatureArr != null && signatureArr.length == 1 && (messageDigestB = b("SHA1")) != null) {
            return messageDigestB.digest(packageInfoD.signatures[0].toByteArray());
        }
        return null;
    }
}
