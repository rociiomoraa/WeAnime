package com.example.weanime

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)

        // ANIMACIÓN POP AL COMENZAR
        splashScreen.setOnExitAnimationListener { splash ->

            val icon = splash.iconView

            // POP antes de desaparecer
            val popScaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 1.12f, 1f)
            val popScaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 1.12f, 1f)

            val popAnimator = ObjectAnimator.ofPropertyValuesHolder(
                icon,
                popScaleX,
                popScaleY
            ).apply { duration = 350 }

            // Cuando termine, hacemos la transición
            popAnimator.doOnEnd {
                splash.remove()
                startActivity(Intent(this, AboutActivity::class.java))
                finish()
            }

            popAnimator.start()
        }
    }
}
