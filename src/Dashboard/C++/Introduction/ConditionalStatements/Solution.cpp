#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    string w[] = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "Greater than 9" };
    if (n > 10)
        n = 10;
    std:cout << w[n];
    return 0;
}
