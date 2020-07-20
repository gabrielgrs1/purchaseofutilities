package com.gabrielgrs1.purchaseofutilities.core.di

import androidx.room.Room
import com.gabrielgrs.moviedb.core.api.provideMoviesApi
import com.gabrielgrs.moviedb.core.api.provideRetrofit
import com.gabrielgrs.moviedb.data.api.repository.MoviesRepositoryImpl
import com.gabrielgrs.moviedb.data.database.MovieDbRoomDatabase
import com.gabrielgrs.moviedb.data.database.repository.FavoriteMoviesRepositoryImpl
import com.gabrielgrs.moviedb.domain.repository.FavoriteMoviesRepository
import com.gabrielgrs.moviedb.domain.repository.MoviesRepository
import com.gabrielgrs.moviedb.domain.usecase.FavoriteMoviesUseCase
import com.gabrielgrs.moviedb.domain.usecase.IsFavoriteMoviesUseCase
import com.gabrielgrs.moviedb.domain.usecase.MovieDetailUseCase
import com.gabrielgrs.moviedb.domain.usecase.PopularMoviesUseCase
import com.gabrielgrs.moviedb.domain.usecase.SearchMoviesUseCase
import com.gabrielgrs.moviedb.domain.usecase.SimilarMoviesUseCase
import com.gabrielgrs.moviedb.presentation.ui.moviedetail.MovieDetailViewModel
import com.gabrielgrs.moviedb.presentation.ui.popularmovies.PopularMoviesViewModel
import com.gabrielgrs.moviedb.presentation.ui.searchmovies.SearchMoviesViewModel
import org.koin.android.ext.koin.androidApplication
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