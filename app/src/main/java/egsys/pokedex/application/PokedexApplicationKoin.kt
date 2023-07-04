package egsys.pokedex.application

import android.app.Application
import egsys.pokedex.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PokedexApplicationKoin : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger()
            androidContext(this@PokedexApplicationKoin)
            modules(mainModule)
        }
    }
}