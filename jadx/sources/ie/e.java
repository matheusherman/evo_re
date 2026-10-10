package ie;

import fc.u;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class e {
    static u a(String str) {
        if (str.equals("SHA-256")) {
            return nc.a.f16308c;
        }
        if (str.equals("SHA-512")) {
            return nc.a.f16312e;
        }
        if (str.equals("SHAKE128")) {
            return nc.a.f16328m;
        }
        if (str.equals("SHAKE256")) {
            return nc.a.f16330n;
        }
        throw new IllegalArgumentException("unrecognized digest: " + str);
    }
}
