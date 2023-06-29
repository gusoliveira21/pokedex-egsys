package egsys.pokedex.di

import egsys.data.api.RetrofitInicializer
import egsys.data.api.Service
import egsys.data.repository.RepositoryImpl
import egsys.domain.repository.Repository
import egsys.domain.usecase.base.GetListUseCase
import egsys.pokedex.ui.screens.appArea.home.HomeViewModel
import egsys.pokedex.ui.screens.appArea.home.HomeViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single<Service> { RetrofitInicializer().getRetrofitService() }
    viewModel<HomeViewModel>{ HomeViewModelImpl(get()) }
    factory { GetListUseCase(get()) }
    single<Repository> { RepositoryImpl(get(), get()) }
}