#include <stdio.h>
#include <stdlib.h>
#include "Arvore.h"
#include "No.h"


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

void rotacaoSimplesDir(No** raiz){
    No* aux=(*raiz)->esq->dir;
    (*raiz)->esq->dir=*raiz;
    (*raiz)=(*raiz)->esq;
    (*raiz)->dir->esq=aux;
}

void rotacaoSimplesEsq(No** raiz){
    No* aux=(*raiz)->dir->esq;
    (*raiz)->dir->esq=*raiz;
    (*raiz)=(*raiz)->dir;
    (*raiz)->esq->dir=aux;
}

void rotacaoDuplaEsq(No** raiz){
    rotacaoSimplesDir((*raiz)->dir);
    rotacaoSimplesEsq(raiz);
}

void rotacaoDuplaDir(No** raiz){
    rotacaoSimplesEsq((*raiz)->esq);
    rotacaoSimplesDir(raiz);
}

void checkAVL(No** raiz){
    int b= (*raiz)->dir->h - (*raiz)->esq->h;
    if (b>=2){
        int b2=(*raiz)->dir->dir->h - (*raiz)->dir->esq->h;
        if(b2>=0){
            rotacaoSimplesEsq(raiz);
            mudaH((*raiz)->esq);
        }
        else{
            rotacaoDuplaEsq(raiz);
        }
    }
    if(b<=-2){
        int b2=(*raiz)->esq->esq->h - (*raiz)->esq->dir->h;
        if(b2<=0){
            rotacaoSimplesDir(raiz);
            mudaH((*raiz)->dir);
        }
        else{
            rotacaoDuplaDir(raiz);
        }
    }
}

void mudaH(No* raiz){
    if((raiz->dir!=NULL) && (raiz->esq==NULL)){
        raiz->h=raiz->dir->h +1;
    }
    if((raiz->dir==NULL) && (raiz->esq!=NULL)){
        raiz->h=raiz->esq->h +1;
    }

    else if((*raiz)->dir->h){

    }
}


int main(){
    Arvore* a=alocaArvore();
    int n;
    for(int cont=0; cont<9; cont++){
        scanf("%d", &n);
        construirArvore(a, n);
    }
    imprimirArvore(a);
    scanf("%d", &n);
    removeNoArvore(a, n);
    imprimirArvore(a);
    desalocaArvore(a);
    return 0;
}
