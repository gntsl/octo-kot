import java.time.LocalDate

class VisaServiceImpl(override val storage: ApplicationsStorage) : VisaService {

    override fun createApplication(userId: String, applicationDate: LocalDate) {
        storage.addApplication(Application(userId, applicationDate, ApplicationState.CREATED))
    }

    override fun createCity(id: Long, name: String) {
        storage.addCity(City(id, name))
    }

    override fun submitBiometrics(userId: String, submissionDate: LocalDate, cityId: Long) {
        val application = storage.findApplication(userId)
        application?.biometricsCity = storage.getCity(cityId)
        application?.biometricsDate = submissionDate
        application?.applicationState = ApplicationState.BIOMETRICS_SUBMITTED
        application?.let { storage.updateApplication(it) }
    }

    override fun approveVisa(userId: String, visaType: VisaType, approveDate: LocalDate) {
        val application = storage.findApplication(userId)
        application?.visaType = visaType
        application?.approveDate = approveDate
        application?.applicationState = ApplicationState.VISA_APPROVED
        application?.let { storage.updateApplication(it) }
    }

    override fun submitPassport(userId: String, submissionDate: LocalDate, cityId: Long) {
        val application = storage.findApplication(userId)
        application?.stampCity = storage.getCity(cityId)
        application?.stampSubmissionDate = submissionDate
        application?.applicationState = ApplicationState.PASSPORT_SUBMITTED
        application?.let { storage.updateApplication(it) }
    }

    override fun receivePassport(userId: String, receiveDate: LocalDate) {
        val application = storage.findApplication(userId)
        application?.stampDate = receiveDate
        application?.applicationState = ApplicationState.COMPLETED
        application?.let { storage.updateApplication(it) }
    }
}