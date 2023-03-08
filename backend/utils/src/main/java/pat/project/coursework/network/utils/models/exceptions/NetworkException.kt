package pat.project.coursework.network.utils.models.exceptions

class NetworkException(
    override val message: String?,
    override val cause: Throwable,
) : Exception(message, cause)

class NoNetworkException(
    override val message: String?,
    override val cause: Throwable
) : Exception(message, cause)
