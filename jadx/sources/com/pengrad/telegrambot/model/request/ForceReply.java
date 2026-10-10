package com.pengrad.telegrambot.model.request;

import androidx.paging.a;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u00020\u00038\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/pengrad/telegrambot/model/request/ForceReply;", "Lcom/pengrad/telegrambot/model/request/Keyboard;", "selective", "", "inputFieldPlaceholder", "", "(ZLjava/lang/String;)V", "force_reply", "()Ljava/lang/String;", "setInputFieldPlaceholder", "(Ljava/lang/String;)V", "()Z", "setSelective", "(Z)V", "component1", "component2", "copy", "equals", TransactionPartnerType.OTHER, "", "hashCode", "", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ForceReply extends Keyboard {
    private final boolean force_reply;
    private String inputFieldPlaceholder;
    private boolean selective;

    /* JADX WARN: Multi-variable type inference failed */
    public ForceReply() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForceReply)) {
            return false;
        }
        ForceReply forceReply = (ForceReply) other;
        return this.selective == forceReply.selective && m.a(this.inputFieldPlaceholder, forceReply.inputFieldPlaceholder);
    }

    public final String inputFieldPlaceholder() {
        return this.inputFieldPlaceholder;
    }

    public final boolean selective() {
        return this.selective;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ForceReply(boolean z10) {
        this(z10, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ForceReply copy$default(ForceReply forceReply, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = forceReply.selective;
        }
        if ((i10 & 2) != 0) {
            str = forceReply.inputFieldPlaceholder;
        }
        return forceReply.copy(z10, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSelective() {
        return this.selective;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getInputFieldPlaceholder() {
        return this.inputFieldPlaceholder;
    }

    public final ForceReply copy(boolean selective, String inputFieldPlaceholder) {
        return new ForceReply(selective, inputFieldPlaceholder);
    }

    public int hashCode() {
        int iA = a.a(this.selective) * 31;
        String str = this.inputFieldPlaceholder;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public final ForceReply inputFieldPlaceholder(String inputFieldPlaceholder) {
        this.inputFieldPlaceholder = inputFieldPlaceholder;
        return this;
    }

    public final ForceReply selective(boolean selective) {
        this.selective = selective;
        return this;
    }

    public final void setInputFieldPlaceholder(String str) {
        this.inputFieldPlaceholder = str;
    }

    public final void setSelective(boolean z10) {
        this.selective = z10;
    }

    public String toString() {
        return "ForceReply(selective=" + this.selective + ", inputFieldPlaceholder=" + this.inputFieldPlaceholder + ')';
    }

    public /* synthetic */ ForceReply(boolean z10, String str, int i10, g gVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? null : str);
    }

    public ForceReply(boolean z10, String str) {
        this.selective = z10;
        this.inputFieldPlaceholder = str;
        this.force_reply = true;
    }
}
