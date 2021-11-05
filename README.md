# NEO

### This project gathers data about near Earth objects (NEOs) from the NASA api (linked below). It uses Java and the Json-simple library to parse the data and print information to the console.

### https://api.nasa.gov/

## Getting Started
All dependencies are included. In git bash, enter the following to clone this repository:
```
git clone https://github.com/jgades8/NEO
```
This project is run on:
```
openjdk-15 version 15.0.2
```

## Usage
When the script is run, it will prompt the user to enter a date in the terminal in the format
`YYYY-MM-dd`

It will also prompt the user to enter a number based on if they want to print information about potentially hazardous, not hazardous, or all NEOs for the date entered.

## Ouput example
Data is output in the following format:
```
Name: (2007 DL41)
NEO Reference ID: 3368864
ID: 3368864
Absolute Magnitude (H): 20.7
Is potentially hazardous: true
Is sentry object: false
NASA JPL URL: http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3368864
Links: http://www.neowsapp.com/rest/v1/neo/3368864?api_key=zyfNxc8RLnE7oHuzTiA5xPCJ35J4koH3rNTlio85

Diameter information of NEO reference ID 3368864
Estimated maximum diameter in feet: 1412.6189567557
Estimated minimum diameter in feet: 631.7424027221
Estimated maximum diameter in miles: 0.2675413778
Estimated minimum diameter in miles: 0.1196481415
Estimated maximum diameter in meters: 430.566244241
Estimated minimum diameter in meters: 192.5550781879
Estimated maximum diameter in kilometers: 0.4305662442
Estimated minimum diameter in kilometers: 0.1925550782

Velocity information of NEO reference ID 3368864
Relative velocity in miles per hour: 43749.6571367838
Relative velocity in kilometers per hour: 70409.3905370923
Relative velocity in kilometers per second: 19.5581640381
NEO reference ID 3368864 is near Earth on 2021-10-10
Miss distance (astronomical): 0.2053406323
Miss distance (lunar): 79.8775059647
Miss distance (miles): 1.9087603979996134E7
Miss distance (kilometers): 3.0718521216533203E7
```
