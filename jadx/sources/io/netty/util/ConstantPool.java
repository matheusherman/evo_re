package io.netty.util;

import io.netty.util.Constant;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class ConstantPool<T extends Constant<T>> {
    private final ConcurrentMap<String, T> constants = PlatformDependent.newConcurrentHashMap();
    private final AtomicInteger nextId = new AtomicInteger(1);

    protected abstract T newConstant(int i10, String str);

    public T valueOf(Class<?> cls, String str) {
        return (T) valueOf(((Class) ObjectUtil.checkNotNull(cls, "firstNameComponent")).getName() + '#' + ((String) ObjectUtil.checkNotNull(str, "secondNameComponent")));
    }

    private T getOrCreate(String str) {
        T t10 = this.constants.get(str);
        if (t10 != null) {
            return t10;
        }
        T t11 = (T) newConstant(nextId(), str);
        T tPutIfAbsent = this.constants.putIfAbsent(str, t11);
        return tPutIfAbsent == null ? t11 : tPutIfAbsent;
    }

    @Deprecated
    public final int nextId() {
        return this.nextId.getAndIncrement();
    }

    public T valueOf(String str) {
        return (T) getOrCreate(ObjectUtil.checkNonEmpty(str, "name"));
    }
}
