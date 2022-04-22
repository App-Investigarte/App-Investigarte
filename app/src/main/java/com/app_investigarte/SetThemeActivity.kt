package com.app_investigarte

import android.app.Application
import androidx.appcompat.app.AppCompatActivity

class SetThemeActivity {

    companion object {
        @JvmStatic
        fun setTheme(contex: AppCompatActivity, subregion: Int) {
            when (subregion) {
                1 ->                     // 1 = Bajo Cauca
                    //se asigna un nuevo tema a la actividad.
                    contex.setTheme(R.style.Theme_Background_colors_warm)
                2 ->                     // 2 = Magdalena medio
                    //se asigna un nuevo tema a la actividad.
                    contex.setTheme(R.style.Theme_Background_colors_cold)
                3 ->                     // 3 = Nordeste antioque�o
                    //se asigna un nuevo tema a la actividad.
                    contex.setTheme(R.style.Theme_Background_colors_warm)
                4 ->                     // 4 = Norte Antioque�o
                    //se asigna un nuevo tema a la actividad.
                    contex.setTheme(R.style.Theme_Background_colors_cold)
                5 ->                     // 5 = occidente antioque�o
                    //se asigna un nuevo tema a la actividad.
                    contex.setTheme(R.style.Theme_Background_colors_warm)
                6 ->                     // 6 = Oriente Antioque�o
                    //se asigna un nuevo tema a la actividad.
                    contex.setTheme(R.style.Theme_Background_colors_warm)
                7 ->                     // 7 = Suroeste antioque�o
                    //se asigna un nuevo tema a la actividad.
                    contex.setTheme(R.style.Theme_Background_colors_cold)
                8 ->                     // 8 = Uraba antioque�o
                    //se asigna un nuevo tema a la actividad.
                    contex.setTheme(R.style.Theme_Background_colors_cold)
                9 ->                     // 9 = Valle de Aburr�
                    //se asigna un nuevo tema a la actividad.
                    contex.setTheme(R.style.Theme_Background_colors_warm)
                else -> {}
            }

        }
    }
}