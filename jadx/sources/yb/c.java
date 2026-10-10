package yb;

import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f22550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger f22551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BigInteger f22552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f22553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BigInteger f22554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BigInteger f22555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f22556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f22557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final File[] f22558i;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f22559a;

        a(File file) {
            this.f22559a = file;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.equals(this.f22559a);
        }
    }

    public static void c(File file, File file2) throws Throwable {
        d(file, file2, true);
    }

    public static boolean h(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                b(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static FileOutputStream o(File file) {
        return p(file, false);
    }

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(1024L);
        f22550a = bigIntegerValueOf;
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(bigIntegerValueOf);
        f22551b = bigIntegerMultiply;
        BigInteger bigIntegerMultiply2 = bigIntegerValueOf.multiply(bigIntegerMultiply);
        f22552c = bigIntegerMultiply2;
        BigInteger bigIntegerMultiply3 = bigIntegerValueOf.multiply(bigIntegerMultiply2);
        f22553d = bigIntegerMultiply3;
        BigInteger bigIntegerMultiply4 = bigIntegerValueOf.multiply(bigIntegerMultiply3);
        f22554e = bigIntegerMultiply4;
        f22555f = bigIntegerValueOf.multiply(bigIntegerMultiply4);
        BigInteger bigIntegerMultiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
        f22556g = bigIntegerMultiply5;
        f22557h = bigIntegerValueOf.multiply(bigIntegerMultiply5);
        f22558i = new File[0];
    }

    private static void a(File file, File file2) throws FileNotFoundException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (file.exists()) {
            return;
        }
        throw new FileNotFoundException("Source '" + file + "' does not exist");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.nio.channels.FileChannel, java.nio.channels.ReadableByteChannel] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    private static void i(File file, File file2, boolean z10) throws Throwable {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        ?? channel;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        ?? r10 = 0;
        r10 = 0;
        r10 = 0;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    channel = fileInputStream.getChannel();
                    try {
                        ?? channel2 = fileOutputStream.getChannel();
                        try {
                            long size = channel.size();
                            long j10 = 0;
                            while (j10 < size) {
                                long j11 = size - j10;
                                if (j11 > 31457280) {
                                    j11 = 31457280;
                                }
                                long jTransferFrom = channel2.transferFrom(channel, j10, j11);
                                if (jTransferFrom == 0) {
                                    break;
                                } else {
                                    j10 += jTransferFrom;
                                }
                            }
                            e.d(new Closeable[]{channel2, fileOutputStream, channel, fileInputStream});
                            long length = file.length();
                            long length2 = file2.length();
                            if (length == length2) {
                                if (z10) {
                                    file2.setLastModified(file.lastModified());
                                    return;
                                }
                                return;
                            }
                            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                        } catch (Throwable th) {
                            th = th;
                            r10 = channel2;
                            e.d(new Closeable[]{r10, fileOutputStream, channel, fileInputStream});
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    channel = 0;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                channel = fileOutputStream;
                e.d(new Closeable[]{r10, fileOutputStream, channel, fileInputStream});
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            fileOutputStream = null;
        }
    }

    public static void n(File file, File file2) throws Throwable {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' is a directory");
        }
        if (file2.exists()) {
            throw new b("Destination '" + file2 + "' already exists");
        }
        if (file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' is a directory");
        }
        if (file.renameTo(file2)) {
            return;
        }
        c(file, file2);
        if (file.delete()) {
            return;
        }
        h(file2);
        throw new IOException("Failed to delete original file '" + file + "' after copy to '" + file2 + "'");
    }

    public static void b(File file) throws IOException {
        IOException e10 = null;
        for (File file2 : q(file)) {
            try {
                j(file2);
            } catch (IOException e11) {
                e10 = e11;
            }
        }
        if (e10 != null) {
            throw e10;
        }
    }

    public static void d(File file, File file2, boolean z10) throws Throwable {
        a(file, file2);
        if (!file.isDirectory()) {
            if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                File parentFile = file2.getParentFile();
                if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                    throw new IOException("Destination '" + parentFile + "' directory cannot be created");
                }
                if (file2.exists() && !file2.canWrite()) {
                    throw new IOException("Destination '" + file2 + "' exists but is read-only");
                }
                i(file, file2, z10);
                return;
            }
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        throw new IOException("Source '" + file + "' exists but is a directory");
    }

    public static void e(InputStream inputStream, File file) {
        try {
            f(inputStream, file);
        } finally {
            e.b(inputStream);
        }
    }

    public static void f(InputStream inputStream, File file) {
        FileOutputStream fileOutputStreamO = o(file);
        try {
            e.e(inputStream, fileOutputStreamO);
            fileOutputStreamO.close();
        } finally {
            e.c(fileOutputStreamO);
        }
    }

    public static void g(File file) throws IOException {
        if (file.exists()) {
            if (!m(file)) {
                b(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static void j(File file) throws IOException {
        if (file.isDirectory()) {
            g(file);
            return;
        }
        boolean zExists = file.exists();
        if (!file.delete()) {
            if (!zExists) {
                throw new FileNotFoundException("File does not exist: " + file);
            }
            throw new IOException("Unable to delete file: " + file);
        }
    }

    public static void k(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
            }
            return;
        }
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("Unable to create directory " + file);
        }
    }

    private static boolean l(File file) {
        File canonicalFile;
        File parentFile;
        File[] fileArrListFiles;
        if (file.exists() || (parentFile = (canonicalFile = file.getCanonicalFile()).getParentFile()) == null || !parentFile.exists() || (fileArrListFiles = parentFile.listFiles(new a(canonicalFile))) == null || fileArrListFiles.length <= 0) {
            return false;
        }
        return true;
    }

    public static boolean m(File file) {
        File file2;
        if (f.a()) {
            return f.b(file);
        }
        if (file != null) {
            if (d.g()) {
                return false;
            }
            if (file.getParent() == null) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile().getCanonicalFile(), file.getName());
            }
            if (file2.getCanonicalFile().equals(file2.getAbsoluteFile())) {
                return l(file);
            }
            return true;
        }
        throw new NullPointerException("File must not be null");
    }

    public static FileOutputStream p(File file, boolean z10) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.canWrite()) {
                    throw new IOException("File '" + file + "' cannot be written to");
                }
            } else {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        }
        return new FileOutputStream(file, z10);
    }

    private static File[] q(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    return fileArrListFiles;
                }
                throw new IOException("Failed to list contents of " + file);
            }
            throw new IllegalArgumentException(file + " is not a directory");
        }
        throw new IllegalArgumentException(file + " does not exist");
    }
}
