package com.pengrad.telegrambot.model.inputprofilephoto;

import com.pengrad.telegrambot.model.paidmedia.PaidMediaPhoto;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/pengrad/telegrambot/model/inputprofilephoto/InputProfilePhotoStatic;", "Lcom/pengrad/telegrambot/model/inputprofilephoto/InputProfilePhoto;", PaidMediaPhoto.TYPE, "", "(Ljava/lang/String;)V", "()Ljava/lang/String;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InputProfilePhotoStatic extends InputProfilePhoto {
    private final String photo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputProfilePhotoStatic(String photo) {
        super("static");
        m.f(photo, "photo");
        this.photo = photo;
    }

    /* JADX INFO: renamed from: photo, reason: from getter */
    public final String getPhoto() {
        return this.photo;
    }
}
