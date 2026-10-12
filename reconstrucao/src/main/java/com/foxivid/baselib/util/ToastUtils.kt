package com.foxivid.baselib.util

import com.hjq.toast.Toaster

/**
 * Toasts (biblioteca Toaster, com.hjq) executados no thread de UI da activity atual,
 * e só se a activity estiver em resumed.
 * Original: x1/f1/lb/util/g1.java (+ lambdas e1/f1).
 */
object ToastUtils {
    /** Original: `g1.c(String)`. */
    fun showLong(string: String) {
        AppMonitor.currentActivity()?.runOnUiThread {
            if (AppMonitor.isActivityResumed()) Toaster.showLong(string)
        }
    }

    /** Original: `g1.e(String)`. */
    fun showShort(string: String) {
        AppMonitor.currentActivity()?.runOnUiThread {
            if (AppMonitor.isActivityResumed()) Toaster.showShort(string)
        }
    }
}
