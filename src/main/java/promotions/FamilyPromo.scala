package promotions

import rents.Rent
import utils.{Message, Utils}

import scala.collection.mutable.ArrayBuffer

class FamilyPromo() extends Promotion with Critero {

  promotionType = "FAMILY_PROMOTION"
  message = Message.FAMILY_PROMOTION_MSG
  var minRents: Int = Utils.getValueFromPropertiesFile(Utils.RESOURCES_PATH + CONFIG_FILE, "MIN_RENTS").toInt
  var maxRents: Int = Utils.getValueFromPropertiesFile(Utils.RESOURCES_PATH + CONFIG_FILE, "MAX_RENTS").toInt
  var familyDiscount: Double = Utils.getValueFromPropertiesFile(Utils.RESOURCES_PATH + CONFIG_FILE, "FAMILY_PROMO").toDouble

  override def comply(rent: ArrayBuffer[Rent]): Boolean = rentsQuantity(rent) >= minRents && rentsQuantity(rent) <= maxRents

  override def getDiscount: Double = familyDiscount

  override def getMessage: String = message

  def rentsQuantity(rent: ArrayBuffer[Rent]): Int = rent.length

}
