package utils

import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream
import java.util.Properties
import org.apache.log4j.Logger

object Utils {
  private val logger = Logger.getLogger(classOf[Utils])
  val RESOURCES_PATH: String = "src" + File.separator + "main" + File.separator + "resources" + File.separator

  def getValueFromPropertiesFile(file: String, key: String): String = try {
    val input = new FileInputStream(file)
    try {
      val prop = new Properties
      prop.load(input)
      returnKeyValue(key, prop)
    } catch {
      case ex: IOException =>
        logger.info("Cannot read from file: " + ex)
        throw new IOException
    } finally if (input != null) input.close()
  }

  private def returnKeyValue(key: String, prop: Properties) = try prop.getProperty(key)
  catch {
    case np: NullPointerException =>
      logger.info("Property not found")
      throw new NullPointerException
  }
}

class Utils private() {
}