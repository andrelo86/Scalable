/*
package test.java

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

import org.apache.log4j.Logger
import org.testng.Assert
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import rents.RentFactory

object SysAdminTest {
  private val LOGGER = Logger.getLogger(classOf[SysAdminTest].getName)
  private val BIKES_QTY = 5
}

class SysAdminTest {
  private var sysAdminTest = SysAdmin.getInstance(SysAdminTest.BIKES_QTY)

  @BeforeMethod def setUp(): Unit = {
    SysAdminTest.LOGGER.info("Loading test data..")
    SysAdmin.reset
    sysAdminTest = SysAdmin.getInstance(5)
    SysAdminTest.LOGGER.info("Test data loaded successfully..")
  }

  @Test def getCorrectAvailableBikesTest(): Unit = {
    val singleRentByHour = RentFactory.createSingleRent(1, ChronoUnit.HOURS)
    val singleRentByWeek = RentFactory.createSingleRent(1, ChronoUnit.WEEKS)
    val singleHourRentHour = singleRentByHour.rent(sysAdminTest.getAvailableBikes)
    val singleWeekRentHour = singleRentByWeek.rent(sysAdminTest.getAvailableBikes)
    val expectedAvailableBikes = 3
    val sysAdminTestAvailableBikes = sysAdminTest.getAvailableBikes.size
    Assert.assertEquals(expectedAvailableBikes, sysAdminTestAvailableBikes, "Something went wrong when set as Unavailable a bike")
  }

  @Test def correctReturnBikeDateByHourTest(): Unit = {
    val singleRentByHour = RentFactory.createSingleRent(1, ChronoUnit.HOURS)
    val rentByHour = singleRentByHour.rent(sysAdminTest.getAvailableBikes)
    val nowLocalDateTime = LocalDateTime.now
    val bikeReturnDate = sysAdminTest.getBikes.get(0).getReturnDate
    val expectedReturnDate = nowLocalDateTime.plus(1, ChronoUnit.HOURS)
    Assert.assertEquals(expectedReturnDate.getHour, bikeReturnDate.getHour, "Something went wrong calculating the date of return")
  }

  @Test def correctReturnBikeDateByDayTest(): Unit = {
    val singleRentByDay = RentFactory.createSingleRent(1, ChronoUnit.DAYS)
    val rentByDay = singleRentByDay.rent(sysAdminTest.getAvailableBikes)
    val nowLocalDateTime = LocalDateTime.now
    val bikeReturnDate = sysAdminTest.getBikes.get(0).getReturnDate
    val expectedReturnDate = nowLocalDateTime.plus(1, ChronoUnit.DAYS)
    Assert.assertEquals(expectedReturnDate.getDayOfYear, bikeReturnDate.getDayOfYear, "Something went wrong calculating the date of return")
  }

  @Test def correctReturnBikeDateByWeekTest(): Unit = {
    val singleRentByWeek = RentFactory.createSingleRent(1, ChronoUnit.WEEKS)
    val rentByWeek = singleRentByWeek.rent(sysAdminTest.getAvailableBikes)
    val nowLocalDateTime = LocalDateTime.now
    val bikeReturnDate = sysAdminTest.getBikes.get(0).getReturnDate
    val expectedReturnDate = nowLocalDateTime.plus(1, ChronoUnit.WEEKS)
    Assert.assertEquals(expectedReturnDate.getDayOfWeek, bikeReturnDate.getDayOfWeek, "Something went wrong calculating the date of return")
  }

  @Test def correctPublishReturnDateTest(): Unit = {
    val singleRentByDay = RentFactory.createSingleRent(1, ChronoUnit.DAYS)
    val singleRentByWeek = RentFactory.createSingleRent(1, ChronoUnit.WEEKS)
    val rentByDay = singleRentByDay.rent(sysAdminTest.getAvailableBikes)
    val rentByWeek = singleRentByWeek.rent(sysAdminTest.getAvailableBikes)
    sysAdminTest.publishReturnDate
  }
}*/
