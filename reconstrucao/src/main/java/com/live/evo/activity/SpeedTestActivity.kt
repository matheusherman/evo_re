package com.live.evo.activity

import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.live.evo.MyApplication
import com.live.evo.R
import com.live.evo.speedtest.SpeedTestManager
import com.live.evo.util.ToastUtils
import com.live.evo.widget.GaugeView
import java.util.Locale

/**
 * Tela de "teste de velocidade". Aberta a partir do ChannelFragment (fragment/x) via [start].
 *
 * Original: com/live/evo/activity/SpeedTestActivity.java
 *
 * Descoberta: nesta versão o teste é **apenas visual** — [startTest] só anima os medidores de 0→100→0 em 3 s;
 * o [SpeedTestManager] (d6.a) é um stub sem lógica (listener sem métodos, `stop()` vazio). Ping/jitter/download/upload
 * ficam em "-".
 */
class SpeedTestActivity : AppCompatActivity(), SpeedTestManager.Listener {

    private var mTvStart: TextView? = null
    private var mInfo: TextView? = null
    private var mCurDownload: TextView? = null; private var mDownloadPer: TextView? = null; private var mGvDownload: GaugeView? = null
    private var mCurUpload: TextView? = null; private var mUploadPer: TextView? = null; private var mGvUpload: GaugeView? = null
    private var mClientVal: TextView? = null; private var mServerVal: TextView? = null
    private var mPingVal: TextView? = null; private var mJitterVal: TextView? = null
    private var mDownloadVal: TextView? = null; private var mUploadVal: TextView? = null
    private var speedtestManager: SpeedTestManager? = null
    private var mAnimator: ValueAnimator? = null
    private var mBackPressedAgain = false
    private var mHandler: Handler? = null
    private var mIsTesting = false
    private var mLocale: Locale? = null

    /** Inferência: `native`; provavelmente setContentView + [readLocale] (n) + [findViews] (s) + [initListeners] (o). */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TODO("nativo/não decompilado: SpeedTestActivity.onCreate")
    }

    /** Original: n() */
    @Suppress("DEPRECATION")
    private fun readLocale() {
        val cfg = application.resources.configuration
        mLocale = if (Build.VERSION.SDK_INT >= 24) cfg.locales.get(0) else cfg.locale
    }

    /** Original: o() — clique em "start" inicia o teste; texto pisca (alpha 0.2→1, 1,5 s, infinito). */
    private fun initListeners() {
        mHandler = Handler()
        mTvStart?.setOnClickListener { startTest() }
        speedtestManager = SpeedTestManager.get(MyApplication.get())
        val blink = AlphaAnimation(0.2f, 1.0f).apply { repeatMode = Animation.REVERSE; repeatCount = -1; duration = 1500L }
        mTvStart?.animation = blink
        blink.start()
    }

    /** Original: s() */
    private fun findViews() {
        mTvStart = findViewById(R.id.tv_start)
        mClientVal = findViewById(R.id.client_val); mServerVal = findViewById(R.id.server_val)
        mPingVal = findViewById(R.id.ping_val); mJitterVal = findViewById(R.id.jitter_val)
        mDownloadVal = findViewById(R.id.download_val); mUploadVal = findViewById(R.id.upload_val)
        mInfo = findViewById(R.id.tv_info)
        mCurDownload = findViewById(R.id.tv_download_current_speed); mDownloadPer = findViewById(R.id.tv_download_per); mGvDownload = findViewById(R.id.gv_download)
        mCurUpload = findViewById(R.id.tv_upload_current_speed); mUploadPer = findViewById(R.id.tv_upload_per); mGvUpload = findViewById(R.id.gv_upload)
        listOf(mPingVal, mJitterVal, mDownloadVal, mUploadVal).forEach { it?.text = "-" }
    }

    /** Original: u() */
    private fun startTest() {
        if (mIsTesting) { ToastUtils.show(this, R.string.retry_later); return }
        mIsTesting = true
        animateGauges()
        mGvDownload?.setValue(0); mCurDownload?.text = "0.00"; mDownloadPer?.text = "0%"
        mGvUpload?.setValue(0); mCurUpload?.text = "0.00"; mUploadPer?.text = "0%"
        mInfo?.text = resources.getString(R.string.init_env)
    }

    /** Original: q() / r() — animação 0→100→0 em 3 s nos dois medidores. */
    private fun animateGauges() {
        if (mAnimator == null) mAnimator = ValueAnimator.ofInt(0, 100, 0)
        mAnimator?.duration = 3000L
        mAnimator?.addUpdateListener { a ->
            val v = a.animatedValue as Int
            mGvDownload?.setValue(v); mGvUpload?.setValue(v)
            mCurDownload?.text = "$v"; mCurUpload?.text = "$v"
            mDownloadPer?.text = "$v%"; mUploadPer?.text = "$v%"
        }
        mAnimator?.start()
    }

    /** Duplo back em 2,5 s para sair. Original: onBackPressed() */
    override fun onBackPressed() {
        if (mBackPressedAgain) finish() else {
            ToastUtils.show(this, R.string.backpress_agrain_exit)
            mBackPressedAgain = true
            mHandler?.postDelayed({ mBackPressedAgain = false }, 2500L)
        }
        super.onBackPressed()
    }

    override fun onResume() { super.onResume(); speedtestManager?.setListener(this) }
    override fun onStop() { super.onStop(); speedtestManager?.stop(); speedtestManager?.setListener(null) }

    companion object {
        const val TAG = "SpeedTestActivity"
        /** Original: SpeedTestActivity$Companion.a(Context) */
        fun start(context: Context) = context.startActivity(Intent(context, SpeedTestActivity::class.java))
    }
}
