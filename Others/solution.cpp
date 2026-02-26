#include <iostream>
using namespace std;

void exec() {
    int n;
    cin >> n;
    string s;
    cin >> s;

    if(n&1 && s[0] == 'b') {
        cout << "NO" << endl; return;
    }

    int i = (n&1)?1:0;

    for(;i<n-1;i+=2) {
        if(s[i] == s[i+1] && s[i] != '?') {
            cout << "NO" << endl; return;
        }
    }

    cout << "YES" << endl;
}

int main() {
   int t;
   cin >> t;
   while(t-- > 0) exec();
}