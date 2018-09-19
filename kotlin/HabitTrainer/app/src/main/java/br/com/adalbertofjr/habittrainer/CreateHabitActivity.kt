package br.com.adalbertofjr.habittrainer

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import br.com.adalbertofjr.habittrainer.db.HabitDbTable
import kotlinx.android.synthetic.main.activity_create_habit.*
import java.io.IOException

private val CHOOSE_IMAGE_REQUEST = 1

class CreateHabitActivity : AppCompatActivity() {
    private val LOG_TAG = CreateHabitActivity::class.java.simpleName

    private var imageBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_habit)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }


    fun storeHabit(v: View) {
        if (edt_title.isBlank() || edt_description.isBlank()) {
            Log.d(LOG_TAG, "No habit stored: title or description missing.")
            displayErrorMessage("You habit needs an engaging title and description.")
            return
        } else if (this.imageBitmap == null) {
            Log.d(LOG_TAG, "No habit stored: image missing.")
            displayErrorMessage("Add a motivation picture to your habit.")
            return
        }

        // Store data
        val title = edt_title.text.toString()
        val description = edt_description.text.toString()
        val habit = Habit(title, description, imageBitmap!!)

        val id = HabitDbTable(this).store(habit)

        if (id == -1L) {
            displayErrorMessage("Habit could not be stored.")
        } else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun displayErrorMessage(message: String) {
        tv_error.visibility = View.VISIBLE
        tv_error.text = message
    }

    fun chooseImage(v: View) {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        val chooser = Intent.createChooser(intent, "Choose image for a new habit")
        startActivityForResult(chooser, CHOOSE_IMAGE_REQUEST)

        Log.d(LOG_TAG, "Intent to choose image sent")
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CHOOSE_IMAGE_REQUEST && resultCode == Activity.RESULT_OK
                && data != null && data.data != null) {
            Log.d(LOG_TAG, "An image was chosen by the user.")

            val bitmap = tryReadBitmap(data.data)

            bitmap?.let {
                this.imageBitmap = bitmap
                iv_image.setImageBitmap(bitmap)
                Log.d(LOG_TAG, "Read image bitmap and update image view.")
            }

        }
    }

    private fun tryReadBitmap(data: Uri): Bitmap? {
        return try {
            MediaStore.Images.Media.getBitmap(contentResolver, data)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}

private fun EditText.isBlank() = this.text.toString().isBlank()
