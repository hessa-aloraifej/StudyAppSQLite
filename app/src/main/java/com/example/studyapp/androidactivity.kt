package com.example.studyapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class androidactivity : AppCompatActivity() {

    lateinit var myRV:RecyclerView
    lateinit var dbhr:DBHlpr
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_androidactivity)
        dbhr=DBHlpr(applicationContext)
        myRV =findViewById(R.id.rvMain)

        var type='a'
        val data = dbhr.readData(type)
        updateRV(data)
        title = "Kotlin Topics For Review"
    }

fun updateRV(data: ArrayList<Lessons>){
    myRV.adapter = RecyclerViewAdapter(this@androidactivity,data)
    myRV.layoutManager = LinearLayoutManager(this)
}

    fun remove(s: String){
        dbhr.del(s)
        updateRV(dbhr.readData('a'))
    }
    fun edit(s1: String, s2:String){
        dbhr.update(s1,s2)
       updateRV(dbhr.readData('a'))
    }
    fun customAlert(s: String){


        val dialogBuilder = AlertDialog.Builder(this)
        val input = EditText(this)

        dialogBuilder.setMessage("Edit Your Content")
            .setPositiveButton("Ok", DialogInterface.OnClickListener {
                    dialog, id ->
                edit(s,input.text.toString())
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                    dialog, id ->dialog.cancel()
            })

        val alert = dialogBuilder.create()

        alert.setTitle("Edit Note")
        alert.setView(input)
        alert.show()
    }

    fun confirmAlert(s: String){


        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setMessage("Are You Sure To Delete This ?")
            .setPositiveButton("Yes", DialogInterface.OnClickListener {
                    dialog, id ->
                remove(s)
            })
            .setNegativeButton("No", DialogInterface.OnClickListener {
                    dialog, id ->dialog.cancel()
            })

        val alert = dialogBuilder.create()

        alert.setTitle("Confirmation")
        alert.show()
    }
}