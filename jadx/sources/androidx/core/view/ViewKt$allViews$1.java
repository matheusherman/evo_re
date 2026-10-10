package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {409, 411}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lta/j;", "Landroid/view/View;", "Lr8/z;", "<anonymous>", "(Lta/j;)V"}, k = 3, mv = {1, 8, 0})
final class ViewKt$allViews$1 extends kotlin.coroutines.jvm.internal.k implements c9.p<ta.j<? super View>, v8.f<? super r8.z>, Object> {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewKt$allViews$1(View view, v8.f<? super ViewKt$allViews$1> fVar) {
        super(2, fVar);
        this.$this_allViews = view;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, fVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // c9.p
    public final Object invoke(ta.j<? super View> jVar, v8.f<? super r8.z> fVar) {
        return ((ViewKt$allViews$1) create(jVar, fVar)).invokeSuspend(r8.z.f17874a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        if (r1.f(r5, r4) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ta.j jVar;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                jVar = (ta.j) this.L$0;
                r8.r.b(obj);
            }
            return r8.z.f17874a;
        }
        r8.r.b(obj);
        jVar = (ta.j) this.L$0;
        View view = this.$this_allViews;
        this.L$0 = jVar;
        this.label = 1;
        if (jVar.c(view, this) != objC) {
        }
        return objC;
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            ta.h<View> descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
        }
        return r8.z.f17874a;
    }
}
