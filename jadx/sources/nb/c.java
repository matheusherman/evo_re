package nb;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lnb/c;", "", "Ltb/g;", "name", "value", "<init>", "(Ltb/g;Ltb/g;)V", "", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ltb/g;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "a", "()Ltb/g;", "b", "", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ltb/g;", "c", "I", "hpackSize", "d", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final tb.g f16126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final tb.g f16127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final tb.g f16128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final tb.g f16129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final tb.g f16130i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final tb.g f16131j;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final tb.g name;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final tb.g value;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int hpackSize;

    public c(tb.g name, tb.g value) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(value, "value");
        this.name = name;
        this.value = value;
        this.hpackSize = name.x() + 32 + value.x();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        return kotlin.jvm.internal.m.a(this.name, cVar.name) && kotlin.jvm.internal.m.a(this.value, cVar.value);
    }

    static {
        tb.g.Companion companion = tb.g.INSTANCE;
        f16126e = companion.c(":");
        f16127f = companion.c(":status");
        f16128g = companion.c(":method");
        f16129h = companion.c(":path");
        f16130i = companion.c(":scheme");
        f16131j = companion.c(":authority");
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final tb.g getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final tb.g getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return this.name.A() + ": " + this.value.A();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(String name, String value) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(value, "value");
        tb.g.Companion companion = tb.g.INSTANCE;
        this(companion.c(name), companion.c(value));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(tb.g name, String value) {
        this(name, tb.g.INSTANCE.c(value));
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(value, "value");
    }
}
