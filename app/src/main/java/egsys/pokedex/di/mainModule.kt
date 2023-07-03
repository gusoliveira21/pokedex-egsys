package egsys.pokedex.di

import egsys.data.api.RetrofitInicializer
import egsys.data.api.Service
import egsys.data.repository.RepositoryImpl
import egsys.domain.repository.Repository
import egsys.domain.usecase.home.GetListOnlyByTypeUseCase
import egsys.domain.usecase.home.GetListTypeUseCase
import egsys.domain.usecase.home.GetListPokemonsUseCase
import egsys.domain.usecase.home.GetListWithNameAndTypeUseCase
import egsys.pokedex.ui.screens.appArea.home.HomeViewModel
import egsys.pokedex.ui.screens.appArea.home.HomeViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single<Service> { RetrofitInicializer().getRetrofitService() }
    viewModel<HomeViewModel>{ HomeViewModelImpl(get(), get(), get(), get()) }
    factory { GetListPokemonsUseCase(get()) }
    factory { GetListTypeUseCase(get()) }
    factory { GetListOnlyByTypeUseCase(get()) }
    factory { GetListWithNameAndTypeUseCase(get()) }
    single<Repository> { RepositoryImpl(get(), get()) }
}