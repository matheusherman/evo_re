package com.live.evo_mobile.ui;

import androidx.exifinterface.media.ExifInterface;
import com.live.evo.R$color;
import com.live.evo.R$layout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\u0004J\r\u0010\n\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0004R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/live/evo_mobile/ui/n2;", "Lcom/tvc/lib/mobile/ui/base/d;", "Lz4/e0;", "<init>", "()V", "", ExifInterface.LONGITUDE_WEST, "()I", "Lr8/z;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "e0", "y", "", "hidden", "onHiddenChanged", "(Z)V", "R", "onDestroy", "", "Lqf/a;", "e", "Ljava/util/List;", "lastRemindItemList", "Lcom/live/evo_mobile/adapter/p;", "f", "Lr8/i;", "d0", "()Lcom/live/evo_mobile/adapter/p;", "subscribeListAdapter", "g", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class n2 extends com.tvc.lib.mobile.ui.base.d<z4.e0> {

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<qf.a> lastRemindItemList;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final r8.i subscribeListAdapter = r8.j.a(new c9.a() { // from class: com.live.evo_mobile.ui.m2
        @Override // c9.a
        public final Object invoke() {
            return n2.f0();
        }
    });

    /* JADX INFO: renamed from: com.live.evo_mobile.ui.n2$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/live/evo_mobile/ui/n2$a;", "", "<init>", "()V", "Lcom/live/evo_mobile/ui/n2;", "a", "()Lcom/live/evo_mobile/ui/n2;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final n2 a() {
            return new n2();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/live/evo_mobile/ui/n2$b", "Lcom/live/evo_mobile/adapter/p$a;", "Lu7/j;", "item", "", "position", "Lr8/z;", "a", "(Lu7/j;I)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements com.live.evo_mobile.adapter.p.a {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.SubscribeListFragment$initListener$1$onClick$1", f = "SubscribeListFragment.kt", l = {74, 78}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ u7.j $item;
            int label;
            final /* synthetic */ n2 this$0;

            /* JADX INFO: renamed from: com.live.evo_mobile.ui.n2$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.SubscribeListFragment$initListener$1$onClick$1$1", f = "SubscribeListFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0142a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                int label;
                final /* synthetic */ n2 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0142a(n2 n2Var, v8.f<? super C0142a> fVar) {
                    super(2, fVar);
                    this.this$0 = n2Var;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0142a(this.this$0, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0142a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        this.this$0.e0();
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(u7.j jVar, n2 n2Var, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$item = jVar;
                this.this$0 = n2Var;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.$item, this.this$0, fVar);
            }

            @Override // c9.p
            public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0072, code lost:
            
                if (kotlinx.coroutines.h.g(r13, r1, r12) == r0) goto L15;
             */
            @Override // kotlin.coroutines.jvm.internal.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                a aVar;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            r8.r.b(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        r8.r.b(obj);
                        aVar = this;
                    }
                    return r8.z.f17874a;
                }
                r8.r.b(obj);
                t.v.c.i.a aVar2 = t.v.c.i.a.f18646a;
                int iC = this.$item.getData().c();
                long jE = this.$item.getData().e();
                String channel = this.$item.getData().d().getChannel();
                kotlin.jvm.internal.m.e(channel, "getChannel(...)");
                this.label = 1;
                aVar = this;
                if (t.v.c.i.a.K0(aVar2, iC, jE, channel, null, aVar, 8, null) != objC) {
                }
                return objC;
                aVar.this$0.U();
                kotlinx.coroutines.g2 g2VarC = kotlinx.coroutines.a1.c();
                C0142a c0142a = new C0142a(aVar.this$0, null);
                aVar.label = 2;
            }
        }

        b() {
        }

        @Override // com.live.evo_mobile.adapter.p.a
        public void a(u7.j item, int position) {
            kotlin.jvm.internal.m.f(item, "item");
            n2.this.Z();
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new a(item, n2.this, null), 3, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.SubscribeListFragment$loadSubscribeList$1", f = "SubscribeListFragment.kt", l = {50}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.SubscribeListFragment$loadSubscribeList$1$1", f = "SubscribeListFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lqf/a;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super List<? extends qf.a>>, Throwable, v8.f<? super r8.z>, Object> {
            int label;
            final /* synthetic */ n2 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(n2 n2Var, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = n2Var;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super List<qf.a>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                return new a(this.this$0, fVar).invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    this.this$0.U();
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ n2 f8159a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.SubscribeListFragment$loadSubscribeList$1$2$1", f = "SubscribeListFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ List<u7.j> $list;
                int label;
                final /* synthetic */ n2 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(n2 n2Var, List<u7.j> list, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.this$0 = n2Var;
                    this.$list = list;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.this$0, this.$list, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        this.this$0.d0().submitList(this.$list);
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(n2 n2Var) {
                this.f8159a = n2Var;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(List<qf.a> list, v8.f<? super r8.z> fVar) {
                this.f8159a.U();
                this.f8159a.lastRemindItemList = list;
                ArrayList arrayList = new ArrayList();
                Iterator<qf.a> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new u7.j(false, it.next()));
                }
                Object objG = kotlinx.coroutines.h.g(kotlinx.coroutines.a1.c(), new a(this.f8159a, arrayList, null), fVar);
                return objG == kotlin.coroutines.intrinsics.b.c() ? objG : r8.z.f17874a;
            }
        }

        c(v8.f<? super c> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return n2.this.new c(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((c) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(t.v.c.i.a.f18646a.K(), new a(n2.this, null));
                b bVar = new b(n2.this);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.live.evo_mobile.adapter.p d0() {
        return (com.live.evo_mobile.adapter.p) this.subscribeListAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.live.evo_mobile.adapter.p f0() {
        return new com.live.evo_mobile.adapter.p();
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int R() {
        return R$color.color_focused;
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void V() {
        T().f22755a.setAdapter(d0());
        d0().z(true);
        d0().A(S(), R$layout.view_empty_data);
        e0();
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int W() {
        return R$layout.fragment_favorite_list;
    }

    public final void e0() {
        Z();
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new c(null), 3, null);
    }

    @Override // com.tvc.lib.mobile.ui.base.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            e0();
        }
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void y() {
        d0().Y(new b());
    }
}
