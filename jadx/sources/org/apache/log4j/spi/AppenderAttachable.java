package org.apache.log4j.spi;

import java.util.Enumeration;
import org.apache.log4j.Appender;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public interface AppenderAttachable {
    void addAppender(Appender appender);

    Enumeration getAllAppenders();

    Appender getAppender(String str);

    boolean isAttached(Appender appender);

    void removeAllAppenders();

    void removeAppender(String str);

    void removeAppender(Appender appender);
}
