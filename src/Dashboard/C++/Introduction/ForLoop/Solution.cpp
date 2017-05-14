#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a;
    cin >> b;
    string w[] = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    for (int i = a; i <= b; i++) {
        if (i <= 9) {
            cout << w[i] << endl;
        } else if (i % 2 == 0) {
            cout << "even" << endl;
        } else {
            cout << "odd" << endl;
        }
    }
    return 0;
}
