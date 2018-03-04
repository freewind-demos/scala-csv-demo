package example
import java.io.File

import com.github.tototoshi.csv.CSVReader

object Hello extends App {

  val reader = CSVReader.open(new File("./demo/resources/simple.csv"))

  val all = reader.all()

  all.foreach(println)

}
