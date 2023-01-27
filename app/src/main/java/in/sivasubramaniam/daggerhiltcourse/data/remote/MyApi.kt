package `in`.sivasubramaniam.daggerhiltcourse.data.remote

import retrofit2.http.GET

interface MyApi {
    @GET("test")
    suspend fun doNetWorkCall()
}