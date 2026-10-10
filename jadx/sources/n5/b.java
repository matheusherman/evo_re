package n5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.q1;
import com.live.evo.util.t;
import com.live.evo.util.x1;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15962b = 7;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15963c = 7;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15964d = 14;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15965e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RelativeLayout f15966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f15967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextView f15968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TextView f15969d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final View f15970e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f15971f;

        public void f(boolean z10) {
            this.f15971f = z10;
        }

        a(b bVar, View view) {
            this.f15968c = (TextView) view.findViewById(R$id.tv_week);
            TextView textView = (TextView) view.findViewById(R$id.tv_date);
            this.f15969d = textView;
            this.f15970e = view.findViewById(R$id.ll_parent);
            this.f15967b = view.findViewById(R$id.iv_arrow);
            this.f15966a = (RelativeLayout) view.findViewById(R$id.rl_cir);
            if (com.live.evo.util.e.b().a()) {
                t.b(textView);
                t.b(this.f15968c);
            } else {
                t.d(textView);
                t.b(this.f15968c);
            }
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f15961a).inflate(R$layout.epg_date_item, viewGroup, false);
            aVar = new a(this, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Calendar calendarC = q1.c(q1.h(), i10 - this.f15963c);
        if (i10 == this.f15965e) {
            aVar.f15970e.setEnabled(false);
            aVar.f(true);
            aVar.f15970e.setBackgroundResource(R$drawable.list_focus_bg);
        } else {
            if (this.f15962b == i10) {
                aVar.f15970e.setEnabled(true);
            } else {
                aVar.f15970e.setEnabled(false);
            }
            aVar.f(false);
            aVar.f15970e.setBackgroundResource(R$drawable.icon_transport);
        }
        if (i10 == this.f15962b) {
            aVar.f15966a.setEnabled(true);
            int iE = i10 == this.f15965e ? x1.e(2131099809) : x1.e(R$color.color_focused);
            aVar.f15969d.setTextColor(iE);
            aVar.f15968c.setTextColor(iE);
            aVar.f15967b.setVisibility(0);
        } else {
            aVar.f15966a.setEnabled(false);
            int iE2 = x1.e(R$color.color_eeeeee);
            aVar.f15969d.setTextColor(iE2);
            aVar.f15968c.setTextColor(iE2);
            aVar.f15967b.setVisibility(8);
        }
        aVar.f15968c.setText(q1.o(calendarC.get(7)));
        if (i10 == this.f15963c && com.live.evo.util.e.b().g()) {
            aVar.f15969d.setText(x1.j(R$string.today));
            return view;
        }
        aVar.f15969d.setText(String.valueOf(calendarC.get(5)));
        return view;
    }

    public int a() {
        return this.f15964d;
    }

    public int b() {
        return this.f15962b;
    }

    public int c() {
        return this.f15963c;
    }

    public void d(int i10, boolean z10) {
        this.f15962b = i10;
        if (z10) {
            this.f15965e = i10;
        }
        notifyDataSetChanged();
    }

    public void e(int i10) {
        this.f15964d = i10;
        if (i10 >= 7) {
            this.f15963c = i10 - 7;
        } else {
            this.f15963c = 0;
        }
        notifyDataSetChanged();
    }

    public void f(int i10) {
        this.f15965e = i10;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f15964d;
    }

    public b(Context context) {
        this.f15961a = context;
    }
}
