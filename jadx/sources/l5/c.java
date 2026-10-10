package l5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.util.t;
import com.live.evo.util.v;
import com.live.evo.util.z0;
import i5.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c extends n5.a<h> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<h> f15208g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final LayoutInflater f15209h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Context f15210i;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f15211a;

        a(b bVar) {
            this.f15211a = bVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            int i10;
            if (z10) {
                z0.d(this.f15211a.itemView);
                i10 = R$color.item_selected_color;
            } else {
                z0.g(this.f15211a.itemView);
                i10 = R$color.item_normal_color;
            }
            this.f15211a.f15213a.setTextColor(c.this.f15210i.getResources().getColor(i10));
            this.f15211a.f15217e.setTextColor(c.this.f15210i.getResources().getColor(i10));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f15213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RelativeLayout f15214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ImageView f15215c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ImageView f15216d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private TextView f15217e;

        /* synthetic */ b(c cVar, View view, d dVar) {
            this(cVar, view);
        }

        private b(c cVar, View view) {
            super(view);
            this.f15213a = (TextView) view.findViewById(R$id.searchresultitem_tv_channelid);
            this.f15214b = (RelativeLayout) view.findViewById(R$id.tv_channel_layout);
            this.f15215c = (ImageView) view.findViewById(R$id.searchresultitem_iv_fav);
            this.f15216d = (ImageView) view.findViewById(R$id.searchresultitem_iv_result_img);
            this.f15217e = (TextView) view.findViewById(R$id.searchresultitem_tv_name);
            t.d(this.f15213a);
            t.d(this.f15217e);
        }
    }

    @Override // n5.a
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void c(RecyclerView.ViewHolder viewHolder, int i10, h hVar) {
        if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            String strValueOf = String.valueOf(hVar.i() + 1);
            if (strValueOf.length() <= 1) {
                strValueOf = "00" + strValueOf;
            } else if (strValueOf.length() <= 2) {
                strValueOf = "0" + strValueOf;
            }
            hVar.e();
            bVar.f15213a.setText(strValueOf);
            bVar.f15217e.setText(hVar.e());
            v.d(this.f15210i, hVar.g(), bVar.f15216d);
            viewHolder.itemView.setOnFocusChangeListener(new a(bVar));
            if (hVar.j() > 0) {
                bVar.f15215c.setVisibility(0);
            } else {
                bVar.f15215c.setVisibility(8);
            }
            viewHolder.itemView.setFocusable(true);
        }
    }

    public c(Context context) {
        this.f15210i = context;
        this.f15209h = LayoutInflater.from(context);
    }

    @Override // n5.a
    public RecyclerView.ViewHolder d(ViewGroup viewGroup, int i10) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.search_result_item, viewGroup, false), null);
    }
}
