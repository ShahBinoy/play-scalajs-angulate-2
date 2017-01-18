package com.washingtonpost.identity.csr.security

import scala.scalajs.js

/**
  * Created by shahb on 1/17/17.
  */
object Config {

  private lazy val _perms = js.Dynamic.global.userPerms.asInstanceOf[js.UndefOr[js.Array[String]]].getOrElse(js.Array())

  def hasPermission(s: String) = {
    System.out.println(s"passed String ${s}, perms size is ${_perms.size} perms values are ${_perms} and exists ${_perms.contains(s)}")
    _perms.contains(s)
    //_perms.getOrElse(s, false)
  }

}
