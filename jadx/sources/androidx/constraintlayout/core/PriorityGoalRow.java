package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-4f;
    static final int NOT_FOUND = -1;
    GoalVariableAccessor mAccessor;
    private SolverVariable[] mArrayGoals;
    Cache mCache;
    private int mNumGoals;
    private SolverVariable[] mSortArray;
    private int mTableSize;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class GoalVariableAccessor {
        PriorityGoalRow mRow;
        SolverVariable mVariable;

        public void add(SolverVariable solverVariable) {
            for (int i10 = 0; i10 < 9; i10++) {
                float[] fArr = this.mVariable.mGoalStrengthVector;
                float f10 = fArr[i10] + solverVariable.mGoalStrengthVector[i10];
                fArr[i10] = f10;
                if (Math.abs(f10) < 1.0E-4f) {
                    this.mVariable.mGoalStrengthVector[i10] = 0.0f;
                }
            }
        }

        public final boolean isNull() {
            for (int i10 = 0; i10 < 9; i10++) {
                if (this.mVariable.mGoalStrengthVector[i10] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.mRow = priorityGoalRow;
        }

        public boolean addToGoal(SolverVariable solverVariable, float f10) {
            boolean z10 = true;
            if (!this.mVariable.inGoal) {
                for (int i10 = 0; i10 < 9; i10++) {
                    float f11 = solverVariable.mGoalStrengthVector[i10];
                    if (f11 != 0.0f) {
                        float f12 = f11 * f10;
                        if (Math.abs(f12) < 1.0E-4f) {
                            f12 = 0.0f;
                        }
                        this.mVariable.mGoalStrengthVector[i10] = f12;
                    } else {
                        this.mVariable.mGoalStrengthVector[i10] = 0.0f;
                    }
                }
                return true;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                float[] fArr = this.mVariable.mGoalStrengthVector;
                float f13 = fArr[i11] + (solverVariable.mGoalStrengthVector[i11] * f10);
                fArr[i11] = f13;
                if (Math.abs(f13) < 1.0E-4f) {
                    this.mVariable.mGoalStrengthVector[i11] = 0.0f;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                PriorityGoalRow.this.removeGoal(this.mVariable);
            }
            return false;
        }

        public void init(SolverVariable solverVariable) {
            this.mVariable = solverVariable;
        }

        public final boolean isNegative() {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = this.mVariable.mGoalStrengthVector[i10];
                if (f10 > 0.0f) {
                    return false;
                }
                if (f10 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = solverVariable.mGoalStrengthVector[i10];
                float f11 = this.mVariable.mGoalStrengthVector[i10];
                if (f11 != f10) {
                    if (f11 < f10) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.mVariable.mGoalStrengthVector, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.mVariable != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    str = str + this.mVariable.mGoalStrengthVector[i10] + " ";
                }
            }
            return str + "] " + this.mVariable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeGoal(SolverVariable solverVariable) {
        int i10 = 0;
        while (i10 < this.mNumGoals) {
            if (this.mArrayGoals[i10] == solverVariable) {
                while (true) {
                    int i11 = this.mNumGoals;
                    if (i10 >= i11 - 1) {
                        this.mNumGoals = i11 - 1;
                        solverVariable.inGoal = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.mArrayGoals;
                        int i12 = i10 + 1;
                        solverVariableArr[i10] = solverVariableArr[i12];
                        i10 = i12;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.mNumGoals = 0;
        this.mConstantValue = 0.0f;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i10 = -1;
        for (int i11 = 0; i11 < this.mNumGoals; i11++) {
            SolverVariable solverVariable = this.mArrayGoals[i11];
            if (!zArr[solverVariable.f322id]) {
                this.mAccessor.init(solverVariable);
                if (i10 == -1) {
                    if (this.mAccessor.isNegative()) {
                        i10 = i11;
                    }
                } else if (this.mAccessor.isSmallerThan(this.mArrayGoals[i10])) {
                    i10 = i11;
                }
            }
        }
        if (i10 == -1) {
            return null;
        }
        return this.mArrayGoals[i10];
    }

    private void addToGoal(SolverVariable solverVariable) {
        int i10;
        int i11 = this.mNumGoals + 1;
        SolverVariable[] solverVariableArr = this.mArrayGoals;
        if (i11 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.mArrayGoals = solverVariableArr2;
            this.mSortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.mArrayGoals;
        int i12 = this.mNumGoals;
        solverVariableArr3[i12] = solverVariable;
        int i13 = i12 + 1;
        this.mNumGoals = i13;
        if (i13 > 1 && solverVariableArr3[i12].f322id > solverVariable.f322id) {
            int i14 = 0;
            while (true) {
                i10 = this.mNumGoals;
                if (i14 >= i10) {
                    break;
                }
                this.mSortArray[i14] = this.mArrayGoals[i14];
                i14++;
            }
            Arrays.sort(this.mSortArray, 0, i10, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.core.PriorityGoalRow.1
                @Override // java.util.Comparator
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.f322id - solverVariable3.f322id;
                }
            });
            for (int i15 = 0; i15 < this.mNumGoals; i15++) {
                this.mArrayGoals[i15] = this.mSortArray[i15];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        this.mAccessor.init(solverVariable);
        this.mAccessor.reset();
        solverVariable.mGoalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        return this.mNumGoals == 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public String toString() {
        String str = " goal -> (" + this.mConstantValue + ") : ";
        for (int i10 = 0; i10 < this.mNumGoals; i10++) {
            this.mAccessor.init(this.mArrayGoals[i10]);
            str = str + this.mAccessor + " ";
        }
        return str;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z10) {
        SolverVariable solverVariable = arrayRow.mVariable;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i10 = 0; i10 < currentSize; i10++) {
            SolverVariable variable = arrayRowVariables.getVariable(i10);
            float variableValue = arrayRowVariables.getVariableValue(i10);
            this.mAccessor.init(variable);
            if (this.mAccessor.addToGoal(solverVariable, variableValue)) {
                addToGoal(variable);
            }
            this.mConstantValue += arrayRow.mConstantValue * variableValue;
        }
        removeGoal(solverVariable);
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.mTableSize = 128;
        this.mArrayGoals = new SolverVariable[128];
        this.mSortArray = new SolverVariable[128];
        this.mNumGoals = 0;
        this.mAccessor = new GoalVariableAccessor(this);
        this.mCache = cache;
    }
}
