#include <stdio.h>
#include <stdlib.h>
#include "Arvore.h"
#include "No.h"


No* alocarNo(){
    No* no = (No*) malloc(sizeof(No));
    no->esq = NULL;
    no->dir = NULL;
    no->h = 0;
    return no;
}

void desalocarNo(No* no){
    if (no==NULL){
        return;
    }
    desalocarNo(no->esq);
    desalocarNo(no->dir);
    free(no);
    no=NULL;
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
        colocarNosArvore(&(a->raiz), n);
    }
}

void colocarNosArvore(No** no, int n){
    if(verificaN(*no, n)!=1){
        if(((*no)->info>n)&&((*no)->esq == NULL)){
            (*no)->esq=alocarNo();
            (*no)->esq->info=n;
        }
        else if(((*no)->info<n)&&((*no)->dir == NULL)){
            (*no)->dir=alocarNo();
            (*no)->dir->info=n;
        }
        else if((*no)->info>n){
            colocarNosArvore(&(*no)->esq, n);
        }
        else if((*no)->info<n){
            colocarNosArvore(&(*no)->dir, n);
        }
        mudaH(*no);
        checkAVL(no);
    }
}

void printH(No* raiz){
    if((raiz->dir==NULL) && (raiz->esq==NULL)){
        printf("%d H = %d\n", raiz->info ,raiz->h);
    }
    else if((raiz->dir!=NULL) && (raiz->esq==NULL)){
        printH(raiz->dir);
        printf("%d H = %d\n", raiz->info ,raiz->h);
    }
    else if((raiz->dir==NULL) && (raiz->esq!=NULL)){
        printH(raiz->esq);
        printf("%d H = %d\n", raiz->info ,raiz->h);
    }
    else if((raiz->dir!=NULL) && (raiz->esq!=NULL)){
        printH(raiz->dir);
        printH(raiz->esq);
        printf("%d H = %d\n", raiz->info ,raiz->h);
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

No* buscaNo(No* raiz, int n){
    if(raiz!=NULL){
        if (raiz->info == n){
            return raiz;
        }
        else if(raiz->info > n){
            buscaNo(raiz->esq, n);
        }
        else if(raiz->info < n){
            buscaNo(raiz->dir, n);
        }
    }
}

No* buscaPai(No* no, int num){
    if (no != NULL){
        if (no->info != num){
            if ((NULL != no->dir && no->dir->info == num) || (no->esq != NULL && no->esq->info == num)) {
                return no;
            } else {
                if (num < no->info) {
                    return buscaPai(no->esq, num);
                } else if (num > no->info) {
                    return buscaPai(no->dir, num);
                }
            }
        }
        else if (no->info == num){
            return no;
        }

    }
    return no;
}

int classificaNo(No* no){
    if((no->esq==NULL)&&(no->dir==NULL)){
        return 1;//Se o no é folha
    }
    else if((no->esq!=NULL)&&(no->dir==NULL)){
        return 2;//se o no tem um no a esquerda
    }
    else if((no->esq==NULL)&&(no->dir!=NULL)){
        return 3;//se o no tem um no a direita
    }
    return 4;//se o no tem nos em ambos os lados
}

No* menorSucessor(No* no){
    if (no->esq ==NULL){
        return no;
    }
    else{
        menorSucessor(no->esq);
    }
}

void removeNoArvore(Arvore* a, int n){
    removeNo(a->raiz, n);
}


void removeNo(No* no, int n){
    if((verificaN(no, n))!=1){
        No* noaux=buscaNo(no, n);
        No* paiaux=buscaPai(no, n);
        int x=classificaNo(noaux);
        if(x==1){
            if(paiaux->dir!=NULL){
                if((paiaux->dir->info)==n){
                    desalocarNo(noaux);
                    paiaux->dir=NULL;
                }
            }
            else if(paiaux->esq!=NULL){
                if(paiaux->esq->info==n){
                    desalocarNo(noaux);
                    paiaux->esq=NULL;
                }
            }
        }
        else if(x==2){
            if(paiaux->dir!=NULL){
                if(paiaux->dir->info==n){
                    paiaux->dir=noaux->esq;
                    noaux->esq=NULL;
                    desalocarNo(noaux);
                }
            }
            else if(paiaux->esq!=NULL){
                    if(paiaux->esq->info==n){
                    paiaux->esq=noaux->esq;
                    noaux->esq=NULL;
                    desalocarNo(noaux);
                }
            }
        }
        else if(x==3){
            if(paiaux->dir!=NULL){
                if(paiaux->dir->info==n){
                    paiaux->dir=noaux->dir;
                    noaux->dir=NULL;
                    desalocarNo(noaux);
                }
            }
            else if(paiaux->esq!=NULL){
                if(paiaux->esq->info==n){
                    paiaux->esq=noaux->dir;
                    noaux->dir=NULL;
                    desalocarNo(noaux);
                }
            }
        }
        else if(x==4){
            No* sucessor=menorSucessor(noaux->dir);
            No* paisucessor=buscaPai(no, sucessor->info);
            if((classificaNo(sucessor))==1){
                noaux->info=sucessor->info;
                desalocarNo(sucessor);
                if(paisucessor!=noaux){
                    paisucessor->esq=NULL;
                }
                else{
                    paisucessor->dir=NULL;
                }
            }
            else if((classificaNo(sucessor))==3){
                noaux->info=sucessor->info;
                paisucessor->esq=sucessor->dir;
                sucessor->dir=NULL;
                desalocarNo(sucessor);
            }
        }
    }
}


/*
int removeNo(No* no, int n){
    if(no == NULL){
        printf("Valor nao existe\n");
        return 0;
    }
    int res;
    if(n < no->info){
        if((res=removeNo(no->esq, n))==1){
            if(contaAVL(&no)>=2){
                if(no->dir->esq->h <= no->dir->dir->h){
                    rotacaoSimplesEsq(&no);
                }
                else{
                    rotacaoDuplaEsq(&no);
                }
            }
        }
    }
    if(n> no->info){
        if((res=removeNo((no->dir), n))==1){
            if(contaAVL(&no)<=-2){
                if(no->esq->dir->h <= no->esq->esq->h){
                    rotacaoSimplesDir(&no);
                }
                else{
                    rotacaoDuplaDir(&no);
                }
            }
        }
    }
    if(n == no->info){
        if((no->esq==NULL)||(no->dir==NULL)){
            No* aux=no;
            if(no->esq != NULL){
                no=no->esq;
            }
            else{
                no=no->dir;
            }
            desalocarNo(aux);
        }
        else{
            No* menor=menorSucessor(no->dir);
            no->info = menor->info;
            removeNo((no->dir), no->info);
            if(contaAVL(&no)<= -2){
                if(no->esq->dir->h <= no->esq->esq->h){
                    rotacaoSimplesDir(&no);
                }
                else{
                    rotacaoDuplaDir(&no);
                }
            }
        }
        return 1;
    }
    return res;
}
*/
void rotacaoSimplesDir (No ** no){
    No *aux = (*no)->dir->esq;
    (*no)->dir->esq = (*no);
    (*no)= (*no)->dir;
    (*no)->esq->dir = aux;
    mudaH(*no);
}

void rotacaoSimplesEsq (No ** no){
    No *aux = (*no)->esq->dir;
    (*no)->esq->dir = (*no);
    (*no)= (*no)->esq;
    (*no)->dir->esq = aux;
    mudaH(*no);
}

void rotacaoDuplaEsq (No ** no){
    rotacaoSimplesDir(&((*no)->esq));
    rotacaoSimplesEsq(&(*no));
}

void rotacaoDuplaDir (No ** no){
    rotacaoSimplesEsq(&(*no)->dir);
    rotacaoSimplesDir(&(*no));
}

int contaAVL ( No ** no){

    if (((*no)->dir) != NULL && (*no)->esq != NULL){
        return (*no)->dir->h - (*no)->esq->h;
    }

    else if (((*no)->dir) == NULL && (*no)->esq == NULL){
        return 0;
    }

    else if (((*no)->dir) == NULL || (*no)->esq == NULL){

        if (((*no)->dir) == NULL){
            return (0-1) - (*no)->esq->h;
        }

        if (((*no)->esq) == NULL){
            return (*no)->dir->h + 1;
        }
    }
}

void checkAVL (No ** no){

    int b = contaAVL(&(*no));

    if(b >= 2){
        int b2 = contaAVL(&(*no)->dir);

        if (b2 >= 0){
            rotacaoSimplesDir(&(*no));
        }
        else {
            rotacaoDuplaDir(&(*no));
        }
    }
    else if (b <= -2){
        int b2 = contaAVL(&(*no)->esq);
        if (b2 <= 0){
            rotacaoSimplesEsq(&(*no));
        }
        else {
            rotacaoDuplaEsq(&(*no));
        }
    }
    mudaH(*no);
}
/*
void checkAVL(No** raiz){
    int b=0;
    if((*raiz)->dir!=NULL && (*raiz)->esq!=NULL){
        b=  ((*raiz)->dir->h) - ((*raiz)->esq->h);
    }
    else if((*raiz)->dir==NULL && (*raiz)->esq!=NULL){
        b= -(((*raiz)->esq->h)+1);
    }
    else if((*raiz)->dir!=NULL && (*raiz)->esq==NULL){
        b= ((*raiz)->dir->h)+1;
    }
    if (b>=2){
        int b2=0;
        if((*raiz)->dir->dir!=NULL&&(*raiz)->dir->esq!=NULL){
            b2=((*raiz)->dir->dir->h) - ((*raiz)->dir->esq->h);
        }
        else if((*raiz)->dir->dir==NULL&&(*raiz)->dir->esq!=NULL){
            b2=-(((*raiz)->dir->esq->h)+1);
        }
        else if((*raiz)->dir->dir!=NULL&&(*raiz)->dir->esq==NULL){
            b2=((*raiz)->dir->dir->h)+1;
        }
        if(b2>=0){
            rotacaoSimplesDir(raiz);
        }
        else{
            rotacaoDuplaDir(raiz);
        }
    }
    if(b<=-2){
        int b2=0;
        if((*raiz)->esq->dir!=NULL&&(*raiz)->esq->esq!=NULL){
            b2=((*raiz)->esq->dir->h)- ((*raiz)->esq->esq->h);
        }
        else if(((*raiz)->esq->dir==NULL&&(*raiz)->esq->esq!=NULL)){
            b2=-(((*raiz)->esq->esq->h)+1);
        }
        else if((*raiz)->esq->dir!=NULL&&(*raiz)->esq->esq==NULL){
            b2=((*raiz)->esq->dir->h)+1;
        }
        if(b2<=0){
            rotacaoSimplesEsq(raiz);
        }
        else{
            rotacaoDuplaEsq(raiz);
        }
    }
}
*/

void mudaH(No* raiz){
    if((raiz->dir==NULL) && (raiz->esq==NULL)){
        raiz->h=0;
    }
    else if((raiz->dir!=NULL) && (raiz->esq==NULL)){
        mudaH(raiz->dir);
        raiz->h=raiz->dir->h +1;
    }
    else if((raiz->dir==NULL) && (raiz->esq!=NULL)){
        mudaH(raiz->esq);
        raiz->h=raiz->esq->h +1;
    }
    else if((raiz->dir!=NULL) && (raiz->esq!=NULL)){
        mudaH(raiz->dir);
        mudaH(raiz->esq);
        if((raiz->dir->h) == (raiz->esq->h)){
            raiz->h=raiz->dir->h+1;
        }
        else if((raiz->dir->h) > (raiz->esq->h)){
            raiz->h=raiz->dir->h+1;
        }
        else if((raiz->dir->h) < (raiz->esq->h)){
            raiz->h=raiz->esq->h+1;
        }
    }
}

void menu(){
    int x=1;
    Arvore* a=alocaArvore();
    while(x!=0){
        printf("Para inserir digite 1\nPara excluir digite 2\nPara imprimir a arvore digite 3\nPara sair digite 0\n");
        scanf("%d", &x);
        int n;
        if(x==1){
            printf("Insira o valor a ser inserido:\n");
            scanf("%d", &n);
            construirArvore(a, n);
            printH(a->raiz);
        }
        else if(x==2){
            printf("Insira o valor a ser removido:\n");
            scanf("%d", &n);
            removeNoArvore(a, n);
        }
        else if(x==3){
            imprimirArvore(a);
        }
    }
    desalocaArvore(a);
}

int main(){
    menu();
    return 0;
}
