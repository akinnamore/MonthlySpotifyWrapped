package model

case class Artists(
                   external_urls: Map[String, String],
                   followers: Followers,
                   genres: List[String],
                   href: Option[String],
                   id: String,
                   images: List[Image],
                   name: String,
                   popularity: Int,
                   `type`: String,
                   uri: String
                 )