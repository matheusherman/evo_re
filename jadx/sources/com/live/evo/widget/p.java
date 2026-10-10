package com.live.evo.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import i5.y;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class p extends RecyclerView.Adapter<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<y> f7664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LayoutInflater f7665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f7666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7667d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f7668a;

        a(c cVar) {
            this.f7668a = cVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (z10) {
                this.f7668a.f7672b.setTextColor(p.this.f7666c.getResources().getColor(R$color.program_text_focused_color));
            } else {
                this.f7668a.f7672b.setTextColor(p.this.f7666c.getResources().getColor(R$color.item_text_normal_color));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ y f7670a;

        b(p pVar, y yVar) {
            this.f7670a = yVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f7670a.a() != null) {
                this.f7670a.a().run();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f7671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f7672b;

        public c(p pVar, View view) {
            super(view);
            this.f7671a = (ImageView) view.findViewById(R$id.menu_icon);
            this.f7672b = (TextView) view.findViewById(R$id.menu_name);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull c cVar, int i10) {
        y yVar = this.f7664a.get(i10);
        if (yVar.b() == -1) {
            cVar.f7671a.setVisibility(8);
        } else {
            cVar.f7671a.setVisibility(0);
            cVar.f7671a.setImageResource(yVar.b());
        }
        cVar.itemView.setOnFocusChangeListener(new a(cVar));
        cVar.f7672b.setText(yVar.c());
        cVar.itemView.setOnClickListener(new b(this, yVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return this.f7667d ? new c(this, this.f7665b.inflate(R$layout.popup_menu_item_pip, viewGroup, false)) : new c(this, this.f7665b.inflate(R$layout.popup_menu_item2, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<y> list = this.f7664a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public p(Context context, List<y> list, boolean z10) {
        this.f7667d = false;
        this.f7666c = context;
        this.f7665b = LayoutInflater.from(context);
        this.f7664a = list;
        this.f7667d = z10;
    }
}
