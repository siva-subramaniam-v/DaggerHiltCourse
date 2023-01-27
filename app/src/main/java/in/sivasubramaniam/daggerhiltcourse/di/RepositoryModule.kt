package `in`.sivasubramaniam.daggerhiltcourse.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.sivasubramaniam.daggerhiltcourse.data.repository.MyRepositoryImpl
import `in`.sivasubramaniam.daggerhiltcourse.domain.repository.MyRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    // using "@Binds" instead of "@Provides" for abstraction types reduces code generation by dagger.
    @Binds // binds implementation type to abstraction type, ie: returns the specific implementation type provided in this constructor, when a dependency of the abstraction type is requested
    @Singleton
    abstract fun bindMyRepository(
        myRepositoryImpl: MyRepositoryImpl // actual implementation type to be injected
    ): MyRepository // abstraction type (interface / abstract class)
}