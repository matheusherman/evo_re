package r7;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import u7.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\fJ)\u0010\u0011\u001a\u00020\n2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0002\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0002\u0010\u0015R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lr7/e;", "Lu7/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lr7/a;", "<init>", "()V", "", ExifInterface.LATITUDE_SOUTH, "()I", "position", "Lr8/z;", "Q", "(I)V", "R", "", "list", "index", "U", "(Ljava/util/List;Ljava/lang/Integer;)V", "Lr7/e$a;", "listener", "(Lr7/e$a;)V", "n", "Lr7/e$a;", "", "o", "Z", "enableClick", "p", "cancelSelected", "Landroid/os/Handler;", "q", "Landroid/os/Handler;", "handler", "a", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class e<T extends u7.a> extends r7.a<T> {

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private a<T> listener;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean cancelSelected;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean enableClick = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ-\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lr7/e$a;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "isSelected", "item", "Lr8/z;", "c", "(ZLjava/lang/Object;)V", "a", "(Ljava/lang/Object;)V", "", "position", "e", "(Ljava/lang/Object;I)V", "b", "", "list", "d", "(Ljava/lang/Object;ILjava/util/List;)V", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a<T> {

        /* JADX INFO: renamed from: r7.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class C0344a {
            public static <T> void d(a<T> aVar, T t10, int i10, List<? extends T> list) {
                m.f(list, "list");
            }

            public static <T> void b(a<T> aVar, T t10) {
            }

            public static <T> void a(a<T> aVar, T t10, int i10) {
            }

            public static <T> void c(a<T> aVar, T t10, int i10) {
            }

            public static <T> void e(a<T> aVar, boolean z10, T t10) {
            }
        }

        void a(T item);

        void b(T item, int position);

        void c(boolean isSelected, T item);

        void d(T item, int position, List<? extends T> list);

        void e(T item, int position);
    }

    public final void U(List<? extends T> list, Integer index) {
        List<? extends T> list2 = list;
        if (list2 != null && !list2.isEmpty() && index != null && list.size() > index.intValue() && index.intValue() >= 0) {
            int size = list.size();
            int i10 = 0;
            while (true) {
                boolean z10 = true;
                if (i10 >= size) {
                    break;
                }
                T t10 = list.get(i10);
                if (i10 != index.intValue()) {
                    z10 = false;
                }
                t10.a(z10);
                i10++;
            }
            a<T> aVar = this.listener;
            if (aVar != null) {
                aVar.a(list.get(index.intValue()));
            }
            a<T> aVar2 = this.listener;
            if (aVar2 != null) {
                aVar2.d(list.get(index.intValue()), index.intValue(), list);
            }
            a<T> aVar3 = this.listener;
            if (aVar3 != null) {
                aVar3.c(true, list.get(index.intValue()));
            }
            a<T> aVar4 = this.listener;
            if (aVar4 != null) {
                aVar4.b(list.get(index.intValue()), index.intValue());
            }
        }
        super.submitList(list);
    }

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
    public static final void P(e eVar, g0.d adapter, View view, int i10) {
        m.f(adapter, "adapter");
        m.f(view, "view");
        if (eVar.enableClick) {
            int size = adapter.m().size();
            for (int i11 = 0; i11 < size; i11++) {
                u7.a aVar = (u7.a) adapter.m().get(i11);
                if (i11 == i10) {
                    if (aVar.getSelected()) {
                        a<T> aVar2 = eVar.listener;
                        if (aVar2 != null) {
                            aVar2.e((T) aVar, i10);
                        }
                    } else {
                        a<T> aVar3 = eVar.listener;
                        if (aVar3 != null) {
                            aVar3.a(aVar);
                        }
                        a<T> aVar4 = eVar.listener;
                        if (aVar4 != null) {
                            aVar4.b(aVar, i10);
                        }
                        a<T> aVar5 = eVar.listener;
                        if (aVar5 != null) {
                            aVar5.d(aVar, i10, eVar.m());
                        }
                    }
                    if (eVar.cancelSelected) {
                        aVar.a(!aVar.getSelected());
                        adapter.x(i11, aVar);
                    } else if (!aVar.getSelected()) {
                        aVar.a(true);
                        adapter.x(i11, aVar);
                    }
                    a<T> aVar6 = eVar.listener;
                    if (aVar6 != null) {
                        aVar6.c(aVar.getSelected(), aVar);
                    }
                } else {
                    aVar.a(false);
                    adapter.x(i11, aVar);
                }
            }
        }
    }

    public final void T(a<T> listener) {
        m.f(listener, "listener");
        this.listener = listener;
    }

    public e() {
        i0.c.b(this, 0L, new g0.d.InterfaceC0181d() { // from class: r7.d
            @Override // g0.d.InterfaceC0181d
            public final void b(g0.d dVar, View view, int i10) {
                e.P(this.f17851a, dVar, view, i10);
            }
        }, 1, null);
    }

    public final void Q(int position) {
        int i10 = 0;
        for (T t10 : m()) {
            int i11 = i10 + 1;
            if (i10 == position) {
                t10.a(true);
                notifyItemChanged(i10);
            } else if (t10.getSelected()) {
                t10.a(false);
                notifyItemChanged(i10);
            }
            i10 = i11;
        }
    }

    public final void R(int position) {
        int i10 = 0;
        for (T t10 : m()) {
            int i11 = i10 + 1;
            if (i10 == position) {
                t10.a(true);
            } else if (t10.getSelected()) {
                t10.a(false);
            }
            i10 = i11;
        }
        notifyDataSetChanged();
    }

    public final int S() {
        if (m().isEmpty()) {
            return 0;
        }
        int size = m().size();
        for (int i10 = 0; i10 < size; i10++) {
            if (m().get(i10).getSelected()) {
                return i10;
            }
        }
        return 0;
    }
}
