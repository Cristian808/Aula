#ifndef ARVORE_H_INCLUDED
#define ARVORE_H_INCLUDED
#include "No.h"

struct arvore{
    No* raiz;
};

typedef struct arvore Arvore;

Arvore* alocaArvore();
void desalocaArvore(Arvore* a);
void construirArvore(Arvore* a, int n);
void imprimirArvore(Arvore* a);
void colocarNosArvore(No** no, int n);
int verificaN(No* raiz, int n);
void imprimirSubArvore(No* n);
void lerString(No* no, char c[], int *cont, int t);
void lerStringArvore(Arvore* a, char[]);
void rotacaoDuplaDir(No** raiz);
void rotacaoDuplaEsq(No** raiz);
void rotacaoSimplesDir(No** raiz);
void rotacaoSimplesEsq(No** raiz);
void menu();
void checkAVL(No** raiz);
void mudaH(No* raiz);
void removeNo(No* no, int n);

#endif // ARVORE_H_INCLUDED
