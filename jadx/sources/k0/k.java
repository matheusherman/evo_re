package k0;

import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public interface k {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
    }

    void A(@Nullable TextureView textureView);

    void B();

    long C();

    boolean a();

    void b(a aVar);

    void c(int i10, long j10);

    boolean d();

    void e(boolean z10);

    void f(@Nullable TextureView textureView);

    e1.e g();

    int getPlaybackState();

    int getRepeatMode();

    void h(@Nullable SurfaceView surfaceView);

    void i();

    boolean isPlaying();

    @Nullable
    i j();

    long k();

    long l();

    void m(a aVar);

    List<y0.a> n();

    int o();

    boolean p(int i10);

    void pause();

    void play();

    void prepare();

    void q(@Nullable SurfaceView surfaceView);

    n r();

    m s();

    void setRepeatMode(int i10);

    j t();

    Looper u();

    boolean v();

    a1.b w();

    long x();

    void y();

    void z();
}
