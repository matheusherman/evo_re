package com.tvc.lib.mobile.ui.widget;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.ArrayList;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: renamed from: com.tvc.lib.mobile.ui.widget.s, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0016BG\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u0016\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u000fR'\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001d\u001a\u0004\b\u001b\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/tvc/lib/mobile/ui/widget/s;", "", "", TypedValues.Custom.S_COLOR, "selectedColor", "backgroundColor", "", "borderStyle", "Ljava/util/ArrayList;", "Lcom/tvc/lib/mobile/ui/widget/s$a;", "Lkotlin/collections/ArrayList;", "items", "<init>", "(IIILjava/lang/String;Ljava/util/ArrayList;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "c", "b", "e", "d", "Ljava/lang/String;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class TabBarBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int color;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int selectedColor;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int backgroundColor;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String borderStyle;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final ArrayList<ItemBean> items;

    /* JADX INFO: renamed from: com.tvc.lib.mobile.ui.widget.s$a, reason: from toString */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\n\u001a\u00020\t\u0012\b\b\u0003\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\u001c\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001e\u0010\u000fR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001f\u001a\u0004\b\u001d\u0010\u0011¨\u0006 "}, d2 = {"Lcom/tvc/lib/mobile/ui/widget/s$a;", "", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "", "isCdn", "text", "iconPath", "selectedIconPath", "", "iconId", "selectedIconId", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "c", "b", "Z", "g", "()Z", "f", "d", "e", "I", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ItemBean {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String id;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isCdn;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String text;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String iconPath;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final String selectedIconPath;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int iconId;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final int selectedIconId;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemBean)) {
                return false;
            }
            ItemBean itemBean = (ItemBean) other;
            return kotlin.jvm.internal.m.a(this.id, itemBean.id) && this.isCdn == itemBean.isCdn && kotlin.jvm.internal.m.a(this.text, itemBean.text) && kotlin.jvm.internal.m.a(this.iconPath, itemBean.iconPath) && kotlin.jvm.internal.m.a(this.selectedIconPath, itemBean.selectedIconPath) && this.iconId == itemBean.iconId && this.selectedIconId == itemBean.selectedIconId;
        }

        public ItemBean(String id2, boolean z10, String text, String str, String str2, @DrawableRes int i10, @DrawableRes int i11) {
            kotlin.jvm.internal.m.f(id2, "id");
            kotlin.jvm.internal.m.f(text, "text");
            this.id = id2;
            this.isCdn = z10;
            this.text = text;
            this.iconPath = str;
            this.selectedIconPath = str2;
            this.iconId = i10;
            this.selectedIconId = i11;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getIconId() {
            return this.iconId;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getIconPath() {
            return this.iconPath;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final int getSelectedIconId() {
            return this.selectedIconId;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final String getSelectedIconPath() {
            return this.selectedIconPath;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: g, reason: from getter */
        public final boolean getIsCdn() {
            return this.isCdn;
        }

        public int hashCode() {
            int iHashCode = ((((this.id.hashCode() * 31) + androidx.paging.a.a(this.isCdn)) * 31) + this.text.hashCode()) * 31;
            String str = this.iconPath;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.selectedIconPath;
            return ((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.iconId) * 31) + this.selectedIconId;
        }

        public String toString() {
            return "ItemBean(id=" + this.id + ", isCdn=" + this.isCdn + ", text=" + this.text + ", iconPath=" + this.iconPath + ", selectedIconPath=" + this.selectedIconPath + ", iconId=" + this.iconId + ", selectedIconId=" + this.selectedIconId + ")";
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabBarBean)) {
            return false;
        }
        TabBarBean tabBarBean = (TabBarBean) other;
        return this.color == tabBarBean.color && this.selectedColor == tabBarBean.selectedColor && this.backgroundColor == tabBarBean.backgroundColor && kotlin.jvm.internal.m.a(this.borderStyle, tabBarBean.borderStyle) && kotlin.jvm.internal.m.a(this.items, tabBarBean.items);
    }

    public TabBarBean(@ColorInt int i10, @ColorInt int i11, @ColorInt int i12, String borderStyle, ArrayList<ItemBean> items) {
        kotlin.jvm.internal.m.f(borderStyle, "borderStyle");
        kotlin.jvm.internal.m.f(items, "items");
        this.color = i10;
        this.selectedColor = i11;
        this.backgroundColor = i12;
        this.borderStyle = borderStyle;
        this.items = items;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getBorderStyle() {
        return this.borderStyle;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    public final ArrayList<ItemBean> d() {
        return this.items;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getSelectedColor() {
        return this.selectedColor;
    }

    public int hashCode() {
        return (((((((this.color * 31) + this.selectedColor) * 31) + this.backgroundColor) * 31) + this.borderStyle.hashCode()) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "TabBarBean(color=" + this.color + ", selectedColor=" + this.selectedColor + ", backgroundColor=" + this.backgroundColor + ", borderStyle=" + this.borderStyle + ", items=" + this.items + ")";
    }
}
