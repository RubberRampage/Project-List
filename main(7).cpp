#include <iostream>  // Input/output stream
#include <fstream>   // File stream
#include <string>    // String class for handling strings

using namespace std;  // Using the standard namespace for convenience

// Struct to represent a person's information
struct Person {
    string first_name;  // First name of the person
    string last_name;   // Last name of the person
    string city;        // City where the person resides
    int age;            // Age of the person
};

// Struct to represent an employee, which includes person's information along with salary and years in service
struct Employee {
    Person person;      // Person's information
    double salary;      // Salary of the employee
    int years_in_service;  // Number of years the employee has been in service
};

// Function to read employee data from a file and populate the array of Employee structs
void readEmployeesFromFile(Employee employees[], const string& filename) {
    // Open the input file
    ifstream infile(filename);
    // Check if the file was opened successfully
    if (!infile) {
        cerr << "Error: Unable to open input file." << endl;  // Print error message to standard error stream
        exit(1);  // Terminate the program with an error code
    }

    // Loop to read data for each employee from the file
    for (int i = 0; i < 20; ++i) {
        // Declare variables to store data for each employee
        string first_name, last_name, city;
        int age, years_in_service;
        double salary;
        
        // Read data from the file into variables
        if (!(infile >> first_name >> last_name >> city >> age >> salary >> years_in_service)) {
            cerr << "Error reading input file." << endl;  // Print error message if unable to read data
            exit(1);  // Terminate the program with an error code
        }

        // Populate the corresponding fields of the Employee struct for the current employee
        employees[i].person.first_name = first_name;
        employees[i].person.last_name = last_name;
        employees[i].person.city = city;
        employees[i].person.age = age;
        employees[i].salary = salary;
        employees[i].years_in_service = years_in_service;
    }

    // Close the input file
    infile.close();
}

// Function to increment the age of each employee by 2
void addAge(Employee employees[]) {
    // Loop through each employee in the array
    for (int i = 0; i < 20; ++i) {
        // Increment the age of the current employee by 2
        employees[i].person.age += 2;
    }
}

// Function to write employee data to an output file
void writeEmployeesToFile(const Employee employees[], const string& filename) {
    // Open the output file
    ofstream outfile(filename);
    // Check if the file was opened successfully
    if (!outfile) {
        cerr << "Error: Unable to open output file." << endl;  // Print error message to standard error stream
        exit(1);  // Terminate the program with an error code
    }

    // Loop to write data for each employee to the output file
    for (int i = 0; i < 20; ++i) {
        // Write employee information to the output file
        outfile << employees[i].person.first_name << " "
                << employees[i].person.last_name << " - Age: "
                << employees[i].person.age << ", City: "
                << employees[i].person.city << ", Salary: "
                << employees[i].salary << ", Years in Service: "
                << employees[i].years_in_service << endl;
    }

    // Close the output file
    outfile.close();
}

// Main function
int main() {
    // Declare an array to store employee data
    Employee employees[20];
    // Specify input and output file names
    string input_file = "input.txt";
    string output_file = "output.txt";

    // Read employee data from the input file
    readEmployeesFromFile(employees, input_file);
    // Increment the age of each employee by 2
    addAge(employees);
    // Write modified employee data to the output file
    writeEmployeesToFile(employees, output_file);

    // Print a message indicating that the data has been successfully written to the output file
    cout << "Data written to output.txt" << endl;

    // Return 0 to indicate successful program execution
    return 0;
}