/*
package test.java

import java.time.temporal.ChronoUnit
import java.util
import java.util.stream.IntStream

import entities.Bike
import org.apache.log4j.Logger
import org.testng.Assert
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test
import rents.RentFactory

object RentalsTest {
  private val BIKES_QTY = 10
}

class RentalsTest {
  private var bikes = null
  var LOGGER = Logger.getLogger(classOf[RentalsTest].getName)

  @BeforeSuite def setUp(): Unit = {
    RentalsTest.LOGGER.info("Loading test data..")
    this.bikes = new util.ArrayList[Nothing]
    IntStream.range(0, RentalsTest.BIKES_QTY).forEach((bike: Int) => bikes.add(new Bike))
    RentalsTest.LOGGER.info("Test data loaded successfully..")
  }

  @Test def rentComplexCalculatorTest(): Unit = {
    val rentByDays = RentFactory.createSingleRent(2, ChronoUnit.DAYS)
    val rentByWeek = RentFactory.createSingleRent(3, ChronoUnit.WEEKS)
    val rents = new Array[Nothing]
    rents.add(rentByDays)
    rents.add(rentByWeek)
    val complexRent = RentFactory.createComplexRental(rents)
    val expectedTotalRent = 220.0
    val calculatedTotalRent = complexRent.rent(bikes)
    Assert.assertEquals(expectedTotalRent, calculatedTotalRent, "Something went wrong by calculate a Complex Rent.")
  }

  @Test def complexRentWithDiscountCalculatorTest(): Unit = {
    val rentByHour = RentFactory.createSingleRent(4, ChronoUnit.HOURS)
    val rentByDays = RentFactory.createSingleRent(2, ChronoUnit.DAYS)
    val rentByWeek = RentFactory.createSingleRent(3, ChronoUnit.WEEKS)
    val rents = new util.ArrayList[Nothing]
    rents.add(rentByHour)
    rents.add(rentByDays)
    rents.add(rentByWeek)
    val complexRent = RentFactory.createComplexRental(rents)
    val promotionDiscount = 0.3
    val expectedTotalRent = 240.0 * promotionDiscount
    val calculatedTotalRent = complexRent.rent(bikes)
    Assert.assertEquals(expectedTotalRent, calculatedTotalRent, "Something went wrong by calculate a Complex Rent with a Family Promotion Discount.")
  }

  @Test(expectedExceptions = Array(classOf[Nothing])) def checkNullCollectionOfBikesTest(): Unit = {
    val singleRent = RentFactory.createSingleRent(5, ChronoUnit.HOURS)
    val calculatedTotalRent = singleRent.rent(null)
  }
}*/
