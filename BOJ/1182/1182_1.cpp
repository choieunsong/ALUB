/**
* 메모리: 1984 KB, 시간: 4 ms
* 2021.12.01
* by Alub
*/
#include <iostream>
#include <vector>

using namespace std;

int _count;
int n,s;

void check( int sum, vector<int> &num, int i){
    if(i == n){
        if(sum == s){
            _count += 1;
        }
        return;
    }
    check(sum+num[i], num, i+1);
    check(sum, num, i+1);
}

int main(){
    _count=0;

    cin >> n >> s;

    vector<int> num(n);
    for(int i=0; i<n; i++)
        cin >> num[i];
    
    check(0, num, 0);
    if(s==0) _count-=1;
    cout << _count << endl;

    return 0;
}