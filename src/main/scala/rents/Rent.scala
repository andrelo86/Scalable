package rents

import entities.Bike
import java.util.Objects

import org.apache.log4j.Logger
import utils.Utils

import scala.collection.mutable.ArrayBuffer

object Rent {
  private val RATES_FILE = Utils.RESOURCES_PATH + "config"
  protected var logger: Logger = null
}

abstract class Rent() {
  protected var byHour: Double = Objects.requireNonNull(Utils.getValueFromPropertiesFile(Rent.RATES_FILE, "RATE_BY_HOUR")).toDouble
  protected var byDay: Double = Objects.requireNonNull(Utils.getValueFromPropertiesFile(Rent.RATES_FILE, "RATE_BY_DAY")).toDouble
  protected var byWeek: Double = Objects.requireNonNull(Utils.getValueFromPropertiesFile(Rent.RATES_FILE, "RATE_BY_WEEK")).toDouble

  def rent(bikes: ArrayBuffer[Bike]): Double
}