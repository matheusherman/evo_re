package n5;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.q1;
import com.live.evo.util.t;
import com.live.evo.util.v;
import com.live.evo.util.x1;
import i5.c0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class q extends BaseAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<c0> f16054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f16055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LayoutInflater f16056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<c0> f16058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private n5.a.e<c0> f16059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private n5.a.f f16060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private n5.a.g f16061i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f16053a = q6.c.d(q.class);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ObjectAnimator f16062j = null;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f16063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f16064b;

        a(d dVar, int i10) {
            this.f16063a = dVar;
            this.f16064b = i10;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            int i10;
            int i11;
            this.f16063a.f16074e.setEnabled(z10);
            if (z10) {
                if (q.this.f16061i != null) {
                    q.this.f16061i.a(view, this.f16064b);
                }
                i10 = R$color.item_selected_color;
                i11 = R$color.item_selected_color;
            } else {
                i10 = R$color.item_normal_color;
                i11 = R$color.epg_text_color;
            }
            this.f16063a.f16070a.setTextColor(x1.e(i10));
            this.f16063a.f16071b.setTextColor(x1.e(i11));
            this.f16063a.f16073d.setTextColor(x1.e(i10));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements View.OnKeyListener {
        b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            q.this.f16060h.v(view, i10, keyEvent);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f16067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c0 f16068b;

        c(int i10, c0 c0Var) {
            this.f16067a = i10;
            this.f16068b = c0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q.this.f16059g.a(this.f16067a, this.f16068b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class d extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f16070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TextView f16071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ImageView f16072c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private TextView f16073d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private TextView f16074e;

        public d(q qVar, View view) {
            super(view);
            this.f16070a = (TextView) view.findViewById(R$id.subscribelistitem_tv_date);
            this.f16071b = (TextView) view.findViewById(R$id.subscribelistitem_tv_program);
            this.f16072c = (ImageView) view.findViewById(R$id.subscribelistitem_iv_channel_icon);
            this.f16073d = (TextView) view.findViewById(R$id.subscribelistitem_tv_channel);
            TextView textView = (TextView) view.findViewById(R$id.subscribelistitem_tv_set);
            this.f16074e = textView;
            textView.setEnabled(false);
            if (com.live.evo.util.e.b().a()) {
                t.b(this.f16070a);
                t.b(this.f16071b);
                t.b(this.f16073d);
                t.b(this.f16074e);
                return;
            }
            t.a(this.f16070a);
            t.b(this.f16071b);
            t.b(this.f16073d);
            t.d(this.f16074e);
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        d dVar;
        if (view == null) {
            view = this.f16056d.inflate(R$layout.subscribe_list_item, (ViewGroup) null);
            view.setEnabled(false);
            dVar = new d(this, view);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        c0 c0Var = this.f16058f.get(i10);
        long jLongValue = c0Var.h().longValue();
        long jLongValue2 = c0Var.j().longValue();
        dVar.f16070a.setText(String.format("%s - %s", q1.m(jLongValue, x1.j(R$string.HHmm)), q1.m(jLongValue2, x1.j(R$string.HHmm))));
        dVar.f16071b.setText(c0Var.g());
        dVar.f16073d.setText(c0Var.b());
        if (c0Var.i() == 0) {
            dVar.f16074e.setText(x1.j(2131951835));
        } else {
            dVar.f16074e.setText(x1.j(R$string.resubscribe));
        }
        String strE = c0Var.e();
        if (!TextUtils.isEmpty(strE)) {
            dVar.f16072c.setVisibility(0);
            v.d(this.f16055c, strE, dVar.f16072c);
        }
        dVar.itemView.setFocusable(true);
        dVar.itemView.setOnFocusChangeListener(new a(dVar, i10));
        dVar.itemView.setOnKeyListener(new b());
        dVar.itemView.setOnClickListener(new c(i10, c0Var));
        return view;
    }

    public void d(List<c0> list, int i10) {
        List<c0> list2 = this.f16058f;
        if (list2 != null) {
            this.f16057e = i10;
            list2.clear();
            if (list != null && list.size() > 0) {
                this.f16058f.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f16058f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f16058f.get(i10);
    }

    public q(Context context, List<c0> list) {
        ArrayList arrayList = new ArrayList();
        this.f16058f = arrayList;
        this.f16055c = context;
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        this.f16054b = list;
        this.f16056d = LayoutInflater.from(this.f16055c);
    }
}
