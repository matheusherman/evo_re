package com.live.evo.fragment.subjuect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.q1;
import com.live.evo.util.x1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LayoutInflater f6711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f6712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<String> f6713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6715f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView f6716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f6717b;

        /* JADX INFO: renamed from: com.live.evo.fragment.subjuect.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class RunnableC0102a implements Runnable {
            RunnableC0102a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                if (aVar.f6717b < e.this.getItemCount()) {
                    a aVar2 = a.this;
                    aVar2.f6716a.scrollToPosition(aVar2.f6717b);
                }
            }
        }

        a(RecyclerView recyclerView, int i10) {
            this.f6716a = recyclerView;
            this.f6717b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.notifyDataSetChanged();
            this.f6716a.post(new RunnableC0102a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6720a;

        b(int i10) {
            this.f6720a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = e.this.f6714e;
            if (i10 < e.this.getItemCount()) {
                int i11 = this.f6720a;
                if (i11 != i10) {
                    e.this.notifyItemChanged(i11);
                }
                e.this.notifyItemChanged(i10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f6722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LinearLayout f6723b;

        c(e eVar, View view) {
            super(view);
            this.f6722a = (TextView) view.findViewById(R$id.subject_date_tv);
            this.f6723b = (LinearLayout) view.findViewById(R$id.subject_date_layout);
        }
    }

    public void b(RecyclerView recyclerView, List<String> list, int i10, List<String> list2) {
        this.f6712c.clear();
        this.f6713d.clear();
        this.f6713d.addAll(list2);
        if (list != null && list.size() > 0) {
            this.f6712c.addAll(list);
        }
        if (i10 < getItemCount()) {
            this.f6714e = i10;
        }
        recyclerView.post(new a(recyclerView, i10));
    }

    public void c(RecyclerView recyclerView, int i10, boolean z10) {
        if (i10 < 0 || i10 >= getItemCount()) {
            return;
        }
        int i11 = this.f6714e;
        this.f6714e = i10;
        this.f6715f = z10;
        recyclerView.scrollToPosition(i10);
        recyclerView.post(new b(i11));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f6712c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i10) {
        c cVar = (c) viewHolder;
        String strA = q1.a(this.f6712c.get(i10));
        if (this.f6712c.get(i10).equals(q1.k())) {
            strA = x1.j(R$string.today);
        }
        cVar.f6722a.setText(strA);
        if (this.f6715f && this.f6714e == i10) {
            cVar.f6722a.setTextSize(2, 20.0f);
            cVar.f6723b.setBackgroundResource(R$color.color_focused);
        } else {
            cVar.f6722a.setTextSize(2, 16.0f);
            cVar.f6723b.setBackground(null);
        }
        if (this.f6713d.size() <= 0) {
            cVar.f6722a.setTextColor(x1.e(R$color.subject_date_unenble));
            cVar.f6722a.setBackgroundResource(2131102158);
            return;
        }
        if (!this.f6713d.contains(this.f6712c.get(i10))) {
            cVar.f6722a.setTextColor(x1.e(R$color.subject_date_unenble));
            cVar.f6722a.setBackgroundResource(2131102158);
            return;
        }
        int i11 = this.f6714e;
        if (i11 == i10 && this.f6715f) {
            cVar.f6722a.setTextColor(x1.e(R$color.subject_datetext_list_select));
            cVar.f6722a.setBackgroundResource(2131102158);
        } else if (i11 == i10) {
            cVar.f6722a.setTextColor(x1.e(R$color.color_focused));
            cVar.f6722a.setBackgroundResource(R$drawable.subject_date_bg_focus);
        } else {
            cVar.f6722a.setTextColor(x1.e(R$color.subject_datetext_list));
            cVar.f6722a.setBackgroundResource(2131102158);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new c(this, LayoutInflater.from(this.f6710a).inflate(R$layout.subject_matchdate_item, viewGroup, false));
    }

    public e(Context context, List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        this.f6712c = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f6713d = arrayList2;
        this.f6714e = 0;
        this.f6710a = context;
        arrayList2.clear();
        arrayList2.addAll(list2);
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        this.f6711b = LayoutInflater.from(this.f6710a);
    }
}
