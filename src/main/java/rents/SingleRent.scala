package rents

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

import entities.Bike
import org.apache.log4j.Logger

import scala.collection.mutable.ArrayBuffer

/**
  * Class to represent a single rent (1 bike) by hour day or week.
  */
class SingleRent(var time: Long, var timeType: ChronoUnit) extends Rent {
  var logger = Logger.getLogger(classOf[SingleRent])
  var rate: Double = setRate(timeType)

  /**
    * If this grows we should look for a design to avoid switch.
    */
  private def setRate(timeType: ChronoUnit):Double = timeType match {
    case ChronoUnit.HOURS  => this.byHour
    case ChronoUnit.DAYS => this.byDay
    case ChronoUnit.WEEKS => this.byWeek
  }

  def rent(bikes: ArrayBuffer[Bike]): Double = {
    var total = 0.0
    var localDateTime = LocalDateTime.now
    localDateTime = localDateTime.plus(time, timeType)
    val bike = getFirstAvailableBike(bikes)
    if (bike.isDefined) {
      bike.get.setReturnDate(localDateTime)
      bike.get.setAvailability(false)
      total = time * rate
    }
    total
  }


  private def getFirstAvailableBike(bikes: ArrayBuffer[Bike]) = { // Aca le agregue que devuelva un optional por si no hay bicis disponibles
    bikes.find((bike: Bike) => bike.getAvailability)
  }

}