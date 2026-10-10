package m7;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static File f15663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static FileChannel f15664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static FileLock f15665c;

    public static synchronized void a() {
        try {
            f.i();
            if (f15663a == null) {
                f15663a = new File(l7.e.e());
            }
            if (!f15663a.exists()) {
                try {
                    f15663a.createNewFile();
                } catch (Exception unused) {
                    return;
                }
            }
            if (f15664b == null) {
                try {
                    f15664b = new RandomAccessFile(f15663a, "rw").getChannel();
                } catch (Exception unused2) {
                    return;
                }
            }
            try {
                f15665c = f15664b.lock();
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized void b() {
        try {
            f.i();
            FileLock fileLock = f15665c;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Exception unused) {
                } finally {
                    f15665c = null;
                }
            }
            FileChannel fileChannel = f15664b;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (Exception unused2) {
                } finally {
                    f15664b = null;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
