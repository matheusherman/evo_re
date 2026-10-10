package com.live.evo.osd;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.util.s0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LayoutInflater f7120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f7121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, i5.i> f7122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7123e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7124f;

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewInflate;
        a aVar;
        if (view == null) {
            aVar = new a(this);
            viewInflate = this.f7120b.inflate(R$layout.program_classify_item, viewGroup, false);
            aVar.f7125a = (ImageView) viewInflate.findViewById(R$id.programclassifyitem_iv_img);
            aVar.f7126b = (TextView) viewInflate.findViewById(R$id.programclassifyitem_tv_name);
            aVar.f7127c = (ImageView) viewInflate.findViewById(R$id.programclassifynew_iv_img);
            if (com.live.evo.util.e.b().a()) {
                com.live.evo.util.t.b(aVar.f7126b);
            }
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (a) view.getTag();
        }
        ((View) aVar.f7126b.getParent()).setEnabled(!this.f7124f && this.f7123e == i10);
        i5.i iVar = this.f7122d.get(this.f7121c.get(i10));
        String str = Configurator.NULL;
        String strH = iVar == null ? Configurator.NULL : iVar.h();
        if (strH != null) {
            str = strH;
        }
        aVar.f7126b.setText(str);
        if (iVar != null) {
            String strB = iVar.b();
            String strD = iVar.d();
            if (TextUtils.isEmpty(strD) && TextUtils.isEmpty(strB)) {
                aVar.f7126b.setVisibility(0);
                aVar.f7125a.setVisibility(8);
            } else {
                aVar.f7126b.setVisibility(8);
                aVar.f7125a.setVisibility(0);
                if (TextUtils.isEmpty(strD)) {
                    com.live.evo.util.v.c(this.f7119a, strB, 2131102158, aVar.f7125a);
                } else if (TextUtils.isEmpty(strB) || this.f7123e != i10) {
                    com.live.evo.util.v.c(this.f7119a, strD, 2131102158, aVar.f7125a);
                } else {
                    com.live.evo.util.v.c(this.f7119a, strB, 2131102158, aVar.f7125a);
                }
            }
        } else {
            aVar.f7126b.setVisibility(0);
            aVar.f7125a.setVisibility(8);
        }
        if (iVar == null) {
            aVar.f7127c.setVisibility(8);
            return viewInflate;
        }
        iVar.j();
        aVar.f7127c.setVisibility(8);
        return viewInflate;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ImageView f7125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        TextView f7126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ImageView f7127c;

        a(m mVar) {
        }
    }

    public void a(List<String> list) {
        this.f7121c.clear();
        if (list != null) {
            this.f7121c.addAll(list);
        }
    }

    public void b(int i10, boolean z10) {
        this.f7123e = i10;
        this.f7124f = z10;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7121c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f7121c.get(i10);
    }

    public m(Context context, List<String> list) {
        this.f7119a = context;
        this.f7120b = LayoutInflater.from(context);
        ArrayList arrayList = new ArrayList();
        this.f7121c = arrayList;
        arrayList.addAll(list);
        this.f7122d = s0.f7342a.t();
    }
}
