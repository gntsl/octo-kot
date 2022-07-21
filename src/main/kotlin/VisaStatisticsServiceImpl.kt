class VisaStatisticsServiceImpl(override val storage: ApplicationsStorage) : VisaStatisticsService {

    override fun getApplicationsCount(): Int {
        return storage.getApplications().size
    }

    override fun getMostPopularCity(): String {
        return storage.getApplications().groupingBy { a -> a.biometricsCity!!.name }.eachCount()
            .maxOf { it.key }.toString()
    }

    override fun getFoilLessVisasCountByCity(): Map<String, Int> {
        return storage.getApplications().filter { a -> a.visaType!! == VisaType.FOIL_LESS }
            .groupingBy { a -> a.biometricsCity!!.name }.eachCount()
    }
}