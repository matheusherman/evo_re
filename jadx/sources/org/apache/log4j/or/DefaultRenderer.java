package org.apache.log4j.or;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class DefaultRenderer implements ObjectRenderer {
    DefaultRenderer() {
    }

    @Override // org.apache.log4j.or.ObjectRenderer
    public String doRender(Object obj) {
        try {
            return obj.toString();
        } catch (Exception e10) {
            return e10.toString();
        }
    }
}
