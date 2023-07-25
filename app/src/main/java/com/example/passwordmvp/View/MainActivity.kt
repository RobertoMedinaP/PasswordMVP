package com.example.passwordmvp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.passwordmvp.Presenter.PassPresenter
import com.example.passwordmvp.Presenter.Passview
import com.example.passwordmvp.R
import com.example.passwordmvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Passview {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: PassPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        presenter= PassPresenter(this)

        binding.button.setOnClickListener {
            val password= binding.textInputLayout.editText?.text.toString()
            presenter.onPasswordTextChanged(password)
        }


    }

    override fun showPasswordStrengthLevel(Level: Int) {
        var texto=binding.textView2
        var color = R.color.white
        if (Level<=4) {
            color = R.color.red
            texto.setText("Password Débil")
        }
        else if (Level >=5 && Level <=8){
            color= R.color.yellow
            texto.setText("Password de seguridad media")

        }
        else if (Level>=9){
            color=R.color.green
            texto.setText("Password de seguridad fuerte")
        }
        else{
            texto.setText("Ingrese un Password")
        }

        binding.textView2.setBackgroundColor(resources.getColor(color))
    }
}