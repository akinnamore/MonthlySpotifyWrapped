package model

case class Album(
                  album_type: Option[String],
                  artists: List[ArtistSimple],
                  available_markets: List[String],
                  copyrights: List[Copyright],
                  external_ids: Map[String, String],
                  external_urls: Map[String, String],
                  genres: List[String],
                  href: Option[String],
                  id: Option[String],
                  images: List[Image],
                  name: Option[String],
                  popularity: Int,
                  release_date: String,
                  release_date_precision: String,
                  tracks: Page[TrackSimple],
                  `type`: String,
                  uri: String
                )
