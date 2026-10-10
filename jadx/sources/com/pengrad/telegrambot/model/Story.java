package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Story implements Serializable {
    private static final long serialVersionUID = 0;
    private Chat chat;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private Integer f8239id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Story story = (Story) obj;
            if (Objects.equals(this.chat, story.chat) && Objects.equals(this.f8239id, story.f8239id)) {
                return true;
            }
        }
        return false;
    }

    public Chat chat() {
        return this.chat;
    }

    public int hashCode() {
        return Objects.hash(this.chat, this.f8239id);
    }

    public Integer id() {
        return this.f8239id;
    }

    public String toString() {
        return "Story{chat=" + this.chat + ", id=" + this.f8239id + '}';
    }
}
