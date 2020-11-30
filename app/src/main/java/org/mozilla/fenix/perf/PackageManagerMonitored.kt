package org.mozilla.fenix.perf

import android.content.Context
import android.content.pm.PackageManager
import org.mozilla.fenix.ext.getAndIncrementNoOverflow
import java.util.concurrent.atomic.AtomicInteger


object PackageManagerCount {
    val count = AtomicInteger(0)
}
private fun packageManagerMonitored(context: Context): PackageManager {
    PackageManagerCount.count.getAndIncrementNoOverflow()
    return context.packageManager
}