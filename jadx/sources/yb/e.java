package yb;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f22563a = File.separatorChar;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f22564b;

    static {
        zb.b bVar = new zb.b(4);
        PrintWriter printWriter = new PrintWriter(bVar);
        printWriter.println();
        f22564b = bVar.toString();
        printWriter.close();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void d(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            a(closeable);
        }
    }

    public static long g(InputStream inputStream, OutputStream outputStream, int i10) {
        return j(inputStream, outputStream, new byte[i10]);
    }

    public static void h(InputStream inputStream, Writer writer, Charset charset) {
        f(new InputStreamReader(inputStream, a.a(charset)), writer);
    }

    public static long i(InputStream inputStream, OutputStream outputStream) {
        return g(inputStream, outputStream, 4096);
    }

    public static long j(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j10 = 0;
        while (true) {
            int i10 = inputStream.read(bArr);
            if (-1 == i10) {
                return j10;
            }
            outputStream.write(bArr, 0, i10);
            j10 += (long) i10;
        }
    }

    public static long k(Reader reader, Writer writer) {
        return l(reader, writer, new char[4096]);
    }

    public static long l(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j10 = 0;
        while (true) {
            int i10 = reader.read(cArr);
            if (-1 == i10) {
                return j10;
            }
            writer.write(cArr, 0, i10);
            j10 += (long) i10;
        }
    }

    public static byte[] m(InputStream inputStream) {
        zb.a aVar = new zb.a();
        e(inputStream, aVar);
        return aVar.b();
    }

    public static String n(InputStream inputStream, Charset charset) {
        zb.b bVar = new zb.b();
        h(inputStream, bVar, charset);
        return bVar.toString();
    }

    public static void b(InputStream inputStream) {
        a(inputStream);
    }

    public static void c(OutputStream outputStream) {
        a(outputStream);
    }

    public static int e(InputStream inputStream, OutputStream outputStream) {
        long jI = i(inputStream, outputStream);
        if (jI > 2147483647L) {
            return -1;
        }
        return (int) jI;
    }

    public static int f(Reader reader, Writer writer) {
        long jK = k(reader, writer);
        if (jK > 2147483647L) {
            return -1;
        }
        return (int) jK;
    }
}
