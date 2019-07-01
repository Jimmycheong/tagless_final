package jimmy.example


object Main2 extends App {

  type DataId = Int
  type DataValue = String

  case class Data(id: DataId, value: DataValue)

  trait RepoDSL[F[_]] {
    def getInfo(dataId: DataId): F[DataValue]

    def putInfo(dataId: DataId, dataValue: DataValue): F[DataId]
  }

  object RepoDSL {

    def apply[F[_]](implicit C: RepoDSL[F]): RepoDSL[F] = C

    implicit val repoIntepreter = new RepoDSL[Option] {
      override def getInfo(dataId: DataId): Option[DataValue] = Some("a data value.")
      override def putInfo(dataId: DataId, dataValue: DataValue): Option[DataId] = Some(dataId)
    }
  }

  implicit class RepoDSLSyntax[F[_]: RepoDSL](data: Data) {
    def getInfo: F[DataValue] = RepoDSL[F].getInfo(data.id)
  }

  val dataPiece = Data(1, "I like alsatians")

  println(dataPiece.getInfo)

}
