package cubex.mahesh.firebaseapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

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
        var fuser = FirebaseAuth.getInstance().
                    currentUser?.uid
        var dBase = FirebaseDatabase.getInstance()
        var dref = dBase.getReference(fuser)
        dref.child("name").setValue(et1?.text.toString())
        dref.child("gender").setValue(et2?.text.toString())
        dref.child("mno").setValue(et3?.text.toString())
        dref.child("dob").setValue(et4?.text.toString())

        var i = Intent(this@RegisterActivity,
                StorageActivity::class.java)
        startActivity(i)
     }


}
