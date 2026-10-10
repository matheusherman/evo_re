package org.apache.log4j.config;

import androidx.exifinterface.media.ExifInterface;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import org.apache.log4j.Appender;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class PropertyPrinter implements PropertyGetter.PropertyCallback {
    protected Hashtable appenderNames;
    protected boolean doCapitalize;
    protected Hashtable layoutNames;
    protected int numAppenders;
    protected PrintWriter out;

    public PropertyPrinter(PrintWriter printWriter) {
        this(printWriter, false);
    }

    public static String capitalize(String str) {
        if (!Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        if (str.length() != 1 && !Character.isLowerCase(str.charAt(1))) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.setCharAt(0, Character.toUpperCase(str.charAt(0)));
        return stringBuffer.toString();
    }

    protected void printOptions(PrintWriter printWriter, Category category) {
        String string;
        Enumeration allAppenders = category.getAllAppenders();
        Level level = category.getLevel();
        String string2 = level == null ? "" : level.toString();
        while (allAppenders.hasMoreElements()) {
            Appender appender = (Appender) allAppenders.nextElement();
            String name = (String) this.appenderNames.get(appender);
            if (name == null) {
                name = appender.getName();
                if (name == null || isGenAppName(name)) {
                    name = genAppName();
                }
                this.appenderNames.put(appender, name);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("log4j.appender.");
                stringBuffer.append(name);
                printOptions(printWriter, appender, stringBuffer.toString());
                if (appender.getLayout() != null) {
                    Object layout = appender.getLayout();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("log4j.appender.");
                    stringBuffer2.append(name);
                    stringBuffer2.append(".layout");
                    printOptions(printWriter, layout, stringBuffer2.toString());
                }
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(string2);
            stringBuffer3.append(", ");
            stringBuffer3.append(name);
            string2 = stringBuffer3.toString();
        }
        if (category == Logger.getRootLogger()) {
            string = "log4j.rootLogger";
        } else {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("log4j.logger.");
            stringBuffer4.append(category.getName());
            string = stringBuffer4.toString();
        }
        if (string2 != "") {
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append(string);
            stringBuffer5.append("=");
            stringBuffer5.append(string2);
            printWriter.println(stringBuffer5.toString());
        }
        if (category.getAdditivity() || category == Logger.getRootLogger()) {
            return;
        }
        StringBuffer stringBuffer6 = new StringBuffer();
        stringBuffer6.append("log4j.additivity.");
        stringBuffer6.append(category.getName());
        stringBuffer6.append("=false");
        printWriter.println(stringBuffer6.toString());
    }

    public PropertyPrinter(PrintWriter printWriter, boolean z10) {
        this.numAppenders = 0;
        this.appenderNames = new Hashtable();
        this.layoutNames = new Hashtable();
        this.out = printWriter;
        this.doCapitalize = z10;
        print(printWriter);
        printWriter.flush();
    }

    public static void main(String[] strArr) {
        new PropertyPrinter(new PrintWriter(System.out));
    }

    @Override // org.apache.log4j.config.PropertyGetter.PropertyCallback
    public void foundProperty(Object obj, String str, String str2, Object obj2) {
        if ((obj instanceof Appender) && "name".equals(str2)) {
            return;
        }
        if (this.doCapitalize) {
            str2 = capitalize(str2);
        }
        PrintWriter printWriter = this.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append("=");
        stringBuffer.append(obj2.toString());
        printWriter.println(stringBuffer.toString());
    }

    protected String genAppName() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        int i10 = this.numAppenders;
        this.numAppenders = i10 + 1;
        stringBuffer.append(i10);
        return stringBuffer.toString();
    }

    protected boolean isGenAppName(String str) {
        if (str.length() < 2 || str.charAt(0) != 'A') {
            return false;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (str.charAt(i10) < '0' || str.charAt(i10) > '9') {
                return false;
            }
        }
        return true;
    }

    public void print(PrintWriter printWriter) {
        printOptions(printWriter, Logger.getRootLogger());
        Enumeration currentLoggers = LogManager.getCurrentLoggers();
        while (currentLoggers.hasMoreElements()) {
            printOptions(printWriter, (Logger) currentLoggers.nextElement());
        }
    }

    protected void printOptions(PrintWriter printWriter, Logger logger) {
        printOptions(printWriter, (Category) logger);
    }

    protected void printOptions(PrintWriter printWriter, Object obj, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("=");
        stringBuffer.append(obj.getClass().getName());
        printWriter.println(stringBuffer.toString());
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(str);
        stringBuffer2.append(".");
        PropertyGetter.getProperties(obj, this, stringBuffer2.toString());
    }
}
