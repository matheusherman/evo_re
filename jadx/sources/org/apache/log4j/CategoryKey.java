package org.apache.log4j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class CategoryKey {
    static /* synthetic */ Class class$org$apache$log4j$CategoryKey;
    int hashCache;
    String name;

    public final boolean equals(Object obj) throws Throwable {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        Class<?> clsClass$ = class$org$apache$log4j$CategoryKey;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.CategoryKey");
            class$org$apache$log4j$CategoryKey = clsClass$;
        }
        if (clsClass$ == obj.getClass()) {
            return this.name.equals(((CategoryKey) obj).name);
        }
        return false;
    }

    public final int hashCode() {
        return this.hashCache;
    }

    CategoryKey(String str) {
        this.name = str;
        this.hashCache = str.hashCode();
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }
}
