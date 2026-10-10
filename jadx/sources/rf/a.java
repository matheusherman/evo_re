package rf;

import hb.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import v8.f;
import x1.f1.lb.media.c;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lrf/a;", "Lx1/f1/lb/media/c$a;", "<init>", "()V", "", "epgId", "Ljava/io/File;", "file", "", "Lz1/b1/lb/m/meta/EPGProgramme;", "a", "(Ljava/lang/String;Ljava/io/File;Lv8/f;)Ljava/lang/Object;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a implements c.a {
    @Override // x1.f1.lb.media.c.a
    public Object a(String str, File file, f<? super List<? extends EPGProgramme>> fVar) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        FileInputStream fileInputStream = new FileInputStream(file);
        xmlPullParserNewPullParser.setInput(fileInputStream, "utf-8");
        ArrayList arrayList = new ArrayList();
        EPGProgramme ePGProgramme = null;
        for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
            String name = xmlPullParserNewPullParser.getName();
            if (eventType == 2) {
                if (name.equals("programme")) {
                    ePGProgramme = new EPGProgramme();
                    String attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "start");
                    String attributeValue2 = xmlPullParserNewPullParser.getAttributeValue(null, "stop");
                    c cVar = c.f20788a;
                    m.c(attributeValue);
                    ePGProgramme.setStart(cVar.L(attributeValue));
                    m.c(attributeValue2);
                    ePGProgramme.setStop(cVar.L(attributeValue2));
                    ePGProgramme.setChannel(str);
                } else if (name.equals("title")) {
                    xmlPullParserNewPullParser.next();
                    if (ePGProgramme != null) {
                        String text = xmlPullParserNewPullParser.getText();
                        if (text == null) {
                            text = "empty title";
                        }
                        ePGProgramme.setTitle(text);
                    }
                } else if (name.equals("desc")) {
                    xmlPullParserNewPullParser.next();
                    if (ePGProgramme != null) {
                        ePGProgramme.setDesc(xmlPullParserNewPullParser.getText());
                    }
                }
            }
            if (eventType == 3 && name.equals("programme")) {
                if (ePGProgramme != null) {
                    arrayList.add(ePGProgramme);
                }
                ePGProgramme = null;
            }
        }
        d.m(fileInputStream);
        return arrayList;
    }
}
