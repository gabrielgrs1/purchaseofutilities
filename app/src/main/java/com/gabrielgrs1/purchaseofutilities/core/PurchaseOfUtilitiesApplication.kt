package com.gabrielgrs1.purchaseofutilities.core

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.standalone.KoinComponent

class PurchaseOfUtilitiesApplication : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
//        startKoin(
//            this,
//            listOf(
//                persistenceModule,
//                viewModelModule,
//                repositoryModule,
//                useCaseModule,
//                daoModule
//            )
//        )
    }
}