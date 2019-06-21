package promotions

import java.util.Optional

object PromotionFactory {
  def createPromo(promoType: String): Optional[Promotion] = { // Agregue que devuelva un optional aca tambien, por si no encuentra la key.
    if (promoType == "FAMILY_PROMO") Optional.of(new FamilyPromo)
    else Optional.empty
  }
}

class PromotionFactory private() {
}