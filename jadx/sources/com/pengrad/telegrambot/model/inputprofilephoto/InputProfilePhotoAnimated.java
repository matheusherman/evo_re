package com.pengrad.telegrambot.model.inputprofilephoto;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0005\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/pengrad/telegrambot/model/inputprofilephoto/InputProfilePhotoAnimated;", "Lcom/pengrad/telegrambot/model/inputprofilephoto/InputProfilePhoto;", "animation", "", "(Ljava/lang/String;)V", "mainFrameTimestamp", "", "(Ljava/lang/String;Ljava/lang/Double;)V", "()Ljava/lang/String;", "()Ljava/lang/Double;", "setMainFrameTimestamp", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InputProfilePhotoAnimated extends InputProfilePhoto {
    private final String animation;
    private Double mainFrameTimestamp;

    private InputProfilePhotoAnimated(String str, Double d10) {
        super("animated");
        this.animation = str;
        this.mainFrameTimestamp = d10;
    }

    /* JADX INFO: renamed from: mainFrameTimestamp, reason: from getter */
    public final Double getMainFrameTimestamp() {
        return this.mainFrameTimestamp;
    }

    /* JADX INFO: renamed from: animation, reason: from getter */
    public final String getAnimation() {
        return this.animation;
    }

    public final InputProfilePhotoAnimated mainFrameTimestamp(double mainFrameTimestamp) {
        this.mainFrameTimestamp = Double.valueOf(mainFrameTimestamp);
        return this;
    }

    public final void setMainFrameTimestamp(Double d10) {
        this.mainFrameTimestamp = d10;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InputProfilePhotoAnimated(String animation) {
        this(animation, null);
        m.f(animation, "animation");
    }
}
