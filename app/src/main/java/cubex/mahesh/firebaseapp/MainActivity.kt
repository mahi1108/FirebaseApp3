package cubex.mahesh.firebaseapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth



class MainActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    var let1:EditText? = null
    var let2:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        let1 = findViewById(R.id.let1)
        let2 = findViewById(R.id.let2)

        mAuth = FirebaseAuth.getInstance()

    }

    fun  login(v:View)
    {

        mAuth?.signInWithEmailAndPassword(
                let1?.text.toString(),let2?.text.toString())!!.
                addOnCompleteListener(object:
                        OnCompleteListener<AuthResult> {
                    override fun onComplete(task: Task<AuthResult>) {
                        if(task.isSuccessful){

                            var i = Intent(this@MainActivity,
                                    DashboardActivity::class.java)
                            startActivity(i)


                        }else{
                            Toast.makeText(this@MainActivity,
                                    "Auth Failed...",Toast.LENGTH_LONG).show()
                        }
                    }
                })

    }
    
    fun  register(v:View)
    {
        mAuth?.createUserWithEmailAndPassword(
                let1?.text.toString(),let2?.text.toString())!!.
                addOnCompleteListener(object:
                        OnCompleteListener<AuthResult> {
                    override fun onComplete(task: Task<AuthResult>) {
                            if(task.isSuccessful){
                                var i = Intent(this@MainActivity,
                                        RegisterActivity::class.java)
                                startActivity(i)
                            }else{
       Toast.makeText(this@MainActivity,
           "Auth Failed...",Toast.LENGTH_LONG).show()
                            }
                    }
                })
    }
}
