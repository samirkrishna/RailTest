package com.has.sam.cej.railtest

data class Train(val number: String = "",
                 val classes: List<ClassesItem>?,
                 val name: String = "",
                 val days: List<DaysItem>?)