package org.wfp.serviceprovision.constants

class ApiEndpoints {
    companion object {
        const val SERVICES_BY_COUNTRY_ENDPOINT="services/{countryCode}/"
        const val queries_ENDPOINT="queries/"
        const val LOGIN_ENDPOINT="auth/login/"
        const val LOGOUT_ENDPOINT="auth/logout"
        const val REGISTER_ENDPOINT="auth/register"
        const val PASSWORD_RESET_ENDPOINT="auth/password/reset/confirm"
    }
}