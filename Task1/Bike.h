#ifndef BIKE_H
#define BIKE_H
#include <iostream>
#include "Vehicle.h"

using namespace std;

class Bike: public Vehicle
{
        int weight;
        string bikeType;

    public:

        int getNoOfWheels()
        {
            return 2;
        }

        Bike(int weigh,string type,string col,string brnd,string mdl,int mil,int pri):Vehicle(type,col,brnd,mdl,mil,pri)
        {
            weight=weigh;
            bikeType=type;
        }

};

#endif // BIKE_H_INCLUDED
