package z4;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.tabs.TabLayout;
import com.live.evo.R$id;
import com.tvc.lib.mobile.ui.widget.AutoCompleteEditText;
import com.tvc.lib.mobile.ui.widget.ClearEditText;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f22697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f22698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AutoCompleteEditText f22699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final EditText f22700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final EditText f22701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ClearEditText f22702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final EditText f22703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final EditText f22704h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f22705i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f22706j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f22707k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f22708l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final ImageView f22709m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final ImageView f22710n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final ImageView f22711o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final ImageView f22712p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final LinearLayout f22713q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f22714r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f22715s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f22716t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f22717u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f22718v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f22719w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f22720x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final AppCompatSpinner f22721y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    public final TabLayout f22722z;

    private c(@NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout, @NonNull AutoCompleteEditText autoCompleteEditText, @NonNull EditText editText, @NonNull EditText editText2, @NonNull ClearEditText clearEditText, @NonNull EditText editText3, @NonNull EditText editText4, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull ImageView imageView7, @NonNull ImageView imageView8, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4, @NonNull RelativeLayout relativeLayout5, @NonNull RelativeLayout relativeLayout6, @NonNull RelativeLayout relativeLayout7, @NonNull RelativeLayout relativeLayout8, @NonNull AppCompatSpinner appCompatSpinner, @NonNull TabLayout tabLayout) {
        this.f22697a = linearLayout;
        this.f22698b = relativeLayout;
        this.f22699c = autoCompleteEditText;
        this.f22700d = editText;
        this.f22701e = editText2;
        this.f22702f = clearEditText;
        this.f22703g = editText3;
        this.f22704h = editText4;
        this.f22705i = imageView;
        this.f22706j = imageView2;
        this.f22707k = imageView3;
        this.f22708l = imageView4;
        this.f22709m = imageView5;
        this.f22710n = imageView6;
        this.f22711o = imageView7;
        this.f22712p = imageView8;
        this.f22713q = linearLayout2;
        this.f22714r = relativeLayout2;
        this.f22715s = relativeLayout3;
        this.f22716t = relativeLayout4;
        this.f22717u = relativeLayout5;
        this.f22718v = relativeLayout6;
        this.f22719w = relativeLayout7;
        this.f22720x = relativeLayout8;
        this.f22721y = appCompatSpinner;
        this.f22722z = tabLayout;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i10 = R$id.email_panel;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R$id.email_panel);
        if (relativeLayout != null) {
            i10 = R$id.et_login_email;
            AutoCompleteEditText autoCompleteEditText = (AutoCompleteEditText) ViewBindings.findChildViewById(view, R$id.et_login_email);
            if (autoCompleteEditText != null) {
                i10 = R$id.et_login_email_password;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, R$id.et_login_email_password);
                if (editText != null) {
                    i10 = R$id.et_login_email_password_confirm;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R$id.et_login_email_password_confirm);
                    if (editText2 != null) {
                        i10 = R$id.et_login_phone;
                        ClearEditText clearEditText = (ClearEditText) ViewBindings.findChildViewById(view, R$id.et_login_phone);
                        if (clearEditText != null) {
                            i10 = R$id.et_login_phone_password;
                            EditText editText3 = (EditText) ViewBindings.findChildViewById(view, R$id.et_login_phone_password);
                            if (editText3 != null) {
                                i10 = R$id.et_login_phone_password_confirm;
                                EditText editText4 = (EditText) ViewBindings.findChildViewById(view, R$id.et_login_phone_password_confirm);
                                if (editText4 != null) {
                                    i10 = R$id.iv_password_delete;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R$id.iv_password_delete);
                                    if (imageView != null) {
                                        i10 = R$id.iv_password_delete_confirm;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R$id.iv_password_delete_confirm);
                                        if (imageView2 != null) {
                                            i10 = R$id.iv_password_delete_email;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R$id.iv_password_delete_email);
                                            if (imageView3 != null) {
                                                i10 = R$id.iv_password_delete_email_confirm;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R$id.iv_password_delete_email_confirm);
                                                if (imageView4 != null) {
                                                    i10 = R$id.iv_password_show;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R$id.iv_password_show);
                                                    if (imageView5 != null) {
                                                        i10 = R$id.iv_password_show_email;
                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R$id.iv_password_show_email);
                                                        if (imageView6 != null) {
                                                            i10 = R$id.iv_show_user_list_1;
                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R$id.iv_show_user_list_1);
                                                            if (imageView7 != null) {
                                                                i10 = R$id.iv_show_user_list_2;
                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, R$id.iv_show_user_list_2);
                                                                if (imageView8 != null) {
                                                                    i10 = R$id.ll_login_phone_country_code;
                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R$id.ll_login_phone_country_code);
                                                                    if (linearLayout != null) {
                                                                        i10 = R$id.phone_panel;
                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R$id.phone_panel);
                                                                        if (relativeLayout2 != null) {
                                                                            i10 = R$id.rl_login_email_account;
                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R$id.rl_login_email_account);
                                                                            if (relativeLayout3 != null) {
                                                                                i10 = R$id.rl_login_email_password;
                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, R$id.rl_login_email_password);
                                                                                if (relativeLayout4 != null) {
                                                                                    i10 = R$id.rl_login_email_password_confirm;
                                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, R$id.rl_login_email_password_confirm);
                                                                                    if (relativeLayout5 != null) {
                                                                                        i10 = R$id.rl_login_phone_account;
                                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, R$id.rl_login_phone_account);
                                                                                        if (relativeLayout6 != null) {
                                                                                            i10 = R$id.rl_login_phone_password;
                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view, R$id.rl_login_phone_password);
                                                                                            if (relativeLayout7 != null) {
                                                                                                i10 = R$id.rl_login_phone_password_confirm;
                                                                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view, R$id.rl_login_phone_password_confirm);
                                                                                                if (relativeLayout8 != null) {
                                                                                                    i10 = R$id.spinner_area;
                                                                                                    AppCompatSpinner appCompatSpinner = (AppCompatSpinner) ViewBindings.findChildViewById(view, R$id.spinner_area);
                                                                                                    if (appCompatSpinner != null) {
                                                                                                        i10 = R$id.tab_layout;
                                                                                                        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, R$id.tab_layout);
                                                                                                        if (tabLayout != null) {
                                                                                                            return new c((LinearLayout) view, relativeLayout, autoCompleteEditText, editText, editText2, clearEditText, editText3, editText4, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, linearLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, appCompatSpinner, tabLayout);
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f22697a;
    }
}
