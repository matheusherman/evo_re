package io.netty.channel;

import io.netty.channel.Channel;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ReflectiveChannelFactory<T extends Channel> implements ChannelFactory<T> {
    private final Constructor<? extends T> constructor;

    @Override // io.netty.bootstrap.ChannelFactory
    public T newChannel() {
        try {
            return this.constructor.newInstance(null);
        } catch (Throwable th) {
            throw new ChannelException("Unable to create Channel from class " + this.constructor.getDeclaringClass(), th);
        }
    }

    public String toString() {
        return StringUtil.simpleClassName((Class<?>) ReflectiveChannelFactory.class) + '(' + StringUtil.simpleClassName((Class<?>) this.constructor.getDeclaringClass()) + ".class)";
    }

    public ReflectiveChannelFactory(Class<? extends T> cls) {
        ObjectUtil.checkNotNull(cls, "clazz");
        try {
            this.constructor = cls.getConstructor(null);
        } catch (NoSuchMethodException e10) {
            throw new IllegalArgumentException("Class " + StringUtil.simpleClassName((Class<?>) cls) + " does not have a public non-arg constructor", e10);
        }
    }
}
