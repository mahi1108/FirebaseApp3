package cubex.mahesh.firebaseapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdRequest
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.android.gms.ads.AdView



class DashboardActivity : AppCompatActivity() {

    var name:TextView? = null
    var gender:TextView? = null
    var mno:TextView? = null
    var dob:TextView? = null

    var iview:ImageView? = null
    private var mAdView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        mAdView = findViewById<View>(R.id.adView) as AdView?
        val adRequest = AdRequest.Builder().build()
        mAdView!!.loadAd(adRequest)

        iview = findViewById(R.id.iview)

        name = findViewById(R.id.name)
        gender = findViewById(R.id.gender)
        mno = findViewById(R.id.mno)
        dob = findViewById(R.id.dob)

        var fuser = FirebaseAuth.getInstance().
                currentUser?.uid
        var dBase = FirebaseDatabase.getInstance()
        var dref = dBase.getReference(fuser)
        dref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {

            }

            override fun onDataChange(ds: DataSnapshot?) {
               var it =      ds?.children
                it!!.forEach { e ->
                    if(e.key.equals("name")){
                        name?.setText(e.value.toString())
                    }
                    if(e.key.equals("gander")){
                        gender?.setText(e.value.toString())
                    }
                    if(e.key.equals("mno")){
                        mno?.setText(e.value.toString())
                    }
                    if(e.key.equals("dob")){
                        dob?.setText(e.value.toString())
                    }
                    if(e.key.equals("profile_pic")){
                      //   name?.setText(e.value.toString())
                        Glide.with(this@DashboardActivity).
                                load(e.value.toString()).
                                into(iview!!)
                    }
                }
            }
        })

    }

}
