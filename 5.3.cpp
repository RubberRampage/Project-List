#include <iostream>
using namespace std;

// Function prototype
void displayGrades(double[], int);

int main() {
    const int MAX_STUDENTS = 100;
    double scores[MAX_STUDENTS];
    int numStudents;

    // Get the number of students
    cout << "Enter number of students: ";
    cin >> numStudents;

    // Get scores from the user
    cout << "\nEnter " << numStudents << " scores: ";
    for (int i = 0; i < numStudents; ++i) {
        cin >> scores[i];
    }
    cout << endl;

    // Display grades
    displayGrades(scores, numStudents);

    return 0;
}

// Function to display grades
void displayGrades(double scores[], int numStudents) {
    const char GRADES[] = {'A', 'B', 'C', 'D', 'F'};

    // Find the highest score
    double highestScore = scores[0];
    for (int i = 1; i < numStudents; ++i) {
        if (scores[i] > highestScore) {
            highestScore = scores[i];
        }
    }

    // Calculate grades in increments of 10 starting from the highest score
    for (int i = 0; i < numStudents; ++i) {
        cout << "Student " << i << " score is " << scores[i] << " and grade is ";

        // Calculate the grade index based on the difference from the highest score
        int gradeIndex = static_cast<int>((highestScore - scores[i]) / 10);

        // Ensure the grade index is within valid bounds
        if (gradeIndex < 0) {
            gradeIndex = 0;
        } else if (gradeIndex >= sizeof(GRADES) / sizeof(GRADES[0])) {
            gradeIndex = sizeof(GRADES) / sizeof(GRADES[0]) - 1;
        }

        cout << GRADES[gradeIndex] << endl;
    }
}
