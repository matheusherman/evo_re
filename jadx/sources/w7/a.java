package w7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import com.stub.StubApp;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0003\u0007\u0016\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010 R\u0011\u0010$\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010#¨\u0006&"}, d2 = {"Lw7/a;", "", "Landroid/content/Context;", "mContext", "<init>", "(Landroid/content/Context;)V", "Lr8/z;", "c", "()V", "Lw7/a$c;", "volumeChangeListener", "e", "(Lw7/a$c;)V", "context", "Landroid/content/BroadcastReceiver;", "receiver", "Landroid/content/IntentFilter;", "filter", "d", "(Landroid/content/Context;Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V", "a", "Landroid/content/Context;", "b", "Lw7/a$c;", "mVolumeChangeListener", "Lw7/a$b;", "Lw7/a$b;", "mVolumeBroadcastReceiver", "Landroid/media/AudioManager;", "Landroid/media/AudioManager;", "mAudioManager", "", "Z", "mRegistered", "", "()I", "currentMusicVolume", "f", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private c mVolumeChangeListener;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private b mVolumeBroadcastReceiver;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AudioManager mAudioManager;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mRegistered;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lw7/a$b;", "Landroid/content/BroadcastReceiver;", "Lw7/a;", "mVolumeChangeObserver", "<init>", "(Lw7/a;)V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lr8/z;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "Lw7/a;", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private a mVolumeChangeObserver;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a aVar;
            c cVar;
            int iB;
            m.f(context, "context");
            m.f(intent, "intent");
            if (!m.a("android.media.VOLUME_CHANGED_ACTION", intent.getAction()) || intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3 || (aVar = this.mVolumeChangeObserver) == null || (cVar = aVar.mVolumeChangeListener) == null || (iB = aVar.b()) < 0) {
                return;
            }
            cVar.a(iB);
        }

        public b(a aVar) {
            this.mVolumeChangeObserver = aVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lw7/a$c;", "", "", "volume", "Lr8/z;", "a", "(I)V", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface c {
        void a(int volume);
    }

    public a(Context mContext) {
        m.f(mContext, "mContext");
        this.mContext = mContext;
        Object systemService = StubApp.getOrigApplicationContext(mContext.getApplicationContext()).getSystemService("audio");
        m.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.mAudioManager = (AudioManager) systemService;
    }

    public final int b() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return -1;
    }

    public final void c() {
        if (this.mRegistered) {
            return;
        }
        this.mVolumeBroadcastReceiver = new b(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        d(this.mContext, this.mVolumeBroadcastReceiver, intentFilter);
        this.mRegistered = true;
    }

    public final void d(Context context, BroadcastReceiver receiver, IntentFilter filter) {
        m.f(context, "context");
        if (Build.VERSION.SDK_INT >= 34) {
            context.registerReceiver(receiver, filter, 2);
        } else {
            context.registerReceiver(receiver, filter);
        }
    }

    public final void e(c volumeChangeListener) {
        m.f(volumeChangeListener, "volumeChangeListener");
        this.mVolumeChangeListener = volumeChangeListener;
    }
}
