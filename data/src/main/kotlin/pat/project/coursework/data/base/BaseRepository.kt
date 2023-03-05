package pat.project.coursework.data.base


import pat.project.coursework.network.utils.models.ResponseStatus
import pat.project.coursework.network.utils.models.exceptions.NetworkException
import pat.project.coursework.network.utils.models.exceptions.NoNetworkException
import java.net.UnknownHostException

open class BaseRepository(
    private val repository: String = "Repository",
) {

    protected suspend fun <K : Any> safeApiSuspendResult(call: suspend () -> K?): ResponseStatus<K> {
        val response: K?
        return try {
            response = call.invoke()
            ResponseStatus.Success(
                response
            )
        } catch (e: Exception) {
            when (e) {
                is UnknownHostException -> {
                    ResponseStatus.Error(
                        NoNetworkException(
                            e.message,
                            Throwable(repository),
                        )
                    )
                }
                else -> {
                    ResponseStatus.Error(
                        NetworkException(
                            e.message,
                            Throwable(repository),
                        )
                    )
                }
            }
        }
    }

    companion object {
        val SUCCESS_CODES = 200..299
        val SERVER_ERROR_CODE = 500..540
        const val AUTHENTICATION_ERROR_CODE = 401
    }
}
