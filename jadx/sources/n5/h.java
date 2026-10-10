package n5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import i5.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f16007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LayoutInflater f16008b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<z> f16010d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16009c = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f16011e = true;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ImageView f16012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        TextView f16013b;

        /* synthetic */ a(h hVar, i iVar) {
            this(hVar);
        }

        private a(h hVar) {
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    public void a(int i10) {
        this.f16009c = i10;
        notifyDataSetChanged();
    }

    public void b(List<z> list) {
        List<z> list2 = this.f16010d;
        if (list2 != null) {
            list2.clear();
            this.f16010d.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f16010d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f16010d.get(i10);
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewInflate;
        a aVar;
        if (view == null) {
            aVar = new a(this, null);
            viewInflate = this.f16008b.inflate(R$layout.lockclassify_list_item, (ViewGroup) null);
            aVar.f16012a = (ImageView) viewInflate.findViewById(R$id.lockclassifylistitem_iv_image);
            aVar.f16013b = (TextView) viewInflate.findViewById(R$id.lockclassifylistitem_tv_item_name);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (a) view.getTag();
        }
        String strValueOf = String.valueOf(i10 + 1);
        if (strValueOf.length() <= 1) {
            strValueOf = "0" + strValueOf;
        }
        z zVar = this.f16010d.get(i10);
        aVar.f16013b.setText(strValueOf + "  " + zVar.b());
        if (zVar.c() == 1) {
            aVar.f16012a.setVisibility(0);
            return viewInflate;
        }
        aVar.f16012a.setVisibility(8);
        return viewInflate;
    }

    public h(Context context, List<z> list) {
        ArrayList arrayList = new ArrayList();
        this.f16010d = arrayList;
        this.f16007a = context;
        arrayList.addAll(list);
        this.f16008b = LayoutInflater.from(this.f16007a);
    }
}
