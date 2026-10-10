package com.live.evo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends Dialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f5655h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f5656i = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f5658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Button f5659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Button f5660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f5661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Runnable f5663g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f5664a;

        a(Runnable runnable) {
            this.f5664a = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            Runnable runnable = this.f5664a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: renamed from: com.live.evo.dialog.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class ViewOnClickListenerC0069b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f5666a;

        ViewOnClickListenerC0069b(Runnable runnable) {
            this.f5666a = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            Runnable runnable = this.f5666a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f5668a;

        c(Runnable runnable) {
            this.f5668a = runnable;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            this.f5668a.run();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f5669a;

        d(Runnable runnable) {
            this.f5669a = runnable;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            this.f5669a.run();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f5670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f5671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f5672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f5673d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private DialogInterface.OnClickListener f5674e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private DialogInterface.OnClickListener f5675f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Runnable f5676g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f5677h = true;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f5678i = true;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f5679j = true;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f5680k = b.f5655h;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f5681a;

            a(b bVar) {
                this.f5681a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.f5674e != null) {
                    e.this.f5674e.onClick(this.f5681a, b.f5655h);
                }
            }
        }

        /* JADX INFO: renamed from: com.live.evo.dialog.b$e$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class ViewOnClickListenerC0070b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f5683a;

            ViewOnClickListenerC0070b(b bVar) {
                this.f5683a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.f5675f != null) {
                    e.this.f5675f.onClick(this.f5683a, b.f5656i);
                }
            }
        }

        public b c() {
            b bVar = new b(this.f5670a);
            bVar.f5663g = this.f5676g;
            bVar.f5661e.setText(TextUtils.isEmpty(this.f5673d) ? "" : Html.fromHtml(this.f5673d));
            if (this.f5677h) {
                bVar.f5659c.setText(this.f5671b);
                bVar.f5659c.setOnClickListener(new a(bVar));
            } else {
                bVar.f5659c.setVisibility(8);
            }
            if (this.f5678i) {
                bVar.f5660d.setText(this.f5672c);
                bVar.f5660d.setOnClickListener(new ViewOnClickListenerC0070b(bVar));
            } else {
                bVar.f5660d.setVisibility(8);
            }
            bVar.f5662f = this.f5680k;
            return bVar;
        }

        public e d(boolean z10) {
            this.f5679j = z10;
            return this;
        }

        public e e(String str, DialogInterface.OnClickListener onClickListener) {
            this.f5672c = str;
            this.f5675f = onClickListener;
            return this;
        }

        public e f(Runnable runnable) {
            this.f5676g = runnable;
            return this;
        }

        public e g(String str) {
            this.f5673d = str;
            return this;
        }

        public e h(String str, DialogInterface.OnClickListener onClickListener) {
            this.f5671b = str;
            this.f5674e = onClickListener;
            return this;
        }

        public e(Context context) {
            this.f5670a = context;
        }

        public b i() {
            b bVarC = c();
            bVarC.show();
            return bVarC;
        }
    }

    public static void i(Context context, String str, String str2, String str3, Runnable runnable, Runnable runnable2) {
        j(context, str, str2, str3, runnable, runnable2, null);
    }

    public void h(String str, String str2, String str3, Runnable runnable, Runnable runnable2, boolean z10, boolean z11, boolean z12) {
        g(str, str2, str3, runnable, runnable2, null, z10, z11, z12);
    }

    private void f(Context context) {
        this.f5657a = context;
        setContentView(2131624035);
        this.f5661e = (TextView) findViewById(2131427756);
        this.f5658b = findViewById(2131427757);
        this.f5659c = (Button) findViewById(2131427753);
        this.f5660d = (Button) findViewById(2131427752);
        if (com.live.evo.util.e.b().a()) {
            com.live.evo.util.t.c(this.f5661e);
            com.live.evo.util.t.b(this.f5659c);
            com.live.evo.util.t.b(this.f5660d);
        } else {
            com.live.evo.util.t.c(this.f5661e);
            com.live.evo.util.t.d(this.f5659c);
            com.live.evo.util.t.d(this.f5660d);
        }
    }

    public static void j(Context context, String str, String str2, String str3, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        new e(context).h(str2, new d(runnable)).e(str3, new c(runnable2)).f(runnable3).g(str).d(false).i();
    }

    public b(@NonNull Context context) {
        super(context, 2132017467);
        this.f5662f = f5655h;
        f(context);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Runnable runnable = this.f5663g;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void g(String str, String str2, String str3, Runnable runnable, Runnable runnable2, Runnable runnable3, boolean z10, boolean z11, boolean z12) {
        setCancelable(z12);
        this.f5663g = runnable3;
        this.f5661e.setText(str);
        this.f5659c.setText(str2);
        this.f5660d.setText(str3);
        this.f5659c.setOnClickListener(new a(runnable));
        this.f5660d.setOnClickListener(new ViewOnClickListenerC0069b(runnable2));
        if (z10) {
            this.f5659c.setVisibility(0);
        } else {
            this.f5659c.setVisibility(8);
        }
        if (z11) {
            this.f5660d.setVisibility(0);
        } else {
            this.f5660d.setVisibility(8);
        }
        show();
        if (this.f5662f == f5655h) {
            this.f5659c.requestFocus();
        } else {
            this.f5660d.requestFocus();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.f5662f == f5655h) {
            this.f5659c.requestFocus();
        } else {
            this.f5660d.requestFocus();
        }
    }
}
