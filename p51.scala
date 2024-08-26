import scala.io.StdIn.readLine

object p51 {

  // Function to continuously prompt the user to enter product names and collect them in a List
  def getProductList(): List[String] = {
    var productList: List[String] = List()
    var input: String = ""

    println("Enter product names (type 'done' to finish):")

    while (input != "done") {
      input = readLine()
      if (input != "done" && input.nonEmpty) {
        productList = productList :+ input
      }
    }

    productList
  }

  // Function to print each product name with its position in the list
  def printProductList(products: List[String]): Unit = {
    products.zipWithIndex.foreach { case (product, index) =>
      println(s"${index + 1}. $product")
    }
  }

  // Function to return the total number of products in the list
  def getTotalProducts(products: List[String]): Int = {
    products.length
  }

  def main(args: Array[String]): Unit = {
    // Capture the product list
    val products = getProductList()

    // Display the product list with positions
    println("\nProduct List:")
    printProductList(products)

    // Display the total number of products
    val totalProducts = getTotalProducts(products)
    println(s"\nTotal number of products: $totalProducts")
  }
}
