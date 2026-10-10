package com.pengrad.telegrambot.model.paidmedia;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PaidMediaPreview extends PaidMedia {
    public static final String TYPE = "preview";
    private Integer duration;
    private Integer height;
    private Integer width;

    @Override // com.pengrad.telegrambot.model.paidmedia.PaidMedia
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PaidMediaPreview paidMediaPreview = (PaidMediaPreview) obj;
            if (Objects.equals(type(), paidMediaPreview.type()) && Objects.equals(this.width, paidMediaPreview.width) && Objects.equals(this.height, paidMediaPreview.height) && Objects.equals(this.duration, paidMediaPreview.duration)) {
                return true;
            }
        }
        return false;
    }

    public PaidMediaPreview() {
        super(TYPE);
    }

    public Integer getDuration() {
        return this.duration;
    }

    public Integer getHeight() {
        return this.height;
    }

    public Integer getWidth() {
        return this.width;
    }

    @Override // com.pengrad.telegrambot.model.paidmedia.PaidMedia
    public String toString() {
        return "PaidMediaPreview{width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + '}';
    }

    @Override // com.pengrad.telegrambot.model.paidmedia.PaidMedia
    public int hashCode() {
        return Objects.hash(type(), this.width, this.height, this.duration);
    }
}
