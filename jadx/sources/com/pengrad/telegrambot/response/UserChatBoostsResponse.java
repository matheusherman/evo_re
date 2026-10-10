package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.chatboost.ChatBoost;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/pengrad/telegrambot/response/UserChatBoostsResponse;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "result", "Lcom/pengrad/telegrambot/response/UserChatBoostsResponse$ChatBoosts;", "(Lcom/pengrad/telegrambot/response/UserChatBoostsResponse$ChatBoosts;)V", "boosts", "", "Lcom/pengrad/telegrambot/model/chatboost/ChatBoost;", "()[Lcom/pengrad/telegrambot/model/chatboost/ChatBoost;", "component1", "copy", "equals", "", TransactionPartnerType.OTHER, "", "hashCode", "", "toString", "", "ChatBoosts", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class UserChatBoostsResponse extends BaseResponse {
    private final ChatBoosts result;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/pengrad/telegrambot/response/UserChatBoostsResponse$ChatBoosts;", "", "boosts", "", "Lcom/pengrad/telegrambot/model/chatboost/ChatBoost;", "(Ljava/util/List;)V", "getBoosts", "()Ljava/util/List;", "component1", "copy", "equals", "", TransactionPartnerType.OTHER, "hashCode", "", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ChatBoosts {
        private final List<ChatBoost> boosts;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ChatBoosts) && m.a(this.boosts, ((ChatBoosts) other).boosts);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ChatBoosts(List<? extends ChatBoost> boosts) {
            m.f(boosts, "boosts");
            this.boosts = boosts;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChatBoosts copy$default(ChatBoosts chatBoosts, List list, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                list = chatBoosts.boosts;
            }
            return chatBoosts.copy(list);
        }

        public final List<ChatBoost> component1() {
            return this.boosts;
        }

        public final ChatBoosts copy(List<? extends ChatBoost> boosts) {
            m.f(boosts, "boosts");
            return new ChatBoosts(boosts);
        }

        public final List<ChatBoost> getBoosts() {
            return this.boosts;
        }

        public int hashCode() {
            return this.boosts.hashCode();
        }

        public String toString() {
            return "ChatBoosts(boosts=" + this.boosts + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserChatBoostsResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UserChatBoostsResponse) && m.a(this.result, ((UserChatBoostsResponse) other).result);
    }

    public UserChatBoostsResponse(ChatBoosts result) {
        m.f(result, "result");
        this.result = result;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final ChatBoosts getResult() {
        return this.result;
    }

    public static /* synthetic */ UserChatBoostsResponse copy$default(UserChatBoostsResponse userChatBoostsResponse, ChatBoosts chatBoosts, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            chatBoosts = userChatBoostsResponse.result;
        }
        return userChatBoostsResponse.copy(chatBoosts);
    }

    public final ChatBoost[] boosts() {
        return (ChatBoost[]) this.result.getBoosts().toArray(new ChatBoost[0]);
    }

    public final UserChatBoostsResponse copy(ChatBoosts result) {
        m.f(result, "result");
        return new UserChatBoostsResponse(result);
    }

    public int hashCode() {
        return this.result.hashCode();
    }

    @Override // com.pengrad.telegrambot.response.BaseResponse
    public String toString() {
        return "UserChatBoostsResponse(result=" + this.result + ')';
    }

    public /* synthetic */ UserChatBoostsResponse(ChatBoosts chatBoosts, int i10, g gVar) {
        this((i10 & 1) != 0 ? new ChatBoosts(r.l()) : chatBoosts);
    }
}
