package org.apache.log4j.or;

import org.apache.log4j.Layout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ThreadGroupRenderer implements ObjectRenderer {
    @Override // org.apache.log4j.or.ObjectRenderer
    public String doRender(Object obj) {
        if (!(obj instanceof ThreadGroup)) {
            try {
                return obj.toString();
            } catch (Exception e10) {
                return e10.toString();
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        ThreadGroup threadGroup = (ThreadGroup) obj;
        stringBuffer.append("java.lang.ThreadGroup[name=");
        stringBuffer.append(threadGroup.getName());
        stringBuffer.append(", maxpri=");
        stringBuffer.append(threadGroup.getMaxPriority());
        stringBuffer.append("]");
        int iActiveCount = threadGroup.activeCount();
        Thread[] threadArr = new Thread[iActiveCount];
        threadGroup.enumerate(threadArr);
        for (int i10 = 0; i10 < iActiveCount; i10++) {
            stringBuffer.append(Layout.LINE_SEP);
            stringBuffer.append("   Thread=[");
            stringBuffer.append(threadArr[i10].getName());
            stringBuffer.append(",");
            stringBuffer.append(threadArr[i10].getPriority());
            stringBuffer.append(",");
            stringBuffer.append(threadArr[i10].isDaemon());
            stringBuffer.append("]");
        }
        return stringBuffer.toString();
    }
}
