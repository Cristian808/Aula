#include <stdio.h>
#include <stdlib.h>
#include "Arvore.h"
#include "No.h"
#include <ctype.h>
#include <string.h>

No* alocarNo(){
    No* no = (No*) malloc(sizeof(No));
    no->esq = NULL;
    no->dir = NULL;
    return no;
}

void desalocarNo(No* no){
    if (no==NULL){
        return;
    }
    desalocarNo(no->esq);
    desalocarNo(no->dir);
    free(no);
    no = NULL;
}

Arvore* alocaArvore(){
    Arvore* a= (Arvore*) malloc(sizeof(Arvore));
    a->raiz=NULL;
    return a;
}

void desalocaArvore(Arvore* a){
    if(a==NULL){
        return;
    }
    desalocarNo(a->raiz);
    free(a);
}

void construirArvore(Arvore* a, int n){
    if (a->raiz == NULL){
        a->raiz = alocarNo();
        a->raiz->info = n;
        }
    else{
        colocarNosArvore(a->raiz, n);
    }
}

void colocarNosArvore(No* no, int n){
    if(verificaN(no, n)!=1){
        if((no->info>n)&&(no->esq == NULL)){
            No* aux=alocarNo();
            aux->info=n;
            no->esq=aux;
            return;
        }
        else if((no->info<n)&&(no->dir == NULL)){
            No* aux=alocarNo();
            aux->info=n;
            no->dir=aux;
            return;
        }
        else if(no->info>n){
            colocarNosArvore(no->esq, n);
            return;
        }
        else if(no->info<n){
            colocarNosArvore(no->dir, n);
            return;
        }

    }
}

int verificaN(No* raiz, int n){
    if(raiz!=NULL){
        if (raiz->info == n){
            return 1;
        }
        else if(raiz->info > n){
            verificaN(raiz->esq, n);
        }
        else if(raiz->info < n){
            verificaN(raiz->dir, n);
        }
        return 0;
    }
    return 0;
}

void imprimirArvore(Arvore* a){
    printf("(%d", a->raiz->info);
    imprimirSubArvore(a->raiz);
    printf(")");
}

void imprimirSubArvore(No* n){
    if((n->esq != NULL)&&(n->dir == NULL)){
        printf("(%d", n->esq->info);
        imprimirSubArvore(n->esq);
        printf(")");
    }
    else if(n->esq != NULL){
        printf("(%d ", n->esq->info);
        imprimirSubArvore(n->esq);
    }
    if((n->dir != NULL)&&(n->esq == NULL)){
        printf("(%d", n->dir->info);
        imprimirSubArvore(n->dir);
        printf(")");
    }
    else if(n->dir != NULL){
        printf("%d", n->dir->info);
        imprimirSubArvore(n->dir);
        printf(")");
    }
}

int tamanho(char *c){
    int cont = 0;
    while(c[cont]!='\0'){
        cont++;
    }
    return cont;
}

void lerStringArvore(Arvore* a, char c[]){
    int cont=0;
    int t=tamanho(c);
    No* aux=alocarNo();
    a->raiz=aux;
    lerString(a->raiz, c, &cont, t);

}

void lerString(No* no, char c[], int *cont, int t){
    if(*cont<t){
        if(c[*cont] == '('){
            (*cont)++;
            lerString(no, c, cont, t);
            if(isdigit(c[(*cont)])){
                No* aux=alocarNo();
                no->dir=aux;
                lerString(no->dir, c, cont, t);
            }
        }
        else if(isdigit(c[*cont])){
            no->info=(c[*cont]-48);
            if((c[(*cont)+1]=='(')&&(no->esq == NULL)){
                (*cont)+=2;
                No* aux=alocarNo();
                no->esq=aux;
                lerString(no->esq, c, cont, t);
            }
            if((c[(*cont)+1]==')')||(c[(*cont)+1] == ' ')){
                (*cont)++;
                return;
            }
            else if(isdigit(c[(*cont)])){
                No* aux=alocarNo();
                no->dir=aux;
                lerString(no->dir, c, cont, t);
            }
            else if(c[*cont]==')'){
                (*cont)++;
                return;
            }
            else if(isdigit(c[(*cont)+1])){
                (*cont)++;
                No* aux=alocarNo();
                no->dir=aux;
                lerString(no->dir, c, cont, t);
            }
        }
    }
}




int main(){
    char c[50];
    scanf("%[^\n]%*c", c);
    Arvore* a=alocaArvore();
    /*
    for(int cont=0; cont<7;cont++){
        scanf("%d", &n);
        construirArvore(a, n);
    }*/
    lerStringArvore(a, c);
    imprimirArvore(a);
    desalocaArvore(a);
    return 0;
}
