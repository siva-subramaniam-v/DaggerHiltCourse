package `in`.sivasubramaniam.daggerhiltcourse.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.sivasubramaniam.daggerhiltcourse.data.remote.MyApi
import `in`.sivasubramaniam.daggerhiltcourse.data.repository.MyRepositoryImpl
import `in`.sivasubramaniam.daggerhiltcourse.domain.repository.MyRepository
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // SingletonComponent -> all dependencies will live as long as the application does
object AppModule {

    @Provides
    @Singleton // Singleton -> only one instance of this class will be created in this module and will be shared wherever an object of this type needs to be injected
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(MyApi::class.java)
    }

//    @Provides
//    @Singleton
//    fun provideMyRepository(
//        api: MyApi,
//        app: Application,
//        @Named("hello1") hello1: String
//    ): MyRepository {
//        return MyRepositoryImpl(api, app)
//    } --> moved to RepositoryModule.kt (abstracted dependency)

    // Dependencies if the same type
    @Provides
    @Singleton
    @Named("hello1")
    fun provideString1() = "Hello 1"

    @Provides
    @Singleton
    @Named("hello2")
    fun provideString2() = "Hello 2"
}