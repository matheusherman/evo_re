package com.live.evo_mobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001f\u0015B%\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u00020\u00142\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001a\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010!R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/live/evo_mobile/adapter/i;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/live/evo_mobile/adapter/i$b;", "", "", "list", "Landroid/view/LayoutInflater;", "mInflater", "Lcom/live/evo_mobile/adapter/i$a;", "listener", "<init>", "(Ljava/util/List;Landroid/view/LayoutInflater;Lcom/live/evo_mobile/adapter/i$a;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "d", "(Landroid/view/ViewGroup;I)Lcom/live/evo_mobile/adapter/i$b;", "holder", "position", "Lr8/z;", "b", "(Lcom/live/evo_mobile/adapter/i$b;I)V", "getItemCount", "()I", "dataList", "e", "(Ljava/util/List;)V", "", "getItemId", "(I)J", "a", "Lcom/live/evo_mobile/adapter/i$a;", "Ljava/util/List;", "itemList", "c", "Landroid/view/LayoutInflater;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a listener;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<String> itemList;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final LayoutInflater mInflater;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/live/evo_mobile/adapter/i$a;", "", "", "item", "Lr8/z;", "a", "(Ljava/lang/String;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        void a(String item);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/live/evo_mobile/adapter/i$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/live/evo_mobile/adapter/i;Landroid/view/View;)V", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "textView", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final TextView textView;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f7771b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i iVar, View itemView) {
            super(itemView);
            kotlin.jvm.internal.m.f(itemView, "itemView");
            this.f7771b = iVar;
            View viewFindViewById = itemView.findViewById(R$id.search_hisotry_item_tv);
            kotlin.jvm.internal.m.e(viewFindViewById, "findViewById(...)");
            this.textView = (TextView) viewFindViewById;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final TextView getTextView() {
            return this.textView;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    public i(List<String> list, LayoutInflater mInflater, a listener) {
        kotlin.jvm.internal.m.f(list, "list");
        kotlin.jvm.internal.m.f(mInflater, "mInflater");
        kotlin.jvm.internal.m.f(listener, "listener");
        this.listener = listener;
        this.itemList = list;
        this.mInflater = mInflater;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(i iVar, String str, View view) {
        iVar.listener.a(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        kotlin.jvm.internal.m.f(holder, "holder");
        final String str = this.itemList.get(position);
        holder.getTextView().setText(str);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.adapter.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.c(this.f7765a, str, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.m.f(parent, "parent");
        View viewInflate = this.mInflater.inflate(R$layout.item_search_history, parent, false);
        kotlin.jvm.internal.m.c(viewInflate);
        return new b(this, viewInflate);
    }

    public final void e(List<String> dataList) {
        kotlin.jvm.internal.m.f(dataList, "dataList");
        this.itemList = dataList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemList.size();
    }
}
