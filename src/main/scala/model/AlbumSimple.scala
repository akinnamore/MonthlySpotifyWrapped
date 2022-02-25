package model

case class AlbumSimple(
                        album_type: String,
                        artists: Artists,
                        available_markets: List[String],
                        external_urls: Map[String, String],
                        href: Option[String],
                        id: String,
                        images: List[Image],
                        name: String,
                        `type`: String,
                        uri: String
                      )
