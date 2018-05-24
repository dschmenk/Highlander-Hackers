from time import sleep
import serial
s = serial.Serial('/dev/ttyACM0', 57600)
actions = ["=", 10]

for (action in actions):	
	s.write("")
	print s.readline()
	sleep(action[1])
	s.write(action[])

#d3~123 set motors on
#d2=0
	
	
