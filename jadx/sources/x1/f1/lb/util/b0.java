package x1.f1.lb.util;

import android.annotation.SuppressLint;
import androidx.core.app.NotificationCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u00067A(\f;\"B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J3\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001d¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b&\u0010%J\u001b\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070'2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b(\u0010)J+\u0010/\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*2\b\b\u0002\u0010,\u001a\u00020\u00072\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J)\u00101\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b1\u00102J)\u00103\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b3\u00102J'\u00107\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0004H\u0007¢\u0006\u0004\b7\u00108R\u001c\u0010=\u001a\n :*\u0004\u0018\u000109098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010?¨\u0006B"}, d2 = {"Lx1/f1/lb/util/b0;", "", "<init>", "()V", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "savePath", "", "async", "Lx1/f1/lb/util/b0$f;", "listener", "Lr8/z;", "e", "(Ljava/lang/String;Ljava/lang/String;ZLx1/f1/lb/util/b0$f;)V", "Ljava/io/File;", "file", "algorithm", "i", "(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;", "input", "p", "(Ljava/lang/String;)Ljava/lang/String;", "checksum", "Lx1/f1/lb/util/b0$b;", "checksumCalculator", "", "size", "l", "(Ljava/io/File;Ljava/lang/String;Lx1/f1/lb/util/b0$b;J)Z", "Lx1/f1/lb/util/m;", "Ljava/io/InputStream;", "callback", "", "failure", "f", "(Ljava/lang/String;Lx1/f1/lb/util/m;Lx1/f1/lb/util/m;)V", "j", "(Ljava/io/File;)Ljava/lang/String;", "k", "Lkotlinx/coroutines/flow/f;", "c", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/f;", "Lx1/f1/lb/util/b0$d;", "context", "whatRetIfExists", "Lx1/f1/lb/util/b0$e;", "loaderBeforeOverwrite", "g", "(Lx1/f1/lb/util/b0$d;ZLx1/f1/lb/util/b0$e;)Z", "m", "(Ljava/io/File;Ljava/lang/String;J)Z", "o", "inputFilePath", "outputFilePath", "key", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "Lokhttp3/z;", "Lokhttp3/z;", "okHttpClient", "a", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f21310a = new b0();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(b0.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static okhttp3.z okHttpClient = of.e.f16588a.e();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001dR\u0014\u0010 \u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lx1/f1/lb/util/b0$a;", "Lx1/f1/lb/util/b0$d;", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "dir", "fileName", "", "isZip", "Lx1/f1/lb/util/b0$f;", "listener", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLx1/f1/lb/util/b0$f;)V", "Ljava/util/concurrent/atomic/AtomicInteger;", "j", "()Ljava/util/concurrent/atomic/AtomicInteger;", "b", "()Ljava/lang/String;", "i", "a", "Ljava/io/File;", "e", "()Ljava/io/File;", "h", "()Z", "c", "()Lx1/f1/lb/util/b0$f;", "Ljava/lang/String;", "d", "Z", "Lx1/f1/lb/util/b0$f;", "f", "Ljava/io/File;", "file", "g", "Ljava/util/concurrent/atomic/AtomicInteger;", "tryTimes", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String url;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String dir;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final String fileName;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isZip;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final f listener;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final File file;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final AtomicInteger tryTimes;

        public a(String url, String dir, String fileName, boolean z10, f fVar) {
            kotlin.jvm.internal.m.f(url, "url");
            kotlin.jvm.internal.m.f(dir, "dir");
            kotlin.jvm.internal.m.f(fileName, "fileName");
            this.url = url;
            this.dir = dir;
            this.fileName = fileName;
            this.isZip = z10;
            this.listener = fVar;
            this.file = new File(dir, fileName);
            this.tryTimes = new AtomicInteger(1);
        }

        @Override // x1.f1.lb.util.b0.d
        /* JADX INFO: renamed from: a, reason: from getter */
        public String getFileName() {
            return this.fileName;
        }

        @Override // x1.f1.lb.util.b0.d
        /* JADX INFO: renamed from: b, reason: from getter */
        public String getUrl() {
            return this.url;
        }

        @Override // x1.f1.lb.util.b0.d
        /* JADX INFO: renamed from: c, reason: from getter */
        public f getListener() {
            return this.listener;
        }

        @Override // x1.f1.lb.util.b0.d
        /* JADX INFO: renamed from: e, reason: from getter */
        public File getFile() {
            return this.file;
        }

        @Override // x1.f1.lb.util.b0.d
        /* JADX INFO: renamed from: h, reason: from getter */
        public boolean getIsZip() {
            return this.isZip;
        }

        @Override // x1.f1.lb.util.b0.d
        /* JADX INFO: renamed from: i, reason: from getter */
        public String getDir() {
            return this.dir;
        }

        @Override // x1.f1.lb.util.b0.d
        /* JADX INFO: renamed from: j, reason: from getter */
        public AtomicInteger getTryTimes() {
            return this.tryTimes;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lx1/f1/lb/util/b0$b;", "", "Ljava/io/File;", "file", "", "a", "(Ljava/io/File;)Ljava/lang/String;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        String a(File file);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lx1/f1/lb/util/b0$c;", "Lx1/f1/lb/util/b0$a;", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "dir", "fileName", "", "isZip", "Lx1/f1/lb/util/b0$f;", "listener", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLx1/f1/lb/util/b0$f;)V", "d", "()Ljava/lang/String;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class c extends a {
        public /* synthetic */ c(String str, String str2, String str3, boolean z10, f fVar, int i10, kotlin.jvm.internal.g gVar) {
            this(str, str2, str3, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? null : fVar);
        }

        @Override // x1.f1.lb.util.b0.d
        public String d() {
            return null;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String url, String dir, String fileName, boolean z10, f fVar) {
            super(url, dir, fileName, z10, fVar);
            kotlin.jvm.internal.m.f(url, "url");
            kotlin.jvm.internal.m.f(dir, "dir");
            kotlin.jvm.internal.m.f(fileName, "fileName");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\bH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0012\u0010\u0007J\u000f\u0010\u0013\u001a\u00020\nH&¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lx1/f1/lb/util/b0$d;", "", "Ljava/util/concurrent/atomic/AtomicInteger;", "j", "()Ljava/util/concurrent/atomic/AtomicInteger;", "", "b", "()Ljava/lang/String;", "Ljava/io/File;", "file", "", "f", "(Ljava/io/File;)Z", "g", "i", "a", "e", "()Ljava/io/File;", "d", "h", "()Z", "Lx1/f1/lb/util/b0$f;", "c", "()Lx1/f1/lb/util/b0$f;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface d {
        /* JADX INFO: renamed from: a */
        String getFileName();

        /* JADX INFO: renamed from: b */
        String getUrl();

        /* JADX INFO: renamed from: c */
        f getListener();

        String d();

        /* JADX INFO: renamed from: e */
        File getFile();

        boolean f(File file);

        boolean g(File file);

        /* JADX INFO: renamed from: h */
        boolean getIsZip();

        /* JADX INFO: renamed from: i */
        String getDir();

        /* JADX INFO: renamed from: j */
        AtomicInteger getTryTimes();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lx1/f1/lb/util/b0$e;", "", "Ljava/io/File;", "file", "Lr8/z;", "a", "(Ljava/io/File;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface e {
        void a(File file);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lx1/f1/lb/util/b0$f;", "", "", "savedPath", "Lr8/z;", "b", "(Ljava/lang/String;)V", "", "progress", "c", "(I)V", "", "e", "a", "(Ljava/lang/Throwable;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface f {
        void a(Throwable e10);

        void b(String savedPath);

        void c(int progress);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.DownloadUtils$checkExists$1", f = "DownloadUtils.kt", l = {254}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class g extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super Boolean>, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, v8.f<? super g> fVar) {
            super(2, fVar);
            this.$url = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            g gVar = new g(this.$url, fVar);
            gVar.L$0 = obj;
            return gVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super Boolean> gVar, v8.f<? super r8.z> fVar) {
            return ((g) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x005a  */
        /* JADX WARN: Code duplicated, block: B:24:0x0064  */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            okhttp3.d0 d0Var;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    d0Var = (okhttp3.d0) this.L$0;
                    try {
                        r8.r.b(obj);
                        if (d0Var != null) {
                            hb.d.m(d0Var);
                        }
                        return r8.z.f17874a;
                    } catch (Throwable th) {
                        th = th;
                        if (d0Var != null) {
                            hb.d.m(d0Var);
                        }
                        throw th;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r8.r.b(obj);
            kotlinx.coroutines.flow.g gVar = (kotlinx.coroutines.flow.g) this.L$0;
            okhttp3.d0 d0VarExecute = null;
            try {
                d0VarExecute = b0.okHttpClient.a(new okhttp3.b0.a().k(this.$url).d().b()).execute();
                Boolean boolA = kotlin.coroutines.jvm.internal.b.a(d0VarExecute.n());
                this.L$0 = d0VarExecute;
                this.label = 1;
                if (gVar.emit(boolA, this) == objC) {
                    return objC;
                }
                d0Var = d0VarExecute;
                if (d0Var != null) {
                    hb.d.m(d0Var);
                }
                return r8.z.f17874a;
            } catch (Throwable th2) {
                th = th2;
                d0Var = d0VarExecute;
                if (d0Var != null) {
                    hb.d.m(d0Var);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"x1/f1/lb/util/b0$h", "Lokhttp3/f;", "Lokhttp3/e;", NotificationCompat.CATEGORY_CALL, "Ljava/io/IOException;", "e", "Lr8/z;", "onFailure", "(Lokhttp3/e;Ljava/io/IOException;)V", "Lokhttp3/d0;", "response", "onResponse", "(Lokhttp3/e;Lokhttp3/d0;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h implements okhttp3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f21320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f21321b;

        h(f fVar, String str) {
            this.f21320a = fVar;
            this.f21321b = str;
        }

        @Override // okhttp3.f
        public void onFailure(okhttp3.e call, IOException e10) {
            kotlin.jvm.internal.m.f(call, "call");
            kotlin.jvm.internal.m.f(e10, "e");
            f fVar = this.f21320a;
            if (fVar != null) {
                fVar.a(e10);
            }
        }

        /* JADX WARN: Code duplicated, block: B:52:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:54:0x00b8  */
        @Override // okhttp3.f
        public void onResponse(okhttp3.e call, okhttp3.d0 response) throws Throwable {
            FileOutputStream fileOutputStream;
            kotlin.jvm.internal.m.f(call, "call");
            kotlin.jvm.internal.m.f(response, "response");
            okhttp3.e0 body = response.getBody();
            if (body == null) {
                return;
            }
            byte[] bArr = new byte[2048];
            File file = new File(this.f21321b);
            InputStream inputStream = null;
            try {
                InputStream inputStreamA = body.a();
                try {
                    long f16697d = body.getContentLength();
                    if (file.exists()) {
                        file.delete();
                    }
                    fileOutputStream = new FileOutputStream(file);
                    long j10 = 0;
                    while (true) {
                        try {
                            int i10 = inputStreamA.read(bArr);
                            if (i10 == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i10);
                            j10 += (long) i10;
                            if (f16697d > 0) {
                                int i11 = (int) (((j10 * 1.0f) / f16697d) * 100);
                                f fVar = this.f21320a;
                                if (fVar != null) {
                                    fVar.c(i11);
                                }
                            }
                        } catch (Exception e10) {
                            e = e10;
                            inputStream = inputStreamA;
                            try {
                                f fVar2 = this.f21320a;
                                if (fVar2 != null) {
                                    fVar2.a(e);
                                }
                                hb.d.m(response);
                                hb.d.m(body);
                                if (inputStream != null) {
                                    hb.d.m(inputStream);
                                }
                                if (fileOutputStream != null) {
                                    hb.d.m(fileOutputStream);
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                hb.d.m(response);
                                hb.d.m(body);
                                if (inputStream != null) {
                                    hb.d.m(inputStream);
                                }
                                if (fileOutputStream != null) {
                                    hb.d.m(fileOutputStream);
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = inputStreamA;
                            hb.d.m(response);
                            hb.d.m(body);
                            if (inputStream != null) {
                                hb.d.m(inputStream);
                            }
                            if (fileOutputStream != null) {
                                hb.d.m(fileOutputStream);
                            }
                            throw th;
                        }
                    }
                    fileOutputStream.flush();
                    f fVar3 = this.f21320a;
                    if (fVar3 != null) {
                        String absolutePath = file.getAbsolutePath();
                        kotlin.jvm.internal.m.e(absolutePath, "getAbsolutePath(...)");
                        fVar3.b(absolutePath);
                    }
                    hb.d.m(response);
                    hb.d.m(body);
                    hb.d.m(inputStreamA);
                    hb.d.m(fileOutputStream);
                } catch (Exception e11) {
                    e = e11;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (Exception e12) {
                e = e12;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"x1/f1/lb/util/b0$i", "Lx1/f1/lb/util/b0$f;", "", "savedPath", "Lr8/z;", "b", "(Ljava/lang/String;)V", "", "progress", "c", "(I)V", "", "e", "a", "(Ljava/lang/Throwable;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.y f21322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f21323b;

        i(kotlin.jvm.internal.y yVar, d dVar) {
            this.f21322a = yVar;
            this.f21323b = dVar;
        }

        @Override // x1.f1.lb.util.b0.f
        public void a(Throwable e10) {
            kotlin.jvm.internal.m.f(e10, "e");
            b0.logger.warn("Download failure", e10);
            f listener = this.f21323b.getListener();
            if (listener != null) {
                listener.a(e10);
            }
        }

        @Override // x1.f1.lb.util.b0.f
        public void b(String savedPath) {
            kotlin.jvm.internal.m.f(savedPath, "savedPath");
            this.f21322a.element = true;
            f listener = this.f21323b.getListener();
            if (listener != null) {
                listener.b(savedPath);
            }
        }

        @Override // x1.f1.lb.util.b0.f
        public void c(int progress) {
            f listener = this.f21323b.getListener();
            if (listener != null) {
                listener.c(progress);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/util/b0$j", "Lx1/f1/lb/util/b0$b;", "Ljava/io/File;", "file", "", "a", "(Ljava/io/File;)Ljava/lang/String;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class j implements b {
        @Override // x1.f1.lb.util.b0.b
        public String a(File file) {
            kotlin.jvm.internal.m.f(file, "file");
            return b0.f21310a.j(file);
        }

        j() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/util/b0$k", "Lx1/f1/lb/util/b0$b;", "Ljava/io/File;", "file", "", "a", "(Ljava/io/File;)Ljava/lang/String;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class k implements b {
        @Override // x1.f1.lb.util.b0.b
        public String a(File file) {
            kotlin.jvm.internal.m.f(file, "file");
            return b0.f21310a.k(file);
        }

        k() {
        }
    }

    private final void e(String url, String savePath, boolean async, f listener) {
        okhttp3.b0 b0VarB = new okhttp3.b0.a().k(url).b();
        h hVar = new h(listener, savePath);
        if (async) {
            okHttpClient.a(b0VarB).J(hVar);
            return;
        }
        okhttp3.e eVarA = okHttpClient.a(b0VarB);
        try {
            hVar.onResponse(eVarA, eVarA.execute());
        } catch (IOException e10) {
            hVar.onFailure(eVarA, e10);
        }
    }

    public static /* synthetic */ boolean h(b0 b0Var, d dVar, boolean z10, e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            eVar = null;
        }
        return b0Var.g(dVar, z10, eVar);
    }

    private final boolean l(File file, String checksum, b checksumCalculator, long size) {
        if (size <= 0) {
            if (checksum == null || checksum.length() == 0) {
                return true;
            }
            return ac.g.d(checksumCalculator.a(file), checksum);
        }
        if (file.length() != size) {
            return false;
        }
        if (checksum == null || checksum.length() == 0) {
            return true;
        }
        return ac.g.d(checksumCalculator.a(file), checksum);
    }

    public static /* synthetic */ boolean n(b0 b0Var, File file, String str, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = 0;
        }
        return b0Var.m(file, str, j10);
    }

    private final String p(String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = input.getBytes(ua.d.UTF_8);
        kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        kotlin.jvm.internal.m.c(bArrDigest);
        String str = "";
        for (byte b10 : bArrDigest) {
            String str2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
            kotlin.jvm.internal.m.e(str2, "format(...)");
            str = str + str2;
        }
        return str;
    }

    public final kotlinx.coroutines.flow.f<Boolean> c(String url) {
        kotlin.jvm.internal.m.f(url, "url");
        return kotlinx.coroutines.flow.h.v(new g(url, null));
    }

    @SuppressLint({"GetInstance"})
    public final void d(String inputFilePath, String outputFilePath, String key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        kotlin.jvm.internal.m.f(inputFilePath, "inputFilePath");
        kotlin.jvm.internal.m.f(outputFilePath, "outputFilePath");
        kotlin.jvm.internal.m.f(key, "key");
        byte[] bytes = key.getBytes(ua.d.UTF_8);
        kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, secretKeySpec);
        FileInputStream fileInputStream = new FileInputStream(inputFilePath);
        CipherInputStream cipherInputStream = new CipherInputStream(fileInputStream, cipher);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath);
        byte[] bArr = new byte[1024];
        while (true) {
            int i10 = cipherInputStream.read(bArr);
            if (i10 == -1) {
                fileOutputStream.flush();
                cipherInputStream.close();
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
            fileOutputStream.write(bArr, 0, i10);
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00bc A[Catch: all -> 0x00c0, TRY_ENTER, TryCatch #0 {all -> 0x00c0, blocks: (B:34:0x00bc, B:37:0x00c2), top: B:52:0x00ba }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c2 A[Catch: all -> 0x00c0, TRY_LEAVE, TryCatch #0 {all -> 0x00c0, blocks: (B:34:0x00bc, B:37:0x00c2), top: B:52:0x00ba }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:37:0x00c2, please report this as an issue */
    public final void f(String url, m<InputStream> callback, m<Throwable> failure) {
        okhttp3.e0 body;
        okhttp3.d0 d0VarExecute;
        InputStream inputStream;
        InputStream inputStreamA;
        InputStream inputStreamA2;
        kotlin.jvm.internal.m.f(url, "url");
        kotlin.jvm.internal.m.f(callback, "callback");
        try {
            okhttp3.b0 b0VarB = new okhttp3.b0.a().k(url).b();
            d0VarExecute = okHttpClient.a(b0VarB).execute();
            try {
                int code = d0VarExecute.getCode();
                if (code == com.skydoves.sandwich.e.OK.getCode()) {
                    body = d0VarExecute.getBody();
                    if (body != null) {
                        try {
                            inputStreamA = body.a();
                        } catch (Throwable th) {
                            th = th;
                            inputStream = null;
                            try {
                                if (failure != null) {
                                    failure.a(th);
                                } else {
                                    callback.a(null);
                                    logger.error("download [" + url + "] failure", th);
                                }
                                if (d0VarExecute != null) {
                                    hb.d.m(d0VarExecute);
                                }
                                if (body != null) {
                                    hb.d.m(body);
                                }
                                if (inputStream != null) {
                                    hb.d.m(inputStream);
                                }
                            } catch (Throwable th2) {
                                if (d0VarExecute != null) {
                                    hb.d.m(d0VarExecute);
                                }
                                if (body != null) {
                                    hb.d.m(body);
                                }
                                if (inputStream != null) {
                                    hb.d.m(inputStream);
                                }
                                throw th2;
                            }
                        }
                    } else {
                        inputStreamA = null;
                    }
                } else {
                    String strN = "";
                    okhttp3.e0 body2 = d0VarExecute.getBody();
                    if (body2 != null && (inputStreamA2 = body2.a()) != null) {
                        strN = yb.e.n(inputStreamA2, ua.d.UTF_8);
                    }
                    logger.error("download error, url[" + url + "] request headers[" + b0VarB.getHeaders() + "] response code[" + code + "] response headers[" + d0VarExecute.getHeaders() + "] body[" + ((Object) strN) + "]", new Object[0]);
                    body = null;
                    inputStreamA = null;
                }
                try {
                    callback.a(inputStreamA);
                    hb.d.m(d0VarExecute);
                    if (body != null) {
                        hb.d.m(body);
                    }
                    if (inputStreamA != null) {
                        hb.d.m(inputStreamA);
                    }
                } catch (Throwable th3) {
                    inputStream = inputStreamA;
                    th = th3;
                    if (failure != null) {
                        failure.a(th);
                    } else {
                        callback.a(null);
                        logger.error("download [" + url + "] failure", th);
                    }
                    if (d0VarExecute != null) {
                        hb.d.m(d0VarExecute);
                    }
                    if (body != null) {
                        hb.d.m(body);
                    }
                    if (inputStream != null) {
                        hb.d.m(inputStream);
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                body = null;
                inputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            body = null;
            d0VarExecute = null;
            inputStream = null;
        }
    }

    public final boolean g(d context, boolean whatRetIfExists, e loaderBeforeOverwrite) throws Throwable {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.y yVar = new kotlin.jvm.internal.y();
        File file = context.getFile();
        if (file.exists()) {
            if (context.f(file)) {
                return whatRetIfExists;
            }
            if (loaderBeforeOverwrite != null) {
                loaderBeforeOverwrite.a(file);
            }
        }
        context.getTryTimes().decrementAndGet();
        b1 b1Var = b1.f21324a;
        String strD = b1Var.d(b1Var.e(), p(context.getUrl() + "}"));
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        if (bVar.t()) {
            logger.debug("download url[{}], saveDir[{}], fileName[{}], file[{}], tmpPath[{}]", context.getUrl(), context.getDir(), context.getFileName(), context.getFile().getAbsolutePath(), strD);
        }
        e(context.getUrl(), strD, false, new i(yVar, context));
        File file2 = new File(strD);
        String absolutePath = context.getFile().getAbsolutePath();
        if (!yVar.element || !file2.exists()) {
            if (context.getTryTimes().get() > 0) {
                return h(this, context, false, null, 6, null);
            }
            return false;
        }
        String strD2 = context.d();
        if (strD2 == null) {
            strD2 = "";
        }
        if (!ac.g.f(strD2)) {
            kotlin.jvm.internal.m.c(absolutePath);
            d(strD, absolutePath, strD2);
            file2.delete();
        } else if (context.getIsZip()) {
            yb.c.e(new GZIPInputStream(new FileInputStream(file2)), file);
            if (file.exists()) {
                file2.delete();
            } else {
                logger.warn("unzip failure[{}]->[{}]", file2.getAbsolutePath(), file.getAbsolutePath());
                if (!bVar.t()) {
                    file2.delete();
                }
            }
        } else {
            yb.c.c(file2, context.getFile());
        }
        if (!file.exists()) {
            if (context.getTryTimes().get() > 0) {
                h(this, context, false, null, 6, null);
            }
            return false;
        }
        if (context.g(file)) {
            return true;
        }
        file.delete();
        if (context.getTryTimes().get() > 0) {
            return h(this, context, false, null, 6, null);
        }
        return false;
    }

    public final String j(File file) {
        kotlin.jvm.internal.m.f(file, "file");
        return i(file, "MD5");
    }

    public final String k(File file) {
        kotlin.jvm.internal.m.f(file, "file");
        return i(file, "SHA-1");
    }

    public final boolean m(File file, String checksum, long size) {
        kotlin.jvm.internal.m.f(file, "file");
        return l(file, checksum, new j(), size);
    }

    public final boolean o(File file, String checksum, long size) {
        kotlin.jvm.internal.m.f(file, "file");
        return l(file, checksum, new k(), size);
    }

    private b0() {
    }

    private final String i(File file, String algorithm) {
        if (file.exists() && file.isFile()) {
            byte[] bArr = new byte[16384];
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
                FileInputStream fileInputStream = new FileInputStream(file);
                while (true) {
                    int i10 = fileInputStream.read(bArr, 0, 16384);
                    if (i10 != -1) {
                        messageDigest.update(bArr, 0, i10);
                    } else {
                        fileInputStream.close();
                        byte[] bArrDigest = messageDigest.digest();
                        o oVar = o.f21430a;
                        kotlin.jvm.internal.m.c(bArrDigest);
                        return new String(oVar.b(bArrDigest));
                    }
                }
            } catch (Exception e10) {
                logger.error("digest [{}] failure", algorithm, e10);
                return null;
            }
        } else {
            if (x1.f1.lb.config.b.f20643a.t()) {
                logger.debug("file not exits algorithm[{}] file[{}]", algorithm, file.getAbsolutePath());
            }
            return null;
        }
    }
}
