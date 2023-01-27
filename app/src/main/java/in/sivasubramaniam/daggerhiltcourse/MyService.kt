package `in`.sivasubramaniam.daggerhiltcourse

import android.app.Service
import android.content.Intent
import android.os.IBinder
import dagger.hilt.android.AndroidEntryPoint
import `in`.sivasubramaniam.daggerhiltcourse.domain.repository.MyRepository
import javax.inject.Inject

@AndroidEntryPoint // to be specified on top of all android component classes - Activities, Fragments, Services etc..
class MyService : Service() {

    @Inject
    lateinit var myRepository: MyRepository // Field injection. Fields need to be public to be injected

    override fun onCreate() {
        super.onCreate() // injection happens in onCreate() of super class
        // myRepository.doNetworkCall() -> injected fields can & must be used after super.onCreate()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}

/*
class MyService @Inject constructor(
    private val repository: MyRepository // can't inject dependencies for services in the constructor, because -> (constructors cannot be provided to services)
): Service() {

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}
*/