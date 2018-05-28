package cubex.mahesh.firebaseapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import java.io.File

class StorageActivity : AppCompatActivity() {

    var iview:ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)

        iview = findViewById(R.id.iview)
        
    }

    fun  camera(v:View)
    {
  var i = Intent("android.media.action.IMAGE_CAPTURE")
    startActivityForResult(i,123)
    }

    fun  gallery(v:View)
    {
        var i = Intent()
        i.setAction(Intent.ACTION_GET_CONTENT)
        i.setType("image/*");
        startActivityForResult(i,124)
    }

    override fun onActivityResult(requestCode: Int,
                                    resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode,
                data)
        var uri:Uri? = null
        if(requestCode==123 && resultCode== Activity.RESULT_OK)
        {


        }else if(requestCode==124&& resultCode== Activity.RESULT_OK)
        {
         var uri =  data?.data
         var file:File = File(uri?.path)

         var dRef = FirebaseStorage.getInstance().
        getReference(FirebaseAuth.getInstance().currentUser!!.uid)
        dRef.child(file.name).putFile(uri!!).
          addOnCompleteListener(object : OnCompleteListener<UploadTask.TaskSnapshot> {
              override fun onComplete(task: Task<UploadTask.TaskSnapshot>) {

     Toast.makeText(this@StorageActivity,
             task.isSuccessful.toString(),Toast.LENGTH_LONG).show( )

        var dBase = FirebaseDatabase.getInstance().getReference(
                FirebaseAuth.getInstance().currentUser!!.uid)
        dBase.child("profile_url").
                setValue(task.getResult().downloadUrl.toString())
              }

          })
        }

    }


}
