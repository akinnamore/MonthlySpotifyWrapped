package model

case class Page[T](
                    href: Option[String],
                    items: List[T],
                    limit: Option[Int],
                    next: Option[String],
                    offset: Option[Int],
                    previous: Option[String],
                    total: Option[Int]
                    )
