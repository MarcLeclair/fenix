/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fenix.detektrules.perf

import io.gitlab.arturbosch.detekt.api.*
import org.jetbrains.kotlin.psi.KtDotQualifiedExpression


private const val ERROR_MESSAGE = "Please use `packageManagerMonitor` instead of `context.packageManager` " +
        "to allow the monitoring of packageManager useage for performance purposes"

/**
 * Prevents use of PackageManager call without using the PackageManagerMonitored function.
 */
class MozillaUsePackageManagerMonitored(config: Config = Config.empty) : Rule(config) {
    override val issue = Issue(
            "MozillaUsePackageManagerMonitored",
            Severity.Defect,
            DESCR,
            Debt.FIVE_MINS
    )

    override fun visitDotQualifiedExpression(expression: KtDotQualifiedExpression) {
        super.visitDotQualifiedExpression(expression)

        if (expression.node.chars.contains("packageManager") &&
                !expression.node.chars.contains("packageManagerMonitor") &&
                !expression.containingFile.name.contains("PackageManagerMonitored")) {
            report(CodeSmell(issue, Entity.from(expression), ERROR_MESSAGE))
        }
    }

}
