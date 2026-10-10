package com.pengrad.telegrambot.model.stars;

import androidx.paging.a;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/pengrad/telegrambot/model/stars/DirectMessagePriceChanged;", "", "areDirectMessagesEnabled", "", "directMessageStarCount", "", "(ZLjava/lang/Integer;)V", "()Z", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ZLjava/lang/Integer;)Lcom/pengrad/telegrambot/model/stars/DirectMessagePriceChanged;", "equals", TransactionPartnerType.OTHER, "hashCode", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class DirectMessagePriceChanged {
    private final boolean areDirectMessagesEnabled;
    private final Integer directMessageStarCount;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectMessagePriceChanged)) {
            return false;
        }
        DirectMessagePriceChanged directMessagePriceChanged = (DirectMessagePriceChanged) other;
        return this.areDirectMessagesEnabled == directMessagePriceChanged.areDirectMessagesEnabled && m.a(this.directMessageStarCount, directMessagePriceChanged.directMessageStarCount);
    }

    public static /* synthetic */ DirectMessagePriceChanged copy$default(DirectMessagePriceChanged directMessagePriceChanged, boolean z10, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = directMessagePriceChanged.areDirectMessagesEnabled;
        }
        if ((i10 & 2) != 0) {
            num = directMessagePriceChanged.directMessageStarCount;
        }
        return directMessagePriceChanged.copy(z10, num);
    }

    /* JADX INFO: renamed from: areDirectMessagesEnabled, reason: from getter */
    public final boolean getAreDirectMessagesEnabled() {
        return this.areDirectMessagesEnabled;
    }

    public final boolean component1() {
        return this.areDirectMessagesEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getDirectMessageStarCount() {
        return this.directMessageStarCount;
    }

    public final DirectMessagePriceChanged copy(boolean areDirectMessagesEnabled, Integer directMessageStarCount) {
        return new DirectMessagePriceChanged(areDirectMessagesEnabled, directMessageStarCount);
    }

    public final Integer directMessageStarCount() {
        return this.directMessageStarCount;
    }

    public int hashCode() {
        int iA = a.a(this.areDirectMessagesEnabled) * 31;
        Integer num = this.directMessageStarCount;
        return iA + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "DirectMessagePriceChanged(areDirectMessagesEnabled=" + this.areDirectMessagesEnabled + ", directMessageStarCount=" + this.directMessageStarCount + ')';
    }

    public DirectMessagePriceChanged(boolean z10, Integer num) {
        this.areDirectMessagesEnabled = z10;
        this.directMessageStarCount = num;
    }
}
