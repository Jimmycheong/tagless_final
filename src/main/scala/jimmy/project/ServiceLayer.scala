package jimmy.project

import java.util.UUID

import jimmy.project.DSL.BaseRepoLayer

class ServiceLayer[F[_]](implicit repoLayer: BaseRepoLayer[F]){

  def getInfo(userId: UUID): F[Either[String, Customer]] = repoLayer.getInfo(userId)

  def addNewUser(customer: Customer): F[Either[String, Customer]] = repoLayer.addNewCustomer(customer)

}
