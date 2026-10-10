package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class KeyFrames {
    private static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    private static final String CUSTOM_METHOD = "CustomMethod";
    private static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    static HashMap<String, Constructor<? extends Key>> sKeyMakers;
    private HashMap<Integer, ArrayList<Key>> mFramesMap = new HashMap<>();

    public KeyFrames() {
    }

    static {
        HashMap<String, Constructor<? extends Key>> map = new HashMap<>();
        sKeyMakers = map;
        try {
            map.put("KeyAttribute", KeyAttributes.class.getConstructor(null));
            sKeyMakers.put("KeyPosition", KeyPosition.class.getConstructor(null));
            sKeyMakers.put("KeyCycle", KeyCycle.class.getConstructor(null));
            sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(null));
            sKeyMakers.put("KeyTrigger", KeyTrigger.class.getConstructor(null));
        } catch (NoSuchMethodException e10) {
            Log.e(TAG, "unable to load", e10);
        }
    }

    public void addAllFrames(MotionController motionController) {
        ArrayList<Key> arrayList = this.mFramesMap.get(-1);
        if (arrayList != null) {
            motionController.addKeys(arrayList);
        }
    }

    public void addFrames(MotionController motionController) {
        ArrayList<Key> arrayList = this.mFramesMap.get(Integer.valueOf(motionController.mId));
        if (arrayList != null) {
            motionController.addKeys(arrayList);
        }
        ArrayList<Key> arrayList2 = this.mFramesMap.get(-1);
        if (arrayList2 != null) {
            for (Key key : arrayList2) {
                if (key.matches(((ConstraintLayout.LayoutParams) motionController.mView.getLayoutParams()).constraintTag)) {
                    motionController.addKey(key);
                }
            }
        }
    }

    public void addKey(Key key) {
        if (!this.mFramesMap.containsKey(Integer.valueOf(key.mTargetId))) {
            this.mFramesMap.put(Integer.valueOf(key.mTargetId), new ArrayList<>());
        }
        ArrayList<Key> arrayList = this.mFramesMap.get(Integer.valueOf(key.mTargetId));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    public ArrayList<Key> getKeyFramesForView(int i10) {
        return this.mFramesMap.get(Integer.valueOf(i10));
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        HashMap<String, ConstraintAttribute> map;
        HashMap<String, ConstraintAttribute> map2;
        Key keyTimeCycle;
        try {
            int eventType = xmlPullParser.getEventType();
            Key key = null;
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && ViewTransition.KEY_FRAME_SET_TAG.equals(xmlPullParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlPullParser.getName();
                    if (sKeyMakers.containsKey(name)) {
                        switch (name.hashCode()) {
                            case -300573030:
                                if (name.equals("KeyTimeCycle")) {
                                    keyTimeCycle = new KeyTimeCycle();
                                    keyTimeCycle.load(context, Xml.asAttributeSet(xmlPullParser));
                                    addKey(keyTimeCycle);
                                    key = keyTimeCycle;
                                } else {
                                    throw new NullPointerException("Key " + name + " not found");
                                }
                                break;
                            case -298435811:
                                if (name.equals("KeyAttribute")) {
                                    keyTimeCycle = new KeyAttributes();
                                    keyTimeCycle.load(context, Xml.asAttributeSet(xmlPullParser));
                                    addKey(keyTimeCycle);
                                    key = keyTimeCycle;
                                } else {
                                    throw new NullPointerException("Key " + name + " not found");
                                }
                                break;
                            case 540053991:
                                if (name.equals("KeyCycle")) {
                                    keyTimeCycle = new KeyCycle();
                                    keyTimeCycle.load(context, Xml.asAttributeSet(xmlPullParser));
                                    addKey(keyTimeCycle);
                                    key = keyTimeCycle;
                                } else {
                                    throw new NullPointerException("Key " + name + " not found");
                                }
                                break;
                            case 1153397896:
                                if (name.equals("KeyPosition")) {
                                    keyTimeCycle = new KeyPosition();
                                    keyTimeCycle.load(context, Xml.asAttributeSet(xmlPullParser));
                                    addKey(keyTimeCycle);
                                    key = keyTimeCycle;
                                } else {
                                    throw new NullPointerException("Key " + name + " not found");
                                }
                                break;
                            case 1308496505:
                                if (name.equals("KeyTrigger")) {
                                    keyTimeCycle = new KeyTrigger();
                                    keyTimeCycle.load(context, Xml.asAttributeSet(xmlPullParser));
                                    addKey(keyTimeCycle);
                                    key = keyTimeCycle;
                                } else {
                                    throw new NullPointerException("Key " + name + " not found");
                                }
                                break;
                            default:
                                throw new NullPointerException("Key " + name + " not found");
                        }
                    }
                    if (name.equalsIgnoreCase("CustomAttribute")) {
                        if (key != null && (map2 = key.mCustomConstraints) != null) {
                            ConstraintAttribute.parse(context, xmlPullParser, map2);
                        }
                    } else if (name.equalsIgnoreCase("CustomMethod") && key != null && (map = key.mCustomConstraints) != null) {
                        ConstraintAttribute.parse(context, xmlPullParser, map);
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e10) {
            Log.e(TAG, "Error parsing XML resource", e10);
        } catch (XmlPullParserException e11) {
            Log.e(TAG, "Error parsing XML resource", e11);
        }
    }

    static String name(int i10, Context context) {
        return context.getResources().getResourceEntryName(i10);
    }
}
