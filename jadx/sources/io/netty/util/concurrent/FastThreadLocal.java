package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.PlatformDependent;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class FastThreadLocal<V> {
    private static final int variablesToRemoveIndex = InternalThreadLocalMap.nextVariableIndex();
    private final int index = InternalThreadLocalMap.nextVariableIndex();

    public final V get() {
        InternalThreadLocalMap internalThreadLocalMap = InternalThreadLocalMap.get();
        V v10 = (V) internalThreadLocalMap.indexedVariable(this.index);
        return v10 != InternalThreadLocalMap.UNSET ? v10 : initialize(internalThreadLocalMap);
    }

    protected V initialValue() {
        return null;
    }

    public final void remove() {
        remove(InternalThreadLocalMap.getIfSet());
    }

    public final void set(V v10) {
        if (v10 != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(InternalThreadLocalMap.get(), v10);
        } else {
            remove();
        }
    }

    private static void addToVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap, FastThreadLocal<?> fastThreadLocal) {
        Set setNewSetFromMap;
        int i10 = variablesToRemoveIndex;
        Object objIndexedVariable = internalThreadLocalMap.indexedVariable(i10);
        if (objIndexedVariable == InternalThreadLocalMap.UNSET || objIndexedVariable == null) {
            setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            internalThreadLocalMap.setIndexedVariable(i10, setNewSetFromMap);
        } else {
            setNewSetFromMap = (Set) objIndexedVariable;
        }
        setNewSetFromMap.add(fastThreadLocal);
    }

    private static void removeFromVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap, FastThreadLocal<?> fastThreadLocal) {
        Object objIndexedVariable = internalThreadLocalMap.indexedVariable(variablesToRemoveIndex);
        if (objIndexedVariable == InternalThreadLocalMap.UNSET || objIndexedVariable == null) {
            return;
        }
        ((Set) objIndexedVariable).remove(fastThreadLocal);
    }

    private void setKnownNotUnset(InternalThreadLocalMap internalThreadLocalMap, V v10) {
        if (internalThreadLocalMap.setIndexedVariable(this.index, v10)) {
            addToVariablesToRemove(internalThreadLocalMap, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void remove(InternalThreadLocalMap internalThreadLocalMap) {
        if (internalThreadLocalMap == null) {
            return;
        }
        Object objRemoveIndexedVariable = internalThreadLocalMap.removeIndexedVariable(this.index);
        removeFromVariablesToRemove(internalThreadLocalMap, this);
        if (objRemoveIndexedVariable != InternalThreadLocalMap.UNSET) {
            try {
                onRemoval(objRemoveIndexedVariable);
            } catch (Exception e10) {
                PlatformDependent.throwException(e10);
            }
        }
    }

    private V initialize(InternalThreadLocalMap internalThreadLocalMap) {
        V vInitialValue;
        try {
            vInitialValue = initialValue();
        } catch (Exception e10) {
            PlatformDependent.throwException(e10);
            vInitialValue = null;
        }
        internalThreadLocalMap.setIndexedVariable(this.index, vInitialValue);
        addToVariablesToRemove(internalThreadLocalMap, this);
        return vInitialValue;
    }

    public static void removeAll() {
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null) {
            return;
        }
        try {
            Object objIndexedVariable = ifSet.indexedVariable(variablesToRemoveIndex);
            if (objIndexedVariable != null && objIndexedVariable != InternalThreadLocalMap.UNSET) {
                for (FastThreadLocal fastThreadLocal : (FastThreadLocal[]) ((Set) objIndexedVariable).toArray(new FastThreadLocal[0])) {
                    fastThreadLocal.remove(ifSet);
                }
            }
        } finally {
            InternalThreadLocalMap.remove();
        }
    }

    public final V getIfExists() {
        V v10;
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet != null && (v10 = (V) ifSet.indexedVariable(this.index)) != InternalThreadLocalMap.UNSET) {
            return v10;
        }
        return null;
    }

    public final V get(InternalThreadLocalMap internalThreadLocalMap) {
        V v10 = (V) internalThreadLocalMap.indexedVariable(this.index);
        return v10 != InternalThreadLocalMap.UNSET ? v10 : initialize(internalThreadLocalMap);
    }

    public final void set(InternalThreadLocalMap internalThreadLocalMap, V v10) {
        if (v10 != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(internalThreadLocalMap, v10);
        } else {
            remove(internalThreadLocalMap);
        }
    }

    protected void onRemoval(V v10) {
    }
}
