package model

case class Playlist(name: String,
                    public: Option[Boolean],
                    id: String,
                    collaborative: Option[Boolean],
                    description: Option[String]
                   )