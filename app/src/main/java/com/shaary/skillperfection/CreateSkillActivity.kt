package com.shaary.skillperfection

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class CreateSkillActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_skill)

        var editSkillName: EditText = findViewById(R.id.skill_name_edit_text)
        val saveButton = findViewById<Button>(R.id.save_button)
        val cancelButton: Button = findViewById(R.id.cancel_button)

        saveButton.setOnClickListener{
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editSkillName.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val skill = editSkillName.text.toString()
                replyIntent.putExtra(EXTRA_NAME, skill)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }

        cancelButton.setOnClickListener{
            val replyIntent = Intent()
            setResult(Activity.RESULT_CANCELED, replyIntent)
            finish()
        }
    }

    companion object {
        const val EXTRA_NAME = "com.shaary.skillperfection.NAME"
    }
}
