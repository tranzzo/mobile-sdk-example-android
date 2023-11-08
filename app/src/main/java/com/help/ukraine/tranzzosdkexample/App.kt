package com.help.ukraine.tranzzosdkexample

import android.app.Application
import ua.tranzzo.checkout_sdk.GooglePayConfig
import ua.tranzzo.checkout_sdk.TranzzoPaymentSDK
import ua.tranzzo.checkout_sdk.model.SdkEnvironment

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        TranzzoPaymentSDK.init(
            sdkEnvironment = SdkEnvironment.TEST,
            googlePayConfig = GooglePayConfig(
                merchantName = "Test merchant name",
                merchantId = "01234567890123456789",
                environment = SdkEnvironment.TEST
            ),
            currency = "UAH",
            countryCode = "UA",
            loggerEnabled = true,
        )
    }
}
