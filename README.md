# java-8-streams

The number of unique customerId for each contractId.
The number of unique customerId for each geozone.
The average buildduration for each geozone.
The list of unique customerId for each geozone."
  
customerId,contractId,geozone,teamcode,projectcode,buildduration
2343225,2345,us_east,RedTeam,ProjectApple,3445s
1223456,2345,us_west,BlueTeam,ProjectBanana,2211s
3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s
1233456,2345,us_west,BlueTeam,ProjectDate,2221s
3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s




OUTPUT

===========================================================
The number of unique customerId for each contractId.
===========================================================
contractorId-> 2345 CustomerIds Number---> 3
contractorId-> 2346 CustomerIds Number---> 2
===========================================================
The number of unique customerId for each geozone.
===========================================================
Zone -> eu_west-:-> Number of unique customerIds -> 2
Zone -> us_west-:-> Number of unique customerIds -> 2
Zone -> us_east-:-> Number of unique customerIds -> 1
===========================================================
The list of unique customerIds for each geozone.
===========================================================
Geozone->eu_west
CustomerId -> 3244132
CustomerId -> 3244332
Geozone->us_west
CustomerId -> 1223456
CustomerId -> 1233456
Geozone->us_east
CustomerId -> 2343225
===========================================================
The average buildduration for each geozone.
===========================================================
The average build duration -> 4222.0s for each geozone -> eu_west
The average build duration -> 2216.0s for each geozone -> us_west
The average build duration -> 3445.0s for each geozone -> us_east

