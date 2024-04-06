package com.example.apollohitlgraphql.model



data class PlanetDetail(
    val code:String,
    val name: String?,
    val gravity :String,
   val population:Float,
    val rotationPeriod:Int,
    val edited:String,
    val created:String
    )




