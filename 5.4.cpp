#include <iostream>
#include <fstream>
#include <string>
using namespace std;

// Prototype
void reverse(int[], int);

int main() {
    const int SIZE = 10;
    int numbers[SIZE];

    // Take input file name and open the file
    string inputFileName;
    cout << "Enter the filename: "<< endl;
    cin >> inputFileName;

    ifstream inputFile(inputFileName);

    // Check if the file is open
    if (!inputFile.is_open()) {
        cerr << "Error opening input file." << endl;
        return 1;
    }

    // Read numbers from the file
    int i = 0;
    while (i < SIZE && inputFile >> numbers[i]) {
        i++;
    }

    // Check if there are enough numbers in the file
    if (i < SIZE) {
        cerr << "Error: input file does not contain enough numbers." << endl;
        return 1;
    }

    // Close the input file
    inputFile.close();

    // Call the reverse function
    reverse(numbers, SIZE);

    // Take output file name and open the file
    string outputFileName;
    cout << "Enter the output filename: "<< endl;
    cin >> outputFileName;

    ofstream outputFile(outputFileName);

    // Check if the file is open
    if (!outputFile.is_open()) {
        cerr << "Error opening output file." << endl;
        return 1;
    }

    // Display the reversed numbers and write them to the output file
    cout << "The reversal of the input is ";
    for (int j = 0; j < SIZE; ++j) {
        cout << numbers[j] << " ";
        outputFile << numbers[j] << " ";
    }

    // Close the output file
    outputFile.close();

    return 0;
}

// Define the reverse function
void reverse(int arr[], int size) {
    int start = 0;
    int end = size - 1;

    while (start < end) {
        // Swap elements at start and end indices
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        // Move indices toward the center
        start++;
        end--;
    }
}
