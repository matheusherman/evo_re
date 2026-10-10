package ziyi.kit.keyboard;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Configuration;
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.net.SyslogAppender;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class KeyboardView extends LinearLayout {
    private KeyView A;
    private boolean B;
    private boolean C;
    private View.OnFocusChangeListener D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SparseArray<KeyView> f23308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SparseArray<Animator> f23309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Animator f23310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<EditText> f23311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private EditText f23312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View.OnTouchListener f23313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View.OnLongClickListener f23314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View.OnClickListener f23315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f23316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f23317j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f23318k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f23319l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f23320m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Typeface f23321n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f23322o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f23323p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f23324q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f23325r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f23326s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Rect f23327t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f23328u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f23329v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f23330w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f23331x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int[] f23332y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f23333z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            KeyboardView.this.l();
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
    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!(view instanceof EditText)) {
                return false;
            }
            if (!view.hasFocus()) {
                view.requestFocus();
            }
            KeyboardView.this.J((EditText) view);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements View.OnLongClickListener {
        c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (!(view instanceof EditText)) {
                return false;
            }
            if (!view.hasFocus()) {
                view.requestFocus();
            }
            KeyboardView.this.J((EditText) view);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            KeyboardView.this.o((KeyView) view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements View.OnFocusChangeListener {
        e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (!(view instanceof EditText) || z10 || KeyboardView.this.f23312e == null) {
                return;
            }
            KeyboardView.this.getVisibility();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f implements View.OnKeyListener {
        f() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (KeyboardView.this.getVisibility() == 0) {
                return false;
            }
            if ((keyEvent.getKeyCode() != 23 && keyEvent.getKeyCode() != 66) || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 5) {
                return false;
            }
            KeyboardView keyboardView = KeyboardView.this;
            keyboardView.J(keyboardView.f23312e);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class g implements View.OnLongClickListener {
        g() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            KeyboardView.this.m();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class h implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f23341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f23342b;

        h(int i10, int i11) {
            this.f23341a = i10;
            this.f23342b = i11;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() != 21 || this.f23341a != 0) {
                if (keyEvent.getKeyCode() == 19 && this.f23342b == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class i implements Animator.AnimatorListener {
        i() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            KeyboardView.this.f23310c = null;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            KeyboardView.this.f23310c = null;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            KeyboardView.this.f23310c = animator;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class j implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f23345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f23346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f23347c;

        public j(int i10, float f10, float f11) {
            this.f23345a = i10;
            this.f23346b = f10;
            this.f23347c = f11;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            KeyboardView.this.f23309b.remove(this.f23345a);
            KeyView keyView = (KeyView) KeyboardView.this.f23308a.get(this.f23345a);
            if (keyView != null) {
                keyView.setScaleX(this.f23346b);
                keyView.setScaleY(this.f23347c);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            KeyboardView.this.f23309b.remove(this.f23345a);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface k {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface l {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface m {
    }

    public KeyboardView(Context context) {
        this(context, null);
    }

    private void G() {
        setVisibility(0);
        KeyView keyView = this.A;
        if (keyView != null) {
            keyView.setSelected(true);
        }
        bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.A = null;
        F();
        List<List<ziyi.kit.keyboard.a>> listA = KeyUtils.A(getKeyboardType(), getResources().getConfiguration().orientation == 1);
        float fW = w(listA);
        int size = listA.size();
        int i10 = (int) fW;
        if (fW > i10) {
            i10++;
            fW = i10;
        }
        this.f23332y[0] = getPadding() + ((this.f23328u + (this.f23330w * 2)) * i10) + getPadding();
        if (this.f23332y[0] > getResources().getDisplayMetrics().widthPixels) {
            this.f23328u = (((getResources().getDisplayMetrics().widthPixels - getPadding()) - getPadding()) - ((this.f23330w * 2) * i10)) / i10;
            this.f23332y[0] = getPadding() + ((this.f23328u + (this.f23330w * 2)) * i10) + getPadding();
        }
        this.f23332y[1] = getPadding() + ((this.f23329v + (this.f23331x * 2)) * size) + getPadding();
        for (int i11 = 0; i11 < size; i11++) {
            List<ziyi.kit.keyboard.a> list = listA.get(i11);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            linearLayout.setWeightSum(fW);
            addView(linearLayout, new LinearLayout.LayoutParams(this.f23332y[0], -2));
            for (int i12 = 0; i12 < list.size(); i12++) {
                k(linearLayout, i11, i12, list.get(i12), this.f23329v);
            }
        }
        L(this.B);
        M();
        int i13 = (getResources().getDisplayMetrics().widthPixels - this.f23332y[0]) / 2;
        int i14 = i13 > 0 ? i13 : 0;
        setPadding(i14, 20, i14, 20);
    }

    private void p(boolean z10) {
        for (int i10 = 0; i10 < this.f23308a.size(); i10++) {
            SparseArray<KeyView> sparseArray = this.f23308a;
            sparseArray.get(sparseArray.keyAt(i10)).setEnabled(z10);
        }
    }

    private float w(List<List<ziyi.kit.keyboard.a>> list) {
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

    public KeyboardView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean B() {
        return !TextUtils.equals(this.f23322o, "none");
    }

    private boolean C(@NonNull EditText editText) {
        if (this.f23311d.isEmpty()) {
            return false;
        }
        List<EditText> list = this.f23311d;
        return editText == list.get(list.size() - 1);
    }

    private void M() {
        KeyView keyView = this.f23308a.get(151);
        if (keyView != null) {
            keyView.b(this.C ? "Hide" : "Show");
        }
    }

    @Nullable
    private EditText getFocusedEditText() {
        EditText editText = this.f23312e;
        if (editText == null || !editText.hasFocus()) {
            for (EditText editText2 : this.f23311d) {
                if (editText2.hasFocus()) {
                    this.f23312e = editText2;
                    break;
                }
            }
        }
        this.f23312e.setSelectAllOnFocus(false);
        this.f23312e.setOnFocusChangeListener(this.D);
        return this.f23312e;
    }

    @Nullable
    private EditText getFocusedEditText2() {
        EditText editText = this.f23312e;
        if (editText != null) {
            editText.setSelectAllOnFocus(false);
            this.f23312e.setOnKeyListener(new f());
            this.f23312e.setOnFocusChangeListener(this.D);
        }
        return this.f23312e;
    }

    private int getPadding() {
        return 20;
    }

    private void setKeyboardType(String str) {
        this.f23333z = str;
        if (str.equals("letterNumber")) {
            this.C = true;
        } else if (str.equals("letter")) {
            this.C = false;
        }
    }

    private int t(int i10) {
        if (i10 == 148) {
            return this.f23319l;
        }
        return KeyUtils.x(i10) ? this.f23320m : this.f23318k;
    }

    private int u(int i10) {
        return i10 == 148 ? this.f23317j : this.f23316i;
    }

    private float v(int i10) {
        return 20.0f;
    }

    private void x() {
        setVisibility(8);
    }

    public void F() {
        int[] iArr = this.f23332y;
        iArr[0] = 0;
        iArr[1] = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ViewGroup) {
                ((ViewGroup) childAt).removeAllViews();
            }
        }
        removeAllViews();
    }

    public int[] getKeyboardSize() {
        return this.f23332y;
    }

    public String getKeyboardType() {
        return this.f23333z;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x005c  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Animator animator = this.f23310c;
        if (animator != null) {
            animator.cancel();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if (B() && !this.f23325r) {
                    i();
                }
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    if (B()) {
                        i();
                    }
                }
            } else if (B() && !this.f23325r && this.f23326s == motionEvent.getPointerId(0)) {
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                float f10 = this.f23323p - x10;
                float f11 = this.f23324q - y10;
                if (Math.abs(f10) < 8.0f && Math.abs(f11) < 8.0f) {
                    this.f23323p = x10;
                    this.f23324q = y10;
                } else if (!D()) {
                    this.f23325r = true;
                    p(false);
                }
            }
        } else if (B() && !this.f23325r) {
            this.f23326s = motionEvent.getPointerId(0);
            this.f23323p = motionEvent.getX();
            this.f23324q = motionEvent.getY();
        }
        return this.f23325r;
    }

    public void setDefaultUpperCase(boolean z10) {
        this.B = z10;
    }

    public void setDragSupportModel(String str) {
        this.f23322o = str;
    }

    public void setFunctionKeyBackground(int i10) {
        if (i10 > 0) {
            this.f23320m = i10;
        }
    }

    public void setKeyNextColor(int i10) {
        this.f23317j = i10;
    }

    public void setKeyTextColor(int i10) {
        this.f23316i = i10;
    }

    public void setNextKeyBackground(int i10) {
        if (i10 > 0) {
            this.f23319l = i10;
        }
    }

    public void setNormalKeyBackground(int i10) {
        if (i10 > 0) {
            this.f23318k = i10;
        }
    }

    public void y(int i10, int i11) {
        this.f23328u = i10;
        this.f23329v = i11;
    }

    public void z(int i10, int i11) {
        this.f23330w = i10;
        this.f23331x = i11;
    }

    public KeyboardView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f23308a = new SparseArray<>();
        this.f23309b = new SparseArray<>();
        this.f23310c = null;
        this.f23311d = new ArrayList(20);
        this.f23312e = null;
        this.f23313f = new b();
        this.f23314g = new c();
        this.f23315h = new d();
        this.f23316i = -514;
        this.f23317j = -514;
        this.f23318k = R$drawable.key_normal_key_background_selector;
        this.f23319l = R$drawable.key_next_key_background_ripple;
        this.f23320m = R$drawable.key_special_key_background_ripple;
        this.f23321n = null;
        this.f23322o = "vertical";
        this.f23326s = -1;
        this.f23327t = new Rect();
        this.f23332y = new int[2];
        this.A = null;
        this.B = false;
        this.C = false;
        this.D = new e();
        setOrientation(1);
        setBackgroundResource(R$drawable.key_keyboard_background_shape);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int iApplyDimension = (int) TypedValue.applyDimension(1, displayMetrics.widthPixels <= displayMetrics.heightPixels ? 50 : 80, context.getResources().getDisplayMetrics());
        int iApplyDimension2 = (int) TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.KeyboardView, i10, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.KeyboardView_keyWidth, iApplyDimension);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.KeyboardView_keyHeight, 0);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.KeyboardView_keyHorizontalSpace, iApplyDimension2);
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.KeyboardView_keyVerticalSpace, iApplyDimension2);
        int i11 = typedArrayObtainStyledAttributes.getInt(R$styleable.KeyboardView_keyboardType, 0);
        typedArrayObtainStyledAttributes.recycle();
        y(dimensionPixelSize, dimensionPixelSize2 <= 0 ? (dimensionPixelSize * 3) / 5 : dimensionPixelSize2);
        z(dimensionPixelSize3, dimensionPixelSize4);
        if (isInEditMode()) {
            if (i11 == 0) {
                H("ninePalaceNumber");
            } else if (i11 == 1) {
                this.C = false;
                H("letter");
            } else if (i11 == 2) {
                this.C = true;
                H("letterNumber");
            } else if (i11 == 3) {
                H("symbol");
            }
        }
        setPadding(20, 20, 20, 20);
    }

    private boolean D() {
        if (getScaleX() < 1.0f) {
            return true;
        }
        return false;
    }

    private void E(KeyView keyView) {
        int iC = keyView.getBean().c();
        if (!KeyUtils.x(iC) && !KeyUtils.z(iC) && iC != 112) {
            Animator animator = this.f23309b.get(iC);
            if (animator != null) {
                animator.cancel();
            }
            float scaleX = keyView.getScaleX();
            float scaleY = keyView.getScaleY();
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(keyView, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, scaleX, scaleX * 1.2f, scaleX), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, scaleY, 1.2f * scaleY, scaleY)).setDuration(200L);
            duration.addListener(new j(iC, scaleX, scaleY));
            this.f23309b.put(iC, duration);
            duration.start();
        }
    }

    private void H(String str) {
        String keyboardType = getKeyboardType();
        if (!str.equals(keyboardType)) {
            setKeyboardType(str);
            if ((!"ninePalaceNumber".equals(keyboardType) && !"ninePalaceNumber".equals(str)) || (getTranslationX() == 0.0f && getTranslationY() == 0.0f)) {
                l();
            } else {
                s(new a());
            }
        }
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(EditText editText) {
        int inputType = editText.getInputType();
        int imeOptions = editText.getImeOptions();
        if (inputType == 0) {
            x();
            return;
        }
        int i10 = inputType & 15;
        if (i10 != 2 && i10 != 3 && i10 != 4) {
            String keyboardType = getKeyboardType();
            if (TextUtils.isEmpty(keyboardType) || "ninePalaceNumber".equals(keyboardType)) {
                if (this.C) {
                    keyboardType = "letterNumber";
                } else {
                    keyboardType = "letter";
                }
            }
            H(keyboardType);
        } else {
            H("ninePalaceNumber");
        }
        if (this.f23311d.isEmpty()) {
            this.f23311d.size();
        }
        if (!C(editText) && (imeOptions & 255) != 6) {
            this.f23308a.get(148).b("Next");
        } else {
            this.f23308a.get(148).b("Done");
        }
        this.f23312e = editText;
    }

    private void L(boolean z10) {
        int i10;
        q();
        this.B = z10;
        for (int i11 = 16; i11 <= 53; i11++) {
            KeyView keyView = this.f23308a.get(i11);
            if (keyView != null) {
                keyView.c(z10);
            }
        }
        KeyView keyView2 = this.f23308a.get(150);
        if (keyView2 != null) {
            if (z10) {
                i10 = R$drawable.key_icon_upper_case;
            } else {
                i10 = R$drawable.key_icon_lower_case;
            }
            keyView2.a(i10);
        }
    }

    private int getStatusBarHeight() {
        int identifier = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getContext().getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void i() {
        int paddingTop;
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.getPaddingLeft();
        viewGroup.getWidth();
        viewGroup.getPaddingRight();
        viewGroup.getPaddingTop();
        int height = viewGroup.getHeight() - viewGroup.getPaddingBottom();
        int i10 = this.f23329v + (this.f23331x * 2);
        getHitRect(this.f23327t);
        int i11 = height - this.f23327t.top;
        int i12 = i10 * 2;
        if (i11 <= this.f23332y[1] + i12 + getPaddingBottom()) {
            int i13 = i10 / 2;
            if (i11 >= (this.f23332y[1] - i13) - getPaddingBottom()) {
                paddingTop = this.f23332y[1];
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
            int i15 = (height - paddingTop) - this.f23327t.top;
            if (Math.abs(i15) <= i12 + getPaddingTop()) {
                ObjectAnimator duration = ObjectAnimator.ofFloat(this, (Property<KeyboardView, Float>) View.TRANSLATION_Y, getTranslationY(), getTranslationY() + i15).setDuration(Math.abs(i15));
                duration.addListener(new i());
                duration.start();
            }
        }
    }

    private void k(LinearLayout linearLayout, int i10, int i11, ziyi.kit.keyboard.a aVar, int i12) {
        LinearLayout.LayoutParams layoutParams;
        g gVar;
        int i13;
        int iC = aVar.c();
        KeyView keyView = this.f23308a.get(iC);
        if (keyView == null) {
            keyView = new KeyView(getContext());
            keyView.setTypeface(this.f23321n);
            keyView.getTextKeyView().setTextColor(u(iC));
            keyView.getTextKeyView().setTextSize(1, v(iC));
            keyView.setOnClickListener(this.f23315h);
            if (iC == 147) {
                gVar = new g();
            } else {
                gVar = null;
            }
            keyView.setOnLongClickListener(gVar);
            keyView.setEnabled(KeyUtils.w(iC));
            if (iC == 294) {
                i13 = 4;
            } else {
                i13 = 0;
            }
            keyView.setVisibility(i13);
            keyView.setBackgroundResource(t(iC));
            keyView.setBean(aVar);
            if (!KeyUtils.z(aVar.c())) {
                this.f23308a.put(iC, keyView);
            }
        }
        keyView.setOnKeyListener(new h(i11, i10));
        if (aVar.f()) {
            this.A = keyView;
        }
        ViewGroup.LayoutParams layoutParams2 = keyView.getLayoutParams();
        if (layoutParams2 instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new LinearLayout.LayoutParams(0, i12);
        }
        layoutParams.weight = aVar.b();
        int i14 = this.f23330w;
        layoutParams.leftMargin = i14;
        layoutParams.rightMargin = i14;
        int i15 = this.f23331x;
        layoutParams.topMargin = i15;
        layoutParams.bottomMargin = i15;
        linearLayout.addView(keyView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(KeyView keyView) {
        E(keyView);
        ziyi.kit.keyboard.a bean = keyView.getBean();
        int iC = bean.c();
        String str = "letter";
        if (iC != 256) {
            switch (iC) {
                case 144:
                    j();
                    break;
                case 145:
                    A(bean);
                    break;
                case 146:
                    if (this.C) {
                        str = "letterNumber";
                    }
                    H(str);
                    break;
                case 147:
                    n();
                    break;
                case 148:
                    h(bean);
                    break;
                case 149:
                    H("ninePalaceNumberWithABC");
                    break;
                case 150:
                    L(!this.B);
                    break;
                case 151:
                    K();
                    M();
                    break;
                case SyslogAppender.LOG_LOCAL3 /* 152 */:
                    break;
                case 153:
                    H("symbol");
                    break;
                default:
                    A(bean);
                    break;
            }
            return;
        }
        if (this.C) {
            str = "letterNumber";
        }
        H(str);
    }

    private void q() {
        if (!isInEditMode() && getParent() == null) {
            throw new IllegalStateException("Initialize first.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x00a0  */
    private void r(float f10, float f11) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int paddingLeft = viewGroup.getPaddingLeft();
        int width = viewGroup.getWidth() - viewGroup.getPaddingRight();
        int paddingTop = viewGroup.getPaddingTop();
        int height = viewGroup.getHeight() - viewGroup.getPaddingBottom();
        byte b10 = 2;
        int i10 = this.f23329v + (this.f23331x * 2);
        getHitRect(this.f23327t);
        Rect rect = this.f23327t;
        int i11 = rect.left;
        if (i11 + f10 < paddingLeft) {
            f10 = paddingLeft - i11;
        }
        int i12 = rect.right;
        if (i12 + f10 > width) {
            f10 = width - i12;
        }
        if (rect.top + f11 < paddingTop - ((this.f23332y[1] - i10) - getPaddingBottom())) {
            f11 = (paddingTop - ((this.f23332y[1] - i10) - getPaddingBottom())) - this.f23327t.top;
        }
        if (this.f23327t.bottom + f11 > ((this.f23332y[1] + height) - i10) - getPaddingTop()) {
            f11 = (((height + this.f23332y[1]) - i10) - getPaddingTop()) - this.f23327t.bottom;
        }
        String str = this.f23322o;
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

    private void s(Animator.AnimatorListener animatorListener) {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, getTranslationX(), 0.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, getTranslationX(), 0.0f)).setDuration(300L);
        duration.addListener(animatorListener);
        duration.start();
    }

    public final void A(ziyi.kit.keyboard.a aVar) {
        EditText focusedEditText2 = getFocusedEditText2();
        if (focusedEditText2 != null) {
            Editable text = focusedEditText2.getText();
            int selectionStart = focusedEditText2.getSelectionStart();
            int selectionEnd = focusedEditText2.getSelectionEnd();
            CharSequence charSequenceE = aVar.e();
            if (selectionEnd > selectionStart) {
                text.replace(selectionStart, selectionEnd, charSequenceE);
            } else {
                text.insert(selectionStart, charSequenceE);
            }
            if (KeyUtils.y(aVar.c())) {
                int selectionStart2 = focusedEditText2.getSelectionStart();
                if (selectionStart2 - selectionStart == 2) {
                    focusedEditText2.setSelection(selectionStart2 - 1);
                }
            }
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(focusedEditText2, Integer.valueOf(SupportMenu.CATEGORY_MASK));
            } catch (Exception unused) {
            }
            focusedEditText2.moveCursorToVisibleOffset();
            focusedEditText2.setLongClickable(false);
            focusedEditText2.setCursorVisible(true);
            focusedEditText2.setLinksClickable(true);
        }
    }

    public void I() {
        if (getVisibility() != 0) {
            G();
        }
        KeyView keyView = this.A;
        if (keyView != null) {
            keyView.setSelected(true);
        }
    }

    public final void K() {
        if ("letterNumber".equals(getKeyboardType())) {
            this.C = false;
            H("letter");
        } else if ("letter".equals(getKeyboardType())) {
            this.C = true;
            H("letterNumber");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && getVisibility() == 0) {
            x();
            clearFocus();
            EditText editText = this.f23312e;
            if (editText != null) {
                editText.clearFocus();
                this.f23312e.requestFocus();
            }
            return true;
        }
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 67) {
                n();
                return true;
            }
            if (getVisibility() == 0 && (keyEvent.getKeyCode() == 21 || keyEvent.getKeyCode() == 22 || keyEvent.getKeyCode() == 20 || keyEvent.getKeyCode() == 19 || keyEvent.getKeyCode() == 23 || keyEvent.getKeyCode() == 66)) {
                return super.dispatchKeyEvent(keyEvent);
            }
            EditText focusedEditText2 = getFocusedEditText2();
            if (focusedEditText2 != null && keyEvent.getKeyCode() != 23 && keyEvent.getKeyCode() != 66) {
                focusedEditText2.onKeyDown(keyEvent.getKeyCode(), keyEvent);
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void h(ziyi.kit.keyboard.a aVar) {
        EditText focusedEditText2 = getFocusedEditText2();
        if (focusedEditText2 != null && !"Done".equals(aVar.d().toString())) {
            focusedEditText2.clearFocus();
            this.f23312e = null;
            int i10 = 0;
            while (i10 < this.f23311d.size()) {
                if (focusedEditText2 != this.f23311d.get(i10)) {
                    i10++;
                } else {
                    int i11 = i10 + 1;
                    this.f23311d.get(i11).requestFocus();
                    J(this.f23311d.get(i11));
                    return;
                }
            }
            i10 = -1;
            int i12 = i10 + 1;
            this.f23311d.get(i12).requestFocus();
            J(this.f23311d.get(i12));
            return;
        }
        x();
    }

    public void j() {
        if (getVisibility() == 0) {
            x();
        }
    }

    public final void m() {
        EditText focusedEditText2 = getFocusedEditText2();
        if (focusedEditText2 != null) {
            Editable text = focusedEditText2.getText();
            int selectionStart = focusedEditText2.getSelectionStart();
            int selectionEnd = focusedEditText2.getSelectionEnd();
            if (selectionEnd > selectionStart) {
                text.delete(selectionStart, selectionEnd);
            } else {
                text.delete(0, selectionStart);
                focusedEditText2.setSelection(0);
            }
        }
    }

    public final void n() {
        EditText focusedEditText2 = getFocusedEditText2();
        if (focusedEditText2 != null) {
            Editable text = focusedEditText2.getText();
            int selectionStart = focusedEditText2.getSelectionStart();
            int selectionEnd = focusedEditText2.getSelectionEnd();
            if (selectionEnd > selectionStart) {
                text.delete(selectionStart, selectionEnd);
                return;
            }
            int i10 = selectionStart - 1;
            if (i10 < 0) {
                i10 = 0;
            }
            text.delete(i10, selectionStart);
            focusedEditText2.setSelection(i10);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0039  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!D() && B()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked == 3) {
                            if (this.f23325r) {
                                i();
                                this.f23325r = false;
                                p(true);
                            }
                        }
                    } else if (this.f23326s == motionEvent.getPointerId(0)) {
                        float x10 = motionEvent.getX();
                        float y10 = motionEvent.getY();
                        r(-(this.f23323p - x10), -(this.f23324q - y10));
                    }
                } else if (this.f23325r && this.f23326s == motionEvent.getPointerId(0)) {
                    i();
                    this.f23325r = false;
                    p(true);
                }
            } else if (this.f23326s == motionEvent.getPointerId(0)) {
                this.f23323p = motionEvent.getX();
                this.f23324q = motionEvent.getY();
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCreateKeyListener(m mVar) {
    }

    public void setKeyDownListener(k kVar) {
    }

    public void setKeyboardListener(l lVar) {
    }
}
