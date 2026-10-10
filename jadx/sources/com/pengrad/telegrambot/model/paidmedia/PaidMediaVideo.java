package com.pengrad.telegrambot.model.paidmedia;

import com.pengrad.telegrambot.model.Video;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PaidMediaVideo extends PaidMedia {
    public static final String TYPE = "video";
    private Video video;

    @Override // com.pengrad.telegrambot.model.paidmedia.PaidMedia
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PaidMediaVideo paidMediaVideo = (PaidMediaVideo) obj;
            if (Objects.equals(type(), paidMediaVideo.type()) && Objects.equals(this.video, paidMediaVideo.video)) {
                return true;
            }
        }
        return false;
    }

    public PaidMediaVideo() {
        super("video");
    }

    public Video getVideo() {
        return this.video;
    }

    @Override // com.pengrad.telegrambot.model.paidmedia.PaidMedia
    public String toString() {
        return "PaidMediaVideo{video=" + this.video + '}';
    }

    @Override // com.pengrad.telegrambot.model.paidmedia.PaidMedia
    public int hashCode() {
        return Objects.hash(type(), this.video);
    }
}
