package com.tvc.lib.mobile.ext;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.p000lifecycle.LifecycleOwnerKt;
import c9.p;
import c9.q;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.l0;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u001aQ\u0010\n\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\u000f\u001a\u00020\u0005*\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a%\u0010\u0012\u001a\u00020\u0005*\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/appcompat/app/AppCompatActivity;", "", "time", "Lkotlin/Function1;", "Lkotlinx/coroutines/l0;", "Lr8/z;", "start", "next", "Lkotlin/Function0;", "end", "a", "(Landroidx/appcompat/app/AppCompatActivity;ILc9/l;Lc9/l;Lc9/a;)V", "Landroid/app/Activity;", "", "darkMode", "b", "(Landroid/app/Activity;Z)V", "res", "c", "(Landroid/app/Activity;ILjava/lang/Boolean;)V", "tvclib_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: com.tvc.lib.mobile.ext.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ext.ActivityExtKt$countDown$1", f = "ActivityExt.kt", l = {61}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class C0159a extends kotlin.coroutines.jvm.internal.l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ c9.a<z> $end;
        final /* synthetic */ c9.l<Integer, z> $next;
        final /* synthetic */ c9.l<l0, z> $start;
        final /* synthetic */ int $time;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.tvc.lib.mobile.ext.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ext.ActivityExtKt$countDown$1$1", f = "ActivityExt.kt", l = {50, 52}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0160a extends kotlin.coroutines.jvm.internal.l implements p<kotlinx.coroutines.flow.g<? super Integer>, v8.f<? super z>, Object> {
            final /* synthetic */ int $time;
            int I$0;
            int I$1;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0160a(int i10, v8.f<? super C0160a> fVar) {
                super(2, fVar);
                this.$time = i10;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                C0160a c0160a = new C0160a(this.$time, fVar);
                c0160a.L$0 = obj;
                return c0160a;
            }

            @Override // c9.p
            public final Object invoke(kotlinx.coroutines.flow.g<? super Integer> gVar, v8.f<? super z> fVar) {
                return ((C0160a) create(gVar, fVar)).invokeSuspend(z.f17874a);
            }

            /* JADX WARN: Code duplicated, block: B:11:0x004d A[PHI: r4 r5 r6
              0x004d: PHI (r4v3 int) = (r4v1 int), (r4v2 int), (r4v7 int) binds: [B:10:0x0037, B:19:0x007f, B:6:0x000e] A[DONT_GENERATE, DONT_INLINE]
              0x004d: PHI (r5v2 java.util.Iterator<java.lang.Integer>) = 
              (r5v0 java.util.Iterator<java.lang.Integer>)
              (r5v1 java.util.Iterator<java.lang.Integer>)
              (r5v7 java.util.Iterator<java.lang.Integer>)
             binds: [B:10:0x0037, B:19:0x007f, B:6:0x000e] A[DONT_GENERATE, DONT_INLINE]
              0x004d: PHI (r6v2 kotlinx.coroutines.flow.g) = (r6v0 kotlinx.coroutines.flow.g), (r6v1 kotlinx.coroutines.flow.g), (r6v5 kotlinx.coroutines.flow.g) binds: [B:10:0x0037, B:19:0x007f, B:6:0x000e] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:13:0x0053  */
            /* JADX WARN: Code duplicated, block: B:15:0x005c  */
            /* JADX WARN: Code duplicated, block: B:18:0x006f A[PHI: r1 r4 r5 r6
              0x006f: PHI (r1v4 int) = (r1v5 int), (r1v5 int), (r1v6 int) binds: [B:14:0x005a, B:16:0x006c, B:9:0x0027] A[DONT_GENERATE, DONT_INLINE]
              0x006f: PHI (r4v2 int) = (r4v3 int), (r4v3 int), (r4v4 int) binds: [B:14:0x005a, B:16:0x006c, B:9:0x0027] A[DONT_GENERATE, DONT_INLINE]
              0x006f: PHI (r5v1 java.util.Iterator<java.lang.Integer>) = 
              (r5v2 java.util.Iterator<java.lang.Integer>)
              (r5v2 java.util.Iterator<java.lang.Integer>)
              (r5v4 java.util.Iterator<java.lang.Integer>)
             binds: [B:14:0x005a, B:16:0x006c, B:9:0x0027] A[DONT_GENERATE, DONT_INLINE]
              0x006f: PHI (r6v1 kotlinx.coroutines.flow.g) = (r6v2 kotlinx.coroutines.flow.g), (r6v2 kotlinx.coroutines.flow.g), (r6v4 kotlinx.coroutines.flow.g) binds: [B:14:0x005a, B:16:0x006c, B:9:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:21:0x0082  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007f -> B:11:0x004d). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // kotlin.coroutines.jvm.internal.a
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    r9 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
                    int r1 = r9.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L37
                    if (r1 == r3) goto L27
                    if (r1 != r2) goto L1f
                    int r1 = r9.I$0
                    java.lang.Object r4 = r9.L$1
                    java.util.Iterator r4 = (java.util.Iterator) r4
                    java.lang.Object r5 = r9.L$0
                    kotlinx.coroutines.flow.g r5 = (kotlinx.coroutines.flow.g) r5
                    r8.r.b(r10)
                    r6 = r5
                    r5 = r4
                    r4 = r1
                    goto L4d
                L1f:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r0)
                    throw r10
                L27:
                    int r1 = r9.I$1
                    int r4 = r9.I$0
                    java.lang.Object r5 = r9.L$1
                    java.util.Iterator r5 = (java.util.Iterator) r5
                    java.lang.Object r6 = r9.L$0
                    kotlinx.coroutines.flow.g r6 = (kotlinx.coroutines.flow.g) r6
                    r8.r.b(r10)
                    goto L6f
                L37:
                    r8.r.b(r10)
                    java.lang.Object r10 = r9.L$0
                    kotlinx.coroutines.flow.g r10 = (kotlinx.coroutines.flow.g) r10
                    int r1 = r9.$time
                    r4 = 0
                    h9.c r1 = h9.f.k(r1, r4)
                    int r4 = r9.$time
                    java.util.Iterator r1 = r1.iterator()
                    r6 = r10
                    r5 = r1
                L4d:
                    boolean r10 = r5.hasNext()
                    if (r10 == 0) goto L82
                    r10 = r5
                    kotlin.collections.k0 r10 = (kotlin.collections.k0) r10
                    int r1 = r10.nextInt()
                    if (r1 == r4) goto L6f
                    r9.L$0 = r6
                    r9.L$1 = r5
                    r9.I$0 = r4
                    r9.I$1 = r1
                    r9.label = r3
                    r7 = 1000(0x3e8, double:4.94E-321)
                    java.lang.Object r10 = kotlinx.coroutines.v0.a(r7, r9)
                    if (r10 != r0) goto L6f
                    goto L81
                L6f:
                    java.lang.Integer r10 = kotlin.coroutines.jvm.internal.b.b(r1)
                    r9.L$0 = r6
                    r9.L$1 = r5
                    r9.I$0 = r4
                    r9.label = r2
                    java.lang.Object r10 = r6.emit(r10, r9)
                    if (r10 != r0) goto L4d
                L81:
                    return r0
                L82:
                    r8.z r10 = r8.z.f17874a
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tvc.lib.mobile.ext.a.C0159a.C0160a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX INFO: renamed from: com.tvc.lib.mobile.ext.a$a$b */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ext.ActivityExtKt$countDown$1$2", f = "ActivityExt.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
        static final class b extends kotlin.coroutines.jvm.internal.l implements p<kotlinx.coroutines.flow.g<? super Integer>, v8.f<? super z>, Object> {
            final /* synthetic */ l0 $$this$launch;
            final /* synthetic */ c9.l<l0, z> $start;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(c9.l<? super l0, z> lVar, l0 l0Var, v8.f<? super b> fVar) {
                super(2, fVar);
                this.$start = lVar;
                this.$$this$launch = l0Var;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new b(this.$start, this.$$this$launch, fVar);
            }

            @Override // c9.p
            public final Object invoke(kotlinx.coroutines.flow.g<? super Integer> gVar, v8.f<? super z> fVar) {
                return ((b) create(gVar, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    this.$start.invoke(this.$$this$launch);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.tvc.lib.mobile.ext.a$a$c */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ext.ActivityExtKt$countDown$1$3", f = "ActivityExt.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class c extends kotlin.coroutines.jvm.internal.l implements q<kotlinx.coroutines.flow.g<? super Integer>, Throwable, v8.f<? super z>, Object> {
            final /* synthetic */ c9.a<z> $end;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(c9.a<z> aVar, v8.f<? super c> fVar) {
                super(3, fVar);
                this.$end = aVar;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Integer> gVar, Throwable th, v8.f<? super z> fVar) {
                return new c(this.$end, fVar).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    this.$end.invoke();
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.tvc.lib.mobile.ext.a$a$d */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ext.ActivityExtKt$countDown$1$4", f = "ActivityExt.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class d extends kotlin.coroutines.jvm.internal.l implements q<kotlinx.coroutines.flow.g<? super Integer>, Throwable, v8.f<? super z>, Object> {
            /* synthetic */ Object L$0;
            int label;

            d(v8.f<? super d> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Integer> gVar, Throwable th, v8.f<? super z> fVar) {
                d dVar = new d(fVar);
                dVar.L$0 = th;
                return dVar.invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    String message = ((Throwable) this.L$0).getMessage();
                    if (message == null) {
                        message = "Unkown Error";
                    }
                    Log.e("", message);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.tvc.lib.mobile.ext.a$a$e */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class e<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c9.l<Integer, z> f9194a;

            /* JADX WARN: Multi-variable type inference failed */
            e(c9.l<? super Integer, z> lVar) {
                this.f9194a = lVar;
            }

            public final Object b(int i10, v8.f<? super z> fVar) {
                this.f9194a.invoke(kotlin.coroutines.jvm.internal.b.b(i10));
                return z.f17874a;
            }

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).intValue(), fVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0159a(int i10, c9.l<? super l0, z> lVar, c9.a<z> aVar, c9.l<? super Integer, z> lVar2, v8.f<? super C0159a> fVar) {
            super(2, fVar);
            this.$time = i10;
            this.$start = lVar;
            this.$end = aVar;
            this.$next = lVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            C0159a c0159a = new C0159a(this.$time, this.$start, this.$end, this.$next, fVar);
            c0159a.L$0 = obj;
            return c0159a;
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((C0159a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(kotlinx.coroutines.flow.h.B(kotlinx.coroutines.flow.h.D(kotlinx.coroutines.flow.h.v(new C0160a(this.$time, null)), new b(this.$start, (l0) this.L$0, null)), new c(this.$end, null)), new d(null));
                e eVar = new e(this.$next);
                this.label = 1;
                if (fVarF.collect(eVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    public static final void a(AppCompatActivity appCompatActivity, int i10, c9.l<? super l0, z> start, c9.l<? super Integer, z> next, c9.a<z> end) {
        m.f(appCompatActivity, "<this>");
        m.f(start, "start");
        m.f(next, "next");
        m.f(end, "end");
        kotlinx.coroutines.j.d(LifecycleOwnerKt.getLifecycleScope(appCompatActivity), null, null, new C0159a(i10, start, end, next, null), 3, null);
    }

    public static final void b(Activity activity, boolean z10) {
        m.f(activity, "<this>");
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
            activity.getWindow().getDecorView().setSystemUiVisibility(z10 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    public static final void c(Activity activity, int i10, Boolean bool) {
        m.f(activity, "<this>");
        int i11 = Build.VERSION.SDK_INT;
        Window window = activity.getWindow();
        if (window != null) {
            window.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            window.clearFlags(134217728);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            window.setNavigationBarColor(0);
            Drawable drawable = ResourcesCompat.getDrawable(activity.getResources(), i10, null);
            if (drawable != null) {
                activity.getWindow().setBackgroundDrawable(new a8.a(drawable, drawable));
            }
            if (i11 >= 29) {
                window.setNavigationBarContrastEnforced(false);
            }
            window.getDecorView().setSystemUiVisibility(1280);
        }
        if (bool != null) {
            b(activity, bool.booleanValue());
        }
    }

    public static /* synthetic */ void d(Activity activity, int i10, Boolean bool, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            bool = null;
        }
        c(activity, i10, bool);
    }
}
