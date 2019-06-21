package app

import java.time.ZoneId
import java.util.Date

import entities.Bike
import org.apache.log4j.Logger
import utils.Message

import scala.collection.mutable.ArrayBuffer

/**
  * Singleton class used as bicycle store.
  */
object SysAdmin {
  private val logger = Logger.getLogger(classOf[SysAdmin])

  def getInstance(totalBikes: Int): SysAdmin = {
     new SysAdmin(totalBikes)
  }

}

class SysAdmin private(val totalBikes: Int) {
  var bikes: ArrayBuffer[Bike] = loadStock(totalBikes)

  def loadStock(totalBikes: Int): ArrayBuffer[Bike] = {
    var bikes = ArrayBuffer[Bike]()
    bikes += new Bike
    bikes += new Bike
    bikes += new Bike
    bikes += new Bike
    bikes += new Bike
    bikes
  }

  def getAvailableBikes: ArrayBuffer[Bike] = {
    var availableBikes = ArrayBuffer[Bike]()
    for (bike <- bikes) {
      if (bike.getAvailability) {
        availableBikes += bike
      }
    }
    availableBikes
  }

  def publishReturnDate(): Unit = {
    val rentedBikes = getRentedBikes
    if (!rentedBikes.isEmpty) {
      for (bike <- rentedBikes) {
        val asDate = Date.from(bike.getReturnDate.atZone(ZoneId.systemDefault).toInstant)
        SysAdmin.logger.info(String.format("%s%s", Message.RETURN_INFO_MSG, asDate.toString))
      }
    }
  }

  def getRentedBikes = bikes.filter((bike: Bike) => !bike.getAvailability)

  def getBikes: ArrayBuffer[Bike] = bikes
}