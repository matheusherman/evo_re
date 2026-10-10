package com.tvc.lib.mobile.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.StringRes;
import com.tvc.lib.R$id;
import com.tvc.lib.R$layout;
import kotlin.Metadata;
import r8.z;
import t.v.c.widget.ImageView;
import t.v.c.widget.LinearLayout;
import t.v.c.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\r\u0010\bJ!\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\f2\b\b\u0001\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001a\u0010\u001eR\u0016\u0010\u001d\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/tvc/lib/mobile/ui/widget/FullscreenMenuView;", "Lt/v/c/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lr8/z;", "b", "Lkotlin/Function1;", "Landroid/view/View;", "onClick", "setViewOnClickListener", "(Lc9/l;)V", "", "show", "setStillShow", "(Z)V", "hide", "setHideOrVisibility", "titleId", "setTitle", "(I)V", "", "title", "(Ljava/lang/String;)V", "Lt/v/c/widget/TextView;", "d", "Lt/v/c/widget/TextView;", "Lt/v/c/widget/ImageView;", "e", "Lt/v/c/widget/ImageView;", "icon", "f", "Lt/v/c/widget/LinearLayout;", "itemLayout", "g", "Z", "isStillShow", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FullscreenMenuView extends LinearLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView title;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView icon;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout itemLayout;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isStillShow;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FullscreenMenuView(Context context) {
        this(context, null);
        kotlin.jvm.internal.m.f(context, "context");
    }

    public final void setHideOrVisibility(boolean hide) {
        LinearLayout linearLayout = null;
        if (hide) {
            LinearLayout linearLayout2 = this.itemLayout;
            if (linearLayout2 == null) {
                kotlin.jvm.internal.m.v("itemLayout");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout3 = this.itemLayout;
        if (linearLayout3 == null) {
            kotlin.jvm.internal.m.v("itemLayout");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setVisibility(0);
    }

    public final void setTitle(@StringRes int titleId) {
        TextView textView = this.title;
        if (textView == null) {
            kotlin.jvm.internal.m.v("title");
            textView = null;
        }
        textView.setText(getContext().getString(titleId));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FullscreenMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.m.f(context, "context");
    }

    public final void setStillShow(boolean show) {
        this.isStillShow = show;
        if (show) {
            TextView textView = this.title;
            if (textView == null) {
                kotlin.jvm.internal.m.v("title");
                textView = null;
            }
            textView.setVisibility(0);
        }
    }

    public final void setTitle(String title) {
        kotlin.jvm.internal.m.f(title, "title");
        if (TextUtils.isEmpty(title)) {
            return;
        }
        TextView textView = this.title;
        if (textView == null) {
            kotlin.jvm.internal.m.v("title");
            textView = null;
        }
        textView.setText(title);
    }

    public final void setViewOnClickListener(final c9.l<? super View, z> onClick) {
        kotlin.jvm.internal.m.f(onClick, "onClick");
        LinearLayout linearLayout = this.itemLayout;
        if (linearLayout == null) {
            kotlin.jvm.internal.m.v("itemLayout");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tvc.lib.mobile.ui.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FullscreenMenuView.c(onClick, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenMenuView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.m.f(context, "context");
        b(context, attributeSet);
    }

    private final void b(Context context, AttributeSet attr) {
        LayoutInflater.from(context).inflate(R$layout.layout_fullscreen_menu, (ViewGroup) this, true);
        this.title = (TextView) findViewById(R$id.name);
        this.icon = (ImageView) findViewById(R$id.icon);
        this.itemLayout = (LinearLayout) findViewById(R$id.item_layout);
        if (this.isStillShow) {
            TextView textView = this.title;
            if (textView == null) {
                kotlin.jvm.internal.m.v("title");
                textView = null;
            }
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(c9.l lVar, View view) {
        kotlin.jvm.internal.m.c(view);
        lVar.invoke(view);
    }
}
