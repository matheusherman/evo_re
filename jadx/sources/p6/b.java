package p6;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {
    public static byte[] a(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        Deflater deflater = new Deflater(9);
        deflater.setInput(bytes);
        deflater.finish();
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr, 0, deflater.deflate(bArr));
        }
        deflater.end();
        byteArrayOutputStream.close();
        new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        return byteArrayOutputStream.toByteArray();
    }
}
