package androidx.leanback.media;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public abstract class PlayerAdapter {
    Callback mCallback;

    public boolean isPlaying() {
        return false;
    }

    public boolean isPrepared() {
        return true;
    }

    public abstract void pause();

    public abstract void play();

    public long getBufferedPosition() {
        return 0L;
    }

    public final Callback getCallback() {
        return this.mCallback;
    }

    public long getCurrentPosition() {
        return 0L;
    }

    public long getDuration() {
        return 0L;
    }

    public long getSupportedActions() {
        return 64L;
    }

    public final void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void fastForward() {
    }

    public void next() {
    }

    public void onDetachedFromHost() {
    }

    public void previous() {
    }

    public void rewind() {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class Callback {
        public void onBufferedPositionChanged(PlayerAdapter playerAdapter) {
        }

        public void onCurrentPositionChanged(PlayerAdapter playerAdapter) {
        }

        public void onDurationChanged(PlayerAdapter playerAdapter) {
        }

        public void onMetadataChanged(PlayerAdapter playerAdapter) {
        }

        public void onPlayCompleted(PlayerAdapter playerAdapter) {
        }

        public void onPlayStateChanged(PlayerAdapter playerAdapter) {
        }

        public void onPreparedStateChanged(PlayerAdapter playerAdapter) {
        }

        public void onBufferingStateChanged(PlayerAdapter playerAdapter, boolean z10) {
        }

        public void onError(PlayerAdapter playerAdapter, int i10, String str) {
        }

        public void onVideoSizeChanged(PlayerAdapter playerAdapter, int i10, int i11) {
        }
    }

    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
    }

    public void seekTo(long j10) {
    }

    public void setProgressUpdatingEnabled(boolean z10) {
    }

    public void setRepeatAction(int i10) {
    }

    public void setShuffleAction(int i10) {
    }
}
