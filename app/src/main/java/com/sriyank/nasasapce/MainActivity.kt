package com.sriyank.nasasapce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sriyank.nasasapce.model.RiskData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myArray: ArrayList<RiskData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myArray = arrayListOf<RiskData>()

        myArray.add(
            RiskData(
                R.drawable.semsem,
                "Muscle Atrophy",
                "Semsem",
                "36 space years",
                "loves to sing and study matters of space",
                "- The lead singer in the music band called \"AstroDragons\".\n" +
                        "- Is the hero that managed to overcome the the muscle atrophy stress in space.",
                "hopes to be the most famous singer in the galaxy."
            )
        )

        myArray.add(
            RiskData(
                R.drawable.felfel,
                "inadequate nutrition",
                "Felfel",
                "35 space years",
                "loves drawing",
                "- his art gallery is going to open in two days, he's a very excited boy.\n" +
                        "- this talented Spacetopian managed to find the solution for eating healthy in space.",
                "wants to be the No. 1 painter among his town."
            )
        )

        myArray.add(
            RiskData(
                R.drawable.doc,
                "immune dysregulation",
                "Doctor",
                "48 space years",
                "biological experiments and animals",
                "- his art gallery is going to open in two days, he's a very excited boy.\n" +
                        "- this talented Spacetopian managed to find the solution for eating healthy in space. He's about to apply for the space science award, let's hope he wins it!\n" +
                        "- An expert on the immune system and managed to find a solution to its related problem. ",
                "Aspires to end all the biological diseases and begin a new life."
            )
        )

        myArray.add(
            RiskData(
                R.drawable.warda,
                "Radiation Carcinogenesis",
                "Mrs/Warda",
                "29 space years",
                "playing the piano and reading books",
                "- The wife of Mr. Daboor.\n" +
                        "- The pianist in the music band \"AstroDragons",
                "wants to have 2 kids a boy and a girl."
            )
        )

        myArray.add(
            RiskData(
                R.drawable.daboor,
                "Bone fractures",
                "Mr. Daboor",
                "31 space years",
                "playing the guitar and going on dates with his wife",
                "The lead guitarist in the music band \"AstroDragons\"",
                "be the most famous guitarist in Space"
            )
        )

        myArray.add(
            RiskData(
                R.drawable.rosa,
                "Renal stones",
                "Rosa",
                "18 space years",
                " likes to travel and knowing others",
                "- She's a senior in High school.\n" +
                        "- Has a fan account for \"AstroDragons\"",
                "Meet the members of her favorite band and be a successful person"
            )
        )

        myArray.add(
            RiskData(
                R.drawable.catto,
                "SANS",
                "Mr. Catto",
                "31 space years",
                "studying of human nature",
                "A senior cat in his community",
                "knowing the little secrets of everybeing"
            )
        )

        myArray.add(
            RiskData(
                R.drawable.beans,
                "Host-microorganisms interactions",
                "Mr. Green beans",
                "41 space years",
                "biology of the small organisms",
                "his mum is an Astrotopia while his dad is a Spacetopian",
                "wear glasses with six lenses"
            )
        )

        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.setHasFixedSize(true)

        val adapter = RiskAdapter(myArray)
        recycleView.adapter = adapter

        adapter.setOnClickListener(object : RiskAdapter.onItemClickListener{

            override fun onItemClick(position: Int) {

                val intent = Intent(this@MainActivity,ProfileActivity::class.java)

                intent.putExtra("image",myArray[position].img)
                intent.putExtra("stress",myArray[position].Stress)
                intent.putExtra("name",myArray[position].Name)
                intent.putExtra("age",myArray[position].age)
                intent.putExtra("likes",myArray[position].Likes)
                intent.putExtra("about",myArray[position].About)
                intent.putExtra("dream",myArray[position].Dreams)

                startActivity(intent)
            }

        })

    }
}