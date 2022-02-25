
/* Spotify API Wrapper */

To generate your monthly spotify wrapped playlist, follow these steps:

1: Generate your Spotify developer's OAuth token
    assuming you have the token in postman - if not, there are many online tutorials
        go to Postman -> click on your Spotify collection -> scroll to bottom -> click "Get New Access Token"
        select "Use Token" then copy the generated token
        paste token in place of the "token" value in Runnable.scala
2. In Runnable.scala, set the location of the PrintWriter file to wherever you want to save your listening history

3. To run the code:
    in your terminal, navigate to the root directory of project
        in my case, this is /Users/allisonkinnamore/Desktop/scala/MonthlySpotifyWrapped
    run "sbt" in terminal to start sbt server
    run "compile"
    run "run"

4. Enjoy your playlist!