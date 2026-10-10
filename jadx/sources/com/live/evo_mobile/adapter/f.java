package com.live.evo_mobile.adapter;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.util.t;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import u7.HistoryLiveListData;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u0016\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001aJ\u000f\u0010\u001f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u0019¨\u0006+"}, d2 = {"Lcom/live/evo_mobile/adapter/f;", "Lr7/c;", "Lu7/e;", "<init>", "()V", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "", "isSelected", "Lr8/z;", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/String;Z)V", "Lj0/b;", "holder", "", "position", "item", ExifInterface.GPS_DIRECTION_TRUE, "(Lj0/b;ILu7/e;)V", "", "", "payloads", "U", "(Lj0/b;ILu7/e;Ljava/util/List;)V", "edit", "Z", "(Z)V", "X", "()Z", IjkMediaMeta.IJKM_KEY_SELECTED, "a0", "G", "()I", "Lcom/live/evo_mobile/adapter/f$a;", "callback", "Y", "(Lcom/live/evo_mobile/adapter/f$a;)V", "p", "Lcom/live/evo_mobile/adapter/f$a;", "statusCallback", "q", "editStatus", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f extends r7.c<HistoryLiveListData> {

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private a statusCallback;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean editStatus;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/live/evo_mobile/adapter/f$a;", "", "", "isSelected", "Lr8/z;", "a", "(Z)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        void a(boolean isSelected);
    }

    @Override // r7.a
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public void E(j0.b holder, int position, final HistoryLiveListData item) {
        kotlin.jvm.internal.m.f(holder, "holder");
        kotlin.jvm.internal.m.f(item, "item");
        holder.d(R$id.iv_status, item.getSelected()).c(R$id.iv_status, !this.editStatus);
        r7.a.K(this, holder, R$id.img, item.getIconUrl(), 0, 4, null).e(R$id.tv_content, item.getName());
        holder.itemView.setOnTouchListener(new View.OnTouchListener() { // from class: com.live.evo_mobile.adapter.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return f.V(this.f7761a, item, view, motionEvent);
            }
        });
        t.b((TextView) holder.a(R$id.tv_content));
    }

    @Override // r7.a
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public void F(j0.b holder, int position, HistoryLiveListData item, List<? extends Object> payloads) {
        kotlin.jvm.internal.m.f(holder, "holder");
        kotlin.jvm.internal.m.f(item, "item");
        kotlin.jvm.internal.m.f(payloads, "payloads");
        holder.c(R$id.iv_status, !this.editStatus);
    }

    /* JADX INFO: renamed from: X, reason: from getter */
    public final boolean getEditStatus() {
        return this.editStatus;
    }

    public final void Y(a callback) {
        kotlin.jvm.internal.m.f(callback, "callback");
        this.statusCallback = callback;
    }

    public final void Z(boolean edit) {
        this.editStatus = edit;
        Iterator it = m().iterator();
        while (it.hasNext()) {
            ((HistoryLiveListData) it.next()).a(false);
        }
        notifyItemRangeChanged(0, m().size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean V(f fVar, HistoryLiveListData historyLiveListData, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            fVar.W(historyLiveListData.getId(), historyLiveListData.getSelected());
            return false;
        }
        return false;
    }

    private final void W(String id2, boolean isSelected) {
        int i10;
        if (m() != null && !m().isEmpty()) {
            int i11 = 0;
            for (T t10 : m()) {
                if (t10.getSelected() && !kotlin.jvm.internal.m.a(t10.getId(), id2)) {
                    i11++;
                }
            }
            if (isSelected) {
                i10 = i11 - 1;
            } else {
                i10 = i11 + 1;
            }
            if (this.statusCallback != null) {
                if (i10 == m().size()) {
                    a aVar = this.statusCallback;
                    kotlin.jvm.internal.m.c(aVar);
                    aVar.a(true);
                } else {
                    a aVar2 = this.statusCallback;
                    kotlin.jvm.internal.m.c(aVar2);
                    aVar2.a(false);
                }
            }
        }
    }

    @Override // r7.a
    public int G() {
        return R$layout.item_live_history;
    }

    public final void a0(boolean selected) {
        Iterator it = m().iterator();
        while (it.hasNext()) {
            ((HistoryLiveListData) it.next()).a(selected);
        }
        notifyItemRangeChanged(0, m().size());
    }
}
