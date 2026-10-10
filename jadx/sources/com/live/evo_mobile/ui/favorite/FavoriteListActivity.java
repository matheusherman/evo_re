package com.live.evo_mobile.ui.favorite;

import android.content.Intent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.p000lifecycle.Lifecycle;
import androidx.p000lifecycle.MutableLiveData;
import androidx.p000lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import c9.l;
import com.live.evo.R$color;
import com.live.evo.R$layout;
import com.tvc.lib.mobile.ext.i;
import com.tvc.lib.mobile.ui.base.BaseDataBindActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;
import r8.z;
import u7.HistoryLiveListData;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/live/evo_mobile/ui/favorite/FavoriteListActivity;", "Lcom/tvc/lib/mobile/ui/base/BaseDataBindActivity;", "Lz4/f;", "<init>", "()V", "", NotificationCompat.CATEGORY_STATUS, "Lr8/z;", "M", "(Z)V", "", "x", "()I", "v", "Lu7/e;", "item", "L", "(Lu7/e;)V", "Landroidx/lifecycle/MutableLiveData;", "I", "()Landroidx/lifecycle/MutableLiveData;", "", "", "k", "Ljava/util/List;", "mTitles", "Landroidx/fragment/app/Fragment;", "l", "mFragments", "m", "Landroidx/lifecycle/MutableLiveData;", "editStatusLive", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FavoriteListActivity extends BaseDataBindActivity<z4.f> {

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private List<String> mTitles = r.r("Live", "VOD");

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final List<Fragment> mFragments = r.r(g.INSTANCE.a());

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Boolean> editStatusLive = new MutableLiveData<>();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class a implements Observer, h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ l f7937a;

        a(l function) {
            m.f(function, "function");
            this.f7937a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof h)) {
                return m.a(getFunctionDelegate(), ((h) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.h
        public final r8.c<?> getFunctionDelegate() {
            return this.f7937a;
        }

        @Override // androidx.p000lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f7937a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z J(FavoriteListActivity favoriteListActivity, View it) {
        m.f(it, "it");
        if (m.a(it, favoriteListActivity.t().f22760a)) {
            favoriteListActivity.finish();
        } else if (m.a(it, favoriteListActivity.t().f22764e)) {
            favoriteListActivity.M(false);
        } else if (m.a(it, favoriteListActivity.t().f22761b)) {
            favoriteListActivity.M(true);
        }
        return z.f17874a;
    }

    private final void M(boolean status) {
        this.editStatusLive.setValue(Boolean.valueOf(status));
    }

    public final MutableLiveData<Boolean> I() {
        return this.editStatusLive;
    }

    public final void L(HistoryLiveListData item) {
        m.f(item, "item");
        Intent intent = new Intent();
        intent.putExtra("channelId", item.getId());
        setResult(2, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z K(FavoriteListActivity favoriteListActivity, Boolean bool) {
        if (bool.booleanValue()) {
            favoriteListActivity.t().f22764e.setVisibility(0);
            favoriteListActivity.t().f22761b.setVisibility(8);
        } else {
            favoriteListActivity.t().f22764e.setVisibility(8);
            favoriteListActivity.t().f22761b.setVisibility(0);
        }
        return z.f17874a;
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public void v() {
        com.tvc.lib.mobile.ext.a.c(this, R$color.status_bar_bg_color, Boolean.FALSE);
        this.mTitles = r.r(getString(2131952372), getString(2131952198));
        ViewPager2 viewPager2 = t().f22766g;
        m.e(viewPager2, "viewPager2");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        m.e(supportFragmentManager, "getSupportFragmentManager(...)");
        Lifecycle lifecycle = getLifecycle();
        m.e(lifecycle, "<get-lifecycle>(...)");
        com.tvc.lib.mobile.ext.l.c(viewPager2, supportFragmentManager, lifecycle, this.mFragments, 0, 8, null);
        ViewPager2 viewPager3 = t().f22766g;
        m.e(viewPager3, "viewPager2");
        com.tvc.lib.mobile.ext.l.d(viewPager3, t().f22763d, this.mTitles);
        i.b(t().f22763d);
        t().f22765f.setText(getString(2131953179));
        com.tvc.lib.mobile.ext.d.f(new View[]{t().f22760a, t().f22764e, t().f22761b}, 0L, new l() { // from class: com.live.evo_mobile.ui.favorite.a
            @Override // c9.l
            public final Object invoke(Object obj) {
                return FavoriteListActivity.J(this.f7938a, (View) obj);
            }
        }, 2, null);
        this.editStatusLive.observe(this, new a(new l() { // from class: com.live.evo_mobile.ui.favorite.b
            @Override // c9.l
            public final Object invoke(Object obj) {
                return FavoriteListActivity.K(this.f7939a, (Boolean) obj);
            }
        }));
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public int x() {
        return R$layout.activity_history_list;
    }
}
