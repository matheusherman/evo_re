package org.apache.log4j.net;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class TelnetAppender extends AppenderSkeleton {
    private int port = 23;
    private SocketHandler sh;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    protected class SocketHandler extends Thread {
        private ServerSocket serverSocket;
        private Vector writers = new Vector();
        private Vector connections = new Vector();
        private int MAX_CONNECTIONS = 20;

        public void close() {
            synchronized (this) {
                try {
                    Enumeration enumerationElements = this.connections.elements();
                    while (enumerationElements.hasMoreElements()) {
                        try {
                            ((Socket) enumerationElements.nextElement()).close();
                        } catch (InterruptedIOException unused) {
                            Thread.currentThread().interrupt();
                        } catch (IOException | RuntimeException unused2) {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            try {
                this.serverSocket.close();
            } catch (InterruptedIOException unused3) {
                Thread.currentThread().interrupt();
            } catch (IOException | RuntimeException unused4) {
            }
        }

        public synchronized void send(String str) {
            Iterator it = this.connections.iterator();
            Iterator it2 = this.writers.iterator();
            while (it2.hasNext()) {
                it.next();
                PrintWriter printWriter = (PrintWriter) it2.next();
                printWriter.print(str);
                if (printWriter.checkError()) {
                    it.remove();
                    it2.remove();
                }
            }
        }

        public SocketHandler(int i10) {
            this.serverSocket = new ServerSocket(i10);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("TelnetAppender-");
            stringBuffer.append(getName());
            stringBuffer.append("-");
            stringBuffer.append(i10);
            setName(stringBuffer.toString());
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!this.serverSocket.isClosed()) {
                try {
                    Socket socketAccept = this.serverSocket.accept();
                    PrintWriter printWriter = new PrintWriter(socketAccept.getOutputStream());
                    if (this.connections.size() < this.MAX_CONNECTIONS) {
                        synchronized (this) {
                            try {
                                this.connections.addElement(socketAccept);
                                this.writers.addElement(printWriter);
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("TelnetAppender v1.0 (");
                                stringBuffer.append(this.connections.size());
                                stringBuffer.append(" active connections)\r\n\r\n");
                                printWriter.print(stringBuffer.toString());
                                printWriter.flush();
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } else {
                        printWriter.print("Too many connections.\r\n");
                        printWriter.flush();
                        socketAccept.close();
                    }
                } catch (Exception e10) {
                    if ((e10 instanceof InterruptedIOException) || (e10 instanceof InterruptedException)) {
                        Thread.currentThread().interrupt();
                    }
                    if (!this.serverSocket.isClosed()) {
                        LogLog.error("Encountered error while in SocketHandler loop.", e10);
                    }
                }
            }
            try {
                this.serverSocket.close();
            } catch (InterruptedIOException unused) {
                Thread.currentThread().interrupt();
            } catch (IOException unused2) {
            }
        }

        public void finalize() {
            close();
        }
    }

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return true;
    }

    @Override // org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
        try {
            SocketHandler socketHandler = new SocketHandler(this.port);
            this.sh = socketHandler;
            socketHandler.start();
        } catch (InterruptedIOException e10) {
            Thread.currentThread().interrupt();
            e10.printStackTrace();
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (RuntimeException e12) {
            e12.printStackTrace();
        }
        super.activateOptions();
    }

    @Override // org.apache.log4j.AppenderSkeleton
    protected void append(LoggingEvent loggingEvent) {
        String[] throwableStrRep;
        SocketHandler socketHandler = this.sh;
        if (socketHandler != null) {
            socketHandler.send(this.layout.format(loggingEvent));
            if (!this.layout.ignoresThrowable() || (throwableStrRep = loggingEvent.getThrowableStrRep()) == null) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : throwableStrRep) {
                stringBuffer.append(str);
                stringBuffer.append("\r\n");
            }
            this.sh.send(stringBuffer.toString());
        }
    }

    @Override // org.apache.log4j.Appender
    public void close() {
        SocketHandler socketHandler = this.sh;
        if (socketHandler != null) {
            socketHandler.close();
            try {
                this.sh.join();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int i10) {
        this.port = i10;
    }
}
