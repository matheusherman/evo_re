package com.live.evo_mobile.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.exifinterface.media.ExifInterface;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.util.t;
import kotlin.Metadata;
import t.v.c.widget.ImageView;
import u7.StoryListData;
import z1.b1.lb.m.meta.ChannelStreamResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/live/evo_mobile/adapter/n;", "Lr7/e;", "Lu7/i;", "<init>", "()V", "Lj0/b;", "holder", "", "position", "item", "Lr8/z;", ExifInterface.LONGITUDE_WEST, "(Lj0/b;ILu7/i;)V", "Lcom/live/evo_mobile/adapter/n$a;", "listener", "Y", "(Lcom/live/evo_mobile/adapter/n$a;)V", "G", "()I", "r", "Lcom/live/evo_mobile/adapter/n$a;", "clickListener", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class n extends r7.e<StoryListData> {

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private a clickListener;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/live/evo_mobile/adapter/n$a;", "", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "response", "", "position", "Lr8/z;", "a", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;I)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        void a(ChannelStreamResponse response, int position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(n nVar, ChannelStreamResponse channelStreamResponse, int i10, View view) {
        a aVar = nVar.clickListener;
        if (aVar == null || aVar == null) {
            return;
        }
        aVar.a(channelStreamResponse, i10);
    }

    @Override // r7.a
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public void E(j0.b holder, final int position, StoryListData item) {
        kotlin.jvm.internal.m.f(holder, "holder");
        kotlin.jvm.internal.m.f(item, "item");
        final ChannelStreamResponse response = item.getResponse();
        String iconUrl = response.getIconUrl();
        kotlin.jvm.internal.m.e(iconUrl, "getIconUrl(...)");
        r7.a.K(this, holder, R$id.iv_img, iconUrl, 0, 4, null).e(R$id.tv_title, item.getVideoTitle()).d(R$id.cl_root, item.getSelected()).e(R$id.tv_content, item.getEpgContent());
        ((ImageView) holder.a(R$id.view_show_epg)).setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.adapter.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.X(this.f7780a, response, position, view);
            }
        });
        if (response.isCatchup()) {
            ((ImageView) holder.a(R$id.view_show_epg)).setImageResource(R$drawable.tv_menu_playback_icon);
            ((AppCompatImageView) holder.a(R$id.iv_next)).setVisibility(8);
        } else {
            ((ImageView) holder.a(R$id.view_show_epg)).setImageDrawable(null);
            ((AppCompatImageView) holder.a(R$id.iv_next)).setVisibility(0);
        }
        t.b((TextView) holder.a(R$id.tv_title));
        t.b((TextView) holder.a(R$id.tv_content));
    }

    public final void Y(a listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        this.clickListener = listener;
    }

    @Override // r7.a
    public int G() {
        return R$layout.item_channel_list_story;
    }
}
