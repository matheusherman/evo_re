package androidx.leanback.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class MediaControllerAdapter extends PlayerAdapter {
    private static final boolean DEBUG = false;
    private static final String TAG = "MediaControllerAdapter";
    private MediaControllerCompat mController;
    Handler mHandler = new Handler();
    private final Runnable mPositionUpdaterRunnable = new Runnable() { // from class: androidx.leanback.media.MediaControllerAdapter.1
        @Override // java.lang.Runnable
        public void run() {
            MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
            MediaControllerAdapter mediaControllerAdapter = MediaControllerAdapter.this;
            mediaControllerAdapter.mHandler.postDelayed(this, mediaControllerAdapter.getUpdatePeriod());
        }
    };
    boolean mIsBuffering = false;
    MediaControllerCompat.Callback mMediaControllerCallback = new MediaControllerCompat.Callback() { // from class: androidx.leanback.media.MediaControllerAdapter.2
        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            MediaControllerAdapter.this.getCallback().onMetadataChanged(MediaControllerAdapter.this);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.Callback
        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
            if (MediaControllerAdapter.this.mIsBuffering && playbackStateCompat.getState() != 6) {
                MediaControllerAdapter.this.getCallback().onBufferingStateChanged(MediaControllerAdapter.this, false);
                MediaControllerAdapter.this.getCallback().onBufferedPositionChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.mIsBuffering = false;
            }
            if (playbackStateCompat.getState() == 0) {
                return;
            }
            if (playbackStateCompat.getState() == 1) {
                MediaControllerAdapter.this.getCallback().onPlayCompleted(MediaControllerAdapter.this);
                return;
            }
            if (playbackStateCompat.getState() == 2) {
                MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
                return;
            }
            if (playbackStateCompat.getState() == 3) {
                MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
                return;
            }
            if (playbackStateCompat.getState() == 6) {
                MediaControllerAdapter mediaControllerAdapter = MediaControllerAdapter.this;
                mediaControllerAdapter.mIsBuffering = true;
                mediaControllerAdapter.getCallback().onBufferingStateChanged(MediaControllerAdapter.this, true);
                MediaControllerAdapter.this.getCallback().onBufferedPositionChanged(MediaControllerAdapter.this);
                return;
            }
            if (playbackStateCompat.getState() == 7) {
                if (playbackStateCompat.getErrorMessage() == null) {
                    MediaControllerAdapter.this.getCallback().onError(MediaControllerAdapter.this, playbackStateCompat.getErrorCode(), "");
                    return;
                } else {
                    MediaControllerAdapter.this.getCallback().onError(MediaControllerAdapter.this, playbackStateCompat.getErrorCode(), playbackStateCompat.getErrorMessage().toString());
                    return;
                }
            }
            if (playbackStateCompat.getState() == 4) {
                MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
            } else if (playbackStateCompat.getState() == 5) {
                MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
            }
        }
    };

    private int mapRepeatActionToRepeatMode(int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (i10 != 1) {
            return i10 != 2 ? -1 : 1;
        }
        return 2;
    }

    private int mapShuffleActionToShuffleMode(int i10) {
        if (i10 != 0) {
            return i10 != 1 ? -1 : 1;
        }
        return 0;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void fastForward() {
        this.mController.getTransportControls().fastForward();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getBufferedPosition() {
        if (this.mController.getPlaybackState() == null) {
            return 0L;
        }
        return this.mController.getPlaybackState().getBufferedPosition();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getCurrentPosition() {
        if (this.mController.getPlaybackState() == null) {
            return 0L;
        }
        return this.mController.getPlaybackState().getPosition();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getDuration() {
        if (this.mController.getMetadata() == null) {
            return 0L;
        }
        return (int) this.mController.getMetadata().getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
    }

    public Drawable getMediaArt(Context context) {
        Bitmap iconBitmap;
        if (this.mController.getMetadata() == null || (iconBitmap = this.mController.getMetadata().getDescription().getIconBitmap()) == null) {
            return null;
        }
        return new BitmapDrawable(context.getResources(), iconBitmap);
    }

    public MediaControllerCompat getMediaController() {
        return this.mController;
    }

    public CharSequence getMediaSubtitle() {
        return this.mController.getMetadata() == null ? "" : this.mController.getMetadata().getDescription().getSubtitle();
    }

    public CharSequence getMediaTitle() {
        return this.mController.getMetadata() == null ? "" : this.mController.getMetadata().getDescription().getTitle();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getSupportedActions() {
        if (this.mController.getPlaybackState() == null) {
            return 0L;
        }
        long actions = this.mController.getPlaybackState().getActions();
        long j10 = (actions & 512) != 0 ? 64L : 0L;
        if ((actions & 32) != 0) {
            j10 |= 256;
        }
        if ((actions & 16) != 0) {
            j10 |= 16;
        }
        if ((64 & actions) != 0) {
            j10 |= 128;
        }
        if ((8 & actions) != 0) {
            j10 |= 32;
        }
        if ((PlaybackStateCompat.ACTION_SET_REPEAT_MODE & actions) != 0) {
            j10 |= 512;
        }
        return (actions & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) != 0 ? 1024 | j10 : j10;
    }

    int getUpdatePeriod() {
        return 16;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public boolean isPlaying() {
        if (this.mController.getPlaybackState() == null) {
            return false;
        }
        return this.mController.getPlaybackState().getState() == 3 || this.mController.getPlaybackState().getState() == 4 || this.mController.getPlaybackState().getState() == 5;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void next() {
        this.mController.getTransportControls().skipToNext();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
        this.mController.registerCallback(this.mMediaControllerCallback);
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void onDetachedFromHost() {
        this.mController.unregisterCallback(this.mMediaControllerCallback);
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void pause() {
        this.mController.getTransportControls().pause();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void play() {
        this.mController.getTransportControls().play();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void previous() {
        this.mController.getTransportControls().skipToPrevious();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void rewind() {
        this.mController.getTransportControls().rewind();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void seekTo(long j10) {
        this.mController.getTransportControls().seekTo(j10);
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void setProgressUpdatingEnabled(boolean z10) {
        this.mHandler.removeCallbacks(this.mPositionUpdaterRunnable);
        if (z10) {
            this.mHandler.postDelayed(this.mPositionUpdaterRunnable, getUpdatePeriod());
        }
    }

    public MediaControllerAdapter(MediaControllerCompat mediaControllerCompat) {
        if (mediaControllerCompat != null) {
            this.mController = mediaControllerCompat;
            return;
        }
        throw new NullPointerException("Object of MediaControllerCompat is null");
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void setRepeatAction(int i10) {
        this.mController.getTransportControls().setRepeatMode(mapRepeatActionToRepeatMode(i10));
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void setShuffleAction(int i10) {
        this.mController.getTransportControls().setShuffleMode(mapShuffleActionToShuffleMode(i10));
    }
}
