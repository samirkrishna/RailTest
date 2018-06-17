package com.has.sam.cej.railtest

data class PnrStatusPOJO(val passengers: List<PassengersItem>?,
                         val responseCode: Int = 0,
                         val reservationUpto: ReservationUpto,
                         val fromStation: FromStation,
                         val journeyClass: JourneyClass,
                         val boardingPoint: BoardingPoint,
                         val chartPrepared: Boolean = false,
                         val pnr: String = "",
                         val debit: Int = 0,
                         val doj: String = "",
                         val toStation: ToStation,
                         val totalPassengers: Int = 0,
                         val train: Train)