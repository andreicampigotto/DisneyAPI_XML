package di

import org.koin.dsl.module

object NetworkModule {
    val module = module {
        single { HTTPClient() }
        factory { get<HTTPClient>().create(::class) }
    }
}