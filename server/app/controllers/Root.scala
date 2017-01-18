package com.washingtonpost.controllers

import play.api._
import play.api.http.ContentTypes
import play.api.mvc._
import play.twirl.api.{HtmlFormat, Html => H}
import views.IndexView

import scalatags.Text.all._

class Root( env: Environment) extends Controller {

  def Html(tags: Modifier) = "<!DOCTYPE html>" + tags.toString

  def userCreds(user: String ) = {
    user match {
      case  u if u.equals("") => Seq("agent")
      case  u if u.equals("agent") => Seq("agent")
      case  u if u.equals("admin") => Seq("admin", "agent")
      case  u if u.equals("super") => Seq( "super", "admin", "agent")
    }
  }

  def index(path: String, u: String) = Action {

    //Ok(views.html.index(env,userCreds.mkString("\"", "\", \"", "\"")))

    Ok(HtmlFormat.raw(Html(IndexView(userCreds(u).mkString("'", "', '", "'"))))).withHeaders(CONTENT_TYPE -> ContentTypes.HTML)
  }
}
