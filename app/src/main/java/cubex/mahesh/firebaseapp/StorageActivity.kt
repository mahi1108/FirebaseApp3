package cubex.mahesh.firebaseapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class StorageActivity : AppCompatActivity() {

    var iview:ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)

        iview = findViewById(R.id.iview)
        
    }

    fun  camera(v:View)
    {

    }

    fun  gallery(v:View)
    {

    }

}
