package ya;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b extends ya.a implements Closeable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ZipFile f22540k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private File f22541l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private FileChannel f22542m;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Closeable {
        a() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            b.super.close();
        }
    }

    @Override // ya.a
    public byte[] a(String str) {
        ZipEntry entry = this.f22540k.getEntry(str);
        if (entry == null) {
            return null;
        }
        return fb.b.b(this.f22540k.getInputStream(entry));
    }

    @Override // ya.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a aVar = new a();
        try {
            ZipFile zipFile = this.f22540k;
            try {
                FileChannel fileChannel = this.f22542m;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (zipFile != null) {
                    zipFile.close();
                }
                aVar.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    aVar.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    public b(File file) {
        this.f22541l = file;
        this.f22540k = new ZipFile(file);
    }
}
