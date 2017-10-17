package lurie.rm.simpleeditor

import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.fileContent
import android.os.Bundle
import android.content.Context
import android.os.Environment
import android.view.View
import android.widget.Toast
import lurie.rm.simpleeditor.R.id.fileContent
import java.io.BufferedReader
import java.io.File
import java.io.PrintWriter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun saveMe(view: View) {
        val sd_main = File(filesDir.toString())
        var success = true
        if (!sd_main.exists()) {
            success = sd_main.mkdir()
        }
        if (success) {
            val sd = File(sd_main, "SEditor")

            if (!sd.exists()) {
                success = sd.mkdir()
            }
            if (success) {
                // directory exists or already created
                val dest = File(sd, "hardcodedfile.txt")
                try {
                    PrintWriter(dest).use { out -> out.println(fileContent.text.toString()) }
                    val lToast = Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT)
                    lToast.show()
                } catch (e: Exception) {
                    // TODO: handle the exception
                }
            } else {
                // TODO: handle too
            }
        }
    }

    fun loadMe(view: View) {
        val file = File(filesDir.toString() + "/SEditor", "hardcodedfile.txt")
        if (file.exists()) {
            val bufferedReader: BufferedReader = file.bufferedReader()
            val inputString = bufferedReader.use {it.readText()}
            fileContent.setText(inputString)
            fileContent.setSelection(fileContent.text.length)
            val lToast = Toast.makeText(this, "Load!", Toast.LENGTH_SHORT)
            lToast.show()
        }
        else{
            val lToast = Toast.makeText(this, "Not Exist!", Toast.LENGTH_SHORT)
            lToast.show()
        }


    }
}