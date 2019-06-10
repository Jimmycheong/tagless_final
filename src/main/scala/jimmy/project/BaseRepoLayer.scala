package jimmy.project

import java.util.UUID

import jimmy.project.DSL.BaseRepoLayer



trait BaseOps[F] {
}


class ServiceOps {

  implicit val repoLayer = new BaseRepoLayer[Option] {

//    override def getInfo(): Option[Customer] = Some(Customer(1, "name", 18))
//    override def addNewCustomer(): Option[Customer] = None
//    override def removeCustomer(): Option[Customer] = None

    override def getInfo(uuid: UUID): Option[Either[String, Customer]] = {
      if (uuid == "234")  Some(Left("Invalid!!"))
      else                Some(Right(Customer(uuid, "Simon", 23)))
    }

    override def addNewCustomer(customer: Customer): Option[Either[String, Customer]] = ???

    override def removeCustomer(UUID: UUID): Option[Either[String, Customer]] = ???
  }
}