package endpoints

import model._
import org.json4s._
import org.json4s.jackson.JsonMethods._
import scalaj.http.{HttpRequest, HttpOptions, Http}


object TopItems extends SpotifyEndpoint {

  implicit val formats: Formats = DefaultFormats

  val limit = "30"
  val timeRange = "short_term"

  val topArtisits = baseAPIUrl + "/v1/me/top/artists?limit=" + limit + "&time_range=" + timeRange
  val topTracks = baseAPIUrl + "/v1/me/top/tracks?limit=" + limit + "&time_range=" + timeRange

  def getUserTopTracks(token: String) = {
    val getTracks = Http(topTracks).header("Authorization", "Bearer " + token).asString
    val parsed = parse(getTracks.body)
    val tracks = parsed.extract[Page[TrackSimple]]
    tracks.items
  }

  def getUserTopArtists(token: String) = {
    val getArtists = Http(topArtisits).header("Authorization", "Bearer " + token).asString
    val parsed = parse(getArtists.body)
    val artists = parsed.camelizeKeys.extract[Page[Artists]]
    artists.items
  }

}
