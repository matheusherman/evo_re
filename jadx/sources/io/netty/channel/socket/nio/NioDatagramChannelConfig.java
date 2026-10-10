package io.netty.channel.socket.nio;

import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.channel.socket.DefaultDatagramChannelConfig;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.channels.DatagramChannel;
import java.util.Enumeration;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class NioDatagramChannelConfig extends DefaultDatagramChannelConfig {
    private static final Method GET_OPTION;
    private static final Object IP_MULTICAST_IF;
    private static final Object IP_MULTICAST_LOOP;
    private static final Object IP_MULTICAST_TTL;
    private static final Method SET_OPTION;
    private final DatagramChannel javaChannel;

    static {
        Class<?> cls;
        Class<?> cls2;
        Object obj;
        Object obj2;
        Class<?> cls3;
        Method declaredMethod;
        Method method;
        ClassLoader classLoader = PlatformDependent.getClassLoader(DatagramChannel.class);
        Object obj3 = null;
        try {
            cls = Class.forName("java.net.SocketOption", true, classLoader);
        } catch (Exception unused) {
            cls = null;
        }
        try {
            cls2 = Class.forName("java.net.StandardSocketOptions", true, classLoader);
        } catch (Exception unused2) {
            cls2 = null;
        }
        if (cls != null) {
            try {
                Object obj4 = cls2.getDeclaredField("IP_MULTICAST_TTL").get(null);
                try {
                    obj = cls2.getDeclaredField("IP_MULTICAST_IF").get(null);
                    try {
                        obj2 = cls2.getDeclaredField("IP_MULTICAST_LOOP").get(null);
                        try {
                            cls3 = Class.forName("java.nio.channels.NetworkChannel", true, classLoader);
                        } catch (Throwable unused3) {
                            cls3 = null;
                        }
                        if (cls3 == null) {
                            method = null;
                            declaredMethod = null;
                        } else {
                            try {
                                Method declaredMethod2 = cls3.getDeclaredMethod("getOption", cls);
                                try {
                                    declaredMethod = cls3.getDeclaredMethod("setOption", cls, Object.class);
                                    method = declaredMethod2;
                                } catch (Exception e10) {
                                    throw new Error("cannot locate the setOption() method", e10);
                                }
                            } catch (Exception e11) {
                                throw new Error("cannot locate the getOption() method", e11);
                            }
                        }
                        obj3 = obj4;
                    } catch (Exception e12) {
                        throw new Error("cannot locate the IP_MULTICAST_LOOP field", e12);
                    }
                } catch (Exception e13) {
                    throw new Error("cannot locate the IP_MULTICAST_IF field", e13);
                }
            } catch (Exception e14) {
                throw new Error("cannot locate the IP_MULTICAST_TTL field", e14);
            }
        } else {
            method = null;
            declaredMethod = null;
            obj2 = null;
            obj = null;
        }
        IP_MULTICAST_TTL = obj3;
        IP_MULTICAST_IF = obj;
        IP_MULTICAST_LOOP = obj2;
        GET_OPTION = method;
        SET_OPTION = declaredMethod;
    }

    private Object getOption0(Object obj) {
        Method method = GET_OPTION;
        if (method == null) {
            throw new UnsupportedOperationException();
        }
        try {
            return method.invoke(this.javaChannel, obj);
        } catch (Exception e10) {
            throw new ChannelException(e10);
        }
    }

    private void setOption0(Object obj, Object obj2) {
        Method method = SET_OPTION;
        if (method == null) {
            throw new UnsupportedOperationException();
        }
        try {
            method.invoke(this.javaChannel, obj, obj2);
        } catch (Exception e10) {
            throw new ChannelException(e10);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig
    protected void autoReadCleared() {
        ((NioDatagramChannel) this.channel).clearReadPending0();
    }

    @Override // io.netty.channel.socket.DefaultDatagramChannelConfig
    public NetworkInterface getNetworkInterface() {
        return (NetworkInterface) getOption0(IP_MULTICAST_IF);
    }

    @Override // io.netty.channel.socket.DefaultDatagramChannelConfig
    public int getTimeToLive() {
        return ((Integer) getOption0(IP_MULTICAST_TTL)).intValue();
    }

    @Override // io.netty.channel.socket.DefaultDatagramChannelConfig
    public boolean isLoopbackModeDisabled() {
        return ((Boolean) getOption0(IP_MULTICAST_LOOP)).booleanValue();
    }

    @Override // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public DatagramChannelConfig setAutoRead(boolean z10) {
        super.setAutoRead(z10);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultDatagramChannelConfig
    public DatagramChannelConfig setLoopbackModeDisabled(boolean z10) {
        setOption0(IP_MULTICAST_LOOP, Boolean.valueOf(z10));
        return this;
    }

    @Override // io.netty.channel.socket.DefaultDatagramChannelConfig
    public DatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface) {
        setOption0(IP_MULTICAST_IF, networkInterface);
        return this;
    }

    @Override // io.netty.channel.socket.DefaultDatagramChannelConfig
    public DatagramChannelConfig setTimeToLive(int i10) {
        setOption0(IP_MULTICAST_TTL, Integer.valueOf(i10));
        return this;
    }

    NioDatagramChannelConfig(NioDatagramChannel nioDatagramChannel, DatagramChannel datagramChannel) {
        super(nioDatagramChannel, datagramChannel.socket());
        this.javaChannel = datagramChannel;
    }

    @Override // io.netty.channel.socket.DefaultDatagramChannelConfig
    public InetAddress getInterface() {
        NetworkInterface networkInterface = getNetworkInterface();
        if (networkInterface != null) {
            Enumeration<InetAddress> enumerationAddressesFromNetworkInterface = SocketUtils.addressesFromNetworkInterface(networkInterface);
            if (enumerationAddressesFromNetworkInterface.hasMoreElements()) {
                return enumerationAddressesFromNetworkInterface.nextElement();
            }
            return null;
        }
        return null;
    }

    @Override // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        if (PlatformDependent.javaVersion() >= 7 && (channelOption instanceof NioChannelOption)) {
            return (T) NioChannelOption.getOption(this.javaChannel, (NioChannelOption) channelOption);
        }
        return (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.socket.DefaultDatagramChannelConfig
    public DatagramChannelConfig setInterface(InetAddress inetAddress) {
        try {
            setNetworkInterface(NetworkInterface.getByInetAddress(inetAddress));
            return this;
        } catch (SocketException e10) {
            throw new ChannelException(e10);
        }
    }

    @Override // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t10) {
        if (PlatformDependent.javaVersion() >= 7 && (channelOption instanceof NioChannelOption)) {
            return NioChannelOption.setOption(this.javaChannel, (NioChannelOption) channelOption, t10);
        }
        return super.setOption(channelOption, t10);
    }
}
