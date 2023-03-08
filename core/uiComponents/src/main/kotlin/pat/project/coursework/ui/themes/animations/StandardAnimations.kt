package pat.project.coursework.ui.themes.animations

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.staticCompositionLocalOf
import pat.project.coursework.ui.themes.animations.AnimationDuration.standardEnterTransactionAnimationSpecTime
import pat.project.coursework.ui.themes.animations.AnimationDuration.standardEnterTransactionOffset
import pat.project.coursework.ui.themes.animations.AnimationDuration.standardExitTransitionAnimationSpecTime
import pat.project.coursework.ui.themes.animations.AnimationDuration.standardExitTransitionOffset

object StandardAnimations {
    val standardEnterTransaction =
        slideInHorizontally(
            initialOffsetX = { standardEnterTransactionOffset },
            animationSpec = tween(
                durationMillis = standardEnterTransactionAnimationSpecTime,
                easing = LinearEasing
            )
        )
    val standardExitTransition =
        slideOutHorizontally(
            targetOffsetX = { standardExitTransitionOffset },
            animationSpec = tween(
                durationMillis = standardExitTransitionAnimationSpecTime,
                easing = LinearEasing
            )
        )

    val standardPopEnterTransition =
        slideInHorizontally(
            initialOffsetX = { -standardEnterTransactionOffset },
            animationSpec = tween(
                durationMillis = standardExitTransitionAnimationSpecTime,
                easing = LinearEasing
            )
        )
}

val LocalAnimationsProvider = staticCompositionLocalOf<StandardAnimations> {
    error("No AnimationsProvider provided")
}
