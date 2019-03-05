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

    data class IsBoolExample(val isTrueOrFalse: Boolean)

    data class NullableIsBoolExample(val isTrueOrFalse: Boolean?)
}