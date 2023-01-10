package com.stewonello.fertilizer.components

import com.stewonello.fertilizer.dialect.FertilizerComponent

// TODO: Or just use the registering class itself !! ?? ... Maybe use name scheme like 'TestComponent'

// Must inherit FertilizerComponent() to be auto registered
data class Test(
    var title: String,
    val content: String,
    val data: Map<String, String>? = null
//    val classForType: String,
) : FertilizerComponent() {

    /* TODO: ... could we add useful methods and component logic here?? OMG !!
        So we would use an actual instance if we wanted to use logic on params? or just static methods ... or both?
        How though .... how would that look like? Access in template?? In Processor?
     */

    init {
        title += " 👻 ~~ boohoo greetings from the constructor ~~"

//        classForType = switch { that stuff }
    }

    companion object {
        fun moreUsefulLogicQuestionMark() {}
    }
    fun someUsefulLogicQuestionMark() {}
}

// TODO: Require a *Props() class? Or ... better as above 👆
data class TestProps(
    val title: String,
    val content: String
)
