package org.slf4j.helpers;

import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class f implements bf.b, Serializable {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    @Override // bf.b
    public String getName() {
        return this.name;
    }

    f() {
    }

    protected Object readResolve() {
        return bf.c.i(getName());
    }
}
