package se;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d f18638a = new d();

    public static byte[] c(byte[] bArr) {
        return d(bArr, 0, bArr.length);
    }

    public static byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f18638a.a(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e10) {
            throw new a("exception decoding Hex string: " + e10.getMessage(), e10);
        }
    }

    public static byte[] b(String str) {
        try {
            return f18638a.b(str, 0, str.length());
        } catch (Exception e10) {
            throw new a("exception decoding Hex string: " + e10.getMessage(), e10);
        }
    }

    public static byte[] d(byte[] bArr, int i10, int i11) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f18638a.c(bArr, i10, i11, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e10) {
            throw new b("exception encoding Hex string: " + e10.getMessage(), e10);
        }
    }
}
