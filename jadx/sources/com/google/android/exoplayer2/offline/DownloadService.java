package com.google.android.exoplayer2.offline;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.exoplayer2.scheduler.Requirements;
import d1.d;
import d1.g;
import d1.k;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class DownloadService extends Service {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final HashMap<Class<? extends DownloadService>, a> f1621j = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f1622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @StringRes
    private final int f1623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @StringRes
    private final int f1624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f1625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1629h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1630i;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private DownloadService f1631a;

        public void b(DownloadService downloadService) {
            d1.a.c(this.f1631a == null);
            this.f1631a = downloadService;
            throw null;
        }

        public void c(DownloadService downloadService) {
            d1.a.c(this.f1631a == downloadService);
            this.f1631a = null;
        }

        static /* synthetic */ p0.a a(a aVar) {
            aVar.getClass();
            return null;
        }
    }

    protected abstract p0.a a();

    @Override // android.app.Service
    public void onDestroy() {
        this.f1630i = true;
        ((a) d1.a.b(this.f1625d)).c(this);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.f1628g = true;
    }

    @Override // android.app.Service
    @Nullable
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public void onCreate() {
        String str = this.f1622a;
        if (str != null) {
            g.a(this, str, this.f1623b, this.f1624c, 2);
        }
        a aVar = f1621j.get(getClass());
        if (aVar != null) {
            this.f1625d = aVar;
            aVar.b(this);
        } else {
            int i10 = k.f9577a;
            a();
            throw null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:18:0x0047  */
    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i10, int i11) {
        String action;
        String stringExtra;
        this.f1626e = i11;
        this.f1628g = false;
        if (intent != null) {
            action = intent.getAction();
            stringExtra = intent.getStringExtra("content_id");
            this.f1627f |= intent.getBooleanExtra("foreground", false) || "com.google.android.exoplayer.downloadService.action.RESTART".equals(action);
        } else {
            action = null;
            stringExtra = null;
        }
        if (action == null) {
            action = "com.google.android.exoplayer.downloadService.action.INIT";
        }
        a.a((a) d1.a.b(this.f1625d));
        switch (action) {
            case "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD":
                if (((DownloadRequest) ((Intent) d1.a.b(intent)).getParcelableExtra("download_request")) != null) {
                    intent.getIntExtra("stop_reason", 0);
                    throw null;
                }
                d.b("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
                break;
                break;
            case "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS":
                throw null;
            case "com.google.android.exoplayer.downloadService.action.RESTART":
            case "com.google.android.exoplayer.downloadService.action.INIT":
                break;
            case "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS":
                throw null;
            case "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS":
                if (((Requirements) ((Intent) d1.a.b(intent)).getParcelableExtra("requirements")) != null) {
                    throw null;
                }
                d.b("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
                break;
                break;
            case "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS":
                throw null;
            case "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON":
                if (!((Intent) d1.a.b(intent)).hasExtra("stop_reason")) {
                    d.b("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                } else {
                    intent.getIntExtra("stop_reason", 0);
                    throw null;
                }
                break;
            case "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD":
                if (stringExtra != null) {
                    throw null;
                }
                d.b("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                break;
                break;
            default:
                d.b("DownloadService", action.length() != 0 ? "Ignored unrecognized action: ".concat(action) : new String("Ignored unrecognized action: "));
                break;
        }
        int i12 = k.f9577a;
        this.f1629h = false;
        throw null;
    }
}
