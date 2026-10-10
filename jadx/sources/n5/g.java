package n5;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.util.t;
import com.live.evo.util.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g extends n5.a<String> implements View.OnClickListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f15998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f15999h;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f16000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f16001b;

        a(int i10, c cVar) {
            this.f16000a = i10;
            this.f16001b = cVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            int i10;
            if (z10) {
                z0.d(view);
                n5.a.g gVar = g.this.f15953e;
                if (gVar != null) {
                    gVar.a(view, this.f16000a);
                }
                i10 = R$color.item_selected_color;
            } else {
                z0.g(view);
                i10 = R$color.item_normal_color;
            }
            this.f16001b.f16005a.setTextColor(g.this.f15999h.getResources().getColor(i10));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f16003a;

        b(c cVar) {
            this.f16003a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.i(g.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class c extends RecyclerView.ViewHolder implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f16005a;

        public c(View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R$id.keyitem_tv_name);
            this.f16005a = textView;
            textView.setOnClickListener(g.this);
            this.f16005a.setOnKeyListener(this);
            t.d(this.f16005a);
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            g.i(g.this);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface d {
    }

    @Override // n5.a, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 24;
    }

    @Override // n5.a
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void c(RecyclerView.ViewHolder viewHolder, int i10, String str) {
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            cVar.f16005a.setText(str);
            cVar.f16005a.setTag(Integer.valueOf(i10 + 1));
            cVar.itemView.setTag(str);
            viewHolder.itemView.setOnFocusChangeListener(new a(i10, cVar));
            viewHolder.itemView.setOnClickListener(new b(cVar));
        }
        viewHolder.itemView.setFocusable(true);
    }

    public g(Context context, String[] strArr) {
        this.f15999h = context;
        this.f15998g = strArr;
    }

    static /* bridge */ /* synthetic */ d i(g gVar) {
        gVar.getClass();
        return null;
    }

    @Override // n5.a
    public RecyclerView.ViewHolder d(ViewGroup viewGroup, int i10) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.key_item, viewGroup, false));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
