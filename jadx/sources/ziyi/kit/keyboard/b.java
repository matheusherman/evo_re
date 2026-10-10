package ziyi.kit.keyboard;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.net.SyslogAppender;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b extends FrameLayout {
    private int A;
    private int B;
    private int C;
    private int D;
    private int[] E;
    private String F;
    private KeyView G;
    private boolean H;
    private boolean I;
    private boolean J;
    private int K;
    private int L;
    private View.OnFocusChangeListener M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f23356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap<Integer, Integer> f23358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f23359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f23360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f23361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SparseArray<KeyView> f23362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SparseArray<KeyView> f23363h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SparseArray<Animator> f23364i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Animator f23365j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<EditText> f23366k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<EditText> f23367l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private HashMap<EditText, View.OnKeyListener> f23368m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private EditText f23369n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f23370o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private View.OnTouchListener f23371p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private View.OnLongClickListener f23372q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private View.OnKeyListener f23373r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private View.OnClickListener f23374s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Typeface f23375t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f23376u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f23377v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f23378w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f23379x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f23380y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Rect f23381z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.f23356a.clearAnimation();
            b.this.c0(b.this.f23356a.getLeft(), b.this.f23356a.getTop() + b.this.f23361f, b.this.f23356a.getWidth(), b.this.f23356a.getHeight() * 2);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: renamed from: ziyi.kit.keyboard.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class RunnableC0495b implements Runnable {
        RunnableC0495b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = KeyUtils.f23286h;
            if (i10 != 0) {
                b.this.h0(i10);
            } else {
                b bVar = b.this;
                bVar.h0(bVar.f23356a.getHeight());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.s();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!(view instanceof EditText)) {
                return false;
            }
            b.this.g0((EditText) view);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements View.OnLongClickListener {
        e() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (!(view instanceof EditText)) {
                return false;
            }
            b.this.g0((EditText) view);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f implements View.OnKeyListener {
        f() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            b.this.dispatchKeyEvent(keyEvent);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.v((KeyView) view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class h implements View.OnFocusChangeListener {
        h() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (b.this.J || b.this.getVisibility() != 0 || !(view instanceof EditText) || b.this.f23369n == null) {
                return;
            }
            view.setSelected(!z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class i implements View.OnLongClickListener {
        i() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.t();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class j implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f23391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f23392b;

        j(int i10, int i11) {
            this.f23391a = i10;
            this.f23392b = i11;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() != 21 || this.f23391a != 0) {
                if (keyEvent.getKeyCode() == 19 && this.f23392b == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class k implements Animator.AnimatorListener {
        k() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.f23365j = null;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.f23365j = null;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f23365j = animator;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class l implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f23395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f23396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f23397c;

        public l(int i10, float f10, float f11) {
            this.f23395a = i10;
            this.f23396b = f10;
            this.f23397c = f11;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.f23364i.remove(this.f23395a);
            KeyView keyView = (KeyView) b.this.f23362g.get(this.f23395a);
            if (keyView != null) {
                keyView.setScaleX(this.f23396b);
                keyView.setScaleY(this.f23397c);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.f23364i.remove(this.f23395a);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface m {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface n {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface o {
    }

    public b(Context context, View view, boolean z10) {
        this(context, z10, (AttributeSet) null);
        this.f23356a = view;
    }

    private void C(boolean z10) {
        for (int i10 = 0; i10 < this.f23362g.size(); i10++) {
            SparseArray<KeyView> sparseArray = this.f23362g;
            sparseArray.get(sparseArray.keyAt(i10)).setEnabled(z10);
        }
    }

    private float J(List<List<ziyi.kit.keyboard.a>> list) {
        float fMax = 0.0f;
        for (int i10 = 0; i10 < list.size(); i10++) {
            List<ziyi.kit.keyboard.a> list2 = list.get(i10);
            float fB = 0.0f;
            for (int i11 = 0; i11 < list2.size(); i11++) {
                fB += list2.get(i11).b();
            }
            fMax = Math.max(fMax, fB);
        }
        return fMax;
    }

    private void d0() {
        setVisibility(0);
        setBackgroundResource(KeyUtils.f23279a);
    }

    private int G(int i10) {
        return KeyUtils.f23281c;
    }

    private int H(int i10) {
        Resources resources;
        int i11;
        if (i10 == 148) {
            resources = getResources();
            i11 = KeyUtils.f23283e;
        } else {
            resources = getResources();
            i11 = KeyUtils.f23282d;
        }
        return resources.getColor(i11);
    }

    private float I(int i10) {
        return 20.0f;
    }

    private void K() {
        setVisibility(8);
        setKeyboardType(null);
        this.K = 0;
        this.L = 0;
        setFocusKeyViewBackgroud(KeyUtils.f23281c);
        List<EditText> list = this.f23366k;
        if (list != null) {
            for (EditText editText : list) {
                if (this.f23368m.get(editText) != null) {
                    editText.setOnKeyListener(this.f23368m.get(editText));
                } else {
                    editText.setOnKeyListener(null);
                }
            }
        }
    }

    private boolean P() {
        return !TextUtils.equals(this.f23376u, "none");
    }

    private boolean Q(@NonNull EditText editText) {
        if (this.f23366k.isEmpty()) {
            return false;
        }
        List<EditText> list = this.f23366k;
        return editText == list.get(list.size() - 1);
    }

    private void Z() {
        List<EditText> list = this.f23366k;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (EditText editText : this.f23366k) {
            editText.setShowSoftInputOnFocus(false);
            try {
                Field declaredField = View.class.getDeclaredField("mListenerInfo");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(editText);
                Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnKeyListener");
                declaredField2.setAccessible(true);
                if (this.f23368m.get(editText) == null && obj != null && declaredField2.get(obj) != null) {
                    this.f23368m.put(editText, (View.OnKeyListener) declaredField2.get(obj));
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e10) {
                e10.printStackTrace();
            }
            editText.setOnTouchListener(this.f23371p);
            editText.setOnLongClickListener(this.f23372q);
            editText.setOnKeyListener(this.f23373r);
        }
    }

    private void b0() {
        if (this.G != null) {
            setFocusKeyViewBackgroud(KeyUtils.f23281c);
        }
        if (getKeyboardType() != null) {
            KeyView keyView = this.f23363h.get(KeyUtils.A(getKeyboardType(), getResources().getConfiguration().orientation == 1).get(this.K).get(this.L).c());
            this.G = keyView;
            if (keyView != null) {
                setFocusKeyViewBackgroud(KeyUtils.f23280b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(int i10, int i11, int i12, int i13) {
        if (this.f23356a.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f23356a.getLayoutParams();
            layoutParams.setMargins(i10, i11, 0, 0);
            layoutParams.width = i12;
            layoutParams.height = i13;
            this.f23356a.setLayoutParams(layoutParams);
        } else if (this.f23356a.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f23356a.getLayoutParams();
            layoutParams2.setMargins(i10, i11, 0, 0);
            layoutParams2.width = i12;
            layoutParams2.height = i13;
            this.f23356a.setLayoutParams(layoutParams2);
        } else if (this.f23356a.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f23356a.getLayoutParams();
            layoutParams3.setMargins(i10, i11, 0, 0);
            layoutParams3.width = i12;
            layoutParams3.height = i13;
            this.f23356a.setLayoutParams(layoutParams3);
        }
        this.f23356a.requestLayout();
    }

    private int getPadding() {
        return 20;
    }

    private void n0() {
        KeyView keyView = this.f23362g.get(151);
        if (keyView != null) {
            keyView.b(this.I ? "Hide" : "Show");
        }
    }

    private void setFocusKeyViewBackgroud(int i10) {
        KeyView keyView = this.G;
        if (keyView != null) {
            keyView.setBackgroundResource(i10);
        }
    }

    private void setKeyboardType(String str) {
        this.F = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals("letterNumber")) {
            this.I = true;
        } else if (str.equals("letter")) {
            this.I = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(KeyView keyView) {
        if (keyView != null) {
            V(keyView);
            ziyi.kit.keyboard.a bean = keyView.getBean();
            int iC = bean.c();
            if (iC == 256) {
                e0(this.I ? "letterNumber" : "letter");
                return;
            }
            switch (iC) {
                case 144:
                    p();
                    break;
                case 145:
                    N(bean);
                    break;
                case 146:
                    e0(this.I ? "letterNumber" : "letter");
                    break;
                case 147:
                    u();
                    break;
                case 148:
                    n(bean);
                    break;
                case 149:
                    e0("ninePalaceNumberWithABC");
                    break;
                case 150:
                    l0(!this.H);
                    break;
                case 151:
                    i0();
                    n0();
                    break;
                case SyslogAppender.LOG_LOCAL3 /* 152 */:
                    break;
                case 153:
                    e0("symbol");
                    break;
                default:
                    N(bean);
                    break;
            }
        }
    }

    public void L(int i10, int i11) {
        this.A = i10;
        this.B = i11;
    }

    public void M(int i10, int i11) {
        this.C = i10;
        this.D = i11;
    }

    public void W() {
        this.f23366k.clear();
    }

    public void X() {
        int[] iArr = this.E;
        iArr[0] = 0;
        iArr[1] = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) childAt;
                int childCount = viewGroup.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    ((ViewGroup) viewGroup.getChildAt(i10)).removeAllViews();
                }
                viewGroup.removeAllViews();
            }
        }
        removeAllViews();
    }

    public void Y() {
        View view = this.f23356a;
        if (view == null || this.f23361f >= 0) {
            return;
        }
        int left = view.getLeft();
        int i10 = this.f23370o;
        int width = this.f23356a.getWidth();
        int height = this.f23356a.getHeight() * 2;
        this.f23361f = 0;
        c0(left, i10, width, height);
    }

    @Nullable
    public EditText getFocusedEditText() {
        EditText editText = this.f23369n;
        if (editText == null || !editText.hasFocus()) {
            for (EditText editText2 : this.f23366k) {
                if (editText2.hasFocus()) {
                    this.f23369n = editText2;
                    break;
                }
            }
        }
        EditText editText3 = this.f23369n;
        if (editText3 != null) {
            editText3.setSelectAllOnFocus(false);
            this.f23369n.setOnFocusChangeListener(this.M);
        }
        return this.f23369n;
    }

    public int[] getKeyboardSize() {
        return this.E;
    }

    public String getKeyboardType() {
        return this.F;
    }

    public Integer getTabTag() {
        return Integer.valueOf(this.f23359d);
    }

    public void h0(int i10) {
        View view = this.f23356a;
        if (view != null) {
            if (this.f23370o != -1) {
                this.f23370o = view.getTop();
            }
            EditText focusedEditText = getFocusedEditText();
            if (focusedEditText != null) {
                int[] iArr = {0, 0};
                focusedEditText.getLocationInWindow(iArr);
                this.f23360e = i10 - getHeight();
                int height = iArr[1] + focusedEditText.getHeight();
                int i11 = this.f23360e;
                if (height > i11) {
                    this.f23361f = (i11 - iArr[1]) - focusedEditText.getHeight();
                }
                int i12 = this.f23361f;
                if (i12 >= 0 || (-i12) >= i10 / 2) {
                    this.f23361f = 0;
                    return;
                }
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.f23361f);
                translateAnimation.setInterpolator(new OvershootInterpolator());
                translateAnimation.setDuration(200L);
                translateAnimation.setAnimationListener(new a());
                this.f23356a.startAnimation(translateAnimation);
            }
        }
    }

    public void l(EditText editText) {
        if (editText != null) {
            m(editText);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void m(@NonNull EditText editText) {
        if (this.f23366k.contains(editText)) {
            return;
        }
        this.f23366k.add(editText);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x005c  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Animator animator = this.f23365j;
        if (animator != null) {
            animator.cancel();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if (P() && !this.f23379x) {
                    o();
                }
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    if (P()) {
                        o();
                    }
                }
            } else if (P() && !this.f23379x && this.f23380y == motionEvent.getPointerId(0)) {
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                float f10 = this.f23377v - x10;
                float f11 = this.f23378w - y10;
                if (Math.abs(f10) < 8.0f && Math.abs(f11) < 8.0f) {
                    this.f23377v = x10;
                    this.f23378w = y10;
                } else if (!R()) {
                    this.f23379x = true;
                    C(false);
                }
            }
        } else if (P() && !this.f23379x) {
            this.f23380y = motionEvent.getPointerId(0);
            this.f23377v = motionEvent.getX();
            this.f23378w = motionEvent.getY();
        }
        return this.f23379x;
    }

    public void setDefaultUpperCase(boolean z10) {
        this.H = z10;
    }

    public void setDragSupportModel(String str) {
        this.f23376u = str;
    }

    public void setNormalKeyBackground(int i10) {
        if (i10 > 0) {
            KeyUtils.f23281c = i10;
        }
    }

    public void setTabTag(int i10) {
        this.f23359d = i10;
    }

    public b(Context context, boolean z10, @Nullable AttributeSet attributeSet) {
        this(context, z10, attributeSet, 0);
    }

    private void D() {
        if (!isInEditMode() && getParent() == null) {
            throw new IllegalStateException("Initialize first.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x00a0  */
    private void E(float f10, float f11) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int paddingLeft = viewGroup.getPaddingLeft();
        int width = viewGroup.getWidth() - viewGroup.getPaddingRight();
        int paddingTop = viewGroup.getPaddingTop();
        int height = viewGroup.getHeight() - viewGroup.getPaddingBottom();
        byte b10 = 2;
        int i10 = this.B + (this.D * 2);
        getHitRect(this.f23381z);
        Rect rect = this.f23381z;
        int i11 = rect.left;
        if (i11 + f10 < paddingLeft) {
            f10 = paddingLeft - i11;
        }
        int i12 = rect.right;
        if (i12 + f10 > width) {
            f10 = width - i12;
        }
        if (rect.top + f11 < paddingTop - ((this.E[1] - i10) - getPaddingBottom())) {
            f11 = (paddingTop - ((this.E[1] - i10) - getPaddingBottom())) - this.f23381z.top;
        }
        if (this.f23381z.bottom + f11 > ((this.E[1] + height) - i10) - getPaddingTop()) {
            f11 = (((height + this.E[1]) - i10) - getPaddingTop()) - this.f23381z.bottom;
        }
        String str = this.f23376u;
        str.getClass();
        switch (str.hashCode()) {
            case -1984141450:
                if (!str.equals("vertical")) {
                    b10 = -1;
                } else {
                    b10 = 0;
                }
                break;
            case 96673:
                if (!str.equals("all")) {
                    b10 = -1;
                } else {
                    b10 = 1;
                }
                break;
            case 1387629604:
                if (!str.equals("horizontal")) {
                    b10 = -1;
                }
                break;
            default:
                b10 = -1;
                break;
        }
        switch (b10) {
            case 0:
                setTranslationY(getTranslationY() + f11);
                break;
            case 1:
                setTranslationX(getTranslationX() + f10);
                setTranslationY(getTranslationY() + f11);
                break;
            case 2:
                setTranslationX(getTranslationX() + f10);
                break;
        }
    }

    private void F(Animator.AnimatorListener animatorListener) {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, getTranslationX(), 0.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, getTranslationX(), 0.0f)).setDuration(300L);
        duration.addListener(animatorListener);
        duration.start();
    }

    private boolean R() {
        if (getScaleX() < 1.0f) {
            return true;
        }
        return false;
    }

    private void V(KeyView keyView) {
        int iC = keyView.getBean().c();
        if (!KeyUtils.x(iC) && !KeyUtils.z(iC) && iC != 112) {
            Animator animator = this.f23364i.get(iC);
            if (animator != null) {
                animator.cancel();
            }
            float scaleX = keyView.getScaleX();
            float scaleY = keyView.getScaleY();
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(keyView, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, scaleX, scaleX * 1.2f, scaleX), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, scaleY, 1.2f * scaleY, scaleY)).setDuration(200L);
            duration.addListener(new l(iC, scaleX, scaleY));
            this.f23364i.put(iC, duration);
            duration.start();
        }
    }

    private void a0() {
        String keyboardType = getKeyboardType();
        boolean z10 = true;
        if (getResources().getConfiguration().orientation != 1) {
            z10 = false;
        }
        List<List<ziyi.kit.keyboard.a>> listA = KeyUtils.A(keyboardType, z10);
        if (listA != null && listA.size() > 0) {
            ziyi.kit.keyboard.a aVar = listA.get(0).get(0);
            setFocusKeyViewBackgroud(KeyUtils.f23281c);
            this.G = this.f23362g.get(aVar.c());
            this.K = 0;
            this.L = 0;
            setFocusKeyViewBackgroud(KeyUtils.f23280b);
        }
    }

    private void e0(String str) {
        String keyboardType = getKeyboardType();
        if (!str.equals(keyboardType)) {
            setKeyboardType(str);
            if ((!"ninePalaceNumber".equals(keyboardType) && !"ninePalaceNumber".equals(str)) || (getTranslationX() == 0.0f && getTranslationY() == 0.0f)) {
                s();
            } else {
                F(new c());
            }
        }
        f0();
        switch (str) {
            case "ninePalaceNumberWithABC":
                if (keyboardType == "letterNumber") {
                    setKeyFocus(146);
                    break;
                }
                break;
            case "letter":
                if (keyboardType == "letterNumber") {
                    setKeyFocus(151);
                    break;
                }
                break;
            case "symbol":
                if (keyboardType == "letterNumber") {
                    setKeyFocus(256);
                    break;
                }
                break;
            case "letterNumber":
                if (keyboardType == "ninePalaceNumberWithABC") {
                    setKeyFocus(149);
                    break;
                } else {
                    if (keyboardType == "symbol") {
                        setKeyFocus(153);
                    } else if (keyboardType == "letter") {
                        setKeyFocus(151);
                    }
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(EditText editText) {
        int inputType = editText.getInputType();
        int imeOptions = editText.getImeOptions();
        int i10 = inputType & 15;
        if (i10 != 2 && i10 != 3 && i10 != 4) {
            String keyboardType = getKeyboardType();
            if (TextUtils.isEmpty(keyboardType) || "ninePalaceNumber".equals(keyboardType)) {
                if (this.I) {
                    keyboardType = "letterNumber";
                } else {
                    keyboardType = "letter";
                }
            }
            e0(keyboardType);
        } else {
            e0("ninePalaceNumber");
        }
        if (this.f23366k.isEmpty()) {
            this.f23366k.size();
        }
        if (!Q(editText) && (imeOptions & 255) != 6) {
            this.f23362g.get(148).b("Next");
        } else {
            this.f23362g.get(148).b("Done");
        }
        this.f23369n = editText;
    }

    private int getStatusBarHeight() {
        int identifier = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getContext().getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void j0() {
        EditText focusedEditText = getFocusedEditText();
        this.f23369n = focusedEditText;
        if (focusedEditText != null && focusedEditText.getVisibility() == 0) {
            g0(this.f23369n);
            Z();
        }
    }

    private void l0(boolean z10) {
        int i10;
        D();
        this.H = z10;
        for (int i11 = 16; i11 <= 53; i11++) {
            KeyView keyView = this.f23362g.get(i11);
            if (keyView != null) {
                keyView.c(z10);
            }
        }
        KeyView keyView2 = this.f23362g.get(150);
        if (keyView2 != null) {
            if (z10) {
                i10 = R$drawable.key_icon_upper_case;
            } else {
                i10 = R$drawable.key_icon_lower_case;
            }
            keyView2.a(i10);
        }
    }

    private void o() {
        int paddingTop;
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.getPaddingLeft();
        viewGroup.getWidth();
        viewGroup.getPaddingRight();
        viewGroup.getPaddingTop();
        int height = viewGroup.getHeight() - viewGroup.getPaddingBottom();
        int i10 = this.B + (this.D * 2);
        getHitRect(this.f23381z);
        int i11 = height - this.f23381z.top;
        int i12 = i10 * 2;
        if (i11 <= this.E[1] + i12 + getPaddingBottom()) {
            int i13 = i10 / 2;
            if (i11 >= (this.E[1] - i13) - getPaddingBottom()) {
                paddingTop = this.E[1];
            } else if (i11 >= getPaddingTop() + i10) {
                int paddingTop2 = i11 - getPaddingTop();
                int i14 = paddingTop2 / i10;
                if (paddingTop2 % i10 >= i13) {
                    i14++;
                }
                paddingTop = getPaddingTop() + (i14 * i10);
            } else {
                paddingTop = i10 + getPaddingTop();
            }
            int i15 = (height - paddingTop) - this.f23381z.top;
            if (Math.abs(i15) <= i12 + getPaddingTop()) {
                ObjectAnimator duration = ObjectAnimator.ofFloat(this, (Property<b, Float>) View.TRANSLATION_Y, getTranslationY(), getTranslationY() + i15).setDuration(Math.abs(i15));
                duration.addListener(new k());
                duration.start();
            }
        }
    }

    private void r(LinearLayout linearLayout, int i10, int i11, ziyi.kit.keyboard.a aVar, int i12) {
        LinearLayout.LayoutParams layoutParams;
        i iVar;
        int i13;
        int iC = aVar.c();
        KeyView keyView = this.f23362g.get(iC);
        if (keyView == null) {
            keyView = new KeyView(getContext());
            keyView.setTypeface(this.f23375t);
            keyView.getTextKeyView().setTextColor(H(iC));
            keyView.getTextKeyView().setTextSize(1, I(iC));
            keyView.setOnClickListener(this.f23374s);
            if (iC == 147) {
                iVar = new i();
            } else {
                iVar = null;
            }
            keyView.setOnLongClickListener(iVar);
            keyView.setEnabled(KeyUtils.w(iC));
            if (iC == 294) {
                i13 = 4;
            } else {
                i13 = 0;
            }
            keyView.setVisibility(i13);
            keyView.setBackgroundResource(G(iC));
            keyView.setBean(aVar);
            this.f23363h.put(iC, keyView);
            if (!KeyUtils.z(aVar.c())) {
                this.f23362g.put(iC, keyView);
            }
        } else if (keyView.getParent() != null) {
            ((ViewGroup) keyView.getParent()).removeView(keyView);
        }
        keyView.setOnKeyListener(new j(i11, i10));
        if (i10 == this.K && i11 == this.L) {
            setFocusKeyViewBackgroud(KeyUtils.f23281c);
            this.G = keyView;
            setFocusKeyViewBackgroud(KeyUtils.f23280b);
        }
        ViewGroup.LayoutParams layoutParams2 = keyView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new LinearLayout.LayoutParams(0, i12);
        }
        layoutParams.weight = aVar.b();
        int i14 = this.C;
        layoutParams.leftMargin = i14;
        layoutParams.rightMargin = i14;
        int i15 = this.D;
        layoutParams.topMargin = i15;
        layoutParams.bottomMargin = i15;
        linearLayout.addView(keyView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        boolean z10;
        boolean z11;
        X();
        String keyboardType = getKeyboardType();
        int i10 = 0;
        boolean z12 = true;
        if (getResources().getConfiguration().orientation == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        List<List<ziyi.kit.keyboard.a>> listA = KeyUtils.A(keyboardType, z10);
        float fJ = J(listA);
        int size = listA.size();
        this.f23357b = size;
        int i11 = (int) fJ;
        if (fJ > i11) {
            i11++;
            fJ = i11;
        }
        this.E[0] = getPadding() + ((this.A + (this.C * 2)) * i11) + getPadding();
        if (this.E[0] > getResources().getDisplayMetrics().widthPixels) {
            this.A = (((getResources().getDisplayMetrics().widthPixels - getPadding()) - getPadding()) - ((this.C * 2) * i11)) / i11;
            this.E[0] = getPadding() + ((this.A + (this.C * 2)) * i11) + getPadding();
        }
        this.E[1] = getPadding() + ((this.B + (this.D * 2)) * size) + getPadding();
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        for (int i12 = 0; i12 < size; i12++) {
            List<ziyi.kit.keyboard.a> list = listA.get(i12);
            this.f23358c.put(Integer.valueOf(i12), Integer.valueOf(list.size()));
            LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
            linearLayout2.setOrientation(0);
            linearLayout2.setWeightSum(fJ);
            linearLayout.addView(linearLayout2, new FrameLayout.LayoutParams(this.E[0], -2));
            for (int i13 = 0; i13 < list.size(); i13++) {
                r(linearLayout2, i12, i13, list.get(i13), this.B);
            }
        }
        if (this.K >= this.f23357b) {
            this.K = 0;
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.L >= this.f23358c.get(Integer.valueOf(this.K)).intValue()) {
            this.L = 0;
        } else {
            z12 = z11;
        }
        if (z12) {
            setFocusKeyViewBackgroud(KeyUtils.f23281c);
            this.G = this.f23362g.get(listA.get(this.K).get(this.L).c());
            setFocusKeyViewBackgroud(KeyUtils.f23280b);
        }
        addView(linearLayout);
        l0(this.H);
        n0();
        int i14 = (getResources().getDisplayMetrics().widthPixels - this.E[0]) / 2;
        if (i14 > 0) {
            i10 = i14;
        }
        setPadding(i10, 20, i10, 20);
        linearLayout.bringToFront();
        requestLayout();
        linearLayout.invalidate();
    }

    private void setKeyFocus(int i10) {
        String keyboardType = getKeyboardType();
        boolean z10 = true;
        if (getResources().getConfiguration().orientation != 1) {
            z10 = false;
        }
        List<List<ziyi.kit.keyboard.a>> listA = KeyUtils.A(keyboardType, z10);
        int size = listA.size();
        for (int i11 = 0; i11 < size; i11++) {
            List<ziyi.kit.keyboard.a> list = listA.get(i11);
            for (int i12 = 0; i12 < list.size(); i12++) {
                ziyi.kit.keyboard.a aVar = list.get(i12);
                if (aVar.c() == i10) {
                    setFocusKeyViewBackgroud(KeyUtils.f23281c);
                    this.G = this.f23362g.get(aVar.c());
                    this.K = i11;
                    this.L = i12;
                    setFocusKeyViewBackgroud(KeyUtils.f23280b);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0054  */
    boolean A(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                    int i10 = this.K;
                    if (i10 > 0) {
                        this.K = i10 - 1;
                        b0();
                    }
                    break;
                case 20:
                    int i11 = this.K;
                    if (i11 < this.f23357b - 1) {
                        this.K = i11 + 1;
                        b0();
                    }
                    break;
                case 21:
                    int i12 = this.L;
                    if (i12 > 0) {
                        this.L = i12 - 1;
                        b0();
                    }
                    break;
                case 22:
                    if (this.L < this.f23358c.get(Integer.valueOf(this.K)).intValue() - 1) {
                        this.L++;
                        b0();
                    }
                    break;
                case 23:
                    v(this.G);
                    break;
                default:
                    x(keyEvent);
                    break;
            }
        } else {
            v(this.G);
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:51:0x00b9  */
    boolean B(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                    int i10 = this.K;
                    if (i10 > 0) {
                        if (i10 != 1) {
                            if (i10 != 2) {
                                this.K = i10 - 1;
                                b0();
                            } else {
                                int i11 = this.L;
                                if (i11 >= 2 && i11 <= 5) {
                                    this.L = i11 - 1;
                                } else if (i11 > 5) {
                                    this.L = i11 - 2;
                                }
                                this.K = i10 - 1;
                                b0();
                            }
                        } else {
                            int i12 = this.L;
                            if (i12 >= 2 && i12 <= 3) {
                                this.L = i12 + 1;
                            } else if (i12 > 3) {
                                this.L = i12 + 2;
                            }
                            this.K = i10 - 1;
                            b0();
                        }
                    }
                    break;
                case 20:
                    int i13 = this.K;
                    if (i13 < this.f23357b - 1) {
                        if (i13 != 0) {
                            if (i13 != 1) {
                                this.K = i13 + 1;
                                b0();
                            } else {
                                int i14 = this.L;
                                if (i14 >= 2 && i14 <= 3) {
                                    this.L = i14 + 1;
                                } else if (i14 > 3) {
                                    this.L = i14 + 2;
                                }
                                this.K = i13 + 1;
                                b0();
                            }
                        } else {
                            int i15 = this.L;
                            if (i15 >= 2 && i15 <= 4) {
                                this.L = i15 - 1;
                            } else if (i15 > 4) {
                                this.L = i15 - 2;
                            }
                            this.K = i13 + 1;
                            b0();
                        }
                    }
                    break;
                case 21:
                    int i16 = this.L;
                    if (i16 > 0) {
                        this.L = i16 - 1;
                        b0();
                    }
                    break;
                case 22:
                    if (this.L < this.f23358c.get(Integer.valueOf(this.K)).intValue() - 1) {
                        this.L++;
                        b0();
                    }
                    break;
                case 23:
                    v(this.G);
                    break;
            }
        } else {
            v(this.G);
        }
        return true;
    }

    public final void N(ziyi.kit.keyboard.a aVar) {
        EditText focusedEditText = getFocusedEditText();
        if (focusedEditText != null) {
            Editable text = focusedEditText.getText();
            int selectionStart = focusedEditText.getSelectionStart();
            int selectionEnd = focusedEditText.getSelectionEnd();
            CharSequence charSequenceE = aVar.e();
            if (selectionEnd > selectionStart) {
                text.replace(selectionStart, selectionEnd, charSequenceE);
            } else {
                text.insert(selectionStart, charSequenceE);
            }
            if (KeyUtils.y(aVar.c())) {
                int selectionStart2 = focusedEditText.getSelectionStart();
                if (selectionStart2 - selectionStart == 2) {
                    focusedEditText.setSelection(selectionStart2 - 1);
                }
            }
        }
    }

    public final void O(CharSequence charSequence) {
        EditText focusedEditText = getFocusedEditText();
        if (focusedEditText != null) {
            Editable text = focusedEditText.getText();
            int selectionStart = focusedEditText.getSelectionStart();
            int selectionEnd = focusedEditText.getSelectionEnd();
            if (selectionEnd > selectionStart) {
                text.replace(selectionStart, selectionEnd, charSequence);
            } else {
                text.insert(selectionStart, charSequence);
            }
            int selectionStart2 = focusedEditText.getSelectionStart();
            if (selectionStart2 - selectionStart == 2) {
                focusedEditText.setSelection(selectionStart2 - 1);
            }
        }
    }

    public void S() {
        W();
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    public void T() {
        p();
    }

    public void U() {
        EditText focusedEditText = getFocusedEditText();
        if (focusedEditText != null) {
            focusedEditText.requestFocus();
            g0(focusedEditText);
            Z();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:33:0x0070  */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        EditText focusedEditText;
        if (keyEvent.getAction() == 0) {
            if (getVisibility() == 0) {
                if (keyEvent.getKeyCode() != 4 && keyEvent.getKeyCode() != 111) {
                    if (keyEvent.getKeyCode() == 67) {
                        u();
                        return true;
                    }
                    EditText focusedEditText2 = getFocusedEditText();
                    if (focusedEditText2 != null && (focusedEditText2 instanceof AppCompatAutoCompleteTextView)) {
                        AppCompatAutoCompleteTextView appCompatAutoCompleteTextView = (AppCompatAutoCompleteTextView) focusedEditText2;
                        if (appCompatAutoCompleteTextView.isPopupShowing() && ((keyEvent.getKeyCode() != 23 && keyEvent.getKeyCode() != 66) || appCompatAutoCompleteTextView.getListSelection() != -1)) {
                            return focusedEditText2.onKeyDown(keyEvent.getKeyCode(), keyEvent);
                        }
                    }
                    if (getKeyboardType() != null) {
                        String keyboardType = getKeyboardType();
                        keyboardType.getClass();
                        switch (keyboardType) {
                            case "ninePalaceNumberWithABC":
                                A(keyEvent);
                                break;
                            case "ninePalaceNumber":
                                z(keyEvent);
                                break;
                            case "letter":
                                y(keyEvent);
                                break;
                            case "symbol":
                                B(keyEvent);
                                break;
                            case "letterNumber":
                                w(keyEvent);
                                break;
                        }
                    }
                    return true;
                }
                p();
                return true;
            }
        } else if (keyEvent.getAction() == 1 && (focusedEditText = getFocusedEditText()) != null && (focusedEditText instanceof AppCompatAutoCompleteTextView) && ((AppCompatAutoCompleteTextView) focusedEditText).isPopupShowing()) {
            return focusedEditText.onKeyUp(keyEvent.getKeyCode(), keyEvent);
        }
        return true;
    }

    public void f0() {
        if (getVisibility() != 0) {
            d0();
        }
        bringToFront();
    }

    public final void i0() {
        if ("letterNumber".equals(getKeyboardType())) {
            this.I = false;
            e0("letter");
        } else if ("letter".equals(getKeyboardType())) {
            this.I = true;
            e0("letterNumber");
        }
    }

    public void k0() {
        String string;
        if (getVisibility() != 0) {
            j0();
        }
        EditText focusedEditText = getFocusedEditText();
        if (focusedEditText != null && focusedEditText.getText() != null && (focusedEditText instanceof AppCompatAutoCompleteTextView) && (string = focusedEditText.getText().toString()) != null && string.endsWith("@") && string.indexOf("@") == string.length() - 1) {
            ((AppCompatAutoCompleteTextView) focusedEditText).showDropDown();
        }
    }

    public void m0() {
        if (getVisibility() == 0) {
            p();
        } else {
            k0();
        }
    }

    public final void n(ziyi.kit.keyboard.a aVar) {
        EditText focusedEditText = getFocusedEditText();
        if (focusedEditText != null && !"Done".equals(aVar.d().toString())) {
            this.f23369n = null;
            int i10 = 0;
            while (true) {
                if (i10 < this.f23366k.size()) {
                    if (focusedEditText == this.f23366k.get(i10)) {
                        break;
                    } else {
                        i10++;
                    }
                } else {
                    i10 = -1;
                    break;
                }
            }
            int i11 = i10 + 1;
            if (i11 >= this.f23366k.size()) {
                K();
                return;
            }
            this.f23366k.get(i11).requestFocus();
            this.f23366k.get(i11).moveCursorToVisibleOffset();
            setFocusKeyViewBackgroud(KeyUtils.f23281c);
            g0(this.f23366k.get(i11));
            a0();
            postDelayed(new RunnableC0495b(), 100L);
            return;
        }
        K();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0039  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!R() && P()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked == 3) {
                            if (this.f23379x) {
                                o();
                                this.f23379x = false;
                                C(true);
                            }
                        }
                    } else if (this.f23380y == motionEvent.getPointerId(0)) {
                        float x10 = motionEvent.getX();
                        float y10 = motionEvent.getY();
                        E(-(this.f23377v - x10), -(this.f23378w - y10));
                    }
                } else if (this.f23379x && this.f23380y == motionEvent.getPointerId(0)) {
                    o();
                    this.f23379x = false;
                    C(true);
                }
            } else if (this.f23380y == motionEvent.getPointerId(0)) {
                this.f23377v = motionEvent.getX();
                this.f23378w = motionEvent.getY();
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p() {
        EditText focusedEditText = getFocusedEditText();
        if (focusedEditText != null && (focusedEditText instanceof AppCompatAutoCompleteTextView)) {
            AppCompatAutoCompleteTextView appCompatAutoCompleteTextView = (AppCompatAutoCompleteTextView) focusedEditText;
            if (appCompatAutoCompleteTextView.isPopupShowing()) {
                appCompatAutoCompleteTextView.dismissDropDown();
                return;
            }
        }
        if (getVisibility() == 0) {
            K();
        }
    }

    public Boolean q() {
        EditText focusedEditText = getFocusedEditText();
        if (focusedEditText != null && (focusedEditText instanceof AppCompatAutoCompleteTextView)) {
            AppCompatAutoCompleteTextView appCompatAutoCompleteTextView = (AppCompatAutoCompleteTextView) focusedEditText;
            if (appCompatAutoCompleteTextView.isPopupShowing()) {
                appCompatAutoCompleteTextView.dismissDropDown();
                return Boolean.TRUE;
            }
        }
        if (getVisibility() == 0) {
            K();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public final void t() {
        EditText focusedEditText = getFocusedEditText();
        if (focusedEditText != null) {
            Editable text = focusedEditText.getText();
            int selectionStart = focusedEditText.getSelectionStart();
            int selectionEnd = focusedEditText.getSelectionEnd();
            if (selectionEnd > selectionStart) {
                text.delete(selectionStart, selectionEnd);
            } else {
                text.delete(0, selectionStart);
                focusedEditText.setSelection(0);
            }
        }
    }

    public final void u() {
        EditText focusedEditText = getFocusedEditText();
        if (focusedEditText != null) {
            Editable text = focusedEditText.getText();
            int selectionStart = focusedEditText.getSelectionStart();
            int selectionEnd = focusedEditText.getSelectionEnd();
            if (selectionEnd > selectionStart) {
                text.delete(selectionStart, selectionEnd);
                return;
            }
            int i10 = selectionStart - 1;
            if (i10 < 0) {
                i10 = 0;
            }
            text.delete(i10, selectionStart);
            if (i10 > text.length()) {
                focusedEditText.setSelection(text.length());
            } else {
                focusedEditText.setSelection(i10);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00bf  */
    boolean w(KeyEvent keyEvent) {
        int i10;
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                    int i11 = this.K;
                    if (i11 > 0) {
                        if (i11 != 2) {
                            if (i11 != 4) {
                                this.K = i11 - 1;
                                b0();
                            } else {
                                int i12 = this.L;
                                if (i12 == 0) {
                                    this.L = 0;
                                } else if (i12 != 1 && i12 != 2) {
                                    if (i12 == 3) {
                                        this.L = 6;
                                    } else {
                                        this.L = 9;
                                    }
                                } else {
                                    this.L = i12 + 1;
                                }
                                this.K = i11 - 1;
                                b0();
                            }
                        } else {
                            if (this.L == 9) {
                                this.L = 10;
                            }
                            this.K = i11 - 1;
                            b0();
                        }
                    }
                    break;
                case 20:
                    int i13 = this.K;
                    if (i13 < this.f23357b - 1) {
                        if (i13 != 1) {
                            if (i13 == 3 && (i10 = this.L) > 1) {
                                if (i10 > 1 && i10 < 4) {
                                    this.L = i10 - 1;
                                } else if (i10 >= 4 && i10 <= 7) {
                                    this.L = 3;
                                } else {
                                    this.L = 4;
                                }
                            }
                            this.K = i13 + 1;
                            b0();
                        } else {
                            int i14 = this.L;
                            if (i14 == 9 || i14 == 10) {
                                this.L = 9;
                            }
                            this.K = i13 + 1;
                            b0();
                        }
                    }
                    break;
                case 21:
                    int i15 = this.L;
                    if (i15 > 0) {
                        this.L = i15 - 1;
                        b0();
                    }
                    break;
                case 22:
                    if (this.L < this.f23358c.get(Integer.valueOf(this.K)).intValue() - 1) {
                        this.L++;
                        b0();
                    }
                    break;
                case 23:
                    v(this.G);
                    break;
                default:
                    x(keyEvent);
                    break;
            }
        } else {
            v(this.G);
        }
        return true;
    }

    public void x(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 67) {
            switch (keyCode) {
                case 7:
                    O("0");
                    break;
                case 8:
                    O("1");
                    break;
                case 9:
                    O(ExifInterface.GPS_MEASUREMENT_2D);
                    break;
                case 10:
                    O(ExifInterface.GPS_MEASUREMENT_3D);
                    break;
                case 11:
                    O("4");
                    break;
                case 12:
                    O("5");
                    break;
                case 13:
                    O("6");
                    break;
                case 14:
                    O("7");
                    break;
                case 15:
                    O("8");
                    break;
                case 16:
                    O("9");
                    break;
            }
            return;
        }
        u();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:58:0x00c2  */
    boolean y(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                    int i10 = this.K;
                    if (i10 > 0) {
                        if (i10 != 1) {
                            if (i10 != 2) {
                                if (i10 == 3) {
                                    int i11 = this.L;
                                    if (i11 == 0) {
                                        this.L = 0;
                                    } else if (i11 != 1 && i11 != 2) {
                                        if (i11 == 3) {
                                            this.L = 6;
                                        } else {
                                            this.L = 9;
                                        }
                                    } else {
                                        this.L = i11 + 1;
                                    }
                                    this.K = i10 - 1;
                                    b0();
                                }
                            } else {
                                this.K = i10 - 1;
                                b0();
                            }
                        } else {
                            if (this.L == 9) {
                                this.L = 10;
                            }
                            this.K = i10 - 1;
                            b0();
                        }
                    }
                    break;
                case 20:
                    int i12 = this.K;
                    if (i12 < this.f23357b - 1) {
                        if (i12 != 0) {
                            if (i12 != 1) {
                                if (i12 == 2) {
                                    int i13 = this.L;
                                    if (i13 > 1) {
                                        if (i13 > 1 && i13 < 4) {
                                            this.L = i13 - 1;
                                        } else if (i13 >= 4 && i13 <= 7) {
                                            this.L = 3;
                                        } else {
                                            this.L = 4;
                                        }
                                    }
                                    this.K = i12 + 1;
                                    b0();
                                }
                            } else {
                                this.K = i12 + 1;
                                b0();
                            }
                        } else {
                            int i14 = this.L;
                            if (i14 == 9 || i14 == 10) {
                                this.L = 9;
                            }
                            this.K = i12 + 1;
                            b0();
                        }
                    }
                    break;
                case 21:
                    int i15 = this.L;
                    if (i15 > 0) {
                        this.L = i15 - 1;
                        b0();
                    }
                    break;
                case 22:
                    if (this.L < this.f23358c.get(Integer.valueOf(this.K)).intValue() - 1) {
                        this.L++;
                        b0();
                    }
                    break;
                case 23:
                    v(this.G);
                    break;
            }
        } else {
            v(this.G);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0074  */
    boolean z(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                    int i10 = this.K;
                    if (i10 > 0) {
                        if (i10 == 3 && this.L == 2) {
                            this.L = 3;
                        }
                        this.K = i10 - 1;
                        b0();
                    }
                    break;
                case 20:
                    int i11 = this.K;
                    if (i11 < this.f23357b - 1) {
                        if (i11 == 2 && this.L == 3) {
                            this.L = 2;
                        }
                        this.K = i11 + 1;
                        b0();
                    }
                    break;
                case 21:
                    int i12 = this.L;
                    if (i12 > 0) {
                        this.L = i12 - 1;
                        b0();
                    }
                    break;
                case 22:
                    if (this.L < this.f23358c.get(Integer.valueOf(this.K)).intValue() - 1) {
                        this.L++;
                        b0();
                    }
                    break;
                case 23:
                    v(this.G);
                    break;
                default:
                    x(keyEvent);
                    break;
            }
        } else {
            v(this.G);
        }
        return true;
    }

    public b(Context context, boolean z10, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f23358c = new HashMap<>();
        this.f23362g = new SparseArray<>();
        this.f23363h = new SparseArray<>();
        this.f23364i = new SparseArray<>();
        this.f23365j = null;
        this.f23366k = new ArrayList(20);
        this.f23367l = new ArrayList(20);
        this.f23368m = new HashMap<>();
        this.f23369n = null;
        this.f23370o = -1;
        this.f23371p = new d();
        this.f23372q = new e();
        this.f23373r = new f();
        this.f23374s = new g();
        this.f23375t = null;
        this.f23376u = "vertical";
        this.f23380y = -1;
        this.f23381z = new Rect();
        this.E = new int[2];
        this.G = null;
        this.H = false;
        this.I = true;
        this.J = false;
        this.K = 0;
        this.L = 0;
        this.M = new h();
        this.J = z10;
        setBackgroundResource(KeyUtils.f23279a);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int iApplyDimension = (int) TypedValue.applyDimension(1, displayMetrics.widthPixels <= displayMetrics.heightPixels ? 42 : 67, context.getResources().getDisplayMetrics());
        int iApplyDimension2 = (int) TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.KeyboardView, i10, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.KeyboardView_keyWidth, iApplyDimension);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.KeyboardView_keyHeight, 0);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.KeyboardView_keyHorizontalSpace, iApplyDimension2);
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.KeyboardView_keyVerticalSpace, iApplyDimension2);
        int i11 = typedArrayObtainStyledAttributes.getInt(R$styleable.KeyboardView_keyboardType, 0);
        typedArrayObtainStyledAttributes.recycle();
        L(dimensionPixelSize, dimensionPixelSize2 <= 0 ? (dimensionPixelSize * 3) / 5 : dimensionPixelSize2);
        M(dimensionPixelSize3, dimensionPixelSize4);
        if (isInEditMode()) {
            if (i11 == 0) {
                e0("ninePalaceNumber");
            } else if (i11 == 1) {
                this.I = false;
                e0("letter");
            } else if (i11 == 2) {
                this.I = true;
                e0("letterNumber");
            } else if (i11 == 3) {
                e0("symbol");
            }
        }
        setPadding(20, 20, 20, 20);
    }

    public void setCreateKeyListener(o oVar) {
    }

    public void setKeyDownListener(m mVar) {
    }

    public void setKeyboardListener(n nVar) {
    }
}
