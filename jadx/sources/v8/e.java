package v8;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u00011B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0019\u001a\u00020\u00182\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ*\u0010\u001e\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u001b*\u00020\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ7\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010 2\u0006\u0010!\u001a\u00028\u00002\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\"H\u0016¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00012\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0016¢\u0006\u0004\b&\u0010'J\u001a\u0010)\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010\u000bJ\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010/R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00100¨\u00062"}, d2 = {"Lv8/e;", "Lv8/j;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "Lv8/j$b;", "element", "<init>", "(Lv8/j;Lv8/j$b;)V", "", "h", "()I", "", "e", "(Lv8/j$b;)Z", "context", "g", "(Lv8/e;)Z", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "input", "Lr8/z;", "readObject", "(Ljava/io/ObjectInputStream;)V", ExifInterface.LONGITUDE_EAST, "Lv8/j$c;", "key", "get", "(Lv8/j$c;)Lv8/j$b;", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Lc9/p;)Ljava/lang/Object;", "minusKey", "(Lv8/j$c;)Lv8/j;", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Lv8/j;", "Lv8/j$b;", "a", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class e implements j, Serializable {
    private final j.b element;
    private final j left;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lv8/e$a;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "Lv8/j;", "elements", "<init>", "([Lv8/j;)V", "", "readResolve", "()Ljava/lang/Object;", "[Lv8/j;", "getElements", "()[Lv8/j;", "a", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class a implements Serializable {
        private static final long serialVersionUID = 0;
        private final j[] elements;

        public a(j[] elements) {
            m.f(elements, "elements");
            this.elements = elements;
        }

        private final Object readResolve() {
            j[] jVarArr = this.elements;
            j jVarPlus = k.f19724a;
            for (j jVar : jVarArr) {
                jVarPlus = jVarPlus.plus(jVar);
            }
            return jVarPlus;
        }
    }

    private final int h() {
        int i10 = 2;
        e eVar = this;
        while (true) {
            j jVar = eVar.left;
            eVar = jVar instanceof e ? (e) jVar : null;
            if (eVar == null) {
                return i10;
            }
            i10++;
        }
    }

    public e(j left, j.b element) {
        m.f(left, "left");
        m.f(element, "element");
        this.left = left;
        this.element = element;
    }

    private final boolean g(e context) {
        while (e(context.element)) {
            j jVar = context.left;
            if (!(jVar instanceof e)) {
                m.d(jVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return e((j.b) jVar);
            }
            context = (e) jVar;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i(String acc, j.b element) {
        m.f(acc, "acc");
        m.f(element, "element");
        if (acc.length() == 0) {
            return element.toString();
        }
        return acc + ", " + element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z l(j[] jVarArr, kotlin.jvm.internal.z zVar, z zVar2, j.b element) {
        m.f(zVar2, "<unused var>");
        m.f(element, "element");
        int i10 = zVar.element;
        zVar.element = i10 + 1;
        jVarArr[i10] = element;
        return z.f17874a;
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        return eVar.h() == h() && eVar.g(this);
    }

    @Override // v8.j
    public <R> R fold(R initial, p<? super R, ? super j.b, ? extends R> operation) {
        m.f(operation, "operation");
        return operation.invoke((Object) this.left.fold(initial, operation), this.element);
    }

    @Override // v8.j
    public <E extends j.b> E get(j.c<E> key) {
        m.f(key, "key");
        e eVar = this;
        while (true) {
            E e10 = (E) eVar.element.get(key);
            if (e10 != null) {
                return e10;
            }
            j jVar = eVar.left;
            if (!(jVar instanceof e)) {
                return (E) jVar.get(key);
            }
            eVar = (e) jVar;
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // v8.j
    public j minusKey(j.c<?> key) {
        m.f(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        j jVarMinusKey = this.left.minusKey(key);
        if (jVarMinusKey == this.left) {
            return this;
        }
        return jVarMinusKey == k.f19724a ? this.element : new e(jVarMinusKey, this.element);
    }

    public String toString() {
        return '[' + ((String) fold("", new p() { // from class: v8.d
            @Override // c9.p
            public final Object invoke(Object obj, Object obj2) {
                return e.i((String) obj, (j.b) obj2);
            }
        })) + ']';
    }

    private final boolean e(j.b element) {
        return m.a(get(element.getKey()), element);
    }

    private final Object writeReplace() {
        int iH = h();
        final j[] jVarArr = new j[iH];
        final kotlin.jvm.internal.z zVar = new kotlin.jvm.internal.z();
        fold(z.f17874a, new p() { // from class: v8.c
            @Override // c9.p
            public final Object invoke(Object obj, Object obj2) {
                return e.l(jVarArr, zVar, (z) obj, (j.b) obj2);
            }
        });
        if (zVar.element == iH) {
            return new a(jVarArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    @Override // v8.j
    public j plus(j jVar) {
        return j.a.b(this, jVar);
    }
}
