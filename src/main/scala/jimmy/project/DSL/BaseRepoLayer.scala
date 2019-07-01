package jimmy.project.DSL

import java.util.UUID

import jimmy.project.Customer

trait BaseRepoLayer[F[_]] {

  def getInfo(uuid: UUID): F[Either[String, Customer]]

  def addNewCustomer(customer: Customer): F[Either[String, Customer]]

}

object BaseRepoLayer {
  def apply[F[_]](C: BaseRepoLayer[F]): BaseRepoLayer[F] = C
}
