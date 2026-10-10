package com.live.evo_mobile.adapter;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import kotlin.Metadata;
import t.v.c.widget.MyRelativelayout;
import z1.b1.lb.m.meta.ChannelStreamResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/live/evo_mobile/adapter/p;", "Lr7/e;", "Lu7/j;", "<init>", "()V", "Lj0/b;", "holder", "", "position", "item", "Lr8/z;", ExifInterface.LONGITUDE_WEST, "(Lj0/b;ILu7/j;)V", "Lcom/live/evo_mobile/adapter/p$a;", "listener", "Y", "(Lcom/live/evo_mobile/adapter/p$a;)V", "G", "()I", "r", "Lcom/live/evo_mobile/adapter/p$a;", "getItemClickListener", "()Lcom/live/evo_mobile/adapter/p$a;", "setItemClickListener", "itemClickListener", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p extends r7.e<u7.j> {

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private a itemClickListener;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/live/evo_mobile/adapter/p$a;", "", "Lu7/j;", "item", "", "position", "Lr8/z;", "a", "(Lu7/j;I)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        void a(u7.j item, int position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(p pVar, u7.j jVar, int i10, View view) {
        a aVar = pVar.itemClickListener;
        if (aVar != null) {
            aVar.a(jVar, i10);
        }
    }

    @Override // r7.a
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public void E(j0.b holder, final int position, final u7.j item) {
        kotlin.jvm.internal.m.f(holder, "holder");
        kotlin.jvm.internal.m.f(item, "item");
        ChannelStreamResponse channelStreamResponseJ = t.v.c.i.a.f18646a.j(item.getData().c());
        String strH = x1.f1.lb.util.n.n().h(1, item.getData().e());
        String strH2 = x1.f1.lb.util.n.n().h(1, item.getData().d().getStop());
        if (channelStreamResponseJ != null) {
            String iconUrl = channelStreamResponseJ.getIconUrl();
            kotlin.jvm.internal.m.e(iconUrl, "getIconUrl(...)");
            I(holder, R$id.iv_img, iconUrl, R$drawable.menu_tv_icon);
        }
        String streamName = channelStreamResponseJ != null ? channelStreamResponseJ.getStreamName() : null;
        holder.e(R$id.tv_epg_title, streamName).d(R$id.cl_epg_root, item.getTv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_SELECTED java.lang.String()).e(R$id.tv_epg_content, strH + " - " + strH2 + ": " + item.getData().d().getTitle());
        holder.e(R$id.tv_playback, j().getString(2131953077));
        MyRelativelayout myRelativelayout = (MyRelativelayout) holder.a(R$id.rl_playback_btn);
        myRelativelayout.setVisibility(0);
        myRelativelayout.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.adapter.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.X(this.f7784a, item, position, view);
            }
        });
    }

    public final void Y(a listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        this.itemClickListener = listener;
    }

    @Override // r7.a
    public int G() {
        return R$layout.item_subscribe_list;
    }
}
