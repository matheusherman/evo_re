package org.apache.log4j.varia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class Roller {
    static Logger cat;
    static /* synthetic */ Class class$org$apache$log4j$varia$Roller;
    static String host;
    static int port;

    static void roll() {
        try {
            Socket socket = new Socket(host, port);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream.writeUTF(ExternallyRolledFileAppender.ROLL_OVER);
            String utf = dataInputStream.readUTF();
            if (ExternallyRolledFileAppender.OK.equals(utf)) {
                cat.info("Roll over signal acknowledged by remote appender.");
            } else {
                Logger logger = cat;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Unexpected return code ");
                stringBuffer.append(utf);
                stringBuffer.append(" from remote entity.");
                logger.warn(stringBuffer.toString());
                System.exit(2);
            }
        } catch (IOException e10) {
            Logger logger2 = cat;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not send roll signal on host ");
            stringBuffer2.append(host);
            stringBuffer2.append(" port ");
            stringBuffer2.append(port);
            stringBuffer2.append(" .");
            logger2.error(stringBuffer2.toString(), e10);
            System.exit(2);
        }
        System.exit(0);
    }

    static {
        Class clsClass$ = class$org$apache$log4j$varia$Roller;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.varia.Roller");
            class$org$apache$log4j$varia$Roller = clsClass$;
        }
        cat = Logger.getLogger(clsClass$);
    }

    static void init(String str, String str2) throws Throwable {
        host = str;
        try {
            port = Integer.parseInt(str2);
        } catch (NumberFormatException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Second argument ");
            stringBuffer.append(str2);
            stringBuffer.append(" is not a valid integer.");
            usage(stringBuffer.toString());
        }
    }

    static void usage(String str) throws Throwable {
        System.err.println(str);
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Usage: java ");
        Class clsClass$ = class$org$apache$log4j$varia$Roller;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.varia.Roller");
            class$org$apache$log4j$varia$Roller = clsClass$;
        }
        stringBuffer.append(clsClass$.getName());
        stringBuffer.append("host_name port_number");
        printStream.println(stringBuffer.toString());
        System.exit(1);
    }

    Roller() {
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    public static void main(String[] strArr) throws Throwable {
        BasicConfigurator.configure();
        if (strArr.length == 2) {
            init(strArr[0], strArr[1]);
        } else {
            usage("Wrong number of arguments.");
        }
        roll();
    }
}
