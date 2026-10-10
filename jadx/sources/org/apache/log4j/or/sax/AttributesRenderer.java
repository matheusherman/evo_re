package org.apache.log4j.or.sax;

import org.apache.log4j.or.ObjectRenderer;
import org.xml.sax.Attributes;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class AttributesRenderer implements ObjectRenderer {
    @Override // org.apache.log4j.or.ObjectRenderer
    public String doRender(Object obj) {
        if (!(obj instanceof Attributes)) {
            try {
                return obj.toString();
            } catch (Exception e10) {
                return e10.toString();
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        Attributes attributes = (Attributes) obj;
        int length = attributes.getLength();
        boolean z10 = true;
        for (int i10 = 0; i10 < length; i10++) {
            if (z10) {
                z10 = false;
            } else {
                stringBuffer.append(", ");
            }
            stringBuffer.append(attributes.getQName(i10));
            stringBuffer.append('=');
            stringBuffer.append(attributes.getValue(i10));
        }
        return stringBuffer.toString();
    }
}
