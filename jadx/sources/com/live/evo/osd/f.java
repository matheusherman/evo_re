package com.live.evo.osd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.o1;
import com.live.evo.util.q1;
import com.live.evo.util.x1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f7081b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f7083d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f7080a = q6.c.d(f.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, List<i5.p>> f7082c = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7084e = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7086g = 14;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7087h = 14 / 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f7088i = 14;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f7089j = TimeUnit.DAYS.toMillis(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SimpleDateFormat f7085f = o1.a(x1.j(R$string.ddMMyyyy));

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VerticalGridView f7090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f7091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f7092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TextView f7093d;

        /* JADX INFO: renamed from: com.live.evo.osd.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class ViewOnFocusChangeListenerC0107a implements View.OnFocusChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ f f7095a;

            ViewOnFocusChangeListenerC0107a(f fVar) {
                this.f7095a = fVar;
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z10) {
                if (f.this.f7083d != null) {
                    f.this.f7083d.d(z10);
                }
            }
        }

        a(View view) {
            super(view);
            this.f7092c = (TextView) view.findViewById(R$id.epgdlgparent_tv_week);
            this.f7091b = (TextView) view.findViewById(R$id.epgdlgparent_tv_date);
            this.f7090a = (VerticalGridView) view.findViewById(R$id.epgdlgparent_gv_epg);
            this.f7093d = (TextView) view.findViewById(R$id.epgdlgparent_tv_not_data);
            if (com.live.evo.util.e.b().a()) {
                com.live.evo.util.t.c(this.f7092c);
                com.live.evo.util.t.b(this.f7091b);
                com.live.evo.util.t.b(this.f7093d);
            } else {
                com.live.evo.util.t.a(this.f7092c);
                com.live.evo.util.t.d(this.f7091b);
                com.live.evo.util.t.b(this.f7093d);
            }
            this.f7090a.setNumColumns(1);
            this.f7090a.setWindowAlignment(1);
            this.f7093d.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0107a(f.this));
        }
    }

    private void b(List<i5.p> list) {
        this.f7082c.clear();
        if (list == null) {
            this.f7080a.warn("epg data set to null", new Object[0]);
            return;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            i5.p pVar = list.get(i10);
            String str = this.f7085f.format(new Date(pVar.f().longValue()));
            List<i5.p> arrayList = this.f7082c.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f7082c.put(str, arrayList);
            }
            arrayList.add(pVar);
            String str2 = this.f7085f.format(new Date(pVar.g().longValue()));
            if (!str.equals(str2) && q1.n(str2) != pVar.g().longValue()) {
                List<i5.p> arrayList2 = this.f7082c.get(str2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.f7082c.put(str2, arrayList2);
                }
                arrayList2.add(pVar);
            }
        }
        if (this.f7082c.size() <= 0 || this.f7082c.size() > 14) {
            this.f7086g = 14;
            return;
        }
        int size = this.f7082c.size();
        this.f7086g = size;
        this.f7087h = size / 2;
    }

    public int c() {
        return this.f7087h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        this.f7080a.debug("big_epg_item_count[{}]", Integer.valueOf(this.f7086g));
        return this.f7086g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        a aVar = (a) viewHolder;
        aVar.itemView.setTag((i10 + 1) + "");
        long jB = q1.b();
        String str = this.f7085f.format(new Date(jB));
        long j10 = jB + (((long) (i10 - this.f7087h)) * this.f7089j);
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(j10);
        calendar.setTime(date);
        String str2 = this.f7085f.format(date);
        List<i5.p> arrayList = this.f7082c.get(str2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        aVar.f7092c.setText(q1.o(calendar.get(7)));
        if (str2.equals(str)) {
            aVar.f7091b.setText(this.f7081b.getString(R$string.today));
        } else {
            aVar.f7091b.setText(str2);
        }
        if (arrayList.size() == 0) {
            aVar.f7090a.setVisibility(8);
            aVar.f7093d.setVisibility(0);
        } else {
            aVar.f7090a.setVisibility(0);
            aVar.f7093d.setVisibility(8);
        }
        int i11 = i10 == 0 ? R$color.epgdlgparent_tv_date_focus_tc : R$color.epgdlgparent_tv_date_normal_tc;
        aVar.f7092c.setTextColor(x1.e(i11));
        aVar.f7091b.setTextColor(x1.e(i11));
        d dVar = new d(this.f7081b, arrayList, this.f7083d);
        long jI = q1.i(j10);
        dVar.k(jI);
        if (!arrayList.isEmpty()) {
            this.f7080a.debug("zero_time[{}][{}][{}][{}]", Integer.valueOf(i10), Long.valueOf(jI), arrayList.get(0).f(), arrayList.get(arrayList.size() - 1).g());
        }
        if (str.equals(str2) && !arrayList.isEmpty()) {
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                i5.p pVar = arrayList.get(i12);
                if (j10 >= pVar.f().longValue() && j10 < pVar.g().longValue()) {
                    this.f7084e = i12;
                    dVar.l(i12);
                    break;
                }
            }
        }
        aVar.f7090a.setAdapter(dVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(this.f7081b).inflate(R$layout.epg_dialog_parent, viewGroup, false));
    }

    public f(Context context, e eVar, RecyclerView recyclerView) {
        this.f7081b = context;
        this.f7083d = eVar;
    }

    public void d(List<i5.p> list) {
        b(list);
    }
}
