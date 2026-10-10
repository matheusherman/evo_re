package v8;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001:\u0002\u0013\u0014J*\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H¦\u0002¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00028\u00002\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\nH&¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lv8/j;", "", "Lv8/j$b;", ExifInterface.LONGITUDE_EAST, "Lv8/j$c;", "key", "get", "(Lv8/j$c;)Lv8/j$b;", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Lc9/p;)Ljava/lang/Object;", "context", "plus", "(Lv8/j;)Lv8/j;", "minusKey", "(Lv8/j$c;)Lv8/j;", "c", "b", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface j {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public static j b(j jVar, j context) {
            m.f(context, "context");
            return context == k.f19724a ? jVar : (j) context.fold(jVar, new p() { // from class: v8.i
                @Override // c9.p
                public final Object invoke(Object obj, Object obj2) {
                    return j.a.c((j) obj, (j.b) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static j c(j acc, b element) {
            m.f(acc, "acc");
            m.f(element, "element");
            j jVarMinusKey = acc.minusKey(element.getKey());
            k kVar = k.f19724a;
            if (jVarMinusKey == kVar) {
                return element;
            }
            g.Companion bVar = g.INSTANCE;
            g gVar = (g) jVarMinusKey.get(bVar);
            if (gVar == null) {
                return new e(jVarMinusKey, element);
            }
            j jVarMinusKey2 = jVarMinusKey.minusKey(bVar);
            return jVarMinusKey2 == kVar ? new e(element, gVar) : new e(new e(jVarMinusKey2, element), gVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J*\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lv8/j$b;", "Lv8/j;", ExifInterface.LONGITUDE_EAST, "Lv8/j$c;", "key", "get", "(Lv8/j$c;)Lv8/j$b;", "getKey", "()Lv8/j$c;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b extends j {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class a {
            public static <R> R a(b bVar, R r10, p<? super R, ? super b, ? extends R> operation) {
                m.f(operation, "operation");
                return operation.invoke(r10, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b bVar, c<E> key) {
                m.f(key, "key");
                if (!m.a(bVar.getKey(), key)) {
                    return null;
                }
                m.d(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static j c(b bVar, c<?> key) {
                m.f(key, "key");
                return m.a(bVar.getKey(), key) ? k.f19724a : bVar;
            }

            public static j d(b bVar, j context) {
                m.f(context, "context");
                return a.b(bVar, context);
            }
        }

        @Override // v8.j
        <E extends b> E get(c<E> key);

        c<?> getKey();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lv8/j$c;", "Lv8/j$b;", ExifInterface.LONGITUDE_EAST, "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface c<E extends b> {
    }

    <R> R fold(R initial, p<? super R, ? super b, ? extends R> operation);

    <E extends b> E get(c<E> key);

    j minusKey(c<?> key);

    j plus(j context);
}
