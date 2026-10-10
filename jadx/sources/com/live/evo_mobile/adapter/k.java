package com.live.evo_mobile.adapter;

import android.widget.CompoundButton;
import android.widget.Switch;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import kotlin.Metadata;
import u7.MainSettingData;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/live/evo_mobile/adapter/k;", "Lr7/a;", "Lu7/g;", "<init>", "()V", "Lj0/b;", "holder", "", "position", "item", "Lr8/z;", "P", "(Lj0/b;ILu7/g;)V", "Lcom/live/evo_mobile/adapter/k$a;", "listener", "R", "(Lcom/live/evo_mobile/adapter/k$a;)V", "G", "()I", "n", "Lcom/live/evo_mobile/adapter/k$a;", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k extends r7.a<MainSettingData> {

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private a listener;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/live/evo_mobile/adapter/k$a;", "", "", "checked", "Landroid/widget/Switch;", "switch", "Lr8/z;", "a", "(ZLandroid/widget/Switch;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        void a(boolean checked, Switch r10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(k kVar, Switch r10, CompoundButton compoundButton, boolean z10) {
        a aVar = kVar.listener;
        if (aVar != null) {
            aVar.a(z10, r10);
        }
    }

    @Override // r7.a
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void E(j0.b holder, int position, MainSettingData item) {
        kotlin.jvm.internal.m.f(holder, "holder");
        kotlin.jvm.internal.m.f(item, "item");
        r7.a.J(this, holder, R$id.iv_icon, item.getIcon(), 0, 4, null).e(R$id.tv_content, item.getContent()).c(R$id.iv_right, item.getSelected() != null).c(R$id.s_witch, item.getSelected() == null);
        final Switch r10 = (Switch) holder.a(R$id.s_witch);
        if (r10.getVisibility() != 0 || item.getSelected() == null) {
            r10.setOnCheckedChangeListener(null);
        } else {
            r10.setChecked(t.v.c.i.a.f18646a.e0());
            r10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.live.evo_mobile.adapter.j
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    k.Q(this.f7772a, r10, compoundButton, z10);
                }
            });
        }
    }

    public final void R(a listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        this.listener = listener;
    }

    @Override // r7.a
    public int G() {
        return R$layout.item_main_me_setting;
    }
}
