package x1.f1.lb.ad;

import c9.p;
import c9.q;
import com.google.gson.e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import ua.n;
import x1.f1.lb.util.g0;
import x1.f1.lb.util.w0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0003J\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lx1/f1/lb/ad/b;", "", "<init>", "()V", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "", "d", "(Ljava/lang/String;)Z", "Lx1/f1/lb/util/g0;", "", "Lx1/f1/lb/ad/a;", "callback", "Lr8/z;", "c", "(Lx1/f1/lb/util/g0;)V", "e", "value", "f", "(Ljava/lang/String;)V", "b", "()Z", "Ljava/util/List;", "getAdExtContent", "()Ljava/util/List;", "g", "(Ljava/util/List;)V", "adExtContent", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f20540a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static List<Object> adExtContent = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.ad.AdManager$getStartupAdList$1", f = "AdManager.kt", l = {38}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ g0<List<AdItem>> $callback;
        int label;

        /* JADX INFO: renamed from: x1.f1.lb.ad.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "x1.f1.lb.ad.AdManager$getStartupAdList$1$1", f = "AdManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0393a extends l implements q<g<? super String>, Throwable, v8.f<? super z>, Object> {
            final /* synthetic */ g0<List<AdItem>> $callback;
            /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: x1.f1.lb.ad.b$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @f(c = "x1.f1.lb.ad.AdManager$getStartupAdList$1$1$1", f = "AdManager.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0394a extends l implements p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ g0<List<AdItem>> $callback;
                final /* synthetic */ Throwable $it;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0394a(g0<List<AdItem>> g0Var, Throwable th, v8.f<? super C0394a> fVar) {
                    super(2, fVar);
                    this.$callback = g0Var;
                    this.$it = th;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new C0394a(this.$callback, this.$it, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((C0394a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r.b(obj);
                        this.$callback.b(this.$it);
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0393a(g0<List<AdItem>> g0Var, v8.f<? super C0393a> fVar) {
                super(3, fVar);
                this.$callback = g0Var;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(g<? super String> gVar, Throwable th, v8.f<? super z> fVar) {
                C0393a c0393a = new C0393a(this.$callback, fVar);
                c0393a.L$0 = th;
                return c0393a.invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    j.d(m0.b(), null, null, new C0394a(this.$callback, (Throwable) this.L$0, null), 3, null);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: x1.f1.lb.ad.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0395b<T> implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ g0<List<AdItem>> f20542a;

            /* JADX INFO: renamed from: x1.f1.lb.ad.b$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @f(c = "x1.f1.lb.ad.AdManager$getStartupAdList$1$2$1", f = "AdManager.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0396a extends l implements p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ List<AdItem> $adItemList;
                final /* synthetic */ g0<List<AdItem>> $callback;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0396a(g0<List<AdItem>> g0Var, List<AdItem> list, v8.f<? super C0396a> fVar) {
                    super(2, fVar);
                    this.$callback = g0Var;
                    this.$adItemList = list;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new C0396a(this.$callback, this.$adItemList, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((C0396a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r.b(obj);
                        this.$callback.a(this.$adItemList);
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: x1.f1.lb.ad.b$a$b$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @f(c = "x1.f1.lb.ad.AdManager$getStartupAdList$1$2", f = "AdManager.kt", l = {41}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class C0397b extends d {
                Object L$0;
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ C0395b<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0397b(C0395b<? super T> c0395b, v8.f<? super C0397b> fVar) {
                    super(fVar);
                    this.this$0 = c0395b;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, this);
                }
            }

            C0395b(g0<List<AdItem>> g0Var) {
                this.f20542a = g0Var;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, v8.f<? super z> fVar) {
                C0397b c0397b;
                Throwable th;
                C0395b<T> c0395b;
                if (fVar instanceof C0397b) {
                    c0397b = (C0397b) fVar;
                    int i10 = c0397b.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0397b.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0397b = new C0397b(this, fVar);
                    }
                } else {
                    c0397b = new C0397b(this, fVar);
                }
                Object objH = c0397b.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0397b.label;
                if (i11 == 0) {
                    r.b(objH);
                    try {
                        List<String> listZ0 = n.z0(str, new String[]{","}, false, 0, 6, null);
                        x1.f1.lb.api.cache.b bVar = x1.f1.lb.api.cache.b.f20561a;
                        c0397b.L$0 = this;
                        c0397b.label = 1;
                        objH = bVar.h("start_up_img_list", listZ0, c0397b);
                        if (objH == objC) {
                            return objC;
                        }
                        c0395b = this;
                    } catch (Throwable th2) {
                        th = th2;
                        c0395b = this;
                        c0395b.f20542a.b(th);
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    c0395b = (C0395b) c0397b.L$0;
                    try {
                        r.b(objH);
                    } catch (Throwable th3) {
                        th = th3;
                        c0395b.f20542a.b(th);
                    }
                }
                ArrayList arrayList = new ArrayList();
                int i12 = 0;
                for (Map.Entry entry : ((Map) objH).entrySet()) {
                    arrayList.add(new AdItem(i12, b.f20540a.d((String) entry.getKey()), (File) entry.getValue()));
                    i12++;
                }
                j.d(m0.b(), null, null, new C0396a(c0395b.f20542a, arrayList, null), 3, null);
                return z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(g0<List<AdItem>> g0Var, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$callback = g0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new a(this.$callback, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                kotlinx.coroutines.flow.f fVarF = h.f(w0.f21452a.g("startup_ad_list", ""), new C0393a(this.$callback, null));
                C0395b c0395b = new C0395b(this.$callback);
                this.label = 1;
                if (fVarF.collect(c0395b, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: x1.f1.lb.ad.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.ad.AdManager$loadAdExtContent$1", f = "AdManager.kt", l = {67}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class C0398b extends l implements p<l0, v8.f<? super z>, Object> {
        int label;

        /* JADX INFO: renamed from: x1.f1.lb.ad.b$b$a */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "x1.f1.lb.ad.AdManager$loadAdExtContent$1$1", f = "AdManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends l implements q<g<? super String>, Throwable, v8.f<? super z>, Object> {
            int label;

            /* JADX INFO: renamed from: x1.f1.lb.ad.b$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @f(c = "x1.f1.lb.ad.AdManager$loadAdExtContent$1$1$1", f = "AdManager.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0399a extends l implements p<l0, v8.f<? super z>, Object> {
                int label;

                C0399a(v8.f<? super C0399a> fVar) {
                    super(2, fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new C0399a(fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((C0399a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r.b(obj);
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            a(v8.f<? super a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(g<? super String> gVar, Throwable th, v8.f<? super z> fVar) {
                return new a(fVar).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    j.d(m0.b(), null, null, new C0399a(null), 3, null);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: x1.f1.lb.ad.b$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0400b<T> implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0400b<T> f20543a = new C0400b<>();

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, v8.f<? super z> fVar) {
                b.f20540a.f(str);
                return z.f17874a;
            }

            C0400b() {
            }
        }

        C0398b(v8.f<? super C0398b> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new C0398b(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((C0398b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                kotlinx.coroutines.flow.f fVarF = h.f(w0.f21452a.g("ad_list_ext", ""), new a(null));
                g gVar = C0400b.f20543a;
                this.label = 1;
                if (fVarF.collect(gVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.ad.AdManager$loadAdExtContent$2", f = "AdManager.kt", l = {79}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ String $value;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "x1.f1.lb.ad.AdManager$loadAdExtContent$2$1", f = "AdManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends l implements p<l0, v8.f<? super z>, Object> {
            final /* synthetic */ List<Object> $contentList;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(List<Object> list, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$contentList = list;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new a(this.$contentList, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    b.f20540a.g(this.$contentList);
                    xe.c.c().o(new nf.a());
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: x1.f1.lb.ad.b$c$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"x1/f1/lb/ad/b$c$b", "Lf3/a;", "", "", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0401b extends f3.a<List<Object>> {
            C0401b() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, v8.f<? super c> fVar) {
            super(2, fVar);
            this.$value = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new c(this.$value, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((c) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 == 1) {
                        r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r.b(obj);
                    List list = (List) new e().o(this.$value, new C0401b().d());
                    g2 g2VarC = a1.c();
                    a aVar = new a(list, null);
                    this.label = 1;
                    if (kotlinx.coroutines.h.g(g2VarC, aVar, this) == objC) {
                        return objC;
                    }
                }
            } catch (Throwable unused) {
            }
            return z.f17874a;
        }
    }

    public final boolean b() {
        return m.a(of.a.f16585a.f(), "code");
    }

    public final void c(g0<List<AdItem>> callback) {
        m.f(callback, "callback");
        j.d(m0.a(a1.b()), null, null, new a(callback, null), 3, null);
    }

    public final void f(String value) {
        m.f(value, "value");
        if (b()) {
            return;
        }
        j.d(m0.a(a1.b()), null, null, new c(value, null), 3, null);
    }

    public final void g(List<Object> list) {
        m.f(list, "<set-?>");
        adExtContent = list;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d(String url) {
        Locale locale = Locale.getDefault();
        m.e(locale, "getDefault(...)");
        String lowerCase = url.toLowerCase(locale);
        m.e(lowerCase, "toLowerCase(...)");
        if (!n.v(lowerCase, ".mp4", false, 2, null) && !n.v(lowerCase, ".mov", false, 2, null) && !n.v(lowerCase, ".ts", false, 2, null) && !n.v(lowerCase, ".mpegts", false, 2, null)) {
            return false;
        }
        return true;
    }

    public final void e() {
        if (!b()) {
            j.d(m0.a(a1.b()), null, null, new C0398b(null), 3, null);
        }
    }
}
