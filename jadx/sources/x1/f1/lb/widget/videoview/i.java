package x1.f1.lb.widget.videoview;

import android.util.LruCache;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\tH\u0086@¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\tH\u0086@¢\u0006\u0004\b\f\u0010\u000bR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000e¨\u0006\u0010"}, d2 = {"Lx1/f1/lb/widget/videoview/i;", "", "<init>", "()V", "Lx1/f1/lb/widget/videoview/h;", "session", "Lr8/z;", "c", "(Lx1/f1/lb/widget/videoview/h;)V", "", "b", "(JLv8/f;)Ljava/lang/Object;", "d", "Landroid/util/LruCache;", "Landroid/util/LruCache;", "cache", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f21588a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final LruCache<Long, h> cache = new LruCache<>(10);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlaySessionCache", f = "PlaySessionCache.kt", l = {27}, m = "get")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class a extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        a(v8.f<? super a> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.b(0L, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlaySessionCache$get$2", f = "PlaySessionCache.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ kotlin.jvm.internal.b0<h> $playSession;
        final /* synthetic */ long $session;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.jvm.internal.b0<h> b0Var, long j10, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$playSession = b0Var;
            this.$session = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new b(this.$playSession, this.$session, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                this.$playSession.element = i.cache.get(kotlin.coroutines.jvm.internal.b.c(this.$session));
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlaySessionCache", f = "PlaySessionCache.kt", l = {36}, m = "remove")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class c extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        c(v8.f<? super c> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.d(0L, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlaySessionCache$remove$2", f = "PlaySessionCache.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class d extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ kotlin.jvm.internal.b0<h> $playSession;
        final /* synthetic */ long $session;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(kotlin.jvm.internal.b0<h> b0Var, long j10, v8.f<? super d> fVar) {
            super(2, fVar);
            this.$playSession = b0Var;
            this.$session = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new d(this.$playSession, this.$session, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((d) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                this.$playSession.element = i.cache.remove(kotlin.coroutines.jvm.internal.b.c(this.$session));
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(long j10, v8.f<? super h> fVar) {
        a aVar;
        kotlin.jvm.internal.b0 b0Var;
        if (fVar instanceof a) {
            aVar = (a) fVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(fVar);
            }
        } else {
            aVar = new a(fVar);
        }
        Object obj = aVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = aVar.label;
        if (i11 == 0) {
            r8.r.b(obj);
            kotlin.jvm.internal.b0 b0Var2 = new kotlin.jvm.internal.b0();
            kotlinx.coroutines.i0 i0VarB = kotlinx.coroutines.a1.b();
            b bVar = new b(b0Var2, j10, null);
            aVar.L$0 = b0Var2;
            aVar.label = 1;
            if (kotlinx.coroutines.h.g(i0VarB, bVar, aVar) == objC) {
                return objC;
            }
            b0Var = b0Var2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b0Var = (kotlin.jvm.internal.b0) aVar.L$0;
            r8.r.b(obj);
        }
        return b0Var.element;
    }

    public final void c(h session) {
        kotlin.jvm.internal.m.f(session, "session");
        Map<Long, h> mapSnapshot = cache.snapshot();
        Collection<h> collectionValues = mapSnapshot != null ? mapSnapshot.values() : null;
        if (collectionValues != null && !collectionValues.isEmpty()) {
            for (h hVar : collectionValues) {
                if (kotlin.jvm.internal.m.a(hVar.getAndroidx.core.app.NotificationCompat.CATEGORY_EVENT java.lang.String().c(), session.getAndroidx.core.app.NotificationCompat.CATEGORY_EVENT java.lang.String().c()) && hVar.getAndroidx.core.app.NotificationCompat.CATEGORY_EVENT java.lang.String().g() != session.getAndroidx.core.app.NotificationCompat.CATEGORY_EVENT java.lang.String().g()) {
                    cache.remove(Long.valueOf(hVar.getAndroidx.core.app.NotificationCompat.CATEGORY_EVENT java.lang.String().g()));
                }
            }
        }
        cache.put(Long.valueOf(session.getAndroidx.core.app.NotificationCompat.CATEGORY_EVENT java.lang.String().g()), session);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(long j10, v8.f<? super h> fVar) {
        c cVar;
        kotlin.jvm.internal.b0 b0Var;
        if (fVar instanceof c) {
            cVar = (c) fVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(fVar);
            }
        } else {
            cVar = new c(fVar);
        }
        Object obj = cVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = cVar.label;
        if (i11 == 0) {
            r8.r.b(obj);
            kotlin.jvm.internal.b0 b0Var2 = new kotlin.jvm.internal.b0();
            kotlinx.coroutines.i0 i0VarB = kotlinx.coroutines.a1.b();
            d dVar = new d(b0Var2, j10, null);
            cVar.L$0 = b0Var2;
            cVar.label = 1;
            if (kotlinx.coroutines.h.g(i0VarB, dVar, cVar) == objC) {
                return objC;
            }
            b0Var = b0Var2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b0Var = (kotlin.jvm.internal.b0) cVar.L$0;
            r8.r.b(obj);
        }
        return b0Var.element;
    }

    private i() {
    }
}
