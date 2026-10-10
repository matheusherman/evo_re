package com.live.evo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$style;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f5821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Dialog f5822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RecyclerView f5823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, i5.a> f5824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<i5.a> f5825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d5.b f5826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f5827h;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements d5.b.a {
        a() {
        }

        @Override // d5.b.a
        public void a(i5.a aVar) {
            if (z.this.f5821b != null) {
                z.this.f5821b.a(aVar);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b {
        void a(i5.a aVar);
    }

    private void b() {
        HashMap map = new HashMap();
        this.f5824e = map;
        this.f5825f.clear();
        for (i5.a aVar : map.values()) {
            if (aVar != null && aVar.e() != -1) {
                int i10 = this.f5827h;
                if (i10 != 3) {
                    if (i10 != 6) {
                        if (aVar.e() == 0) {
                            this.f5825f.add(0, aVar);
                        }
                    } else if (aVar.e() == 1) {
                        this.f5825f.add(0, aVar);
                    }
                } else if (aVar.e() == 2) {
                    this.f5825f.add(0, aVar);
                }
            }
        }
    }

    private void d() {
        this.f5825f = new ArrayList();
        b();
        this.f5823d.setLayoutManager(new LinearLayoutManager(this.f5820a));
        this.f5823d.addItemDecoration(new DividerItemDecoration(this.f5820a, 1));
        d5.b bVar = new d5.b(this.f5825f, this.f5820a, new a());
        this.f5826g = bVar;
        this.f5823d.setAdapter(bVar);
    }

    private void e() {
        View viewInflate = LayoutInflater.from(this.f5820a).inflate(R$layout.user_list_dialog, (ViewGroup) null, false);
        com.live.evo.widget.o oVar = new com.live.evo.widget.o(this.f5820a, R$style.EPGDialog);
        this.f5822c = oVar;
        oVar.setContentView(viewInflate);
        this.f5822c.setCanceledOnTouchOutside(true);
        this.f5823d = (RecyclerView) viewInflate.findViewById(R$id.userlistdlg_rv_userlist);
    }

    public void c() {
        if (this.f5822c.isShowing()) {
            this.f5822c.hide();
        }
    }

    public boolean f() {
        List<i5.a> list = this.f5825f;
        return list != null && list.size() > 0;
    }

    public void g() {
        if (this.f5822c.isShowing()) {
            return;
        }
        this.f5822c.show();
    }

    public z(Context context, int i10, b bVar) {
        this.f5820a = context;
        this.f5821b = bVar;
        this.f5827h = i10;
        e();
        d();
    }
}
