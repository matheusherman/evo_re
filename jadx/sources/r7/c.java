package r7;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import u7.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lr7/c;", "Lu7/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lr7/a;", "<init>", "()V", "", "Q", "()Ljava/util/List;", "Lr7/c$a;", "listener", "Lr8/z;", "R", "(Lr7/c$a;)V", "n", "Lr7/c$a;", "", "o", "Z", "enableClick", "a", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class c<T extends u7.a> extends r7.a<T> {

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private a<T> listener;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean enableClick = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void P(c cVar, g0.d adapter, View view, int i10) {
        m.f(adapter, "adapter");
        m.f(view, "view");
        u7.a aVar = (u7.a) adapter.getItem(i10);
        if (aVar != null && cVar.enableClick) {
            aVar.a(!aVar.getSelected());
            adapter.x(i10, aVar);
            a<T> aVar2 = cVar.listener;
            if (aVar2 != null) {
                aVar2.a((T) aVar);
            }
            a<T> aVar3 = cVar.listener;
            if (aVar3 != null) {
                aVar3.b((T) aVar, i10);
            }
            a<T> aVar4 = cVar.listener;
            if (aVar4 != null) {
                aVar4.c(aVar.getSelected(), aVar);
            }
        }
    }

    public final void R(a<T> listener) {
        m.f(listener, "listener");
        this.listener = listener;
    }

    public c() {
        i0.c.b(this, 0L, new g0.d.InterfaceC0181d() { // from class: r7.b
            @Override // g0.d.InterfaceC0181d
            public final void b(g0.d dVar, View view, int i10) {
                c.P(this.f17848a, dVar, view, i10);
            }
        }, 1, null);
    }

    public final List<T> Q() {
        List<T> listM = m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM) {
            if (((u7.a) obj).getSelected()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lr7/c$a;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "isSelected", "item", "Lr8/z;", "c", "(ZLjava/lang/Object;)V", "a", "(Ljava/lang/Object;)V", "", "position", "b", "(Ljava/lang/Object;I)V", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a<T> {
        void a(T item);

        void b(T item, int position);

        void c(boolean isSelected, T item);

        /* JADX INFO: renamed from: r7.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class C0343a {
            public static <T> void a(a<T> aVar, T t10) {
            }

            public static <T> void b(a<T> aVar, T t10, int i10) {
            }
        }
    }
}
