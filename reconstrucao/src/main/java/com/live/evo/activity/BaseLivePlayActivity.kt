package com.live.evo.activity

import android.os.Bundle
import com.live.evo.activity.base.BaseActivity

/**
 * Base de Activities de reprodução ao vivo. `onCreate` chama `super` e um método privado `s()` vazio.
 * Original: com/live/evo/activity/BaseLivePlayActivity.java
 */
open class BaseLivePlayActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Original: s() — corpo vazio
    }
}
