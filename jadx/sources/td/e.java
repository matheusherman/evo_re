package td;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class e extends b {
    e(boolean z10) {
        this.F = z10;
        this.f19138d = 434;
        this.f19132a = 378;
        this.f19136c = 24;
        this.f19134b = TypedValues.CycleType.TYPE_VISIBILITY;
        if (z10) {
            this.f19138d = 407;
            this.f19132a = 225;
            this.f19134b = 280;
        }
        this.f19140e = 8;
        this.f19142f = 3;
        this.f19144g = TypedValues.PositionType.TYPE_PERCENT_WIDTH;
        this.f19146h = 512;
        this.f19148i = ((512 + 64) - 1) / 64;
        this.f19150j = (TypedValues.PositionType.TYPE_PERCENT_WIDTH + 63) / 64;
        this.f19152k = 256;
        this.f19154l = ((256 + 64) - 1) / 64;
        this.f19156m = (256 + 63) / 64;
        this.f19158n = 256;
        this.f19160o = 0;
        this.f19162p = 1;
        this.f19164q = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.f19166r = 253;
        this.f19168s = 159;
        this.f19170t = 3;
        this.f19172u = 15;
        this.f19174v = 6;
        this.f19176w = 1;
        this.f19178x = 7;
        this.f19180y = 8;
        this.f19182z = 125;
        this.A = 159;
        this.B = 24;
        int i10 = (ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION + 7) / 8;
        this.C = i10;
        int i11 = ((253 - 1) + 7) / 8;
        this.D = i11;
        int i12 = ((TypedValues.PositionType.TYPE_PERCENT_WIDTH + 7) / 8) * 2;
        this.E = i12;
        this.f19133a0 = new long[]{-1, -1, -1, -6052837899185946625L, 1371447078966912928L, 1989455001339985327L, 6937169319750509776L, 18127602061483550L};
        this.f19135b0 = new long[]{-2, -1, -1, 6341068275337658367L, 2742894157933825857L, 3978910002679970654L, -4572405434208532064L, 36255204122967100L};
        this.f19137c0 = new long[]{-4, -1, -1, -5764607523034234881L, 5485788315867651714L, 7957820005359941308L, -9144810868417064128L, 72510408245934201L};
        this.f19139d0 = new long[]{0, 0, 0, -6052837899185946624L, 1371447078966912928L, 1989455001339985327L, 6937169319750509776L, 18127602061483550L};
        this.f19143f0 = new long[]{-4461107314665330645L, -1802088430207800380L, 1256978695003386886L, 1160166531934947224L};
        this.f19141e0 = new long[]{16, 0, 0, Long.MIN_VALUE, -6992818379522110486L, -8322327821750875619L, -628489347501693444L, 3527199594194418739L, 1469206208402633719L, -2321267407214619740L, 3713841762384630283L, 5732158007287747578L, -2430897911214499685L, -4830033863159816259L, 5867348778409282426L, 285023702989702L};
        this.f19145g0 = new long[]{0, 0, 0, 288230376151711744L};
        this.f19147h0 = new long[]{-4461107314665330645L, -1802088430207800380L, 1256978695003386886L, 1160166531934947224L};
        this.f19149i0 = new long[]{6703660896400103571L, -5909411912860498377L, 3678485159306027873L, -1093120675051731550L, 2873992082182551772L, 7171536194148839865L, -8265119447870746812L, 16352189888232255L, 9094247284453741849L, -3193704231875796372L, -4566050114418754087L, -54528743463601070L, -3047936482764286209L, 1922054504381246808L, -1396317688998530438L, 7612225463883843L, 5585423759613901741L, 2458739554285137871L, 8711841994324700402L, 7897112202292909028L, 5786141083180541608L, -1166217168022687708L, -3785477569279922225L, 4594121609494003L, 969679319129173575L, -2352131510239393043L, -5157801319708392578L, -8562986439770759325L, -6951028502467660703L, -9067673585621255480L, -1528728095638149651L, 1716330900454016L, 2133917679667870743L, 6131595433662066731L, 4132892201466249495L, 4243264721812232392L, 6868906156409292872L, -520717866781942678L, -2868022759630592540L, 12061138545445877L, -4294522333240218021L, 8869864843183837084L, -8701368168747863904L, -4965310479604401471L, -6825489128068601256L, -8596507567827754495L, 3990273888349394775L, 1829864135412729L};
        this.f19151j0 = new long[]{-2350017237560825637L, -4392041795693706226L, 4385548945328509436L, -771423915569509155L, 4241169154243281967L, -9055620440120322608L, 7121043649763917783L, 8110065236168021L, 0, 0, 0, 0, 0, 0, 0, 0, 3329382374260773473L, 3539711558809017592L, 6589269349358072822L, 3923158083819410753L, -5273354194737115313L, 1859160943325703733L, -794327878939895329L, 15124960556656395L, 0, 0, 0, 0, 0, 0, 0, 0, 3317107392457288018L, -3242006345699259022L, 2378317285299659333L, 2752067541212454492L, 5401008318620329606L, -3485230783958939245L, -925585022753670519L, 3869545957505286L, 279293490929988356L, -7404656326429938090L, -9205024153151674593L, 1152299110578731394L, -1908147126641080015L, 1402013848611896279L, 564564276466162271L, 16163713578947404L};
        this.f19153k0 = new long[]{5947461595517747487L, -7239495231421361479L, -6650860256814894726L, 6612826553991653612L, -7038675916694928349L, -4645012440608975211L, 5109635575176285622L, 17852757024708465L};
        this.f19155l0 = new long[]{1017, 0, 0, -5476377146882523136L, 7190870292575474356L, 5866111745285600125L, -8444962029219724990L, 10972777180780883L};
        this.f19157m0 = new int[]{61, 32, 16, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 16, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 29, 16, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 13, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 5, 4, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1};
        this.f19159n0 = new int[]{71, 38, 21, 13, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 5, 4, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 9, 5, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 4, 2, 1, 1, 1, 2, 1, 1, 17, 9, 5, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 4, 2, 1, 1, 1, 2, 1, 1, 8, 4, 2, 1, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 33, 17, 9, 5, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 4, 2, 1, 1, 1, 2, 1, 1, 8, 4, 2, 1, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 16, 8, 4, 2, 1, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1};
        if (z10) {
            this.G = 3;
            this.H = 255;
            this.I = i10;
            this.J = i11;
            this.K = (i10 * 4) + i12 + 2;
            this.L = (i10 * 3) + i12 + 2;
            this.M = 378;
            this.N = 17;
            this.O = 34;
            this.P = 20;
            this.Q = 5;
            this.R = 3;
            this.S = 1 << 5;
            this.T = 27;
            this.U = 1 << (ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION % 5);
            this.V = 1;
            this.W = ((ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION + 5) - 1) / 5;
            this.X = ((159 + 3) - 1) / 3;
            this.Y = 51;
            this.Z = 54;
            InputStream resourceAsStream = e.class.getResourceAsStream("p503.properties");
            Properties properties = new Properties();
            try {
                properties.load(resourceAsStream);
                this.f19183z0 = b.d(properties, "ph2_path", this.Y);
                this.A0 = b.d(properties, "ph3_path", this.Z);
                this.f19149i0 = b.a(properties, "A_gen", this.f19150j * 6);
                this.f19151j0 = b.a(properties, "B_gen", this.f19150j * 6);
                this.f19161o0 = b.a(properties, "XQB3", this.f19150j * 2);
                this.f19163p0 = b.a(properties, "A_basis_zero", this.f19150j * 8);
                this.f19165q0 = b.a(properties, "B_basis_zero", this.f19150j * 8);
                this.f19167r0 = b.a(properties, "B_gen_3_tors", this.f19150j * 16);
                this.f19169s0 = b.a(properties, "g_R_S_im", this.f19150j);
                this.f19153k0 = b.a(properties, "Montgomery_R2", this.f19150j);
                this.f19177w0 = b.a(properties, "Montgomery_RB1", this.f19150j);
                this.f19179x0 = b.a(properties, "Montgomery_RB2", this.f19150j);
                this.f19155l0 = b.a(properties, "Montgomery_one", this.f19150j);
                this.f19181y0 = b.a(properties, "threeinv", this.f19150j);
                this.B0 = b.a(properties, "u_entang", this.f19150j * 2);
                this.C0 = b.a(properties, "u0_entang", this.f19150j * 2);
                this.D0 = b.b(properties, "table_r_qr", this.N, this.f19150j);
                this.E0 = b.b(properties, "table_r_qnr", this.N, this.f19150j);
                this.F0 = b.b(properties, "table_v_qr", this.O, this.f19150j);
                this.G0 = b.b(properties, "table_v_qnr", this.O, this.f19150j);
                this.H0 = b.c(properties, "v_3_torsion", this.P, 2, this.f19150j);
                this.I0 = b.a(properties, "T_tate3", (((this.f19168s - 1) * 6) + 4) * this.f19150j);
                this.J0 = b.a(properties, "T_tate2_firststep_P", this.f19150j * 4);
                this.K0 = b.a(properties, "T_tate2_P", (this.f19164q - 2) * 3 * this.f19150j);
                this.L0 = b.a(properties, "T_tate2_firststep_Q", this.f19150j * 4);
                this.M0 = b.a(properties, "T_tate2_Q", (this.f19164q - 2) * 3 * this.f19150j);
                this.N0 = b.a(properties, "ph2_T", this.W * (this.S >>> 1) * 2 * this.f19150j);
                this.Q0 = b.a(properties, "ph3_T", this.X * (this.T >> 1) * 2 * this.f19150j);
                int i13 = this.f19150j;
                this.f19175v0 = new long[i13];
                int i14 = this.X;
                int i15 = this.T;
                this.R0 = new long[(i15 >>> 1) * i14 * 2 * i13];
                this.S0 = new long[i14 * (i15 >>> 1) * 2 * i13];
                int i16 = this.W;
                int i17 = this.S;
                int[] iArr = this.f19183z0;
                int i18 = this.Y;
                this.O0 = new long[(((i16 - 1) * (i17 / 2)) + (iArr[i18 - 1] - 1)) * 2];
                this.P0 = new long[(((i16 - 1) * (i17 / 2)) + (iArr[i18 - 1] - 1)) * 2];
            } catch (IOException e10) {
                throw new IllegalStateException("unable to load Picnic properties: " + e10.getMessage(), e10);
            }
        }
    }
}
