package com.live.evo_mobile.ui;

import android.content.Intent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.p000lifecycle.Lifecycle;
import androidx.p000lifecycle.MutableLiveData;
import androidx.p000lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.live.evo.R$color;
import com.live.evo.R$layout;
import com.tvc.lib.mobile.ui.base.BaseDataBindActivity;
import java.util.List;
import kotlin.Metadata;
import u7.HistoryLiveListData;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/live/evo_mobile/ui/HistoryListActivity;", "Lcom/tvc/lib/mobile/ui/base/BaseDataBindActivity;", "Lz4/f;", "<init>", "()V", "", NotificationCompat.CATEGORY_STATUS, "Lr8/z;", "M", "(Z)V", "", "x", "()I", "v", "Lu7/e;", "item", "L", "(Lu7/e;)V", "Landroidx/lifecycle/MutableLiveData;", "I", "()Landroidx/lifecycle/MutableLiveData;", "", "", "k", "Ljava/util/List;", "mTitles", "Landroidx/fragment/app/Fragment;", "l", "mFragments", "m", "Landroidx/lifecycle/MutableLiveData;", "editStatusLive", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HistoryListActivity extends BaseDataBindActivity<z4.f> {

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private List<String> mTitles = kotlin.collections.r.r("Live", "VOD");

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final List<Fragment> mFragments = kotlin.collections.r.r(d0.INSTANCE.a());

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Boolean> editStatusLive = new MutableLiveData<>();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class a implements Observer, kotlin.jvm.internal.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ c9.l f7830a;

        a(c9.l function) {
            kotlin.jvm.internal.m.f(function, "function");
            this.f7830a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.h)) {
                return kotlin.jvm.internal.m.a(getFunctionDelegate(), ((kotlin.jvm.internal.h) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.h
        public final r8.c<?> getFunctionDelegate() {
            return this.f7830a;
        }

        @Override // androidx.p000lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f7830a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z J(HistoryListActivity historyListActivity, View it) {
        kotlin.jvm.internal.m.f(it, "it");
        if (kotlin.jvm.internal.m.a(it, historyListActivity.t().f22760a)) {
            historyListActivity.finish();
        } else if (kotlin.jvm.internal.m.a(it, historyListActivity.t().f22764e)) {
            historyListActivity.M(false);
        } else if (kotlin.jvm.internal.m.a(it, historyListActivity.t().f22761b)) {
            historyListActivity.M(true);
        }
        return r8.z.f17874a;
    }

    private final void M(boolean status) {
        this.editStatusLive.setValue(Boolean.valueOf(status));
    }

    public final MutableLiveData<Boolean> I() {
        return this.editStatusLive;
    }

    public final void L(HistoryLiveListData item) {
        kotlin.jvm.internal.m.f(item, "item");
        Intent intent = new Intent();
        intent.putExtra("channelId", item.getId());
        setResult(2, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z K(HistoryListActivity historyListActivity, Boolean bool) {
        if (bool.booleanValue()) {
            historyListActivity.t().f22764e.setVisibility(0);
            historyListActivity.t().f22761b.setVisibility(8);
        } else {
            historyListActivity.t().f22764e.setVisibility(8);
            historyListActivity.t().f22761b.setVisibility(0);
        }
        return r8.z.f17874a;
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public void v() {
        com.tvc.lib.mobile.ext.a.c(this, R$color.status_bar_bg_color, Boolean.FALSE);
        this.mTitles = kotlin.collections.r.r(getString(2131952372), getString(2131952198));
        ViewPager2 viewPager2 = t().f22766g;
        kotlin.jvm.internal.m.e(viewPager2, "viewPager2");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        kotlin.jvm.internal.m.e(supportFragmentManager, "getSupportFragmentManager(...)");
        Lifecycle lifecycle = getLifecycle();
        kotlin.jvm.internal.m.e(lifecycle, "<get-lifecycle>(...)");
        com.tvc.lib.mobile.ext.l.c(viewPager2, supportFragmentManager, lifecycle, this.mFragments, 0, 8, null);
        ViewPager2 viewPager3 = t().f22766g;
        kotlin.jvm.internal.m.e(viewPager3, "viewPager2");
        com.tvc.lib.mobile.ext.l.d(viewPager3, t().f22763d, this.mTitles);
        com.tvc.lib.mobile.ext.i.b(t().f22763d);
        com.tvc.lib.mobile.ext.d.f(new View[]{t().f22760a, t().f22764e, t().f22761b}, 0L, new c9.l() { // from class: com.live.evo_mobile.ui.x
            @Override // c9.l
            public final Object invoke(Object obj) {
                return HistoryListActivity.J(this.f8209a, (View) obj);
            }
        }, 2, null);
        this.editStatusLive.observe(this, new a(new c9.l() { // from class: com.live.evo_mobile.ui.y
            @Override // c9.l
            public final Object invoke(Object obj) {
                return HistoryListActivity.K(this.f8213a, (Boolean) obj);
            }
        }));
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public int x() {
        return R$layout.activity_history_list;
    }
}
