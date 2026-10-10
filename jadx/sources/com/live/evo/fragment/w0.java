package com.live.evo.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.widget.MarqueeTextView;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class w0 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<i5.l> f6854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6855b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6856c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f6857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LayoutInflater f6858e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ImageView f6859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MarqueeTextView f6860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextView f6861c;

        public a(w0 w0Var, View view) {
            this.f6859a = (ImageView) view.findViewById(R$id.leftmenulistitem_iv_icons);
            this.f6860b = (MarqueeTextView) view.findViewById(R$id.leftmenulistitem_mtv_item_name);
            this.f6861c = (TextView) view.findViewById(R$id.leftmenu_tv_flag);
            this.f6859a.setEnabled(false);
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    public void a(int i10, boolean z10) {
        this.f6855b = i10;
        this.f6856c = z10;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f6854a.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f6858e.inflate(R$layout.function_menu_item, (ViewGroup) null);
            aVar = new a(this, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        ((View) aVar.f6860b.getParent()).setSelected(this.f6856c && this.f6855b == i10);
        ((View) aVar.f6860b.getParent()).setEnabled(!this.f6856c && this.f6855b == i10);
        i5.l lVar = this.f6854a.get(i10);
        aVar.f6860b.setText(lVar.d());
        aVar.f6859a.setBackgroundResource(lVar.c());
        aVar.f6861c.setVisibility((!lVar.f() || lVar.a() <= 0) ? 8 : 0);
        if (lVar.f()) {
            int iA = lVar.a() <= 99 ? lVar.a() : 99;
            aVar.f6861c.setText("" + iA);
        }
        if (this.f6856c || this.f6855b != i10) {
            aVar.f6860b.setTypeface(Typeface.DEFAULT);
            view.setBackgroundResource(2131102158);
            return view;
        }
        aVar.f6860b.setTypeface(Typeface.DEFAULT_BOLD);
        ViewCompat.setBackground(view, AppCompatResources.getDrawable(this.f6857d, R$drawable.menu_function_bg_unfocus));
        return view;
    }

    public w0(Context context, List<i5.l> list) {
        this.f6854a = list;
        this.f6857d = context;
        this.f6858e = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return Integer.valueOf(i10);
    }
}
