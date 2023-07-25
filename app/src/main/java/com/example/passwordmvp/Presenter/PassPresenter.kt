package com.example.passwordmvp.Presenter

import com.example.passwordmvp.Model.PassChecker

class PassPresenter(private val view: Passview) {

    private val passChecker= PassChecker()

    fun onPasswordTextChanged(password: String){
        val nivelpassword= passChecker.checkPasswordStrength(password)
        view.showPasswordStrengthLevel(nivelpassword)
    }
}