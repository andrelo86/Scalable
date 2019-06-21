package entities

import java.time.LocalDateTime

class Bike() {

  var returnDate: LocalDateTime = _

  var availability = true

  def getReturnDate: LocalDateTime = returnDate

  def setReturnDate(returnDates: LocalDateTime): Unit = this.returnDate = returnDates

  def getAvailability: Boolean = availability

  def setAvailability(availability: Boolean): Unit = this.availability = availability
}