package com.pengrad.telegrambot.model.paidmedia;

import com.pengrad.telegrambot.model.PhotoSize;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PaidMediaPhoto extends PaidMedia {
    public static final String TYPE = "photo";
    private PhotoSize[] photo;

    public PaidMediaPhoto() {
        super(TYPE);
    }

    @Override // com.pengrad.telegrambot.model.paidmedia.PaidMedia
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && super.equals(obj)) {
            return Objects.deepEquals(this.photo, ((PaidMediaPhoto) obj).photo);
        }
        return false;
    }

    public PhotoSize[] getPhoto() {
        return this.photo;
    }

    @Override // com.pengrad.telegrambot.model.paidmedia.PaidMedia
    public String toString() {
        return "PaidMediaPhoto{photo=" + Arrays.toString(this.photo) + '}';
    }

    @Override // com.pengrad.telegrambot.model.paidmedia.PaidMedia
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), Integer.valueOf(Arrays.hashCode(this.photo)));
    }
}
