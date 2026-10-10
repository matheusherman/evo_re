package com.pengrad.telegrambot.model.reaction;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ReactionCount {
    private Integer total_count;
    private ReactionType type;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ReactionCount reactionCount = (ReactionCount) obj;
            if (Objects.equals(this.type, reactionCount.type) && Objects.equals(this.total_count, reactionCount.total_count)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.type, this.total_count);
    }

    public String toString() {
        return "ReactionCount{type=" + this.type + ", total_count=" + this.total_count + '}';
    }

    public Integer totalCount() {
        return this.total_count;
    }

    public ReactionType type() {
        return this.type;
    }
}
