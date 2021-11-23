/**
* 메모리: 2176 KB, 시간: 12 ms
* 2021.11.23
* by Alub
*/
#include <stdio.h>
#include <iostream>

using namespace std;
int d[201][201] = {0,};
int k, n;

#define MOD 1000000000

int main(){
    cin >> n >> k;

    for(int i=0; i<=n; i++){
        d[0][i] = 0;
        d[1][i] = 1;
    }

    for(int i=2; i<=k; i++){
        for(int j=0; j<=n; j++){
            for(int l=0; l<=j; l++){
                d[i][j] = (d[i][j] + d[i-1][j-l]) % MOD;
            }
        }
    }
    printf("%d\n",d[k][n]);
    return 0;
}

//20 2
// d[k][n] = d[k-1][n-l]