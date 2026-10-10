package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import androidx.annotation.IntRange;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class TimePicker extends Picker {
    private static final int AM_INDEX = 0;
    private static final int HOURS_IN_HALF_DAY = 12;
    private static final int PM_INDEX = 1;
    static final String TAG = "TimePicker";
    PickerColumn mAmPmColumn;
    int mColAmPmIndex;
    int mColHourIndex;
    int mColMinuteIndex;
    private final PickerUtility.TimeConstant mConstant;
    private int mCurrentAmPmIndex;
    private int mCurrentHour;
    private int mCurrentMinute;
    PickerColumn mHourColumn;
    private boolean mIs24hFormat;
    PickerColumn mMinuteColumn;
    private String mTimePickerFormat;

    public TimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.timePickerStyle);
    }

    private static boolean isAnyOf(char c10, char[] cArr) {
        for (char c11 : cArr) {
            if (c10 == c11) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"CustomViewStyleable"})
    public TimePicker(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        PickerUtility.TimeConstant timeConstantInstance = PickerUtility.getTimeConstantInstance(Locale.getDefault(), context.getResources());
        this.mConstant = timeConstantInstance;
        int[] iArr = R.styleable.lbTimePicker;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        try {
            this.mIs24hFormat = typedArrayObtainStyledAttributes.getBoolean(R.styleable.lbTimePicker_is24HourFormat, DateFormat.is24HourFormat(context));
            boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.lbTimePicker_useCurrentTime, true);
            typedArrayObtainStyledAttributes.recycle();
            updateColumns();
            updateColumnsRange();
            if (z10) {
                Calendar calendarForLocale = PickerUtility.getCalendarForLocale(null, timeConstantInstance.locale);
                setHour(calendarForLocale.get(11));
                setMinute(calendarForLocale.get(12));
                setAmPmValue();
            }
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void updateColumnsRange() {
        updateMin(this.mHourColumn, !this.mIs24hFormat ? 1 : 0);
        updateMax(this.mHourColumn, this.mIs24hFormat ? 23 : 12);
        updateMin(this.mMinuteColumn, 0);
        updateMax(this.mMinuteColumn, 59);
        PickerColumn pickerColumn = this.mAmPmColumn;
        if (pickerColumn != null) {
            updateMin(pickerColumn, 0);
            updateMax(this.mAmPmColumn, 1);
        }
    }

    String getBestHourMinutePattern() {
        String bestDateTimePattern = DateFormat.getBestDateTimePattern(this.mConstant.locale, this.mIs24hFormat ? "Hma" : "hma");
        return TextUtils.isEmpty(bestDateTimePattern) ? "h:mma" : bestDateTimePattern;
    }

    public int getHour() {
        if (this.mIs24hFormat) {
            return this.mCurrentHour;
        }
        return this.mCurrentAmPmIndex == 0 ? this.mCurrentHour % 12 : (this.mCurrentHour % 12) + 12;
    }

    public int getMinute() {
        return this.mCurrentMinute;
    }

    public boolean is24Hour() {
        return this.mIs24hFormat;
    }

    public boolean isPm() {
        return this.mCurrentAmPmIndex == 1;
    }

    @Override // androidx.leanback.widget.picker.Picker
    public void onColumnValueChanged(int i10, int i11) {
        if (i10 == this.mColHourIndex) {
            this.mCurrentHour = i11;
        } else if (i10 == this.mColMinuteIndex) {
            this.mCurrentMinute = i11;
        } else {
            if (i10 != this.mColAmPmIndex) {
                throw new IllegalArgumentException("Invalid column index.");
            }
            this.mCurrentAmPmIndex = i11;
        }
    }

    public void setHour(@IntRange(from = 0, to = 23) int i10) {
        if (i10 < 0 || i10 > 23) {
            throw new IllegalArgumentException("hour: " + i10 + " is not in [0-23] range in");
        }
        this.mCurrentHour = i10;
        if (!is24Hour()) {
            int i11 = this.mCurrentHour;
            if (i11 >= 12) {
                this.mCurrentAmPmIndex = 1;
                if (i11 > 12) {
                    this.mCurrentHour = i11 - 12;
                }
            } else {
                this.mCurrentAmPmIndex = 0;
                if (i11 == 0) {
                    this.mCurrentHour = 12;
                }
            }
            setAmPmValue();
        }
        setColumnValue(this.mColHourIndex, this.mCurrentHour, false);
    }

    public void setIs24Hour(boolean z10) {
        if (this.mIs24hFormat == z10) {
            return;
        }
        int hour = getHour();
        int minute = getMinute();
        this.mIs24hFormat = z10;
        updateColumns();
        updateColumnsRange();
        setHour(hour);
        setMinute(minute);
        setAmPmValue();
    }

    public void setMinute(@IntRange(from = 0, to = 59) int i10) {
        if (i10 >= 0 && i10 <= 59) {
            this.mCurrentMinute = i10;
            setColumnValue(this.mColMinuteIndex, i10, false);
        } else {
            throw new IllegalArgumentException("minute: " + i10 + " is not in [0-59] range.");
        }
    }

    private String extractTimeFields() {
        boolean z10;
        String str;
        StringBuilder sb2;
        String bestHourMinutePattern = getBestHourMinutePattern();
        boolean z11 = false;
        if (TextUtils.getLayoutDirectionFromLocale(this.mConstant.locale) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (bestHourMinutePattern.indexOf(97) < 0 || bestHourMinutePattern.indexOf("a") > bestHourMinutePattern.indexOf("m")) {
            z11 = true;
        }
        if (z10) {
            str = "mh";
        } else {
            str = "hm";
        }
        if (is24Hour()) {
            return str;
        }
        if (z11) {
            sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("a");
        } else {
            sb2 = new StringBuilder();
            sb2.append("a");
            sb2.append(str);
        }
        return sb2.toString();
    }

    private void setAmPmValue() {
        if (!is24Hour()) {
            setColumnValue(this.mColAmPmIndex, this.mCurrentAmPmIndex, false);
        }
    }

    private void updateColumns() {
        String bestHourMinutePattern = getBestHourMinutePattern();
        if (TextUtils.equals(bestHourMinutePattern, this.mTimePickerFormat)) {
            return;
        }
        this.mTimePickerFormat = bestHourMinutePattern;
        String strExtractTimeFields = extractTimeFields();
        List<CharSequence> listExtractSeparators = extractSeparators();
        if (listExtractSeparators.size() == strExtractTimeFields.length() + 1) {
            setSeparators(listExtractSeparators);
            String upperCase = strExtractTimeFields.toUpperCase(this.mConstant.locale);
            this.mAmPmColumn = null;
            this.mMinuteColumn = null;
            this.mHourColumn = null;
            this.mColAmPmIndex = -1;
            this.mColMinuteIndex = -1;
            this.mColHourIndex = -1;
            ArrayList arrayList = new ArrayList(3);
            for (int i10 = 0; i10 < upperCase.length(); i10++) {
                char cCharAt = upperCase.charAt(i10);
                if (cCharAt != 'A') {
                    if (cCharAt != 'H') {
                        if (cCharAt == 'M') {
                            PickerColumn pickerColumn = new PickerColumn();
                            this.mMinuteColumn = pickerColumn;
                            arrayList.add(pickerColumn);
                            this.mMinuteColumn.setStaticLabels(this.mConstant.minutes);
                            this.mColMinuteIndex = i10;
                        } else {
                            throw new IllegalArgumentException("Invalid time picker format.");
                        }
                    } else {
                        PickerColumn pickerColumn2 = new PickerColumn();
                        this.mHourColumn = pickerColumn2;
                        arrayList.add(pickerColumn2);
                        this.mHourColumn.setStaticLabels(this.mConstant.hours24);
                        this.mColHourIndex = i10;
                    }
                } else {
                    PickerColumn pickerColumn3 = new PickerColumn();
                    this.mAmPmColumn = pickerColumn3;
                    arrayList.add(pickerColumn3);
                    this.mAmPmColumn.setStaticLabels(this.mConstant.ampm);
                    this.mColAmPmIndex = i10;
                    updateMin(this.mAmPmColumn, 0);
                    updateMax(this.mAmPmColumn, 1);
                }
            }
            setColumns(arrayList);
            return;
        }
        throw new IllegalStateException("Separators size: " + listExtractSeparators.size() + " must equal the size of timeFieldsPattern: " + strExtractTimeFields.length() + " + 1");
    }

    private static void updateMax(PickerColumn pickerColumn, int i10) {
        if (i10 != pickerColumn.getMaxValue()) {
            pickerColumn.setMaxValue(i10);
        }
    }

    private static void updateMin(PickerColumn pickerColumn, int i10) {
        if (i10 != pickerColumn.getMinValue()) {
            pickerColumn.setMinValue(i10);
        }
    }

    List<CharSequence> extractSeparators() {
        String bestHourMinutePattern = getBestHourMinutePattern();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        char[] cArr = {'H', 'h', 'K', 'k', 'm', 'M', 'a'};
        boolean z10 = false;
        char c10 = 0;
        for (int i10 = 0; i10 < bestHourMinutePattern.length(); i10++) {
            char cCharAt = bestHourMinutePattern.charAt(i10);
            if (cCharAt != ' ') {
                if (cCharAt == '\'') {
                    if (!z10) {
                        sb2.setLength(0);
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                } else {
                    if (!z10 && isAnyOf(cCharAt, cArr)) {
                        if (cCharAt != c10) {
                            arrayList.add(sb2.toString());
                            sb2.setLength(0);
                        }
                    } else {
                        sb2.append(cCharAt);
                    }
                    c10 = cCharAt;
                }
            }
        }
        arrayList.add(sb2.toString());
        return arrayList;
    }
}
