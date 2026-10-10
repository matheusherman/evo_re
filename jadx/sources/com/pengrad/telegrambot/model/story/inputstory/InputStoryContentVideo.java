package com.pengrad.telegrambot.model.story.inputstory;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tR \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0007\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0005\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\b\u001a\u0004\u0018\u00010\t8\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\b\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/pengrad/telegrambot/model/story/inputstory/InputStoryContentVideo;", "Lcom/pengrad/telegrambot/model/story/inputstory/InputStoryContent;", "video", "", "(Ljava/lang/String;)V", TypedValues.TransitionType.S_DURATION, "", "coverFrameTimestamp", "isAnimation", "", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Boolean;)V", "()Ljava/lang/Double;", "setCoverFrameTimestamp", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "setDuration", "()Ljava/lang/Boolean;", "setAnimation", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "()Ljava/lang/String;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InputStoryContentVideo extends InputStoryContent {
    private Double coverFrameTimestamp;
    private Double duration;
    private Boolean isAnimation;
    private final String video;

    private InputStoryContentVideo(String str, Double d10, Double d11, Boolean bool) {
        super("video");
        this.video = str;
        this.duration = d10;
        this.coverFrameTimestamp = d11;
        this.isAnimation = bool;
    }

    /* JADX INFO: renamed from: coverFrameTimestamp, reason: from getter */
    public final Double getCoverFrameTimestamp() {
        return this.coverFrameTimestamp;
    }

    /* JADX INFO: renamed from: duration, reason: from getter */
    public final Double getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: isAnimation, reason: from getter */
    public final Boolean getIsAnimation() {
        return this.isAnimation;
    }

    public final InputStoryContentVideo coverFrameTimestamp(double coverFrameTimestamp) {
        this.coverFrameTimestamp = Double.valueOf(coverFrameTimestamp);
        return this;
    }

    public final InputStoryContentVideo duration(double duration) {
        this.duration = Double.valueOf(duration);
        return this;
    }

    public final InputStoryContentVideo isAnimation(boolean isAnimation) {
        this.isAnimation = Boolean.valueOf(isAnimation);
        return this;
    }

    public final void setAnimation(Boolean bool) {
        this.isAnimation = bool;
    }

    public final void setCoverFrameTimestamp(Double d10) {
        this.coverFrameTimestamp = d10;
    }

    public final void setDuration(Double d10) {
        this.duration = d10;
    }

    /* JADX INFO: renamed from: video, reason: from getter */
    public final String getVideo() {
        return this.video;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InputStoryContentVideo(String video) {
        this(video, null, null, null);
        m.f(video, "video");
    }
}
