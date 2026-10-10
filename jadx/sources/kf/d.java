package kf;

import android.media.MediaCrypto;
import androidx.annotation.RequiresApi;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@RequiresApi(api = 18)
public interface d {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a implements d {
        @Override // kf.d
        public MediaCrypto a(int i10) {
            return null;
        }

        @Override // kf.d
        public kf.a b(kf.b bVar, int i10) {
            return kf.a.STATE_LOADED;
        }

        @Override // kf.d
        public kf.a c(int i10, int i11) {
            return kf.a.STATE_LOADED;
        }

        @Override // kf.d
        public void prepare() {
        }

        @Override // kf.d
        public void release() {
        }

        @Override // kf.d
        public void d(e eVar) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class b {
        private d b(String str, Map<String, String> map, UUID uuid, boolean z10) {
            return (d) Class.forName("tv.danmaku.ijk.media.drm.wrapper.DefaultDrmManager").getDeclaredConstructor(String.class, Map.class, UUID.class, Boolean.TYPE).newInstance(str, map, uuid, Boolean.valueOf(z10));
        }

        public d a(String str, Map<String, String> map, UUID uuid, boolean z10) {
            try {
                try {
                    d dVarB = b(str, map, uuid, z10);
                    if (dVarB == null) {
                        return new a();
                    }
                    return dVarB;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return new a();
                }
            } catch (Throwable th) {
                new a();
                throw th;
            }
        }
    }

    MediaCrypto a(int i10);

    kf.a b(kf.b bVar, int i10);

    kf.a c(int i10, int i11);

    void d(e eVar);

    void prepare();

    void release();
}
