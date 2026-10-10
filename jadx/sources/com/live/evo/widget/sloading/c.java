package com.live.evo.widget.sloading;

import s5.d;
import s5.e;
import s5.f;
import s5.g;
import s5.h;
import s5.i;
import s5.j;
import s5.k;
import s5.l;
import s5.m;
import s5.n;
import s5.o;
import s5.p;
import s5.q;
import s5.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum c {
    CIRCLE(s5.b.class),
    CIRCLE_CLOCK(s5.c.class),
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
