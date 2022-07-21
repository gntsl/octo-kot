interface VisaStatisticsService {
    val storage: ApplicationsStorage

    fun getApplicationsCount(): Int

    fun getMostPopularCity(): String

    fun getFoilLessVisasCountByCity(): Map<String, Int>
}