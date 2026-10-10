package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class VideoChatEnded implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer duration;

    public Integer duration() {
        return this.duration;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.duration, ((VideoChatEnded) obj).duration);
    }

    public int hashCode() {
        return Objects.hash(this.duration);
    }

    public String toString() {
        return "VideoChatEnded{duration=" + this.duration + '}';
    }
}
