package org.apache.log4j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class NameValue {
    String key;
    String value;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.key);
        stringBuffer.append("=");
        stringBuffer.append(this.value);
        return stringBuffer.toString();
    }

    public NameValue(String str, String str2) {
        this.key = str;
        this.value = str2;
    }
}
