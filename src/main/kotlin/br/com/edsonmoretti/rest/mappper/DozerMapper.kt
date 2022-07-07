package br.com.edsonmoretti.rest.mappper

import com.github.dozermapper.core.DozerBeanMapperBuilder
import com.github.dozermapper.core.Mapper

object DozerMapper {
    private val mapper: Mapper = DozerBeanMapperBuilder.buildDefault()

    fun <O, D> parseObject(origin: O, destination: Class<D>?): D {
        return mapper.map(origin, destination)
    }

    fun <O, D> parseObjects(origin: List<O>, destination: Class<D>?): ArrayList<D> {
        val destinationObject : ArrayList<D> = ArrayList()
        for (o in origin) {
            destinationObject.add(parseObject(o, destination))
        }
        return destinationObject
    }

}