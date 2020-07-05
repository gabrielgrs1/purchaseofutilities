package com.gabrielgrs1.purchaseofutilities.core.di

import com.gabrielgrs1.purchaseofutilities.core.api.provideApi
import com.gabrielgrs1.purchaseofutilities.core.api.provideRetrofit
import com.gabrielgrs1.purchaseofutilities.data.api.repository.CartRepositoryImpl
import com.gabrielgrs1.purchaseofutilities.domain.repository.CartRepository
import com.gabrielgrs1.purchaseofutilities.domain.usecase.CartUseCase
import com.gabrielgrs1.purchaseofutilities.presentation.ui.cart.CartViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { CartViewModel() }
}

val repositoryModule = module {
    single<CartRepository> { CartRepositoryImpl() }
}

val persistenceModule = module {
    factory { provideApi(get()) }
    single { provideRetrofit() }
}

val useCaseModule = module {
    factory { CartUseCase() }
}