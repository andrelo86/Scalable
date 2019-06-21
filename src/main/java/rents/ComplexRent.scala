package rents

import entities.Bike
import exceptions.NotExistingPromotionException
import org.apache.log4j.Logger
import promotions.Promotion
import promotions.PromotionFactory

import scala.collection.mutable.ArrayBuffer

/**
  * Class to represent a complex Rent, we can set multiples singles rents and apply promotions.
  */
object ComplexRent {
  val TOTAL = "Total: "
}

class ComplexRent private[rents](var rentableList: ArrayBuffer[Rent]) extends Rent {
  var logger: Logger = Logger.getLogger(classOf[ComplexRent])
  var promotion: Promotion = setPromotion()

  def setPromotion(): Promotion = { // Contemplate not existing promos.
    var promo = PromotionFactory.createPromo("FAMILY_PROMO")
    if (promo.isPresent) promo.get()
    else throw new NotExistingPromotionException
  }

  def rent(bikes: ArrayBuffer[Bike]): Double = {
    var total = 0.0
    if (bikes.nonEmpty) {
      for (singleRent <- rentableList) {
        total += singleRent.rent(bikes)
      }
    }
    getTotal(total)
  }
  // null used to define that all bikes was rented.
  def getTotal(total: Double) = if (promotion.comply(rentableList)) {
    logger.info(promotion.getMessage + " " + ComplexRent.TOTAL + total * promotion.getDiscount)
    total * promotion.getDiscount
  }
  else {
    logger.info(ComplexRent.TOTAL + total)
    total
  }
}