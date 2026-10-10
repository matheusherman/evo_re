package com.live.evo.util;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class w {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements com.google.gson.j<HashMap> {
        @Override // com.google.gson.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public HashMap<String, Object> deserialize(com.google.gson.k kVar, Type type, com.google.gson.i iVar) {
            HashMap<String, Object> map = new HashMap<>();
            for (Map.Entry<String, com.google.gson.k> entry : kVar.f().o()) {
                map.put(entry.getKey(), entry.getValue());
            }
            return map;
        }

        a() {
        }
    }

    public static com.google.gson.f b() {
        return new com.google.gson.f().d().e("yyyy-MM-dd HH:mm:ss");
    }

    public static com.google.gson.f d() {
        return new com.google.gson.f().d().e("yyyy-MM-dd HH:mm:ss").c(HashMap.class, new a());
    }

    public static com.google.gson.e a() {
        return b().b();
    }

    public static com.google.gson.e c() {
        return d().b();
    }
}
