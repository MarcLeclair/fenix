/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fenix.perf

import android.content.Context
import android.content.pm.PackageManager
import org.mozilla.fenix.ext.getAndIncrementNoOverflow
import java.util.concurrent.atomic.AtomicInteger

object PackageManagerMonitored {
    val count = AtomicInteger(0)
}

fun packageManagerMonitor(context: Context): PackageManager {
    PackageManagerMonitored.count.getAndIncrementNoOverflow()
    return context.packageManager
}
