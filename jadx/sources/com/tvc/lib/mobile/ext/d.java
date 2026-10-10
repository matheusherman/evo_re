package com.tvc.lib.mobile.ext;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u001aC\u0010\b\u001a\u00020\u00062\u0016\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0000\"\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\u000b\u001a\u00020\u0006*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u000b\u0010\f\"\"\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"", "Landroid/view/View;", "views", "", "interval", "Lkotlin/Function1;", "Lr8/z;", "onClick", "e", "([Landroid/view/View;JLc9/l;)V", "action", "c", "(Landroid/view/View;JLc9/l;)V", "a", "J", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "lastClickTime", "tvclib_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f9198a;

    public static final void c(View view, final long j10, final c9.l<? super View, z> action) {
        m.f(view, "<this>");
        m.f(action, "action");
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tvc.lib.mobile.ext.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.d(j10, action, view2);
            }
        });
    }

    public static final void e(View[] views, long j10, final c9.l<? super View, z> onClick) {
        m.f(views, "views");
        m.f(onClick, "onClick");
        for (View view : views) {
            if (view != null) {
                c(view, j10, new c9.l() { // from class: com.tvc.lib.mobile.ext.b
                    @Override // c9.l
                    public final Object invoke(Object obj) {
                        return d.g(onClick, (View) obj);
                    }
                });
            }
        }
    }

    public static /* synthetic */ void f(View[] viewArr, long j10, c9.l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 500;
        }
        e(viewArr, j10, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z g(c9.l lVar, View view) {
        m.f(view, "view");
        lVar.invoke(view);
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(long j10, c9.l lVar, View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j11 = f9198a;
        if (j11 != 0 && jCurrentTimeMillis - j11 < j10) {
            return;
        }
        f9198a = jCurrentTimeMillis;
        m.c(view);
        lVar.invoke(view);
    }
}
