# Axiom Mobile Handset home task application
This spring boot application calls the Json URL(https://api.myjson.com/bins/1f2r2v?pretty=true) internally 
using Rest GET endpoint and then render the json array response, filter them by given search criteria.

## Basic Software dependencies :
1. JDK 1.8 or later
2. Maven 3.5.4+
3. Git 2.20+
4. Spring boot 2.1.4.RELEASE
5. Junit Jupiter
6. Gson
7. Lombok

## How to run the app :

1. In any folder of choice, open command prompt/git terminal.

2. Run the following commands :
  git clone https://github.com/Boburmirzo/axiom-mobile-handset.git
  
  This app can be run both as normal **spring boot** project or as **docker image**.
### Spring-Boot App Run:
1. Move to the mobile folder i.e. root folder of the app where pom is placed.
2. Run command mvn clean install spring-boot:run

### Scenario -1 (My Personal Repo)
**Sample Endpoint** : http://localhost:8080/mobile/search/ GET :
**Sample Output** : [
    {
    id: 25846,
    brand: "Apple",
    phone: "Apple iPad Pro 12.9 (2018)",
    picture: "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-129-2018.jpg",
    sim: "Nano-SIM eSIM",
    resolution: "2048 x 2732 pixels",
    hardware: {
    audioJack: "No",
    gps: "Yes with A-GPS",
    battery: "Li-Po 9720 mAh battery (36.71 Wh)"
    },
    release: {
    announceDate: "2018 October",
    priceEur: 1100
    }
    },
    ...]
### Scenario -2 (Test Repo)
**Sample Endpoint with filter** : http://localhost:8080/mobile/search/?id=25846 GET :
**Sample Output** : [
    {
    id: 25846,
    brand: "Apple",
    phone: "Apple iPad Pro 12.9 (2018)",
    picture: "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-129-2018.jpg",
    sim: "Nano-SIM eSIM",
    resolution: "2048 x 2732 pixels",
    hardware: {
    audioJack: "No",
    gps: "Yes with A-GPS",
    battery: "Li-Po 9720 mAh battery (36.71 Wh)"
    },
    release: {
    announceDate: "2018 October",
    priceEur: 1100
    }
    },
    ...
    ]

