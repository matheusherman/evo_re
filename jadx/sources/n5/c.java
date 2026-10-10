package n5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.util.v;
import com.live.evo.util.z0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<i5.h> f15972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f15973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutInflater f15974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15976e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<i5.h> f15977f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f15978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ImageView f15979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ImageView f15980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TextView f15981d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f15982e;

        /* synthetic */ a(c cVar, d dVar) {
            this(cVar);
        }

        private a(c cVar) {
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    public void a(int i10) {
        this.f15976e = i10;
        notifyDataSetChanged();
    }

    public void b(i5.h hVar, int i10) {
        List<i5.h> list = this.f15977f;
        if (list != null) {
            this.f15975d = i10;
            list.remove(i10);
            this.f15977f.add(i10, hVar);
            notifyDataSetChanged();
        }
    }

    public void c(List<i5.h> list) {
        List<i5.h> list2 = this.f15977f;
        if (list2 != null) {
            list2.clear();
            this.f15977f.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f15977f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f15977f.get(i10);
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewInflate;
        a aVar;
        int i11;
        if (view == null) {
            aVar = new a(this, null);
            viewInflate = this.f15974c.inflate(R$layout.favoriteall_program_list_item, (ViewGroup) null);
            aVar.f15978a = (TextView) viewInflate.findViewById(R$id.favallprogramlistitem_tv_channel_id);
            aVar.f15979b = (ImageView) viewInflate.findViewById(R$id.favallprogramlistitem_iv_image_favorite);
            aVar.f15980c = (ImageView) viewInflate.findViewById(R$id.favallprogramlistitem_iv_program_icons);
            aVar.f15981d = (TextView) viewInflate.findViewById(R$id.favallprogramlistitem_tv_program_item_name);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (a) view.getTag();
        }
        i5.h hVar = this.f15977f.get(i10);
        String strValueOf = String.valueOf(this.f15972a.indexOf(hVar) + 1);
        if (strValueOf.length() <= 1) {
            strValueOf = "00" + strValueOf;
        } else if (strValueOf.length() <= 2) {
            strValueOf = "0" + strValueOf;
        }
        aVar.f15978a.setText(strValueOf);
        aVar.f15981d.setText(hVar.e());
        if (hVar.j() > 0) {
            if (aVar.f15979b.getVisibility() != 0) {
                aVar.f15979b.setVisibility(0);
            }
        } else if (aVar.f15979b.getVisibility() == 0) {
            aVar.f15979b.setVisibility(8);
        }
        v.c(this.f15973b, hVar.g(), 2131102158, aVar.f15980c);
        if (this.f15976e == i10) {
            z0.d(viewInflate);
            aVar.f15982e = true;
            i11 = R$color.item_selected_color;
        } else {
            if (aVar.f15982e) {
                z0.g(viewInflate);
            }
            aVar.f15982e = false;
            i11 = R$color.item_normal_color;
        }
        aVar.f15978a.setTextColor(this.f15973b.getResources().getColor(i11));
        aVar.f15981d.setTextColor(this.f15973b.getResources().getColor(i11));
        return viewInflate;
    }

    public c(Context context, List<i5.h> list) {
        ArrayList arrayList = new ArrayList();
        this.f15977f = arrayList;
        this.f15973b = context;
        arrayList.addAll(list);
        this.f15972a = list;
        this.f15974c = LayoutInflater.from(this.f15973b);
    }
}
