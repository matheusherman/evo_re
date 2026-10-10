package org.apache.log4j.net;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class SocketAppender extends AppenderSkeleton {
    public static final int DEFAULT_PORT = 4560;
    static final int DEFAULT_RECONNECTION_DELAY = 30000;
    private static final int RESET_FREQUENCY = 1;
    public static final String ZONE = "_log4j_obj_tcpconnect_appender.local.";
    InetAddress address;
    private boolean advertiseViaMulticastDNS;
    private String application;
    private Connector connector;
    int counter;
    boolean locationInfo;
    ObjectOutputStream oos;
    int port;
    int reconnectionDelay;
    String remoteHost;
    private ZeroConfSupport zeroConf;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class Connector extends Thread {
        boolean interrupted = false;

        Connector() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!this.interrupted) {
                try {
                    Thread.sleep(SocketAppender.this.reconnectionDelay);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Attempting connection to ");
                    stringBuffer.append(SocketAppender.this.address.getHostName());
                    LogLog.debug(stringBuffer.toString());
                    SocketAppender socketAppender = SocketAppender.this;
                    Socket socket = new Socket(socketAppender.address, socketAppender.port);
                    synchronized (this) {
                        try {
                            SocketAppender.this.oos = new ObjectOutputStream(socket.getOutputStream());
                            SocketAppender.this.connector = null;
                            LogLog.debug("Connection established. Exiting connector thread.");
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                } catch (IOException e10) {
                    if (e10 instanceof InterruptedIOException) {
                        Thread.currentThread().interrupt();
                    }
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Could not connect to ");
                    stringBuffer2.append(SocketAppender.this.address.getHostName());
                    stringBuffer2.append(". Exception is ");
                    stringBuffer2.append(e10);
                    LogLog.debug(stringBuffer2.toString());
                } catch (InterruptedException unused) {
                    LogLog.debug("Connector interrupted. Leaving loop.");
                    return;
                } catch (ConnectException unused2) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Remote host ");
                    stringBuffer3.append(SocketAppender.this.address.getHostName());
                    stringBuffer3.append(" refused connection.");
                    LogLog.debug(stringBuffer3.toString());
                }
            }
        }
    }

    public SocketAppender() {
        this.port = DEFAULT_PORT;
        this.reconnectionDelay = 30000;
        this.locationInfo = false;
        this.counter = 0;
    }

    @Override // org.apache.log4j.Appender
    public synchronized void close() {
        try {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.advertiseViaMulticastDNS) {
                this.zeroConf.unadvertise();
            }
            cleanUp();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return false;
    }

    @Override // org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
        if (this.advertiseViaMulticastDNS) {
            ZeroConfSupport zeroConfSupport = new ZeroConfSupport(ZONE, this.port, getName());
            this.zeroConf = zeroConfSupport;
            zeroConfSupport.advertise();
        }
        connect(this.address, this.port);
    }

    @Override // org.apache.log4j.AppenderSkeleton
    public void append(LoggingEvent loggingEvent) {
        if (loggingEvent == null) {
            return;
        }
        if (this.address == null) {
            ErrorHandler errorHandler = this.errorHandler;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No remote host is set for SocketAppender named \"");
            stringBuffer.append(this.name);
            stringBuffer.append("\".");
            errorHandler.error(stringBuffer.toString());
            return;
        }
        if (this.oos != null) {
            try {
                if (this.locationInfo) {
                    loggingEvent.getLocationInformation();
                }
                String str = this.application;
                if (str != null) {
                    loggingEvent.setProperty("application", str);
                }
                loggingEvent.getNDC();
                loggingEvent.getThreadName();
                loggingEvent.getMDCCopy();
                loggingEvent.getRenderedMessage();
                loggingEvent.getThrowableStrRep();
                this.oos.writeObject(loggingEvent);
                this.oos.flush();
                int i10 = this.counter + 1;
                this.counter = i10;
                if (i10 >= 1) {
                    this.counter = 0;
                    this.oos.reset();
                }
            } catch (IOException e10) {
                if (e10 instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
                this.oos = null;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Detected problem with connection: ");
                stringBuffer2.append(e10);
                LogLog.warn(stringBuffer2.toString());
                if (this.reconnectionDelay > 0) {
                    fireConnector();
                } else {
                    this.errorHandler.error("Detected problem with connection, not reconnecting.", e10, 0);
                }
            }
        }
    }

    public void cleanUp() {
        ObjectOutputStream objectOutputStream = this.oos;
        if (objectOutputStream != null) {
            try {
                objectOutputStream.close();
            } catch (IOException e10) {
                if (e10 instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
                LogLog.error("Could not close oos.", e10);
            }
            this.oos = null;
        }
        Connector connector = this.connector;
        if (connector != null) {
            connector.interrupted = true;
            this.connector = null;
        }
    }

    void connect(InetAddress inetAddress, int i10) {
        String string;
        if (this.address == null) {
            return;
        }
        try {
            cleanUp();
            this.oos = new ObjectOutputStream(new Socket(inetAddress, i10).getOutputStream());
        } catch (IOException e10) {
            if (e10 instanceof InterruptedIOException) {
                Thread.currentThread().interrupt();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not connect to remote log4j server at [");
            stringBuffer.append(inetAddress.getHostName());
            stringBuffer.append("].");
            String string2 = stringBuffer.toString();
            if (this.reconnectionDelay > 0) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(string2);
                stringBuffer2.append(" We will try again later.");
                string = stringBuffer2.toString();
                fireConnector();
            } else {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(string2);
                stringBuffer3.append(" We are not retrying.");
                string = stringBuffer3.toString();
                this.errorHandler.error(string, e10, 0);
            }
            LogLog.error(string);
        }
    }

    void fireConnector() {
        if (this.connector == null) {
            LogLog.debug("Starting a new connector thread.");
            Connector connector = new Connector();
            this.connector = connector;
            connector.setDaemon(true);
            this.connector.setPriority(1);
            this.connector.start();
        }
    }

    public String getApplication() {
        return this.application;
    }

    public boolean getLocationInfo() {
        return this.locationInfo;
    }

    public int getPort() {
        return this.port;
    }

    public int getReconnectionDelay() {
        return this.reconnectionDelay;
    }

    public String getRemoteHost() {
        return this.remoteHost;
    }

    public boolean isAdvertiseViaMulticastDNS() {
        return this.advertiseViaMulticastDNS;
    }

    public void setAdvertiseViaMulticastDNS(boolean z10) {
        this.advertiseViaMulticastDNS = z10;
    }

    public void setApplication(String str) {
        this.application = str;
    }

    public void setLocationInfo(boolean z10) {
        this.locationInfo = z10;
    }

    public void setPort(int i10) {
        this.port = i10;
    }

    public void setReconnectionDelay(int i10) {
        this.reconnectionDelay = i10;
    }

    static InetAddress getAddressByName(String str) {
        try {
            return InetAddress.getByName(str);
        } catch (Exception e10) {
            if ((e10 instanceof InterruptedIOException) || (e10 instanceof InterruptedException)) {
                Thread.currentThread().interrupt();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not find address of [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            LogLog.error(stringBuffer.toString(), e10);
            return null;
        }
    }

    public void setRemoteHost(String str) {
        this.address = getAddressByName(str);
        this.remoteHost = str;
    }

    public SocketAppender(InetAddress inetAddress, int i10) {
        this.port = DEFAULT_PORT;
        this.reconnectionDelay = 30000;
        this.locationInfo = false;
        this.counter = 0;
        this.address = inetAddress;
        this.remoteHost = inetAddress.getHostName();
        this.port = i10;
        connect(inetAddress, i10);
    }

    public SocketAppender(String str, int i10) {
        this.reconnectionDelay = 30000;
        this.locationInfo = false;
        this.counter = 0;
        this.port = i10;
        InetAddress addressByName = getAddressByName(str);
        this.address = addressByName;
        this.remoteHost = str;
        connect(addressByName, i10);
    }
}
