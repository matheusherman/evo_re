package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.resolver.AddressResolverGroup;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class BootstrapConfig extends AbstractBootstrapConfig<Bootstrap, Channel> {
    public SocketAddress remoteAddress() {
        return ((Bootstrap) this.bootstrap).remoteAddress();
    }

    public AddressResolverGroup<?> resolver() {
        return ((Bootstrap) this.bootstrap).resolver();
    }

    @Override // io.netty.bootstrap.AbstractBootstrapConfig
    public String toString() {
        StringBuilder sb2 = new StringBuilder(super.toString());
        sb2.setLength(sb2.length() - 1);
        sb2.append(", resolver: ");
        sb2.append(resolver());
        SocketAddress socketAddressRemoteAddress = remoteAddress();
        if (socketAddressRemoteAddress != null) {
            sb2.append(", remoteAddress: ");
            sb2.append(socketAddressRemoteAddress);
        }
        sb2.append(')');
        return sb2.toString();
    }

    BootstrapConfig(Bootstrap bootstrap) {
        super(bootstrap);
    }
}
