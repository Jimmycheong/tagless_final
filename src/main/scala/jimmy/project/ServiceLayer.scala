package jimmy.project

import java.util.UUID

import cats._
import jimmy.project.DSL.BaseRepoLayer

import scala.language.higherKinds

class ServiceLayer[F[_]: Monad](implicit repoLayer: BaseRepoLayer[F]) extends BaseOps[F] {

  def getInfo(userId: UUID): F[Either[String, Customer]] = repoLayer.getInfo(userId)

  def addNewUser(customer: Customer): F[Either[String, Customer]] = repoLayer.addNewCustomer(customer)

  def removeCustomer(UUID: UUID): F[Either[String, Customer]] =

}
