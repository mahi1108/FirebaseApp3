package cubex.mahesh.firebaseapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var let1:EditText? = null
    var let2:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        let1 = findViewById(R.id.let1)
        let2 = findViewById(R.id.let2)

    }

    fun  login(v:View)
    {

    }
    
    fun  register(v:View)
    {

    }
}
