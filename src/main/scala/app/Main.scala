package app

import java.time.temporal.ChronoUnit
import java.util.Objects

import org.apache.log4j.Logger
import rents.{Rent, RentFactory}
import utils.Utils

import scala.collection.mutable.ArrayBuffer

object Main {

  val CONFIG_FILE = Utils.RESOURCES_PATH + "config"
  val sysAdmin = SysAdmin.getInstance(Objects.requireNonNull(Utils.getValueFromPropertiesFile(CONFIG_FILE, "STOCK")).toInt)
  val logger = Logger.getLogger("Main")

  def main(args: Array[String]): Unit = {

    // Create Rents
    val rent4Hours = RentFactory.createSingleRent(4, ChronoUnit.HOURS)
    val rentAWeek = RentFactory.createSingleRent(1, ChronoUnit.WEEKS)
    val rent2Hour = RentFactory.createSingleRent(2, ChronoUnit.HOURS)
    val rents = ArrayBuffer[Rent]()
    rents += rent4Hours
    rents += rentAWeek
    rents += rent2Hour
    val complexRent = RentFactory.createComplexRental(rents)

    //Execute rents
    val rentTotal = rent4Hours.rent(sysAdmin.getAvailableBikes)
    if (Objects.nonNull(rentTotal)) {
      logger.info("You rent a bike for a total of: " + rentTotal)
      sysAdmin.publishReturnDate()
    }
    else logger.info("All bikes are rented.")

    val rentComplexTotal = complexRent.rent(sysAdmin.getAvailableBikes)
    if (Objects.nonNull(rentComplexTotal)) {
      logger.info("You rent a bike for a total of: " + rentTotal)
      sysAdmin.publishReturnDate()
    }
    else logger.info("All bikes are rented.")
  }
}