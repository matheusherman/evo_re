package org.apache.log4j.net;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.helpers.CyclicBuffer;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.OptionHandler;
import org.apache.log4j.spi.TriggeringEventEvaluator;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.xml.UnrecognizedElementHandler;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class SMTPAppender extends AppenderSkeleton implements UnrecognizedElementHandler {
    static /* synthetic */ Class class$org$apache$log4j$spi$TriggeringEventEvaluator;
    private String bcc;
    private int bufferSize;

    /* JADX INFO: renamed from: cb, reason: collision with root package name */
    protected CyclicBuffer f17068cb;

    /* JADX INFO: renamed from: cc, reason: collision with root package name */
    private String f17069cc;
    protected TriggeringEventEvaluator evaluator;
    private String from;
    private boolean locationInfo;
    protected Message msg;
    private String replyTo;
    private boolean sendOnClose;
    private boolean smtpDebug;
    private String smtpHost;
    private String smtpPassword;
    private int smtpPort;
    private String smtpProtocol;
    private String smtpUsername;
    private String subject;
    private String to;

    public SMTPAppender() {
        this(new DefaultEvaluator());
    }

    @Override // org.apache.log4j.Appender
    public synchronized void close() {
        this.closed = true;
        if (this.sendOnClose && this.f17068cb.length() > 0) {
            sendBuffer();
        }
    }

    InternetAddress[] parseAddress(String str) {
        try {
            return InternetAddress.parse(str, true);
        } catch (AddressException e10) {
            ErrorHandler errorHandler = this.errorHandler;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not parse address [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            errorHandler.error(stringBuffer.toString(), e10, 6);
            return null;
        }
    }

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return true;
    }

    public SMTPAppender(TriggeringEventEvaluator triggeringEventEvaluator) {
        this.smtpPort = -1;
        this.smtpDebug = false;
        this.bufferSize = 512;
        this.locationInfo = false;
        this.sendOnClose = false;
        this.f17068cb = new CyclicBuffer(512);
        this.evaluator = triggeringEventEvaluator;
    }

    protected void addressMessage(Message message) {
        String str = this.from;
        if (str != null) {
            message.setFrom(getAddress(str));
        } else {
            message.setFrom();
        }
        String str2 = this.replyTo;
        if (str2 != null && str2.length() > 0) {
            message.setReplyTo(parseAddress(this.replyTo));
        }
        String str3 = this.to;
        if (str3 != null && str3.length() > 0) {
            message.setRecipients(Message.RecipientType.TO, parseAddress(this.to));
        }
        String str4 = this.f17069cc;
        if (str4 != null && str4.length() > 0) {
            message.setRecipients(Message.RecipientType.CC, parseAddress(this.f17069cc));
        }
        String str5 = this.bcc;
        if (str5 == null || str5.length() <= 0) {
            return;
        }
        message.setRecipients(Message.RecipientType.BCC, parseAddress(this.bcc));
    }

    protected boolean checkEntryConditions() {
        if (this.msg == null) {
            this.errorHandler.error("Message object not configured.");
            return false;
        }
        if (this.evaluator == null) {
            ErrorHandler errorHandler = this.errorHandler;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No TriggeringEventEvaluator is set for appender [");
            stringBuffer.append(this.name);
            stringBuffer.append("].");
            errorHandler.error(stringBuffer.toString());
            return false;
        }
        if (this.layout != null) {
            return true;
        }
        ErrorHandler errorHandler2 = this.errorHandler;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("No layout set for appender named [");
        stringBuffer2.append(this.name);
        stringBuffer2.append("].");
        errorHandler2.error(stringBuffer2.toString());
        return false;
    }

    protected Session createSession() {
        Properties properties;
        String string;
        Authenticator authenticator;
        try {
            properties = new Properties(System.getProperties());
        } catch (SecurityException unused) {
            properties = new Properties();
        }
        String str = this.smtpProtocol;
        if (str != null) {
            properties.put("mail.transport.protocol", str);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("mail.");
            stringBuffer.append(this.smtpProtocol);
            string = stringBuffer.toString();
        } else {
            string = "mail.smtp";
        }
        if (this.smtpHost != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(string);
            stringBuffer2.append(".host");
            properties.put(stringBuffer2.toString(), this.smtpHost);
        }
        if (this.smtpPort > 0) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(string);
            stringBuffer3.append(".port");
            properties.put(stringBuffer3.toString(), String.valueOf(this.smtpPort));
        }
        if (this.smtpPassword == null || this.smtpUsername == null) {
            authenticator = null;
        } else {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(string);
            stringBuffer4.append(".auth");
            properties.put(stringBuffer4.toString(), "true");
            authenticator = new Authenticator() { // from class: org.apache.log4j.net.SMTPAppender.1
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SMTPAppender.this.smtpUsername, SMTPAppender.this.smtpPassword);
                }
            };
        }
        Session session = Session.getInstance(properties, authenticator);
        String str2 = this.smtpProtocol;
        if (str2 != null) {
            session.setProtocolForAddress("rfc822", str2);
        }
        boolean z10 = this.smtpDebug;
        if (z10) {
            session.setDebug(z10);
        }
        return session;
    }

    protected String formatBody() {
        String[] throwableStrRep;
        StringBuffer stringBuffer = new StringBuffer();
        String header = this.layout.getHeader();
        if (header != null) {
            stringBuffer.append(header);
        }
        int length = this.f17068cb.length();
        for (int i10 = 0; i10 < length; i10++) {
            LoggingEvent loggingEvent = this.f17068cb.get();
            stringBuffer.append(this.layout.format(loggingEvent));
            if (this.layout.ignoresThrowable() && (throwableStrRep = loggingEvent.getThrowableStrRep()) != null) {
                for (String str : throwableStrRep) {
                    stringBuffer.append(str);
                    stringBuffer.append(Layout.LINE_SEP);
                }
            }
        }
        String footer = this.layout.getFooter();
        if (footer != null) {
            stringBuffer.append(footer);
        }
        return stringBuffer.toString();
    }

    InternetAddress getAddress(String str) {
        try {
            return new InternetAddress(str);
        } catch (AddressException e10) {
            ErrorHandler errorHandler = this.errorHandler;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not parse address [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            errorHandler.error(stringBuffer.toString(), e10, 6);
            return null;
        }
    }

    public String getBcc() {
        return this.bcc;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public String getCc() {
        return this.f17069cc;
    }

    public final TriggeringEventEvaluator getEvaluator() {
        return this.evaluator;
    }

    public String getEvaluatorClass() {
        TriggeringEventEvaluator triggeringEventEvaluator = this.evaluator;
        if (triggeringEventEvaluator == null) {
            return null;
        }
        return triggeringEventEvaluator.getClass().getName();
    }

    public String getFrom() {
        return this.from;
    }

    public boolean getLocationInfo() {
        return this.locationInfo;
    }

    public String getReplyTo() {
        return this.replyTo;
    }

    public boolean getSMTPDebug() {
        return this.smtpDebug;
    }

    public String getSMTPHost() {
        return this.smtpHost;
    }

    public String getSMTPPassword() {
        return this.smtpPassword;
    }

    public final int getSMTPPort() {
        return this.smtpPort;
    }

    public final String getSMTPProtocol() {
        return this.smtpProtocol;
    }

    public String getSMTPUsername() {
        return this.smtpUsername;
    }

    public final boolean getSendOnClose() {
        return this.sendOnClose;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getTo() {
        return this.to;
    }

    @Override // org.apache.log4j.xml.UnrecognizedElementHandler
    public boolean parseUnrecognizedElement(Element element, Properties properties) throws Throwable {
        if (!"triggeringPolicy".equals(element.getNodeName())) {
            return false;
        }
        Class clsClass$ = class$org$apache$log4j$spi$TriggeringEventEvaluator;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.spi.TriggeringEventEvaluator");
            class$org$apache$log4j$spi$TriggeringEventEvaluator = clsClass$;
        }
        Object element2 = DOMConfigurator.parseElement(element, properties, clsClass$);
        if (!(element2 instanceof TriggeringEventEvaluator)) {
            return true;
        }
        setEvaluator((TriggeringEventEvaluator) element2);
        return true;
    }

    protected void sendBuffer() {
        MimeBodyPart mimeBodyPart;
        try {
            try {
                String body = formatBody();
                boolean z10 = true;
                for (int i10 = 0; i10 < body.length() && z10; i10++) {
                    z10 = body.charAt(i10) <= 127;
                }
                if (z10) {
                    mimeBodyPart = new MimeBodyPart();
                    mimeBodyPart.setContent(body, this.layout.getContentType());
                } else {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(MimeUtility.encode(byteArrayOutputStream, "quoted-printable"), "UTF-8");
                        outputStreamWriter.write(body);
                        outputStreamWriter.close();
                        InternetHeaders internetHeaders = new InternetHeaders();
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(this.layout.getContentType());
                        stringBuffer.append("; charset=UTF-8");
                        internetHeaders.setHeader("Content-Type", stringBuffer.toString());
                        internetHeaders.setHeader("Content-Transfer-Encoding", "quoted-printable");
                        mimeBodyPart = new MimeBodyPart(internetHeaders, byteArrayOutputStream.toByteArray());
                    } catch (Exception unused) {
                        StringBuffer stringBuffer2 = new StringBuffer(body);
                        for (int i11 = 0; i11 < stringBuffer2.length(); i11++) {
                            if (stringBuffer2.charAt(i11) >= 128) {
                                stringBuffer2.setCharAt(i11, '?');
                            }
                        }
                        MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
                        mimeBodyPart2.setContent(stringBuffer2.toString(), this.layout.getContentType());
                        mimeBodyPart = mimeBodyPart2;
                    }
                }
                MimeMultipart mimeMultipart = new MimeMultipart();
                mimeMultipart.addBodyPart(mimeBodyPart);
                this.msg.setContent(mimeMultipart);
                this.msg.setSentDate(new Date());
                Transport.send(this.msg);
            } catch (RuntimeException e10) {
                LogLog.error("Error occured while sending e-mail notification.", e10);
            }
        } catch (MessagingException e11) {
            LogLog.error("Error occured while sending e-mail notification.", e11);
        }
    }

    public void setBcc(String str) {
        this.bcc = str;
    }

    public void setBufferSize(int i10) {
        this.bufferSize = i10;
        this.f17068cb.resize(i10);
    }

    public void setCc(String str) {
        this.f17069cc = str;
    }

    public final void setEvaluator(TriggeringEventEvaluator triggeringEventEvaluator) {
        if (triggeringEventEvaluator == null) {
            throw new NullPointerException("trigger");
        }
        this.evaluator = triggeringEventEvaluator;
    }

    public void setEvaluatorClass(String str) throws Throwable {
        Class clsClass$ = class$org$apache$log4j$spi$TriggeringEventEvaluator;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.spi.TriggeringEventEvaluator");
            class$org$apache$log4j$spi$TriggeringEventEvaluator = clsClass$;
        }
        this.evaluator = (TriggeringEventEvaluator) OptionConverter.instantiateByClassName(str, clsClass$, this.evaluator);
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setLocationInfo(boolean z10) {
        this.locationInfo = z10;
    }

    public void setReplyTo(String str) {
        this.replyTo = str;
    }

    public void setSMTPDebug(boolean z10) {
        this.smtpDebug = z10;
    }

    public void setSMTPHost(String str) {
        this.smtpHost = str;
    }

    public void setSMTPPassword(String str) {
        this.smtpPassword = str;
    }

    public final void setSMTPPort(int i10) {
        this.smtpPort = i10;
    }

    public final void setSMTPProtocol(String str) {
        this.smtpProtocol = str;
    }

    public void setSMTPUsername(String str) {
        this.smtpUsername = str;
    }

    public final void setSendOnClose(boolean z10) {
        this.sendOnClose = z10;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public void setTo(String str) {
        this.to = str;
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    @Override // org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
        MimeMessage mimeMessage = new MimeMessage(createSession());
        this.msg = mimeMessage;
        try {
            addressMessage(mimeMessage);
            String str = this.subject;
            if (str != null) {
                try {
                    this.msg.setSubject(MimeUtility.encodeText(str, "UTF-8", (String) null));
                } catch (UnsupportedEncodingException e10) {
                    LogLog.error("Unable to encode SMTP subject", e10);
                }
            }
        } catch (MessagingException e11) {
            LogLog.error("Could not activate SMTPAppender options.", e11);
        }
        TriggeringEventEvaluator triggeringEventEvaluator = this.evaluator;
        if (triggeringEventEvaluator instanceof OptionHandler) {
            ((OptionHandler) triggeringEventEvaluator).activateOptions();
        }
    }

    @Override // org.apache.log4j.AppenderSkeleton
    public void append(LoggingEvent loggingEvent) {
        if (checkEntryConditions()) {
            loggingEvent.getThreadName();
            loggingEvent.getNDC();
            loggingEvent.getMDCCopy();
            if (this.locationInfo) {
                loggingEvent.getLocationInformation();
            }
            loggingEvent.getRenderedMessage();
            loggingEvent.getThrowableStrRep();
            this.f17068cb.add(loggingEvent);
            if (this.evaluator.isTriggeringEvent(loggingEvent)) {
                sendBuffer();
            }
        }
    }
}
