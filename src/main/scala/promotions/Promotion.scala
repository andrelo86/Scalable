package promotions

abstract class Promotion extends Critero {
  protected var CONFIG_FILE = "config"
  protected var promotionType: String = null
  protected var message: String = null

  def getDiscount: Double

  def getMessage: String
}