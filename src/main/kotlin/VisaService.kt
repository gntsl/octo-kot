import java.time.LocalDate

interface VisaService {

    val storage: ApplicationsStorage

    fun createApplication(userId: String, applicationDate: LocalDate)

    fun createCity(id: Long, name: String)

    fun submitBiometrics(userId: String, submissionDate: LocalDate, cityId: Long)

    fun approveVisa(userId: String, visaType: VisaType, approveDate: LocalDate)

    fun submitPassport(userId: String, submissionDate: LocalDate, cityId: Long)

    fun receivePassport(userId: String, receiveDate: LocalDate)

}