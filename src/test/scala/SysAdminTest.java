/*
package test.java;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SysAdminTest {

  private static final Logger LOGGER = Logger.getLogger(SysAdminTest.class.getName());

  private static final int BIKES_QTY = 5;

  private SysAdmin sysAdminTest = SysAdmin.getInstance(BIKES_QTY);


  @BeforeMethod
  public void setUp() {
    LOGGER.info("Loading test data..");
    SysAdmin.reset();
    sysAdminTest = SysAdmin.getInstance(5);
    LOGGER.info("Test data loaded successfully..");
  }

  @Test
  public void getCorrectAvailableBikesTest() {
    Rent singleRentByHour = RentFactory.createSingleRent(1, ChronoUnit.HOURS);
    Rent singleRentByWeek = RentFactory.createSingleRent(1, ChronoUnit.WEEKS);

    Double singleHourRentHour = singleRentByHour.rent(sysAdminTest.getAvailableBikes());
    Double singleWeekRentHour = singleRentByWeek.rent(sysAdminTest.getAvailableBikes());

    int expectedAvailableBikes = 3;
    int sysAdminTestAvailableBikes = sysAdminTest.getAvailableBikes().size();

    Assert.assertEquals(expectedAvailableBikes, sysAdminTestAvailableBikes,
        "Something went wrong when set as Unavailable a bike");
  }

  @Test
  public void correctReturnBikeDateByHourTest() {
    Rent singleRentByHour = RentFactory.createSingleRent(1, ChronoUnit.HOURS);

    Double rentByHour = singleRentByHour.rent(sysAdminTest.getAvailableBikes());

    LocalDateTime nowLocalDateTime = LocalDateTime.now();
    LocalDateTime bikeReturnDate = sysAdminTest.getBikes().get(0).getReturnDate();

    LocalDateTime expectedReturnDate = nowLocalDateTime.plus(1, ChronoUnit.HOURS);
    Assert.assertEquals(expectedReturnDate.getHour(), bikeReturnDate.getHour(),
        "Something went wrong calculating the date of return");
  }

  @Test
  public void correctReturnBikeDateByDayTest() {
    Rent singleRentByDay = RentFactory.createSingleRent(1, ChronoUnit.DAYS);

    Double rentByDay = singleRentByDay.rent(sysAdminTest.getAvailableBikes());

    LocalDateTime nowLocalDateTime = LocalDateTime.now();
    LocalDateTime bikeReturnDate = sysAdminTest.getBikes().get(0).getReturnDate();

    LocalDateTime expectedReturnDate = nowLocalDateTime.plus(1, ChronoUnit.DAYS);
    Assert.assertEquals(expectedReturnDate.getDayOfYear(), bikeReturnDate.getDayOfYear(),
        "Something went wrong calculating the date of return");
  }

  @Test
  public void correctReturnBikeDateByWeekTest() {
    Rent singleRentByWeek = RentFactory.createSingleRent(1, ChronoUnit.WEEKS);

    Double rentByWeek = singleRentByWeek.rent(sysAdminTest.getAvailableBikes());

    LocalDateTime nowLocalDateTime = LocalDateTime.now();
    LocalDateTime bikeReturnDate = sysAdminTest.getBikes().get(0).getReturnDate();

    LocalDateTime expectedReturnDate = nowLocalDateTime.plus(1, ChronoUnit.WEEKS);
    Assert.assertEquals(expectedReturnDate.getDayOfWeek(), bikeReturnDate.getDayOfWeek(),
        "Something went wrong calculating the date of return");
  }

  @Test
  public void correctPublishReturnDateTest() {
    Rent singleRentByDay = RentFactory.createSingleRent(1, ChronoUnit.DAYS);
    Rent singleRentByWeek = RentFactory.createSingleRent(1, ChronoUnit.WEEKS);

    Double rentByDay = singleRentByDay.rent(sysAdminTest.getAvailableBikes());
    Double rentByWeek = singleRentByWeek.rent(sysAdminTest.getAvailableBikes());

    sysAdminTest.publishReturnDate();
  }

}
*/
