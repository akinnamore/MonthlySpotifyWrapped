package model

case class TrackLink(
                    external_urls: Map[String, String],
                    href: Option[String],
                    id: String,
                    `type`: String,
                    uri: String
                    )
