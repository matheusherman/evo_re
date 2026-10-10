package o5;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.live.evo.R$id;
import com.live.evo.widget.nicespinner.NiceSpinner;
import i5.o;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private q6.b f16461a = q6.c.d(d.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f16462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private NiceSpinner f16463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EditText f16464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private o f16465e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements r5.b {
        b() {
        }

        @Override // r5.b
        public void a(NiceSpinner niceSpinner, View view, int i10, long j10) {
            d dVar = d.this;
            dVar.f16465e = (o) dVar.f16463c.getSelectedItem();
        }
    }

    public void h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                this.f16464d.setText("");
                return;
            }
            List<o> listB = o5.a.c().b();
            for (int i10 = 0; i10 < listB.size(); i10++) {
                o oVar = listB.get(i10);
                if (str.contains(oVar.c()) && str.indexOf(oVar.c()) == 0) {
                    this.f16463c.q(i10, true);
                    str = str.replace(oVar.c(), "");
                    break;
                }
            }
            if (TextUtils.isEmpty(str)) {
                this.f16464d.setText("");
            } else {
                this.f16464d.setText(str);
                this.f16464d.setSelection(str.length());
            }
        } catch (Exception e10) {
            this.f16461a.error(e10.getMessage(), e10);
        }
    }

    public void j(i5.a aVar) {
        if (aVar != null) {
            try {
                if (!TextUtils.isEmpty(aVar.a())) {
                    if (o5.a.c().g(aVar.d() + aVar.a())) {
                        List<o> listB = o5.a.c().b();
                        for (int i10 = 0; i10 < listB.size(); i10++) {
                            if (listB.get(i10).c().equalsIgnoreCase(aVar.d())) {
                                this.f16463c.q(i10, true);
                                break;
                            }
                        }
                        this.f16464d.setText(aVar.a());
                        this.f16464d.setSelection(aVar.a().length());
                        return;
                    }
                }
            } catch (Exception e10) {
                this.f16461a.error(e10.getMessage(), e10);
                return;
            }
        }
        this.f16464d.setText("");
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements r5.d<o> {
        a(d dVar) {
        }

        @Override // r5.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Spannable a(o oVar) {
            String strC;
            if (!TextUtils.isEmpty(oVar.b())) {
                strC = oVar.c() + "(" + oVar.b() + ")";
            } else {
                strC = oVar.c();
            }
            return new SpannableString(strC);
        }
    }

    private void k(View view) {
        if (this.f16463c == null) {
            this.f16463c = (NiceSpinner) view.findViewById(R$id.spinner_phonecode);
        }
        if (this.f16464d == null) {
            this.f16464d = (EditText) view.findViewById(R$id.et_phonenumber);
        }
        if (this.f16463c == null || this.f16464d == null) {
            return;
        }
        i();
    }

    public NiceSpinner c() {
        return this.f16463c;
    }

    public String d() {
        try {
            if (TextUtils.isEmpty(this.f16464d.getText().toString().trim())) {
                return "";
            }
            return o5.a.c().b().get(this.f16463c.getSelectedIndex()).c() + this.f16464d.getText().toString().trim();
        } catch (Exception unused) {
            return "";
        }
    }

    public String e() {
        try {
            return this.f16464d.getText().toString().trim();
        } catch (Exception unused) {
            return "";
        }
    }

    public EditText f() {
        return this.f16464d;
    }

    public void l(CharSequence charSequence) {
        try {
            this.f16464d.setText(charSequence);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void m(int i10, boolean z10) {
        try {
            this.f16463c.q(i10, z10);
        } catch (Exception unused) {
        }
    }

    public d(Context context, View view) {
        this.f16462b = context;
        k(view);
    }

    private void i() {
        List<o> listB = o5.a.c().b();
        a aVar = new a(this);
        this.f16463c.setSpinnerTextFormatter(aVar);
        this.f16463c.setSelectedTextFormatter(aVar);
        this.f16463c.setOnSpinnerItemSelectedListener(new b());
        this.f16463c.l(listB);
        if (listB != null && listB.size() > 5) {
            this.f16463c.setHeight(400);
        }
    }

    public o g() {
        return o5.a.c().b().get(this.f16463c.getSelectedIndex());
    }

    public void n(i5.a aVar) {
        List<o> listB = o5.a.c().b();
        for (int i10 = 0; i10 < listB.size(); i10++) {
            o oVar = listB.get(i10);
            if (oVar.c().equalsIgnoreCase(aVar.d()) && oVar.a().equalsIgnoreCase(aVar.b())) {
                m(i10, true);
                return;
            }
        }
    }
}
