package jimmy.project

import java.util.UUID

import cats.Monad
import jimmy.project.DSL.BaseRepoLayer

import scala.collection.mutable.ListBuffer


object ServiceOps {

  implicit val repoLayer = new BaseRepoLayer[Seq] {

    var data = new ListBuffer[Customer]()

    override def getInfo(uuid: UUID): Seq[Either[String, Customer]] =
      data.find(d => d.id == uuid) match {
        case Some(customer) => Seq(Right(customer))
        case None => Seq(Left(s"Couldn't find the customer with uuid: $uuid"))
      }

    override def addNewCustomer(customer: Customer): Seq[Either[String, Customer]] = {
      data += customer
      Seq(Right(customer))
    }
  }

  implicit class BaseRepoLayerSyntax[F[_]: Monad, A](data: F[A]) {
    def map[B](f: A => B): F[B] = Monad[F].map(data)(f)
  }

}