package x1.f1.lb.util;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\tJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0011J\r\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0011J\r\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0011J\r\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0011J\r\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0011J\r\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0011J\r\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u0011J\r\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u0011J\r\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u0011J\r\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u0011J\u001d\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\n¢\u0006\u0004\b!\u0010\u0011J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\"¢\u0006\u0004\b%\u0010$R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010&R\u0016\u0010(\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010&R\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010&R\u0016\u0010*\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010&R\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010&R\u0016\u0010,\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010&R\u0016\u0010-\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\b\u0010&R\u0016\u0010.\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010&R\u0016\u0010/\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u00100\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010&R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010&R\u0016\u00102\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010&R\u0016\u00103\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010&R\u0016\u00104\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010&R\u0016\u00106\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u00105R\u0016\u00107\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u00105¨\u00068"}, d2 = {"Lx1/f1/lb/util/b1;", "", "<init>", "()V", "Lr8/z;", "q", "Ljava/io/File;", "fileDirs", "h", "(Ljava/io/File;)V", "", "subPath", "g", "(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;", "a", "m", "f", "()Ljava/lang/String;", "c", "e", "b", "i", "s", "t", "n", "u", "o", "r", "p", "dir", "fileName", "d", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "k", "", "l", "()J", "j", "Ljava/lang/String;", "appCachePathM", "appCachePathGtM", "epgCachePath", "tmpCachePath", "crashLogPath", "videoDataPath", "videoFullDataPath", "vodPlaylistCachePath", "fileDataPath", "playPositionHistoryPath", "signatureCachePath", "subscribeCachePath", "sportsCachePath", "hostsCachePath", "J", "totalStorage", "freeStorage", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b1 f21324a = new b1();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String appCachePathM;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String appCachePathGtM;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static String epgCachePath;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static String tmpCachePath;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static String crashLogPath;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static String videoDataPath;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static String videoFullDataPath;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static String vodPlaylistCachePath;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static String fileDataPath;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static String playPositionHistoryPath;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static String signatureCachePath;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static String subscribeCachePath;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static String sportsCachePath;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static String hostsCachePath;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private static long totalStorage;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static long freeStorage;

    private final void a() {
        String str = tmpCachePath;
        if (str == null) {
            kotlin.jvm.internal.m.v("tmpCachePath");
            str = null;
        }
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            file.delete();
        }
    }

    private final String g(File fileDirs, String subPath) {
        File file = new File(fileDirs, subPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        kotlin.jvm.internal.m.e(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    private final void h(File fileDirs) {
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        epgCachePath = g(fileDirs, "epg_" + bVar.g());
        appCachePathM = fileDirs.getAbsolutePath();
        appCachePathGtM = g(fileDirs, "upgrade");
        tmpCachePath = g(fileDirs, "_tmp_" + bVar.g());
        crashLogPath = g(fileDirs, "log_" + bVar.g());
        videoDataPath = g(fileDirs, "v_data_" + bVar.g());
        videoFullDataPath = g(fileDirs, "v_f_data_" + bVar.g());
        fileDataPath = g(fileDirs, "f_data_" + bVar.g());
        playPositionHistoryPath = g(fileDirs, "vod_play_hist_" + bVar.g());
        vodPlaylistCachePath = g(fileDirs, "vod_playlist_" + bVar.g());
        signatureCachePath = g(fileDirs, "signature_" + bVar.g());
        subscribeCachePath = g(fileDirs, "subscribe_" + bVar.g());
        sportsCachePath = g(fileDirs, "sports" + bVar.g());
        hostsCachePath = g(fileDirs, "hosts_" + bVar.g());
        String str = appCachePathM;
        String str2 = null;
        if (str == null) {
            kotlin.jvm.internal.m.v("appCachePathM");
            str = null;
        }
        File file = new File(str, "upgrade.apk");
        if (file.exists()) {
            file.delete();
        }
        String str3 = appCachePathGtM;
        if (str3 == null) {
            kotlin.jvm.internal.m.v("appCachePathGtM");
        } else {
            str2 = str3;
        }
        File file2 = new File(str2, "upgrade.apk");
        if (file2.exists()) {
            file2.delete();
        }
    }

    private final void q() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        totalStorage = statFs.getTotalBytes();
        freeStorage = statFs.getFreeBytes();
    }

    public final String b() {
        String str = crashLogPath;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.m.v("crashLogPath");
        return null;
    }

    public final String c() {
        String str = epgCachePath;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.m.v("epgCachePath");
        return null;
    }

    public final String d(String dir, String fileName) {
        kotlin.jvm.internal.m.f(dir, "dir");
        kotlin.jvm.internal.m.f(fileName, "fileName");
        return dir + File.separator + fileName;
    }

    public final String e() {
        String str = tmpCachePath;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.m.v("tmpCachePath");
        return null;
    }

    public final String f() {
        if (Build.VERSION.SDK_INT >= 24) {
            String str = appCachePathGtM;
            if (str != null) {
                return str;
            }
            kotlin.jvm.internal.m.v("appCachePathGtM");
            return null;
        }
        String str2 = appCachePathM;
        if (str2 != null) {
            return str2;
        }
        kotlin.jvm.internal.m.v("appCachePathM");
        return null;
    }

    public final String i() {
        String str = fileDataPath;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.m.v("fileDataPath");
        return null;
    }

    public final long j() {
        return freeStorage;
    }

    public final String k() {
        String str = hostsCachePath;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.m.v("hostsCachePath");
        return null;
    }

    public final long l() {
        return totalStorage;
    }

    public final void m(File fileDirs) {
        kotlin.jvm.internal.m.f(fileDirs, "fileDirs");
        q();
        h(fileDirs);
        a();
    }

    public final String n() {
        String str = playPositionHistoryPath;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.m.v("playPositionHistoryPath");
        return null;
    }

    public final String o() {
        String str = signatureCachePath;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.m.v("signatureCachePath");
        return null;
    }

    public final String p() {
        String str = sportsCachePath;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.m.v("sportsCachePath");
        return null;
    }

    public final String r() {
        String str = subscribeCachePath;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.m.v("subscribeCachePath");
        return null;
    }

    public final String s() {
        String str = videoDataPath;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.m.v("videoDataPath");
        return null;
    }

    public final String t() {
        String str = videoFullDataPath;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.m.v("videoFullDataPath");
        return null;
    }

    public final String u() {
        String str = vodPlaylistCachePath;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.m.v("vodPlaylistCachePath");
        return null;
    }

    private b1() {
    }
}
