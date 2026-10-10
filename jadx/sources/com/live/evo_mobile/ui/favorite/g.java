package com.live.evo_mobile.ui.favorite;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p000lifecycle.MutableLiveData;
import androidx.p000lifecycle.Observer;
import c9.p;
import com.live.evo.R$color;
import com.live.evo.R$layout;
import com.live.evo.util.s1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.n1;
import r8.i;
import r8.j;
import r8.r;
import r8.z;
import u7.HistoryLiveListData;
import z1.b1.lb.m.meta.ChannelStreamResponse;
import z4.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\u0004R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/live/evo_mobile/ui/favorite/g;", "Lcom/tvc/lib/mobile/ui/base/d;", "Lz4/g0;", "<init>", "()V", "Lr8/z;", "h0", "", "R", "()I", ExifInterface.LONGITUDE_WEST, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/live/evo_mobile/adapter/f;", "e", "Lr8/i;", "i0", "()Lcom/live/evo_mobile/adapter/f;", "mHistoryLiveListAdapter", "", "Lu7/e;", "f", "Ljava/util/List;", "mList", "g", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g extends com.tvc.lib.mobile.ui.base.d<g0> {

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final i mHistoryLiveListAdapter = j.a(new c9.a() { // from class: com.live.evo_mobile.ui.favorite.c
        @Override // c9.a
        public final Object invoke() {
            return g.m0();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<HistoryLiveListData> mList = new ArrayList();

    /* JADX INFO: renamed from: com.live.evo_mobile.ui.favorite.g$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/live/evo_mobile/ui/favorite/g$a;", "", "<init>", "()V", "Lcom/live/evo_mobile/ui/favorite/g;", "a", "()Lcom/live/evo_mobile/ui/favorite/g;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final g a() {
            return new g();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo_mobile/ui/favorite/g$b", "Lcom/live/evo_mobile/adapter/f$a;", "", "isSelected", "Lr8/z;", "a", "(Z)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements com.live.evo_mobile.adapter.f.a {
        b() {
        }

        @Override // com.live.evo_mobile.adapter.f.a
        public void a(boolean isSelected) {
            g.this.T().f22778a.f22757b.setSelected(isSelected);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/live/evo_mobile/ui/favorite/g$c", "Lr7/c$a;", "Lu7/e;", "", "isSelected", "item", "Lr8/z;", "f", "(ZLu7/e;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements r7.c.a<HistoryLiveListData> {
        c() {
        }

        @Override // r7.c.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(boolean isSelected, HistoryLiveListData item) {
            m.f(item, "item");
            if (g.this.i0().getEditStatus() || !(g.this.getActivity() instanceof FavoriteListActivity)) {
                return;
            }
            FragmentActivity activity = g.this.getActivity();
            m.d(activity, "null cannot be cast to non-null type com.live.evo_mobile.ui.favorite.FavoriteListActivity");
            ((FavoriteListActivity) activity).L(item);
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
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.favorite.FavoriteLiveFragment$initView$3", f = "FavoriteLiveFragment.kt", l = {57}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class d extends l implements p<l0, v8.f<? super z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.favorite.FavoriteLiveFragment$initView$3$1", f = "FavoriteLiveFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends l implements p<l0, v8.f<? super z>, Object> {
            int label;
            final /* synthetic */ g this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g gVar, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = gVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new a(this.this$0, fVar);
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
                    this.this$0.i0().submitList(this.this$0.mList);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        d(v8.f<? super d> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return g.this.new d(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((d) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                g.this.h0();
                g2 g2VarC = a1.c();
                a aVar = new a(g.this, null);
                this.label = 1;
                if (h.g(g2VarC, aVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.favorite.FavoriteLiveFragment$initView$5$dialog$1$1", f = "FavoriteLiveFragment.kt", l = {111}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class e extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ List<HistoryLiveListData> $list;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.favorite.FavoriteLiveFragment$initView$5$dialog$1$1$1", f = "FavoriteLiveFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends l implements p<l0, v8.f<? super z>, Object> {
            int label;
            final /* synthetic */ g this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g gVar, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = gVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new a(this.this$0, fVar);
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
                    this.this$0.i0().notifyDataSetChanged();
                    com.tvc.lib.mobile.ext.f.b(4113, null, null, 6, null);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(List<HistoryLiveListData> list, v8.f<? super e> fVar) {
            super(2, fVar);
            this.$list = list;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return g.this.new e(this.$list, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((e) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                g.this.mList.clear();
                ArrayList arrayList = new ArrayList();
                Iterator<HistoryLiveListData> it = this.$list.iterator();
                while (it.hasNext()) {
                    arrayList.add(kotlin.coroutines.jvm.internal.b.b(it.next().getKey()));
                }
                t.v.c.i.a.f18646a.C0(arrayList);
                g.this.h0();
                g2 g2VarC = a1.c();
                a aVar = new a(g.this, null);
                this.label = 1;
                if (h.g(g2VarC, aVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class f implements Observer, kotlin.jvm.internal.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ c9.l f7949a;

        f(c9.l function) {
            m.f(function, "function");
            this.f7949a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.h)) {
                return m.a(getFunctionDelegate(), ((kotlin.jvm.internal.h) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.h
        public final r8.c<?> getFunctionDelegate() {
            return this.f7949a;
        }

        @Override // androidx.p000lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f7949a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.live.evo_mobile.adapter.f i0() {
        return (com.live.evo_mobile.adapter.f) this.mHistoryLiveListAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z k0(final g gVar, View it) {
        m.f(it, "it");
        if (m.a(it, gVar.T().f22778a.f22757b) || m.a(it, gVar.T().f22778a.f22759d)) {
            gVar.T().f22778a.f22757b.setSelected(!gVar.T().f22778a.f22757b.isSelected());
            gVar.i0().a0(gVar.T().f22778a.f22757b.isSelected());
        } else if (m.a(it, gVar.T().f22778a.f22758c)) {
            final List<HistoryLiveListData> listQ = gVar.i0().Q();
            if (listQ.isEmpty()) {
                s1.a(gVar.S(), gVar.getString(2131952903));
                return z.f17874a;
            }
            v7.c cVar = new v7.c(null, new c9.a() { // from class: com.live.evo_mobile.ui.favorite.f
                @Override // c9.a
                public final Object invoke() {
                    return g.l0(this.f7942a, listQ);
                }
            }, 1, null);
            FragmentManager childFragmentManager = gVar.getChildFragmentManager();
            m.e(childFragmentManager, "getChildFragmentManager(...)");
            cVar.X(childFragmentManager);
        }
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z l0(g gVar, List list) {
        kotlinx.coroutines.j.d(n1.f14892a, a1.b(), null, gVar.new e(list, null), 2, null);
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.live.evo_mobile.adapter.f m0() {
        return new com.live.evo_mobile.adapter.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        String strValueOf;
        String string;
        if (getContext() != null) {
            Context context = getContext();
            if (context != null) {
                string = context.getString(2131951852);
            } else {
                string = null;
            }
            strValueOf = String.valueOf(string);
        } else {
            strValueOf = "";
        }
        for (ChannelStreamResponse channelStreamResponse : t.v.c.i.a.o(t.v.c.i.a.f18646a, strValueOf, null, 2, null)) {
            if (t.v.c.i.a.f18646a.m0(channelStreamResponse.getKey())) {
                String streamName = channelStreamResponse.getStreamName();
                m.e(streamName, "getStreamName(...)");
                String iconUrl = channelStreamResponse.getIconUrl();
                m.e(iconUrl, "getIconUrl(...)");
                String streamId = channelStreamResponse.getStreamId();
                m.e(streamId, "getStreamId(...)");
                this.mList.add(new HistoryLiveListData(streamName, iconUrl, streamId, channelStreamResponse.getKey(), false, 16, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z j0(g gVar, Boolean bool) {
        if (bool.booleanValue()) {
            gVar.T().f22778a.f22756a.setVisibility(0);
        } else {
            gVar.T().f22778a.f22756a.setVisibility(8);
        }
        com.live.evo_mobile.adapter.f fVarI0 = gVar.i0();
        m.c(bool);
        fVarI0.Z(bool.booleanValue());
        gVar.T().f22778a.f22757b.setSelected(false);
        return z.f17874a;
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int R() {
        return R$color.color_focused;
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void V() {
        FavoriteListActivity favoriteListActivity;
        T().f22779b.setAdapter(i0());
        i0().Y(new b());
        i0().R(new c());
        MutableLiveData<Boolean> mutableLiveDataI = null;
        kotlinx.coroutines.j.d(n1.f14892a, a1.b(), null, new d(null), 2, null);
        FragmentActivity fragmentActivityS = S();
        if (fragmentActivityS instanceof FavoriteListActivity) {
            favoriteListActivity = (FavoriteListActivity) fragmentActivityS;
        } else {
            favoriteListActivity = null;
        }
        if (favoriteListActivity != null) {
            mutableLiveDataI = favoriteListActivity.I();
        }
        if (mutableLiveDataI != null) {
            mutableLiveDataI.observe(this, new f(new c9.l() { // from class: com.live.evo_mobile.ui.favorite.d
                @Override // c9.l
                public final Object invoke(Object obj) {
                    return g.j0(this.f7940a, (Boolean) obj);
                }
            }));
        }
        com.tvc.lib.mobile.ext.d.f(new View[]{T().f22778a.f22757b, T().f22778a.f22759d, T().f22778a.f22758c}, 0L, new c9.l() { // from class: com.live.evo_mobile.ui.favorite.e
            @Override // c9.l
            public final Object invoke(Object obj) {
                return g.k0(this.f7941a, (View) obj);
            }
        }, 2, null);
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int W() {
        return R$layout.fragment_history_live;
    }
}
