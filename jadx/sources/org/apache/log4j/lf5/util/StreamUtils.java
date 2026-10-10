package org.apache.log4j.lf5.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class StreamUtils {
    public static final int DEFAULT_BUFFER_SIZE = 2048;

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        copy(inputStream, outputStream, 2048);
    }

    public static void copy(InputStream inputStream, OutputStream outputStream, int i10) throws IOException {
        byte[] bArr = new byte[i10];
        int i11 = inputStream.read(bArr);
        while (i11 != -1) {
            outputStream.write(bArr, 0, i11);
            i11 = inputStream.read(bArr);
        }
        outputStream.flush();
    }

    public static byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static void copyThenClose(InputStream inputStream, OutputStream outputStream) throws IOException {
        copy(inputStream, outputStream);
        inputStream.close();
        outputStream.close();
    }
}
