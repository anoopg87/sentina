package au.com.sentina.webservice

interface APICallBacks<in T> {
    fun setResult(t: T)
    fun setError(message: String)
}