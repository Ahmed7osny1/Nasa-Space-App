package com.sriyank.nasasapce

import com.sriyank.nasasapce.model.QuestionData

object setData {

    fun getQuestion(): ArrayList<QuestionData> {

        var que: ArrayList<QuestionData> = arrayListOf()

        que.add(
            QuestionData(
            1,
            "Our astronauts work in a weightless environment," +
                    " very little muscle contraction is needed to support their bodies or move around." +
                    " Without regular use and exercise our muscles gradually become weak," +
                    " this is a process called ......",
                "Hypoplasia",
                "Atrophy",
                "dysplasia",
                2
            )
        )

        que.add(
            QuestionData(
                1,
                "Studies have shown that astronauts experience up to a 20 percent loss" +
                        " of muscle mass on spaceflights lasting.....",
                "five to eleven days.",
                "five to eleven months.",
                "five to eleven year.",
                1
            )
        )

        que.add(
            QuestionData(
                1,
                "The way to minimize muscle atrophy in space is through ....",
                "sleeping and stop doing anything for 2 weeks.",
                "intensive exercise and adequate diet.",
                "eating large amount of protein.",
                2
            )
        )

        return que
    }
}