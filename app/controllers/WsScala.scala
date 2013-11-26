package controllers

import play.api.mvc.Controller
import play.mvc.WebSocket
import play.mvc.WebSocket.{Out, In}
import play.libs.F.Callback

object WsScala extends Controller {

  def echo(): WebSocket[String] = new WebSocket[String] {
    def onReady(in: In[String], out: Out[String]) {
      in.onMessage(new Callback[String] {
        def invoke(message: String) {
          out.write(message)
        }
      })
    }
  }
  
}
