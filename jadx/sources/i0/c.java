package i0;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import g0.d;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aQ\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Lg0/d;", "", "time", "Lg0/d$d;", "block", "a", "(Lg0/d;JLg0/d$d;)Lg0/d;", "com.github.CymChad.brvah"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class c {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J1\u0010\t\u001a\u00020\b2\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"i0/c$a", "Li0/b;", "Lg0/d;", "adapter", "Landroid/view/View;", "view", "", "position", "Lr8/z;", "c", "(Lg0/d;Landroid/view/View;I)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a<T> extends b<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.InterfaceC0181d<T> f11003c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j10, d.InterfaceC0181d<T> interfaceC0181d) {
            super(j10);
            this.f11003c = interfaceC0181d;
        }

        @Override // i0.b
        protected void c(d<T, ?> adapter, View view, int position) {
            m.f(adapter, "adapter");
            m.f(view, "view");
            this.f11003c.b(adapter, view, position);
        }
    }

    public static final <T, VH extends RecyclerView.ViewHolder> d<T, VH> a(d<T, VH> dVar, long j10, d.InterfaceC0181d<T> block) {
        m.f(dVar, "<this>");
        m.f(block, "block");
        return dVar.C(new a(j10, block));
    }

    public static /* synthetic */ d b(d dVar, long j10, d.InterfaceC0181d interfaceC0181d, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 500;
        }
        return a(dVar, j10, interfaceC0181d);
    }
}
