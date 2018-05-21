/*
  Motor Control sketch:
  
  Steering sensor on analog input A0
  Steering direction on D4
  Steering PWM on D5
  Drive direction on D2
  Drive PWM on D3
 */
#define LEFT     0
#define RIGHT    1
#define FORWARD  0
#define BACKWARD 1
const int steeringSensePin = A0; // Analog input pin that the potentiometer is attached to
const int steeringDirPin   = 4;  // Steering direction
const int steeringPowPin   = 5;  // Steering power
const int driveDirPin      = 2;  // Drive direction
const int drivePowPin      = 3;  // Drive power
int steeringValue  = 0;          // steering
int steeringCenter = 0;
int steeringLeft   = 0;
int steeringRight  = 0;
int driveValue     = 0;           // speed

void setup()
{
  Serial.begin(57600); 
}

void calibrate()
{
  digitalWrite(steeringDirPin, LOW);
  analogWrite(steeringPowPin,  0);
  delay(100);
  steeringCenter = analogRead(steeringSensePin);
  digitalWrite(steeringDirPin, HIGH);
  delay(200);
  steeringRight = analogRead(steeringSensePin);
  digitalWrite(steeringDirPin, LOW);
  analogWrite(steeringPowPin,  255);
  delay(400);
  steeringLeft = analogRead(steeringSensePin);
  analogWrite(steeringPowPin,  0);
}

void loop()
{
  char cmd;
  int pin, val;
  if (Serial.available())
  {
    switch (Serial.read())
    {
      case '!': // Synchronize
        calibrate();// Calibrate steering
        Serial.println(steeringLeft);
        Serial.println(steeringCenter);
        Serial.println(steeringRight);
        Serial.println("!");
        break;
      case '=': // Read a value
        Serial.readBytes(&cmd, 1);
        switch (cmd)
        {
          case 'D': // Read digital pin
          case 'd':
            pin = Serial.parseInt();
            pinMode(pin, INPUT);
            Serial.println(digitalRead(pin));
            break;
          case 'A': // Read analog pin
          case 'a':
            pin = Serial.parseInt() + A0;
            pinMode(pin, INPUT);
            Serial.println(analogRead(pin));
            break;
          default:
            Serial.println("Huh?");
        }
        break;
      case 'D': // Write digital pin
      case 'd':
        pin = Serial.parseInt();
        Serial.readBytes(&cmd, 1);
        switch (cmd)
        {
          case '=': // Binary
            val = Serial.parseInt() ? HIGH : LOW;
            pinMode(pin, OUTPUT);
            digitalWrite(pin, val);
            break;
          case '~': // PWM
            val = Serial.parseInt();
            pinMode(pin, OUTPUT);
            analogWrite(pin, val);
            break;
        }
        break;
      case 'A': // Write analog pin
      case 'a':
        pin = Serial.parseInt() + A0;
        Serial.readBytes(&cmd, 1);
        if (cmd != '=')
          break;
        val = Serial.parseInt();
        pinMode(pin, OUTPUT);
        digitalWrite(pin, val);
        break;
    }
  }
}
