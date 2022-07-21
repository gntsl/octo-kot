import java.time.LocalDate

data class Application(
    val userId: String,
    val applicationDate: LocalDate,
    var applicationState: ApplicationState,
    var visaType: VisaType? = null,
    var biometricsCity: City? = null,
    var biometricsDate: LocalDate? = null,
    var approveDate: LocalDate? = null,
    var stampCity: City? = null,
    var stampSubmissionDate: LocalDate? = null,
    var stampDate: LocalDate? = null
)
