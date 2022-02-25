import endpoints._
import java.io._
import java.time.LocalDate
import java.time.format.DateTimeFormatter


object Runnable {
  def main(args: Array[String]): Unit = {

    // do this more gracefully when adding front end with Spotify auth
    val token = "your token"

    // get current month and year
    val month = MonthMapper.getMonth(DateTimeFormatter.ofPattern("MM").format(LocalDate.now))
    val year = DateTimeFormatter.ofPattern("YYYY").format(LocalDate.now)
    val upperaseMonth = month.toUpperCase

    // write to file
    val writer = new PrintWriter(new File(s"/Users/allisonkinnamore/Desktop/scala/MonthlySpotifyWrapped/SpotifyWrappedHistory/$month Wrapped $year.txt" ))

    // print top 30 tracks
    println(s"TOP 30 TRACKS FOR $upperaseMonth\n")
    writer.write(s"TOP 30 TRACKS FOR $upperaseMonth\n")

    val tracks = TopItems.getUserTopTracks(token)

    tracks.zipWithIndex.foreach{ case (track, i) => println((i+1) + ". " + track.name) }
    tracks.zipWithIndex.foreach{ case (track, i) => writer.write((i+1) + ". " + track.name + "\n") }

    val trackIDs = tracks.map(track => track.id)

    // print top 30 artists
    println(s"\nTOP 30 ARTISTS FOR $upperaseMonth\n")
    writer.write("TOP 30 ARTISTS FOR " + upperaseMonth + "\n")

    val artists = TopItems.getUserTopArtists(token)

    artists.zipWithIndex.foreach{ case (artist, i) => println((i+1) + ". " + artist.name) }
    artists.zipWithIndex.foreach{ case (artist, i) => writer.write((i+1) + ". " + artist.name + "\n") }

    writer.close()

    // make empty playlist
    val playlistName = s"$month Wrapped"
    val description = s"Enjoy your $month version of monthly Spotify Wrapped!"
    PlaylistEndpoint.makePlaylist(token, playlistName, description)

    // get playlist ID
    val playlistID = PlaylistEndpoint.getPlaylist(token)

    // add top songs to playlist
    PlaylistEndpoint.addTracks(token, playlistID, trackIDs)

    println(s"\nEnjoy your $playlistName playlist!\n")

  }
}