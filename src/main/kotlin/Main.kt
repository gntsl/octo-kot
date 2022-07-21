import java.time.LocalDate

fun main(args: Array<String>) {
    val dictionaryApplicationsStorage = DictionaryApplicationsStorage()
    val service = VisaServiceImpl(dictionaryApplicationsStorage)
    val stat = VisaStatisticsServiceImpl(dictionaryApplicationsStorage)

    service.createCity(1, "Rome")
    service.createCity(2, "London")
    service.createCity(3, "Budapest")

    generateApplications(100, service)

    println("Count of all applications:  ${stat.getApplicationsCount()}")
    println("Cities issued foil-less visas:  ${stat.getFoilLessVisasCountByCity()}")
    println("Most popular city among all type of application: ${stat.getMostPopularCity()}")
}

private fun generateApplications(number: Int, service: VisaServiceImpl) {
    for (i in 1..number) {
        val userId = "User$i"
        val visaType = VisaType.values().random()
        service.createApplication(userId, LocalDate.now().minusDays((0..40L).random()))
        service.submitBiometrics(
            userId,
            LocalDate.now().minusDays((20..40L).random()),
            (1..3L).random()
        )
        service.approveVisa(userId, visaType, LocalDate.now().minusDays((0..20L).random()))
        if (visaType != VisaType.FOIL_LESS) {
            service.submitPassport(
                userId,
                LocalDate.now().minusDays((0..10L).random()),
                (1..3L).random()
            )
            service.receivePassport(userId, LocalDate.now())
        }
    }
}