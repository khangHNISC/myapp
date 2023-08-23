import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.myapp.core.network.fake.FakeNetworkDataSource


@Module
@InstallIn(SingletonComponent::class)
interface FlavoredNetworkModule {
    @Binds
    fun FakeNetworkDataSource.binds(): MyAppNetworkDataSource
}