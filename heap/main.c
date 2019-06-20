#include <stdio.h>
#include <stdlib.h>


void heapsort(int *a, int n){
    criarHeap(a, n);
    for(int i=n-1; i>1;i--){
        troca(&(a[0]), &(a[i]));
        heapify(a, 0, i-1);
    }
}

void heapify(int *a, int i, int n){
    int esq=(2*(i+1))-1;
    int dir=2*(i+1);
    int maior;
    if(esq <= n && a[esq] > a[i]){
        maior=esq;
    }
    else{
        maior=i;
    }
    if(dir <= n && a[dir] > a[maior]){
        maior=dir;
    }
    if(maior != i){
        troca(&(a[i]), &(a[maior]));
        heapify(a, maior, n);
    }

}

void troca(int *a, int *b){
    int x= *a;
    *a=*b;
    *b=x;
}

void criarHeap(int *a, int n){
    for(int i=n/2; i>=0; i--){
        heapify(a, i, n);
    }
}

int main()
{
    int n=10;
    int a[n];
    a[0]=4;
    a[1]=6;
    a[2]=3;
    a[3]=2;
    a[4]=16;
    a[5]=9;
    a[6]=10;
    a[7]=14;
    a[8]=8;
    a[9]=7;
    heapsort(a, n);
    for(int i=0; i<n; i++){
        printf("\n%d", a[i]);
    }
    return 0;
}
