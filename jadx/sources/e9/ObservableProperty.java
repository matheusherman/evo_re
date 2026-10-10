package e9;

import androidx.exifinterface.media.ExifInterface;
import i9.k;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: renamed from: e9.b, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\f\u0010\rJ+\u0010\u000f\u001a\u00020\u000e2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0012\u001a\u00028\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J.\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0014\u001a\u00028\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001a¨\u0006\u001b"}, d2 = {"Le9/b;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Le9/d;", "", "initialValue", "<init>", "(Ljava/lang/Object;)V", "Li9/k;", "property", "oldValue", "newValue", "", "b", "(Li9/k;Ljava/lang/Object;Ljava/lang/Object;)Z", "Lr8/z;", "a", "(Li9/k;Ljava/lang/Object;Ljava/lang/Object;)V", "thisRef", "getValue", "(Ljava/lang/Object;Li9/k;)Ljava/lang/Object;", "value", "setValue", "(Ljava/lang/Object;Li9/k;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ObservableProperty<V> implements d<Object, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private V value;

    protected abstract boolean b(k<?> property, V oldValue, V newValue);

    protected void a(k<?> property, V oldValue, V newValue) {
        m.f(property, "property");
    }

    @Override // e9.d, e9.c
    public V getValue(Object thisRef, k<?> property) {
        m.f(property, "property");
        return this.value;
    }

    @Override // e9.d
    public void setValue(Object thisRef, k<?> property, V value) {
        m.f(property, "property");
        V v10 = this.value;
        if (b(property, v10, value)) {
            this.value = value;
            a(property, v10, value);
        }
    }

    public String toString() {
        return "ObservableProperty(value=" + this.value + ')';
    }

    public ObservableProperty(V v10) {
        this.value = v10;
    }
}
