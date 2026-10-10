package m3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;
import com.google.zxing.client.android.R$raw;
import com.stub.StubApp;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15595d = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15597b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15598c = false;

    @SuppressLint({"MissingPermission"})
    public synchronized void d() {
        Vibrator vibrator;
        try {
            if (this.f15597b) {
                c();
            }
            if (this.f15598c && (vibrator = (Vibrator) this.f15596a.getSystemService("vibrator")) != null) {
                vibrator.vibrate(200L);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static /* synthetic */ boolean b(MediaPlayer mediaPlayer, int i10, int i11) {
        Log.w(f15595d, "Failed to beep " + i10 + ", " + i11);
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        return true;
    }

    public MediaPlayer c() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).build());
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: m3.c
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                e.a(mediaPlayer2);
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: m3.d
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i10, int i11) {
                return e.b(mediaPlayer2, i10, i11);
            }
        });
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.f15596a.getResources().openRawResourceFd(R$raw.zxing_beep);
            try {
                mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                assetFileDescriptorOpenRawResourceFd.close();
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                mediaPlayer.start();
                return mediaPlayer;
            } catch (Throwable th) {
                assetFileDescriptorOpenRawResourceFd.close();
                throw th;
            }
        } catch (IOException e10) {
            Log.w(f15595d, e10);
            mediaPlayer.reset();
            mediaPlayer.release();
            return null;
        }
    }

    public void e(boolean z10) {
        this.f15597b = z10;
    }

    public e(Activity activity) {
        activity.setVolumeControlStream(3);
        this.f15596a = StubApp.getOrigApplicationContext(activity.getApplicationContext());
    }

    public static /* synthetic */ void a(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
    }
}
