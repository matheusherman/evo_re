package io.netty.util;

import androidx.concurrent.futures.a;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class DefaultAttributeMap implements AttributeMap {
    private static final AtomicReferenceFieldUpdater<DefaultAttributeMap, DefaultAttribute[]> ATTRIBUTES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultAttributeMap.class, DefaultAttribute[].class, "attributes");
    private static final DefaultAttribute[] EMPTY_ATTRIBUTES = new DefaultAttribute[0];
    private volatile DefaultAttribute[] attributes = EMPTY_ATTRIBUTES;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class DefaultAttribute<T> extends AtomicReference<T> implements Attribute<T> {
        private static final AtomicReferenceFieldUpdater<DefaultAttribute, DefaultAttributeMap> MAP_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultAttribute.class, DefaultAttributeMap.class, "attributeMap");
        private static final long serialVersionUID = -2661411462200283011L;
        private volatile DefaultAttributeMap attributeMap;
        private final AttributeKey<T> key;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isRemoved() {
            return this.attributeMap == null;
        }

        DefaultAttribute(DefaultAttributeMap defaultAttributeMap, AttributeKey<T> attributeKey) {
            this.attributeMap = defaultAttributeMap;
            this.key = attributeKey;
        }
    }

    private static int searchAttributeByKey(DefaultAttribute[] defaultAttributeArr, AttributeKey<?> attributeKey) {
        int length = defaultAttributeArr.length - 1;
        int i10 = 0;
        while (i10 <= length) {
            int i11 = (i10 + length) >>> 1;
            AttributeKey<?> attributeKey2 = defaultAttributeArr[i11].key;
            if (attributeKey2 == attributeKey) {
                return i11;
            }
            if (attributeKey2.id() < attributeKey.id()) {
                i10 = i11 + 1;
            } else {
                length = i11 - 1;
            }
        }
        return -(i10 + 1);
    }

    @Override // io.netty.util.AttributeMap
    public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
        DefaultAttribute[] defaultAttributeArr;
        DefaultAttribute[] defaultAttributeArr2;
        ObjectUtil.checkNotNull(attributeKey, "key");
        DefaultAttribute defaultAttribute = null;
        do {
            defaultAttributeArr = this.attributes;
            int iSearchAttributeByKey = searchAttributeByKey(defaultAttributeArr, attributeKey);
            if (iSearchAttributeByKey >= 0) {
                DefaultAttribute defaultAttribute2 = defaultAttributeArr[iSearchAttributeByKey];
                if (!defaultAttribute2.isRemoved()) {
                    return defaultAttribute2;
                }
                if (defaultAttribute == null) {
                    defaultAttribute = new DefaultAttribute(this, attributeKey);
                }
                defaultAttributeArr2 = (DefaultAttribute[]) Arrays.copyOf(defaultAttributeArr, defaultAttributeArr.length);
                defaultAttributeArr2[iSearchAttributeByKey] = defaultAttribute;
            } else {
                if (defaultAttribute == null) {
                    defaultAttribute = new DefaultAttribute(this, attributeKey);
                }
                int length = defaultAttributeArr.length;
                defaultAttributeArr2 = new DefaultAttribute[length + 1];
                orderedCopyOnInsert(defaultAttributeArr, length, defaultAttributeArr2, defaultAttribute);
            }
        } while (!a.a(ATTRIBUTES_UPDATER, this, defaultAttributeArr, defaultAttributeArr2));
        return defaultAttribute;
    }

    private static void orderedCopyOnInsert(DefaultAttribute[] defaultAttributeArr, int i10, DefaultAttribute[] defaultAttributeArr2, DefaultAttribute defaultAttribute) {
        int iId = defaultAttribute.key.id();
        int i11 = i10 - 1;
        while (i11 >= 0 && defaultAttributeArr[i11].key.id() >= iId) {
            defaultAttributeArr2[i11 + 1] = defaultAttributeArr[i11];
            i11--;
        }
        int i12 = i11 + 1;
        defaultAttributeArr2[i12] = defaultAttribute;
        if (i12 > 0) {
            System.arraycopy(defaultAttributeArr, 0, defaultAttributeArr2, 0, i12);
        }
    }
}
