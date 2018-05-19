# Highlander Hackers Robot Project

Quick gstreamer test: 

Jetson - `gst-launch-1.0 nvcamerasrc ! 'video/x-raw(memory:NVMM),width=720,height=480' ! nvjpegenc ! tcpserversink host=$JETSON_IP port=5000`

Client - `gst-launch-1.0 tcpclientsrc host=$JETSON_IP port=5000 ! jpegdec ! autovideosink`

- [Jetson TX2](https://developer.nvidia.com/embedded-computing)
- [Maisto Rock Crawler Base](https://www.amazon.com/gp/product/B00Y53XH9O/ref=oh_aui_detailpage_o02_s00?ie=UTF8&psc=1)
- [SeeedStudio Motor Shield](http://wiki.seeedstudio.com/Motor_Shield_V2.0/)
- [L298N Motor Drive Controller](https://www.amazon.com/gp/product/B00XAGRQTO/ref=oh_aui_detailpage_o01_s00?ie=UTF8&psc=1)
- [Linear slide potentiometer](https://www.amazon.com/gp/product/B079C9411R/ref=oh_aui_detailpage_o00_s00?ie=UTF8&psc=1)
- [9.6V NiMH Battery Pack](https://www.amazon.com/gp/product/B001BBMZFU/ref=oh_aui_detailpage_o02_s00?ie=UTF8&psc=1)

![Maisto Rock Crawler](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0008.jpg)

![Controller Box](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0010.jpg)

![Controller Box Wires](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0011.jpg)

![Steering Arm Sensor](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0012.jpg)

![L298N Motor Controller in Box](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0013.jpg)

![Motor Controller and Arduino Placement](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0014.jpg)

![Motor Controller Power Wiring](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0015.jpg)

![Motor Controller Arduino Inputs](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0016.jpg)

![Steering Sensor Connector Arm](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0017.jpg)

![Steering Senesor Connector Arm Connected](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0018.jpg)

![Arduino Wiring](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0019.jpg)

![Controller Box w/ Arduino USB Connector](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0020.jpg)

![Controller Box w/ Power Connector](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0021.jpg)

![Jetson Mount #1](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0023.jpg)

!(Jetson Mount #2](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0024.jpg)

![Jetson Mount #3](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0025.jpg)

![Jetsom Mount #4](https://github.com/dschmenk/Highlander-Hackers/blob/master/images/IMG_0026.jpg)

