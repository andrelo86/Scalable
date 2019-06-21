package promotions

import rents.Rent

import scala.collection.mutable.ArrayBuffer

trait Critero {

  def comply(rent: ArrayBuffer[Rent]): Boolean

}
