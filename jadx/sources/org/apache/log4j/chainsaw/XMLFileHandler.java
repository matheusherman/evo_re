package org.apache.log4j.chainsaw;

import java.util.StringTokenizer;
import org.apache.log4j.Level;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class XMLFileHandler extends DefaultHandler {
    private static final String TAG_EVENT = "log4j:event";
    private static final String TAG_LOCATION_INFO = "log4j:locationInfo";
    private static final String TAG_MESSAGE = "log4j:message";
    private static final String TAG_NDC = "log4j:NDC";
    private static final String TAG_THROWABLE = "log4j:throwable";
    private final StringBuffer mBuf = new StringBuffer();
    private String mCategoryName;
    private Level mLevel;
    private String mLocationDetails;
    private String mMessage;
    private final MyTableModel mModel;
    private String mNDC;
    private int mNumEvents;
    private String mThreadName;
    private String[] mThrowableStrRep;
    private long mTimeStamp;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() {
        this.mNumEvents = 0;
    }

    private void addEvent() {
        this.mModel.addEvent(new EventDetails(this.mTimeStamp, this.mLevel, this.mCategoryName, this.mNDC, this.mThreadName, this.mMessage, this.mThrowableStrRep, this.mLocationDetails));
        this.mNumEvents++;
    }

    private void resetData() {
        this.mTimeStamp = 0L;
        this.mLevel = null;
        this.mCategoryName = null;
        this.mNDC = null;
        this.mThreadName = null;
        this.mMessage = null;
        this.mThrowableStrRep = null;
        this.mLocationDetails = null;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i10, int i11) {
        this.mBuf.append(String.valueOf(cArr, i10, i11));
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (TAG_EVENT.equals(str3)) {
            addEvent();
            resetData();
            return;
        }
        if (TAG_NDC.equals(str3)) {
            this.mNDC = this.mBuf.toString();
            return;
        }
        if (TAG_MESSAGE.equals(str3)) {
            this.mMessage = this.mBuf.toString();
            return;
        }
        if (!TAG_THROWABLE.equals(str3)) {
            return;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(this.mBuf.toString(), "\n\t");
        String[] strArr = new String[stringTokenizer.countTokens()];
        this.mThrowableStrRep = strArr;
        if (strArr.length <= 0) {
            return;
        }
        strArr[0] = stringTokenizer.nextToken();
        int i10 = 1;
        while (true) {
            String[] strArr2 = this.mThrowableStrRep;
            if (i10 >= strArr2.length) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("\t");
            stringBuffer.append(stringTokenizer.nextToken());
            strArr2[i10] = stringBuffer.toString();
            i10++;
        }
    }

    int getNumEvents() {
        return this.mNumEvents;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.mBuf.setLength(0);
        if (TAG_EVENT.equals(str3)) {
            this.mThreadName = attributes.getValue("thread");
            this.mTimeStamp = Long.parseLong(attributes.getValue("timestamp"));
            this.mCategoryName = attributes.getValue("logger");
            this.mLevel = Level.toLevel(attributes.getValue("level"));
            return;
        }
        if (TAG_LOCATION_INFO.equals(str3)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(attributes.getValue("class"));
            stringBuffer.append(".");
            stringBuffer.append(attributes.getValue("method"));
            stringBuffer.append("(");
            stringBuffer.append(attributes.getValue("file"));
            stringBuffer.append(":");
            stringBuffer.append(attributes.getValue("line"));
            stringBuffer.append(")");
            this.mLocationDetails = stringBuffer.toString();
        }
    }

    XMLFileHandler(MyTableModel myTableModel) {
        this.mModel = myTableModel;
    }
}
