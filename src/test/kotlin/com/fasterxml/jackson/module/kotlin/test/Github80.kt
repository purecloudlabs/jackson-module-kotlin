package com.fasterxml.jackson.module.kotlin.test

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.Test
import kotlin.test.assertEquals

class TestGithub80 {

    @Test
    fun testIsBool() {
        val mapper = jacksonObjectMapper()

        val example = IsBoolExample(true)
        val json = mapper.writeValueAsString(example)
        assertEquals("""{"isTrueOrFalse":true}""", json)

        val deserialized = mapper.readValue(json, IsBoolExample::class.java)
        assertEquals(example.isTrueOrFalse, deserialized.isTrueOrFalse)
    }

    @Test
    fun testNullableIsBool() {
        val mapper = jacksonObjectMapper()

        val example = NullableIsBoolExample(true)
        val json = mapper.writeValueAsString(example)
        assertEquals("""{"isTrueOrFalse":true}""", json)

        val deserialized = mapper.readValue(json, NullableIsBoolExample::class.java)
        assertEquals(example.isTrueOrFalse, deserialized.isTrueOrFalse)
    }

    @Test
    fun testGetProperty() {
        val mapper = jacksonObjectMapper()

        val example = GetExample(1)
        val json = mapper.writeValueAsString(example)
        assertEquals("""{"getProp":1}""", json)

        val deserialized = mapper.readValue(json, GetExample::class.java)
        assertEquals(example.getProp, deserialized.getProp)
    }

    data class IsBoolExample(val isTrueOrFalse: Boolean)

    data class NullableIsBoolExample(val isTrueOrFalse: Boolean?)

    data class GetExample(val getProp: Int)
}