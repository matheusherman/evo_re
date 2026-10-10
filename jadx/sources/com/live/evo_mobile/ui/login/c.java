package com.live.evo_mobile.ui.login;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000b\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/live/evo_mobile/ui/login/c;", "", "", "phonePreCode", "countryCode", "countryShowName", "", "seq", "reg", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "b", "d", "I", "e", "()I", "f", "(Ljava/lang/String;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String phonePreCode;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String countryCode;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String countryShowName;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int seq;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String reg;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getCountryShowName() {
        return this.countryShowName;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getPhonePreCode() {
        return this.phonePreCode;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getReg() {
        return this.reg;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getSeq() {
        return this.seq;
    }

    public final void f(String str) {
        this.reg = str;
    }

    public c(String str, String str2, String str3, int i10, String str4) {
        this.phonePreCode = str;
        this.countryCode = str2;
        this.countryShowName = str3;
        this.seq = i10;
        this.reg = str4;
    }
}
