package com.live.evo.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.log4j.spi.Configurator;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b0 extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f5865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewPager f5866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f5867c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<TextView> f5868d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Fragment> f5869e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f5870f = Configurator.NULL;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f5871g = Configurator.NULL;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f5872h = false;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements ViewPager.OnPageChangeListener {
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i10) {
            for (int i11 = 0; i11 < b0.this.f5868d.size(); i11++) {
                if (i11 == i10) {
                    ((TextView) b0.this.f5868d.get(i11)).setSelected(true);
                } else {
                    ((TextView) b0.this.f5868d.get(i11)).setSelected(false);
                }
            }
        }

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b0.this.isAdded()) {
                b0.this.f5866b.setCurrentItem(0);
            }
        }
    }

    private void T() {
        this.f5866b.addOnPageChangeListener(new a());
    }

    private void U() {
        this.f5867c.clear();
        this.f5868d.clear();
        this.f5869e.clear();
        TextView textView = (TextView) this.f5865a.findViewById(R$id.tv_feedback);
        TextView textView2 = (TextView) this.f5865a.findViewById(R$id.tv_faq);
        TextView textView3 = (TextView) this.f5865a.findViewById(R$id.tv_contact);
        textView2.setVisibility(8);
        textView3.setVisibility(8);
        this.f5867c.add(getString(R$string.feedback_userfeedback_title_1));
        this.f5868d.add(textView);
        m3 m3Var = new m3();
        m3Var.k0(this.f5870f);
        m3Var.j0(this.f5871g);
        this.f5869e.add(m3Var);
        if (com.live.evo.util.q.d().c() != null && com.live.evo.util.q.d().c().size() > 0) {
            this.f5867c.add(getString(R$string.feedback_faq_title_1));
            this.f5868d.add(textView2);
            this.f5869e.add(new f2());
            textView2.setVisibility(0);
            textView2.setSelected(false);
            textView.setSelected(true);
        }
        if (com.live.evo.util.q.d().b() != null && com.live.evo.util.q.d().b().size() > 0) {
            this.f5867c.add(getString(R$string.feedback_contactus_title_1));
            this.f5868d.add(textView3);
            textView3.setVisibility(0);
            this.f5869e.add(new z());
            textView3.setSelected(false);
            textView.setSelected(true);
        }
        ViewPager viewPager = (ViewPager) this.f5865a.findViewById(R$id.vp_content);
        this.f5866b = viewPager;
        viewPager.setOffscreenPageLimit(2);
        V();
        this.f5866b.post(new b());
        this.f5866b.requestFocus();
        Window window = getDialog().getWindow();
        Objects.requireNonNull(window);
        window.requestFeature(1);
    }

    private void V() {
        this.f5866b.setAdapter(new c0(getChildFragmentManager(), this.f5869e, this.f5867c));
    }

    private void l() {
        x1.f1.lb.util.e0.f21385a.a(this);
    }

    public void W(String str) {
        this.f5871g = str;
    }

    public void X(String str) {
        this.f5870f = str;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        x1.f1.lb.util.e0.f21385a.b(this);
        this.f5872h = false;
        super.onDestroyView();
    }

    @xe.m(threadMode = ThreadMode.MAIN)
    public void onFeedback(i5.s sVar) {
        TextView textView = (TextView) this.f5865a.findViewById(R$id.tv_feedback);
        TextView textView2 = (TextView) this.f5865a.findViewById(R$id.tv_faq);
        TextView textView3 = (TextView) this.f5865a.findViewById(R$id.tv_contact);
        if (com.live.evo.util.q.d().c() != null && com.live.evo.util.q.d().c().size() > 0) {
            this.f5867c.add(getString(R$string.feedback_faq_title_1));
            this.f5868d.add(textView2);
            textView2.setSelected(false);
            textView.setSelected(true);
            this.f5869e.add(new f2());
        }
        if (com.live.evo.util.q.d().b() != null && com.live.evo.util.q.d().b().size() > 0) {
            this.f5867c.add(getString(R$string.feedback_contactus_title_1));
            this.f5868d.add(textView3);
            textView3.setSelected(false);
            textView.setSelected(true);
            this.f5869e.add(new z());
        }
        ((m3) this.f5869e.get(0)).l0(com.live.evo.util.q.d().e());
        V();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        this.f5865a = layoutInflater.inflate(R$layout.feedback_layout, viewGroup, false);
        U();
        T();
        l();
        return this.f5865a;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Dialog dialog = getDialog();
        Window window = dialog.getWindow();
        Objects.requireNonNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -1;
        dialog.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        dialog.getWindow().setBackgroundDrawableResource(2131102158);
        dialog.getWindow().setAttributes(attributes);
        super.onStart();
        this.f5872h = true;
    }
}
