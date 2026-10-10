package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class k {
    public boolean h() {
        return this instanceof h;
    }

    public boolean i() {
        return this instanceof m;
    }

    public boolean k() {
        return this instanceof n;
    }

    public boolean m() {
        return this instanceof p;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            g3.c cVar = new g3.c(stringWriter);
            cVar.x(true);
            com.google.gson.internal.m.b(this, cVar);
            return stringWriter.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    @Deprecated
    public k() {
    }

    public h e() {
        if (h()) {
            return (h) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public n f() {
        if (k()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public p g() {
        if (m()) {
            return (p) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }
}
