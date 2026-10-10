package xa;

import c9.q;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n;
import kotlinx.coroutines.x2;
import r8.z;
import v8.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0016J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u000e\u0018\u00010\tR\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u00020\u000f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010#\u001a\u00020\u001f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010 \u001a\u0004\b!\u0010\"R(\u0010&\u001a\u0014\u0012\u000e\u0012\f0\tR\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010'R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010'R\u0011\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030,8\u0002X\u0082\u0004¨\u0006."}, d2 = {"Lxa/a;", "R", "Lkotlinx/coroutines/l;", "", "clauseObject", "internalResult", "", "h", "(Ljava/lang/Object;Ljava/lang/Object;)I", "Lxa/a$a;", "f", "(Ljava/lang/Object;)Lxa/a$a;", "Lkotlinx/coroutines/internal/c0;", "segment", "index", "Lr8/z;", "b", "(Lkotlinx/coroutines/internal/c0;I)V", "c", "(Ljava/lang/Object;)V", "result", "", "a", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lxa/d;", "g", "(Ljava/lang/Object;Ljava/lang/Object;)Lxa/d;", "", "cause", "e", "(Ljava/lang/Throwable;)V", "Lv8/j;", "Lv8/j;", "getContext", "()Lv8/j;", "context", "", "Ljava/util/List;", "clauses", "Ljava/lang/Object;", "disposableHandleOrSegment", "d", "I", "indexInSegment", "Lkotlinx/atomicfu/AtomicRef;", "state", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class a<R> extends l implements b, x2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f22024f = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "state");

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final j context;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<a<R>.C0475a> clauses;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Object disposableHandleOrSegment;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int indexInSegment;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Object internalResult;
    private volatile Object state;

    /* JADX INFO: renamed from: xa.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fRH\u0010\u0013\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\b\u0018\u00010\u000fj\u0004\u0018\u0001`\u00108\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0016\u0010\u0019\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lxa/a$a;", "", "Lr8/z;", "b", "()V", "Lxa/b;", "select", "internalResult", "Lkotlin/Function1;", "", "a", "(Lxa/b;Ljava/lang/Object;)Lc9/l;", "Ljava/lang/Object;", "clauseObject", "param", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "c", "Lc9/q;", "onCancellationConstructor", "d", "disposableHandleOrSegment", "", "e", "I", "indexInSegment", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class C0475a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Object clauseObject;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final Object param;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final q<b<?>, Object, Object, c9.l<Throwable, z>> onCancellationConstructor;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        public Object disposableHandleOrSegment;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        public int indexInSegment;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<R> f22035f;

        public final c9.l<Throwable, z> a(b<?> select, Object internalResult) {
            q<b<?>, Object, Object, c9.l<Throwable, z>> qVar = this.onCancellationConstructor;
            if (qVar != null) {
                return qVar.invoke(select, this.param, internalResult);
            }
            return null;
        }

        public final void b() {
            Object obj = this.disposableHandleOrSegment;
            a<R> aVar = this.f22035f;
            if (obj instanceof c0) {
                ((c0) obj).o(this.indexInSegment, null, aVar.getContext());
                return;
            }
            b1 b1Var = obj instanceof b1 ? (b1) obj : null;
            if (b1Var != null) {
                b1Var.dispose();
            }
        }
    }

    private final a<R>.C0475a f(Object clauseObject) {
        List<a<R>.C0475a> list = this.clauses;
        Object obj = null;
        if (list == null) {
            return null;
        }
        for (Object obj2 : list) {
            if (((C0475a) obj2).clauseObject == clauseObject) {
                obj = obj2;
                break;
            }
        }
        a<R>.C0475a c0475a = (C0475a) obj;
        if (c0475a != null) {
            return c0475a;
        }
        throw new IllegalStateException(("Clause with object " + clauseObject + " is not found").toString());
    }

    private final int h(Object clauseObject, Object internalResult) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22024f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof n) {
                a<R>.C0475a c0475aF = f(clauseObject);
                if (c0475aF == null) {
                    continue;
                } else {
                    c9.l<Throwable, z> lVarA = c0475aF.a(this, internalResult);
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, c0475aF)) {
                        this.internalResult = internalResult;
                        if (c.h((n) obj, lVarA)) {
                            return 0;
                        }
                        this.internalResult = null;
                        return 2;
                    }
                }
            } else {
                if (m.a(obj, c.f22038c) ? true : obj instanceof C0475a) {
                    return 3;
                }
                if (m.a(obj, c.f22039d)) {
                    return 2;
                }
                if (m.a(obj, c.f22037b)) {
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, r.e(clauseObject))) {
                        return 1;
                    }
                } else {
                    if (!(obj instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj).toString());
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, r.C0((Collection) obj, clauseObject))) {
                        return 1;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.x2
    public void b(c0<?> segment, int index) {
        this.disposableHandleOrSegment = segment;
        this.indexInSegment = index;
    }

    @Override // xa.b
    public void c(Object internalResult) {
        this.internalResult = internalResult;
    }

    @Override // kotlinx.coroutines.m
    public void e(Throwable cause) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22024f;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == c.f22038c) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, c.f22039d));
        List<a<R>.C0475a> list = this.clauses;
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((C0475a) it.next()).b();
        }
        this.internalResult = c.f22040e;
        this.clauses = null;
    }

    @Override // xa.b
    public j getContext() {
        return this.context;
    }

    @Override // c9.l
    public /* bridge */ /* synthetic */ z invoke(Throwable th) {
        e(th);
        return z.f17874a;
    }

    @Override // xa.b
    public boolean a(Object clauseObject, Object result) {
        if (h(clauseObject, result) == 0) {
            return true;
        }
        return false;
    }

    public final d g(Object clauseObject, Object result) {
        return c.a(h(clauseObject, result));
    }
}
