/**
* 메모리: 2768 KB, 시간: 44 ms
* 2021.12.01
* by Alub
*/
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool compare(const pair<int, int>& a, const pair<int, int>& b){
    if(a.first == b.first)
        return a.second < b.second;
    return a.first < b.first;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);

    int n;
    cin >> n;

    vector< pair<int, int> > location(n);
    for(int i=0; i<n; i++)
        cin >> location[i].first >> location[i].second;

    sort(location.begin(), location.end(), compare);

    for(int i=0; i<n; i++)
        cout << location[i].first << " "<< location[i].second << "\n";


    return 0;
}