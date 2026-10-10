package io.netty.util.internal;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class TypeParameterMatcher {
    private static final TypeParameterMatcher NOOP = new TypeParameterMatcher() { // from class: io.netty.util.internal.TypeParameterMatcher.1
        @Override // io.netty.util.internal.TypeParameterMatcher
        public boolean match(Object obj) {
            return true;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class ReflectiveMatcher extends TypeParameterMatcher {
        private final Class<?> type;

        @Override // io.netty.util.internal.TypeParameterMatcher
        public boolean match(Object obj) {
            return this.type.isInstance(obj);
        }

        ReflectiveMatcher(Class<?> cls) {
            this.type = cls;
        }
    }

    public abstract boolean match(Object obj);

    private static Class<?> fail(Class<?> cls, String str) {
        throw new IllegalStateException("cannot determine the type of the type parameter '" + str + "': " + cls);
    }

    TypeParameterMatcher() {
    }

    public static TypeParameterMatcher find(Object obj, Class<?> cls, String str) {
        Map<Class<?>, Map<String, TypeParameterMatcher>> mapTypeParameterMatcherFindCache = InternalThreadLocalMap.get().typeParameterMatcherFindCache();
        Class<?> cls2 = obj.getClass();
        Map<String, TypeParameterMatcher> map = mapTypeParameterMatcherFindCache.get(cls2);
        if (map == null) {
            map = new HashMap<>();
            mapTypeParameterMatcherFindCache.put(cls2, map);
        }
        TypeParameterMatcher typeParameterMatcher = map.get(str);
        if (typeParameterMatcher == null) {
            TypeParameterMatcher typeParameterMatcher2 = get(find0(obj, cls, str));
            map.put(str, typeParameterMatcher2);
            return typeParameterMatcher2;
        }
        return typeParameterMatcher;
    }

    private static Class<?> find0(Object obj, Class<?> cls, String str) {
        Class<?> cls2 = obj.getClass();
        while (true) {
            Class<?> superclass = cls2;
            while (superclass.getSuperclass() != cls) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    return fail(cls2, str);
                }
            }
            TypeVariable<Class<? super Object>>[] typeParameters = superclass.getSuperclass().getTypeParameters();
            int i10 = 0;
            while (true) {
                if (i10 < typeParameters.length) {
                    if (str.equals(typeParameters[i10].getName())) {
                        break;
                    }
                    i10++;
                } else {
                    i10 = -1;
                    break;
                }
            }
            if (i10 >= 0) {
                Type genericSuperclass = superclass.getGenericSuperclass();
                if (!(genericSuperclass instanceof ParameterizedType)) {
                    return Object.class;
                }
                Type rawType = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[i10];
                if (rawType instanceof ParameterizedType) {
                    rawType = ((ParameterizedType) rawType).getRawType();
                }
                if (rawType instanceof Class) {
                    return (Class) rawType;
                }
                if (rawType instanceof GenericArrayType) {
                    Type genericComponentType = ((GenericArrayType) rawType).getGenericComponentType();
                    if (genericComponentType instanceof ParameterizedType) {
                        genericComponentType = ((ParameterizedType) genericComponentType).getRawType();
                    }
                    if (genericComponentType instanceof Class) {
                        return Array.newInstance((Class<?>) genericComponentType, 0).getClass();
                    }
                }
                if (rawType instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) rawType;
                    if (!(typeVariable.getGenericDeclaration() instanceof Class)) {
                        return Object.class;
                    }
                    Class<?> cls3 = (Class) typeVariable.getGenericDeclaration();
                    String name = typeVariable.getName();
                    if (!cls3.isAssignableFrom(cls2)) {
                        return Object.class;
                    }
                    str = name;
                    cls = cls3;
                } else {
                    return fail(cls2, str);
                }
            } else {
                throw new IllegalStateException("unknown type parameter '" + str + "': " + cls);
            }
        }
    }

    public static TypeParameterMatcher get(Class<?> cls) {
        Map<Class<?>, TypeParameterMatcher> mapTypeParameterMatcherGetCache = InternalThreadLocalMap.get().typeParameterMatcherGetCache();
        TypeParameterMatcher reflectiveMatcher = mapTypeParameterMatcherGetCache.get(cls);
        if (reflectiveMatcher == null) {
            if (cls == Object.class) {
                reflectiveMatcher = NOOP;
            } else {
                reflectiveMatcher = new ReflectiveMatcher(cls);
            }
            mapTypeParameterMatcherGetCache.put(cls, reflectiveMatcher);
        }
        return reflectiveMatcher;
    }
}
