interface ApplicationsStorage {

    fun addApplication(application: Application)

    fun addCity(city: City)

    fun getCity(id: Long): City?

    fun getApplications(): Collection<Application>

    fun findApplication(userId: String): Application?

    fun updateApplication(application: Application)

}