package com.help.ukraine.tranzzosdkexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import ua.tranzzo.checkout_sdk.model.AmountType
import ua.tranzzo.checkout_sdk.model.CardModel
import ua.tranzzo.checkout_sdk.model.CustomerData
import ua.tranzzo.checkout_sdk.model.KeyConfig
import ua.tranzzo.checkout_sdk.model.PaymentContract
import ua.tranzzo.checkout_sdk.model.PaymentContractInput
import ua.tranzzo.checkout_sdk.model.PaymentContractOutput
import java.util.UUID

class MainActivity : AppCompatActivity() {
    private lateinit var freeButton: Button

    private lateinit var constantButton: Button

    private lateinit var paymentLauncher: ActivityResultLauncher<PaymentContractInput>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViews()
        setupListeners()
        registerForPaymentResult()
    }

    private fun goToPayment(type: AmountType) {
        paymentLauncher.launch(
            PaymentContractInput(
                amountType = type,
                keyConfig = KeyConfig(
                    sessionToken = Hardcode.generateJWTToken(this),
                    apiKey = "372ddcbf-f4e7-4c24-b5be-f6cfa1b11b9d",
                    posId = "8d6ba88a-6e45-42cd-9626-f6a6d182ddae",
                ),
                customerData = CustomerData(
                    customerEmail = "tempmail@gmail.com",
                    customerPhone = "0506541111"
                ),
            )
        )
    }

    @Suppress("MagicNumber")
    private fun getConstantPayment(): AmountType {
        return AmountType.ConstantAmount(
            amount = 2.53,
            description = "Test description",
            orderId = UUID.randomUUID().toString(),
        )
    }

    @Suppress("MagicNumber")
    private fun getFreePayment(): AmountType {
        return AmountType.FreeAmount(
            prefillAmount = listOf(1, 2, 3),
            description = "Test description",
            orderId = UUID.randomUUID().toString(),
        )
    }

//    @Suppress("MagicNumber")
//    private fun getFreePayment(): AmountType {
//        return AmountType.FreeAmount(
//            prefillAmount = emptyList(),
//            description = "Test description",
//            orderId = UUID.randomUUID().toString(),
//        )
//    }

    private fun findViews() {
        freeButton = findViewById(R.id.free_test_button)
        constantButton = findViewById(R.id.constant_test_button)
    }

    private fun setupListeners() {
        freeButton.setOnClickListener { goToPayment(getFreePayment()) }
        constantButton.setOnClickListener { goToPayment(getConstantPayment()) }
    }

    private fun registerForPaymentResult() {
        paymentLauncher =
            registerForActivityResult(PaymentContract()) { output: PaymentContractOutput ->
                Toast.makeText(this, output.toString(), Toast.LENGTH_LONG).show()
                Log.i("TAG", "Got some value: $output")
            }
    }
}