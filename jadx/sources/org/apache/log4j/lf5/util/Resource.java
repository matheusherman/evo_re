package org.apache.log4j.lf5.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class Resource {
    protected String _name;

    public Resource() {
    }

    public Resource(String str) {
        this._name = str;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String str) {
        this._name = str;
    }

    public InputStream getInputStream() {
        return ResourceUtils.getResourceAsStream(this, this);
    }

    public InputStreamReader getInputStreamReader() {
        InputStream resourceAsStream = ResourceUtils.getResourceAsStream(this, this);
        if (resourceAsStream == null) {
            return null;
        }
        return new InputStreamReader(resourceAsStream);
    }

    public URL getURL() {
        return ResourceUtils.getResourceAsURL(this, this);
    }
}
