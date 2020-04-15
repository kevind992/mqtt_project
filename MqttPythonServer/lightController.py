 GPIO.setmode(GPIO.BCM)
 GPIO.setwarnings(False)
 GPIO.setup(18,GPIO.OUT)

 def on_connect(client, userdata, flags, rc):
     print("Connected with result code "+str(rc))
     client.subscribe("light_command")

 def on_message(client, userdata, msg):
     if msg.payload.decode() == "On Command":
         print("Light On")
         GPIO.output(18,GPIO.HIGH)
     elif msg.payload.decode() == "Off Command":
         print("Light Off")
         GPIO.output(18,GPIO.LOW)
     else:
         print("Unknown command")

 client = mqtt.Client()
 client.connect("127.0.0.1",1883,60)

 client.on_connect = on_connect
 client.on_message = on_message

 client.loop_forever()
