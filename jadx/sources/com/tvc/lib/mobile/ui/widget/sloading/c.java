package com.tvc.lib.mobile.ui.widget.sloading;

import x7.d;
import x7.e;
import x7.f;
import x7.g;
import x7.h;
import x7.i;
import x7.j;
import x7.k;
import x7.l;
import x7.m;
import x7.n;
import x7.o;
import x7.p;
import x7.q;
import x7.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum c {
    CIRCLE(x7.b.class),
    CIRCLE_CLOCK(x7.c.class),
    STAR_LOADING(p.class),
    LEAF_ROTATE(i.class),
    DOUBLE_CIRCLE(d.class),
    PAC_MAN(j.class),
    ELASTIC_BALL(e.class),
    INFECTION_BALL(g.class),
    INTERTWINE(h.class),
    TEXT(q.class),
    SEARCH_PATH(m.class),
    ROTATE_CIRCLE(k.class),
    SINGLE_CIRCLE(n.class),
    SNAKE_CIRCLE(o.class),
    TRANSLATE_CIRCLE(r.class),
    FADING_CIRCLE(f.class),
    ROTATE_SAMECIRCLE(l.class);

    private final Class<?> mBuilderClass;

    <T extends a> T f() {
        try {
            return (T) this.mBuilderClass.newInstance();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    c(Class cls) {
        this.mBuilderClass = cls;
    }
}
