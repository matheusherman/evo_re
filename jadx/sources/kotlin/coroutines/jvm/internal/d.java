package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b!\u0018\u00002\u00020\u0001B#\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u001b\b\u0016\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u0015\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000fR \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lkotlin/coroutines/jvm/internal/d;", "Lkotlin/coroutines/jvm/internal/a;", "Lv8/f;", "", "completion", "Lv8/j;", "_context", "<init>", "(Lv8/f;Lv8/j;)V", "(Lv8/f;)V", "intercepted", "()Lv8/f;", "Lr8/z;", "releaseIntercepted", "()V", "Lv8/j;", "Lv8/f;", "getContext", "()Lv8/j;", "context", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class d extends a {
    private final v8.j _context;
    private transient v8.f<Object> intercepted;

    public d(v8.f<Object> fVar, v8.j jVar) {
        super(fVar);
        this._context = jVar;
    }

    @Override // v8.f
    public v8.j getContext() {
        v8.j jVar = this._context;
        m.c(jVar);
        return jVar;
    }

    public final v8.f<Object> intercepted() {
        v8.f<Object> fVarInterceptContinuation = this.intercepted;
        if (fVarInterceptContinuation == null) {
            v8.g gVar = (v8.g) getContext().get(v8.g.INSTANCE);
            if (gVar == null || (fVarInterceptContinuation = gVar.interceptContinuation(this)) == null) {
                fVarInterceptContinuation = this;
            }
            this.intercepted = fVarInterceptContinuation;
        }
        return fVarInterceptContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    protected void releaseIntercepted() {
        v8.f<?> fVar = this.intercepted;
        if (fVar != null && fVar != this) {
            v8.j.b bVar = getContext().get(v8.g.INSTANCE);
            m.c(bVar);
            ((v8.g) bVar).releaseInterceptedContinuation(fVar);
        }
        this.intercepted = c.f12323a;
    }

    public d(v8.f<Object> fVar) {
        this(fVar, fVar != null ? fVar.getContext() : null);
    }
}
