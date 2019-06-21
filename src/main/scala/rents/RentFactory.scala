package rents

import java.time.temporal.ChronoUnit

import scala.collection.mutable.ArrayBuffer

object RentFactory {
  def createSingleRent(time: Long, timeType: ChronoUnit) = new SingleRent(time, timeType)

  def createComplexRental(singleRents: ArrayBuffer[Rent]) = {
    new ComplexRent(singleRents)
  }
}

class RentFactory private() {
}