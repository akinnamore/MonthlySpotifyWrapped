package endpoints

import model._
import org.json4s._
import org.json4s.jackson.JsonMethods._
import scalaj.http.{HttpRequest, HttpOptions, Http}


object PlaylistEndpoint extends SpotifyEndpoint {
    implicit val formats: Formats = DefaultFormats

    val makePlaylistEndpoint = baseAPIUrl + "/v1/users/" + userID + "/playlists"
    val getPlaylistEndpoint = baseAPIUrl + "/v1/me/playlists?limit=1"

    def getPlaylist(token: String): String = {
        val getPlaylist = Http(getPlaylistEndpoint).header("Authorization", "Bearer " + token).asString
        val parsed = parse(getPlaylist.body)
        val playlist = parsed.camelizeKeys.extract[Page[Playlist]]
        playlist.items.head.id
    }

    def makePlaylist(token: String, playlistName: String, description: String) = {
        Http(makePlaylistEndpoint).postData(raw"""{"name":"$playlistName","description":"$description"}""")
          .header("Content-Type", "application/json")
          .header("Authorization", "Bearer " + token)
          .option(HttpOptions.readTimeout(10000)).asString
    }

    def addTracks(token: String, playlistID: String, trackIDs: List[String]) = {
        val addTracksEndpoint = baseAPIUrl + "/v1/playlists/" + playlistID + "/tracks"
        Http(addTracksEndpoint).postData(generateRawString(generateListOfUris(trackIDs)))
          .header("Content-Type", "application/json")
          .header("Authorization", "Bearer " + token)
          .option(HttpOptions.readTimeout(10000)).asString
    }

    def generateListOfUris(trackIDs: List[String]) = {
        trackIDs.map(id => raw"""spotify:track:$id""")
    }

    // find a prettier way to do this..
    def generateRawString(uris: List[String]) = {
            raw"""{"uris": ["${uris(0)}","${uris(1)}","${uris(2)}","${uris(3)}","${uris(4)}","${uris(5)}","${uris(6)}",
                           |"${uris(7)}","${uris(8)}","${uris(9)}","${uris(10)}","${uris(11)}","${uris(12)}","${uris(13)}","${uris(14)}",
                           |"${uris(15)}","${uris(16)}","${uris(17)}","${uris(18)}","${uris(19)}","${uris(20)}","${uris(21)}","${uris(22)}",
                           |"${uris(23)}","${uris(24)}","${uris(25)}","${uris(26)}","${uris(27)}","${uris(28)}","${uris(29)}"]}""".stripMargin
    }

}

