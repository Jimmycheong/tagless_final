package jimmy.project

import java.util.UUID

object Main extends App {

  println("Tagless project")
  import ServiceOps._

  val myService = new ServiceLayer[Seq]


  val someCustomer = Customer(UUID.randomUUID(), "john", 20)

  myService.addNewUser(someCustomer)

  myService.getInfo(someCustomer.id).head match {
    case Right(value) => println(s"Got customer with name: ${value.name}")
    case Left(error) => println(s"Error: $error")
  }

}
