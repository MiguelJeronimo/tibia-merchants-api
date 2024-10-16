package com.miguel.tibia_merchants_api.utils

import com.miguel.tibia_merchants_api.domain.models.Sections
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

class Utils {
    fun listNPC(): List<Weapons> {
        val list = listOf(
            Weapons(
                "Rashid",
                "https://static.wikia.nocookie.net/tibia/images/f/f5/Rashid.gif/revision/latest?cb=20221218120126&path-prefix=en&format=original",
            ),
            Weapons(
                "Yasir",
                "https://static.wikia.nocookie.net/tibia/images/4/4a/Yasir.gif/revision/latest?cb=20221211091332&path-prefix=en&format=original",
            ),
            Weapons(
                "Haroun",
                "https://static.wikia.nocookie.net/tibia/images/c/ce/Haroun.gif/revision/latest?cb=20230824232628&path-prefix=en&format=original",
            ),
            Weapons(
                "Nah'Bob",
                "https://static.wikia.nocookie.net/tibia/images/d/dd/Nah%27Bob.gif/revision/latest?cb=20230824232703&path-prefix=en&format=original",
            ),
            Weapons(
                "Asnarus",
                "https://static.wikia.nocookie.net/tibia/images/b/b7/Asnarus.gif/revision/latest?cb=20230822091743&path-prefix=en&format=original",
            ),
            Weapons(
                "Alesar",
                "https://static.wikia.nocookie.net/tibia/images/a/a4/Alesar.gif/revision/latest?cb=20230725201630&path-prefix=en&format=original",
            ),
            Weapons(
                "Yaman",
                "https://static.wikia.nocookie.net/tibia/images/7/7f/Yaman.gif/revision/latest?cb=20230822091739&path-prefix=en&format=original",
            ),
            Weapons(
                "Esrik",
                "https://static.wikia.nocookie.net/tibia/images/8/83/Esrik.gif/revision/latest?cb=20230817115544&path-prefix=en&format=original",
            ),
            Weapons(
                "Alexander",
                "https://static.wikia.nocookie.net/tibia/images/f/fe/Alexander.gif/revision/latest?cb=20221217020449&path-prefix=en&format=original",
            ),
            Weapons(
                "Tamoril",
                "https://static.wikia.nocookie.net/tibia/images/a/a1/Tamoril.gif/revision/latest?cb=20230824232445&path-prefix=en&format=original",
            ),
            Weapons(
                "Grizzly Adams",
                "https://static.wikia.nocookie.net/tibia/images/b/b5/Grizzly_Adams.gif/revision/latest?cb=20230831011705&path-prefix=en&format=original",
            )
        )
        return list
    }

    fun addDataInClass(data: ArrayList<Sections>?, dataClass: Any?): Any? {
        return if (data != null && dataClass != null) {
            var position = 0
            val constructor = dataClass::class.primaryConstructor!!.parameters
            if (constructor != null) {
                constructor.forEach { propierties ->
                    if (position < data.size) {
                        val params = dataClass::class.memberProperties.find {
                            it.name == data[position].key
                        }
                        if (params != null && params is KMutableProperty<*>) {
                            params.setter.call(dataClass, data[position].value)
                            position += 1
                        }
                    }
                }
            }
            dataClass
        } else {
            null
        }
    }
}

data class Weapons(
    val name: String,
    val img: String
)