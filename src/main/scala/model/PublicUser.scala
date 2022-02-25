package model

case class PublicUser(
                      display_name: String,
                      external_urls: Map[String, String],
                      href: String,
                      id: String,
                      `type`: String,
                      uri: String
                      )