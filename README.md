# ShipmentsAssignment Kotlin - Compose Project

Shipments Assignment to Drivers by Suitable Score Algoritm

## Suitable Score:
The app calculates Suitable Score of the shipment street name for drivers. 
User could (in next version) select a driver according most Suitable Score over other drivers

## Features
- Shipment Assignment Screen. Actually here shows the result for Suitable Score for one shipment and one drive.
- Shipments & Drivers Screen. Here app shows shipments and driver lists from local or remote Datasource (datasource origin is set in Settings screen).
Actually remote datasource is the Github repository: [ShipmentAssignmentApi](https://github.com/GregHdezQroMx/ShipmentAssignmentApi), its contains shipments.json & drivers.json files.
Using retrofit library for consuming.
- Settings Screen. Actually Here can set data source origin: local or remote (Datastore preferences / Github repository) 

## Technology
- Jetpack
  - Compose
  - Flow & Coroutines
  - ViewModel & Live data 
- Retrofit
- Clean Architecture
- MVVM / MVI
- Dependency injection with Koin

## Next Steps
- Update Shipment Assignment Screen for allow select a driver and select shipment based on its more suitable score.
- Incorporate Server Settings section (Ip Address & Port) for consuming API Rest Webservices with NodeJs Project.




