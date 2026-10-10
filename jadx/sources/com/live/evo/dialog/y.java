package com.live.evo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class y extends Dialog implements View.OnKeyListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f5803m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f5804n = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f5806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f5807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Button f5808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Button f5809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ProgressBar f5810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f5811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f5812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f5813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f5814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f5815k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private e f5816l;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (y.this.f5816l != null) {
                y.this.f5816l.b(y.this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (y.this.f5816l != null) {
                y.this.f5816l.c(y.this);
            } else {
                y.this.hide();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements n {
        c() {
        }

        @Override // com.live.evo.dialog.n
        public void a() {
            if (y.this.f5816l != null) {
                y.this.f5816l.a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class d implements e {
        @Override // com.live.evo.dialog.y.e
        public int d() {
            return y.f5804n;
        }

        @Override // com.live.evo.dialog.y.e
        public void b(y yVar) {
        }

        @Override // com.live.evo.dialog.y.e
        public void c(y yVar) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface e {
        void a();

        void b(y yVar);

        void c(y yVar);

        int d();
    }

    private void b(Context context) {
        this.f5805a = context;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 55;
        attributes.width = -1;
        attributes.height = -1;
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setAttributes(attributes);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        c();
    }

    private void c() {
        View viewInflate = LayoutInflater.from(this.f5805a).inflate(R$layout.layout_upgrade_prompt_a, (ViewGroup) null);
        this.f5806b = viewInflate;
        setContentView(viewInflate);
        this.f5807c = (TextView) this.f5806b.findViewById(R$id.upgrade_text);
        this.f5808d = (Button) this.f5806b.findViewById(R$id.btn_ok);
        this.f5810f = (ProgressBar) this.f5806b.findViewById(R$id.pb_downloading);
        this.f5811g = this.f5806b.findViewById(R$id.btn_parents);
        this.f5812h = this.f5806b.findViewById(R$id.pb_parents);
        this.f5813i = (TextView) this.f5806b.findViewById(R$id.tv_progress);
        this.f5814j = (TextView) this.f5806b.findViewById(R$id.tv_update_select);
        this.f5815k = (TextView) this.f5806b.findViewById(R$id.tv_update_message);
        this.f5808d.requestFocus();
        this.f5809e = (Button) this.f5806b.findViewById(R$id.btn_cancel);
        this.f5808d.setOnKeyListener(this);
        this.f5809e.setOnKeyListener(this);
        this.f5808d.setOnClickListener(new a());
        this.f5809e.setOnClickListener(new b());
        this.f5812h.setVisibility(8);
    }

    public void d(int i10, int i11, int i12, String str, String str2, String str3) {
        this.f5808d.setVisibility(i10);
        this.f5809e.setVisibility(i11);
        this.f5814j.setVisibility(i12);
        this.f5808d.setText(str);
        this.f5809e.setText(str2);
        this.f5814j.setText(str3);
    }

    public void e(e eVar) {
        this.f5816l = eVar;
    }

    public void f(CharSequence charSequence) {
        this.f5807c.setText(charSequence);
    }

    public y(Context context, int i10) {
        super(context, i10);
        b(context);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            if (i10 == 4 || i10 == 111) {
                e eVar = this.f5816l;
                if (eVar != null && eVar.d() != f5804n) {
                    e eVar2 = this.f5816l;
                    if (eVar2 != null && eVar2.d() == f5803m) {
                        dismiss();
                        this.f5816l.c(this);
                        return false;
                    }
                    return false;
                }
                m mVar = new m(this.f5805a);
                mVar.h(new c());
                mVar.i();
                return false;
            }
            return false;
        }
        return false;
    }
}
