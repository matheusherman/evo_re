package q7;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u0006\u0010\t¨\u0006\u000b"}, d2 = {"Lq7/a;", "", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "a", "Ljava/lang/Object;", "getFrom", "()Ljava/lang/Object;", "b", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Object from;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Object to;

    public a(Object from, Object to) {
        m.f(from, "from");
        m.f(to, "to");
        this.from = from;
        this.to = to;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Object getTo() {
        return this.to;
    }
}
