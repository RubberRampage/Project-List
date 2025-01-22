#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int main() {
	// variable to store the unsigned int
    unsigned int seed;
    // read the seed value
    cin >> seed;
    // seed the random function
    srand(seed);
	
	
	// variable to store the number of rolls
    int rolls;
    cout << "How many times do you want the two dice rolled? ";
    cin >> rolls;

	// if the rolls is greater than 0
    if (rolls > 0){
    	// create a 2 dimensional array with all elements intialized to 0
    	int counters[6][6] = {0};
		// loop rolls times
	    for (int i = 0; i < rolls; i++) {
	    	// generate a random number between 1 and 6 for dice 1
	        int die1 = rand() % 6 + 1;
	        // generate a random number between 1 and 6 for dice 12
	        int die2 = rand() % 6 + 1;
	        // store the value in the array
	        counters[die1-1][die2-1]++;
	    }
		// print the combinations now
	    cout << "The combinations:\n";
	    // loop through each inner array of the 2d
	    for (int i = 0; i < 6; i++) {
	    	// loop through each element in the inner array
	        for (int j = 0; j < 6; j++) {
	        	// print the number count
	            cout << "Die 1 = " << i+1 <<" Die 2 = " << j+1 << " occurred " << counters[i][j] << " times.\n";
	        }
	    }
	}
	// end program
    return 0;
}