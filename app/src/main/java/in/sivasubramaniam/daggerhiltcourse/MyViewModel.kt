package `in`.sivasubramaniam.daggerhiltcourse

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.sivasubramaniam.daggerhiltcourse.domain.repository.MyRepository
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: dagger.Lazy<MyRepository> // Lazy injection -> injecting the dependency, but delaying object creation
): ViewModel() {
    init {
        repository.get() // unless repository.get() is called, the repository instance will not be created by hilt
        // use case for lazy injection - https://www.youtube.com/watch?v=bbMsuI2p1DQ&t=1988s
    }
}