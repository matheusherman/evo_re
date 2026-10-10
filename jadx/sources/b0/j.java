package b0;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R$id;
import e0.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Deprecated
public abstract class j<T extends View, Z> extends b0.a<Z> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f617h = R$id.glide_custom_view_target_tag;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final T f618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private View.OnAttachStateChangeListener f620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f622f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @VisibleForTesting
    static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        @VisibleForTesting
        static Integer f623e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<h> f625b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private ViewTreeObserverOnPreDrawListenerC0028a f627d;

        /* JADX INFO: renamed from: b0.j$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        private static final class ViewTreeObserverOnPreDrawListenerC0028a implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f628a;

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f628a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }

            ViewTreeObserverOnPreDrawListenerC0028a(@NonNull a aVar) {
                this.f628a = new WeakReference<>(aVar);
            }
        }

        private static int c(@NonNull Context context) {
            if (f623e == null) {
                Display defaultDisplay = ((WindowManager) k.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f623e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f623e.intValue();
        }

        private int e(int i10, int i11, int i12) {
            int i13 = i11 - i12;
            if (i13 > 0) {
                return i13;
            }
            if (this.f626c && this.f624a.isLayoutRequested()) {
                return 0;
            }
            int i14 = i10 - i12;
            if (i14 > 0) {
                return i14;
            }
            if (this.f624a.isLayoutRequested() || i11 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f624a.getContext());
        }

        private int f() {
            int paddingTop = this.f624a.getPaddingTop() + this.f624a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f624a.getLayoutParams();
            return e(this.f624a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f624a.getPaddingLeft() + this.f624a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f624a.getLayoutParams();
            return e(this.f624a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i10) {
            return i10 > 0 || i10 == Integer.MIN_VALUE;
        }

        private void j(int i10, int i11) {
            Iterator it = new ArrayList(this.f625b).iterator();
            while (it.hasNext()) {
                ((h) it.next()).e(i10, i11);
            }
        }

        void a() {
            if (this.f625b.isEmpty()) {
                return;
            }
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                j(iG, iF);
                b();
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f624a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f627d);
            }
            this.f627d = null;
            this.f625b.clear();
        }

        void k(@NonNull h hVar) {
            this.f625b.remove(hVar);
        }

        a(@NonNull View view) {
            this.f624a = view;
        }

        private boolean i(int i10, int i11) {
            if (h(i10) && h(i11)) {
                return true;
            }
            return false;
        }

        void d(@NonNull h hVar) {
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                hVar.e(iG, iF);
                return;
            }
            if (!this.f625b.contains(hVar)) {
                this.f625b.add(hVar);
            }
            if (this.f627d == null) {
                ViewTreeObserver viewTreeObserver = this.f624a.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC0028a viewTreeObserverOnPreDrawListenerC0028a = new ViewTreeObserverOnPreDrawListenerC0028a(this);
                this.f627d = viewTreeObserverOnPreDrawListenerC0028a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0028a);
            }
        }
    }

    private void m(@Nullable Object obj) {
        f616g = true;
        this.f618b.setTag(f617h, obj);
    }

    @Nullable
    private Object c() {
        return this.f618b.getTag(f617h);
    }

    private void e() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f620d;
        if (onAttachStateChangeListener == null || this.f622f) {
            return;
        }
        this.f618b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f622f = true;
    }

    private void f() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f620d;
        if (onAttachStateChangeListener == null || !this.f622f) {
            return;
        }
        this.f618b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f622f = false;
    }

    @Override // b0.i
    @CallSuper
    public void a(@NonNull h hVar) {
        this.f619c.k(hVar);
    }

    @Override // b0.i
    @CallSuper
    public void j(@NonNull h hVar) {
        this.f619c.d(hVar);
    }

    public String toString() {
        return "Target for: " + this.f618b;
    }

    public j(@NonNull T t10) {
        this.f618b = (T) k.d(t10);
        this.f619c = new a(t10);
    }

    @Override // b0.a, b0.i
    public void i(@Nullable a0.e eVar) {
        m(eVar);
    }

    @Override // b0.a, b0.i
    @CallSuper
    public void k(@Nullable Drawable drawable) {
        super.k(drawable);
        e();
    }

    @Override // b0.a, b0.i
    @Nullable
    public a0.e l() {
        Object objC = c();
        if (objC != null) {
            if (objC instanceof a0.e) {
                return (a0.e) objC;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // b0.a, b0.i
    @CallSuper
    public void n(@Nullable Drawable drawable) {
        super.n(drawable);
        this.f619c.b();
        if (!this.f621e) {
            f();
        }
    }
}
