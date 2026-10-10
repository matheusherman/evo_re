package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplApi26 extends AudioAttributesImplApi21 {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @RequiresApi(26)
    static class Builder extends AudioAttributesImplApi21.Builder {
        Builder() {
        }

        Builder(Object obj) {
            super(obj);
        }

        @Override // androidx.media.AudioAttributesImplApi21.Builder, androidx.media.AudioAttributesImpl.Builder
        @NonNull
        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi26(this.mFwkBuilder.build());
        }

        @Override // androidx.media.AudioAttributesImplApi21.Builder, androidx.media.AudioAttributesImpl.Builder
        @NonNull
        public Builder setUsage(int i10) {
            this.mFwkBuilder.setUsage(i10);
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributesImplApi26() {
    }

    AudioAttributesImplApi26(AudioAttributes audioAttributes) {
        super(audioAttributes, -1);
    }

    @Override // androidx.media.AudioAttributesImplApi21, androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        return this.mAudioAttributes.getVolumeControlStream();
    }
}
