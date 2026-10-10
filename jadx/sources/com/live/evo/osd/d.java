package com.live.evo.osd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.o1;
import com.live.evo.util.x1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<i5.p> f7063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f7064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LayoutInflater f7065d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e f7069h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f7070i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f7062a = q6.c.d(f.class);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7068g = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f7071j = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SimpleDateFormat f7066e = o1.a(x1.j(R$string.HHmm));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7067f = -1;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class a extends RecyclerView.ViewHolder implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f7072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f7073b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TextView f7074c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final View f7075d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final TextView f7076e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f7077f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ImageView f7078g;

        public a(View view) {
            super(view);
            this.f7072a = (TextView) view.findViewById(R$id.epgitemchild_tv_name);
            this.f7073b = (TextView) view.findViewById(R$id.epgitemchild_tv_time);
            this.f7074c = (TextView) view.findViewById(R$id.epgitemchild_tv_previous_left);
            this.f7076e = (TextView) view.findViewById(R$id.epgitemchild_tv_previous_right);
            this.f7075d = view.findViewById(R$id.epgitemchild_iv_play);
            this.f7078g = (ImageView) view.findViewById(R$id.iv_playback);
            if (com.live.evo.util.e.b().a()) {
                com.live.evo.util.t.b(this.f7073b);
                com.live.evo.util.t.b(this.f7072a);
            } else {
                com.live.evo.util.t.d(this.f7073b);
                com.live.evo.util.t.b(this.f7072a);
            }
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setOnFocusChangeListener(this);
        }

        public void f(boolean z10) {
            if (z10) {
                this.f7078g.setImageDrawable(d.this.f7064c.getResources().getDrawable(R$drawable.menu_playback_focus_icon));
            } else {
                this.f7078g.setImageDrawable(d.this.f7064c.getResources().getDrawable(R$drawable.menu_playback_icon));
            }
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            int i10;
            int i11;
            if (z10) {
                this.itemView.setSelected(true);
                if (getAdapterPosition() == -1) {
                    return;
                }
                d.this.f7068g = getAdapterPosition();
                d dVar = d.this;
                dVar.e(this, dVar.f7068g);
                i10 = R$color.epgitemchild_tv_time_select_tc;
                i11 = R$color.epgitemchild_tv_name_select_tc;
            } else {
                if (this.f7077f) {
                    i10 = R$color.epgitemchild_tv_time_focus_tc;
                    i11 = R$color.epgitemchild_tv_name_focus_tc;
                } else {
                    i10 = R$color.epgitemchild_tv_time_normal_tc;
                    i11 = R$color.epgitemchild_tv_name_normal_tc;
                }
                this.itemView.setSelected(false);
            }
            this.f7076e.setTextColor(x1.e(i10));
            this.f7074c.setTextColor(x1.e(i10));
            this.f7073b.setTextColor(x1.e(i10));
            this.f7072a.setTextColor(x1.e(i11));
            f(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(int i10, View view) {
        if (this.f7071j) {
            return;
        }
        this.f7071j = true;
        e eVar = this.f7069h;
        if (eVar != null) {
            eVar.c(f(i10));
        }
        this.f7071j = false;
    }

    public void e(a aVar, int i10) {
        try {
            this.f7069h.a(aVar.f7073b.getText().toString(), aVar.f7072a.getText().toString(), f(i10).a());
        } catch (Exception e10) {
            this.f7062a.error("focus changed error", e10);
        }
    }

    public i5.p f(int i10) {
        List<i5.p> list;
        if (i10 < 0 || (list = this.f7063b) == null || i10 >= list.size()) {
            return null;
        }
        return this.f7063b.get(i10);
    }

    public int g() {
        return this.f7067f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<i5.p> list = this.f7063b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        List<i5.p> list = this.f7063b;
        return (list == null || i10 >= list.size()) ? super.getItemId(i10) : this.f7063b.get(i10).c().longValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, final int i10) {
        i5.p pVar = this.f7063b.get(i10);
        aVar.f7072a.setText(pVar.e());
        long jLongValue = pVar.f().longValue();
        long jLongValue2 = pVar.g().longValue();
        aVar.f7073b.setText(String.format("%s - %s", this.f7066e.format(new Date(jLongValue)), this.f7066e.format(new Date(jLongValue2))));
        if (this.f7067f == i10) {
            aVar.f7075d.setVisibility(0);
        } else {
            aVar.f7075d.setVisibility(8);
        }
        aVar.f7077f = this.f7067f == i10;
        long j10 = this.f7070i;
        if (jLongValue < j10) {
            aVar.f7074c.setVisibility(0);
            aVar.f7076e.setVisibility(8);
        } else if (jLongValue2 > j10 + TimeUnit.DAYS.toMillis(1L)) {
            aVar.f7076e.setVisibility(0);
            aVar.f7074c.setVisibility(8);
        } else {
            aVar.f7074c.setVisibility(8);
            aVar.f7076e.setVisibility(8);
        }
        e eVar = this.f7069h;
        if (eVar == null || !eVar.b(pVar)) {
            aVar.f7078g.setVisibility(8);
        } else {
            aVar.f7078g.setVisibility(0);
        }
        aVar.f(aVar.itemView.hasFocus());
        aVar.itemView.setClickable(true);
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo.osd.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7060a.h(i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this.f7065d.inflate(R$layout.epg_item_child, viewGroup, false));
    }

    public void k(long j10) {
        this.f7070i = j10;
    }

    public void l(int i10) {
        this.f7067f = i10;
    }

    public d(Context context, List<i5.p> list, e eVar) {
        this.f7063b = list;
        this.f7064c = context;
        this.f7065d = LayoutInflater.from(context);
        setHasStableIds(true);
        this.f7069h = eVar;
    }
}
