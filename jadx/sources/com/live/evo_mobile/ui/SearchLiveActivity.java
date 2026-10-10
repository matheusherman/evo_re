package com.live.evo_mobile.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.stub.StubApp;
import com.tvc.lib.mobile.ui.base.BaseDataBindActivity;
import com.tvc.lib.mobile.ui.widget.flexbox.FlexboxLayoutManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import u7.LiveSearchListData;
import z1.b1.lb.m.meta.ChannelStreamResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0017\u0010\u0004R\u0014\u0010\u001a\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/live/evo_mobile/ui/SearchLiveActivity;", "Lcom/tvc/lib/mobile/ui/base/BaseDataBindActivity;", "Lz4/i;", "<init>", "()V", "Lr8/z;", "U", "f0", "", "keyword", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/String;)V", "query", "c0", "d0", "Landroid/content/Context;", "context", "a0", "(Landroid/content/Context;)V", "", "x", "()I", "v", "onDestroy", "k", "Ljava/lang/String;", "SEARCH_LIVE_HISTORY_KEY", "Lz7/c;", "l", "Lz7/c;", "mutableSet", "Lcom/google/gson/e;", "m", "Lcom/google/gson/e;", "gson", "", "Lu7/f;", "n", "Ljava/util/List;", "mChannelList", "Lx1/f1/lb/config/c;", "o", "Lx1/f1/lb/config/c;", "loading", "Lcom/live/evo_mobile/adapter/g;", "p", "Lr8/i;", ExifInterface.GPS_DIRECTION_TRUE, "()Lcom/live/evo_mobile/adapter/g;", "mLiveListAdapter", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchLiveActivity extends BaseDataBindActivity<z4.i> {

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private z7.c<String> mutableSet;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private x1.f1.lb.config.c loading;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final String SEARCH_LIVE_HISTORY_KEY = "search_live_history_key";

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final com.google.gson.e gson = new com.google.gson.e();

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private List<LiveSearchListData> mChannelList = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final r8.i mLiveListAdapter = r8.j.a(new c9.a() { // from class: com.live.evo_mobile.ui.v1
        @Override // c9.a
        public final Object invoke() {
            return SearchLiveActivity.b0();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo_mobile/ui/SearchLiveActivity$a", "Lx1/f1/lb/util/w0$a;", "", "value", "Lr8/z;", "c", "(Ljava/lang/String;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements x1.f1.lb.util.w0.a<String> {

        /* JADX INFO: renamed from: com.live.evo_mobile.ui.SearchLiveActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/live/evo_mobile/ui/SearchLiveActivity$a$a", "Lf3/a;", "Lz7/c;", "", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0133a extends f3.a<z7.c<String>> {
            C0133a() {
            }
        }

        a() {
        }

        @Override // x1.f1.lb.util.w0.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(final String value) {
            kotlin.jvm.internal.m.f(value, "value");
            final SearchLiveActivity searchLiveActivity = SearchLiveActivity.this;
            searchLiveActivity.runOnUiThread(new Runnable() { // from class: com.live.evo_mobile.ui.x1
                @Override // java.lang.Runnable
                public final void run() {
                    SearchLiveActivity.a.d(value, searchLiveActivity);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(String str, SearchLiveActivity searchLiveActivity) {
            if (str.length() > 0) {
                try {
                    searchLiveActivity.mutableSet = (z7.c) searchLiveActivity.gson.o(str, new C0133a().d());
                    if (searchLiveActivity.mutableSet != null) {
                        searchLiveActivity.f0();
                        return;
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            searchLiveActivity.t().f22798f.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo_mobile/ui/SearchLiveActivity$b", "Lcom/live/evo_mobile/adapter/i$a;", "", "item", "Lr8/z;", "a", "(Ljava/lang/String;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements com.live.evo_mobile.adapter.i.a {
        b() {
        }

        @Override // com.live.evo_mobile.adapter.i.a
        public void a(String item) {
            kotlin.jvm.internal.m.f(item, "item");
            SearchLiveActivity.this.t().f22793a.setText(item);
            SearchLiveActivity.this.t().f22793a.setSelection(item.length());
            SearchLiveActivity.this.c0(item);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean X(SearchLiveActivity searchLiveActivity, TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 3) {
            return false;
        }
        searchLiveActivity.c0(String.valueOf(searchLiveActivity.t().f22793a.getText()));
        return true;
    }

    private final void S(String keyword) {
        if (this.mutableSet == null) {
            this.mutableSet = new z7.c<>(0, 1, null);
        }
        z7.c<String> cVar = this.mutableSet;
        kotlin.jvm.internal.m.c(cVar);
        cVar.add(keyword);
        try {
            x1.f1.lb.util.w0 w0Var = x1.f1.lb.util.w0.f21452a;
            String str = this.SEARCH_LIVE_HISTORY_KEY;
            String strW = this.gson.w(this.mutableSet);
            kotlin.jvm.internal.m.e(strW, "toJson(...)");
            w0Var.t(str, strW);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private final com.live.evo_mobile.adapter.g T() {
        return (com.live.evo_mobile.adapter.g) this.mLiveListAdapter.getValue();
    }

    private final void U() {
        x1.f1.lb.util.w0.p(x1.f1.lb.util.w0.f21452a, this.SEARCH_LIVE_HISTORY_KEY, new a(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(SearchLiveActivity searchLiveActivity, View view) {
        try {
            x1.f1.lb.util.w0.f21452a.t(searchLiveActivity.SEARCH_LIVE_HISTORY_KEY, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        searchLiveActivity.mutableSet = null;
        if (searchLiveActivity.t().f22798f.getAdapter() != null) {
            RecyclerView.Adapter adapter = searchLiveActivity.t().f22798f.getAdapter();
            kotlin.jvm.internal.m.d(adapter, "null cannot be cast to non-null type com.live.evo_mobile.adapter.SearchHistoryAdapter");
            ((com.live.evo_mobile.adapter.i) adapter).e(new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z Y(SearchLiveActivity searchLiveActivity, View it) {
        kotlin.jvm.internal.m.f(it, "it");
        if (kotlin.jvm.internal.m.a(it, searchLiveActivity.t().f22794b)) {
            searchLiveActivity.finish();
        }
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(SearchLiveActivity searchLiveActivity, g0.d adapter, View view, int i10) {
        kotlin.jvm.internal.m.f(adapter, "adapter");
        kotlin.jvm.internal.m.f(view, "view");
        if (adapter.getItem(i10) != null) {
            Intent intent = new Intent();
            LiveSearchListData liveSearchListData = (LiveSearchListData) adapter.getItem(i10);
            intent.putExtra("channelId", liveSearchListData != null ? liveSearchListData.getId() : null);
            searchLiveActivity.setResult(3, intent);
            searchLiveActivity.finish();
        }
    }

    private final void a0(Context context) {
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        List<ChannelStreamResponse> listN = aVar.n(context.getString(2131951852), Boolean.valueOf(aVar.e0() && u5.i.INSTANCE.a()));
        this.mChannelList.clear();
        for (ChannelStreamResponse channelStreamResponse : listN) {
            String strB = t.v.c.i.a.f18646a.b(channelStreamResponse);
            if (strB.length() <= 1) {
                strB = "00" + strB;
                kotlin.jvm.internal.m.e(strB, "toString(...)");
            } else if (strB.length() <= 2) {
                strB = "0" + strB;
                kotlin.jvm.internal.m.e(strB, "toString(...)");
            }
            String str = strB;
            List<LiveSearchListData> list = this.mChannelList;
            String streamName = channelStreamResponse.getStreamName();
            kotlin.jvm.internal.m.e(streamName, "getStreamName(...)");
            String iconUrl = channelStreamResponse.getIconUrl();
            kotlin.jvm.internal.m.e(iconUrl, "getIconUrl(...)");
            String streamId = channelStreamResponse.getStreamId();
            kotlin.jvm.internal.m.e(streamId, "getStreamId(...)");
            list.add(new LiveSearchListData(streamName, iconUrl, streamId, channelStreamResponse.getKey(), str, null, false, 96, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.live.evo_mobile.adapter.g b0() {
        return new com.live.evo_mobile.adapter.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(String query) {
        x1.f1.lb.config.c cVar = this.loading;
        if (cVar != null) {
            cVar.b();
        }
        if (TextUtils.isEmpty(query)) {
            d0();
            x1.f1.lb.config.c cVar2 = this.loading;
            if (cVar2 != null) {
                cVar2.a();
                return;
            }
            return;
        }
        S(query);
        f0();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (this.mChannelList.isEmpty()) {
            a0(this);
        }
        int size = this.mChannelList.size();
        if (size < 1) {
            d0();
            x1.f1.lb.config.c cVar3 = this.loading;
            if (cVar3 != null) {
                cVar3.a();
                return;
            }
            return;
        }
        for (int i10 = 0; i10 < size; i10++) {
            LiveSearchListData liveSearchListData = this.mChannelList.get(i10);
            String strE = ua.n.E(liveSearchListData.getName(), " ", "", false, 4, null);
            if (ua.n.G(strE, query, true)) {
                arrayList2.add(liveSearchListData);
            } else if (ua.n.M(strE, query, true)) {
                arrayList3.add(liveSearchListData);
            }
        }
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        if (arrayList.isEmpty()) {
            d0();
            return;
        }
        T().submitList(arrayList);
        x1.f1.lb.config.c cVar4 = this.loading;
        if (cVar4 != null) {
            cVar4.a();
        }
    }

    private final void d0() {
        runOnUiThread(new Runnable() { // from class: com.live.evo_mobile.ui.w1
            @Override // java.lang.Runnable
            public final void run() {
                SearchLiveActivity.e0(this.f8208a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(SearchLiveActivity searchLiveActivity, View view) {
        searchLiveActivity.c0(String.valueOf(searchLiveActivity.t().f22793a.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(SearchLiveActivity searchLiveActivity) {
        searchLiveActivity.T().z(true);
        searchLiveActivity.T().A(searchLiveActivity.s(), R$layout.view_empty_data);
        searchLiveActivity.T().submitList(kotlin.collections.r.l());
        x1.f1.lb.config.c cVar = searchLiveActivity.loading;
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        List<String> listQ0;
        t().f22798f.setVisibility(0);
        z7.c<String> cVar = this.mutableSet;
        if (cVar != null) {
            listQ0 = kotlin.collections.r.Q0(cVar);
        } else {
            listQ0 = null;
        }
        kotlin.jvm.internal.m.c(listQ0);
        kotlin.collections.r.V(listQ0);
        if (t().f22798f.getAdapter() != null) {
            RecyclerView.Adapter adapter = t().f22798f.getAdapter();
            kotlin.jvm.internal.m.d(adapter, "null cannot be cast to non-null type com.live.evo_mobile.adapter.SearchHistoryAdapter");
            ((com.live.evo_mobile.adapter.i) adapter).e(listQ0);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mChannelList.clear();
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public void v() {
        com.tvc.lib.mobile.ext.a.c(this, R$color.status_bar_bg_color, Boolean.FALSE);
        this.loading = z7.j.k(z7.j.f23105a, R$id.loading_layout, R$color.color_focused, t().getRoot(), 0, 8, null);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(StubApp.getOrigApplicationContext(getApplicationContext()));
        flexboxLayoutManager.U(0);
        flexboxLayoutManager.V(1);
        flexboxLayoutManager.W(0);
        flexboxLayoutManager.T(4);
        t().f22798f.setLayoutManager(flexboxLayoutManager);
        t().f22798f.addItemDecoration(new com.tvc.lib.mobile.ui.base.i(z7.p.a(8, StubApp.getOrigApplicationContext(getApplicationContext()))));
        ArrayList arrayList = new ArrayList();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this);
        kotlin.jvm.internal.m.e(layoutInflaterFrom, "from(...)");
        t().f22798f.setAdapter(new com.live.evo_mobile.adapter.i(arrayList, layoutInflaterFrom, new b()));
        t().f22796d.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchLiveActivity.V(this.f8168a, view);
            }
        });
        t().f22801i.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.r1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchLiveActivity.W(this.f8172a, view);
            }
        });
        t().f22793a.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.live.evo_mobile.ui.s1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                return SearchLiveActivity.X(this.f8175a, textView, i10, keyEvent);
            }
        });
        com.tvc.lib.mobile.ext.d.f(new View[]{t().f22794b}, 0L, new c9.l() { // from class: com.live.evo_mobile.ui.t1
            @Override // c9.l
            public final Object invoke(Object obj) {
                return SearchLiveActivity.Y(this.f8199a, (View) obj);
            }
        }, 2, null);
        t().f22800h.setAdapter(T());
        if (t().f22800h.getItemDecorationCount() == 0) {
            t().f22800h.addItemDecoration(new com.tvc.lib.mobile.ui.widget.q(0, 0, z7.p.a(0, this), 0));
        }
        T().C(new g0.d.InterfaceC0181d() { // from class: com.live.evo_mobile.ui.u1
            @Override // g0.d.InterfaceC0181d
            public final void b(g0.d dVar, View view, int i10) {
                SearchLiveActivity.Z(this.f8203a, dVar, view, i10);
            }
        });
        U();
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public int x() {
        return R$layout.activity_live_search;
    }
}
