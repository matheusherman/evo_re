package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class NetUtilInitializations {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NetUtilInitializations.class);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class NetworkIfaceAndInetAddress {
        private final InetAddress address;
        private final NetworkInterface iface;

        public InetAddress address() {
            return this.address;
        }

        public NetworkInterface iface() {
            return this.iface;
        }

        NetworkIfaceAndInetAddress(NetworkInterface networkInterface, InetAddress inetAddress) {
            this.iface = networkInterface;
            this.address = inetAddress;
        }
    }

    static Inet4Address createLocalhost4() {
        try {
            return (Inet4Address) InetAddress.getByAddress("localhost", new byte[]{127, 0, 0, 1});
        } catch (Exception e10) {
            PlatformDependent.throwException(e10);
            return null;
        }
    }

    static Inet6Address createLocalhost6() {
        try {
            return (Inet6Address) InetAddress.getByAddress("localhost", new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1});
        } catch (Exception e10) {
            PlatformDependent.throwException(e10);
            return null;
        }
    }

    static NetworkIfaceAndInetAddress determineLoopback(Inet4Address inet4Address, Inet6Address inet6Address) {
        Iterator it;
        NetworkInterface networkInterface;
        InetAddress inetAddressNextElement;
        InetAddress inetAddress;
        InetAddress inetAddress2;
        ArrayList<NetworkInterface> arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                    if (SocketUtils.addressesFromNetworkInterface(networkInterfaceNextElement).hasMoreElements()) {
                        arrayList.add(networkInterfaceNextElement);
                    }
                }
            }
            loop1: while (true) {
                if (!it.hasNext()) {
                    networkInterface = null;
                    inetAddressNextElement = null;
                    break;
                }
                networkInterface = (NetworkInterface) it.next();
                Enumeration<InetAddress> enumerationAddressesFromNetworkInterface = SocketUtils.addressesFromNetworkInterface(networkInterface);
                while (enumerationAddressesFromNetworkInterface.hasMoreElements()) {
                    inetAddressNextElement = enumerationAddressesFromNetworkInterface.nextElement();
                    if (inetAddressNextElement.isLoopbackAddress()) {
                        break loop1;
                    }
                }
            }
        } catch (SocketException e10) {
            logger.warn("Failed to retrieve the list of available network interfaces", (Throwable) e10);
        }
        it = arrayList.iterator();
        if (networkInterface == null) {
            try {
                for (NetworkInterface networkInterface2 : arrayList) {
                    if (networkInterface2.isLoopback()) {
                        Enumeration<InetAddress> enumerationAddressesFromNetworkInterface2 = SocketUtils.addressesFromNetworkInterface(networkInterface2);
                        if (enumerationAddressesFromNetworkInterface2.hasMoreElements()) {
                            try {
                                inetAddressNextElement = enumerationAddressesFromNetworkInterface2.nextElement();
                                networkInterface = networkInterface2;
                                break;
                            } catch (SocketException e11) {
                                e = e11;
                                networkInterface = networkInterface2;
                                logger.warn("Failed to find the loopback interface", (Throwable) e);
                            }
                        }
                    }
                }
                if (networkInterface == null) {
                    logger.warn("Failed to find the loopback interface");
                }
            } catch (SocketException e12) {
                e = e12;
            }
        }
        if (networkInterface == null) {
            if (inetAddressNextElement == null) {
                try {
                    if (NetworkInterface.getByInetAddress(inet6Address) != null) {
                        logger.debug("Using hard-coded IPv6 localhost address: {}", inet6Address);
                    } else {
                        inetAddress = inetAddressNextElement;
                    }
                    if (inetAddress == null) {
                        inetAddress = inet6Address;
                        logger.debug("Using hard-coded IPv4 localhost address: {}", inet4Address);
                        inetAddress2 = inet4Address;
                    } else {
                        inetAddress = inet6Address;
                        inetAddress2 = inetAddress;
                    }
                } catch (Exception unused) {
                    if (inetAddressNextElement != null) {
                        inetAddress2 = inetAddressNextElement;
                    }
                    return new NetworkIfaceAndInetAddress(networkInterface, inetAddress2);
                } catch (Throwable th) {
                    if (inetAddressNextElement == null) {
                        logger.debug("Using hard-coded IPv4 localhost address: {}", inet4Address);
                    }
                    throw th;
                }
            }
            return new NetworkIfaceAndInetAddress(networkInterface, inetAddress2);
        }
        logger.debug("Loopback interface: {} ({}, {})", networkInterface.getName(), networkInterface.getDisplayName(), inetAddressNextElement.getHostAddress());
        inetAddress2 = inetAddressNextElement;
        return new NetworkIfaceAndInetAddress(networkInterface, inetAddress2);
    }

    private NetUtilInitializations() {
    }
}
