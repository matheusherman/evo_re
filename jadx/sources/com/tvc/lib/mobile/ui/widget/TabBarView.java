package com.tvc.lib.mobile.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import com.google.android.material.tabs.TabLayout;
import com.tvc.lib.R$color;
import com.tvc.lib.R$id;
import com.tvc.lib.R$layout;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0002\u001a\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\r\u0010\bJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0014\u001a\u00020\f2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f\u0018\u00010\u0011¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010 ¨\u0006!"}, d2 = {"Lcom/tvc/lib/mobile/ui/widget/TabBarView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lr8/z;", "c", "position", "e", "(I)V", "Lkotlin/Function1;", "Lcom/tvc/lib/mobile/ui/widget/s$a;", "onSelected", "setSelectListener", "(Lc9/l;)V", "Lcom/tvc/lib/mobile/ui/widget/s;", "tabBarConfig", "d", "(Lcom/tvc/lib/mobile/ui/widget/s;Lc9/l;)V", "a", "Lcom/tvc/lib/mobile/ui/widget/s;", "Lp7/a;", "b", "Lp7/a;", "mDataBinding", "Lc9/l;", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabBarView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private TabBarBean tabBarConfig;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private p7.a mDataBinding;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private c9.l<? super TabBarBean.ItemBean, z> onSelected;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001\u001eB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u000e\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/tvc/lib/mobile/ui/widget/TabBarView$b;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lr8/z;", "block", "f", "(Ljava/lang/String;Lc9/l;)V", "", "d", "(Ljava/lang/String;)Z", "visible", "setUnreadVisible", "(Z)V", "Lcom/tvc/lib/mobile/ui/widget/s;", "tabBarConfig", "Lcom/tvc/lib/mobile/ui/widget/s$a;", "tab", "selectId", "g", "(Lcom/tvc/lib/mobile/ui/widget/s;Lcom/tvc/lib/mobile/ui/widget/s$a;Ljava/lang/String;)V", "Landroidx/appcompat/widget/AppCompatImageView;", "a", "Lr8/i;", "getIvTabIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "ivTabIcon", "Landroidx/appcompat/widget/AppCompatTextView;", "b", "getTvTabName", "()Landroidx/appcompat/widget/AppCompatTextView;", "tvTabName", "c", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends RelativeLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final r8.i ivTabIcon;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final r8.i tvTabName;

        /* JADX INFO: renamed from: com.tvc.lib.mobile.ui.widget.TabBarView$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ui.widget.TabBarView$TabBarItemView$requestDrawable$1", f = "TabBarView.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0167b extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
            final /* synthetic */ c9.l<Drawable, z> $block;
            final /* synthetic */ String $url;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: com.tvc.lib.mobile.ui.widget.TabBarView$b$b$a */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ui.widget.TabBarView$TabBarItemView$requestDrawable$1$1", f = "TabBarView.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ c9.l<Drawable, z> $block;
                final /* synthetic */ File $file;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                a(c9.l<? super Drawable, z> lVar, File file, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.$block = lVar;
                    this.$file = file;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.$block, this.$file, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    String absolutePath;
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        c9.l<Drawable, z> lVar = this.$block;
                        if (lVar != null) {
                            File file = this.$file;
                            if (file != null) {
                                absolutePath = file.getAbsolutePath();
                            } else {
                                absolutePath = null;
                            }
                            lVar.invoke(Drawable.createFromPath(absolutePath));
                        }
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0167b(String str, c9.l<? super Drawable, z> lVar, v8.f<? super C0167b> fVar) {
                super(2, fVar);
                this.$url = str;
                this.$block = lVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                C0167b c0167b = b.this.new C0167b(this.$url, this.$block, fVar);
                c0167b.L$0 = obj;
                return c0167b;
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((C0167b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    l0 l0Var = (l0) this.L$0;
                    Context context = b.this.getContext();
                    kotlin.jvm.internal.m.e(context, "getContext(...)");
                    kotlinx.coroutines.j.d(l0Var, a1.c(), null, new a(this.$block, com.tvc.lib.mobile.ext.e.b(context, this.$url), null), 2, null);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        private final void f(String url, c9.l<? super Drawable, z> block) {
            if (url != null && url.length() != 0 && d(url)) {
                kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new C0167b(url, block, null), 3, null);
            } else if (block != null) {
                block.invoke(null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            kotlin.jvm.internal.m.f(context, "context");
            this.ivTabIcon = r8.j.a(new c9.a() { // from class: com.tvc.lib.mobile.ui.widget.u
                @Override // c9.a
                public final Object invoke() {
                    return TabBarView.b.e(this.f9542a);
                }
            });
            this.tvTabName = r8.j.a(new c9.a() { // from class: com.tvc.lib.mobile.ui.widget.v
                @Override // c9.a
                public final Object invoke() {
                    return TabBarView.b.i(this.f9543a);
                }
            });
            LayoutInflater.from(context).inflate(R$layout.common_view_tab_item, this);
            setGravity(17);
        }

        private final boolean d(String url) {
            if (url != null) {
                return new ua.l("[a-zA-z]+://\\S*").d(url);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AppCompatImageView e(b bVar) {
            return (AppCompatImageView) bVar.findViewById(R$id.iv_tab_icon);
        }

        private final AppCompatImageView getIvTabIcon() {
            Object value = this.ivTabIcon.getValue();
            kotlin.jvm.internal.m.e(value, "getValue(...)");
            return (AppCompatImageView) value;
        }

        private final AppCompatTextView getTvTabName() {
            Object value = this.tvTabName.getValue();
            kotlin.jvm.internal.m.e(value, "getValue(...)");
            return (AppCompatTextView) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AppCompatTextView i(b bVar) {
            return (AppCompatTextView) bVar.findViewById(R$id.tv_tab_name);
        }

        public final void g(TabBarBean tabBarConfig, TabBarBean.ItemBean tab, String selectId) {
            kotlin.jvm.internal.m.f(tabBarConfig, "tabBarConfig");
            kotlin.jvm.internal.m.f(tab, "tab");
            kotlin.jvm.internal.m.f(selectId, "selectId");
            if (tab.getIsCdn()) {
                f(kotlin.jvm.internal.m.a(selectId, tab.getId()) ? tab.getSelectedIconPath() : tab.getIconPath(), new c9.l() { // from class: com.tvc.lib.mobile.ui.widget.t
                    @Override // c9.l
                    public final Object invoke(Object obj) {
                        return TabBarView.b.h(this.f9541a, (Drawable) obj);
                    }
                });
            } else {
                getIvTabIcon().setImageResource(kotlin.jvm.internal.m.a(selectId, tab.getId()) ? tab.getSelectedIconId() : tab.getIconId());
            }
            getTvTabName().setText(tab.getText());
            getTvTabName().setTextColor(kotlin.jvm.internal.m.a(selectId, tab.getId()) ? tabBarConfig.getSelectedColor() : tabBarConfig.getColor());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final z h(b bVar, Drawable drawable) {
            bVar.getIvTabIcon().setImageDrawable(drawable);
            return z.f17874a;
        }

        public final void setUnreadVisible(boolean visible) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"com/tvc/lib/mobile/ui/widget/TabBarView$c", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "Lr8/z;", "onTabReselected", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "onTabUnselected", "onTabSelected", "", "a", "Z", "getFirstSelected", "()Z", "setFirstSelected", "(Z)V", "firstSelected", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements TabLayout.OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean firstSelected = true;

        c() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null) {
                TabBarView tabBarView = TabBarView.this;
                View customView = tab.getCustomView();
                kotlin.jvm.internal.m.d(customView, "null cannot be cast to non-null type com.tvc.lib.mobile.ui.widget.TabBarView.TabBarItemView");
                b bVar = (b) customView;
                Object tag = tab.getTag();
                TabBarBean tabBarBean = null;
                TabBarBean.ItemBean itemBean = tag instanceof TabBarBean.ItemBean ? (TabBarBean.ItemBean) tag : null;
                if (itemBean == null) {
                    return;
                }
                TabBarBean tabBarBean2 = tabBarView.tabBarConfig;
                if (tabBarBean2 == null) {
                    kotlin.jvm.internal.m.v("tabBarConfig");
                } else {
                    tabBarBean = tabBarBean2;
                }
                bVar.g(tabBarBean, itemBean, itemBean.getId());
                this.firstSelected = false;
                c9.l lVar = tabBarView.onSelected;
                if (lVar != null) {
                    lVar.invoke(itemBean);
                }
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            if (tab != null) {
                TabBarView tabBarView = TabBarView.this;
                View customView = tab.getCustomView();
                kotlin.jvm.internal.m.d(customView, "null cannot be cast to non-null type com.tvc.lib.mobile.ui.widget.TabBarView.TabBarItemView");
                b bVar = (b) customView;
                Object tag = tab.getTag();
                TabBarBean tabBarBean = null;
                TabBarBean.ItemBean itemBean = tag instanceof TabBarBean.ItemBean ? (TabBarBean.ItemBean) tag : null;
                if (itemBean == null) {
                    return;
                }
                TabBarBean tabBarBean2 = tabBarView.tabBarConfig;
                if (tabBarBean2 == null) {
                    kotlin.jvm.internal.m.v("tabBarConfig");
                } else {
                    tabBarBean = tabBarBean2;
                }
                bVar.g(tabBarBean, itemBean, "");
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabBarView(Context context) {
        super(context);
        kotlin.jvm.internal.m.f(context, "context");
        c(context, null);
    }

    public final void d(TabBarBean tabBarConfig, c9.l<? super TabBarBean.ItemBean, z> onSelected) {
        kotlin.jvm.internal.m.f(tabBarConfig, "tabBarConfig");
        this.tabBarConfig = tabBarConfig;
        this.onSelected = onSelected;
        p7.a aVar = this.mDataBinding;
        kotlin.jvm.internal.m.c(aVar);
        aVar.f17362a.removeAllTabs();
        ArrayList<TabBarBean.ItemBean> arrayListD = tabBarConfig.d();
        int size = arrayListD.size();
        if (2 > size || size >= 6) {
            return;
        }
        for (TabBarBean.ItemBean itemBean : arrayListD) {
            Context context = getContext();
            kotlin.jvm.internal.m.e(context, "getContext(...)");
            b bVar = new b(context, null);
            bVar.g(tabBarConfig, itemBean, arrayListD.get(0).getId());
            p7.a aVar2 = this.mDataBinding;
            kotlin.jvm.internal.m.c(aVar2);
            TabLayout tabLayout = aVar2.f17362a;
            p7.a aVar3 = this.mDataBinding;
            kotlin.jvm.internal.m.c(aVar3);
            TabLayout.Tab customView = aVar3.f17362a.newTab().setCustomView(bVar);
            customView.setTag(itemBean);
            tabLayout.addTab(customView);
        }
        p7.a aVar4 = this.mDataBinding;
        kotlin.jvm.internal.m.c(aVar4);
        aVar4.f17362a.setBackgroundColor(tabBarConfig.getBackgroundColor());
        int i10 = kotlin.jvm.internal.m.a(tabBarConfig.getBorderStyle(), "white") ? -1 : ViewCompat.MEASURED_STATE_MASK;
        p7.a aVar5 = this.mDataBinding;
        kotlin.jvm.internal.m.c(aVar5);
        aVar5.f17363b.setBackgroundColor(i10);
    }

    public final void e(int position) {
        TabLayout.Tab tabAt;
        p7.a aVar = this.mDataBinding;
        kotlin.jvm.internal.m.c(aVar);
        TabLayout tabLayout = aVar.f17362a;
        if (tabLayout.getTabCount() <= position || (tabAt = tabLayout.getTabAt(position)) == null) {
            return;
        }
        tabAt.select();
    }

    public final void setSelectListener(c9.l<? super TabBarBean.ItemBean, z> onSelected) {
        this.onSelected = onSelected;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.f(context, "context");
        c(context, attributeSet);
    }

    private final void c(Context context, AttributeSet attrs) {
        this.mDataBinding = (p7.a) DataBindingUtil.inflate(LayoutInflater.from(context), R$layout.common_view_tab_bar, this, true);
        setGravity(80);
        p7.a aVar = this.mDataBinding;
        kotlin.jvm.internal.m.c(aVar);
        aVar.f17362a.setTabRippleColorResource(R$color.transparent);
        p7.a aVar2 = this.mDataBinding;
        kotlin.jvm.internal.m.c(aVar2);
        aVar2.f17362a.setTabGravity(0);
        p7.a aVar3 = this.mDataBinding;
        kotlin.jvm.internal.m.c(aVar3);
        aVar3.f17362a.setTabMode(1);
        p7.a aVar4 = this.mDataBinding;
        kotlin.jvm.internal.m.c(aVar4);
        aVar4.f17362a.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new c());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabBarView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.m.f(context, "context");
        c(context, attributeSet);
    }
}
