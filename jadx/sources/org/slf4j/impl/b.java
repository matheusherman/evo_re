package org.slf4j.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.log4j.LogManager;
import org.slf4j.helpers.i;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b implements bf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ConcurrentMap<String, bf.b> f17136a = new ConcurrentHashMap();

    static {
        try {
            Class.forName("org.apache.log4j.Log4jLoggerFactory");
            i.a("Detected both log4j-over-slf4j.jar AND bound slf4j-log4j12.jar on the class path, preempting StackOverflowError. ");
            i.a("See also http://www.slf4j.org/codes.html#log4jDelegationLoop for more details.");
            throw new IllegalStateException("Detected both log4j-over-slf4j.jar AND bound slf4j-log4j12.jar on the class path, preempting StackOverflowError. See also http://www.slf4j.org/codes.html#log4jDelegationLoop for more details.");
        } catch (ClassNotFoundException unused) {
        }
    }

    @Override // bf.a
    public bf.b getLogger(String str) {
        bf.b bVar = this.f17136a.get(str);
        if (bVar != null) {
            return bVar;
        }
        a aVar = new a(str.equalsIgnoreCase("ROOT") ? LogManager.getRootLogger() : LogManager.getLogger(str));
        bf.b bVarPutIfAbsent = this.f17136a.putIfAbsent(str, aVar);
        return bVarPutIfAbsent == null ? aVar : bVarPutIfAbsent;
    }

    public b() {
        LogManager.getRootLogger();
    }
}
