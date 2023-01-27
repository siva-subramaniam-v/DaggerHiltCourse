package `in`.sivasubramaniam.daggerhiltcourse.data.repository

import android.app.Application
import `in`.sivasubramaniam.daggerhiltcourse.R
import `in`.sivasubramaniam.daggerhiltcourse.data.remote.MyApi
import `in`.sivasubramaniam.daggerhiltcourse.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor( // When there is an inject constructor,
    // there is no need for a separate provides function for that class
    private val api: MyApi,
    private val appContext: Application
): MyRepository {

    init {
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository. The app name is $appName")
    }

    override suspend fun doNetworkCall() {
    }
}