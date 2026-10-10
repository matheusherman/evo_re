package com.live.evo_mobile.adapter;

import androidx.exifinterface.media.ExifInterface;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import kotlin.Metadata;
import u7.EpgDateData;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/live/evo_mobile/adapter/b;", "Lr7/e;", "Lu7/d;", "<init>", "()V", "Lj0/b;", "holder", "", "position", "item", "Lr8/z;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lj0/b;ILu7/d;)V", "G", "()I", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b extends r7.e<EpgDateData> {
    @Override // r7.a
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public void E(j0.b holder, int position, EpgDateData item) {
        kotlin.jvm.internal.m.f(holder, "holder");
        kotlin.jvm.internal.m.f(item, "item");
        holder.e(R$id.tv_name, item.getDate()).d(R$id.cl_root, item.getSelected()).c(R$id.v_line, !item.getSelected()).d(R$id.tv_name, item.getSelected());
    }

    @Override // r7.a
    public int G() {
        return R$layout.item_channel_list_left;
    }
}
