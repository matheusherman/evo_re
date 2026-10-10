package org.apache.log4j.net;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.helpers.CyclicBuffer;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class SocketHubAppender extends AppenderSkeleton {
    static final int DEFAULT_PORT = 4560;
    public static final String ZONE = "_log4j_obj_tcpaccept_appender.local.";
    private boolean advertiseViaMulticastDNS;
    private String application;
    private CyclicBuffer buffer;
    private boolean locationInfo;
    private Vector oosList;
    private int port;
    private ServerMonitor serverMonitor;
    private ServerSocket serverSocket;
    private ZeroConfSupport zeroConf;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class ServerMonitor implements Runnable {
        private boolean keepRunning = true;
        private Thread monitorThread;
        private Vector oosList;
        private int port;

        public synchronized void stopMonitor() {
            if (this.keepRunning) {
                LogLog.debug("server monitor thread shutting down");
                this.keepRunning = false;
                try {
                    if (SocketHubAppender.this.serverSocket != null) {
                        SocketHubAppender.this.serverSocket.close();
                        SocketHubAppender.this.serverSocket = null;
                    }
                } catch (IOException unused) {
                }
                try {
                    this.monitorThread.join();
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
                this.monitorThread = null;
                LogLog.debug("server monitor thread shut down");
            }
        }

        public ServerMonitor(int i10, Vector vector) {
            this.port = i10;
            this.oosList = vector;
            Thread thread = new Thread(this);
            this.monitorThread = thread;
            thread.setDaemon(true);
            Thread thread2 = this.monitorThread;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("SocketHubAppender-Monitor-");
            stringBuffer.append(this.port);
            thread2.setName(stringBuffer.toString());
            this.monitorThread.start();
        }

        private void sendCachedEvents(ObjectOutputStream objectOutputStream) throws IOException {
            if (SocketHubAppender.this.buffer != null) {
                for (int i10 = 0; i10 < SocketHubAppender.this.buffer.length(); i10++) {
                    objectOutputStream.writeObject(SocketHubAppender.this.buffer.get(i10));
                }
                objectOutputStream.flush();
                objectOutputStream.reset();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ServerSocket serverSocket;
            Socket socketAccept;
            SocketHubAppender.this.serverSocket = null;
            try {
                try {
                    SocketHubAppender socketHubAppender = SocketHubAppender.this;
                    socketHubAppender.serverSocket = socketHubAppender.createServerSocket(this.port);
                    SocketHubAppender.this.serverSocket.setSoTimeout(1000);
                    try {
                        try {
                            SocketHubAppender.this.serverSocket.setSoTimeout(1000);
                            while (this.keepRunning) {
                                try {
                                    socketAccept = SocketHubAppender.this.serverSocket.accept();
                                } catch (InterruptedIOException unused) {
                                    socketAccept = null;
                                } catch (SocketException e10) {
                                    LogLog.error("exception accepting socket, shutting down server socket.", e10);
                                    this.keepRunning = false;
                                    socketAccept = null;
                                } catch (IOException e11) {
                                    LogLog.error("exception accepting socket.", e11);
                                    socketAccept = null;
                                }
                                if (socketAccept != null) {
                                    try {
                                        InetAddress inetAddress = socketAccept.getInetAddress();
                                        StringBuffer stringBuffer = new StringBuffer();
                                        stringBuffer.append("accepting connection from ");
                                        stringBuffer.append(inetAddress.getHostName());
                                        stringBuffer.append(" (");
                                        stringBuffer.append(inetAddress.getHostAddress());
                                        stringBuffer.append(")");
                                        LogLog.debug(stringBuffer.toString());
                                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socketAccept.getOutputStream());
                                        if (SocketHubAppender.this.buffer != null && SocketHubAppender.this.buffer.length() > 0) {
                                            sendCachedEvents(objectOutputStream);
                                        }
                                        this.oosList.addElement(objectOutputStream);
                                    } catch (IOException e12) {
                                        if (e12 instanceof InterruptedIOException) {
                                            Thread.currentThread().interrupt();
                                        }
                                        LogLog.error("exception creating output stream on socket.", e12);
                                    }
                                }
                            }
                            serverSocket = SocketHubAppender.this.serverSocket;
                        } catch (SocketException e13) {
                            LogLog.error("exception setting timeout, shutting down server socket.", e13);
                            serverSocket = SocketHubAppender.this.serverSocket;
                        }
                        serverSocket.close();
                    } catch (Throwable th) {
                        try {
                            SocketHubAppender.this.serverSocket.close();
                        } catch (InterruptedIOException unused2) {
                            Thread.currentThread().interrupt();
                        } catch (IOException unused3) {
                        }
                        throw th;
                    }
                } catch (Exception e14) {
                    if ((e14 instanceof InterruptedIOException) || (e14 instanceof InterruptedException)) {
                        Thread.currentThread().interrupt();
                    }
                    LogLog.error("exception setting timeout, shutting down server socket.", e14);
                    this.keepRunning = false;
                }
            } catch (InterruptedIOException unused4) {
                Thread.currentThread().interrupt();
            } catch (IOException unused5) {
            }
        }
    }

    public SocketHubAppender() {
        this.port = 4560;
        this.oosList = new Vector();
        this.serverMonitor = null;
        this.locationInfo = false;
        this.buffer = null;
    }

    @Override // org.apache.log4j.Appender
    public synchronized void close() {
        try {
            if (this.closed) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("closing SocketHubAppender ");
            stringBuffer.append(getName());
            LogLog.debug(stringBuffer.toString());
            this.closed = true;
            if (this.advertiseViaMulticastDNS) {
                this.zeroConf.unadvertise();
            }
            cleanUp();
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("SocketHubAppender ");
            stringBuffer2.append(getName());
            stringBuffer2.append(" closed");
            LogLog.debug(stringBuffer2.toString());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return false;
    }

    private void startServer() {
        this.serverMonitor = new ServerMonitor(this.port, this.oosList);
    }

    @Override // org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
        if (this.advertiseViaMulticastDNS) {
            ZeroConfSupport zeroConfSupport = new ZeroConfSupport(ZONE, this.port, getName());
            this.zeroConf = zeroConfSupport;
            zeroConfSupport.advertise();
        }
        startServer();
    }

    @Override // org.apache.log4j.AppenderSkeleton
    public void append(LoggingEvent loggingEvent) {
        ObjectOutputStream objectOutputStream;
        if (loggingEvent != null) {
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
            CyclicBuffer cyclicBuffer = this.buffer;
            if (cyclicBuffer != null) {
                cyclicBuffer.add(loggingEvent);
            }
        }
        if (loggingEvent == null || this.oosList.size() == 0) {
            return;
        }
        int i10 = 0;
        while (i10 < this.oosList.size()) {
            try {
                objectOutputStream = (ObjectOutputStream) this.oosList.elementAt(i10);
            } catch (ArrayIndexOutOfBoundsException unused) {
                objectOutputStream = null;
            }
            if (objectOutputStream == null) {
                return;
            }
            try {
                objectOutputStream.writeObject(loggingEvent);
                objectOutputStream.flush();
                objectOutputStream.reset();
            } catch (IOException e10) {
                if (e10 instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
                this.oosList.removeElementAt(i10);
                LogLog.debug("dropped connection");
                i10--;
            }
            i10++;
        }
    }

    public void cleanUp() {
        LogLog.debug("stopping ServerSocket");
        this.serverMonitor.stopMonitor();
        this.serverMonitor = null;
        LogLog.debug("closing client connections");
        while (this.oosList.size() != 0) {
            ObjectOutputStream objectOutputStream = (ObjectOutputStream) this.oosList.elementAt(0);
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (InterruptedIOException e10) {
                    Thread.currentThread().interrupt();
                    LogLog.error("could not close oos.", e10);
                } catch (IOException e11) {
                    LogLog.error("could not close oos.", e11);
                }
                this.oosList.removeElementAt(0);
            }
        }
    }

    protected ServerSocket createServerSocket(int i10) {
        return new ServerSocket(i10);
    }

    public String getApplication() {
        return this.application;
    }

    public int getBufferSize() {
        CyclicBuffer cyclicBuffer = this.buffer;
        if (cyclicBuffer == null) {
            return 0;
        }
        return cyclicBuffer.getMaxSize();
    }

    public boolean getLocationInfo() {
        return this.locationInfo;
    }

    public int getPort() {
        return this.port;
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

    public void setBufferSize(int i10) {
        this.buffer = new CyclicBuffer(i10);
    }

    public void setLocationInfo(boolean z10) {
        this.locationInfo = z10;
    }

    public void setPort(int i10) {
        this.port = i10;
    }

    public SocketHubAppender(int i10) {
        this.port = 4560;
        this.oosList = new Vector();
        this.serverMonitor = null;
        this.locationInfo = false;
        this.buffer = null;
        this.port = i10;
        startServer();
    }
}
