package com.live.evo_mobile.ui;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p000lifecycle.MutableLiveData;
import androidx.p000lifecycle.Observer;
import com.live.evo.R$color;
import com.live.evo.R$layout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import u7.HistoryLiveListData;
import z1.b1.lb.m.meta.ChannelStreamResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0004R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/live/evo_mobile/ui/d0;", "Lcom/tvc/lib/mobile/ui/base/d;", "Lz4/g0;", "<init>", "()V", "Lr8/z;", "n0", "h0", "", ExifInterface.LONGITUDE_WEST, "()I", "R", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/live/evo_mobile/adapter/f;", "e", "Lr8/i;", "i0", "()Lcom/live/evo_mobile/adapter/f;", "mHistoryLiveListAdapter", "", "Lu7/e;", "f", "Ljava/util/List;", "mList", "g", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d0 extends com.tvc.lib.mobile.ui.base.d<z4.g0> {

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final r8.i mHistoryLiveListAdapter = r8.j.a(new c9.a() { // from class: com.live.evo_mobile.ui.z
        @Override // c9.a
        public final Object invoke() {
            return d0.m0();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<HistoryLiveListData> mList = new ArrayList();

    /* JADX INFO: renamed from: com.live.evo_mobile.ui.d0$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/live/evo_mobile/ui/d0$a;", "", "<init>", "()V", "Lcom/live/evo_mobile/ui/d0;", "a", "()Lcom/live/evo_mobile/ui/d0;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final d0 a() {
            return new d0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo_mobile/ui/d0$b", "Lcom/live/evo_mobile/adapter/f$a;", "", "isSelected", "Lr8/z;", "a", "(Z)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements com.live.evo_mobile.adapter.f.a {
        b() {
        }

        @Override // com.live.evo_mobile.adapter.f.a
        public void a(boolean isSelected) {
            d0.this.T().f22778a.f22757b.setSelected(isSelected);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/live/evo_mobile/ui/d0$c", "Lr7/c$a;", "Lu7/e;", "", "isSelected", "item", "Lr8/z;", "f", "(ZLu7/e;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements r7.c.a<HistoryLiveListData> {
        c() {
        }

        @Override // r7.c.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(boolean isSelected, HistoryLiveListData item) {
            kotlin.jvm.internal.m.f(item, "item");
            if (d0.this.i0().getEditStatus() || !(d0.this.getActivity() instanceof HistoryListActivity)) {
                return;
            }
            FragmentActivity activity = d0.this.getActivity();
            kotlin.jvm.internal.m.d(activity, "null cannot be cast to non-null type com.live.evo_mobile.ui.HistoryListActivity");
            ((HistoryListActivity) activity).L(item);
        }

        @Override // r7.c.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(HistoryLiveListData historyLiveListData) {
            r7.c.a.C0343a.a(this, historyLiveListData);
        }

        @Override // r7.c.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(HistoryLiveListData historyLiveListData, int i10) {
            r7.c.a.C0343a.b(this, historyLiveListData, i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.HistoryLiveFragment$initView$4$dialog$1$1", f = "HistoryLiveFragment.kt", l = {104}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class d extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ List<HistoryLiveListData> $list;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.HistoryLiveFragment$initView$4$dialog$1$1$1", f = "HistoryLiveFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            int label;
            final /* synthetic */ d0 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d0 d0Var, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = d0Var;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.this$0, fVar);
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
                    this.this$0.i0().notifyDataSetChanged();
                    com.tvc.lib.mobile.ext.f.b(FragmentTransaction.TRANSIT_FRAGMENT_OPEN, null, null, 6, null);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(List<HistoryLiveListData> list, v8.f<? super d> fVar) {
            super(2, fVar);
            this.$list = list;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return d0.this.new d(this.$list, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((d) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                d0.this.mList.clear();
                ArrayList arrayList = new ArrayList();
                Iterator<HistoryLiveListData> it = this.$list.iterator();
                while (it.hasNext()) {
                    arrayList.add(kotlin.coroutines.jvm.internal.b.b(it.next().getKey()));
                }
                t.v.c.i.a.f18646a.D0(arrayList);
                d0.this.h0();
                kotlinx.coroutines.g2 g2VarC = kotlinx.coroutines.a1.c();
                a aVar = new a(d0.this, null);
                this.label = 1;
                if (kotlinx.coroutines.h.g(g2VarC, aVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class e implements Observer, kotlin.jvm.internal.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ c9.l f7892a;

        e(c9.l function) {
            kotlin.jvm.internal.m.f(function, "function");
            this.f7892a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.h)) {
                return kotlin.jvm.internal.m.a(getFunctionDelegate(), ((kotlin.jvm.internal.h) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.h
        public final r8.c<?> getFunctionDelegate() {
            return this.f7892a;
        }

        @Override // androidx.p000lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f7892a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.HistoryLiveFragment$setHistoryList$1", f = "HistoryLiveFragment.kt", l = {119}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class f extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.HistoryLiveFragment$setHistoryList$1$1", f = "HistoryLiveFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            int label;
            final /* synthetic */ d0 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d0 d0Var, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = d0Var;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.this$0, fVar);
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
                    this.this$0.i0().submitList(this.this$0.mList);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        f(v8.f<? super f> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return d0.this.new f(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((f) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                d0.this.h0();
                kotlinx.coroutines.g2 g2VarC = kotlinx.coroutines.a1.c();
                a aVar = new a(d0.this, null);
                this.label = 1;
                if (kotlinx.coroutines.h.g(g2VarC, aVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        for (ChannelStreamResponse channelStreamResponse : t.v.c.i.a.f18646a.n(x1.f1.lb.media.a.f20755a.E(), Boolean.FALSE)) {
            String streamName = channelStreamResponse.getStreamName();
            kotlin.jvm.internal.m.e(streamName, "getStreamName(...)");
            String iconUrl = channelStreamResponse.getIconUrl();
            kotlin.jvm.internal.m.e(iconUrl, "getIconUrl(...)");
            String streamId = channelStreamResponse.getStreamId();
            kotlin.jvm.internal.m.e(streamId, "getStreamId(...)");
            this.mList.add(new HistoryLiveListData(streamName, iconUrl, streamId, channelStreamResponse.getKey(), false, 16, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.live.evo_mobile.adapter.f i0() {
        return (com.live.evo_mobile.adapter.f) this.mHistoryLiveListAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z k0(final d0 d0Var, View it) {
        kotlin.jvm.internal.m.f(it, "it");
        if (kotlin.jvm.internal.m.a(it, d0Var.T().f22778a.f22757b) || kotlin.jvm.internal.m.a(it, d0Var.T().f22778a.f22759d)) {
            d0Var.T().f22778a.f22757b.setSelected(!d0Var.T().f22778a.f22757b.isSelected());
            d0Var.i0().a0(d0Var.T().f22778a.f22757b.isSelected());
        } else if (kotlin.jvm.internal.m.a(it, d0Var.T().f22778a.f22758c)) {
            final List<HistoryLiveListData> listQ = d0Var.i0().Q();
            if (listQ.isEmpty()) {
                String string = d0Var.getString(2131952905);
                kotlin.jvm.internal.m.e(string, "getString(...)");
                com.tvc.lib.mobile.ext.h.e(string, d0Var.S());
                return r8.z.f17874a;
            }
            v7.c cVar = new v7.c(null, new c9.a() { // from class: com.live.evo_mobile.ui.c0
                @Override // c9.a
                public final Object invoke() {
                    return d0.l0(this.f7881a, listQ);
                }
            }, 1, null);
            FragmentManager childFragmentManager = d0Var.getChildFragmentManager();
            kotlin.jvm.internal.m.e(childFragmentManager, "getChildFragmentManager(...)");
            cVar.X(childFragmentManager);
        }
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z l0(d0 d0Var, List list) {
        kotlinx.coroutines.j.d(kotlinx.coroutines.n1.f14892a, kotlinx.coroutines.a1.b(), null, d0Var.new d(list, null), 2, null);
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.live.evo_mobile.adapter.f m0() {
        return new com.live.evo_mobile.adapter.f();
    }

    private final void n0() {
        kotlinx.coroutines.j.d(kotlinx.coroutines.n1.f14892a, kotlinx.coroutines.a1.b(), null, new f(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z j0(d0 d0Var, Boolean bool) {
        if (bool.booleanValue()) {
            d0Var.T().f22778a.f22756a.setVisibility(0);
        } else {
            d0Var.T().f22778a.f22756a.setVisibility(8);
        }
        com.live.evo_mobile.adapter.f fVarI0 = d0Var.i0();
        kotlin.jvm.internal.m.c(bool);
        fVarI0.Z(bool.booleanValue());
        d0Var.T().f22778a.f22757b.setSelected(false);
        return r8.z.f17874a;
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int R() {
        return R$color.color_focused;
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void V() {
        HistoryListActivity historyListActivity;
        T().f22779b.setAdapter(i0());
        i0().Y(new b());
        i0().R(new c());
        n0();
        FragmentActivity fragmentActivityS = S();
        MutableLiveData<Boolean> mutableLiveDataI = null;
        if (fragmentActivityS instanceof HistoryListActivity) {
            historyListActivity = (HistoryListActivity) fragmentActivityS;
        } else {
            historyListActivity = null;
        }
        if (historyListActivity != null) {
            mutableLiveDataI = historyListActivity.I();
        }
        if (mutableLiveDataI != null) {
            mutableLiveDataI.observe(this, new e(new c9.l() { // from class: com.live.evo_mobile.ui.a0
                @Override // c9.l
                public final Object invoke(Object obj) {
                    return d0.j0(this.f7873a, (Boolean) obj);
                }
            }));
        }
        com.tvc.lib.mobile.ext.d.f(new View[]{T().f22778a.f22757b, T().f22778a.f22759d, T().f22778a.f22758c}, 0L, new c9.l() { // from class: com.live.evo_mobile.ui.b0
            @Override // c9.l
            public final Object invoke(Object obj) {
                return d0.k0(this.f7877a, (View) obj);
            }
        }, 2, null);
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int W() {
        return R$layout.fragment_history_live;
    }
}
