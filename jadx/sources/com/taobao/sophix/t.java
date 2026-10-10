package com.taobao.sophix;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f8488a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(File file) throws Throwable {
        FileChannel fileChannel;
        FileInputStream fileInputStream;
        if (file == null || !file.exists() || !file.canRead() || file.length() == 0) {
            return "";
        }
        FileInputStream fileInputStream2 = null;
        channel = null;
        channel = null;
        FileChannel channel = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            try {
                channel = fileInputStream.getChannel();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(102400);
                while (true) {
                    int i10 = channel.read(byteBufferAllocate);
                    if (i10 == -1) {
                        String strA = a(messageDigest.digest());
                        i.a(fileInputStream);
                        i.a(channel);
                        return strA;
                    }
                    messageDigest.update(byteBufferAllocate.array(), 0, i10);
                    byteBufferAllocate.position(0);
                }
            } catch (Exception e10) {
                e = e10;
                try {
                    s.a("Md5Util", "getFileMD5", e, new Object[0]);
                    i.a(fileInputStream);
                    i.a(channel);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    fileChannel = channel;
                    fileInputStream2 = fileInputStream;
                    fileInputStream = fileInputStream2;
                    channel = fileChannel;
                    i.a(fileInputStream);
                    i.a(channel);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                i.a(fileInputStream);
                i.a(channel);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
            fileInputStream = fileInputStream2;
            channel = fileChannel;
            i.a(fileInputStream);
            i.a(channel);
            throw th;
        }
    }

    private static String a(byte[] bArr) {
        char[] cArr = new char[32];
        int i10 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            byte b10 = bArr[i11];
            int i12 = i10 + 1;
            char[] cArr2 = f8488a;
            cArr[i10] = cArr2[(b10 >>> 4) & 15];
            i10 += 2;
            cArr[i12] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }
}
