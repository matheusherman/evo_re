package n;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class f extends d {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15824b;

        a(Context context, String str) {
            this.f15823a = context;
            this.f15824b = str;
        }

        @Override // n.d.a
        public File a() {
            File cacheDir = this.f15823a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f15824b != null ? new File(cacheDir, this.f15824b) : cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public f(Context context, String str, long j10) {
        super(new a(context, str), j10);
    }
}
