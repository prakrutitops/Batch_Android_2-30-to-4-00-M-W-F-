package com.example.uploadimage

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.example.uploadimage.databinding.ActivityMainBinding
import net.gotev.uploadservice.MultipartUploadRequest

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var filepath: Uri
    lateinit var  bitmap: Bitmap

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)

        requestpermission()

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun requestpermission()
    {
       if(checkSelfPermission(READ_EXTERNAL_STORAGE)!= PERMISSION_GRANTED)
       {
           ActivityCompat.requestPermissions(this, arrayOf(READ_EXTERNAL_STORAGE),100)
       }
       else
        {

       }
    }

    override fun onClick(v: View?)
    {
        if(v==binding.btn1)
        {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1)
        }
        if(v==binding.btn2)
        {

            val name = binding.edt1.getText().toString()
            val path = getPath(filepath)
            MultipartUploadRequest(this, "https://vyasprakruti.000webhostapp.com/serverimage/upload.php")
                .addFileToUpload(path, "url")
                .addParameter("name", name)
                .setMaxRetries(2)
                .startUpload()

            Toast.makeText(this@MainActivity, "success", Toast.LENGTH_SHORT).show()

        }
    }

    //path get from URI
    @SuppressLint("Range")
    fun getPath(uri: Uri?): String
    {
        var cursor = contentResolver.query(uri!!, null, null, null, null)
        cursor!!.moveToFirst()
        var document_id = cursor.getString(0)
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1)
        cursor.close()
        cursor = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null, MediaStore.Images.Media._ID + " = ? ", arrayOf(document_id), null)
        cursor!!.moveToFirst()
        val path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
        cursor.close()
        return path
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {

        if(requestCode==1 && resultCode == RESULT_OK && data != null)
        {

            filepath = data.data!!
            bitmap= MediaStore.Images.Media.getBitmap(contentResolver, filepath)
            binding.img.setImageBitmap(bitmap)

        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}