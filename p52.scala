import scala.io.StdIn._

case class Book(title: String, author: String, isbn: String)

object p52 {

  // Initial set of books in the library
  var library: Set[Book] = Set(
    Book("1984", "George Orwell", "1234567890"),
    Book("To Kill a Mockingbird", "Harper Lee", "2345678901"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "3456789012")
  )

  // Function to add a new book to the library
  def addBook(): Unit = {
    println("Enter the book title:")
    val title = readLine()
    println("Enter the book author:")
    val author = readLine()
    println("Enter the book ISBN:")
    val isbn = readLine()

    if (isBookInLibrary(isbn)) {
      println("A book with this ISBN already exists in the library.")
    } else {
      library += Book(title, author, isbn)
      println(s"Book '$title' added to the library.")
    }
  }

  // Function to remove a book from the library by its ISBN
  def removeBook(): Unit = {
    println("Enter the ISBN of the book to remove:")
    val isbn = readLine()

    if (isBookInLibrary(isbn)) {
      library = library.filterNot(_.isbn == isbn)
      println(s"Book with ISBN $isbn removed from the library.")
    } else {
      println(s"No book found with ISBN $isbn.")
    }
  }
  
  // Function to check if a book is in the library by its ISBN
  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  // Function to display the current library collection
  def displayLibrary(): Unit = {
    if (library.nonEmpty) {
      println("Current Library Collection:")
      library.foreach(book => println(s"${book.title} by ${book.author} (ISBN: ${book.isbn})"))
    } else {
      println("The library is currently empty.")
    }
  }

  // Function to search for a book by its title and display details if found
  def searchByTitle(): Unit = {
    println("Enter the title of the book to search for:")
    val title = readLine()

    library.find(_.title.equalsIgnoreCase(title)) match {
      case Some(book) =>
        println(s"Found book: ${book.title} by ${book.author} (ISBN: ${book.isbn})")
      case None => println(s"No book found with the title '$title'.")
    }
  }

  // Function to display all books by a specific author
  def displayBooksByAuthor(): Unit = {
    println("Enter the author's name to list their books:")
    val author = readLine()

    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
      println(s"Books by $author:")
      booksByAuthor.foreach(book => println(s"${book.title} (ISBN: ${book.isbn})"))
    } else {
      println(s"No books found by $author.")
    }
  }

  // Function to display the menu and get user choice
  def displayMenu(): Unit = {
    println(
      """
        |Library Management System
        |-------------------------
        |1. Display Library Collection
        |2. Add a New Book
        |3. Remove a Book
        |4. Search for a Book by Title
        |5. Display All Books by Author
        |6. Exit
        |""".stripMargin)
  }

  // Main program loop
  def main(args: Array[String]): Unit = {
    var continue = true
    while (continue) {
      displayMenu()
      val choice = readLine("Enter your choice (1-6): ")

      choice match {
        case "1" => displayLibrary()
        case "2" => addBook()
        case "3" => removeBook()
        case "4" => searchByTitle()
        case "5" => displayBooksByAuthor()
        case "6" => continue = false
        case _   => println("Invalid choice, please try again.")
      }
    }
    println("Exiting Library Management System. Goodbye!")
  }
}
