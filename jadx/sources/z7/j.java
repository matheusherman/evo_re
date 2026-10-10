package z7;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tvc.lib.R$id;
import com.tvc.lib.mobile.ui.widget.sloading.SLoadingView;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import t.v.c.widget.MyPopupWindow;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\r\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\r\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0003J\u001d\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010$R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00060"}, d2 = {"Lz7/j;", "Lx1/f1/lb/config/c;", "<init>", "()V", "", "o", "()Z", "", "loadingLayoutId", "colorFocused", "Landroid/view/View;", "parent", "textRes", "j", "(IILandroid/view/View;I)Lx1/f1/lb/config/c;", "Lcom/tvc/lib/mobile/ui/widget/b;", "h", "(IILandroid/view/View;I)Lcom/tvc/lib/mobile/ui/widget/b;", "", "text", "Lr8/z;", "c", "(Ljava/lang/String;)V", "b", "a", "m", "Landroid/content/Context;", "context", "Ly7/a;", "l", "(Landroid/content/Context;I)Ly7/a;", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Lt/v/c/widget/MyPopupWindow;", "Lt/v/c/widget/MyPopupWindow;", "popupWindow", "Ljava/lang/ref/SoftReference;", "d", "Ljava/lang/ref/SoftReference;", "mParent", "e", "mContext", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "handler", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j implements x1.f1.lb.config.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static MyPopupWindow popupWindow;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static SoftReference<View> mParent;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static SoftReference<Context> mContext;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f23105a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(j.class);

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Handler handler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"z7/j$a", "Lcom/tvc/lib/mobile/ui/widget/b;", "", "text", "Lr8/z;", "c", "(Ljava/lang/String;)V", "b", "()V", "a", "Landroid/view/View;", "Landroid/view/View;", "getLoadingContainer", "()Landroid/view/View;", "setLoadingContainer", "(Landroid/view/View;)V", "loadingContainer", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "textView", "Lcom/tvc/lib/mobile/ui/widget/sloading/SLoadingView;", "Lcom/tvc/lib/mobile/ui/widget/sloading/SLoadingView;", "getLoadingImgView", "()Lcom/tvc/lib/mobile/ui/widget/sloading/SLoadingView;", "setLoadingImgView", "(Lcom/tvc/lib/mobile/ui/widget/sloading/SLoadingView;)V", "loadingImgView", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements com.tvc.lib.mobile.ui.widget.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private View loadingContainer;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private TextView textView;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private SLoadingView loadingImgView;

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(a aVar) {
            try {
                View view = aVar.loadingContainer;
                if (view != null) {
                    view.setVisibility(0);
                }
            } catch (Throwable th) {
                j.logger.error("start loading animation failure", th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(a aVar) {
            try {
                View view = aVar.loadingContainer;
                if (view != null) {
                    view.setVisibility(0);
                }
            } catch (Throwable th) {
                j.logger.error("start loading animation failure", th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(a aVar) {
            try {
                View view = aVar.loadingContainer;
                if (view != null) {
                    view.setVisibility(8);
                }
            } catch (Throwable th) {
                j.logger.error("stop loading animation failure", th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(a aVar, String str) {
            TextView textView = aVar.textView;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = aVar.textView;
            if (textView2 != null) {
                textView2.setText(str);
            }
        }

        @Override // x1.f1.lb.config.c
        public void b() {
            View view = this.loadingContainer;
            if (view == null || view.getVisibility() != 0) {
                if (kotlin.jvm.internal.m.a(Thread.currentThread(), Looper.getMainLooper().getThread())) {
                    j.handler.post(new Runnable() { // from class: z7.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            j.a.j(this.f23100a);
                        }
                    });
                } else {
                    j.handler.post(new Runnable() { // from class: z7.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            j.a.k(this.f23101a);
                        }
                    });
                }
            }
        }

        @Override // x1.f1.lb.config.c
        public void c(final String text) {
            kotlin.jvm.internal.m.f(text, "text");
            if (!kotlin.jvm.internal.m.a(Thread.currentThread(), Looper.getMainLooper().getThread())) {
                j.handler.post(new Runnable() { // from class: z7.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.a.i(this.f23102a, text);
                    }
                });
                return;
            }
            TextView textView = this.textView;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.textView;
            if (textView2 != null) {
                textView2.setText(text);
            }
        }

        a(View view, int i10, int i11, int i12) {
            View viewFindViewById;
            if (view != null) {
                try {
                    viewFindViewById = view.findViewById(i10);
                } catch (Throwable th) {
                    j.logger.error("failure to init loading util", th);
                    return;
                }
            } else {
                viewFindViewById = null;
            }
            this.loadingContainer = viewFindViewById;
            kotlin.jvm.internal.m.c(viewFindViewById);
            SLoadingView sLoadingView = (SLoadingView) viewFindViewById.findViewById(R$id.sloadingdlg_slv);
            this.loadingImgView = sLoadingView;
            if (sLoadingView != null) {
                sLoadingView.setLoadingBuilder(com.tvc.lib.mobile.ui.widget.sloading.c.TRANSLATE_CIRCLE);
            }
            SLoadingView sLoadingView2 = this.loadingImgView;
            if (sLoadingView2 != null) {
                View view2 = this.loadingContainer;
                kotlin.jvm.internal.m.c(view2);
                sLoadingView2.setColorFilter(ContextCompat.getColor(view2.getContext(), i11));
            }
            View view3 = this.loadingContainer;
            kotlin.jvm.internal.m.c(view3);
            TextView textView = (TextView) view3.findViewById(R$id.sloadingdlg_tv_custom_text);
            this.textView = textView;
            if (i12 == 0) {
                if (textView != null) {
                    textView.setVisibility(8);
                }
            } else if (i12 > 0) {
                if (textView != null) {
                    textView.setVisibility(0);
                }
                TextView textView2 = this.textView;
                if (textView2 != null) {
                    View view4 = this.loadingContainer;
                    kotlin.jvm.internal.m.c(view4);
                    textView2.setText(view4.getContext().getString(i12));
                }
            }
            a();
        }

        @Override // x1.f1.lb.config.c
        public void a() {
            j.handler.post(new Runnable() { // from class: z7.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.a.h(this.f23104a);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"z7/j$b", "Lx1/f1/lb/config/c;", "", "text", "Lr8/z;", "c", "(Ljava/lang/String;)V", "b", "()V", "a", "Landroid/view/View;", "Landroid/view/View;", "getLoadingContainer", "()Landroid/view/View;", "setLoadingContainer", "(Landroid/view/View;)V", "loadingContainer", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "textView", "Lcom/tvc/lib/mobile/ui/widget/sloading/SLoadingView;", "Lcom/tvc/lib/mobile/ui/widget/sloading/SLoadingView;", "getLoadingImgView", "()Lcom/tvc/lib/mobile/ui/widget/sloading/SLoadingView;", "setLoadingImgView", "(Lcom/tvc/lib/mobile/ui/widget/sloading/SLoadingView;)V", "loadingImgView", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements x1.f1.lb.config.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private View loadingContainer;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private TextView textView;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private SLoadingView loadingImgView;

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(b bVar) {
            try {
                View view = bVar.loadingContainer;
                if (view != null) {
                    view.setVisibility(0);
                }
            } catch (Throwable th) {
                j.logger.error("start loading animation failure", th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(b bVar) {
            try {
                View view = bVar.loadingContainer;
                if (view != null) {
                    view.setVisibility(8);
                }
            } catch (Throwable th) {
                j.logger.error("stop loading animation failure", th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(b bVar, String str) {
            TextView textView = bVar.textView;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = bVar.textView;
            if (textView2 != null) {
                textView2.setText(str);
            }
        }

        @Override // x1.f1.lb.config.c
        public void c(final String text) {
            kotlin.jvm.internal.m.f(text, "text");
            j.handler.post(new Runnable() { // from class: z7.m
                @Override // java.lang.Runnable
                public final void run() {
                    j.b.h(this.f23119a, text);
                }
            });
        }

        b(View view, int i10, int i11, int i12) {
            View viewFindViewById;
            if (view != null) {
                try {
                    viewFindViewById = view.findViewById(i10);
                } catch (Throwable th) {
                    j.logger.error("failure to init loading util", th);
                    return;
                }
            } else {
                viewFindViewById = null;
            }
            this.loadingContainer = viewFindViewById;
            kotlin.jvm.internal.m.c(viewFindViewById);
            SLoadingView sLoadingView = (SLoadingView) viewFindViewById.findViewById(R$id.sloadingdlg_slv);
            this.loadingImgView = sLoadingView;
            if (sLoadingView != null) {
                sLoadingView.setLoadingBuilder(com.tvc.lib.mobile.ui.widget.sloading.c.TRANSLATE_CIRCLE);
            }
            SLoadingView sLoadingView2 = this.loadingImgView;
            if (sLoadingView2 != null) {
                View view2 = this.loadingContainer;
                kotlin.jvm.internal.m.c(view2);
                sLoadingView2.setColorFilter(ContextCompat.getColor(view2.getContext(), i11));
            }
            View view3 = this.loadingContainer;
            kotlin.jvm.internal.m.c(view3);
            TextView textView = (TextView) view3.findViewById(R$id.sloadingdlg_tv_custom_text);
            this.textView = textView;
            if (i12 == 0) {
                if (textView != null) {
                    textView.setVisibility(8);
                }
            } else if (i12 > 0) {
                if (textView != null) {
                    textView.setVisibility(0);
                }
                TextView textView2 = this.textView;
                if (textView2 != null) {
                    View view4 = this.loadingContainer;
                    kotlin.jvm.internal.m.c(view4);
                    textView2.setText(view4.getContext().getString(i12));
                }
            }
            a();
        }

        @Override // x1.f1.lb.config.c
        public void a() {
            j.handler.post(new Runnable() { // from class: z7.l
                @Override // java.lang.Runnable
                public final void run() {
                    j.b.g(this.f23118a);
                }
            });
        }

        @Override // x1.f1.lb.config.c
        public void b() {
            j.handler.post(new Runnable() { // from class: z7.k
                @Override // java.lang.Runnable
                public final void run() {
                    j.b.i(this.f23117a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(View view) {
        try {
            MyPopupWindow myPopupWindow = popupWindow;
            if (myPopupWindow != null) {
                myPopupWindow.showAtLocation(view, 1, 0, 0);
            }
        } catch (Exception e10) {
            logger.error("show loading failure", e10);
        }
    }

    public static /* synthetic */ com.tvc.lib.mobile.ui.widget.b i(j jVar, int i10, int i11, View view, int i12, int i13, Object obj) {
        if ((i13 & 8) != 0) {
            i12 = -1;
        }
        return jVar.h(i10, i11, view, i12);
    }

    public static /* synthetic */ x1.f1.lb.config.c k(j jVar, int i10, int i11, View view, int i12, int i13, Object obj) {
        if ((i13 & 8) != 0) {
            i12 = -1;
        }
        return jVar.j(i10, i11, view, i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n() {
        MyPopupWindow myPopupWindow;
        try {
            MyPopupWindow myPopupWindow2 = popupWindow;
            if (myPopupWindow2 == null || !myPopupWindow2.isShowing() || (myPopupWindow = popupWindow) == null) {
                return;
            }
            myPopupWindow.dismiss();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private final boolean o() {
        Context context;
        SoftReference<Context> softReference = mContext;
        if (softReference == null || (context = softReference.get()) == null || !(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    @Override // x1.f1.lb.config.c
    public void b() {
        final View view;
        SoftReference<View> softReference = mParent;
        if (softReference == null || (view = softReference.get()) == null) {
            return;
        }
        MyPopupWindow myPopupWindow = popupWindow;
        if ((myPopupWindow == null || !myPopupWindow.isShowing()) && o()) {
            handler.post(new Runnable() { // from class: z7.e
                @Override // java.lang.Runnable
                public final void run() {
                    j.p(view);
                }
            });
        }
    }

    @Override // x1.f1.lb.config.c
    public void c(String text) {
        kotlin.jvm.internal.m.f(text, "text");
    }

    public final com.tvc.lib.mobile.ui.widget.b h(int loadingLayoutId, int colorFocused, View parent, int textRes) {
        return new a(parent, loadingLayoutId, colorFocused, textRes);
    }

    public final x1.f1.lb.config.c j(int loadingLayoutId, int colorFocused, View parent, int textRes) {
        return new b(parent, loadingLayoutId, colorFocused, textRes);
    }

    public final y7.a l(Context context, int colorFocused) {
        kotlin.jvm.internal.m.f(context, "context");
        y7.a aVar = new y7.a(context);
        aVar.f(com.tvc.lib.mobile.ui.widget.sloading.c.TRANSLATE_CIRCLE);
        aVar.g(ContextCompat.getColor(context, colorFocused));
        return aVar;
    }

    public final void m() {
        SoftReference<View> softReference = mParent;
        if (softReference != null) {
            softReference.clear();
        }
        mParent = null;
        a();
        popupWindow = null;
    }

    private j() {
    }

    @Override // x1.f1.lb.config.c
    public void a() {
        if (!o()) {
            return;
        }
        handler.post(new Runnable() { // from class: z7.d
            @Override // java.lang.Runnable
            public final void run() {
                j.n();
            }
        });
    }
}
