package com.franmontiel.persistentcookiejar.persistence;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@SuppressLint({"CommitPrefEdits"})
public class SharedPrefsCookiePersistor implements CookiePersistor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f1485a;

    public SharedPrefsCookiePersistor(Context context) {
        this(context.getSharedPreferences("CookiePersistence", 0));
    }

    public SharedPrefsCookiePersistor(SharedPreferences sharedPreferences) {
        this.f1485a = sharedPreferences;
    }

    private static String c(m mVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mVar.getSecure() ? "https" : "http");
        sb2.append("://");
        sb2.append(mVar.getDomain());
        sb2.append(mVar.getPath());
        sb2.append("|");
        sb2.append(mVar.getName());
        return sb2.toString();
    }

    @Override // com.franmontiel.persistentcookiejar.persistence.CookiePersistor
    public List<m> a() throws Throwable {
        ArrayList arrayList = new ArrayList(this.f1485a.getAll().size());
        Iterator<Map.Entry<String, ?>> it = this.f1485a.getAll().entrySet().iterator();
        while (it.hasNext()) {
            m mVarB = new SerializableCookie().b((String) it.next().getValue());
            if (mVarB != null) {
                arrayList.add(mVarB);
            }
        }
        return arrayList;
    }

    @Override // com.franmontiel.persistentcookiejar.persistence.CookiePersistor
    public void b(Collection<m> collection) {
        SharedPreferences.Editor editorEdit = this.f1485a.edit();
        for (m mVar : collection) {
            editorEdit.putString(c(mVar), new SerializableCookie().c(mVar));
        }
        editorEdit.commit();
    }

    @Override // com.franmontiel.persistentcookiejar.persistence.CookiePersistor
    public void removeAll(Collection<m> collection) {
        SharedPreferences.Editor editorEdit = this.f1485a.edit();
        Iterator<m> it = collection.iterator();
        while (it.hasNext()) {
            editorEdit.remove(c(it.next()));
        }
        editorEdit.commit();
    }
}
