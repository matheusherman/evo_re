package n5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.q1;
import i5.v;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<v> f16014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f16015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutInflater f16016c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ImageView f16017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        LinearLayout f16018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TextView f16019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TextView f16020d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        TextView f16021e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ImageView f16022f;

        /* synthetic */ a(j jVar, k kVar) {
            this(jVar);
        }

        private a(j jVar) {
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    public void a(List<v> list) {
        List<v> list2 = this.f16014a;
        if (list2 != null) {
            list2.clear();
            this.f16014a.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<v> list = this.f16014a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        List<v> list = this.f16014a;
        if (list == null) {
            return null;
        }
        return list.get(i10);
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewInflate;
        a aVar;
        if (view == null) {
            aVar = new a(this, null);
            viewInflate = this.f16016c.inflate(R$layout.message_list_item, (ViewGroup) null);
            aVar.f16017a = (ImageView) viewInflate.findViewById(R$id.iv_nocheck);
            aVar.f16018b = (LinearLayout) viewInflate.findViewById(R$id.lly_message);
            aVar.f16019c = (TextView) viewInflate.findViewById(R$id.message_title);
            aVar.f16020d = (TextView) viewInflate.findViewById(R$id.message_content);
            aVar.f16021e = (TextView) viewInflate.findViewById(R$id.message_time);
            aVar.f16022f = (ImageView) viewInflate.findViewById(R$id.iv_delete);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (a) view.getTag();
        }
        v vVar = this.f16014a.get(i10);
        if (vVar.f() == 0) {
            aVar.f16017a.setVisibility(0);
            aVar.f16019c.setEnabled(true);
        } else {
            aVar.f16019c.setEnabled(false);
            aVar.f16017a.setVisibility(4);
        }
        aVar.f16022f.setVisibility(vVar.i() ? 0 : 8);
        aVar.f16019c.setText(vVar.g());
        aVar.f16020d.setText(vVar.d());
        String strM = q1.m(vVar.n(), this.f16015b.getString(R$string.ddMMyyyy));
        String strM2 = q1.m(vVar.n(), this.f16015b.getString(R$string.HHmm));
        aVar.f16021e.setText(strM2 + "  " + strM);
        return viewInflate;
    }

    public j(Context context, List<v> list) {
        ArrayList arrayList = new ArrayList();
        this.f16014a = arrayList;
        this.f16015b = context;
        arrayList.addAll(list);
        this.f16016c = LayoutInflater.from(this.f16015b);
    }
}
