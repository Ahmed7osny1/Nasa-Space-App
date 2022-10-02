package com.sriyank.nasasapce

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.sriyank.nasasapce.model.QuestionData
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private var currentPosition: Int = 1
    private var questionList: ArrayList<QuestionData>? = null
    private var selectedOption: Int = 0
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionList = setData.getQuestion()

        setQuestion()

        que1.setOnClickListener {
            selectedOptionStyle(que1, 1)
        }
        que2.setOnClickListener {
            selectedOptionStyle(que2, 2)
        }
        que3.setOnClickListener {
            selectedOptionStyle(que3, 3)
        }

        submit.setOnClickListener {

            if (selectedOption != 0) {
                val question = questionList!![currentPosition - 1]
                if (selectedOption != question.correct_ans) {
                    setColor(selectedOption, R.color.custom_color_primary2)
                } else {
                    score++
                }
                setColor(question.correct_ans, R.color.custom_color_primary7)
                if (currentPosition == questionList!!.size)
                    submit.text = "FINISH"
                else
                    submit.text = "GO TO NEXT"
            } else {
                currentPosition++
                when {
                    currentPosition <= questionList!!.size -> {
                        setQuestion()
                        submit.text = "SUBMIT"
                    }
                    else -> {
                        var i = Intent(this, ResultActivity::class.java)
                        i.putExtra("que_score", score.toString())
                        i.putExtra("total_score", questionList!!.size.toString())
                        startActivity(i)
                        finish()
                    }
                }
            }
            selectedOption = 0
        }
    }

    fun setColor(opt: Int, color: Int) {

        when (opt) {

            1 -> que1.background = ContextCompat.getDrawable(this, color)
            2 -> que2.background = ContextCompat.getDrawable(this, color)
            3 -> que3.background = ContextCompat.getDrawable(this, color)

        }
    }

    fun setQuestion() {

        val question = questionList!![currentPosition - 1]
        setOptionDisplay()
        progress_bar.progress = currentPosition
        progress_bar.max = questionList!!.size
        progress_txt.text = "${currentPosition} / ${questionList!!.size}"
        Question_text.text = question.question
        que1.text = question.option_one
        que2.text = question.option_two
        que3.text = question.option_three

    }

    fun setOptionDisplay() {

        var optionList: ArrayList<TextView> = arrayListOf()

        optionList.add(0, que1)
        optionList.add(1, que2)
        optionList.add(2, que3)

        for (op in optionList) {

            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.question_style)
            op.typeface = Typeface.DEFAULT

        }

    }

    fun selectedOptionStyle(view: TextView, opt: Int) {

        setOptionDisplay()
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.question_style)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}