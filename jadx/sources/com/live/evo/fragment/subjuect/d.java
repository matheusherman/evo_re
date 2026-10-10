package com.live.evo.fragment.subjuect;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.util.x1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LayoutInflater f6697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<j5.b> f6698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6700e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f6701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f6702b;

        a(List list, int i10) {
            this.f6701a = list;
            this.f6702b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f6698c.clear();
            List list = this.f6701a;
            if (list != null && list.size() > 0) {
                d.this.f6698c.addAll(this.f6701a);
            }
            d.this.f6699d = this.f6702b;
            d.this.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C0101d f6704a;

        b(d dVar, C0101d c0101d) {
            this.f6704a = c0101d;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (z10) {
                this.f6704a.f6706a.setBackgroundResource(2131102158);
                this.f6704a.f6706a.setTextColor(x1.e(2131099809));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: com.live.evo.fragment.subjuect.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class C0101d extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f6706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ImageView f6707b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private LinearLayout f6708c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private LinearLayout f6709d;

        C0101d(d dVar, View view) {
            super(view);
            this.f6706a = (TextView) view.findViewById(R$id.subject_classification_tv);
            this.f6708c = (LinearLayout) view.findViewById(R$id.subject_classification_layout);
            this.f6709d = (LinearLayout) view.findViewById(R$id.subject_classification_layout2);
            this.f6707b = (ImageView) view.findViewById(R$id.subject_classification_iv);
        }
    }

    public void c(RecyclerView recyclerView, List<j5.b> list, int i10) {
        recyclerView.post(new a(list, i10));
    }

    public void d(RecyclerView recyclerView, int i10, boolean z10) {
        if (i10 != this.f6699d) {
            recyclerView.scrollToPosition(i10);
        }
        this.f6699d = i10;
        this.f6700e = z10;
        recyclerView.post(new c());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f6698c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        C0101d c0101d = (C0101d) viewHolder;
        c0101d.f6706a.setText(this.f6698c.get(i10).a());
        c0101d.f6708c.setEnabled(this.f6699d == i10);
        c0101d.f6708c.setSelected(this.f6700e && this.f6699d == i10);
        c0101d.f6709d.setEnabled(this.f6699d == i10);
        c0101d.f6709d.setSelected(this.f6700e && this.f6699d == i10);
        c0101d.f6706a.setEnabled(this.f6699d == i10);
        c0101d.f6706a.setSelected(this.f6700e && this.f6699d == i10);
        c0101d.f6706a.setBackgroundResource(2131102158);
        if (this.f6699d == i10) {
            c0101d.f6706a.setTextSize(2, 22.0f);
            if (this.f6700e) {
                c0101d.f6706a.setTextColor(x1.e(2131099809));
            } else {
                c0101d.f6706a.setTextColor(x1.e(R$color.color_focused));
                c0101d.f6706a.setBackgroundResource(R$drawable.subject_date_bg_focus);
            }
        } else {
            c0101d.f6706a.setTextSize(2, 18.0f);
            c0101d.f6706a.setTextColor(x1.e(R$color.subject_classificationtext_list));
        }
        if (TextUtils.isEmpty(this.f6698c.get(i10).c())) {
            c0101d.f6707b.setVisibility(8);
        } else {
            c0101d.f6707b.setVisibility(0);
            com.live.evo.util.v.c(this.f6696a, this.f6698c.get(i10).c(), 2131102158, c0101d.f6707b);
        }
        c0101d.itemView.setOnFocusChangeListener(new b(this, c0101d));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new C0101d(this, LayoutInflater.from(this.f6696a).inflate(R$layout.subject_matchclassification_item, viewGroup, false));
    }

    public d(Context context, List<j5.b> list) {
        ArrayList arrayList = new ArrayList();
        this.f6698c = arrayList;
        this.f6699d = 0;
        this.f6696a = context;
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        this.f6697b = LayoutInflater.from(this.f6696a);
    }
}
