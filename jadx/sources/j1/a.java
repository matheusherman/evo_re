package j1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f11532a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue f11533b = new LinkedBlockingQueue();

    @NonNull
    public IBinder a(long j10, @NonNull TimeUnit timeUnit) throws TimeoutException {
        m1.g.j("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f11532a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f11532a = true;
        IBinder iBinder = (IBinder) this.f11533b.poll(j10, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        this.f11533b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(@NonNull ComponentName componentName) {
    }
}
