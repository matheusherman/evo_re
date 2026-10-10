package org.apache.log4j.net;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class SocketNode implements Runnable {
    static /* synthetic */ Class class$org$apache$log4j$net$SocketNode;
    static Logger logger;
    LoggerRepository hierarchy;
    ObjectInputStream ois;
    Socket socket;

    static {
        Class clsClass$ = class$org$apache$log4j$net$SocketNode;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.net.SocketNode");
            class$org$apache$log4j$net$SocketNode = clsClass$;
        }
        logger = Logger.getLogger(clsClass$);
    }

    public SocketNode(Socket socket, LoggerRepository loggerRepository) {
        this.socket = socket;
        this.hierarchy = loggerRepository;
        try {
            this.ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (InterruptedIOException e10) {
            Thread.currentThread().interrupt();
            Logger logger2 = logger;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not open ObjectInputStream to ");
            stringBuffer.append(socket);
            logger2.error(stringBuffer.toString(), e10);
        } catch (IOException e11) {
            Logger logger3 = logger;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not open ObjectInputStream to ");
            stringBuffer2.append(socket);
            logger3.error(stringBuffer2.toString(), e11);
        } catch (RuntimeException e12) {
            Logger logger4 = logger;
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Could not open ObjectInputStream to ");
            stringBuffer3.append(socket);
            logger4.error(stringBuffer3.toString(), e12);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Socket socket;
        try {
            try {
                try {
                    try {
                        ObjectInputStream objectInputStream = this.ois;
                        if (objectInputStream == null) {
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Exception e10) {
                                    logger.info("Could not close connection.", e10);
                                }
                            }
                            socket = this.socket;
                            if (socket == null) {
                                return;
                            }
                            try {
                                socket.close();
                                return;
                            } catch (InterruptedIOException unused) {
                                Thread.currentThread().interrupt();
                                return;
                            } catch (IOException unused2) {
                                return;
                            }
                        }
                        while (true) {
                            LoggingEvent loggingEvent = (LoggingEvent) this.ois.readObject();
                            Logger logger2 = this.hierarchy.getLogger(loggingEvent.getLoggerName());
                            if (loggingEvent.getLevel().isGreaterOrEqual(logger2.getEffectiveLevel())) {
                                logger2.callAppenders(loggingEvent);
                            }
                        }
                    } catch (Throwable th) {
                        ObjectInputStream objectInputStream2 = this.ois;
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (Exception e11) {
                                logger.info("Could not close connection.", e11);
                            }
                        }
                        Socket socket2 = this.socket;
                        if (socket2 == null) {
                            throw th;
                        }
                        try {
                            socket2.close();
                            throw th;
                        } catch (InterruptedIOException unused3) {
                            Thread.currentThread().interrupt();
                            throw th;
                        } catch (IOException unused4) {
                            throw th;
                        }
                    }
                } catch (SocketException unused5) {
                    logger.info("Caught java.net.SocketException closing conneciton.");
                    ObjectInputStream objectInputStream3 = this.ois;
                    if (objectInputStream3 != null) {
                        try {
                            objectInputStream3.close();
                        } catch (Exception e12) {
                            logger.info("Could not close connection.", e12);
                        }
                    }
                    socket = this.socket;
                    if (socket == null) {
                    }
                }
            } catch (IOException e13) {
                Logger logger3 = logger;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Caught java.io.IOException: ");
                stringBuffer.append(e13);
                logger3.info(stringBuffer.toString());
                logger.info("Closing connection.");
                ObjectInputStream objectInputStream4 = this.ois;
                if (objectInputStream4 != null) {
                    try {
                        objectInputStream4.close();
                    } catch (Exception e14) {
                        logger.info("Could not close connection.", e14);
                    }
                }
                socket = this.socket;
                if (socket == null) {
                }
            } catch (Exception e15) {
                logger.error("Unexpected exception. Closing conneciton.", e15);
                ObjectInputStream objectInputStream5 = this.ois;
                if (objectInputStream5 != null) {
                    try {
                        objectInputStream5.close();
                    } catch (Exception e16) {
                        logger.info("Could not close connection.", e16);
                    }
                }
                socket = this.socket;
                if (socket == null) {
                }
            }
        } catch (EOFException unused6) {
            logger.info("Caught java.io.EOFException closing conneciton.");
            ObjectInputStream objectInputStream6 = this.ois;
            if (objectInputStream6 != null) {
                try {
                    objectInputStream6.close();
                } catch (Exception e17) {
                    logger.info("Could not close connection.", e17);
                }
            }
            socket = this.socket;
            if (socket == null) {
            }
        } catch (InterruptedIOException e18) {
            Thread.currentThread().interrupt();
            Logger logger4 = logger;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Caught java.io.InterruptedIOException: ");
            stringBuffer2.append(e18);
            logger4.info(stringBuffer2.toString());
            logger.info("Closing connection.");
            ObjectInputStream objectInputStream7 = this.ois;
            if (objectInputStream7 != null) {
                try {
                    objectInputStream7.close();
                } catch (Exception e19) {
                    logger.info("Could not close connection.", e19);
                }
            }
            socket = this.socket;
            if (socket == null) {
            }
        }
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }
}
