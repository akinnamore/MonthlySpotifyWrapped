
/* Spotify API Wrapper */

To generate your monthly spotify wrapped playlist, follow these steps:

1: Generate your Spotify developer's client ID and client secret
    Log in to Spotify Dev dashboard with your Spotify account: https://developer.spotify.com/dashboard/
        Create a new App to generate your client ID and client secret
        Edit the App settings and add https://oauth.pstmn.io/v1/browser-callback as the redirect URI
        
2. In Postman, make a new Spotify collection 
    on the Authorization tab of the collection, choose "OAuth 2.0" for the type
    Scroll down to "Configure New Token"
        for "Grant Type" select "Authorization Code"
        Callback URL = https://oauth.pstmn.io/v1/browser-callback
        Auth URL = https://accounts.spotify.com/authorize
        Access Token URL = https://accounts.spotify.com/api/token
        Client ID = { your client ID from Spotivy Dev Dashboard }
        Client secret = { your client ID from Spotivy Dev Dashboard }
        Scope = "playlist-modify-public playlist-read-private playlist-modify-private user-top-read"
        Client Authentication = "Send as Basic Auth header"
        
        select "Get new Access token"
        select "Use Token" then copy the generated token
        paste token in place of the "token" value in Runnable.scala
        
3. In Runnable.scala, set the location of the PrintWriter file to wherever you want to save your listening history

4. In SpotifyEndpoint.scala, change userID to the userID of your Spotify account

5. To run the code:
    in your terminal, navigate to the root directory of project
    run "sbt" in terminal to start scala shell (you will need to download sbt through SDKMAN! or homebrew: https://www.scala-sbt.org/download.html)
    run "compile"
    run "run"

6. Enjoy your playlist!
