package com.live.evo.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.R$style;
import com.live.evo.util.r1;
import com.live.evo.util.x1;
import com.live.evo.widget.RemoveKeyCodeEnterEditText;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f5641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Button f5642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RelativeLayout f5643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RemoveKeyCodeEnterEditText f5644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f5645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f5646f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f5648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private i5.h f5649i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f5652l;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private StringBuffer f5647g = new StringBuffer();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f5650j = 30.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f5651k = 4;

    /* JADX INFO: renamed from: com.live.evo.dialog.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class ViewOnClickListenerC0068a implements View.OnClickListener {
        ViewOnClickListenerC0068a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.U();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements DialogInterface.OnKeyListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && ((i10 == 4 || i10 == 111) && a.this.f5648h != null)) {
                a.this.f5648h.b();
            }
            if (keyEvent.getAction() == 1 && a.this.f5644d.hasFocus()) {
                if (i10 == 23 || i10 == 66) {
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface c {
        void a(i5.h hVar);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        String string = this.f5644d.getText().toString();
        if (string.length() < this.f5651k) {
            r1.b(getActivity(), R$string.adult_key_not_map, 0);
            this.f5644d.requestFocus();
            return;
        }
        if (!com.live.evo.l.n().y()) {
            if (TextUtils.equals(string, "2026")) {
                r1.b(getActivity(), R$string.adult_key_invalid, 0);
                this.f5644d.setText("");
                this.f5644d.requestFocus();
                return;
            } else {
                r1.d(getActivity(), x1.k(R$string.adult_key_saved, string.toString()), 1);
                com.live.evo.l.n().O(string.toString());
                com.live.evo.l.n().N(true);
                this.f5648h.a(this.f5649i);
                dismiss();
                return;
            }
        }
        if (t.v.c.i.a.f18646a.p0(string)) {
            com.live.evo.l.n().N(true);
            this.f5648h.a(this.f5649i);
            dismiss();
        } else if (!TextUtils.equals(string, "2026")) {
            r1.b(getActivity(), R$string.adult_key_not_map, 0);
            this.f5644d.setText("");
            this.f5644d.requestFocus();
        } else {
            r1.b(getActivity(), R$string.adult_key_reset_hint, 0);
            com.live.evo.l.n().O("");
            com.live.evo.l.n().N(false);
            FragmentActivity activity = getActivity();
            dismiss();
            com.live.evo.l.n().T(activity, this.f5648h, this.f5649i);
        }
    }

    public static a V(c cVar, i5.h hVar) {
        a aVar = new a();
        aVar.f5648h = cVar;
        aVar.f5649i = hVar;
        return aVar;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R$style.DialogFullScreen);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R$layout.adult_new_key, viewGroup, false);
        this.f5641a = viewInflate;
        this.f5643c = (RelativeLayout) viewInflate.findViewById(R$id.adultnewkey_rl_layout_pwd);
        this.f5644d = (RemoveKeyCodeEnterEditText) this.f5641a.findViewById(R$id.adultnewkey_tv_adult_pwd);
        this.f5642b = (Button) this.f5641a.findViewById(R$id.adultnewkey_btn_go);
        this.f5645e = (TextView) this.f5641a.findViewById(R$id.adultnewkey_tv_title);
        this.f5646f = (TextView) this.f5641a.findViewById(R$id.adultnewkey_tv_hint);
        this.f5652l = this.f5641a;
        this.f5642b.setOnClickListener(new ViewOnClickListenerC0068a());
        getDialog().setOnKeyListener(new b());
        return this.f5641a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        boolean zJ = com.live.evo.l.n().j("category_is_upcase", true);
        if (com.live.evo.l.n().y()) {
            String strJ = x1.j(R$string.adult_key_title);
            if (zJ) {
                strJ = strJ.toUpperCase();
            }
            this.f5645e.setText(strJ);
            this.f5646f.setText(x1.j(R$string.adult_key_again_hint));
            return;
        }
        String strJ2 = x1.j(R$string.adult_key_title);
        if (zJ) {
            strJ2 = strJ2.toUpperCase();
        }
        this.f5645e.setText(strJ2);
        this.f5646f.setText(R$string.adult_key_first_hint);
    }
}
