INSERT INTO COUNTRY( id,code,name,continent )
SELECT CONVERT( "id",INT ), "code","name","continent"
  FROM CSVREAD( 'classpath:/static/countries.csv','id,code,name,continent,wikipedia_link,keywords', NULL );

INSERT INTO AIRPORT( id, ident, type,name,iso_Country )
SELECT CONVERT( "id",INT ), "ident","type","name","iso_country"
  FROM CSVREAD( 'classpath:/static/airports.csv','id,ident,type,name,iso_country,iso_region,municipality,
  gps_code', NULL );

INSERT INTO RUNWAY( id, airport_ref, airport_ident,surface,le_Ident )
SELECT CONVERT( "id",INT ), CONVERT( "airport_ref",INT ),"airport_ident","surface","le_ident"
  FROM CSVREAD( 'classpath:/static/runways.csv', 'id,airport_ref,airport_ident,length_ft,width_ft,
  surface,lighted,closed,le_ident,le_latitude_deg,le_longitude_deg,le_elevation_ft,le_heading_degT,
  le_displaced_threshold_ft,he_ident,he_latitude_deg,he_longitude_deg,he_elevation_ft,he_heading_degT,
  he_displaced_threshold_ft', NULL );
