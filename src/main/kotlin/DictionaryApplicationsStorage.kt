class DictionaryApplicationsStorage : ApplicationsStorage {

    private val applications = HashMap<String, Application>()
    private val cities = HashMap<Long, City>()

    override fun addApplication(application: Application) {
        applications[application.userId] = application
    }

    override fun addCity(city: City) {
        cities[city.id] = city
    }

    override fun getCity(id: Long): City? {
        return cities[id]
    }

    override fun getApplications(): Collection<Application> {
        return applications.values
    }

    override fun findApplication(userId: String): Application? {
        return applications[userId]
    }

    override fun updateApplication(application: Application) {
        applications[application.userId] = application
    }
}