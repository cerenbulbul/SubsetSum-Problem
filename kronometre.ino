#include <Wire.h>
#define accel_module (0x53)
#include <LiquidCrystal.h>

const int rs = 12, en = 11, d4 = 5, d5 = 4, d6 = 3, d7 = 2;
LiquidCrystal lcd(rs, en, d4, d5, d6, d7);
byte values[6] ;
char output[512];
long previousMillis = 0;            // variable to store last time LED was updated
long elapsedTime ;                  // elapsed time for stop watch
void setup() {
 lcd.begin(16, 2);
 lcd.print("Ceren Bulbul");
 lcd.setCursor(0, 1);
 lcd.print("20160808052");
 Wire.begin();
 Serial.begin(9600);
 Wire.beginTransmission(accel_module);
 Wire.write(0x2D);
 Wire.write(0);
 Wire.endTransmission();
 Wire.beginTransmission(accel_module);
 Wire.write(0x2D);
 Wire.write(16);
 Wire.endTransmission();
 Wire.beginTransmission(accel_module);
 Wire.write(0x2D);
 Wire.write(8);
 Wire.endTransmission();
}

void loop() {
 int xyzregister = 0x32;
 int x, y, z;
 
 Wire.beginTransmission(accel_module);
 Wire.write(xyzregister);
 Wire.endTransmission();
 
 Wire.beginTransmission(accel_module);
 Wire.requestFrom(accel_module, 6);
 
 int i = 0;
 while(Wire.available()){
   values[i] = Wire.read();
   i++;
 }

 Wire.endTransmission();
 x = (((int)values[1]) << 8) | values[0];
 y = (((int)values[3])<< 8) | values[2];
 z = (((int)values[5]) << 8) | values[4];
 sprintf(output, "%d %d %d", x, y, z);
 Serial.print(output);
 Serial.write(10);
 
 if((millis()/1000)>=5){
   lcd.clear();
   lcd.setCursor(0,0);
   lcd.print(x/200);
   lcd.setCursor(5,0);
   lcd.print(y/200);
   lcd.setCursor(10,0);
   lcd.print(z/200);
   if(z>200&&y<150&&x<150){
     if(elapsedTime==0){
       lcd.setCursor(0,1);
       lcd.print((millis()/60000)%60);
       lcd.print(":");
       lcd.print((millis()/1000)%60);
       lcd.print(":");
       lcd.print((millis()%1000)/10);
       previousMillis = millis();
     }
     else{
       lcd.setCursor(0,1);
       lcd.print(((millis()-elapsedTime)/60000)%60);
       lcd.print(":");
       lcd.print(((millis()-elapsedTime)/1000)%60);
       lcd.print(":");
       lcd.print(((millis()-elapsedTime)%1000)/10);
       previousMillis = millis()-elapsedTime;
     }
   }
 }
 if(y>200&&z<150&&x<150){
   lcd.setCursor(0,1);
   lcd.print((previousMillis/60000)%60);
     lcd.print(":");
     lcd.print((previousMillis/1000)%60);
     lcd.print(":");
lcd.print((previousMillis%1000)/10);
     lcd.print(" Paused");
   elapsedTime = millis() - previousMillis;
 }
 if(x>200&&y<150&&z<150){
   lcd.setCursor(0,1);
   lcd.print("0:");
   lcd.print("0:");
   lcd.print("0");
   lcd.print(" Cleared");
   elapsedTime = millis();
 }
 delay(200);
}
