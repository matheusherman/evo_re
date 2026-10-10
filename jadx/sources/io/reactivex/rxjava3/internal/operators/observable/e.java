package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.schedulers.m;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e extends g8.c<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final g8.h f11390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f11392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f11393d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends AtomicReference<h8.c> implements h8.c, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        long count;
        final g8.g<? super Long> downstream;

        a(g8.g<? super Long> gVar) {
            this.downstream = gVar;
        }

        public void a(h8.c cVar) {
            k8.a.l(this, cVar);
        }

        @Override // h8.c
        public void dispose() {
            k8.a.a(this);
        }

        @Override // h8.c
        public boolean f() {
            if (get() == k8.a.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != k8.a.DISPOSED) {
                g8.g<? super Long> gVar = this.downstream;
                long j10 = this.count;
                this.count = 1 + j10;
                gVar.a(Long.valueOf(j10));
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // g8.c
    public void u(g8.g<? super Long> gVar) {
        a aVar = new a(gVar);
        gVar.d(aVar);
        g8.h hVar = this.f11390a;
        if (!(hVar instanceof m)) {
            aVar.a(hVar.f(aVar, this.f11391b, this.f11392c, this.f11393d));
            return;
        }
        g8.h.c cVarC = hVar.c();
        aVar.a(cVarC);
        cVarC.d(aVar, this.f11391b, this.f11392c, this.f11393d);
    }

    public e(long j10, long j11, TimeUnit timeUnit, g8.h hVar) {
        this.f11391b = j10;
        this.f11392c = j11;
        this.f11393d = timeUnit;
        this.f11390a = hVar;
    }
}
