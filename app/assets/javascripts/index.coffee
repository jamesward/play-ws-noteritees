$ ->
  
  wsScala = new WebSocket("ws://localhost:9000/echo-ws-scala")
  wsScala.onmessage = (event) ->
    log("Scala Message Received: " + event.data)
  wsScala.onopen = () ->
    log("Scala WS Open")
    wsScala.send("Hello Scala")
    log("Scala Message Sent")
  
  wsJava = new WebSocket("ws://localhost:9000/echo-ws-java")
  wsJava.onmessage = (event) ->
    log("Java Message Received: " + event.data)
  wsJava.onopen = () ->
    log("Java WS Open")
    wsJava.send("Hello Java")
    log("Java Message Sent")
  
log = (message) ->
  $(".well").append($("<p>").text(message))
  