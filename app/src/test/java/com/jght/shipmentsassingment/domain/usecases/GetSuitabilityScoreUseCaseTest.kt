package com.jght.shipmentsassingment.domain.usecases

import com.jght.shipmentsassingment.domain.usecases.shipmentsasignment.GetSuitabilityScoreUseCase
import org.junit.Assert.*

import org.junit.Test

class GetSuitabilityScoreUseCaseTest {
    private val myUseCase = GetSuitabilityScoreUseCase()
    private val streetNames = listOf(
        "Osinski Manors",
        "Marvin Stravenue",
        "Kathlyn Ferry",
        "Champlin Lake",
        "Volkman Garden Suite 447",
        "Dessie Lights",
        "Adolf Island Apt. 744",
        "Lindgren Corners",
        "Aufderhar Rive Suite 859",
        "Fake St.",
    )

    private val driverNames = listOf(
        "Everardo Welch",
        "Orval Mayert",
        "Howard Emmerich",
        "Izaiah Lowe",
        "Monica Hermann",
        "Ellis Wisozk",
        "Noemie Murphy",
        "Cleve Durgan",
        "Murphy Mosciski",
        "Kaiser Sos"
    )

    @Test
    operator fun invoke() {

        var result = myUseCase.invoke(streetNames[0], driverNames[0])
        assertEquals(11.25F, result)

    }

    @Test
    fun getBestSuitabilityScore() {

        //get the best suitability score from driver names and street names

        /*streetNames.forEach { streetName ->
            driverNames.forEach { driverName ->
                var result = myUseCase.invoke(streetName, driverName)
                println("streetName: $streetName, driverName: $driverName, suitabilityScore: $result")
            }
        }*/

        driverNames.forEach { driverName ->
            streetNames.forEach { streetName ->

                val result = myUseCase.invoke(streetName, driverName)
                println(", driverName: $driverName, streetName: $streetName, suitabilityScore: $result")
            }
        }

        /*val bestFits = streetNames.flatMap { streetName ->
            driverNames.map { driverName ->
                myUseCase.invoke(streetName, driverName)
            }
        }.max()

        println("bestFits: $bestFits")*/

        val maxValuesByStreetName: Map<String, Pair<Float, String>> = streetNames.groupBy { streetName ->
            streetName
        }.mapValues { (_, streets) ->
            streets.flatMap { street ->
                driverNames.map { driverName ->
                    Pair(myUseCase.invoke(street, driverName), driverName)
                }
            }.maxByOrNull { it.first }?: Pair(0F, "")
        }
        println("maxValuesByStreetName: $maxValuesByStreetName")


        val maxValuesByDriverName: Map<String, Pair<String, Float>> = driverNames.groupBy { driverName ->
            driverName
        }.mapValues { (_, drivers) ->
            drivers.flatMap { driver ->
                streetNames.map { streetName ->
                    Pair(streetName, myUseCase.invoke(streetName, driver))
                }
            }.maxByOrNull { it.second }?: Pair("", 0F)
        }
        println("maxValuesByDriverName: $maxValuesByDriverName")


        /*
        7.5
        14
        14
        7.5*1.5 = 11.25
         */
    }
}