package com.live.evo.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import com.live.evo.MyApplication
import com.live.evo.util.LocaleContextWrapper
import me.jessyan.autosize.internal.CustomAdapt
import skin.support.app.SkinAppCompatDelegateImpl

/**
 * Base das Activities de reprodução (CatchUpPlayer via FontBaseActivity): modo imersivo (flags 3846 reaplicadas
 * sempre que a barra reaparece), idioma do app, skin-support, AutoSize baseado na largura e registro em MyApplication.
 *
 * Original: com/live/evo/activity/BaseActivity.java (homônima de base/BaseActivity; renomeada para evitar conflito)
 */
abstract class AutoSizeBaseActivity : com.live.evo.activity.base.BaseActivity(), CustomAdapt {

    private var started = false

    override fun getSizeInDp(): Float = 0f
    override fun isBaseOnWidth(): Boolean = true

    override fun attachBaseContext(newBase: Context) = super.attachBaseContext(LocaleContextWrapper.wrap(newBase))

    override fun getDelegate(): AppCompatDelegate = SkinAppCompatDelegateImpl.get(this, this)

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocaleContextWrapper.wrap(this)
        val decor = window.decorView
        decor.systemUiVisibility = IMMERSIVE_FLAGS
        decor.setOnSystemUiVisibilityChangeListener { v ->
            if (v and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) decor.systemUiVisibility = IMMERSIVE_FLAGS
        }
        MyApplication.get().addActivity(this)
    }

    override fun onDestroy() { super.onDestroy(); MyApplication.get().removeActivity(this) }
    override fun onNewIntent(intent: Intent) = super.onNewIntent(intent)
    override fun onStart() { super.onStart(); started = true }
    override fun onStop() { super.onStop(); started = false }

    /** Mantém a tela ligada. Original: t() */
    protected fun keepScreenOn() = window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

    companion object { const val IMMERSIVE_FLAGS = 3846 }
}

/** Original: com/live/evo/activity/FontBaseActivity.java — base vazia acima de [AutoSizeBaseActivity]. */
abstract class FontBaseActivity : AutoSizeBaseActivity()

/** Original: com/live/evo/activity/BaseLivePlayActivity.java — vazia, sem uso. */
open class BaseLivePlayActivity : com.live.evo.activity.base.BaseActivity()
