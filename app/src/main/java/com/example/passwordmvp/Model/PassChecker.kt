package com.example.passwordmvp.Model

class PassChecker {

    fun checkPasswordStrength(password: String): Int{

        var strength = if (password.length < 5) {
            3 } else if ( password.length > 5 && !checkUpperCase(password)) {
            6 } else if ( password.length > 5 && checkUpperCase(password)) {
            9
        } else { 0 }

        return password.length
    }

    fun checkUpperCase(value: String): Boolean{
        for (c in value)
        {
            if (c.isUpperCase()){
                return true
            }

        }
        return false
    }
}
