package di

object NetworkModule {
    val module = module {
        single { HTTPClient() }
        factory { get<HTTPClient>().create(::class) }
    }
}