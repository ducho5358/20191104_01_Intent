package com.tjoeun.a20191104_01_intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_user_info.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {




    val REQ_CODE_FOR_PHONe_NUM = 1001


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        phoneNameInputBtn.setOnClickListener {

            val intent = Intent(this, EditPhoneNumActivity::class.java)
            startActivityForResult(intent, REQ_CODE_FOR_PHONe_NUM)
        }

        nameInputBtn.setOnClickListener {

            val intent = Intent(this, EditUserInfoActivity::class.java)


            if(nameEdt.text.toString() != "이름 입력 필요") {
                intent.putExtra()
            }

            startActivityForResult(intent, 1000)
        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode == 1000) {
            if(resultCode == Activity.RESULT_OK) {

              var inputNameData = data?.getStringExtra("inputName")?.toLowerCase()

              inputNameData?.let {

                  nameTxt.text = it


              }

            else if(requestCode == REQ_CODE_FOR_PHONe_NUM) {
                    if(resultCode == Activity.RESULT_OK) {
                        var phoneNumStr = data?.getStringExtra("inputPhoneNum")

                        phoneNumStr?.let {
                            phoneNumTxt.text = phoneNumStr

                        }
                    }


                }


            }


        }


    }


}
