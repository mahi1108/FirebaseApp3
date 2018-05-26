package cubex.mahesh.firebaseapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {

    var et1:EditText? = null
    var et2:EditText? = null
    var et3:EditText? = null
    var et4:EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        et1 = findViewById(R.id.ret1)
        et2 = findViewById(R.id.ret2)
        et3 = findViewById(R.id.ret3)
        et4 = findViewById(R.id.ret4)
    }

    fun register(v:View)
    {



    }


}
