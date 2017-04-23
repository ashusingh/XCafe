import com.xcafe.{Cafe, InMemoryMenu, ServiceChargeCalculator}

object Main {


  val cafe = new Cafe(InMemoryMenu, ServiceChargeCalculator)
  def main(args: Array[String]): Unit = {


    println("Total amount payable for Cola, Coffee, “Cheese Sandwich => " + cafe.getBill("Cola", "Coffee", "Cheese Sandwich"))


  }

}
