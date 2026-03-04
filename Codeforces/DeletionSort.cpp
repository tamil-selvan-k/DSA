#include <iostream>
using namespace std;

void exec() {
    int n;
    cin >> n;
    int arr[n];
    for(int i=0;i<n;i++) cin >> arr[i];
    for(int i=1;i<n;i++) {
        if(arr[i] < arr[i - 1]) {
            cout << 1 << endl;
            return;
        }
    }
    
    cout << n << endl;
}

int main() {
    int t;
    cin >> t;
    while(t-- > 0) exec();
}
