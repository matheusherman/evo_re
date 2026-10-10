package androidx.constraintlayout.core.state;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public interface RegistryCallback {
    String currentLayoutInformation();

    String currentMotionScene();

    long getLastModified();

    void onDimensions(int i10, int i11);

    void onNewMotionScene(String str);

    void onProgress(float f10);

    void setDrawDebug(int i10);

    void setLayoutInformationMode(int i10);
}
