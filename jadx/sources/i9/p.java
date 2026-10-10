package i9;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u000bB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u000e¨\u0006\u001a"}, d2 = {"Li9/p;", "", "Li9/q;", "variance", "Li9/n;", IjkMediaMeta.IJKM_KEY_TYPE, "<init>", "(Li9/q;Li9/n;)V", "", "toString", "()Ljava/lang/String;", "a", "()Li9/q;", "b", "()Li9/n;", "", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Li9/q;", "d", "Li9/n;", "c", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class p {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p f11247d = new p(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q variance;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final n type;

    /* JADX INFO: renamed from: i9.p$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\bR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Li9/p$a;", "", "<init>", "()V", "Li9/n;", IjkMediaMeta.IJKM_KEY_TYPE, "Li9/p;", "d", "(Li9/n;)Li9/p;", "a", "b", "c", "()Li9/p;", "STAR", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final p a(n type) {
            kotlin.jvm.internal.m.f(type, "type");
            return new p(q.IN, type);
        }

        public final p b(n type) {
            kotlin.jvm.internal.m.f(type, "type");
            return new p(q.OUT, type);
        }

        public final p c() {
            return p.f11247d;
        }

        public final p d(n type) {
            kotlin.jvm.internal.m.f(type, "type");
            return new p(q.INVARIANT, type);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof p)) {
            return false;
        }
        p pVar = (p) other;
        return this.variance == pVar.variance && kotlin.jvm.internal.m.a(this.type, pVar.type);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11250a;

        static {
            int[] iArr = new int[q.values().length];
            try {
                iArr[q.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[q.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[q.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f11250a = iArr;
        }
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final q getVariance() {
        return this.variance;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final n getType() {
        return this.type;
    }

    public final n c() {
        return this.type;
    }

    public final q d() {
        return this.variance;
    }

    public int hashCode() {
        q qVar = this.variance;
        int iHashCode = (qVar == null ? 0 : qVar.hashCode()) * 31;
        n nVar = this.type;
        return iHashCode + (nVar != null ? nVar.hashCode() : 0);
    }

    public String toString() {
        q qVar = this.variance;
        int i10 = qVar == null ? -1 : b.f11250a[qVar.ordinal()];
        if (i10 == -1) {
            return "*";
        }
        if (i10 == 1) {
            return String.valueOf(this.type);
        }
        if (i10 == 2) {
            return "in " + this.type;
        }
        if (i10 != 3) {
            throw new r8.n();
        }
        return "out " + this.type;
    }

    public p(q qVar, n nVar) {
        boolean z10;
        String str;
        this.variance = qVar;
        this.type = nVar;
        if (qVar == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 == (nVar == null)) {
            return;
        }
        if (qVar == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + qVar + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }
}
