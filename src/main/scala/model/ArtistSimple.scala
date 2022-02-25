package model

case class ArtistSimple(
                         external_urls: Map[String, String],
                         href: Option[String],
                         id: String,
                         name: String,
                         `type`: String,
                         uri: String
                       )
