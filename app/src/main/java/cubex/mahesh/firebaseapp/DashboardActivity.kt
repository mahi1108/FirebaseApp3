package cubex.mahesh.firebaseapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {

    var name:TextView? = null
    var gender:TextView? = null
    var mno:TextView? = null
    var dob:TextView? = null

    var iview:ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        name = findViewById(R.id.name)
        gender = findViewById(R.id.gender)
        mno = findViewById(R.id.mno)
        dob = findViewById(R.id.dob)

    }

}
