# airport-information-service

This project is developed in java version 1.8, Spring Boot and Spring Data.
Its simple REST API service developed with spring rest controller. To find Airport and Runway information worldwide 

## Rest API URL's
To Fetch Aiprots for country :
  https://localhost:8082/airport/country/{countryID} 
    country Id's is available in country.csv (in the static folder of the same project)
    e.g INDIA- IN, USA- US, United Kingdome - UK
    
   
 To get Airports runway  
  https://localhost:8082/airport/runways/{airportID} 
  
 To get runway details  
  https://localhost:8082/runways/{runwayID}.
  
  
 
## Used In memory H2 database.
  Country, Airport and Runways information available in the static csv file
